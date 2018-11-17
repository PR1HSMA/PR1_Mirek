import java.util.Scanner;

public class Bußgeldkatalog {

	public static void main(String[] args) {
		
		//variablen anlegen
		int bußgeld = 0 ;
		int punkte = 0;
		int fahrverbot = 0;
		double toleranz = 0.03;
		boolean again = true;
		boolean wdh = false;
		boolean equal1;
		boolean equal2;
		boolean equal3;
		boolean equal4;
		boolean equal5;
		boolean equal6;
		
		//Array für geschwindigkeit
		Double [] Vmax = new Double[2000];
		double wert = 1;
		
		
		try {
			
			System.out.println("-----------------------------------------------");
			System.out.println("#####-Bußgeldrechner-#####");
			System.out.println("-----------------------------------------------");
		
			Scanner sc = new Scanner(System.in);
			
			while (again) {
				
				//Array füllen
				for (int i = 0; i < Vmax.length; i++) {
					
					Vmax [i] = wert;
					wert = wert + 0.1;
					//System.out.println(Vmax[i]);
				}
				
				do {
					
					System.out.println("Fahren sie einen PKW oder einen LKW ?");
					String fahrzeug = sc.nextLine();
					
					//prüfe ob richtige eingabe
					equal5 = fahrzeug.equalsIgnoreCase("pkw") || fahrzeug.equalsIgnoreCase("lkw");	
					//System.out.println(equal5);
					
					do {
						
						if (fahrzeug.equalsIgnoreCase("pkw")) {
							
							System.out.println("Hatten Sie einen Anhänger an ihrem Auto ?");
							String anhänger = sc.nextLine();
							
							equal6 = fahrzeug.equalsIgnoreCase("j") || fahrzeug.equalsIgnoreCase("n");	
							//System.out.println(equal6);
							
						} else {
							String anhänger = "N";
						}
						
					} while (equal6 == false);
					
				} while (equal5 == false);
				
				do {
					
					//nur bei erstem durchlauf 
					if (wdh == false) {
						
						//Prüfe ob eingabe j ode n ist
						System.out.println("Ist dies Ihr erster Verstoß innerhalb der letzten 12 Monate ? (J/N)");
						String anzahl = sc.nextLine();
						
						equal1 = anzahl.equalsIgnoreCase("j") || anzahl.equalsIgnoreCase("n");	
						//System.out.println(equal1);
					}
					
				} while (equal1 == false);	
				
				do {
					
					//Prüfe ob eingabe innerorts oder außerorts ist
					System.out.println("Wurde die Geschwindigkeit innerorts oder außerorts überschritten?");
					String ort = sc.nextLine();
					
					equal2 = ort.equalsIgnoreCase("innerorts") || ort.equalsIgnoreCase("außerorts");	
					//System.out.println(equal2);
						
				} while(equal2 == false);
				
				do {
					
					System.out.println("Um wie viel km/h wurde die Geschwindigkeit überschritten? ");
					double geschwindigkeit = Double.parseDouble(sc.nextLine());
					
						//Prüfen ob eingabe eine Zahl bzw in Array ist
						if (geschwindigkeit) {
							equal4 = true;
							
						} else {
							equal4 = false;
						}
					
					//System.out.println(equal4);
					System.out.println("Ihre Eingabe ist keine Zahl oder sie ist zu groß, bitte wiederholen Sie Ihre Eingabe !");
				
				} while (equal4 == false);
					
				//System.out.println(rechner());
				
				do {
					
					//Prüfe ob eingabe j oder n ist
					System.out.println("Wollen Sie eine weiteres Bußgeld berechnen lassen?  [j / n]");
					String check = sc.nextLine();
					
					equal3 = check.equalsIgnoreCase("j") || check.equalsIgnoreCase("n");	
					//System.out.println(equal3);
					
						if (check.equals("N") || (check.equals("n"))){
							again = false;
							
						} else if (check.equals("J") || (check.equals("j"))){
							again = true;
							wdh = true;
							String anzahl = "N";
							
						} else {
							System.out.println("Falsche Eingabe zur Wiederholung");
							again = true;
							wdh = false;
						}
					
				} while (equal3 == false);

			}
			
			System.out.println("Auf Wiedersehen");
			sc.close();
			
		} catch (Exception X) {
			System.out.println("catch");
		}
	}
	
