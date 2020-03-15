package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Bettor;
import model.HorseRider;
import model.Race;
import threads.BetsThread;

public class Controller {
	@FXML
	private Label LH;
	@FXML
	private Button b1;
	private HBox hb;
	private VBox v;
	private TextArea t1;
	private TextArea t2;
	private TextArea t3;
	private TextArea t4;
	private Race race;

	public Controller() {
		hb = new HBox();
		v = new VBox();
		race = new Race();
	}

	public void Start( GridPane a) {
		v = new VBox();
		t1=new TextArea("Name");
		t2 = new TextArea("Horse name");
		LH = new Label("None");
		b1 = new Button("Add Bettor");
		Button add = new Button("Add");
		a.getChildren().add(hb);
		hb.getChildren().add(v);
		hb.getChildren().add(LH);
		hb.getChildren().add(b1);
		v.getChildren().add(t1);
		v.getChildren().add(t2);
		v.getChildren().add(add);
		b1.setOnAction(e->{if((race.getHorseRiders().size()<=10)&&race.getHorseRiders().size()>=7) {
			addBettor(add, t1, t2, v);
		}	
		});
		add.setOnAction(e->{
			HorseRider hr = new HorseRider(t1.getText(), t2.getText(), race.getHorseRiders().size()+1, 0);
			race.addHorseRider(hr);
			try {
				LH.setText(race.show());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}

	public void addBettor(Button a, TextArea r1, TextArea r2, VBox v1) {
		Runnable betsThread = new BetsThread();
		Thread bets = new Thread(betsThread);
		bets.start();
		v1.getChildren().clear();
		t1.setText("Nit");
		t2.setText("Name");
		t3 = new TextArea("HorseRider");
		t4 = new TextArea("Amount");
		v1.getChildren().add(t1);
		v1.getChildren().add(t2);
		v1.getChildren().add(t3);
		v1.getChildren().add(t4);
		v1.getChildren().add(a);
		a.setOnAction(e->{if(bets.isAlive()) {
			Bettor b = new Bettor(t1.getText(), t2.getText(), t3.getText(), Integer.parseInt(t4.getText()));
			race.addBettor(b);
		}else {
			Bettor b = new Bettor(t1.getText(), t2.getText(), t3.getText(), Integer.parseInt(t4.getText()));
			race.addBettor(b);
			finish(v1, a, t1, t2,t3,t4);
		}
		});

	}
	public void finish(VBox v1, Button a,TextArea r1, TextArea r2,TextArea t3, TextArea t4) {
		race.setPositions();
		
		hb.getChildren().remove(2);
		v1.getChildren().clear();
		
		b1 = new Button("remacht");
		Label t2B = new Label(" ");
		
		t1.setText("Nit");
		t2.setText("");
		v1.getChildren().add(t1);
		v1.getChildren().add(a);
		v1.getChildren().add(t2B);
		a.setText("Consult bet");
		hb.getChildren().add(b1);
		a.setOnAction(e->{
			boolean won = race.consultBet(t1.getText());
			if(won) {
				t2B.setText("Congratulations!, your horse won the race");
			} else {
				t2B.setText("Your horse lose the race");
			}
		});
		
		
		try {
			LH.setText("Positions: \n" + race.show());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		b1.setOnAction(e->{
			race.rematch();
			try {
				LH.setText(race.show());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			addBettor(a, r1, r2, v1);
		});
		hb.getChildren().add(b1);
	}

}
