package bu�gelrechner;

import javax.swing.JOptionPane;

public class Startklasse {

	public static void main(String[] args) {
		
		try {
		
			Bu�geld B01 = new Bu�geld();
			
			B01.setGeschlecht(JOptionPane.showInputDialog("Geben Sie Ihr geschlecht an [W/M]"));
			B01.setName(JOptionPane.showInputDialog("Geben Sie ihren Namen an"));
			B01.setOrt((JOptionPane.showInputDialog("Haben Sie Geschwindigkeit Au�erorts oder Innerorts �berschritten?")));
			B01.setVersto�(Integer.parseInt(JOptionPane.showInputDialog("Um wie Viel km/h haben Sie die Geschwindigkeit �berschritten?")));
			
			//Ausgabe
			JOptionPane.showMessageDialog(null, "Sehr " + B01.abfrageG() + " " + B01.getName() + " Sie haben die Geschwindigkeit " + B01.getOrt() + " um " 
					+ B01.getVersto�() + " km/h �berschritten und erhalten ein Bu�geld in H�he von " + B01.berechneBu�geld() + " �");
					
		} catch(Exception X) {
			System.out.println("Fehler");
		}
	}	
}	