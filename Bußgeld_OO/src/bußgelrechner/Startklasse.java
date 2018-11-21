package bußgelrechner;

import javax.swing.JOptionPane;

public class Startklasse {

	public static void main(String[] args) {
		
		try {
		
			Bußgeld B01 = new Bußgeld();
			
			B01.setGeschlecht(JOptionPane.showInputDialog("Geben Sie Ihr geschlecht an [W/M]"));
			B01.setName(JOptionPane.showInputDialog("Geben Sie ihren Namen an"));
			B01.setOrt((JOptionPane.showInputDialog("Haben Sie Geschwindigkeit Außerorts oder Innerorts überschritten?")));
			B01.setVerstoß(Integer.parseInt(JOptionPane.showInputDialog("Um wie Viel km/h haben Sie die Geschwindigkeit überschritten?")));
			
			//Ausgabe
			JOptionPane.showMessageDialog(null, "Sehr " + B01.abfrageG() + " " + B01.getName() + " Sie haben die Geschwindigkeit " + B01.getOrt() + " um " 
					+ B01.getVerstoß() + " km/h überschritten und erhalten ein Bußgeld in Höhe von " + B01.berechneBußgeld() + " €");
					
		} catch(Exception X) {
			System.out.println("Fehler");
		}
	}	
}	