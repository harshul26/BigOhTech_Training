package Day_1_Politics;

public class MP extends Person{
    String constituency;
    double expenses , spendingLimit;
    Drivers driver;


    public MP(){

    }
    public MP(String name , String constituency , Drivers driver){
        this.constituency = constituency;
        this.spendingLimit = 100000;
        this.driver = driver;
    }

    public String getConstituency(){
        return this.constituency;
    }

    public Drivers getDriver(){
        return this.driver;
    }

    public void addExpense(double exp){
        this.expenses += exp;
    }

    public boolean exceedsSpeedLimit(){
        if(this.expenses > spendingLimit){
            return true;
        }
        else{
            return false;
        }
    }
}
