package guest_app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserRegistration extends JPanel implements ActionListener, MouseMotionListener

{
    
    private final JLabel user, passwd, cpasswd;
    private final JTextField usertf;
    private final JButton registerb, back;
    private final JPasswordField passwdtf, cpasswdtf;
    private final Main main;
    
    public UserRegistration(Main main) {
    	this.main = main;
    	user = new JLabel("Enter your Username: ");
    	passwd = new JLabel("Enter your Password: ");
    	cpasswd = new JLabel("Confirm your Password: ");  	
    	usertf = new JTextField(25);
        passwdtf = new JPasswordField(25);
        cpasswdtf = new JPasswordField(25);
        registerb = new JButton("Register");
        registerb.addActionListener(this);
        back = new JButton("Go back");
        back.addActionListener(this);
        setLayout(null);
        setBounds(0, 250 , 900, 700);
        
        user.setFont(new Font(user.getFont().getName(), Font.BOLD, 23));
        user.setBounds(130, 50, 600, 70);
        add(user);   
        usertf.setFont(new Font(user.getFont().getName(), Font.BOLD, 14));
        usertf.setBounds(420, 75, 340, 30);
        add(usertf);
        
        passwd.setFont(new Font(user.getFont().getName(), Font.BOLD, 23));
        passwd.setBounds(130, 105, 600, 70);
        add(passwd);      
        passwdtf.setFont(new Font(user.getFont().getName(), Font.BOLD, 14));
        passwdtf.setBounds(420, 130, 340, 30);
        add(passwdtf);
        
        cpasswd.setFont(new Font(user.getFont().getName(), Font.BOLD, 23));
        cpasswd.setBounds(130, 160, 600, 70);
        add(cpasswd);
        
        cpasswdtf.setFont(new Font(user.getFont().getName(), Font.BOLD, 14));
        cpasswdtf.setBounds(420, 185, 340, 30);
        add(cpasswdtf);
        
        registerb.setBounds(380, 270, 200, 50);
        add(registerb);
        
        back.setBounds(20, 350, 150, 30);
        add(back);
        
        
    	
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    	if (event.getSource()==registerb) {
    		if (new String(passwdtf.getPassword()).equals("") || new String(cpasswdtf.getPassword()).equals("") || usertf.getText().equals(""))
    			JOptionPane.showMessageDialog(null, "Please fill all the text fields", "Fail registration", JOptionPane.WARNING_MESSAGE);
    		else if (new String(passwdtf.getPassword()).equals(new String(cpasswdtf.getPassword()))) {
    			String user = usertf.getText();
    	        String pasw = new String(cpasswdtf.getPassword());
    	        String info = user + ";" + pasw;

    	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/sources/app_users.txt", true))) {
    	            writer.write(info);
    	            writer.newLine();
    	            JOptionPane.showMessageDialog(null, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
    	            
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    		}   		
    		else 
    			JOptionPane.showMessageDialog(this, "Passwords do not match", "Fail registration", JOptionPane.WARNING_MESSAGE);
    	          			
    	}
    	
    	if (event.getSource()==back) 
    		main.changePanel("login");
    	
    
        
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
