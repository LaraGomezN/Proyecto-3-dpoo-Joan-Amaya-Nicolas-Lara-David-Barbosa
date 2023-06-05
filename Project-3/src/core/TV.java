package core;

public class TV implements serviciosAnadidos{

	private boolean tv;
	public TV (boolean tv)
	{
		this.tv=tv;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (tv) {
			return "si";
		}
		else
			return "no";
	}
	
	public String servicio() {
		// TODO Auto-generated method stub
		return "TV";
	}

}