package ui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import model.Bettor;
import model.HorseRider;
import model.Race;
import threads.BetsThread;

public class Main {
	
	private Scanner reader;
	private Race race;

	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public Main() {
		reader = new Scanner(System.in);
		race = new Race();
		menu();
	}
	
	public void menu() {
		int option = 0;
		while(option != -1) {
			Queue<HorseRider> horses = race.getHorseRiders();
			Queue<HorseRider> aux = new LinkedList<HorseRider>();
			while(!horses.isEmpty()) {
				HorseRider hr = horses.poll();
				System.out.println(hr.toString());
				aux.offer(hr);
			}
			race.setHorseRiders(aux);
			if(race.getHorseRiders().size() == 10) {
				openBets();
				option = -1;
			} else {
				System.out.println("1. Add horse");
				System.out.println("2. Open bets");
				option = reader.nextInt();
				reader.nextLine();
				switch(option) {
				case 1:
					addHorse();
					break;
				case 2:
					if(race.getHorseRiders().size() > 6) {
						openBets();
						option = -1;
					}
					else {
						System.out.println("You can't open the bets yet");
					}
					break;
				default:
					System.out.println("Select a correct option");
					break;
				}
			}
		}
		while(option != 0) {
			System.out.println("0. Finish the race");
			System.out.println("1. Consult bet");
			System.out.println("2. Rematch");
			option = reader.nextInt();
			reader.nextLine();
			switch(option) {
			case 1:
				System.out.println("Bettor name:");
				String name = reader.nextLine();
				boolean won = race.consultBet(name);
				if(won) {
					System.out.println("Congratulations!, your horse won the race");
				} else {
					System.out.println("Your horse lose the race");
				}
				break;
			case 2:
				race.rematch();
				option = 0;
				break;
			case 0:
				break;
			default:
				System.out.println("Select a correct option");
				break;
			}
		}
	}
	
	public void addHorse() {
		System.out.println("Horse rider name:");
		String horseRiderName = reader.nextLine();
		System.out.println("Horse name");
		String horseName = reader.nextLine();
		HorseRider hr = new HorseRider(horseRiderName, horseName, race.getHorseRiders().size()+1, 0);
		race.addHorseRider(hr);
	}
	
	public void openBets() {
		System.out.println("Bets opened, you have 3 minutes to bet");
		Runnable betsThread = new BetsThread();
		Thread bets = new Thread(betsThread);
		bets.start();
		while(bets.isAlive()) {
			System.out.println("Bettor information:");
			System.out.println("Nit:");
			String nit = reader.nextLine();
			System.out.println("Name:");
			String name = reader.nextLine();
			System.out.println("Horse");
			String horse = reader.nextLine();
			System.out.println("Amount:");
			double amount = reader.nextDouble();
			reader.nextLine();
			Bettor b = new Bettor(nit, name, horse, amount);
			race.addBettor(b);
		}
		finishRace();
	}
	
	public void finishRace() {
		System.out.println("Race finished!");
		System.out.println("Podium");
		String podium = "";
		Queue<HorseRider> horses = race.getHorseRiders();
		Queue<HorseRider> aux = new LinkedList<HorseRider>();
		String theThree = "";
		while(!horses.isEmpty()) {
			HorseRider hr = horses.poll();
			if(hr.getPosition() == 1) {
				podium = "1. " + hr.getHorseName() + "\n" + podium;
			} else if(hr.getPosition() == 2) {
				podium += "2. " + hr.getHorseName() + "\n";
			} else if(hr.getPosition() == 3) {
				theThree = "3. " + hr.getHorseName();
			}
			aux.offer(hr);
		}
		race.setHorseRiders(aux);
		podium += theThree;
		System.out.println(podium);
	}
}
