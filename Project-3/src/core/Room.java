package core;

import utils.DateRange;

import java.util.*;

public class Room {
    private final static ArrayList<Long> ids = new ArrayList<>();
    private final long _id;
    private boolean _reserved;
    private double _price;
    private final int _maxOccupancy;
    private Object[] _datePrice;
    private final String _type;
    private ArrayList<serviciosAnadidos> _services;
    private int metros;
    private final HashMap<Long, Guest> _occupants;
    private final HashMap<String, DateRange> _occupancyDateRange;
    public Room(double price, int maxOccupancy, String type){
        long id = (long) (Math.random() * 1_000_000_000);
        while (Room.ids.contains(id)) {
            id = (long) (Math.random() * 1_000_000_000);
        }
        Room.ids.add(id);
        _id = id;
        _reserved = false;
        _price = price;
        _maxOccupancy = maxOccupancy;
        _datePrice = new Object[]{null, null};
        _type = type;
        metros = (int) (Math.random() * 10);
        _occupants = new HashMap<>();
        _occupancyDateRange = new HashMap<>();
        _services=new ArrayList<>();
    }
    public long id(){
        return _id;
    }
    public boolean isReserved(){
        return _reserved;
    }
    public void setReserved(boolean reserved){
        _reserved = reserved;
    }
    public int metroscuadrados()
    {
    	return metros;
    }
    public double price(){
        return _price;
    }
    public double price(DateRange dateRange){
        if (_datePrice[0] == null)
            return _price;
        else if (((DateRange) _datePrice[1]).inRange(dateRange))
            return (double) _datePrice[1];
        return _price;
    }
    public void setPrice(DateRange dateRange, double price){
        _datePrice[0] = dateRange;
        _datePrice[1] = price;
    }
    public void setPrice(double price){
        _price = price;
    }
    public void addRange(DateRange dateRange){
        _occupancyDateRange.put(dateRange.toString(), dateRange);
    }
    public int maxOccupancy(){
        return _maxOccupancy;
    }
    public String type(){
        return _type;
    }
    public ArrayList<Guest> occupants(){
        return new ArrayList<>(_occupants.values());
    }
    public ArrayList<DateRange> occupancyRanges(){
        return new ArrayList<>(_occupancyDateRange.values());
    }
    public boolean reserve(DateRange timeRange, Guest ... guests){
        for (DateRange occupied: occupancyRanges())
            if (occupied.inRange(timeRange))
                return false;
        if (guests.length > _maxOccupancy)
            return false;
        while (canAddOccupant())
            for (Guest guest: guests)
                _occupants.put(guest.identificationCard(), guest);
        return true;
    }
    public boolean canAddOccupant(){
        return _occupants.size() < _maxOccupancy;
    }
    public void addService(serviciosAnadidos servicios) {
    	_services.add(servicios);
    }
    public ArrayList<serviciosAnadidos> GetServices()
    {
    	return _services;
    }
    public void addOccupant(Guest guest){
        _occupants.put(guest.identificationCard(), guest);
    }
    @Override
    public String toString(){
        return "Room id: " + _id + ", type: " + _type + ", base price: " + _price + ", max occupancy: " + _maxOccupancy + ", occupants" + Arrays.toString(_occupants.values().toArray());
    }
}
