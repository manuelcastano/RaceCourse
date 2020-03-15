package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Bettor;
import model.HorseRider;
import model.Race;

class TestRace {
	private Race r;
	private void setage1() {
		Bettor b1 = new Bettor("1005", "mr.j", "caballito", 100);
		HorseRider h1 = new HorseRider("josue", "caballitp", 1, 1);
		r.addBettor(b1);
		r.addHorseRider(h1);
		
	}
	@Test
	void setPositions() {
		
	}

}
