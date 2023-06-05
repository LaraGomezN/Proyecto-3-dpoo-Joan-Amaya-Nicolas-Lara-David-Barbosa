package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LoginManager extends JPanel implements ActionListener , MouseMotionListener {
    private final GUI _gui;
    private final JLabel _welcomeLabel;
    private final JButton _loginButton;
    private final JLabel _userLabel, _passwdLabel;
    private final JTextField _user;
    private final JPasswordField _passwd;

    public LoginManager(GUI gui){
        _gui = gui;
        _welcomeLabel = new JLabel("WELCOME TO DPOO HOTEL");
        _loginButton = new JButton("login");
        _userLabel = new JLabel("User: ");
        _passwdLabel = new JLabel("Password: ");
        _user = new JTextField(25);
        _passwd = new JPasswordField(25);
        _loginButton.addActionListener(this);
        setLayout(null);
        setBounds(0, 250 , 900, 700);

        _welcomeLabel.setFont(new Font(_welcomeLabel.getFont().getName(), Font.BOLD, 37));
        _welcomeLabel.setBounds(185, 30, 600, 70);
        _welcomeLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        add(_welcomeLabel);

        _userLabel.setFont(new Font(_userLabel.getFont().getName(), Font.BOLD, 23));
        _userLabel.setBounds(215, 85 + 35, 600, 70);
        add(_userLabel);
        _user.setFont(new Font(_user.getFont().getName(), Font.BOLD, 14));
        _user.setBounds(345, 106 + 35, 340, 30);
        add(_user);
        _passwdLabel.setFont(new Font(_passwdLabel.getFont().getName(), Font.BOLD, 23));
        _passwdLabel.setBounds(215, 140 + 45, 600, 70);
        add(_passwdLabel);
        _passwd.setFont(new Font(_passwd.getFont().getName(), Font.BOLD, 14));
        _passwd.setBounds(345, 161 + 45, 340, 30);
        add(_passwd);
        _loginButton.setBounds(400, 280, 100, 30);
        add(_loginButton);
        addMouseMotionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == _loginButton){
            if (_gui.directory().isAdministrator(_user.getText(), new String(_passwd.getPassword())))
                _gui.change("admin");
            else if (_gui.directory().isReceptionist(_user.getText(), new String(_passwd.getPassword())))
                _gui.change("receptionist");
            else if (_gui.directory().isEmployee(_user.getText(), new String(_passwd.getPassword())))
                _gui.change("employee");
            else
                JOptionPane.showMessageDialog(this, "User or password is incorrect", "Fail login", JOptionPane.WARNING_MESSAGE);
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