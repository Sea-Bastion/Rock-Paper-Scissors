package rock_paper_scissors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;


// make class and application
public class Main extends Application {
	
	// -------------------------------Attributes-------------------------------
	private static Stage PrimaryStage;
	private Scene game;
	private Logic Logic = new Logic();

	// Images
	private Image RockImage = new Image("file:./sprites/rock.png", 100d, 100d, true, true);
	private Image PaperImage = new Image("file:./sprites/paper.png", 100d, 100d, true, true);
	private Image ScissorsImage = new Image("file:./sprites/scissors.png", 100d, 100d, true, true);

	//choice to image
	private HashMap<Choices, Image> Choice2Image = new HashMap<>();


	// -------------------------------init-------------------------------
	public Main() {

		//set up Choice2Image
		Choice2Image.put(Choices.rock, RockImage);
		Choice2Image.put(Choices.paper, PaperImage);
		Choice2Image.put(Choices.scissors, ScissorsImage);

	}
	

	// -------------------------------main-------------------------------
	public static void main(String[] args) {
		//setup window
		launch(args);
	}

	
	// -------------------------------start-------------------------------
	@Override
	public void start(Stage Window) {
		
		// setting PrimaryStage
		PrimaryStage = Window;
		
		// ---------------widgets---------------

		// title label
		Label msg = new Label("Rock, Paper, or Scissors");

		// buttons
		ImageView RockButton = new ImageView(RockImage);
		ImageView PaperButton = new ImageView(PaperImage);
		ImageView ScissorsButton = new ImageView(ScissorsImage);

		RockButton.setOnMouseClicked(e -> end(Choices.rock));
		PaperButton.setOnMouseClicked(e -> end(Choices.paper));
		ScissorsButton.setOnMouseClicked(e -> end(Choices.scissors));


		// ---------------organize---------------
		
		// put button in a row
		HBox choices = new HBox(20);
		choices.getChildren().addAll(RockButton, PaperButton, ScissorsButton);
		choices.setAlignment(Pos.CENTER);
		
		// stack label and buttons
		VBox MainBox = new VBox(150);
		MainBox.getChildren().addAll(msg, choices);
		MainBox.setPadding(new Insets(20, 20, 20, 20));
		MainBox.setAlignment(Pos.CENTER);
		
		// ---------------window/scene config---------------
		
		game = new Scene(MainBox, 400, 300);
		PrimaryStage.setResizable(false);
		PrimaryStage.setScene(game);
		PrimaryStage.show();
	}

	
	// -------------------------------end-------------------------------
	
	private void end(Choices choice) {
		
		
		// run game logic
		Logic.evaluate(choice);
		
		// ---------------widgets---------------
		
		//display labels
		Label VS = new Label(" VS ");
		ImageView player = new ImageView(Choice2Image.get(choice));
		ImageView comp = new ImageView(Choice2Image.get(Logic.getComp()));
		Label win = new Label(Logic.getWinMsg());
		
		//replay button
		Button ReplayButton = new Button("Play again");
		ReplayButton.setMinWidth(100);
		ReplayButton.setOnAction(e -> PrimaryStage.setScene(game));
		
		//close button
		Button CloseButton = new Button("Close");
		CloseButton.setMinWidth(100);
		CloseButton.setOnAction(e -> PrimaryStage.close());
		
		// ---------------organize---------------
		
		//put the VS in the center
		StackPane VSBox = new StackPane();
		VSBox.getChildren().add(VS);
		VSBox.setAlignment(Pos.CENTER);
		
		//pair VS with choices
		HBox dis = new HBox(20);
		dis.getChildren().addAll(player, VSBox, comp);
		dis.setAlignment(Pos.CENTER);
		
		//pair buttons
		HBox RestartBox = new HBox(20);
		RestartBox.getChildren().addAll(ReplayButton, CloseButton);
		RestartBox.setAlignment(Pos.CENTER);
		
		//pair all
		VBox EndBox = new VBox(40);
		EndBox.getChildren().addAll(dis, win, RestartBox);
		EndBox.setAlignment(Pos.CENTER);
		
		//scene config
		Scene end = new Scene(EndBox, 400, 300);
		PrimaryStage.setScene(end);
		
	}

}
