package core;

public class calefaccion implements serviciosAnadidos{

	private boolean calefaccion;
	public calefaccion (boolean calefaccion)
	{
		this.calefaccion=calefaccion;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (calefaccion) {
			return "si";
		}
		else
			return "no";
		
	}

	public String servicio() {
		// TODO Auto-generated method stub
		return "calefaccion";
	}

}