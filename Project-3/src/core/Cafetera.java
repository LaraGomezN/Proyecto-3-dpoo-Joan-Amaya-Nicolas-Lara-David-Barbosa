package core;

public class Cafetera implements serviciosAnadidos{

	private boolean cafetera;
	public Cafetera (boolean cafetera)
	{
		this.cafetera=cafetera;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (cafetera) {
			return "si";
		}
		else
			return "no";
		
	}

	
	public String servicio() {
		// TODO Auto-generated method stub
		return "cafetera";
	}

}