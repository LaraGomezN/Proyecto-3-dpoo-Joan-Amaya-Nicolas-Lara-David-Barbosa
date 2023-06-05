package gui;

import core.Restaurant;
import core.Spa;
import core.TourGuide;
import utils.Directory;

import javax.swing.*;
import java.io.File;

public class GUI extends JFrame {
    private final Directory _directory;
    private final ImageManager _imageManager = new ImageManager();
    private final LoginManager _loginManager;
    private final AdminManager _adminManager;
    private final EmployeeManager _employeeManager;
    private final RecepcionistManager _recepcionistManager;
    private String actualPanel;
    private Restaurant restaurant;
    private Spa spa;
    private TourGuide guide;

    public GUI() {
    	
        setResizable(false);
        setTitle("Hotel DPOO | Home");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        _imageManager.setImageInUse("login");
        _directory = new Directory("src/sources/usuarios.txt");
        _loginManager = new LoginManager(this);
        _adminManager = new AdminManager(this);
        _employeeManager = new EmployeeManager(this);
        _recepcionistManager = new RecepcionistManager(this);
        add(_imageManager);
        //add(_adminManager);
        _directory.loadGroups();
        _directory.loadPaymentMethods(new File("src/sources/payments.txt"));

        add(_loginManager);
        setVisible(true);

        actualPanel = "login";
    }
    public void change(String panel){
    	_directory.saveGroups();
    	_directory.saveOccupiedRooms();
        _imageManager.setImageInUse(panel);
        if (actualPanel.equals("login"))
            _loginManager.setVisible(false);
        if (actualPanel.equals("admin"))
            _adminManager.setVisible(false);
        if (actualPanel.equals("employee"))
            _employeeManager.setVisible(false);
        if (actualPanel.equals("recepcionist"))
            _recepcionistManager.setVisible(false);


        if (panel.equals("login"))
        {
            _loginManager.setVisible(true);
            _recepcionistManager.setVisible(false);
            _employeeManager.setVisible(false);
            add(_loginManager);
        }


        if (panel.equals("admin"))
        {
            _adminManager.setVisible(true);
            add(_adminManager);
        }
        if (panel.equals("employee"))

        {
            _employeeManager.update();
            _employeeManager.setVisible(true);
            add(_employeeManager);	}

        if (panel.equals("receptionist"))

        {
            _recepcionistManager.update();
            _recepcionistManager.setVisible(true);
            add(_recepcionistManager);	}


        actualPanel = panel;

    }
    public Directory directory(){
        return _directory;
    }
    public ImageManager imageManager(){
        return _imageManager;
    }

    public static void main(String[] args) {
        new GUI();
    }
}