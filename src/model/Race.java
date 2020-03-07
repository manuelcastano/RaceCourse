package model;

import java.util.ArrayList;
import java.util.Stack;

public class Race {
	
	private Iqueue<HorseRider> horseRiders;
	private HashTable<Bettor> bettors;
	
	public Race() {
		horseRiders = new Pqueue<HorseRider>();
		bettors = new HashTable<Bettor>();
	}

	public Iqueue<HorseRider> getHorseRiders() {
		return horseRiders;
	}

	public void setHorseRiders(Iqueue<HorseRider> horseRiders) {
		this.horseRiders = horseRiders;
	}

	public HashTable<Bettor> getBettors() {
		return bettors;
	}

	public void setBettors(HashTable<Bettor> bettors) {
		this.bettors = bettors;
	}
	
	public void addHorseRider(HorseRider hr) {
		horseRiders.enqueue(hr);
	}
	
	public void addBettor(Bettor b) {
		bettors.insert(b, b.getNit());
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
		Bettor b = bettors.search(nit);
		if(b == null) {
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
		bettors = new HashTable<Bettor>();
		int last = horseRiders.size();
		int tracks = 1;
		Stack<HorseRider> st = new Stack<HorseRider>();
		Iqueue<HorseRider> queue = new Pqueue<HorseRider>();
		boolean finished = false;
		while(!finished) {
			while(!horseRiders.isEmpty()) {
				HorseRider hr = null;
				try {
					hr = horseRiders.dequeue();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(hr.getPosition() == last) {
					queue.enqueue(hr);
					hr.setTrack(tracks);
					tracks++;
					last--;
				} else {
					st.push(hr);
				}
			} if(!st.isEmpty()) {
				while(!st.isEmpty()) {
					HorseRider hr = st.pop();
					if(hr.getPosition() == last) {
						queue.enqueue(hr);
						hr.setTrack(tracks);
						tracks++;
						last--;
					} else {
						horseRiders.enqueue(hr);
					}
				}
			}
			if(st.isEmpty() && horseRiders.isEmpty()) {
				finished = true;
			}
		}
		horseRiders = queue;
	}
}
