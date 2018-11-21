package buﬂgelrechner;

public class Buﬂgeld {

	private int buﬂgeld;
	private double verstoﬂ;
	private String anrede;
	private String name;
	private String geschlecht;
	private String ort;

	public Buﬂgeld() {
		
		buﬂgeld = 0;
		verstoﬂ = 0;
		name = " ";
		geschlecht = " ";
	}

	public double getVerstoﬂ() {
		return verstoﬂ;
	}

	public void setVerstoﬂ(double verstoﬂ) {
		this.verstoﬂ = verstoﬂ;
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
	
	public int berechneBuﬂgeld() {
		
		if (ort.equalsIgnoreCase("innerorts")) {
			
			if ((verstoﬂ > 0 ) && (verstoﬂ <= 10)) {
				buﬂgeld = 15;
				
			} else if ((verstoﬂ >= 11) && (verstoﬂ <= 15)) {
				buﬂgeld = 25;
				 
			} else if ((verstoﬂ >= 16) && (verstoﬂ <= 20)) {
				buﬂgeld = 35;
				
			} else if ((verstoﬂ >= 21) && (verstoﬂ <= 25)) {
				buﬂgeld = 80;
				
			} else if ((verstoﬂ >= 26) && (verstoﬂ <= 30)){
				buﬂgeld = 100;
			
			} else if ((verstoﬂ >= 31) && (verstoﬂ <= 40)) {
				buﬂgeld = 160;

			} else if ((verstoﬂ >= 41) && (verstoﬂ <= 50)) {
				buﬂgeld = 200;
				
			} else if ((verstoﬂ >= 51) && (verstoﬂ <= 60)) {					
				buﬂgeld = 280;
				
			} else if ((verstoﬂ >= 60) && (verstoﬂ <= 70)) {
				buﬂgeld = 480;
				
			} else if (verstoﬂ > 70) {
				buﬂgeld = 680;
				
			}
			
		} 
		
		if (ort.equalsIgnoreCase("auﬂerorts")) {
			
			if ((verstoﬂ > 0 ) && (verstoﬂ <= 10)) {
				buﬂgeld = 10;
				
			} else if ((verstoﬂ >= 11) && (verstoﬂ <= 15)) {
				buﬂgeld = 20;
				 
			} else if ((verstoﬂ >= 16) && (verstoﬂ <= 20)) {
				buﬂgeld = 30;
				
			} else if ((verstoﬂ >= 21) && (verstoﬂ <= 25)) {
				buﬂgeld = 70;
				
			} else if ((verstoﬂ >= 26) && (verstoﬂ <= 30)){
				buﬂgeld = 80;
			
			} else if ((verstoﬂ >= 31) && (verstoﬂ <= 40)) {
				buﬂgeld = 120;

			} else if ((verstoﬂ >= 41) && (verstoﬂ <= 50)) {
				buﬂgeld = 160;
				
			} else if ((verstoﬂ >= 51) && (verstoﬂ <= 60)) {					
				buﬂgeld = 240;
				
			} else if ((verstoﬂ >= 60) && (verstoﬂ <= 70)) {
				buﬂgeld = 440;
				
			} else if (verstoﬂ > 70) {
				buﬂgeld = 600;
				
			}
			
		}
		
		return buﬂgeld;

	}
	
	
}


