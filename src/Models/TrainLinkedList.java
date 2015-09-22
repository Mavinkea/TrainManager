package Models;

/**
 * Aril Mavinkere
 * CSE 214 R02
 * 109681869
 * TA: Daniel Rodrigues
 * @author Aril Mavinkere
 * 
 * RUN FROM TrainManager(console) or TrainManagerGUI
 */

public class TrainLinkedList {
    
    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private int size;
    private double length,value,weight;
    private boolean danger;

    /**
     * Constructor that creates an empty list with size 0
     */
    public TrainLinkedList(){
        head=null;
        tail=null;
        cursor=null;
        size=0;
    }
    
    /**
     * Gets current cursor's train car
     * @return 
     */
    public TrainCar getCursorData(){
        if(cursor==null)
            throw new NullPointerException("Cursor is null");
        else
            return cursor.getCar();
    }
    
    /**
     * Sets current cursor's train car
     * @param car 
     */
    public void setCursorData(TrainCar car){
        if(cursor==null)
            throw new NullPointerException("Cursor is null");
        else 
            cursor.setCar(car);
    }
    
    /**
     * Advances cursor forward
     */
    public void cursorForward() {
        if(cursor==null || size==0)
            throw new NullPointerException("Cursor is null");
        else if(cursor.getNext()!=null){cursor=cursor.getNext();}
    }
    
    /**
     * Pushes cursor back 
     */
    public void cursorBackward(){
        if(cursor==null)
            throw new NullPointerException("Cursor is null");
        else if(cursor.getPrev()!=null)
            cursor=cursor.getPrev();
    }
    
    /**
     * Inserts a new node to the list after the cursor
     * @param newCar 
     *      Train car being added
     */
    public void insert(TrainCar newCar){
        if(newCar==null) throw new IllegalArgumentException("New Car is null");
        else{
            TrainCarNode temp=new TrainCarNode(newCar);
            //if list is empty
            if(cursor==null){
                head=temp;
                tail=temp;
            }
            //if cursor is at the tail
            else if(cursor.getNext()==null){
                temp.setPrev(cursor);
                cursor.setNext(temp);
                tail=temp;
            }
            else{
                temp.setNext(cursor.getNext());
                cursor.getNext().setPrev(temp);   
                temp.setPrev(cursor);
                cursor.setNext(temp);
            }
            cursor=temp;
            length+=newCar.getLength();
            value+=newCar.getProductLoad().getValue();
            weight+=newCar.getWeight();

            size++;
        }
    }
    
    /**
     * Removes node at the cursor from the list.
     * @return 
     *      TrainCar being removed
     */
    public TrainCar removeCursor(){
        if(cursor==null && size>=1)
            throw new NullPointerException("Cursor is null");
        else{
            TrainCar toReturn=cursor.getCar();
            
            //if cursor is only element in the list
            if(cursor.getNext()==null && cursor.getPrev()==null){
            	cursor=null;
            	head=null;
            	tail=null;
            }
               
          //if cursor is at the tail
            else if(cursor.getNext()==null){
                cursor.getPrev().setNext(null);
                cursor=cursor.getPrev();
                tail=cursor;
            }
            
            //if cursor is at the head
            else if(cursor.getPrev()==null){
                cursor.getNext().setPrev(null);
                cursor=cursor.getNext();
                head=cursor;
            } 
            
            //if cursor is in the middle somewhere
            else{
                cursor.getPrev().setNext(cursor.getNext());
                cursor.getNext().setPrev(cursor.getPrev());
                cursor=cursor.getPrev();
            }
            
            size--;
            length-=toReturn.getLength();
            value-=toReturn.getProductLoad().getValue();
            weight-=toReturn.getProductLoad().getWeight();
            return toReturn;
        }
    }
    
    /**
     * Returns size of list
     * @return 
     *      size as an integer
     */
    public int size(){
        return size;
    }
    
    /**
     * Returns length of the entire train
     * @return 
     *      Length as a double
     */
    public double getLength(){
        return length;
    }
    
    /**
     * Returns trains monetary value 
     * @return 
     *      Value as a double
     */
    public double getValue(){
        return value;
    }
    
    /**
     * Weight of the car as a whole
     * @return 
     *      Weight in tons as a double
     */     
    public double getWeight(){
        return weight;
    }
    
    /**
     * Danger of the train
     * @return 
     *      True if train contains a dangerous car. False otherwise.
     */
    public boolean isDangerous(){
    	boolean danger=false;
    	TrainCarNode temp=head;
    	while(temp!=null){
    		if(temp.getCar().getProductLoad().getDangerous()){
    			danger=true;
    			this.danger=true;
    		}
    		temp=temp.getNext();
    	}
    	
        return danger;
    }
    
