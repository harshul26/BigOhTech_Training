package Day_3_ATM;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User extends Person{
    public User(String name) {
        super(name);
    }

    static ATM atm = new ATM();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        menu();
        
        atm.atmDetails();

        scn.close();
    }

    public static void menu(){
        System.out.println();
        System.out.println("                             ~---MENU---~                     ");
        System.out.println("Select the operation");
        System.out.println("1. Check A/c Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");
        System.out.println("Enter Your Choice: ");

        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();

        if(choice == 1){
            atm.showBalance();
            menu();
        }
        else if(choice == 2){
            System.out.println("Enter the amount to be withdrawn : ");
            int amount = scn.nextInt();
            atm.withdrawMoney(amount);
            menu();
        }
        else if(choice == 3){
            System.out.println("Enter the amount to be deposit : ");
            int amount = scn.nextInt();
            Denominations d = new Denominations();
            List<Integer> list = d.typeOfCashAvailable();
            System.out.println("Enter the denomination of following type only:");
            for(int i = 0; i < list.size(); i++){
                System.out.println(" " + list.get(i) + " ");
            }
            System.out.println("Enter the number of distinct denominations you are entering : ");
            int countOfD = scn.nextInt();
            HashMap<Integer , Integer> depositingDenominitionRecord = new HashMap<>();
            inputFromTheUserForDenominations(depositingDenominitionRecord , countOfD , list);
            
            atm.depositMoney(amount , depositingDenominitionRecord);
            menu();
        }
        else if(choice == 4){
            System.out.println("             Thankyou for visting!                 ");
            scn.close();
            return;
        }
        else{
            System.out.println("Enter a valid choice");
            menu();
        }
        scn.close();
    }

    public static void inputFromTheUserForDenominations(HashMap<Integer , Integer> depositingDenominitionRecord , int countOfD , List<Integer> list){
        System.out.println("Enter the Denominations from beginning.");
        Scanner scn = new Scanner(System.in);
        for(int i = 0; i < countOfD; i++){
                System.out.println("Enter the Denomination value " + i + " : ");
                int key = scn.nextInt();
                if(list.contains(key)){
                    inputFromTheUserForDenominations(depositingDenominitionRecord , countOfD , list);
                }
                System.out.println("Enter the no. of notes of given Denomination value : ");
                int value = scn.nextInt();
                depositingDenominitionRecord.put(key , value);
        }
        scn.close();
    }
    
}
