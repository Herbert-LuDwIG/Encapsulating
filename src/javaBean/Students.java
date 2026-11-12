package javaBean;

import java.io.Serializable;

public class Students implements Serializable{
	private static final long serialVersionUID = 6906485185789019165L;
	private String vards, uzvards, persKods, talr, studProg, aplNr;
	private int kurss = 1;
	private boolean valstsFin = false, sanemStip = false;
	
	public Students() {}
	
	// Get metodes
	public String getVards() {
		return vards;
	}
	
	public String getUzvards() {
		return uzvards;
	}
	
	public String getPersKods() {
		return persKods;
	}
	
	public String getTalr() {
		return talr;
	}
	
	public String getStudProg() {
		return studProg;
	}
	
	public String getAplNr() {
		return aplNr;
	}
	
	public int getKurss() {
		return kurss;
	}
	
	public boolean isValstsFin() {
		return valstsFin;
	}
	
	public boolean isSanemStip() {
		return sanemStip;
	}
	
	//Set metodes
	public void setVards(String vards) {
		this.vards = vards;
	}
	
	public void setUzvards(String uzvards) {
		this.uzvards = uzvards;
	}
	
	public void setPersKods(String persKods) {
		this.persKods = persKods;
	}
	
	public void setTalr(String talr) {
		this.talr = talr;
	}
	
	public void setStudProg(String studProg) {
		this.studProg = studProg;
	}
	
	public void setAplNr(String aplNr) {
		this.aplNr = aplNr;
	}
	
	public void setKurss(int kurss) {
		this.kurss = kurss;
	}
	
	public void setValstsFin(boolean valstsFin) {
		this.valstsFin = valstsFin;
	}
	
	public void setSanemStip(boolean sanemStip) {
		this.sanemStip = sanemStip;
	}
	
	// Metode priekš kārtošanas
}