package guest_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import core.Guest;

public class RoomAvailability extends JPanel implements ActionListener, MouseMotionListener{

	private final JComboBox<String> combo;
	private final JButton consult, back, book, card;
	private final JTextField initialdtf, finaldtf, creditcardtf;
	private final JPasswordField codetf;
	private final JLabel available, iniciald, finald, creditcard, code; 
	private final Main main;
	private final HashMap<List<String>, List<LocalDate>> hashMap = new HashMap<>();
	private final JLabel info1, info2, info3;
	private JButton end = new JButton("End adding");
    private JButton add = new JButton("Add member");
    private JLabel name = new JLabel("Name");
    private JTextField namet = new JTextField();
    private JLabel mail = new JLabel("Mail");
    private JTextField mailt = new JTextField();
    private JLabel age = new JLabel("Age");
    private JTextField aget = new JTextField();
    private JLabel document = new JLabel("Identification Number");
    private JTextField documentt = new JTextField();
    private JLabel id = new JLabel("Name");
    private JTextField idt = new JTextField();
    private JFrame f = new JFrame();
    private JDialog d = new JDialog(f, "Guest App | DPOO Hotel", true);
	
	public RoomAvailability(Main main){
		this.main = main;
		info1 = new JLabel();
		info2 = new JLabel();
		info3 = new JLabel();
		combo = new JComboBox<String>();
		combo.addActionListener(this);
		consult = new JButton("Consult");
		consult.addActionListener(this);
		back = new JButton("Go back");
        back.addActionListener(this);
        book = new JButton("Do the booking");
        book.addActionListener(this);
        card = new JButton("Do credit card payment");
        card.addActionListener(this);
		initialdtf = new JTextField(25);
		finaldtf = new JTextField(25);
		creditcardtf = new JTextField(25);
		codetf = new JPasswordField(25);
		available = new JLabel("Rooms available");
		iniciald = new JLabel("Enter the initial date: ");
		finald = new JLabel("Enter the final date: ");
		creditcard = new JLabel("Enter your CC number: ");
		code = new JLabel("Enter the code: ");
		
		
		
		setLayout(null);
        setBounds(0, 250 , 900, 700);
        
        iniciald.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 19));
        iniciald.setBounds(360, 10, 600, 70);
        add(iniciald);   
        initialdtf.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 14));
        initialdtf.setBounds(360, 75, 210, 30);
        add(initialdtf);
        
        finald.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 19));
        finald.setBounds(640, 10, 600, 70);
        add(finald);   
        finaldtf.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 14));
        finaldtf.setBounds(640, 75, 210, 30);
        add(finaldtf);
        
        creditcard.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 19));
        creditcard.setBounds(360, 190, 600, 70);
        add(creditcard);   
        creditcardtf.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 14));
        creditcardtf.setBounds(360, 260, 210, 30);
        add(creditcardtf);
        
        code.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 19));
        code.setBounds(640, 190, 600, 70);
        add(code);   
        codetf.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 14));
        codetf.setBounds(640, 260, 210, 30);
        add(codetf);
        
        
        
        
        
        available.setFont(new Font(iniciald.getFont().getName(), Font.BOLD, 22));
        available.setBounds(80, 10, 600, 70);
        add(available);     
        
        combo.setBounds(50, 75, 240, 30);
        add(combo);
        
        back.setBounds(20, 350, 150, 30);
        add(back);
        consult.setBounds(500, 130, 210, 30);
        add(consult);
        book.setBounds(50, 260, 240, 30);
        add(book);
        card.setBounds(480, 310, 240, 30);
        add(card);
        
        
		
	}
	
	
	
	



	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource()==back) 
    		main.changePanel("login");
		
		if (event.getSource()==consult){
			
			if (finaldtf.getText().equals("") || initialdtf.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Please fill all the text fields", "Fail consult", JOptionPane.WARNING_MESSAGE);
			
			else{
				String startDateStr = initialdtf.getText();
				String endDateStr = finaldtf.getText();
				LocalDate startDate = LocalDate.parse(startDateStr);
		        LocalDate endDate = LocalDate.parse(endDateStr);	        
		        List<LocalDate> dateRange = new ArrayList<>();		        
		        LocalDate currentDate = startDate;		        
		        while (!currentDate.isAfter(endDate)) {
		            dateRange.add(currentDate);
		            currentDate = currentDate.plusDays(1);
		        }		        
		        
				try (BufferedReader reader = new BufferedReader(new FileReader("src/sources/rooms.txt"))) {
		            String line;		            
		            hashMap.clear();	            
		            while ((line = reader.readLine()) != null) {		            	
		            	String[] parts = line.split(";");		            	
		            	List<LocalDate> dateRangeRooms = new ArrayList<>();
		            	List<String> key = new ArrayList<>();		            	
		            	long id = (long) (Math.random() * 1_000_000_000);
		            	String id_str = Long.toString(id);
		            	key.add(id_str);
		            	key.add(parts[0]);
		            	key.add(parts[1]);
		            	key.add(parts[2]);
		            	for(int i = 15; i<parts.length; i++) {
		            		LocalDate date = LocalDate.parse(parts[i]);
		            		dateRangeRooms.add(date);
		            	}
		            	hashMap.put(key, dateRangeRooms);  	

		            }
		            
		            List<List<String>> keysToRemove = new ArrayList<>();

		            for (List<String> lista : hashMap.keySet()) {
		                for (LocalDate fecha : hashMap.get(lista)) {
		                    if (dateRange.contains(fecha)) {
		                        keysToRemove.add(lista);
		                        break;
		                    }
		                }
		            }

		            for (List<String> lista : keysToRemove) {
		                hashMap.remove(lista);
		            }

		            combo.removeAllItems(); 
		            for (List<String> lista : hashMap.keySet()) {
		            	String idxd = lista.get(0);
		            	String datoo = "Room ID: " + idxd;
		            	combo.addItem(datoo);
		            }
		            
		            
		            
		            
				}
		            catch (IOException e) {
		            System.out.println("Error al leer el archivo: " + e.getMessage());}       
			}
		}
		
		if (event.getSource() == combo)
        {
			if (combo.getSelectedItem() != null) {
				info1.setText("");
				info2.setText("");
				info3.setText("");
			    String value = combo.getSelectedItem().toString();
			    String number = value.replaceAll("[^0-9]", "");
			    for (List<String> lista : hashMap.keySet()) {
			    	if (lista.contains(number)) {
			    		String price = lista.get(1);
			    		String capacity = lista.get(2);
			    		String type = lista.get(3);
			    		info1.setText("Price: " + price);
			    		info1.setFont(new Font(info1.getFont().getName(), Font.BOLD, 18));
			    		info1.setBounds(50, 130, 200, 30);
			    		add(info1);
			    		
			    		info2.setText("Capacity: " + capacity + " adult");
			    		info2.setFont(new Font(info1.getFont().getName(), Font.BOLD, 18));
			    		info2.setBounds(50, 160, 200, 30);
			    		add(info2);
			    		
			    		info3.setText("Type: " + type);
			    		info3.setFont(new Font(info1.getFont().getName(), Font.BOLD, 18));
			    		info3.setBounds(50, 190, 200, 30);
			    		add(info3);			    	
			    	}			    
			    }
			}
        }
		
		if (event.getSource() == book) {
			if(combo.getSelectedItem() == null) 
				JOptionPane.showMessageDialog(null, "Please enter the dates, press the consult button and select the room that interests you", "Fail reservation", JOptionPane.WARNING_MESSAGE);
			else {
				d.setLayout(null);

	            add.setBackground(new Color(0x00ffe3));
	            add.setBounds(390, 200, 130, 31);
	            add.addActionListener(this);

	            end.setBackground(new Color(0x00ffe3));
	            end.setBounds(520, 200, 130, 31);
	            end.addActionListener(this);

	            name.setFont(new Font(name.getFont().getName(), Font.BOLD, 24));
	            name.setBounds(10, 10, 300, 31);
	            namet.setBounds(10, 50, 300, 31);

	            mail.setFont(new Font(name.getFont().getName(), Font.BOLD, 24));
	            mail.setBounds(10, 90, 300, 31);
	            mailt.setBounds(10, 130, 300, 31);

	            age.setFont(new Font(name.getFont().getName(), Font.BOLD, 24));
	            age.setBounds(350, 10, 300, 31);
	            aget.setBounds(350, 50, 300, 31);

	            document.setFont(new Font(name.getFont().getName(), Font.BOLD, 24));
	            document.setBounds(350, 90, 300, 31);
	            documentt.setBounds(350, 130, 300, 31);

	            id.setFont(new Font(name.getFont().getName(), Font.BOLD, 24));
	            id.setBounds(10, 10, 300, 31);
	            idt.setBounds(10, 50, 300, 31);

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
	            d.setLocationRelativeTo(null);
	            d.setVisible(true);
	            
	            
	            String startDateStrx = initialdtf.getText();
				String endDateStrx = finaldtf.getText();
				LocalDate startDatex = LocalDate.parse(startDateStrx);
		        LocalDate endDatex = LocalDate.parse(endDateStrx);	        
		        List<String> dateRange2 = new ArrayList<>();		        
		        LocalDate currentDatex = startDatex;		        
		        while (!currentDatex.isAfter(endDatex)) {
		            dateRange2.add(currentDatex.toString());
		            currentDatex = currentDatex.plusDays(1);}
		        if (combo.getSelectedItem() != null) {
		        	String valuex = combo.getSelectedItem().toString();
		        	String idx = valuex.substring(9);
		        	String pricex = "";
		        	List<String> fecharet = new ArrayList<>();
		        	for (List<String> lista : hashMap.keySet()) {
		        		if (lista.contains(idx)) 
		        			pricex = lista.get(1);	        		
		        	}
		        	for (String fechax : dateRange2) {
		        		fecharet.add(fechax.toString());}		    
		        	
		        	try (BufferedReader reader = new BufferedReader(new FileReader("src/sources/rooms.txt"))) {
		        		List<String> lineas = new ArrayList<>();
			            String line;		            
			            hashMap.clear();	            
			            while ((line = reader.readLine()) != null) {		            	
			            	String[] parts = line.split(";");
			            	if (parts[0].equals(pricex)) {
			            		List<String> listaUnida = new ArrayList<>(Arrays.asList(parts));
			            		listaUnida.addAll(fecharet);
			            		String aa = String.join(";", listaUnida);
			            		lineas.add(aa);
			            	}
			            	else {
			            		lineas.add(line);
			            	} 	            
			            } 
			            		            
			            try {
			                Files.write(Path.of("src/sources/rooms.txt"), lineas, StandardOpenOption.TRUNCATE_EXISTING);			                
			            }catch (IOException e) {
			                System.out.println("Ocurrió un error al modificar el archivo: " + e.getMessage());}
		            
		        	}
			            catch (IOException e) {
			            System.out.println("Error al leer el archivo: " + e.getMessage());} 
					}		        	
				}		        	
		    }		
		
		
		
		if (event.getSource() == add) {
            namet.setText("");
            mailt.setText("");
            aget.setText("");
            documentt.setText("");        
		}
		
		if (event.getSource() == end) {
			
			d.dispose();
			JOptionPane.showMessageDialog(null, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (event.getSource() == card) {
			if (combo.getSelectedItem() != null) {
				if (creditcardtf.getText().equals("") || new String(codetf.getPassword()).equals("")) 
					JOptionPane.showMessageDialog(null, "Please fill all the text fields", "Fail consult", JOptionPane.WARNING_MESSAGE);
				else {
					if (Authentication.authenticate(creditcardtf.getText(), new String(codetf.getPassword()), "src/sources/credit_cards.txt")) {
						JOptionPane.showMessageDialog(this, "You have paid the reservation for the selected room. As you paid with credit card, you hace 10% discount on the price shown at the left", "Successful payment", JOptionPane.INFORMATION_MESSAGE);  }             
		            else 
		                JOptionPane.showMessageDialog(this, "Credit card number or code is incorrect", "Fail payment", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please enter the dates, press the consult button and select the room that interests you", "Fail reservation", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	

	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	
	
}