    /**
     * Searches list for product with specified name
     * @param name 
     *      Name of the product as a string
     */
    public void findProduct(String name){
        TrainCarNode temp=head;
        double w=0,v=0;
        boolean found=false,d=false;
        while(temp!=null){
            if(temp.getCar().getProductLoad().getName().equals(name)){
                found=true;
                w+=temp.getCar().getProductLoad().getWeight();
                v+=temp.getCar().getProductLoad().getValue();
                d=temp.getCar().getProductLoad().getDangerous();
            }
            temp=temp.getNext();
        }
        if(found)
            System.out.println(name+" found! "+w+"lbs. "+v+"dollars. "+"Dangerous: "+d);
        else
            System.out.println(name+" not found.");
    }
    
    /**
     * Prints a table with information about each car and its product load
     */
    public void printManifest(){
        System.out.println("CAR:                               LOAD\n"+
                "Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous\n"+
                "==================================+===================================================\n");
        int i=1;
        String table="",arrow="  ";
        TrainCarNode temp=head;
        while(temp!=null){
            if(cursor==temp) arrow="->";
            table+=(String.format("%-2s%-6s%-14s%-12s%-1s%-14s%-15s%-12s%-9s",arrow, i,temp.getCar().getLength(),temp.getCar().getWeight(),"|",
                    temp.getCar().getProductLoad().getName(),temp.getCar().getProductLoad().getWeight(),
                   temp.getCar().getProductLoad().getValue(),temp.getCar().getProductLoad().getDangerous())+"\n");
            
            temp=temp.getNext();
            arrow="  ";
            i++;
        }
        
        System.out.println(table);
    }
    
    /**
     * Removes dangerous cars from the list
     */
    public void removeDangerousCars(){
        TrainCarNode cursorRef=head;
        while(cursorRef!=null){
            if(cursorRef.getCar().getProductLoad().getDangerous()){
            	cursor=cursorRef;
                removeCursor();
                danger=false;
            }                     
            cursorRef=cursorRef.getNext();
        }
        
        cursor=cursorRef;
    }
    
    /**
     * Overridden toString method containing information about the train
     * @return 
     *      String with trains size, length, weight, value, and danger level
     */     
    @Override
    public String toString(){
        return "Train: "+size+" cars, "+length+" meters, "+weight+" tons, $"+value+" Dangerous: "+danger;
    }

    
    /**
     * Searches list for product with specified name. Overloaded method to help with GUI.
     * @param name 
     *      Name of the product as a string
     */
    public String findProductAsString(String name){
        TrainCarNode temp=head;
        double w=0,v=0;
        boolean found=false,d=false;
        while(temp!=null){
            if(temp.getCar().getProductLoad().getName().equals(name)){
                found=true;
                w+=temp.getCar().getProductLoad().getWeight();
                v+=temp.getCar().getProductLoad().getValue();
                d=temp.getCar().getProductLoad().getDangerous();
            }
            temp=temp.getNext();
        }
        if(found)
            return (name+" found! "+w+"lbs. "+v+"dollars. "+"Dangerous: "+d);
        else
            return(name+" not found.");
    }
    
    /**
     * Prints a table with information about each car and its product load. Overloaded to help with GUI
     */
    public String printManifestAsString(){
    	String menu=("CAR:                               LOAD\n"+
                "Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous\n"+
                "==================================+===================================================\n");
        int i=1;
        String table="",arrow="  ";
        TrainCarNode temp=head;
        while(temp!=null){
            if(cursor==temp) arrow="->";
            table+=(String.format("%-2s%-6s%-14s%-12s%-1s%-14s%-15s%-12s%-9s",arrow, i,temp.getCar().getLength(),temp.getCar().getWeight(),"|",
                    temp.getCar().getProductLoad().getName(),temp.getCar().getProductLoad().getWeight(),
                   temp.getCar().getProductLoad().getValue(),temp.getCar().getProductLoad().getDangerous())+"\n");
            
            temp=temp.getNext();
            arrow="  ";
            i++;
        }
        
        return menu+"\n"+table;
    }
    
    /**
     * Sets weight of list
     * @param w
     * 		Weight to be set
     */
    public void setWeight(double w){
    	weight=w;
    }
    
    /**
     * Sets value of list
     * @param w
     * 		Value to be set
     */
    public void setValue(double v){
    	value=v;
    }
    
    
}
