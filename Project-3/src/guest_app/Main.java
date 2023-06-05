package guest_app;


import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {

    private final Login login;
    private String actualPanel;
    private final UserRegistration register;
    private final RoomAvailability room;


    public Main() {
    	
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("src/sources/guest_image.png");
        Image image = imageIcon.getImage().getScaledInstance(900, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imagePanel.add(imageLabel);
        getContentPane().add(imagePanel, BorderLayout.NORTH);
        actualPanel = "login";

        login = new Login(this);
        register = new UserRegistration(this);
        room = new RoomAvailability(this);

 
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Guest App | DPOO Hotel");
        setVisible( true );
        setLocationRelativeTo(null);

        getContentPane().add(login);
        login.setVisible(true);
    }
    
    public void changePanel(String panel){
        if (actualPanel.equals("login"))
            login.setVisible(false);
        
        if (actualPanel.equals("register"))
            register.setVisible(false);
        
        if (actualPanel.equals("room"))
            room.setVisible(false);
        

 
        if (panel.equals("login")){
            login.setVisible(true);
            add(login);}

        if (panel.equals("register")){
            register.setVisible(true);
            add(register);}
        
        
        if (panel.equals("room")){       
            room.setVisible(true);
            add(room);}

              
        actualPanel = panel;
    }

    public static void main(String[] args) {
        new Main();
    }
}
