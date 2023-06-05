package core;

import utils.TimeRange;

import java.util.*;

public class Plate extends Service{
    public Plate(
            String name,
            double price,
            ArrayList<String> places,
            TimeRange range
    ){
        super(name, price, places, range);
        ArrayList<String> arrayList = new ArrayList<>(List.of("1,1,1,1,1,1".split(",")));
    }
    @Override
    public String toString() {
        return "Plate: " + super.toString();
    }
}