	public Double berechneToleranzAbzug(Double geschwindigkeit, Double toleranz) {
		
		if (geschwindigkeit <= 100 ) {
			
			toleranz = 3.0;
			Double nachAbzug = geschwindigkeit - toleranz;
			return nachAbzug;
			
		} else {
			
			toleranz = 0.03;
			Double abzug = geschwindigkeit * toleranz;
			Double nachAbzug = geschwindigkeit - abzug;
			return nachAbzug;
		}
		
	}
	
	
	public void rechner(String ort, Double geschwindigkeit, int bußgeld, int punkte, int fahrverbot) {	
			
			try {
			
				if (ort.equals("innerorts") || (ort.equals("Innerorts"))) {
					
					if ((geschwindigkeit > 0 ) && (geschwindigkeit <= 10)) {
						bußgeld = 15;
						
					} else if ((geschwindigkeit >= 11) && (geschwindigkeit <= 15)) {
						bußgeld = 25;
						 
					} else if ((geschwindigkeit >= 16) && (geschwindigkeit <= 20)) {
						bußgeld = 35;
						
					} else if ((geschwindigkeit >= 21) && (geschwindigkeit <= 25)) {
						bußgeld = 80;
						punkte = 1;
						
					} else if ((geschwindigkeit >= 26) && (geschwindigkeit <= 30)) {
						bußgeld = 100;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
						
					} else if ((geschwindigkeit >= 31) && (geschwindigkeit <= 40)) {
						bußgeld = 160;
						punkte = 2;
						fahrverbot = 1; 
						
					} else if ((geschwindigkeit >= 41) && (geschwindigkeit <= 50)) {
						bußgeld = 200;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((geschwindigkeit >= 51) && (geschwindigkeit <= 60)) {					
						punkte = 2; 
						fahrverbot = 2;
						
					} else if ((geschwindigkeit >= 60) && (geschwindigkeit <= 70)) {
						bußgeld = 480;
						punkte = 2;
						fahrverbot = 3;
						
						
					} else if (geschwindigkeit > 70) {
						bußgeld = 680;
						punkte = 2;
						fahrverbot = 3;
						
					}
					
				}
				
				if (ort.equals("Außerorts") || (ort.equals("außerorts") || (ort.equals("Auserorts") || (ort.equals("Auserorts"))))) {
					
					if ((geschwindigkeit > 0 ) && (geschwindigkeit <= 10)) {
						bußgeld = 10;
						
						
					} else if ((geschwindigkeit >= 11) && (geschwindigkeit <= 15)) {
						bußgeld = 20;
						 
					} else if ((geschwindigkeit >= 16) && (geschwindigkeit <= 20)) {
						bußgeld = 30;
						
					} else if ((geschwindigkeit >= 21) && (geschwindigkeit <= 25)) {
						bußgeld = 70;
						punkte = 1;
						
					} else if ((geschwindigkeit >= 26) && (geschwindigkeit <= 30)) {
						bußgeld = 80;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
						
					} else if ((geschwindigkeit >= 31) && (geschwindigkeit <= 40)) {
						bußgeld = 120;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
						
					} else if ((geschwindigkeit >= 41) && (geschwindigkeit <= 50)) {
						bußgeld = 160;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((geschwindigkeit >= 51) && (geschwindigkeit <= 60)) {
						bußgeld = 240;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((geschwindigkeit >= 60) && (geschwindigkeit <= 70)) {
						bußgeld = 440;
						punkte = 2;
						fahrverbot = 2;
						
					} else if (geschwindigkeit > 70) {
						bußgeld = 600;
						punkte = 2;
						fahrverbot = 3;
						
					}
				}
				
				//Ausgaben
				if (punkte == 8) {
					System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n "
							+ "Sie müssen ein Bußgeld von: " + bußgeld + " € bezahlen, da Sie 8 Punkte haben wird Ihnen die Fahrerlaubnis entzogen");	
				} 
				
				if ((geschwindigkeit >= 21) && (geschwindigkeit <= 25)) {
					System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n "
							+ "Sie müssen ein Bußgeld von: " + bußgeld + " € bezahlen, zusätzlich erhalten Sie " + punkte + "Punkt");
				
				} 
				
				else if (geschwindigkeit >=26 ) {
					System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n "
							+ "Sie müssen ein Bußgeld von: " + bußgeld + " € bezahlen, zusätzlich erhalten Sie " + punkte + " Punkt und ein Fahrverbot von " 
							+ fahrverbot + " Monaten");
					
				} else {
					System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n "
							+ "Sie müssen ein Bußgeld von: " + bußgeld + " € bezahlen");	
				}
				
			} catch (Exception X) {
				System.out.println("Fehler");
			}
	}
}