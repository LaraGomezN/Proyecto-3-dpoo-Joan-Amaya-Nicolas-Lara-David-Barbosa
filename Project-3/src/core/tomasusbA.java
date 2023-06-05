package core;

public class tomasusbA implements serviciosAnadidos{

	private boolean usb;
	public tomasusbA (boolean usb)
	{
		this.usb=usb;
	}
	
	
	public String estaPresente() {
		// TODO Auto-generated method stub
		if (usb) {
			return "si";
		}
		else
			return "no";
	}
	public String servicio() {
		// TODO Auto-generated method stub
		return "UsbA";
	}

}