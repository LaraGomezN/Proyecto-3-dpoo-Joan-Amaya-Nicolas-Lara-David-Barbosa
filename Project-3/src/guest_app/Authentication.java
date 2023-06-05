package guest_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authentication {
	
    public static boolean authenticate(String username, String password, String FILE_PATH) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String storedUsername = parts[0];
                String storedPassword = parts[1];
                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    return true;  
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false; 
    }
}


