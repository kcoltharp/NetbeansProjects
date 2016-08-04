package login;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 *
 * @author Kenny
 */
public class Login extends Application{

	@Override
	public void start(Stage primaryStage){
		//add title to window frame
		//primaryStage.setTitle("Welcome - Sign In");

		//use grid pane to algin window components
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		//add Title to window grid
		Text scenetitle = new Text("Welcome");
		scenetitle.setId("welcome-text");
		grid.add(scenetitle, 0, 0, 2, 1);

		//create and add username text and text field to window
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		//create and add password text and text field to window
		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		TextField pwTextField = new TextField();
		grid.add(pwTextField, 1, 2);

		//create and add button and button text to window
		Button btn = new Button("Sign In");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		actiontarget.setId("actiontarget");

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());
		primaryStage.show();

		btn.setOnAction((ActionEvent e) -> {
			actiontarget.setText("Sign in button pressed");
		});
	}

}
