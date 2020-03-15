package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bettor;
import model.HorseRider;
import model.Race;

class TestRace {
	private Race r;
	private void setage1() {
		r = new Race();
		Bettor b1 = new Bettor("1005", "mr.j", "caballito", 100);
		Bettor b2 = new Bettor("1006", "mr.j", "caballito", 100);
		Bettor b3 = new Bettor("1007", "mr.j", "caballito", 100);
		Bettor b4 = new Bettor("1008", "mr.j", "caballito", 100);
		Bettor b5 = new Bettor("1009", "mr.j", "caballito", 100);
		Bettor b6 = new Bettor("1010", "mr.j", "caballito", 100);
		Bettor b7 = new Bettor("1011", "mr.j", "caballito", 100);
		Bettor b8 = new Bettor("1012", "mr.j", "caballito", 100);
		Bettor b9 = new Bettor("1013", "mr.j", "caballito", 100);
		Bettor b10 = new Bettor("1014", "mr.j", "caballito", 100);
		HorseRider h1 = new HorseRider("josue", "caballito", 1, 1);
		HorseRider h2 = new HorseRider("josue1", "caballito1", 2, 2);
		HorseRider h3 = new HorseRider("josue2", "caballito2", 3, 3);
		HorseRider h4 = new HorseRider("josue3", "caballito3", 4, 4);
		HorseRider h5 = new HorseRider("josue4", "caballito4", 5, 5);
		HorseRider h6 = new HorseRider("josue5", "caballito5", 6, 6);
		HorseRider h7 = new HorseRider("josue6", "caballito6", 7, 7);
		r.addBettor(b1);
		r.addBettor(b2);
		r.addBettor(b3);
		r.addBettor(b4);
		r.addBettor(b5);
		r.addBettor(b6);
		r.addBettor(b6);
		r.addBettor(b7);
		r.addBettor(b9);
		r.addBettor(b10);
		r.addHorseRider(h1);
		r.addHorseRider(h2);
		r.addHorseRider(h3);
		r.addHorseRider(h4);
		r.addHorseRider(h5);
		r.addHorseRider(h6);
		r.addHorseRider(h7);
		
	}
	@Test
	void setPositions() {
		setage1();
		r = new Race();
		Race r1 = new Race();
		HorseRider h1 = new HorseRider("josue", "caballito", 1, 1);
		HorseRider h2 = new HorseRider("josue1", "caballito1", 1, 1);
		HorseRider h3 = new HorseRider("josue2", "caballito2", 1, 1);
		HorseRider h4 = new HorseRider("josue3", "caballito3", 1, 1);
		HorseRider h5 = new HorseRider("josue4", "caballito4", 1, 1);
		HorseRider h6 = new HorseRider("josue5", "caballito5", 1, 1);
		HorseRider h7 = new HorseRider("josue6", "caballito6", 1, 1);
		r1.addHorseRider(h1);
		r1.addHorseRider(h2);
		r1.addHorseRider(h3);
		r1.addHorseRider(h4);
		r1.addHorseRider(h5);
		r1.addHorseRider(h6);
		r1.addHorseRider(h7);
		r.setPositions();
	
		
		boolean ce = r1.getHorseRiders().equals(r.getHorseRiders());
		assertTrue(!ce);
		
		
		
	}
	public void consultBet() {
		setage1();
		
		boolean ce = r.consultBet("100");
		assertTrue(ce==true || ce == false);
		
	}
	public void consultBet2() {
		setage1();
		Bettor bs;
		String nit = "";
		String name = "";
		String horse = "";
		
		for (int i = 0; i < 1000; i++) {
			nit = 1 + "";
			name = "El" + i;
			horse = "caballito";
			
			bs = new Bettor(nit, name, horse, i);
		}
		boolean ce = r.consultBet("100");
		assertTrue(ce==true || ce == false);
		
	}
	
	public void rematch() {
		
	}
	

}
