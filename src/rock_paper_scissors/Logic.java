package rock_paper_scissors;

import java.util.Random;

public class Logic {

	// -------------------------------Attributes-------------------------------

	// Choice count

	private Double RockC, PaperC, ScissorsC;
	
	// Computer Choice
	private Choices comp;
	private String WinMsg;


	public Logic(Double r, Double p, Double s) {
		RockC = r;
		PaperC = p;
		ScissorsC = s;
	}

	Logic() {
		RockC = PaperC =ScissorsC = 1D;

	}


	// -------------------------------evaluate answer-------------------------------
	
	void evaluate(Choices choice) throws UnknownError {

		// generating computer
		comp = Computer();

		// ---------------choose winner---------------
		
		// tie logic
		if (choice.toString().equals(comp.toString())) {
			WinMsg = "Tie!";
		}

		// lose logic
		else if (choice.lose().equals(comp.toString())) {
			WinMsg = "Computer Wins!";
		}

		// win logic
		else if (choice.win().equals(comp.toString())) {
			WinMsg = "Player Wins!";
		}

		// this shouldn't happen but why not
		else {
			throw new UnknownError("something is very wrong");
		}



		switch(choice) {
			case scissors: ScissorsC++; break;
			case paper: PaperC++; break;
			case rock: RockC++; break;
		}

	}

	private Choices Computer() {

		//percent constant
		Double PercentPerOne = 100/(RockC + PaperC + ScissorsC);

		// get choice percents
		Double RockP = PercentPerOne*RockC;
		Double PaperP = PercentPerOne*PaperC;
		Double ScissorsP = PercentPerOne*ScissorsC;


		// RNG
		int RNG = new Random().nextInt(100);

		// select choice with RNG
		if (RNG < (RockP-1)) {
			return Choices.Str2Choice.get(Choices.rock.lose());
		}else if (RNG < ((RockP + PaperP) - 1) ) {
			return Choices.Str2Choice.get(Choices.paper.lose());
		}else if (RNG < ((RockP + PaperP + ScissorsP) - 1)) {
			return Choices.Str2Choice.get(Choices.scissors.lose());
		}else throw new UnknownError("something is very wrong");

	}

	Choices getComp() {
		return comp;
	}

	String getWinMsg() {
		return WinMsg;
	}
}
