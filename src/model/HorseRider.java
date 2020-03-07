package model;

public class HorseRider {
	
	private String horseRiderName;
	private String horseName;
	private int track;
	private int position;
	
	public HorseRider(String horseRiderName, String horseName, int track, int position) {
		super();
		this.horseRiderName = horseRiderName;
		this.horseName = horseName;
		this.track = track;
		this.position = position;
	}

	public String getHorseRiderName() {
		return horseRiderName;
	}

	public void setHorseRiderName(String horseRiderName) {
		this.horseRiderName = horseRiderName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		String msg = "";
		msg += "Horse " + getTrack() + ":"+"\n";
		msg += "Horse rider name: " + getHorseRiderName()+"\n";
		msg += "Horse name: " + getHorseName()+"\n";
		msg += "Track: " + getTrack();
		return msg;
	}
}
