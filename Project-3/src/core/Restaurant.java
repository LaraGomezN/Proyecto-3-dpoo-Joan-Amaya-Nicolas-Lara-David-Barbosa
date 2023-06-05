package core;

import utils.TimeRange;
import utils.Utils;

import java.io.*;
import java.util.*;

public class Restaurant {
    private final HashMap<String, Drink> _drinks;
    private final HashMap<String, Plate> _plates;
    private final HashMap<String, Integer> _totalsells;
    private final HashMap<String, Integer> _graphic;
    private final HashMap<String, Integer> _graphic2;
    private final TimeRange _range;
    public Restaurant(TimeRange range){
        _drinks = new HashMap<>();
        _plates = new HashMap<>();
        _totalsells=new HashMap<>();
        _range = range;
        _graphic = new HashMap<>();
        _graphic2 = new HashMap<>();
        
    }
    public void loadDrinks(File drinksFile) throws IOException {
        BufferedReader reader = Utils.read(drinksFile);
        assert reader != null;
        for (String row: reader.lines().toList()) {
            String[] line = row.split(";");
            _drinks.put(line[0], new Drink(line[0], Double.parseDouble(line[1]), new ArrayList<>(List.of(line[2].split(","))), new TimeRange(line[3], line[4])));
        }
        reader.close();
    }
    public void loadPlates(File platesFile) throws IOException {
        BufferedReader reader = Utils.read(platesFile);
        assert reader != null;
        for (String row: reader.lines().toList()) {
            String[] line = row.split(";");
            _plates.put(line[0], new Plate(line[0], Double.parseDouble(line[1]), new ArrayList<>(List.of(line[2].split(","))), new TimeRange(line[3], line[4])));
        }
        reader.close();
    }
    public void addproductsell(String product)
    {
    	if(_totalsells.get(product)==null)
    	{
    		_totalsells.put(product, 1);
    		
    	}
    	else {
    		int value = _totalsells.get(product);
    		value=value+1;
    		_totalsells.put(product, value);
    	}
    	
    }
    
    public void addplacesell(String place)
    {
    	if(_graphic2.get(place)==null)
    	{
    		_graphic2.put(place, 1);
    		
    	}
    	else {
    		int value = _graphic2.get(place);
    		value=value+1;
    		_graphic2.put(place, value);
    	}
    	
    }
    
    public void addPlates(String name, double Price, ArrayList<String> lugares, TimeRange rango )
    {
    	Plate dish= new Plate(name,Price,lugares,rango);
    	_plates.put(name, dish);
    	
    }
    public void addDrinks(String name, double Price, ArrayList<String> lugares, TimeRange rango )
    {
    	Drink drink= new Drink(name,Price,lugares,rango);
    	_drinks.put(name, drink);
    	
    }
    public boolean canSellDrinks(String name){
        return _range.rangeInRange(_drinks.get(name).timeRange());
    }
    public boolean canSellPlates(String name){
        return _range.rangeInRange(_plates.get(name).timeRange());
    }
    public HashMap<String, Drink> drinks(){
        return _drinks;
    }
    public HashMap<String, Integer> getTotalsells()
    {
    	return _totalsells;
    }
    public HashMap<String, Integer> getTotalplaces()
    {
    	return _graphic2;
    }
    
    public void addsells(String string)
    {
    	if (_graphic.get(string)==(null))
    	{
    		_graphic.put(string, 1);
    	}
    	else 
    	{
    		int value = _graphic.get(string);
    		value=value+1;
    		_graphic.put(string, value);
    	}
    	
    	
    }
    public  HashMap<String, Integer> getGraphic()
    {
    	return this._graphic;
    }
    
    
    public HashMap<String, Plate> plates(){
        return _plates;
    }
    public TimeRange timeRange(){
        return _range;
    }

}
