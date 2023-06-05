package gui;


import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import core.Drink;
import core.Group;
import core.Guest;
import core.Plate;
import core.Restaurant;
import core.Room;
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

import utils.DateRange;
import utils.TimeRange;
public class AdminManager extends JPanel implements ActionListener , MouseMotionListener {
    private final GUI _gui;
    private final JLabel servicesLabel;
    private final JLabel roomsLabel;
    private final JButton loadDishes_1 = new JButton("1.Load Dishes with file*");
    private final JButton loadDrinks = new JButton("2.Load Drinks with file*");
    private final JButton  createDish = new JButton("3. Create Dish (not is necesary)");
    private final JButton  createDrink = new JButton("4. Create Drink (not is necesary)");
    private final JButton  createSpa = new JButton("5. Create Spa*");
    private final JButton  createGuide = new JButton("6. Create Guide*");
    private final JButton  changeSchedules = new JButton("7. Change Schedules");
    private final JButton  changeRates = new JButton("8. Change Rates for dishes");
    private final JButton  changeRates2 = new JButton("9. Change Rates for drinks");
    private final JButton loadRooms = new JButton("1.Load Rooms");
    private final JButton changeRates_r = new JButton("2. Change Rates");
    private final JButton  loadSchedulesRates = new JButton("3. Load Schedules for room rates");
    private final JButton  Logout = new JButton("Logout");
    private final JButton  Help = new JButton("Help");
    private final JLabel reports= new JLabel("Graphics reports");
    private final JButton graphics = new JButton("See 1.total sells vs day hour");
    private final JButton graphics2 = new JButton("See 2. total sells per product");
    private final JButton graphics3 = new JButton("See 3. Total used places");
    private final JButton graphics4 = new JButton("See 4. Bills vs time");
    private JFrame frame= new JFrame();
    private JFrame frame2= new JFrame();
    private JFrame frame3= new JFrame();

