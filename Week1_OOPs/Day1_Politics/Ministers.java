package Day_1_Politics;

public class Ministers extends MP{
    
    public Ministers(){

    }
    public Ministers(String name , String constituency , Drivers d){
        super(name ,constituency , d);
        this.spendingLimit = 1000000; 
    }
}
