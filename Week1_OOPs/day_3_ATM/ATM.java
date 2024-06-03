package Day_3_ATM;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATM {
    Denominations denominations; //object of the Denomination class

    public ATM(){
        denominations = new Denominations();
    }

    //method to withdraw money from the ATM 
    public void withdrawMoney(int amount){
        //if atm have the amount which to be withdrawn
        if(denominations.isAmountAvailable(amount)){
            List<Integer> availableCash = denominations.typeOfCashAvailable();
            List<Map.Entry<Integer , Integer>> list = new ArrayList<>(); // to store the number of cash atm has wrt its value
            for(int value : availableCash){
                int noOfNotes = amount/value;
                if(denominations.FixedCashAvailable(value, noOfNotes)){
                    amount -= value * noOfNotes;
                    //denominations.withdrawMoney(value, noOfNotes);
                    if(noOfNotes > 0){
                        list.add(new AbstractMap.SimpleEntry<>(value , noOfNotes));
                    }
                }
            }
            if(amount > 0){
                System.out.println("The given Amount is not available as per the given Denominations");
            }
            else{
                System.out.println("You are recieving : ");
                for(Map.Entry<Integer , Integer> element : list){
                    if(element.getValue() > 0){
                        System.out.print(" " + element.getValue() + " notes of " + element.getKey() + " denomination. ");
                        denominations.withdrawMoney(element.getKey(), element.getValue());
                    }
                }
                System.out.println("Money withdrawn successfully!");
            }
        }
        else{
            System.out.println("Insufficient Balance in your Account");
        }
    }

    public void depositMoney(int amount , HashMap<Integer , Integer> depositingDenominitionRecord){
        for(Map.Entry<Integer , Integer> element : depositingDenominitionRecord.entrySet()){
            denominations.depositMoney(element.getKey(), element.getValue());
        }
        System.out.println("Money Depositted successfully");
        
    }

    public void atmDetails(){
        List<Integer> availableCash = denominations.typeOfCashAvailable();
        for(int value : availableCash){
            System.out.println(value + " -- " + denominations.noOfCashAvailableForValue(value) + " ");
        }
        System.out.println();
        
    }

    public int showBalance(){
        return denominations.getTotalAmount();
    }
    
}
