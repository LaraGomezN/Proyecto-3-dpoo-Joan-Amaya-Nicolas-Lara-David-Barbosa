package gui;

import core.Group;
import core.Guest;
import core.Room;
import core.serviciosAnadidos;
import payments.PaymentMethod;
import utils.DateRange;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class RecepcionistManager extends JPanel implements ActionListener, MouseMotionListener {
    private GUI _gui;
    private JLabel servicesLabel;
    private JLabel roomsLabel;
    private final JButton checkin = new JButton("1. Check-in");
    private final JButton checkroom = new JButton("2. Check rooms");
    private final JButton bill = new JButton("Print bill and checkout");
    private JButton end = new JButton("End adding");
    private JButton add = new JButton("Add member");
    private JFrame k = new JFrame();
    private JDialog d;
    private JFrame f2 = new JFrame();
    private JDialog groupRoomsManager = new JDialog(f2, "Hotel DPOO | Group Assignation", true);
    private JLabel name = new JLabel("Name");
    private JTextField namet = new JTextField();
    private JLabel mail = new JLabel("Mail");
    private JTextField mailt = new JTextField();
    JLabel date = new JLabel("Admission date DD-MM-AAAA (Only the number of year)");
    JTextField datet = new JTextField();
    JLabel date2 = new JLabel("Departure date DD-MM-AAAA (Only the number of year)");
    JTextField date2t = new JTextField();
    JLabel type1 = new JLabel("Room type");
    ButtonGroup g = new ButtonGroup();
    JRadioButton btn1 = new JRadioButton("Standard");
    
    JRadioButton btn2 = new JRadioButton("Suite");
    
    JRadioButton btn3 = new JRadioButton("Double Suite");
    
    JLabel addition = new JLabel("Addition");
    
    JCheckBox opc1 = new JCheckBox("Balcony");
    
    JCheckBox opc2 = new JCheckBox("View");

    JCheckBox opc3 = new JCheckBox("Built-in kitchen");

    private JLabel age = new JLabel("Age");
	JLabel thumb = new JLabel();
	JLabel thumbt = new JLabel("");
    private JTextField aget = new JTextField();
    private JLabel document = new JLabel("Identification Number");
    private JTextField documentt = new JTextField();
    private JLabel id = new JLabel("Name");
    private JTextField idt = new JTextField();
    JComboBox<String> habitaciones= new JComboBox<String>();
    private final JButton Logout = new JButton("Logout");
    private final JButton Help = new JButton("Help");
    private ArrayList<Guest> guests;
    private JLabel idroom=new JLabel("");
    private JLabel numberguess=new JLabel("");
    private JLabel type=new JLabel("");
    private JLabel cafetera=new JLabel("");
    private JLabel calefaccion=new JLabel("");
    private JLabel camaTapetes=new JLabel("");
    private JLabel desayuno=new JLabel("");
    private JLabel plancha=new JLabel("");
    private JLabel secador=new JLabel("");
    private JLabel tomasA=new JLabel("");
    private JLabel tomasB=new JLabel("");
    private JLabel tv=new JLabel("");
    private JLabel voltajeAc=new JLabel("");
    private JLabel aire=new JLabel("");
    private JPanel f = new JPanel();
    private JLabel metros = new JLabel("");
    private JLabel parqpago = new JLabel(" Parqueadero pago: no");
    private JLabel parqgrat = new JLabel(" Parqueadero gratuito: si");
    private JLabel piscina = new JLabel(" Piscina: si");
    private JLabel zh = new JLabel(" zonas humedas: no");
    private JLabel bbq = new JLabel(" BBQ: no");
    private JLabel wifi = new JLabel(" wifi: si");
    private JLabel recp = new JLabel(" recepcion 24 horas: si");
    private JLabel masc = new JLabel(" mascotas: no");
    
    
    ArrayList<Room> Rooms= new ArrayList<>();

    private JFrame x = new JFrame();
    private JDialog y;
    private JButton salir = new JButton("Finish");

    public void update() {
        //if (_gui.directory().restaurant()==null||_gui.directory().spa()==null||_gui.directory().tourGuide()==null)
        //{

        //setLayout(null);
        //setBounds(50, 250 , 900, 700);
        //servicesLabel1.setFont(new Font(servicesLabel1.getFont().getName(), Font.BOLD, 24));
        //servicesLabel1.setBounds(0, 150, 1000, 70);
        //add(servicesLabel1);
        //setLayout(null);
        //setBounds(0, 250 , 900, 700);
        //Logout.setBounds(0, 380, 450, 31);
        //Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        //Logout.addActionListener(this);
        //add(Logout);
        //}
        //else
        //{
        setLayout(null);
        setBounds(0, 250, 900, 700);


        servicesLabel = new JLabel("Services");
        servicesLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        servicesLabel.setBounds(200, 30, 600, 70);
        add(servicesLabel);

        checkin.setBackground(new Color(0x00ffe3));
        checkin.setBounds(100, 90, 300, 31);
        checkin.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        checkin.addActionListener(this);
        add(checkin);

        checkroom.setBackground(new Color(0x00ffe3));
        checkroom.setBounds(100, 120, 300, 31);
        checkroom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        checkroom.addActionListener(this);
        add(checkroom);


        roomsLabel = new JLabel("Group");
        roomsLabel.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
        roomsLabel.setBounds(600, 30, 600, 70);
        add(roomsLabel);

        DefaultListModel<String> aa = new DefaultListModel<>();
        //
        HashMap<Long, Group> grupos1 = _gui.directory().groups();
        for (Map.Entry<Long, Group> entry : grupos1.entrySet()) {
            Long key = entry.getKey();
            Group value = entry.getValue();
            HashMap<Long, Guest> miembros = value.members();
            aa.addElement("Grupo con identificacion " + value.id());


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


        bill.setBackground(new Color(0x00ffe3));
        bill.setBounds(490, 300, 300, 31);
        bill.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        bill.addActionListener(this);
        add(bill);


        Logout.setBounds(0, 380, 450, 31);
        Logout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        Logout.addActionListener(this);
        add(Logout);

        Help.setBounds(450, 380, 450, 31);
        Help.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
        add(Help);
        //}
    }

    public RecepcionistManager(GUI gui) {
        _gui = gui;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == checkin) {
        	if (d==null)
        	{
        		d= new JDialog(k, "Hotel DPOO | Guests", true);
        		guests = new ArrayList<>();
                d.setLayout(null);

                add.setBackground(new Color(0x00ffe3));
                add.setBounds(390, 200, 130, 31);
                add.addActionListener(this);

                end.setBackground(new Color(0x00ffe3));
                end.setBounds(520, 200, 130, 31);
                end.addActionListener(this);

                name.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                name.setBounds(10, 10, 300, 31);
                namet.setBounds(10, 50, 300, 31);

                mail.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                mail.setBounds(10, 90, 300, 31);
                mailt.setBounds(10, 130, 300, 31);

                age.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                age.setBounds(350, 10, 300, 31);
                aget.setBounds(350, 50, 300, 31);

                document.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                document.setBounds(350, 90, 300, 31);
                documentt.setBounds(350, 130, 300, 31);

                id.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                id.setBounds(10, 10, 300, 31);
                idt.setBounds(10, 50, 300, 31);

                checkroom.addActionListener(this);
                d.add(add);
                d.add(end);
                d.add(name);
                d.add(namet);
                d.add(mail);
                d.add(mailt);
                d.add(age);
                d.add(aget);
                d.add(document);
                d.add(documentt);
                d.add(id);
                d.add(idt);

                d.setSize(700, 300);
                d.setVisible(true);

        	}
        	else
        	{
        		d.setVisible(true);
        	}
            

        }

        if (event.getSource() == add) {
            ///
            ///
            ///
            ///
            ///
        	try {
        	
        		guests.add(new Guest(namet.getText(), Integer.parseInt(aget.getText()), Long.parseLong(documentt.getText()), mailt.getText()));
                namet.setText("");
                mailt.setText("");
                aget.setText("");
                documentt.setText("");	
        	}
        	catch(Exception e)
        	{
        		
        		JOptionPane.showMessageDialog(_gui, "Some fields are uncompleted  or the fields are with incorrect information (Check age or id: only numbers)", "Complete all options or incorrect information", JOptionPane.WARNING_MESSAGE);
        		d.setVisible(false);
        		
        		
        	}
            
        }

        if (event.getSource() == end) {
        	try {
        		guests.add(new Guest(namet.getText(), Integer.parseInt(aget.getText()), Long.parseLong(documentt.getText()), mailt.getText()));
                namet.setText("");
                mailt.setText("");
                aget.setText("");
                documentt.setText("");	
                
        	}
        	catch(Exception e)
        	
        	
        	{
        		
        		JOptionPane.showMessageDialog(_gui, "Some fields are uncompleted  or the fields are with incorrect information (Check age or id: only numbers)", "Complete all options or incorrect information", JOptionPane.WARNING_MESSAGE);
        		d.setVisible(false);
        		
        		
        	}
        	try {

            	
                Group group = new Group(guests.get(0), new ArrayList<>(guests));
                guests.clear();
                long group_id = group.id();
                
                d.setVisible(false);
                d.dispose();
                

                
                date.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 11));
                date.setBounds(10, 40, 300, 31);
                datet.setBounds(10, 80, 300, 31);
                 date2.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 11));
                date2.setBounds(10, 120, 300, 31);
                date2t.setBounds(10, 160, 300, 31);

                type1.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 11));
                type1.setBounds(360, 40, 300, 31);
                btn1.setBounds(360, 80, 100, 31);
                btn1.setSelected(true);
                btn2.setBounds(360, 120, 100, 31);
                btn3.setBounds(360, 160, 100, 31);

                addition.setFont(new Font(servicesLabel.getFont().getName(), Font.BOLD, 24));
                addition.setBounds(550, 40, 300, 31);
                opc1.setBounds(550, 80, 300, 31);
                opc2.setBounds(550, 120, 300, 31);
                opc3.setBounds(550, 160, 300, 31);
                salir.setBackground(new Color(0x00ffe3));
                salir.setBounds(530, 210, 130, 31);
                salir.addActionListener(this);
                salir.addActionListener(
                        event_finish -> {
                            if (event_finish.getSource() == salir) {
                                Guest[] members = group.members().values().toArray(new Guest[0]);
                                int members_left = group.members().size() - 1;
                                // Update the frame
                                this.update();
                                // Create the instance of the DateRange passed
                                System.out.println(datet.getText()+date2t.getText());
                                DateRange choseRange = new DateRange(datet.getText(), date2t.getText());
                                // Iter all rooms available
                                for (Room room : _gui.directory().hotel().rooms().values()){
                                    if (!room.occupancyRanges().contains(choseRange) &&
                                            (room.type().equals(btn1.isSelected() ? "single" : (btn2.isSelected() ? "suite" : "double")))
                                    ) {
                                        // Check if the room is not occupied in that DateRange
                                        room.addRange(choseRange);
                                        // Add the new DateRange to the register
                                        while (members_left >= 0 && room.canAddOccupant()){
                                            room.addOccupant(members[members_left]);
                                            members_left --;
                                        }
                                    }
                                }
                            y.setVisible(false);
                            _gui.directory().addGroup(group);
                            update();
                            }
                        }
                    );



                if(y==null) {
                	y= new JDialog(x, "Hotel DPOO | Rooms", true);
                 	y.setLayout(null);
                 	g.add(btn1);
                     g.add(btn2);
                     g.add(btn3);


                     y.add(type);
                     y.add(addition);

                     y.add(btn1);
                     y.add(btn2);
                     y.add(btn3);
                     y.add(salir);
                     y.add(opc1);
                     y.add(opc2);
                     y.add(opc3);

                     y.add(date);
                     y.add(datet);
                     y.add(date2);
                     y.add(date2t);


                     y.setSize(700, 300);
                     y.setVisible(true);
                     
                	
                }
                else {
                	y.setVisible(true);
                }
 
               

             

                	


                            }
        	catch(Exception e)
        	{
        		JOptionPane.showMessageDialog(_gui, "There are not guesses to add in the group ", "No guesses ", JOptionPane.WARNING_MESSAGE);	
        	}
        	}


        if (event.getSource() == Logout) {
            _gui.change("login");
        }

        if (event.getSource() == bill) {
            HashMap<String, PaymentMethod> paymentMethods = _gui.directory().paymentMethods();
            JOptionPane.showMessageDialog(_gui, "All payment methods: " + Arrays.toString(paymentMethods.keySet().toArray(new String[0])), "Payment Methods", JOptionPane.INFORMATION_MESSAGE);
            boolean notValid = true;
            PaymentMethod paymentMethod = null;
            while (notValid){
                String method = JOptionPane.showInputDialog(_gui, "Enter the payment method");
                paymentMethod = paymentMethods.get(method);
                if (paymentMethod != null)
                    notValid = false;
            }
            long number = Long.parseLong(JOptionPane.showInputDialog(_gui, "Enter the card number"));
            short password = Short.parseShort(JOptionPane.showInputDialog(_gui, "Enter the card password"));
            if (paymentMethod.bankCard(number) == null){
                JOptionPane.showMessageDialog(_gui, "Error in the number", "WARNING", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!paymentMethod.bankCard(number).pay(password)){
                JOptionPane.showMessageDialog(_gui, "Error in the password", "CRITICAL", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Long id = Long.parseLong(JOptionPane.showInputDialog(_gui, "Pass the id of the group to do the checkout"));
            Group group = _gui.directory().groups().get(id);
            String message = "Group ID: " + id + "\n";
            for (Guest guest : group.members().values()){
                message = message.concat("The guest: " + guest.name() + " spend:\n");
                message = message.concat("\tRestaurant: " + guest.drinksConsumed() + guest.platesConsumed() + "\n");
                message = message.concat("\tSpa: " + guest.spaUsages() * _gui.directory().spa().price() * 1.19 + "\n");
                message = message.concat("=".repeat(20) + "\n");
            }
            BufferedWriter writer = Utils.write(new File("src/record" + id + ".txt"));
            try { assert writer != null; }
            catch (AssertionError ignored)
            {JOptionPane.showMessageDialog(_gui, "warning error when trying to save the bill of the group '" + id + "'", "CRITICAL", JOptionPane.ERROR_MESSAGE); return;}
            try {writer.write(message);}
            catch (IOException exception)
            {JOptionPane.showMessageDialog(_gui, "something going wrong whe try to edit the file created", "CRITICAL", JOptionPane.ERROR_MESSAGE); return;}
            JOptionPane.showMessageDialog(_gui, "success save of the bill" + id + "'", "INFO", JOptionPane.INFORMATION_MESSAGE);
            try { writer.close(); } catch (IOException ignored) {}
        }
        if (event.getSource() == checkroom){
        	//checkroooms
        	k.setLayout(null);
        	


            f.setLayout(null);
            HashMap<Long, Room> platos= _gui.directory().hotel().rooms();
            
            if (habitaciones.getItemCount()==0)
            {
            	habitaciones.addItem("Select");
                for(Map.Entry<Long, Room> entry : platos.entrySet()) {
                    Long key = entry.getKey();
                    Room value = entry.getValue();
                    Rooms.add(value);
                    habitaciones.addItem("Room with number "+ key +" and price of: "+value.price());
                }
                habitaciones.setBounds(0, 0, 500, 20);
                
                
            }
            
            f.add(habitaciones);
            f.setSize(1000,500);
            k.add(f);
            k.setSize(1000,500);
            k.setVisible(true);
            f.setVisible(true);
            k.setResizable(false);
            habitaciones.addActionListener(this);
        }
        
        if (event.getSource() == habitaciones)
        {
        	String value= habitaciones.getSelectedItem().toString();
        	
        	if (!value.equals("Select"))
        	{
        		visible();

        	}
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    public void visible()
    {
    	

		f.add(calefaccion);
		f.add(voltajeAc);
		f.add(tv);
		f.add(tomasB);
		f.add(tomasA);
		f.add(secador);
		f.add(plancha);
		f.add(desayuno);
		f.add(aire);
		f.add(type);
		f.add(idroom);
		f.add(numberguess);
		f.add(cafetera);
		f.add(metros);
		f.add(camaTapetes);
		f.add(parqpago);
		f.add(parqgrat);
		f.add(piscina);
		f.add(zh);
		f.add(bbq);
		f.add(wifi);
		f.add(recp);
		f.add(masc);
		int index = habitaciones.getSelectedIndex();
		Room idr= Rooms.get(index-1);
		ArrayList<serviciosAnadidos> servicios= idr.GetServices();
		if(idr.type().equals("suite"))
		{
			Image roomImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/double1.png"))).getImage();  //this generates an image file
	    	ImageIcon icon = new ImageIcon(roomImage); 
	    	thumbt.setText("Ilustración habitación suite:");
	    	thumbt.setBounds(200,150,250,20);
	    	thumb.setBounds(250,200,400,200);
	    	thumb.setIcon(icon);
	    	f.add(thumb);
	    	f.add(thumbt);
			
		}
		else if(idr.type().equals("single"))
		{
			Image roomImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/single1.png"))).getImage();  //this generates an image file
	    	ImageIcon icon = new ImageIcon(roomImage); 
	    	thumbt.setText("Ilustración habitación single:");
	    	thumbt.setBounds(200,150,250,20);
	    	thumb.setBounds(250,200,400,200);
	    	thumb.setIcon(icon);
	    	f.add(thumb);
	    	f.add(thumbt);

			
		}
		else if(idr.type().equals("double"))
		{
			Image roomImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/double2.png"))).getImage();  //this generates an image file
	    	ImageIcon icon = new ImageIcon(roomImage); 
	    	thumbt.setText("Ilustración habitación double:");
	    	thumbt.setBounds(200,150,250,20);
	    	thumb.setBounds(250,200,400,200);
	    	thumb.setIcon(icon);
	    	f.add(thumb);
	    	f.add(thumbt);

			
		}
		
		metros.setText("Los metros son: "+ idr.metroscuadrados());
		metros.setBounds(400,80,200,40);
		
    	idroom.setText("Id :"+ idr.id() );
		idroom.setBounds(40,40,100,40);
		
		
		type.setText(" Type: "+ idr.type());
		type.setBounds(40,80,100,40);
		
		
		

		numberguess.setText(" Number of persons is: "+idr.maxOccupancy());
		numberguess.setBounds(40,120,250,40);
		
		
		
		cafetera.setText(" Cafetera: "+ servicios.get(0).estaPresente());
		cafetera.setBounds(40,150,250,40);
		
		
		
		calefaccion.setText(" Calefaccion: "+ servicios.get(1).estaPresente());
		calefaccion.setBounds(40,180,250,40);
		
		
		
		camaTapetes.setText(" Cama y Tapetes: "+ servicios.get(2).estaPresente());
		camaTapetes.setBounds(40,210,250,40);
		
		
		
		desayuno.setText(" Desayuno: "+ servicios.get(3).estaPresente());
		desayuno.setBounds(200,40,250,40);
		
		
		
		plancha.setText(" Plancha: "+ servicios.get(4).estaPresente());
		plancha.setBounds(200,80,250,40);
		
		
		
		secador.setText(" Secador de Pelo: "+ servicios.get(5).estaPresente());
		secador.setBounds(40,270,250,40);
		
		
		
		tomasA.setText(" Tomas usb tipo A: "+ servicios.get(6).estaPresente());
		tomasA.setBounds(40,300,250,40);
		
		
		
		tomasB.setText(" Tomas usb tipo C: "+ servicios.get(7).estaPresente());
		tomasB.setBounds(40,330,250,40);
		
		
		
		tv.setText(" Tv: "+ servicios.get(8).estaPresente());
		tv.setBounds(40,360,250,40);
		
		
		
		voltajeAc.setText(" Voltaje Ac: "+ servicios.get(9).estaPresente());
		voltajeAc.setBounds(40,390,250,40);
		
		parqpago.setBounds(700,40,250,40);
		parqgrat.setBounds(700,80,250,40);
		piscina.setBounds(700,120,250,40);
		zh.setBounds(700,160,250,40);
		bbq.setBounds(700,200,250,40);
		wifi.setBounds(700,240,250,40);
		recp.setBounds(700,280,250,40);
		masc.setBounds(700,310,250,40);
		
		
		
		
		
		aire.setText(" Aire acondicionado: "+ servicios.get(10).estaPresente());
		aire.setBounds(40,240,250,40);
		idroom.setVisible(true);
		aire.setVisible(true);
		voltajeAc.setVisible(true);
		tv.setVisible(true);
		tomasB.setVisible(true);
		tomasA.setVisible(true);
		secador.setVisible(true);
		plancha.setVisible(true);
		desayuno.setVisible(true);
		camaTapetes.setVisible(true);
		calefaccion.setVisible(true);
		cafetera.setVisible(true);
		numberguess.setVisible(true);
		type.setVisible(true);
    	
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }
}