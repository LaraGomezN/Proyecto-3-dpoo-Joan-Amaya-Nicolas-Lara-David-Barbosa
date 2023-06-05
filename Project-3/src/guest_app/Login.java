package guest_app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Login extends JPanel implements ActionListener, MouseMotionListener

{	
    private final JLabel _welcomeLabel;
    private final JButton _loginButton, _registerButton;
    private final JLabel _userLabel, _passwdLabel, _registerLabel;
    private final JTextField _user;
    private final JPasswordField _passwd;
    private final Main main;
    

    
    public Login(Main main) {
    	this.main = main;
    	_registerLabel = new JLabel("New to DPOO Hotel?");
    	_registerButton = new JButton("Create user");
        _welcomeLabel = new JLabel("WELCOME TO GUEST'S APP");
        _loginButton = new JButton("login");
        _userLabel = new JLabel("User: ");
        _passwdLabel = new JLabel("Password: ");
        _user = new JTextField(25);
        _passwd = new JPasswordField(25);	
        setLayout(null);
        setBounds(0, 250 , 900, 700);
        
        
        _welcomeLabel.setFont(new Font(_welcomeLabel.getFont().getName(), Font.BOLD, 37));
        _welcomeLabel.setBounds(185, 20, 600, 70);
        _welcomeLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        add(_welcomeLabel);

        _userLabel.setFont(new Font(_userLabel.getFont().getName(), Font.BOLD, 23));
        _userLabel.setBounds(215, 85 + 15, 600, 70);
        add(_userLabel);
        
        _user.setFont(new Font(_user.getFont().getName(), Font.BOLD, 14));
        _user.setBounds(345, 106 + 15, 340, 30);
        add(_user);
        
        _passwdLabel.setFont(new Font(_passwdLabel.getFont().getName(), Font.BOLD, 23));
        _passwdLabel.setBounds(215, 140 + 25, 600, 70);
        add(_passwdLabel);
        
        _passwd.setFont(new Font(_passwd.getFont().getName(), Font.BOLD, 14));
        _passwd.setBounds(345, 161 + 25, 340, 30);
        add(_passwd);
        
        _registerLabel.setFont(new Font(_passwdLabel.getFont().getName(), Font.BOLD, 23));
        _registerLabel.setBounds(360, 280, 600, 70);
        add(_registerLabel);
        
        _registerButton.setBounds(400, 340, 150, 30);
        _registerButton.addActionListener(this);
        add(_registerButton);
        
        
        _loginButton.setBounds(400, 240, 150, 30);
        _loginButton.addActionListener(this);
        add(_loginButton);
    }
    
 


	@Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == _loginButton) {
            if (Authentication.authenticate(_user.getText(), new String(_passwd.getPassword()), "src/sources/app_users.txt")) 
            	main.changePanel("room");                
            else 
                JOptionPane.showMessageDialog(this, "User or password is incorrect", "Fail login", JOptionPane.WARNING_MESSAGE);
        }
            
        if (event.getSource() == _registerButton)    	
        	main.changePanel("register");        	
        	
     
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
    
    
    
    