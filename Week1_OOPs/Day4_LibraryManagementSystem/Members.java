package Day_4_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

//Member is a Person who is having Books (reserved books , issued books , recieve the message for notification)
public class Members extends Person{
    private String barcode;
    private List<Books> reservedBooks;
    private List<Books> issuedBooks;
    private int fine;
    

    private List<String> issuedBooks_bydate;
    private List<String> messagesRecievedList;
    private final int maxCheckOutBooks;
    public Members(String name, int id, Long contact , String barcode) {
        super(name, id, contact);
        this.barcode = barcode;
        this.fine = 0;
        this.maxCheckOutBooks = 5;
        reservedBooks = new ArrayList<>();
        issuedBooks = new ArrayList<>();
        issuedBooks_bydate = new ArrayList<>();
        messagesRecievedList = new ArrayList<>();
    }

    public String getBarCode(){
        return this.barcode;
    }

    public boolean checkOutBook(Books book , String date){
        for(int i = 0; i < issuedBooks.size(); i++){
            if(issuedBooks.get(i).getBookId() == book.getBookId()){
                issuedBooks_bydate.set(i, date);
                return true;
            }
        }
        if(issuedBooks.size() == maxCheckOutBooks){
            return false;
        }

        issuedBooks.add(book);
        issuedBooks_bydate.add(date);
        return true;
    }

    public void reserveTheBook(Books book){
        reservedBooks.add(book);
    }

    public boolean returnTheBook(Books book){
        for(int i = 0; i < issuedBooks.size(); i++){
            if(issuedBooks.get(i).getBookId() == book.getBookId()){
                issuedBooks.remove(i);
                issuedBooks_bydate.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean cancelTheReservation(Books bookToCancel){
        for(Books book : reservedBooks){
            if(book.getBookId() == bookToCancel.getBookId()){
                reservedBooks.remove(bookToCancel);
                return true;
            }
        }
        return false;
    }

    public List<Books> getReserveBooks(){
        return reservedBooks;
    }
    
    public List<String> getRecievedMessages(){
        return messagesRecievedList;
    }

    public void showMessages(){
        for(String message : messagesRecievedList){
            //System.out.println(message);
        }
    }

    public List<Books> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<Books> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public List<String> getIssuedBooks_bydate() {
        return issuedBooks_bydate;
    }

    public void setIssuedBooks_bydate(List<String> issuedBooks_bydate) {
        this.issuedBooks_bydate = issuedBooks_bydate;
    }

    public void addFine(int fineInRupees) {
        this.fine += fineInRupees;
    }

    public void payFine(int amountPayingCurrently){
        this.fine -= amountPayingCurrently;
    }
    public int getFine() {
        return fine;
    }
    
}
