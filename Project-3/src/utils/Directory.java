package utils;

import core.*;
import payments.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public final class Directory extends Utils {
    public Directory(String path){
        //Accounts
        _administrators = new HashMap<>();
        _receptionists = new HashMap<>();
        _employees = new HashMap<>();
        loadAccounts(path);
        //Services
        _hotel = new Hotel();
        _groups = new HashMap<>();
        paymentMethods = new HashMap<>();
    }
    //Accounts
    public final HashMap<String, String> _administrators;
    public final HashMap<String, String> _receptionists;
    public final HashMap<String, String> _employees;
    private void loadAccounts(String path) {
        BufferedReader reader = read(path);
        assert reader != null;
        for (Iterator<String> lines = reader.lines().iterator(); lines.hasNext();){
            String[] line = lines.next().split(",");
            switch (line[2]){
                case "admin" -> _administrators.put(line[0], line[1]);
                case "receptionist" -> _receptionists.put(line[0], line[1]);
                case "employee" -> _employees.put(line[0], line[1]);
            }
        }
        try{ reader.close(); } catch (IOException error) { error.printStackTrace(); }
    }
    public boolean isAdministrator(String user, String passwd){
        return Objects.equals(_administrators.getOrDefault(user, null), passwd);
    }
    public boolean isReceptionist(String user, String passwd){
        return Objects.equals(_receptionists.getOrDefault(user, null), passwd);
    }
    public boolean isEmployee(String user, String passwd){
        return Objects.equals(_employees.getOrDefault(user, null), passwd);
    }

    //Services
    private final Restaurant _restaurant=new Restaurant(new TimeRange("10:00:00-14:00:00"));
    private Spa _spa;
    private TourGuide _tourGuide;
    private final Hotel _hotel;
    private final HashMap<Long, Group> _groups;
    public Restaurant restaurant(){
        return _restaurant;
    }
    public Spa spa(){
        return _spa;
    }
    public TourGuide tourGuide(){
        return _tourGuide;
    }
    public Hotel hotel() {
        return _hotel;
    }
    public HashMap<Long, Group> groups(){
        return _groups;
    }
    public void addGroup(Group group){
        _groups.put(group.id(), group);
    }
    public void spa(Spa spa){
        _spa = spa;
    }
    public void tourGuide(TourGuide tourGuide){
        _tourGuide = tourGuide;
    }
    public void loadGroups(){
        File file = new File("src/record/groups.txt");
        if (file.exists()){
            BufferedReader reader = read(file);
            assert reader != null;
            for (Object line: reader.lines().toArray()){
                String[] info =((String) (line)).split(";");
                long id = Long.parseLong(info[0]);
                int times = Integer.parseInt(info[1]);
                String[] leaderInfo = info[2].split(",");
                Guest leader = new Guest(
                        leaderInfo[0],
                        Integer.parseInt(leaderInfo[1]),
                        Long.parseLong(leaderInfo[2]),
                        leaderInfo[3]
                );
                ArrayList<Guest> members = new ArrayList<>();
                for (int index = 3; index < info.length; index ++) {
                    String[] memberInfo = info[index].split(",");
                    members.add(
                            new Guest(
                                    memberInfo[0],
                                    Integer.parseInt(memberInfo[1]),
                                    Long.parseLong(memberInfo[2]),
                                    memberInfo[3]
                            )
                    );
                }
                Group group = new Group(id, leader, members);
                for (int time = 0; time < times; time++)
                    group.addSpend(_tourGuide);
                _groups.put(group.id(), group);
            }
            try { reader.close(); } catch (IOException ignored) {}
        }
    }

    public void saveGroups(){
        File file = new File("src/record/groups.txt");
        try {
            if (!file.exists()) file.createNewFile();
            BufferedWriter writer = write(file);
            assert writer != null;
            for (Group group : _groups.values()) {
                String prompt = group.id() + ";" + group.guideTimes();
                for (Guest guest : guests().values()) {
                    prompt = prompt.concat(";" + guest.name() + "," + guest.age() + "," + guest.identificationCard() + "," + guest.mail());
                }
                writer.append(prompt);
                writer.newLine();
            }
            writer.close();
        } catch (IOException ignored) {}
    }

    private HashMap<Long, Guest> guests(){
        HashMap<Long, Guest> guests = new HashMap<>();
        for (Group group : _groups.values()) {
            for (Guest guest : group.members().values()){
                guests.put(guest.identificationCard(), guest);
            }
        }
        return guests;
    }
    /**
     * id;id_card,...;date,...
     */
    public void saveOccupiedRooms(){
        File file = new File("src/record/rooms.txt");
        try {
            if (!file.exists()) file.createNewFile();
            BufferedWriter writer = write(file);
            assert writer != null;
            for (Room room : hotel().rooms().values()){
                String prompt = String.valueOf(room.id());
                if (room.occupants().size() > 0)
                {
                    for (Guest guest : room.occupants())
                        prompt = prompt.concat(";" + guest.identificationCard());
                    prompt = prompt.concat(concat(room.occupancyRanges()));
                    writer.append(prompt);
                    writer.newLine();
                }
            }
            writer.close();
            
        } catch (IOException ignored) {}
    }
    private String concat(ArrayList<DateRange> dateRanges){
        String str = "";
        System.out.println(Arrays.toString(dateRanges.toArray()));
        for (DateRange dateRange : dateRanges){
            str = str.concat("," + dateRange.toStringRepr());
        }
        return str;
    }

    private HashMap<String, PaymentMethod> paymentMethods;

    public void loadPaymentMethods(File file){
        try{
            BufferedReader reader = read(file);
            assert reader != null;
            for (Object line: reader.lines().toArray()){
                String[] info = ((String) line).split(";");
                String className = info[0];
                switch (className){
                    case "Itau" -> {
                        HashMap<Long, BankCard> itauCards = new HashMap<>();
                        for (int index = 1; index < info.length; index ++){
                            String[] cardInfo = info[index].split(",");
                            long number = Long.parseLong(cardInfo[0]);
                            short password = Short.parseShort(cardInfo[1]);
                            itauCards.put(number, new ItauCard(number, password));
                        }
                        paymentMethods.put("Itau", new Itau(itauCards));
                    }
                    case "Nequi" -> {
                        HashMap<Long, BankCard> nequiCards = new HashMap<>();
                        for (int index = 1; index < info.length; index ++){
                            String[] cardInfo = info[index].split(",");
                            long number = Long.parseLong(cardInfo[0]);
                            short password = Short.parseShort(cardInfo[1]);
                            nequiCards.put(number, new NequiCard(number, password));
                        }
                        paymentMethods.put("Nequi", new Nequi(nequiCards));
                    }
                }
            }
            reader.close();
        } catch (IOException ignored) {}
    }

    public HashMap<String, PaymentMethod> paymentMethods(){
        return paymentMethods;
    }
}
