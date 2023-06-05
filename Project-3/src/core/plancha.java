package core;

public class plancha implements serviciosAnadidos{

	private boolean plancha;
	public plancha (boolean plancha)
	{
		this.plancha=plancha;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (plancha) {
			return "si";
		}
		else
			return "no";
	}
	public String servicio() {
		// TODO Auto-generated method stub
		return "plancha";
	}

}