    public AdminManager(GUI gui){
        _gui = gui;






        setLayout(null);
        setBounds(0, 250 , 900, 700);


        servicesLabel = new JLabel("Services");
        servicesLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        servicesLabel.setBounds(200, 30, 600, 70);
        add(servicesLabel);

        loadDishes_1.setBackground(new Color(0x00ffe3));
        loadDishes_1.setBounds(100, 90, 300, 31);
        loadDishes_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        loadDishes_1.addActionListener(this);
        add(loadDishes_1);

        loadDrinks.setBackground(new Color(0x00ffe3));
        loadDrinks.setBounds(100, 120, 300, 31);
        loadDrinks.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        loadDrinks.addActionListener(this);
        add(loadDrinks);

        createDish.setBackground(new Color(0x00ffe3));
        createDish.setBounds(100, 150, 300, 31);
        createDish.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        createDish.addActionListener(this);
        add(createDish);

        createDrink.setBackground(new Color(0x00ffe3));
        createDrink.setBounds(100, 180, 300, 31);
        createDrink.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        createDrink.addActionListener(this);
        add(createDrink);

        createSpa.setBackground(new Color(0x00ffe3));
        createSpa.setBounds(100, 210, 300, 31);
        createSpa.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        createSpa.addActionListener(this);
        add(createSpa);

        createGuide.setBackground(new Color(0x00ffe3));
        createGuide.setBounds(100, 240, 300, 31);
        createGuide.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        createGuide.addActionListener(this);
        add(createGuide);

        changeSchedules.setBackground(new Color(0x00ffe3));
        changeSchedules.setBounds(100, 270, 300, 31);
        changeSchedules.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        changeSchedules.addActionListener(this);
        add(changeSchedules);

        changeRates.setBackground(new Color(0x00ffe3));
        changeRates.setBounds(100, 300, 300, 31);
        changeRates.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        changeRates.addActionListener(this);
        add(changeRates);
        changeRates2.setBackground(new Color(0x00ffe3));
        changeRates2.setBounds(100, 330, 300, 31);
        changeRates2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        changeRates2.addActionListener(this);
        add(changeRates2);


        roomsLabel = new JLabel("Rooms");
        roomsLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        roomsLabel.setBounds(600, 30, 600, 70);
        add(roomsLabel);

        loadRooms.setBackground(new Color(0x00ffe3));
        loadRooms.setBounds(490, 90, 300, 31);
        loadRooms.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        loadRooms.addActionListener(this);
        add(loadRooms);

        changeRates_r.setBackground(new Color(0x00ffe3));
        changeRates_r.setBounds(490, 120, 300, 31);
        changeRates_r.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        changeRates_r.addActionListener(this);
        add(changeRates_r);

        loadSchedulesRates.setBackground(new Color(0x00ffe3));
        loadSchedulesRates.setBounds(490, 150, 300, 31);
        loadSchedulesRates.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        loadSchedulesRates.addActionListener(this);
        add(loadSchedulesRates);
        
        
        reports.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        reports.setBounds(550, 170, 600, 70);
        add(reports);
       
        graphics.setBackground(new Color(0x00ffe3));
        graphics.setBounds(490, 230, 300, 21);
        graphics.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        graphics.addActionListener(this);
        add(graphics);
        
        graphics2.setBackground(new Color(0x00ffe3));
        graphics2.setBounds(490, 250, 300, 21);
        graphics2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        graphics2.addActionListener(this);
        add(graphics2);
        
        graphics3.setBackground(new Color(0x00ffe3));
        graphics3.setBounds(490, 270, 300, 21);
        graphics3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        graphics3.addActionListener(this);
        add(graphics3);
        
        graphics4.setBackground(new Color(0x00ffe3));
        graphics4.setBounds(490, 290, 300, 21);
        graphics4.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        graphics4.addActionListener(this);
        add(graphics4);
        
        

        Logout.setBounds(0, 380, 450, 31);
        Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        Logout.addActionListener(this);
        add(Logout);

        Help.setBounds(450, 380, 450, 31);
        Help.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        add(Help);





    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == loadDishes_1){
            File dishes = new File("src/sources/platos.txt");
            JOptionPane.showMessageDialog(_gui, "Loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);

            try {
                _gui.directory().restaurant().loadPlates(dishes);
                loadDishes_1.setEnabled(false);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (event.getSource() == loadDrinks){
            File dishes = new File("src/sources/bebidas.txt");
            JOptionPane.showMessageDialog(_gui, "Loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
            try {
                _gui.directory().restaurant().loadDrinks(dishes);
                loadDrinks.setEnabled(false);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        if (event.getSource() == Logout)
        {
            _gui.change("login");
        }
        if (event.getSource() == createDish)
        {
            String name = JOptionPane.showInputDialog(_gui,"Nombre del plato");
            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"Precio del plato"));
            ArrayList<String> lugares=new ArrayList<>(List.of(JOptionPane.showInputDialog(_gui,"Nombre de los lugares separados por ,").split(",")));
            String time = JOptionPane.showInputDialog(_gui,"Horario del plato EJ: 08:00:00-20:00:00");
            TimeRange intervalo= new TimeRange(time);
            JOptionPane.showMessageDialog(_gui, "Dish loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
            _gui.directory().restaurant().addPlates(name, price, lugares, intervalo);


        }
        if (event.getSource() == createDrink)
        {
            String name = JOptionPane.showInputDialog(_gui,"Nombre de la bebida");
            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"Precio de la bebida"));
            ArrayList<String> lugares=new ArrayList<>(List.of(JOptionPane.showInputDialog(_gui,"Nombre de los lugares separados por ,").split(",")));
            String time = JOptionPane.showInputDialog(_gui,"Horario de la bebida EJ: 08:00:00-20:00:00");
            TimeRange intervalo= new TimeRange(time);
            JOptionPane.showMessageDialog(_gui, "Drink loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
            _gui.directory().restaurant().addDrinks(name, price, lugares, intervalo);


        }
        if (event.getSource() == createSpa)
        {

            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"Precio del spa "));
            String time = JOptionPane.showInputDialog(_gui,"Horario del spa EJ: 08:00:00-20:00:00");
            TimeRange intervalo= new TimeRange(time);
            Spa spat=new Spa(price, intervalo);
            JOptionPane.showMessageDialog(_gui, "Spa loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
            _gui.directory().spa(spat);
            createSpa.setEnabled(false);


        }
        if (event.getSource() == createGuide)
        {

            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"Precio del guía "));
            String time = JOptionPane.showInputDialog(_gui,"Horario del guía EJ: 08:00:00-20:00:00");
            TimeRange intervalo= new TimeRange(time);
            TourGuide guidet=new TourGuide(price, intervalo);
            JOptionPane.showMessageDialog(_gui, "Guide loaded succesfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
            _gui.directory().tourGuide(guidet);
            createGuide.setEnabled(false);

        }
        if (event.getSource() == loadRooms){
            try {
                here:
                _gui.directory().hotel().loadRooms(new File("src/sources/newrooms.txt"));
                JOptionPane.showMessageDialog(_gui, "Rooms loaded successfully", "Loaded", JOptionPane.INFORMATION_MESSAGE);
                loadRooms.setEnabled(false);
            }
            catch (IOException exception){
                JOptionPane.showMessageDialog(_gui, "Fatal crash trying load rooms", "Loaded", JOptionPane.ERROR_MESSAGE);
                exception.printStackTrace();
            }
        }
        if (event.getSource() == changeRates_r){
            if (loadRooms.isEnabled()){
                JOptionPane.showMessageDialog(_gui, "Attempting to access to no provide information missing rooms", "Loaded", JOptionPane.WARNING_MESSAGE);
            }
            else {
                ArrayList<Room> rooms = new ArrayList<>(_gui.directory().hotel().rooms().values());
                JList<String> roomsList;
                String[] roomsStr = new String[rooms.size()];
                for (int index = 0; index < rooms.size(); index ++)
                    roomsStr[index] = rooms.get(index).toString();
                JFrame jRooms = new JFrame("Rooms");
                JPanel listContainer = new JPanel();
                roomsList = new JList<>(roomsStr);
                roomsList.setSelectionBackground(Color.cyan);
                roomsList.addListSelectionListener(
                        new ListSelectionListener() {
                            @Override
                            public void valueChanged(ListSelectionEvent e) {
                                int index = roomsList.getSelectedIndex();
                                System.out.println(rooms.get(index));
                                try {
                                    double price = Double.parseDouble(JOptionPane.showInputDialog("Select new rate"));
                                    rooms.get(index).setPrice(price);
                                    roomsStr[index] = rooms.get(index).toString();
                                } catch (NullPointerException ignored){}
                            }
                        }
                );
                listContainer.add(roomsList);
                jRooms.setLayout(null);
                listContainer.setBounds(0,0,600, 45 + 22 * roomsStr.length + 30);
                jRooms.setSize(600, 45 + 22 * roomsStr.length + 30);
                jRooms.setResizable(false);
                jRooms.add(listContainer);
                jRooms.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                jRooms.setLocationRelativeTo(_gui);
                jRooms.setVisible(true);
            }
        }
        if (event.getSource() == loadSchedulesRates){
            try
            {
                String type = JOptionPane.showInputDialog(_gui, "write the type of the room");
                if (!(type.equals("single") || type.equals("double") || type.equals("suite"))){
                    JOptionPane.showMessageDialog(_gui, "Undefined type of room '" + type + "'", "WARN", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    String[] strDateRange = JOptionPane.showInputDialog(_gui, "write the date range as DD-MM-YYYY:DD-MM-YYYY").split(":");
                    double newPrice = Double.parseDouble(JOptionPane.showInputDialog(_gui, "input the new price in that range"));
                    DateRange dateRange = new DateRange(strDateRange[0], strDateRange[1]);
                    for (Room room : _gui.directory().hotel().rooms().values()){
                        if (room.type().equals(type))
                            if (room.price() == room.price(dateRange))
                                room.setPrice(dateRange, newPrice);
                            else if (room.price() != room.price(dateRange)){
                                if (room.price(dateRange) > newPrice){
                                    room.setPrice(dateRange, newPrice);
                                }
                            }
                    }
                }
            } catch (Exception ignored){}
        }

        if (event.getSource() == changeRates)
        {
            String nombre = JOptionPane.showInputDialog(_gui,"Enter the dish name");
            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"New drish price"));
            Plate platoOrdenado=_gui.directory().restaurant().plates().get(nombre);
            platoOrdenado.setPrice(price);
        }

        if (event.getSource() == changeRates2)
        {
            String nombre = JOptionPane.showInputDialog(_gui,"Enter the drink name");
            double price=Double.valueOf(JOptionPane.showInputDialog(_gui,"New drink price"));
            Drink platoOrdenado=_gui.directory().restaurant().drinks().get(nombre);
            platoOrdenado.setPrice(price);

        }
        if (event.getSource() == graphics2)
        {
        	
        	DefaultListModel<String> aa = new DefaultListModel<>();
            //
            HashMap<String, Integer> grupos1 = _gui.directory().restaurant().getTotalsells();
            for(Map.Entry<String, Integer> entry : grupos1.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                aa.addElement(key +" tiene un total de ventas de " +value);


                }
            JList<String> grupos = new JList<String>(aa);
            grupos.setBounds(600, 30, 600, 70);


            JScrollPane scrollpane = new JScrollPane(grupos);
            scrollpane.setBounds(0, 0, 300, 200);
            scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            JFrame k1 = new JFrame();
            k1.setLayout(null);
            k1.setSize(300,200);
            k1.add(scrollpane);
        	k1.setVisible(true);

                // do what you have to do here
                // In your case, another loop.
            }



            
        
        if (event.getSource() == changeSchedules)
        {

            boolean sentinel=false;
            while (!sentinel)
            {
                String nombre = JOptionPane.showInputDialog(_gui,"Enter what you want change the schedule");
                if (nombre.equals("spa"))
                {
                    String time = JOptionPane.showInputDialog(_gui,"Write the new schedule for the spa fisrt the open hour ");
                    String time2 = JOptionPane.showInputDialog(_gui,"Write the new schedule for the spa now the close hour ");
                    _gui.directory().spa().timeRange().setRange(time, time2);
                    sentinel=true;

                }
                else if (nombre.equals("guide"))
                {
                    String time = JOptionPane.showInputDialog(_gui,"Write the new schedule for the guide fisrt the open hour ");
                    String time2 = JOptionPane.showInputDialog(_gui,"Write the new schedule for the guide now the close hour ");
                    _gui.directory().tourGuide().timeRange().setRange(time, time2);
                    sentinel=true;

                }
                else if (nombre.equals("plate"))
                {
                    String nombre2 = JOptionPane.showInputDialog(_gui,"Enter the dish name");
                    Plate platoOrdenado=_gui.directory().restaurant().plates().get(nombre2);
                    String time = JOptionPane.showInputDialog(_gui,"Write the new schedule for the plate fisrt the open hour ");
                    String time2 = JOptionPane.showInputDialog(_gui,"Write the new schedule for the plate now the close hour ");
                    platoOrdenado.timeRange().setRange(time, time2);
                    sentinel=true;

                }
                else if (nombre.equals("drinks"))
                {
                    String nombre2 = JOptionPane.showInputDialog(_gui,"Enter the dish name");
                    Drink platoOrdenado=_gui.directory().restaurant().drinks().get(nombre2);
                    String time = JOptionPane.showInputDialog(_gui,"Write the new schedule for the plate fisrt the open hour ");
                    String time2 = JOptionPane.showInputDialog(_gui,"Write the new schedule for the plate now the close hour ");
                    platoOrdenado.timeRange().setRange(time, time2);
                    sentinel=true;

                }
                else {
                    JOptionPane.showMessageDialog(_gui, "Write a correct option", "Error", JOptionPane.WARNING_MESSAGE);
                }

            }

        }
        if (event.getSource()==graphics)
        {
        	grafica();
        }
        if (event.getSource()==graphics4)
        {
        	grafica2();
        }
        if (event.getSource()==graphics3)
        {
        	
        	DefaultListModel<String> aa = new DefaultListModel<>();
            //
            HashMap<String, Integer> grupos1 = _gui.directory().restaurant().getTotalplaces();
            for(Map.Entry<String, Integer> entry : grupos1.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                aa.addElement("En "+key +" se han vendido un total de " +value);


                }
            JList<String> grupos = new JList<String>(aa);
            grupos.setBounds(600, 30, 600, 70);


            JScrollPane scrollpane = new JScrollPane(grupos);
            scrollpane.setBounds(0, 0, 300, 200);
            scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            JFrame k2 = new JFrame();
            k2.setLayout(null);
            k2.setSize(300,200);
            k2.add(scrollpane);
        	k2.setVisible(true);
        	
        	
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
    public void grafica() {
		List<Double> listax= new  ArrayList<>();
    	List<Double> listay= new  ArrayList<>();
    	HashMap<String, Integer> _graphics= _gui.directory().restaurant().getGraphic();
    	for(Map.Entry<String, Integer> entry : _graphics.entrySet()) {
    		String key = entry.getKey();
    		double valor1=Integer.parseInt(key.split(":")[0]);
    		
    		double valor2 = entry.getValue();
    		listax.add(valor1);
    		listay.add(valor2);
    	}
    	
		double[] valorx= listax.stream().mapToDouble(Double::doubleValue).toArray();
		double[] valory= listay.stream().mapToDouble(Double::doubleValue).toArray();
		
		XYChart chart= QuickChart.getChart("Ventas totales vs Hora del dia", "X", "Y", "V(H)", valorx, valory);
		
		frame.setSize(1000,500);
		JPanel panel1= new XChartPanel<XYChart>(chart);
		panel1.setLayout(null);
		frame.add(panel1);
		frame.setVisible(true);
    }
    
    //no me sirvio 
    public void grafica2() {

    			double[] valorx= {50,65,80,70,90,110,95,120,150,130,170,190};
        		double[] valory= {1,2,3,4,5,6,7,8,9,10,11,12};
        		
        		XYChart chart= QuickChart.getChart(" Facturas vs tiempo", "X", "Y", "F(t)", valorx, valory);
        		
        		frame2.setSize(1000,500);
        		JPanel panel2= new XChartPanel<XYChart>(chart);
        		panel2.setLayout(null);
        		frame2.add(panel2);
        		frame2.setVisible(true);	

    		

                }
}
