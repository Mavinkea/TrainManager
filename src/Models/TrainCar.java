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

public class TrainCar {
    
    private double length;
    private double weight;
    private ProductLoad load;
    
    /**
     * Default constructor
     */
    public TrainCar(){
        length=0.0;
        weight=0.0;
        load=null;
    }
    
    /**
     * Overloaded constructor
     * @param length
     *      Length of train car as double
     * @param weight
     *      Weight of train car as double
     * @param load 
     *      What the train car is carrying
     */
    public TrainCar(double length, double weight, ProductLoad load){
        this.length=length;
        this.weight=weight;
        this.load=load;
    }
    
    /**
     * Getter method for length
     * @return 
     *      Train car's length
     */
    public double getLength(){
        return length;
    }
    
    /**
     * Getter method for weight
     * @return 
     *      Train car's weight
     */
    public double getWeight(){
        return weight+load.getWeight();
    }
    
    /**
     * Getter method for product load
     * @return 
     *      Product load object of the train car
     */
    public ProductLoad getProductLoad(){
        return load;
    }
    
    /**
     * Setter method for product load
     * @param load 
     *      ProductLoad object to be set to
     */
    public void setProductLoad(ProductLoad load){
        this.load=load;
    }
    
    /**
     * Checks whether the train car is empty aka has no product load
     * @return 
     *      Whether the train car is empty or not
     */
    public boolean isEmpty(){
        return (this.load.getValue()==0.0 || load==null);
    }
}
