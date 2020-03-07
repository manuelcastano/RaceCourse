package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Race {
	
	private Iqueue<HorseRider> horseRiders;
	private LinkedList<Bettor> bettors;
	
	public Race() {
		horseRiders = new Pqueue<HorseRider>();
		bettors = new LinkedList<Bettor>();
	}

	public Iqueue<HorseRider> getHorseRiders() {
		return horseRiders;
	}

	public void setHorseRiders(Iqueue<HorseRider> horseRiders) {
		this.horseRiders = horseRiders;
	}

	public LinkedList<Bettor> getBettors() {
		return bettors;
	}

	public void setBettors(LinkedList<Bettor> bettors) {
		this.bettors = bettors;
	}
	
	public void addHorseRider(HorseRider hr) {
		horseRiders.enqueue(hr);
	}
	
	public void addBettor(Bettor b) {
		bettors.add(b);
	}
	
	public void setPositions() {
		Iqueue<HorseRider> aux = new Pqueue<HorseRider>();
		int horses = horseRiders.size();
		ArrayList<Integer> positions = new ArrayList<>();
		while(!horseRiders.isEmpty()) {
			HorseRider hr = null;
			try {
				hr = horseRiders.dequeue();
			} catch (Exception e) {
				
			}
			boolean used = false;
			while(!used) {
				int position = (int)(Math.random()*horses + 1);
				for(int i = 0; i < positions.size() && !used; i++) {
					if(positions.get(i) == position) {
						used = true;
					}
				}
				if(used) {
					used = false;
				} else {
					hr.setPosition(position);
					positions.add(position);
					used = true;
				}
			}
			aux.enqueue(hr);
		}
		setHorseRiders(aux);
	}
	
	public boolean consultBet(String nit) {
		Bettor b = null;
		boolean finded = false;
		for(int i = 0; i < bettors.size() && !finded; i++) {
			if(bettors.get(i).getNit().equals(nit)) {
				b = bettors.get(i);
				finded = true;
			}
		}
		if(!finded) {
			return false;
		}
		String horseName = b.getHorse();
		boolean won = false;
		Iqueue<HorseRider> aux = new Pqueue<HorseRider>();
		while(!horseRiders.isEmpty()) {
			HorseRider hr = null;
			try {
				hr = horseRiders.dequeue();
			} catch (Exception e) {
				
			}
			if(hr.getHorseName().equals(horseName)) {
				if(hr.getPosition() == 1) {
					won = true;
				}
			}
			aux.enqueue(hr);
		}
		setHorseRiders(aux);
		return won;
	}
	
	public void rematch() {
		int last = horseRiders.size();
		Iqueue<HorseRider> aux = new Pqueue<HorseRider>();
		HorseRider[] hrs = new HorseRider[last];
		while(!horseRiders.isEmpty()) {
			HorseRider hr = null;
			try {
				hr = horseRiders.dequeue();
			} catch (Exception e) {
			}
			hrs[hr.getPosition()-1] = hr;
		}
		setHorseRiders(aux);
	}
}
