package core;

public class voltajeAC implements serviciosAnadidos{

	private boolean voltaje;
	public voltajeAC (boolean voltaje)
	{
		this.voltaje=voltaje;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (voltaje) {
			return " es de 120 V Ac";
		}
		else
			return " es de 240 V Ac";
	}
	public String servicio() {
		// TODO Auto-generated method stub
		return "votaje";
	}

}