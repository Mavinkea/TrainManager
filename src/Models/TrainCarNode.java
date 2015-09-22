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
public class TrainCarNode {
    
    private TrainCarNode next;
    private TrainCarNode prev;
    private TrainCar car;
    
    /**
     * Default constructor for a node
     */
    public TrainCarNode(){
        next=null;
        prev=null;
        car=null;
    }
    
    /**
     * Overloaded constructor
     * @param car 
     *      Car object to be contained within node
     */
    public TrainCarNode(TrainCar car){
        next=null;
        prev=null;
        this.car=car;
    }
    
    /**
     * Setter method for next node
     * @param next 
     *      Node to be set as next
     */
    public void setNext(TrainCarNode next){
        this.next=next;
    }
    
    /**
     * Getter method for next node
     * @return 
     *      Reference to next node
     */
    public TrainCarNode getNext(){
        return next;
    }
    
    /**
     * Setter method for previous node
     * @param prev 
     *      Node to be set as previous
     */
    public void setPrev(TrainCarNode prev){
        this.prev=prev;
    }
    
    /**
     * Getter method for previous
     * @return 
     *      Reference to previous node
     */
    public TrainCarNode getPrev(){
        return prev;
    }
    
    /**
     * Setter method for car
     * @param car 
     *      Car object
     */
    public void setCar(TrainCar car){
        this.car=car;
    }
    
    /**
     * Getter method for car
     * @return 
     *      Car object contained within node
     */
    public TrainCar getCar(){
        return car;
    }
    
    /**
     * Override of toString method in Object class
     * @return 
     *      String representation of current car
     */
    @Override
    public String toString(){
        return Double.toString(car.getLength())+" "+Double.toString(car.getWeight());
    }
    
}

