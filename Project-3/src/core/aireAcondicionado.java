package core;

public class aireAcondicionado implements serviciosAnadidos{

	private boolean Aire;
	public aireAcondicionado (boolean Aire)
	{
		this.Aire=Aire;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (Aire) {
			return "si";
		}
		else
			return "no";
		
	}


	@Override
	public String servicio() {
		// TODO Auto-generated method stub
		return "Aireacondicionado";
	}

}
