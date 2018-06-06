package rock_paper_scissors;

import java.util.HashMap;

public enum Choices {
	
	//declaring choices
	rock("paper", "scissors"),
	paper("scissors", "rock"),
	scissors("rock", "paper");
	
	//choice attributes 
	private final String BeatBy;
	private final String Beats;

	//static
	static HashMap<String, Choices> Str2Choice = new HashMap<>();
	static {

		Str2Choice.put("rock", rock);
		Str2Choice.put("paper", paper);
		Str2Choice.put("scissors", scissors);

	}
	
	//assigning attributes
	private Choices(String lose, String win) {
		this.BeatBy = lose;
		this.Beats = win;
	}
	
	//get what choice beats
	public String win(){
		return this.Beats;
	}
	
	//get what choice is beat by
	public String lose() {
		return this.BeatBy;
	}
		
	
}
