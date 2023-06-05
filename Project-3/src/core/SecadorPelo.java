package core;

public class SecadorPelo implements serviciosAnadidos{

	private boolean secador;
	public SecadorPelo (boolean secador)
	{
		this.secador=secador;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (secador) {
			return "si";
		}
		else
			return "no";
	}
	public String servicio() {
		// TODO Auto-generated method stub
		return "secador";
	}

}