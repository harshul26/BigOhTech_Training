package Day_3_ATM;

public class Admin extends Person{

    ATM atm;
    public Admin(String name , ATM atm) {
        super(name);
        this.atm = atm;
    }
    //admin can deposit money or remove money using set of denominations with no. of notes into the ATM
    // by accessing its methods like atm.depositMoney(); atm.withdrawMoney;
    
    
    
}
