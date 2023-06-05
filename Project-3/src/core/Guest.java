package core;

import java.util.ArrayList;

public class Guest {
    private final ArrayList<Drink> _drinks;
    private final ArrayList<Plate> _plates;
    private final String _name;
    private final int _age;
    private final long _identificationCard;
    private final String _mail;
    private int _spaUsages;
    public Guest(
            String name,
            int age,
            long identificationCard,
            String mail
    ){
        _drinks = new ArrayList<>();
        _plates = new ArrayList<>();
        _name = name;
        _age = age;
        _identificationCard = identificationCard;
        _mail = mail;
        _spaUsages = 0;
    }
    public void addDrink(Drink service){
        _drinks.add(service);
    }
    public void addDPlate(Plate service){
        _plates.add(service);
    }
    public String bill(){
        String bill = "";
        double spend = 0;
        for (Drink drink: _drinks){
            bill = bill.concat(drink + "\n");
            spend += drink.price();
        }
        for (Plate plate: _plates){
            bill = bill.concat(plate + "\n");
            spend += plate.price();
        }
        bill = bill.concat("NET TOTAL: " + spend + "\n");
        bill = bill.concat("IVA :" + spend * 0.19d + "\n");
        bill = bill.concat("TOTAL :" + spend * 1.19d + "\n");
        return bill;
    }
    public String bill(Spa spa){
        String bill = "";
        double spend = 0;
        for (Drink drink: _drinks){
            bill = bill.concat(drink + "\n");
            spend += drink.price();
        }
        for (Plate plate: _plates){
            bill = bill.concat(plate + "\n");
            spend += plate.price();
        }
        spend += spa.price();
        bill = bill.concat(spa.toString());
        bill = bill.concat("NET TOTAL: " + spend + "\n");
        bill = bill.concat("IVA :" + spend * 0.19d + "\n");
        bill = bill.concat("TOTAL :" + spend * 1.19d + "\n");
        return bill;
    }
    public ArrayList<Drink> drinks(){
        return _drinks;
    }
    public ArrayList<Plate> plates(){
        return _plates;
    }
    public String name(){
        return _name;
    }
    public long identificationCard(){
        return _identificationCard;
    }
    public int spaUsages(){
        return _spaUsages;
    }
    public void addSpaUsage(){
        _spaUsages ++;
    }
    public void delSpaUsage(){
        _spaUsages --;
    }
    public double drinksConsumed(){
        double spend = 0d;
        for (Drink drink : _drinks)
            spend += drink.price();
        return spend * 1.19d;
    }
    public double platesConsumed(){
        double spend = 0d;
        for (Plate plate : _plates)
            spend += plate.price();
        return spend * 1.19d;
    }       
    public double totalconsumed() {
    	double value1= platesConsumed();
    	double value2= drinksConsumed();
    	double total= value1+value2;
    	return total;
    }   
    
    public int age(){
        return _age;
    }
    public String mail() {
        return _mail;
    }
    @Override
    public String toString() {
        return _name + ((_age >= 18) ? " CC: " : " TI: ") + _identificationCard + ", mail: " + _mail;
    }
}
