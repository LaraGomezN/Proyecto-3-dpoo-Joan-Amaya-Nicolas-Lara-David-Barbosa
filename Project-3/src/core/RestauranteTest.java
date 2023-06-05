package core;
import utils.Directory;
import utils.TimeRange;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RestauranteTest {
	
	
	TimeRange tiempo;
	Restaurant restaurante;
	Hotel hotel;
	Directory directorio;
	
	
	@BeforeEach
	void setUp()
	{
		String valor = "10:00:00-20:00:00";
		TimeRange tiempo= new TimeRange(valor);
		this.restaurante = new Restaurant(tiempo);
		this.hotel= new Hotel();
	}
	private void readfile() throws IOException
	{
		FileInputStream archivo = new FileInputStream("src/sources/sadd.txt");
		archivo.read();
		archivo.close();
	}
	@AfterEach
	void finisih()
	{}
	
	@Test
	//
	void prueba() throws IOException
	{
		File archivo = new File("src/sources/bebidas.txt");
		restaurante.loadDrinks(archivo);
	}
	
	@Test
	//prueba error en la carga 
	void prueba2() throws IOException
	{
		
	assertThrows(FileNotFoundException.class, () -> readfile());	
		
		
		;
		
	}


	@Test
	void prueba3() throws IOException
	{
		File archivo = new File("src/sources/platos.txt");
		restaurante.loadPlates(archivo);
	}
	@Test
	//carga de las habitaciones
	void prueba4() throws IOException {
		File archivo = new File("src/sources/rooms.txt");
		hotel.loadRooms(archivo);
	}
	@Test
	//crear directory exitosamente
	void prueba5()
	{
		directorio=new Directory("src/sources/usuarios.txt");
		
	}
	
	
	
	

}
