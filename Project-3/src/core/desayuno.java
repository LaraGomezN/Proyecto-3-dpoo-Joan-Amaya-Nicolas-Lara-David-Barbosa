package core;

public class desayuno implements serviciosAnadidos{

	private boolean desayuno;
	public desayuno (boolean desayuno)
	{
		this.desayuno=desayuno;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (desayuno) {
			return "si";
		}
		else
			return "no";
	}
	
	public String servicio() {
		// TODO Auto-generated method stub
		return "desayuno";
	}

}