package core;

import java.util.*;
import java.io.*;

public class Hotel {
    private final HashMap<Long, Room> _rooms;
    public Hotel(){
        _rooms = new HashMap<>();
    }
    public void loadRooms(File rooms) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(rooms));
        for (String row: reader.lines().toList()){
            String[] line = row.split(";");

            
            
            Room room = new Room(Double.parseDouble(line[0]), Integer.parseInt(line[1]), line[2]);
            Cafetera cafetera= new Cafetera(Boolean.parseBoolean(line[3]));
            room.addService(cafetera);
            calefaccion calefaccion= new calefaccion(Boolean.parseBoolean(line[4]));
            room.addService(calefaccion);
            camaTapetes camaTapetes= new camaTapetes(Boolean.parseBoolean(line[5]));
            room.addService(camaTapetes);
            desayuno desayuno= new desayuno(Boolean.parseBoolean(line[6]));
            room.addService(desayuno);
            plancha plancha= new plancha(Boolean.parseBoolean(line[7]));
            room.addService(plancha);
            SecadorPelo SecadorPelo= new SecadorPelo(Boolean.parseBoolean(line[8]));
            room.addService(SecadorPelo);
            tomasusbA tomasusbA= new tomasusbA(Boolean.parseBoolean(line[9]));
            room.addService(tomasusbA);
            tomasusbC tomasusbC= new tomasusbC(Boolean.parseBoolean(line[10]));
            room.addService(tomasusbC);
            TV TV= new TV(Boolean.parseBoolean(line[12]));
            room.addService(TV);
            voltajeAC voltajeAC= new voltajeAC(Boolean.parseBoolean(line[13]));
            room.addService(voltajeAC);
            aireAcondicionado aireAcondicionado= new aireAcondicionado(Boolean.parseBoolean(line[14]));
            room.addService(aireAcondicionado);
            
            _rooms.put(room.id(), room);
        }
        reader.close();
    }
    public HashMap<Long, Room> rooms(){
        return _rooms;
    }


}
