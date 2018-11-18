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
		boolean equal7;
		
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
					
					System.out.println("Befinden Sie sich noch in der Probezeit?");
					String probeZeit = sc.nextLine();
					
					//prüfe ob eingabe richtig ist
					equal7 = probeZeit.equalsIgnoreCase("j") || probeZeit.equalsIgnoreCase("n");
					//System.out.println(equal7);
					
				} while (equal7 == false);
				
				
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
					
						if (check.equalsIgnoreCase("n")){
							again = false;
							
						} else if (check.equalsIgnoreCase("j")){
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
			Double abzug = geschwindigkeit - toleranz;
			Double nachAbzug = abzug;
			return nachAbzug;
			
		} else {
			
			toleranz = 0.03;
			Double abzug = geschwindigkeit * toleranz;
			Double nachAbzug = geschwindigkeit - abzug;
			return nachAbzug;
		}
		
	}
	
	
	public void rechner(String ort, Double geschwindigkeit, int bußgeld, int punkte, int fahrverbot, Double nachAbzug, String anhänger, String fahrzeug, String probeZeit, String anzahl, Double abzug) {	
			
			try {
				
				//geschwindigkeitsüberschreitung nach toleranz 
				berechneToleranzAbzug();
				
				//für pkw, innerorts, ohne anhänger
				if (fahrzeug.equalsIgnoreCase("pkw") && (ort.equalsIgnoreCase("innerorts") && (anhänger.equalsIgnoreCase("n")))) {
					
					if ((nachAbzug > 0 ) && (nachAbzug <= 10)) {
						bußgeld = 15;
						
					} else if ((nachAbzug >= 11) && (nachAbzug <= 15)) {
						bußgeld = 25;
						 
					} else if ((nachAbzug >= 16) && (nachAbzug <= 20)) {
						bußgeld = 35;
						
					} else if ((nachAbzug >= 21) && (nachAbzug <= 25)) {
						bußgeld = 80;
						punkte = 1;
						
					} else if ((nachAbzug >= 26) && (nachAbzug <= 30) && (anzahl.equalsIgnoreCase("j"))){
						bußgeld = 100;
						punkte = 1;
					
					}  else if ((nachAbzug >= 26) && (nachAbzug <= 30) && (anzahl.equalsIgnoreCase("n"))) {
						bußgeld = 100;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
					
					} else if ((nachAbzug >= 31) && (nachAbzug <= 40)) {
						bußgeld = 160;
						punkte = 2;
						fahrverbot = 1; 
						
					} else if ((nachAbzug >= 41) && (nachAbzug <= 50)) {
						bußgeld = 200;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((nachAbzug >= 51) && (nachAbzug <= 60)) {					
						punkte = 2; 
						fahrverbot = 2;
						
					} else if ((nachAbzug >= 60) && (nachAbzug <= 70)) {
						bußgeld = 480;
						punkte = 2;
						fahrverbot = 3;
						
						
					} else if (nachAbzug > 70) {
						bußgeld = 680;
						punkte = 2;
						fahrverbot = 3;
						
					}
				}
				
				//für pkw, außerorts, ohne anhänger
				if (fahrzeug.equalsIgnoreCase("pkw") && (ort.equalsIgnoreCase("ausßerorts") && (anhänger.equalsIgnoreCase("n")))) {
					
					if ((nachAbzug > 0 ) && (nachAbzug <= 10)) {
						bußgeld = 10;
						
						
					} else if ((nachAbzug >= 11) && (nachAbzug <= 15)) {
						bußgeld = 20;
						 
					} else if ((nachAbzug >= 16) && (nachAbzug <= 20)) {
						bußgeld = 30;
						
					} else if ((nachAbzug >= 21) && (nachAbzug <= 25)) {
						bußgeld = 70;
						punkte = 1;
						
					} else if ((nachAbzug >= 26) && (nachAbzug <= 30) && (anzahl.equalsIgnoreCase("j"))){
						bußgeld = 80;
						punkte = 1;
						
					} else if ((nachAbzug >= 26) && (nachAbzug <= 30) && (anzahl.equalsIgnoreCase("n"))) {
						bußgeld = 80;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
						
					} else if ((nachAbzug >= 31) && (nachAbzug <= 40) && (anzahl.equalsIgnoreCase("j"))){
						bußgeld = 120;
						punkte = 1;
						
					} else if ((nachAbzug >= 31) && (nachAbzug <= 40) && (anzahl.equalsIgnoreCase("n"))){
						bußgeld = 120;
						punkte = 1;
						fahrverbot = 1; // wenn innherhalb 12 monate 2 mal
					
					} else if ((nachAbzug >= 41) && (nachAbzug <= 50)) {
						bußgeld = 160;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((nachAbzug >= 51) && (nachAbzug <= 60)) {
						bußgeld = 240;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((nachAbzug >= 60) && (nachAbzug <= 70)) {
						bußgeld = 440;
						punkte = 2;
						fahrverbot = 2;
						
					} else if (nachAbzug > 70) {
						bußgeld = 600;
						punkte = 2;
						fahrverbot = 3;
						
					}
				}
				
				//für lkw, innerorts oder pkw, innerorts, mit anhänger
				if ((fahrzeug.equalsIgnoreCase("lkw") && (ort.equalsIgnoreCase("innerorts"))) || (fahrzeug.equalsIgnoreCase("pkw") && (anhänger.equalsIgnoreCase("j") && (ort.equalsIgnoreCase("innerorts"))))){
								
					if ((nachAbzug > 0 ) && (nachAbzug <= 10)) {
						bußgeld = 20;
						
					} else if ((nachAbzug >= 11) && (nachAbzug <= 15)) {
						bußgeld = 30;
						 
					} else if ((nachAbzug >= 16) && (nachAbzug <= 20)) {
						bußgeld = 80;
						punkte = 1;
						
					} else if ((nachAbzug >= 21) && (nachAbzug <= 25)) {
						bußgeld = 95;
						punkte = 1;
						
					} else if ((nachAbzug >= 26) && (nachAbzug <= 30)){
						bußgeld = 140;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((nachAbzug >= 31) && (nachAbzug <= 40)){
						bußgeld = 200;
						punkte = 2;
						fahrverbot = 1; 
					
					} else if ((nachAbzug >= 41) && (nachAbzug <= 50)) {
						bußgeld = 280;
						punkte = 2;
						fahrverbot = 2;
						
					} else if ((nachAbzug >= 51) && (nachAbzug <= 60)) {
						bußgeld = 480;
						punkte = 2;
						fahrverbot = 3;
						
					} else if (nachAbzug > 70) {
						bußgeld = 680;
						punkte = 2;
						fahrverbot = 3;
						
					}
					
				}
				
				//für lkw, außerorts oder pkw, außerorts, mit anhänger
				if ((fahrzeug.equalsIgnoreCase("lkw") && (ort.equalsIgnoreCase("außerorts"))) || (fahrzeug.equalsIgnoreCase("pkw") && (anhänger.equalsIgnoreCase("j") && (ort.equalsIgnoreCase("außerorts"))))){
					
					if ((nachAbzug > 0 ) && (nachAbzug <= 10)) {
						bußgeld = 15;
						
					} else if ((nachAbzug >= 11) && (nachAbzug <= 15)) {
						bußgeld = 25;
						 
					} else if ((nachAbzug >= 16) && (nachAbzug <= 20)) {
						bußgeld = 70;
						punkte = 1;
						
					} else if ((nachAbzug >= 21) && (nachAbzug <= 25)) {
						bußgeld = 80;
						punkte = 1;
						
					} else if ((nachAbzug >= 26) && (nachAbzug <= 30)){
						bußgeld = 95;
						punkte = 1;
						
					} else if ((nachAbzug >= 31) && (nachAbzug <= 40)){
						bußgeld = 160;
						punkte = 2;
						fahrverbot = 1; 
					
					} else if ((nachAbzug >= 41) && (nachAbzug <= 50)) {
						bußgeld = 240;
						punkte = 2;
						fahrverbot = 1;
						
					} else if ((nachAbzug >= 51) && (nachAbzug <= 60)) {
						bußgeld = 440;
						punkte = 2;
						fahrverbot = 2;
						
					} else if (nachAbzug > 70) {
						bußgeld = 600;
						punkte = 2;
						fahrverbot = 3;
						
					}
				}
				
				//Ausgaben
				
				//Ausgabe führerschein entzug
				if (punkte == 8) {
					System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n "
							+ "davon wurden " + abzug + " km/h Toleranz abgezogen." + " Sie müssen ein Bußgeld von: " + bußgeld + 
							" € bezahlen, da Sie 8 Punkte haben wird Ihnen die Fahrerlaubnis entzogen");	
				}
				
				//Ausgabe für lkw / anhänger 
				
				//Ausgabe für pkw
				
				System.out.println("Sie haben, " + ort + " die Geschwindigkeit um, " + geschwindigkeit + " km/h überschritten. \n " 
						+ " Davon werden " + abzug + " km/h Toleranz abgezogen. \n" + "Sie müssen ein Bußgeld von: " + bußgeld + " € bezahlen");
				
				//Ausgabe probezeit
				if (probeZeit.equalsIgnoreCase("j") && (bußgeld >= 60)) {
					System.out.println("Zusätzlich wurde Ihre Probezeit um weitere 2 Jahre verlängert !");
				}
				
				if (probeZeit.equalsIgnoreCase("j") && (nachAbzug >= 20)) {
					System.out.println("Ihre Probezeit wird um 2 Jahre verlängert, zusätzlich wird Ihnen ein Aufbauseminar angeordnet !");
				}
				
				if (probeZeit.equalsIgnoreCase("j") && (anzahl.equalsIgnoreCase("n") && (nachAbzug >= 20))) {
					System.out.println("Ihnen wird die Fahrerlaubnis entzogen !");
				}
				
				
			
			} catch (Exception X) {
				System.out.println("Fehler");
			}
	}
}