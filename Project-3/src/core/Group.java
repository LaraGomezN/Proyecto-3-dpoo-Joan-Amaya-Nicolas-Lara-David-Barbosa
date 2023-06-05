package core;

import java.util.*;

public class Group {
    private static final ArrayList<Long> ids = new ArrayList<>();
    private final long _id;
    private final Guest _leader;
    private final HashMap<Long, Guest> _members;
    private final HashMap<Long, Room> _rooms;
    private final HashMap<Integer, Room> _rooms1;
    private long _unAssignedGuests;
    private int _guideTimes;
    private double _spend;
    public Group(Guest leader, ArrayList<Guest> guests){
        long id = (long) (Math.random() * 1_000_000_000);
        while (Group.ids.contains(id)) {
            id = (long) (Math.random() * 1_000_000_000);
        }
        Group.ids.add(id);
        _id = id;
        _members = new HashMap<>();
        _members.put(leader.identificationCard(), leader);
        _leader = leader;
        for (Guest guest: guests){
            _members.put(guest.identificationCard(), guest);
        }
        _rooms = new HashMap<>();
        _rooms1 = new HashMap<>();
        _unAssignedGuests = _members.size();
        _guideTimes = 0;
        _spend = 0;
    }
    public Group(long id, Guest leader, ArrayList<Guest> guests){
        _id = id;
        Group.ids.add(_id);
        _members = new HashMap<>();
        _members.put(leader.identificationCard(), leader);
        _leader = leader;
        _rooms1 = new HashMap<>();
        for (Guest guest: guests){
            _members.put(guest.identificationCard(), guest);
        }
        _rooms = new HashMap<>();
        _unAssignedGuests = _members.size();
        _guideTimes = 0;
        _spend = 0;
    }
    public long id(){
        return _id;
    }
    public long unAssignedGuests(){
        return _unAssignedGuests;
    }
    public void assignGuest(Room room, long identificationCard){
        _unAssignedGuests --;
        _rooms.put(room.id(), room);
        room.addOccupant(_members.get(identificationCard));
    }
    public HashMap<Long, Guest> members(){
        return _members;
    }
    public HashMap<Long, Room> rooms(){
        return _rooms;
       
    }
    
    public HashMap<Integer, Room> rooms1(){
        return _rooms1;
       
    }
    public void addrooms(Room room,int valor)
    {
         _rooms1.put(valor , room);
    }
    public double spend(){
        return _spend;
    }
    public void addSpend(TourGuide tourGuide){
        _guideTimes ++;
        _spend += tourGuide.price();
    }

    public String bill(){
        if (_spend > 0){
            return "Tour Guide : " + _spend + "times: " + _guideTimes +
                    "\nNET PRICE: " + _spend;
        }
        return "";
    }

    @Override
    public String toString(){
        return "leader: " + _leader.name() + ", members: " + Arrays.toString(_members.values().toArray());
    }
    public int guideTimes(){         return _guideTimes;     }
}
