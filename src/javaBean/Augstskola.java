package javaBean;

import javax.swing.JOptionPane;

public class Augstskola {

	public static void main(String[] args) {
		String izvelne, fNosaukums = "studenti.ser";
		String[] darbibas = {"Jauns students", "Noņemt studentu", "Meklēt studentu", "Studentu saraksts", "Kārtot", 
				"Budžeta vietas", "Stipendijas", "Aizvērt programmu"};
		String[] programmas = {"Uzņēmējdarbība un vadīšana", "Datorsistēmas", 
				"Mehatronika", "Elektrotehnoloģiju datorvadība"};
		Integer[] kurss = {1, 2, 3, 4, 5};
		String[] atb = {"Jā", "Nē"};
	
		int studSk = Metodes.skaitlaParbaude("Cik studentus uzglabāsi?", 2, 1000);
		Students[] studentuMas = new Students[studSk];
		Students persona = null;
		
		//Izsaukt deserializāciju
		int id = 0;
		
		do {
			izvelne = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbības izvēle", 
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			if (izvelne == null)
				izvelne = darbibas[darbibas.length-1];
			
			switch(izvelne) {
			// case Jauns students
			case "Jauns students" :
				
				persona = new Students();
				String vards = Metodes.virknesParbaude("Studenta vārds: ", "Pēteris");
				if (vards == null)
					break;
				persona.setVards(vards);
				
				String uzvards = Metodes.virknesParbaude("Studenta uzvārds: ", "Zariņš");
				if (uzvards == null)
					break;
				persona.setUzvards(uzvards);
				
				String persKods = Metodes.pkParbaude("Studenta personas kods: ", "000000-00000");
				if (persKods == null)
					break;
				persona.setPersKods(persKods);
				
				String talr = Metodes.talrParbaude("Studenta tēlruņa nr.: ", "20000000");
				if (talr == null)
					break;
				persona.setTalr(talr);
				
				String studProg = (String) JOptionPane.showInputDialog(null, "Izvēlies studiju programmu", "Studiju programmas izvēle", 
						JOptionPane.QUESTION_MESSAGE, null, programmas, programmas[0]);
				if (studProg == null)
					break;
				persona.setStudProg(studProg);
				
				persona.setAplNr(Metodes.generetNr());
				
				Integer studKurss =(Integer) JOptionPane.showInputDialog(null, "Izvēlies kursu", "Kursa izvēle", 
						JOptionPane.QUESTION_MESSAGE, null, kurss, kurss[0]);
				if (studKurss == null)
					break;
				persona.setKurss(studKurss);
				
				if(JOptionPane.showInputDialog(null, "Vai jāmaksā par studijām?", "Valsts finansējums",
						JOptionPane.QUESTION_MESSAGE, null, atb, atb[0]).equals("Jā"))
					persona.setValstsFin(false);
				else
					persona.setValstsFin(true);
				
				if(JOptionPane.showInputDialog(null, "Vai saņem stipendiju?", "Stipendija",
						JOptionPane.QUESTION_MESSAGE, null, atb, atb[0]).equals("Jā"))
					persona.setSanemStip(true);
				else
					persona.setSanemStip(false);
				
				if(id < studentuMas.length) {
					studentuMas[id] = persona;
					id++;
				} else {
					JOptionPane.showMessageDialog(null, "Nevari vairs pievienot jaunu studentu (masīvā nav brīvu vietu)!", 
							"Kļūda", JOptionPane.ERROR_MESSAGE);
				}
				
				break;
				// case Noņemt studentu
			case "Noņemt studentu" :
				int kuruDzest = Metodes.meklet(studentuMas, JOptionPane.showInputDialog(null, "Apliecības nr.: "));
				
				if(kuruDzest != -1) {
					studentuMas[kuruDzest] = null;
					JOptionPane.showMessageDialog(null, "Students dzēsts!", "Paziņojums", JOptionPane.WARNING_MESSAGE);
				}
				
				
				break;
				
				//case Meklēt studentu
			case "Meklēt studentu": 
				int kuruAtrast = Metodes.meklet(studentuMas, JOptionPane.showInputDialog(null, "Apliecības nr.: "));
				if(kuruAtrast != -1) {
					JOptionPane.showMessageDialog(null, 
							"Students: " + studentuMas[kuruAtrast].getVards() + " " + studentuMas[kuruAtrast].getUzvards() 
							+ "\nStudenta apliecības nr.: " + studentuMas[kuruAtrast].getAplNr()
							+ "\nTālrunis: " + studentuMas[kuruAtrast].getTalr()
							+ "\nPersonas kods: " + studentuMas[kuruAtrast].getPersKods()
							+ "\nStudiju programma: " + studentuMas[kuruAtrast].getStudProg() + " kurss: " + studentuMas[kuruAtrast].getKurss()
							+ "\nValsts finansējums: " + studentuMas[kuruAtrast].isValstsFin()
							+ "\nSaņem stipensiju: " + studentuMas[kuruAtrast].isSanemStip());
				}
				break;
				
			case "Studentu saraksts":
				Metodes.select(studentuMas);
				break;
				
			case "Aizvērt programmu":
				JOptionPane.showMessageDialog(null, "Bye!", "Bye!", JOptionPane.PLAIN_MESSAGE);
				
				Serializacija.Serializet(studentuMas, fNosaukums);
				
				break;
			}// switch
		} while(!izvelne.equals(darbibas[darbibas.length-1]));

	}

}