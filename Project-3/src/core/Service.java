package core;

import utils.TimeRange;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Service {
    private final String _name;
    private double _price;
    private final ArrayList<String> _places;
    private final TimeRange _range;
    public Service(
            String name,
            double price,
            ArrayList<String> places,
            TimeRange range
    ){
        _name = name;
        _price = price;
        _places = places;
        _range = range;
    }
    public String name(){
        return _name;
    }
    public double price(){
        return _price;
    }
    public void setPrice(double price){
        _price = price;
    }
    public ArrayList<String> places(){
        return _places;
    }
    public TimeRange timeRange(){
        return _range;
    }
    @Override
    public String toString() {
        return _name + ", $" + _price + ", places: " + Arrays.toString(_places.toArray()) + ", available schedules: " + _range;
    }
}
