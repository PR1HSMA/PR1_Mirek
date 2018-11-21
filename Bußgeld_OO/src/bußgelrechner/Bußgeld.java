package bu�gelrechner;

public class Bu�geld {

	private int bu�geld;
	private double versto�;
	private String anrede;
	private String name;
	private String geschlecht;
	private String ort;

	public Bu�geld() {
		
		bu�geld = 0;
		versto� = 0;
		name = " ";
		geschlecht = " ";
	}

	public double getVersto�() {
		return versto�;
	}

	public void setVersto�(double versto�) {
		this.versto� = versto�;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public String abfrageG() {
		
		if (geschlecht.equalsIgnoreCase("w")) {
			String anrede = "geehrte Frau";
			return anrede;
			
		} else if (geschlecht.equals("m")) {
			String anrede = "geehrter Herr";
			return anrede;
			
		}
		return anrede;
	}
	
	public int berechneBu�geld() {
		
		if (ort.equalsIgnoreCase("innerorts")) {
			
			if ((versto� > 0 ) && (versto� <= 10)) {
				bu�geld = 15;
				
			} else if ((versto� >= 11) && (versto� <= 15)) {
				bu�geld = 25;
				 
			} else if ((versto� >= 16) && (versto� <= 20)) {
				bu�geld = 35;
				
			} else if ((versto� >= 21) && (versto� <= 25)) {
				bu�geld = 80;
				
			} else if ((versto� >= 26) && (versto� <= 30)){
				bu�geld = 100;
			
			} else if ((versto� >= 31) && (versto� <= 40)) {
				bu�geld = 160;

			} else if ((versto� >= 41) && (versto� <= 50)) {
				bu�geld = 200;
				
			} else if ((versto� >= 51) && (versto� <= 60)) {					
				bu�geld = 280;
				
			} else if ((versto� >= 60) && (versto� <= 70)) {
				bu�geld = 480;
				
			} else if (versto� > 70) {
				bu�geld = 680;
				
			}
			
		} 
		
		if (ort.equalsIgnoreCase("au�erorts")) {
			
			if ((versto� > 0 ) && (versto� <= 10)) {
				bu�geld = 10;
				
			} else if ((versto� >= 11) && (versto� <= 15)) {
				bu�geld = 20;
				 
			} else if ((versto� >= 16) && (versto� <= 20)) {
				bu�geld = 30;
				
			} else if ((versto� >= 21) && (versto� <= 25)) {
				bu�geld = 70;
				
			} else if ((versto� >= 26) && (versto� <= 30)){
				bu�geld = 80;
			
			} else if ((versto� >= 31) && (versto� <= 40)) {
				bu�geld = 120;

			} else if ((versto� >= 41) && (versto� <= 50)) {
				bu�geld = 160;
				
			} else if ((versto� >= 51) && (versto� <= 60)) {					
				bu�geld = 240;
				
			} else if ((versto� >= 60) && (versto� <= 70)) {
				bu�geld = 440;
				
			} else if (versto� > 70) {
				bu�geld = 600;
				
			}
			
		}
		
		return bu�geld;

	}
	
	
}


