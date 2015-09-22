package Views;
import Models.*;

import java.util.Scanner;

/**
 * Aril Mavinkere
 * CSE 214 R02
 * 109681869
 * TA: Daniel Rodrigues
 * @author Aril Mavinkere
 * 
 * RUN FROM TrainManager(console) or TrainManagerGUI
 */
public class TrainManager {
    
    private static final String menu="(F) Cursor Forward \n" +
                                    "(B) Cursor Backward \n" +
                                    "(I) Insert Car After Cursor \n" +
                                    "(R) Remove Car At Cursor \n" +
                                    "(L) Set Product Load \n" +
                                    "(S) Search For Product \n" +
                                    "(T) Display Train \n" +
                                    "(M) Display Manifest \n" +
                                    "(D) Remove Dangerous Cars \n" +
                                    "(Q) Quit \n";
    private static boolean running=true;
    private static Scanner input=new Scanner(System.in);
    private static TrainLinkedList list;
    
    public static void main(String[] args){ 
        list=new TrainLinkedList();
        while(running){
            runMenu();
        }
    }
    
    /**
     * Runs main menu and takes user selection
     */
    public static void runMenu(){
        System.out.println(menu+"Enter a selection:");
        String in=input.next();
        if(in.equals("F"))runF();
        else if(in.equals("B"))runB();
        else if(in.equals("I"))runI();
        else if(in.equals("R"))runR();
        else if(in.equals("L"))runL();
        else if(in.equals("S"))runS();
        else if(in.equals("T"))runT();
        else if(in.equals("M"))runM();
        else if(in.equals("D"))runD();
        else if(in.equals("Q"))runQ();
        else{
            System.out.println("Invalid selection");
        }    
    }
    
    /**
     * Handles cursor forward
     */
    public static void runF(){
        try{
            list.cursorForward();
            System.out.println("Cursor successfully moved forward.");
        }catch(NullPointerException e){System.out.println("Can't move cursor forward.");}
    }
    
    /**
     * Handles cursor backward
     */
    public static void runB(){
        try{
            list.cursorBackward();
            System.out.println("Cursor successfully moved backward.");
        }catch(NullPointerException e){System.out.println("Can't move cursor backward");}
    }
    
    /**
     * Handles train car insertion
     */
    public static void runI(){
        System.out.println("Enter car length in meters: ");
        double l=input.nextDouble();
        System.out.println("Enter car weight in tons: ");
        double w=input.nextDouble();
        
        list.insert(new TrainCar(l,w,new ProductLoad()));
        
        System.out.println("New train car "+l+"meters and "+w+ "tons inserted into train.");
    }
    
    /**
     * Handles train car removal
     */
    public static void runR(){
        try{
            TrainCar temp=list.removeCursor();
            System.out.println("Car successully unlinked. The following load has been removed from the train:\n"+
                                "Name      Weight (t)     Value ($)   Dangerous"+
                                "===================================================");
            System.out.println(String.format("%-14s%-15s%-12s%-9s", temp.getProductLoad().getName(),temp.getProductLoad().getWeight(),
                   temp.getProductLoad().getValue(),temp.getProductLoad().getDangerous()));
        }catch(NullPointerException e){
            System.out.println("Could not remove train car.");
        }
    }
    
    /**
     * Handles load setting
     */
    public static void runL(){
        System.out.println("Enter the product name: ");
        String n=input.nextLine();
        System.out.println("Enter the product weight in tons: ");
        double w=input.nextDouble();
        System.out.print("Enter the value in dollars: ");
        double v=input.nextDouble();
        System.out.print("Is the product dangerous? (Y/N)");
        String d=input.nextLine();
        boolean b=false;
        if(d.equals("Y"))b=true;
        list.getCursorData().setProductLoad(new ProductLoad(n,w,v,b));
        list.setWeight(list.getWeight()+w);
        list.setValue(list.getValue()+v);
    }
    
    /**
     * Handles product search
     */
    public static void runS(){
        System.out.println("Enter the product name");
        String n=input.nextLine();
        list.findProduct(n);
    }
    
    /**
     * Handles train display
     */
    public static void runT(){
        System.out.println(list.toString());
    }
    
    /**
     * Handles manifest display
     */
    public static void runM(){
        list.printManifest();
    }
    
    /**
     * Handles danger removal
     */
    public static void runD(){
        list.removeDangerousCars();
        System.out.println("Dangerous cars successfully removed from the train.\n");
    }
    
    /**
     * Handles quit functionality
     */
    public static void runQ(){
        System.out.println("Program terminated...");
        input=null;
        list=null;
        running=false;
    }
   
}

