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
public class ProductLoad {
    
    private String name;
    private double weight;
    private double value;
    private boolean dangerous;
    
    /**
     * Default Constructor for a Product Load object
     */
    public ProductLoad(){
        name="";
        weight=0.0;
        value=0.0;
        dangerous=false;
    }
    
    /**
     * Overloaded constructor
     * @param name
     *      Name of the product
     * @param weight
     *      Weight of the product as a double
     * @param value
     *      Value of the product as a double
     * @param dangerous 
     *      A boolean value referencing whether load is dangerous
     */
    public ProductLoad(String name, double weight, double value, boolean dangerous){
        this.name=name;
        this.weight=weight;
        this.value=value;
        this.dangerous=dangerous;
    }
    
    /**
     * Sets product name
     * @param name 
     *      New name of product
     */
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * Gets product name
     * @return 
     *      Product name as a String
     */
    public String getName(){
        return name;
    }
    
    /**
     * Sets product weight 
     * @param weight 
     *      Weight of product as a double
     */
    public void setWeight(double weight){
        this.weight=weight;
    }
    
    /**
     * Gets weight of product
     * @return 
     *      Weight as a double
     */
    public double getWeight(){
        return weight;
    }
    
    /**
     * Sets value of product
     * @param value 
     *      Value of product
     */
    public void setValue(double value){
        this.value=value;
    }
    
    /**
     * Gets product value
     * @return 
     *      Value as a double
     */
    public double getValue(){
        return value;
    }
    
    /**
     * Sets danger for product load
     * @param dangerous 
     *      Boolean value referencing if product is dangerous
     */
    public void setDangerous(boolean dangerous){
        this.dangerous=dangerous;
    }
    
    /**
     * Gets danger for the load
     * @return 
     *      Danger as a boolean (True/False)
     */
    public boolean getDangerous(){
        return dangerous;
    }
    
}

