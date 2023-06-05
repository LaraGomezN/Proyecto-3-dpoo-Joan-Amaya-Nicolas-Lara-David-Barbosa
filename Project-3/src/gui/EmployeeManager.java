package gui;
import core.Drink;
import core.Group;
import core.Guest;
import core.Plate;
import core.Restaurant;
import core.Spa;
import core.TourGuide;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import utils.TimeRange;
public class EmployeeManager extends JPanel implements ActionListener , MouseMotionListener{
    private  GUI _gui;
    private  JLabel servicesLabel;
    private  JLabel servicesLabel1=new JLabel("Please inform the admin in order to create dishes,drink,spa or guide.");
    private  JLabel roomsLabel;
    private  JButton restaurantUse = new JButton("1. Plate order");
    private  JButton drinkUse = new JButton("2. Drink order");
    private  JButton spaUse = new JButton("3. Spa use");
    private  JButton guideUse = new JButton("4. Guide use");
    private  JButton RestaurantMenu = new JButton("5. Check menu ");
    private  JButton consultGroup = new JButton("Check spending");

    private  JButton  Logout = new JButton("Logout");
    private  JButton  Help = new JButton("Help");

    public void update(){
        if (_gui.directory().restaurant()==null||_gui.directory().spa()==null||_gui.directory().tourGuide()==null)
        {

            setLayout(null);
            setBounds(50, 250 , 900, 700);
            servicesLabel1.setFont(new Font(servicesLabel1.getFont().getName(), Font.BOLD, 24));
            servicesLabel1.setBounds(0, 150, 1000, 70);
            add(servicesLabel1);
            setLayout(null);
            setBounds(0, 250 , 900, 700);
            Logout.setBounds(0, 380, 450, 31);
            Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            Logout.addActionListener(this);
            add(Logout);
        }
        else
        {



            //Codigo temporal
            ArrayList<Guest> lista1 = new ArrayList<>();
            Guest newguest1= new Guest("juan",19,1090909,"juan@gmail.com");
            Guest newguest2= new Guest("miguel",20,1090901,"miguel@gmail.com");
            Guest newguest3= new Guest("luis",21,1090902,"luis@gmail.com");
            lista1.add(newguest1);
            lista1.add(newguest2);
            lista1.add(newguest3);
            Group grupo1 = new Group(newguest1,lista1);

            ArrayList<Guest> lista2 = new ArrayList<>();
            Guest newguest12= new Guest("epifanio",19,10909091,"epifanio@gmail.com");
            Guest newguest22= new Guest("akali",20,10909012,"akali@gmail.com");
            Guest newguest32= new Guest("alfredo",21,10909023,"alfredo@gmail.com");
            lista2.add(newguest12);
            lista2.add(newguest22);
            lista2.add(newguest32);
            Group grupo2 = new Group(newguest12,lista2);
            _gui.directory().addGroup(grupo2);
            _gui.directory().addGroup(grupo1);
            //------------
            servicesLabel1.setVisible(false);
            setLayout(null);
            setBounds(0, 250 , 900, 700);



            servicesLabel = new JLabel("Services");
            servicesLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            servicesLabel.setBounds(200, 30, 600, 70);
            add(servicesLabel);

            restaurantUse.setBackground(new Color(0x00ffe3));
            restaurantUse.setBounds(100, 90, 300, 31);
            restaurantUse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            restaurantUse.addActionListener(this);
            add(restaurantUse);

            drinkUse.setBackground(new Color(0x00ffe3));
            drinkUse.setBounds(100, 120, 300, 31);
            drinkUse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            drinkUse.addActionListener(this);
            add(drinkUse);

            spaUse.setBackground(new Color(0x00ffe3));
            spaUse.setBounds(100, 150, 300, 31);
            spaUse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            spaUse.addActionListener(this);
            add(spaUse);

            guideUse.setBackground(new Color(0x00ffe3));
            guideUse.setBounds(100, 180, 300, 31);
            guideUse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            guideUse.addActionListener(this);
            add(guideUse);


            RestaurantMenu.setBackground(new Color(0x00ffe3));
            RestaurantMenu.setBounds(100, 210, 300, 31);
            RestaurantMenu.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            RestaurantMenu.addActionListener(this);
            add(RestaurantMenu);



            roomsLabel = new JLabel("Group");
            roomsLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
            roomsLabel.setBounds(600, 30, 600, 70);
            add(roomsLabel);
            DefaultListModel<String> aa = new DefaultListModel<>();
            //
            HashMap<Long, Group> grupos1 = _gui.directory().groups();
            for(Map.Entry<Long, Group> entry : grupos1.entrySet()) {
                Long key = entry.getKey();
                Group value = entry.getValue();
                HashMap<Long, Guest> miembros=value.members();
                for(Map.Entry<Long, Guest> entry2 : miembros.entrySet()) {
                    Long key2 = entry2.getKey();
                    Guest value2 = entry2.getValue();
                    aa.addElement(value2.name() +" del grupo " + value.id() + " con id: " + value2.identificationCard());


                }

                // do what you have to do here
                // In your case, another loop.
            }



            JList<String> grupos = new JList<String>(aa);
            grupos.setBounds(600, 30, 600, 70);


            JScrollPane scrollpane = new JScrollPane(grupos);
            scrollpane.setBounds(490, 90, 300, 200);
            scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            add(scrollpane);


            consultGroup.setBackground(new Color(0x00ffe3));
            consultGroup.setBounds(490, 300, 300, 31);
            consultGroup.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            consultGroup.addActionListener(this);
            add(consultGroup);


            Logout.setBounds(0, 380, 450, 31);
            Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            Logout.addActionListener(this);
            add(Logout);

            Help.setBounds(450, 380, 450, 31);
            Help.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
            add(Help);
        }
    }
    public EmployeeManager(GUI gui){
        _gui = gui;
    }



    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == consultGroup){
        }
        if (event.getSource() == Logout)
        {
            _gui.change("login");
        }
        if (event.getSource() == RestaurantMenu){

            JFrame f= new JFrame();
            JDialog d = new JDialog(f , "Dialog Restaurant", true);
            d.setLayout(null);
            Restaurant restaurante= _gui.directory().restaurant();
            DefaultListModel<String> aa3 = new DefaultListModel<>();
            HashMap<String, Plate> platos= restaurante.plates();
            for(Map.Entry<String, Plate> entry : platos.entrySet()) {
                String key = entry.getKey();
                Plate value = entry.getValue();
                aa3.addElement(key +" con precio de "+value.price() +" con horario de "+ value.timeRange());
            }
            JList<String> grupos2 = new JList<String>(aa3);
            JScrollPane scrollpane = new JScrollPane(grupos2);
            scrollpane.setBounds(0, 0, 500, 200);
            scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            f.add(scrollpane);
            f.setSize(700,300);
            f.setVisible(true);

        }
        if (event.getSource() == consultGroup){

            JFrame f= new JFrame();
            JDialog d = new JDialog(f , "Dialog Restaurant", true);
            d.setLayout(null);
            Restaurant restaurante= _gui.directory().restaurant();
            DefaultListModel<String> aa = new DefaultListModel<>();
            //
            HashMap<Long, Group> grupos1 = _gui.directory().groups();
            for(Map.Entry<Long, Group> entry : grupos1.entrySet()) {
                Long key = entry.getKey();
                Group value = entry.getValue();
                HashMap<Long, Guest> miembros=value.members();
                for(Map.Entry<Long, Guest> entry2 : miembros.entrySet()) {
                    Long key2 = entry2.getKey();
                    Guest value2 = entry2.getValue();
                    aa.addElement(value2.name() +" del grupo " + value.id() + " con id: " + value2.identificationCard()+" tiene un consumo de "+ value2.bill());


                }

                // do what you have to do here
                // In your case, another loop.
            }



            JList<String> grupos = new JList<String>(aa);
            grupos.setBounds(600, 30, 600, 70);


            JScrollPane scrollpane = new JScrollPane(grupos);

            f.add(scrollpane);
            f.setSize(700,300);
            f.setVisible(true);

        }
        if (event.getSource() == restaurantUse){
            boolean success=false;
            while(!success)
            {
                try {Long idg = Long.valueOf(JOptionPane.showInputDialog(_gui,"Enter the id of the group for wich you are gonna order the dish"));
                    Group gruposel= _gui.directory().groups().get(idg);
                    Long id = Long.valueOf(JOptionPane.showInputDialog(_gui,"Enter the id of the person for wich you are gonna order the dish"));
                    Guest huesped = gruposel.members().get(id);
                    String nombre = JOptionPane.showInputDialog(_gui,"Enter the dish name");

                    Plate platoOrdenado=_gui.directory().restaurant().plates().get(nombre);
                    ArrayList<String> lugares = platoOrdenado.places();
                    boolean sentinel=false;

                    while(!sentinel)
                    {
                        String lugar = JOptionPane.showInputDialog(_gui,"Enter the place where you want to eat");
                        if (lugares.contains(lugar))
                        {
                        	_gui.directory().restaurant().addplacesell(lugar);
                            sentinel=true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(_gui, "This place is not available for your dish", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    boolean sentinel2=false;
                    while(!sentinel2)
                    {
                        String timeR = JOptionPane.showInputDialog(_gui,"Enter the hour EJ: 08:00:00");
                        TimeRange range= platoOrdenado.timeRange();
                        if(range.timeInRange(timeR))
                        {
                        	
                        	_gui.directory().restaurant().addsells(timeR);
                        	_gui.directory().restaurant().addproductsell(nombre);
                            sentinel2=true;
                        }
                        else {
                            JOptionPane.showMessageDialog(_gui, "This hour is not available", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }




                    int respuesta= JOptionPane.showConfirmDialog(_gui, "Enter if you want to pay now", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==JOptionPane.YES_OPTION)
                    {}
                    else if (respuesta==JOptionPane.NO_OPTION){
                        huesped.addDPlate(platoOrdenado);
                    }
                    boolean succes2=false;
                    while(!succes2)
                    {
                        int respuesta2= JOptionPane.showConfirmDialog(_gui, "Enter if you want to continue ordering", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (respuesta2==JOptionPane.YES_OPTION)
                        {
                            String nombre2 = JOptionPane.showInputDialog(_gui,"Enter the dish name");
                            Plate platoOrdenado2=_gui.directory().restaurant().plates().get(nombre2);

                            //
                            ArrayList<String> lugares2 = platoOrdenado2.places();
                            boolean sentinel3=false;

                            while(!sentinel3)
                            {
                                String lugar2 = JOptionPane.showInputDialog(_gui,"Enter the place where you want to eat");
                                if (lugares2.contains(lugar2))
                                {
                                    sentinel3=true;
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(_gui, "This place is not available for your dish", "Error", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            boolean sentinel23=false;
                            while(!sentinel23)
                            {
                                String timeR2 = JOptionPane.showInputDialog(_gui,"Enter the hour EJ: 08:00:00");
                                TimeRange range2= platoOrdenado2.timeRange();
                                if(range2.timeInRange(timeR2))
                                {
                                	_gui.directory().restaurant().addsells(timeR2);
                                	_gui.directory().restaurant().addproductsell(nombre2);
                                    sentinel23=true;
                                }
                                else {
                                    JOptionPane.showMessageDialog(_gui, "This hour is not available", "Error", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            //

                            int respuesta3= JOptionPane.showConfirmDialog(_gui, "Enter if you want to pay now", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(respuesta3==JOptionPane.YES_OPTION)
                            {}
                            else {
                                huesped.addDPlate(platoOrdenado2);
                            }
                        }
                        else {
                            succes2=true;
                        }

                    }


                    JOptionPane.showMessageDialog(_gui, "Than you come here again", "Success", JOptionPane.INFORMATION_MESSAGE);
                    success=true;
                }

                catch(Exception e){
                    JOptionPane.showMessageDialog(_gui, "Enter a valid option", "Error", JOptionPane.WARNING_MESSAGE);

                }
            }





        }
        if (event.getSource() == drinkUse){
            boolean success=false;
            while(!success)
            {
                try {Long idg = Long.valueOf(JOptionPane.showInputDialog(_gui,"Enter the id of the group for wich you are gonna order the drink"));
                    if(idg==null)
                    {
                        return;
                    }
                    Group gruposel= _gui.directory().groups().get(idg);
                    Long id = Long.valueOf(JOptionPane.showInputDialog(_gui,"Enter the id of the person for wich you are gonna order the drink"));
                    if(id==null)
                    {
                        return;
                    }
                    Guest huesped = gruposel.members().get(id);
                    if(huesped==null)
                    {
                        return;
                    }
                    String nombre = JOptionPane.showInputDialog(_gui,"Enter the drink name");
                    if(nombre==null)
                    {
                        return;
                    }
                    Drink platoOrdenado=_gui.directory().restaurant().drinks().get(nombre);
                    ArrayList<String> lugares = platoOrdenado.places();
                    boolean sentinel=false;

                    while(!sentinel)
                    {
                        String lugar = JOptionPane.showInputDialog(_gui,"Enter the place where you want to eat");
                        if(lugar==null)
                        {
                            return;
                        }
                        if (lugares.contains(lugar))
                        {
                            sentinel=true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(_gui, "This place is not available for your dish", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    boolean sentinel2=false;
                    while(!sentinel2)
                    {
                        String timeR = JOptionPane.showInputDialog(_gui,"Enter the hour EJ: 08:00:00");
                        
                        if(timeR==null)
                        {
                            return;
                        }
                        TimeRange range= platoOrdenado.timeRange();
                        if(range.timeInRange(timeR))
                        {
                        	_gui.directory().restaurant().addsells(timeR);
                        	_gui.directory().restaurant().addproductsell(nombre);
                            sentinel2=true;
                        }
                        else {
                            JOptionPane.showMessageDialog(_gui, "This hour is not available", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    int respuesta= JOptionPane.showConfirmDialog(_gui, "Enter if you want to pay now", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if(respuesta==JOptionPane.YES_OPTION)
                    {}
                    else {
                        huesped.addDrink(platoOrdenado);
                    }
                    boolean succes2=false;
                    while(!succes2)
                    {
                        int respuesta2= JOptionPane.showConfirmDialog(_gui, "Enter if you want to continue ordering", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (respuesta2==JOptionPane.YES_OPTION)
                        {
                            String nombre2 = JOptionPane.showInputDialog(_gui,"Enter the drink name");
                            if(nombre2==null)
                            {
                                return;
                            }

                            Drink platoOrdenado2=_gui.directory().restaurant().drinks().get(nombre2);
                            int respuesta3= JOptionPane.showConfirmDialog(_gui, "Enter if you want to pay now", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if(respuesta3==JOptionPane.YES_OPTION)
                            {}
                            else {
                                huesped.addDrink(platoOrdenado2);
                            }
                        }
                        else {
                            succes2=true;
                        }

                    }


                    JOptionPane.showMessageDialog(_gui, "Than you come here again", "Success", JOptionPane.INFORMATION_MESSAGE);
                    success=true;
                }

                catch(Exception e){
                    JOptionPane.showMessageDialog(_gui, "Enter a valid option", "Error", JOptionPane.WARNING_MESSAGE);

                }
            }





        }
        if (event.getSource() == spaUse){

            String number = JOptionPane.showInputDialog(_gui,"Enter guest's group ID: ");
            if(number==null)
            {
                return;
            }
            String number2 = JOptionPane.showInputDialog(_gui,"Enter guest's Identification Number: ");
            if(number2==null)
            {
                return;
            }
            long groupId = Long.parseLong(number);
            long guestId = Long.parseLong(number2);
            HashMap<Long, Group> groups = _gui.directory().groups();
            Group guestGroup =groups.get(groupId);
            HashMap<Long, Guest> members = guestGroup.members();
            Guest guest = members.get(guestId);

            String guestTime = JOptionPane.showInputDialog(_gui,"Enter admission time EJ: 10:00:00");
            if(guestTime==null)
            {
                return;
            }
            Spa spaf = _gui.directory().spa();
            TimeRange range = spaf.timeRange();

            boolean inRange = range.timeInRange(guestTime);

            if (inRange == false)
                JOptionPane.showMessageDialog(_gui, "Guest's time is out of Spa's range", "Error", JOptionPane.WARNING_MESSAGE);
            else {
                JOptionPane.showMessageDialog(_gui, "Spa usage registered", "Registered", JOptionPane.INFORMATION_MESSAGE);
                guest.addSpaUsage();
            }
        }
        if (event.getSource() == guideUse){

            String number = JOptionPane.showInputDialog(_gui,"Enter guest's group ID: ");
            long groupId = Long.parseLong(number);
            HashMap<Long, Group> groups = _gui.directory().groups();
            Group guestGroup =groups.get(groupId);

            String guideTime = JOptionPane.showInputDialog(_gui,"Enter tour guide register time EJ: 10:00:00");
            TourGuide guide = _gui.directory().tourGuide();
            TimeRange range = guide.timeRange();

            boolean inRange = range.timeInRange(guideTime);

            if (inRange == false)
                JOptionPane.showMessageDialog(_gui, "Group's time is out of tourguide's range", "Error", JOptionPane.WARNING_MESSAGE);
            else {
                JOptionPane.showMessageDialog(_gui, "Spa usage registered", "Registered", JOptionPane.INFORMATION_MESSAGE);
                guestGroup.addSpend(guide);
            }

        }



    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }
}