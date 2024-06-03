package Day_3_ATM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Denominations {
    //type of denominations = 2000 , 500 , 200 , 100;
    private int totalAmount;
    private TreeMap<Integer , Integer> noOfNotesOfValue; // Sorted Map - Tree Map
    //  Key --> Value of cash  and Value --> no. of Notes 

    public Denominations(){
        noOfNotesOfValue = new TreeMap<>(Comparator.reverseOrder());
        //sorting the map in decreasing order
        noOfNotesOfValue.put(2000 , 0);
        noOfNotesOfValue.put(500 , 0);
        noOfNotesOfValue.put(200 , 0);
        noOfNotesOfValue.put(100 , 0);
    }

    public Denominations(int value , int noOfNotes){
        this();
        //adding new Denominations also 
        depositMoney(value, noOfNotes);
    }

    //in case of Demonetization -> removing of certain denomination
    public void removeDenominations(int value){
        int noOfNotes = noOfNotesOfValue.get(value);
        noOfNotesOfValue.remove(value);
        this.totalAmount -= value * noOfNotes;
    }

    public int getTotalAmount(){
        return this.totalAmount;
    }

    //depositing money - addMoney
    public void depositMoney(int value , int noOfNotes){
        int amount = noOfNotesOfValue.get(value);
        noOfNotesOfValue.put(value, amount+noOfNotes);
        this.totalAmount += value * noOfNotes;
        System.out.println("Money Deposited Successfully");
    }

    //withdrawing money - removeMoney
    public void withdrawMoney(int value , int noOfNotes){
        int amount = noOfNotesOfValue.get(value);
        if(FixedCashAvailable(value, noOfNotes)){
            noOfNotesOfValue.put(value, amount-noOfNotes);
            this.totalAmount -= value * noOfNotes;
            System.out.println("Money Withdrawn Successfully");
        }
        else{
            System.out.println("Insufficient Balance");
        }

    }


    public boolean FixedCashAvailable(int value , int noOfNotes){
        if(noOfNotesOfValue.containsKey(value) && noOfNotesOfValue.get(value) >= noOfNotes){
            return true;
        }
        
        return false;
    }

    public boolean isAmountAvailable(int amount){
        if(totalAmount >= amount){
            return true;
        }
        return false;
    }

    public List<Integer> typeOfCashAvailable(){
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> mapElement : noOfNotesOfValue.entrySet()){
            if(mapElement.getValue() > 0){
                list.add(mapElement.getKey());
            }
        }
        return list;

    }

    public int noOfCashAvailableForValue(int value){
        return noOfNotesOfValue.get(value);
    }
}
