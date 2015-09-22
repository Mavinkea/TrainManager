/**
 * Aril Mavinkere
 * CSE 214 R02
 * 109681869
 * TA: Daniel Rodrigues
 * @author Aril Mavinkere
 * 
 * View in the MVC structure. Sets up the GUI and sends button events to controller
 * 
 * TO RUN THE CONSOLE VERSION:
 * 		1)Comment out the launch method below
 * 		2)Un-comment the command below the launch method
 */

package Views;
import Controllers.*;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.geometry.Pos;

public class TrainManagerGUI extends Application {

	TrainGUIController controller;
	BorderPane layout=new BorderPane();
	Button cf,cb,i,r,l,s,t,m,d;
	TextInputDialog getInfo = new TextInputDialog();
	Label title;
	TextArea textBox;
	
	public static void main(String[] args){
		launch(args);
		//TrainManager.main(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		controller=new TrainGUIController(this);
		primaryStage.setTitle("Course Planner");
		
		VBox buttonGrid=new VBox();
		layout.setLeft(buttonGrid);
		
		title=new Label("Train Linked List");
		title.setMaxWidth(1000);
		title.setAlignment(Pos.CENTER);
		layout.setTop(title);
		layout.setAlignment(title,Pos.CENTER);
		
		textBox=new TextArea();
		textBox.setEditable(false);
		textBox.getStyleClass().add("textBox");
		layout.setCenter(textBox);
		
		cf=new Button("Cursor Forward");
		cb=new Button("Cursor Backward");
		i=new Button("Insert Car");
		r=new Button("Remove Car");
		l=new Button("Set Product Load");
		s=new Button("Search for Product");
		t=new Button("Display train");
		m=new Button("Display Manifest");
		d=new Button("Remove Danger");
		
		buttonGrid.getChildren().add(cf);
		buttonGrid.getChildren().add(cb);
		buttonGrid.getChildren().add(i);
		buttonGrid.getChildren().add(r);
		buttonGrid.getChildren().add(l);
		buttonGrid.getChildren().add(s);
		buttonGrid.getChildren().add(t);
		buttonGrid.getChildren().add(m);
		buttonGrid.getChildren().add(d);
		
		cf.setMaxWidth(150);
		cb.setMaxWidth(150);
		i.setMaxWidth(150);
		r.setMaxWidth(150);
		l.setMaxWidth(150);
		s.setMaxWidth(150);
		t.setMaxWidth(150);
		m.setMaxWidth(150);
		d.setMaxWidth(150);
		
		cf.setOnAction((event)->{controller.cursorForward();});
		cb.setOnAction((event)->{controller.cursorBackward();});
		i.setOnAction((event)->{controller.insert();});
		r.setOnAction((event)->{controller.remove();});
		l.setOnAction((event)->{controller.setLoad();});
		s.setOnAction((event)->{controller.search();});
		t.setOnAction((event)->{controller.displayTrain();});
		m.setOnAction((event)->{controller.displayManifest();});
		d.setOnAction((event)->{controller.removeDanger();});
		
		
		
		Scene scene=new Scene(layout,1000,400);
		scene.getStylesheets().add("file:src/Resources/main.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Returns GUI's textbox. To be used by Controller
	 * @return
	 */
	public TextArea getText(){
		return textBox;
	}
	
	/**
	 * Returns Input Dialog. To be used by controller
	 * @return
	 */
	public TextInputDialog getDialog(){
		return getInfo;
	}
}
