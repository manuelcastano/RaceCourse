package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Race {
	
	private Queue<HorseRider> horseRiders;
	private LinkedList<Bettor> bettors;
	
	public Race() {
		horseRiders = new LinkedList<HorseRider>();
		bettors = new LinkedList<Bettor>();
	}

	public Queue<HorseRider> getHorseRiders() {
		return horseRiders;
	}

	public void setHorseRiders(Queue<HorseRider> horseRiders) {
		this.horseRiders = horseRiders;
	}

	public LinkedList<Bettor> getBettors() {
		return bettors;
	}

	public void setBettors(LinkedList<Bettor> bettors) {
		this.bettors = bettors;
	}
	
	public void addHorseRider(HorseRider hr) {
		horseRiders.offer(hr);
	}
	
	public void addBettor(Bettor b) {
		bettors.add(b);
	}
	
	public void setPositions() {
		Queue<HorseRider> aux = new LinkedList<HorseRider>();
		int horses = horseRiders.size();
		ArrayList<Integer> positions = new ArrayList<>();
		while(!horseRiders.isEmpty()) {
			HorseRider hr = horseRiders.poll();
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
				}
			}
			aux.offer(hr);
		}
		setHorseRiders(aux);
	}
	
	public boolean consultBet(String name) {
		Bettor b = null;
		boolean finded = false;
		for(int i = 0; i < bettors.size() && !finded; i++) {
			if(bettors.get(i).getName().equals(name)) {
				b = bettors.get(i);
				finded = true;
			}
		}
		if(!finded) {
			return false;
		}
		String horseName = b.getHorse();
		boolean won = false;
		Queue<HorseRider> aux = new LinkedList<HorseRider>();
		while(!horseRiders.isEmpty()) {
			HorseRider hr = horseRiders.poll();
			if(hr.getHorseName().equals(horseName)) {
				if(hr.getPosition() == 1) {
					won = true;
				}
			}
			aux.offer(hr);
		}
		setHorseRiders(aux);
		return won;
	}
	
	public void rematch() {
		int last = horseRiders.size();
		Queue<HorseRider> aux = new LinkedList<HorseRider>();
		HorseRider[] hrs = new HorseRider[last];
		while(!horseRiders.isEmpty()) {
			HorseRider hr = horseRiders.poll();
			hrs[hr.getPosition()-1] = hr;
		}
		
		setHorseRiders(aux);
	}
}
