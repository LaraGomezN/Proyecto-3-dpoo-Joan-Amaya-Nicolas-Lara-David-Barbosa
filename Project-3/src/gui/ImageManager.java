package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ImageManager extends JPanel{
    private final Image loginImage, adminImage, receptionistImage, employeeImage;
    private Image imageInUse;

    public ImageManager(){
        loginImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/login_image.png"))).getImage();
        adminImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/admin_image.png"))).getImage();
        receptionistImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/receptionist_image.png"))).getImage();
        employeeImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/sources/employee_image.png"))).getImage();
        setBounds(0,0,900, 250);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawImage(imageInUse, 0, 0, 900, 250, this);
    }

    public void setImageInUse(String type){
        switch (type) {
            case "login" -> imageInUse = loginImage;
            case "admin" -> imageInUse = adminImage;
            case "receptionist" -> imageInUse = receptionistImage;
            case "employee" -> imageInUse = employeeImage;
        }
        repaint();
    }
}
