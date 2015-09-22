/**
 * Aril Mavinkere
 * CSE 214 R02
 * 109681869
 * TA: Daniel Rodrigues
 * @author Aril Mavinkere
 * 
 * TrainGUIController.java
 * Controller in MVC structure. Edits model and displays changes in the view
 */

package Controllers;
import java.util.Optional;

import Views.*;
import Models.*;
import java.util.NoSuchElementException;

public class TrainGUIController {

	TrainManagerGUI gui;
	TrainLinkedList list=new TrainLinkedList();
	
	/**
	 * Creates a controller which will be used in the View
	 * @param gui
	 * 		GUI being worked with
	 */		
	public TrainGUIController(TrainManagerGUI gui){
		this.gui=gui;
	}
	
	/**
	 * Handles cursor forward functionality
	 */
	public void cursorForward(){
		try{
			list.cursorForward();
			gui.getText().setText("Cursor successfully moved forward");
		}catch(NullPointerException e){
			gui.getText().setText("Cursor could not be moved forward");
		}
	}
	
	/**
	 * Handles cursor backward functionality
	 */
	public void cursorBackward(){
		try{
			list.cursorBackward();
			gui.getText().setText("Cursor successfully moved backward");
		}catch(NullPointerException e){
			gui.getText().setText("Cursor could not be moved backward");
		}
	}
	
	/**
	 * Handles insertion functionality
	 */
	public void insert(){
		try{
		gui.getDialog().setTitle("Car length");
		gui.getDialog().setContentText("Please enter length:");
		Optional<String> length=gui.getDialog().showAndWait();
		String l=length.get();
		double l1=Double.parseDouble(l);
		
		gui.getDialog().setTitle("Car weight");
		gui.getDialog().setContentText("Please enter weight:");
		Optional<String> weight=gui.getDialog().showAndWait();
		String w=length.get();
		double w1=Double.parseDouble(w);
		
		list.insert(new TrainCar(l1,w1,new ProductLoad()));
		
		gui.getText().setText("New train car successfully added");
		}catch(NoSuchElementException e){}
		
	}
	
	/**
	 * Handles removal functionality
	 */
	public void remove(){
		try{
			TrainCar r=list.getCursorData();
			list.removeCursor();
			gui.getText().setText(("Car successully unlinked. The following load has been removed from the train:\n"+
                    "Name      Weight (t)     Value ($)   Dangerous\n"+
                    "===================================================\n")+
                    String.format("%-14s%-15s%-12s%-9s", r.getProductLoad().getName(),r.getProductLoad().getWeight(),
                            r.getProductLoad().getValue(),r.getProductLoad().getDangerous()));
		}catch(NullPointerException e){
				gui.getText().setText("Could not remove cursor");
		}
		
	}
	
	
	/**
	 * Handles load setting functionality
	 */
	public void setLoad(){
		try{
		gui.getDialog().setTitle("Product Name");
		gui.getDialog().setContentText("Please enter name:");
		Optional<String> name=gui.getDialog().showAndWait();
		String n=name.get();
		
		gui.getDialog().setTitle("Product weight");
		gui.getDialog().setContentText("Please enter weight:");
		Optional<String> weight=gui.getDialog().showAndWait();
		String w=weight.get();
		double w1=Double.parseDouble(w);
		
		gui.getDialog().setTitle("Product value");
		gui.getDialog().setContentText("Please enter value:");
		Optional<String> value=gui.getDialog().showAndWait();
		String v=weight.get();
		double v1=Double.parseDouble(w);
		
		gui.getDialog().setTitle("Product Dangerous");
		gui.getDialog().setContentText("Is it dangerous?");
		Optional<String> danger=gui.getDialog().showAndWait();
		String d=danger.get();
		
		boolean pd=false;
		if(d.equalsIgnoreCase("Y") || d.equalsIgnoreCase("Yes"))pd=true;
		
		list.getCursorData().setProductLoad(new ProductLoad(n,w1,v1,pd));
		list.setWeight(list.getWeight()+w1);
		list.setValue(list.getValue()+v1);
		gui.getText().setText("Product load set");
		}catch(NoSuchElementException e){}
	}
	
	/**
	 * Handles search functionality
	 */
	public void search(){
		try{
		gui.getDialog().setTitle("Product Name");
		gui.getDialog().setContentText("Please enter name:");
		Optional<String> name=gui.getDialog().showAndWait();
		String n=name.get();
		
		gui.getText().setText(list.findProductAsString(n));
		}catch(NoSuchElementException e){}
	}
	
	/**
	 * Handles display functionality
	 */
	public void displayTrain(){
		gui.getText().setText(list.toString());
		
	}
	
	/**
	 * Handles display functionality
	 */
	public void displayManifest(){
		gui.getText().setText(list.printManifestAsString());
	}
	
	/**
	 * Handles remove danger functionality
	 */
	public void removeDanger(){
		list.removeDangerousCars();
		gui.getText().setText("Dangerous Cars removed");
	}
	
}
