package core;

public class camaTapetes implements serviciosAnadidos{

	private boolean camatapetes;
	public camaTapetes (boolean camatapetes)
	{
		this.camatapetes=camatapetes;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (camatapetes) {
			return "si";
		}
		else
			return "no";
		
	}
	public String servicio() {
		// TODO Auto-generated method stub
		return "tapetes";
	}

}