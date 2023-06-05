package utils;

import java.io.*;

public class Utils {

    public static BufferedWriter write(String path)
    {
        try { return new BufferedWriter(new FileWriter(path));}
        catch (IOException error) { error.printStackTrace(); }
        return null;
    }
    public static BufferedWriter write(File path)
    {
        try { return new BufferedWriter(new FileWriter(path));}
        catch (IOException error) { error.printStackTrace(); }
        return null;
    }
    public static BufferedReader read(String path)
    {
        try { return new BufferedReader(new FileReader(path));}
        catch (IOException error) { error.printStackTrace(); }
        return null;
    }
    public static BufferedReader read(File path)
    {
        try { return new BufferedReader(new FileReader(path));}
        catch (IOException error) { error.printStackTrace(); }
        return null;
    }
}
