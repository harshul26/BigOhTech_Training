package Day_4_LibraryManagementSystem;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
    private List<Books> listOfBooks;
    private List<Members> listOfMembers;
    private SearchCatalogue searchCatalogue;
    private Backend_Calculations calculations;

    public LibraryManagement(){
        this.listOfBooks = new ArrayList<>();
        this.listOfMembers = new ArrayList<>();
        searchCatalogue = new SearchCatalogue();
        calculations = new Backend_Calculations();
    }


    public List<Members> getMembers() {
        return listOfMembers;
    }

    public List<Books> getListOfBooks(){
        return listOfBooks;
    }

    public List<Books> searchBooks(String author , String title , String category , String date){
        List<Integer> booksId = new ArrayList<>();
        if(author != null){
            booksId.addAll( searchCatalogue.searchBookByAuthor(author , this));
        }
        if(title != null){
            booksId.addAll( searchCatalogue.searchBookByAuthor(author , this));
        }
        if(category != null){
            booksId.addAll( searchCatalogue.searchBookByAuthor(author , this));
        }
        if(date != null){
            booksId.addAll(searchCatalogue.searchBookByDate(date, this));
        }

        List<Books> bookObjects = new ArrayList<>();
        for(Books book : listOfBooks){
            if(booksId.contains(book.getBookId())){
                bookObjects.add(book);
            }
    
        }

        return bookObjects;
    }

    public boolean isBookAvailable(Books findBook){
        for(Books book : listOfBooks){
            if(book.getBookId() == findBook.getBookId()){
                return true;
            }
        }
        return false;
    }

    public void showAllBooks(){
        for(Books book : listOfBooks){
            book.showDetailsOfBook();
        }
    }

    public boolean notifyBookAvailable(Books reservedBook , String message){
        for(Books book : listOfBooks){
            if(book.getBookId() == reservedBook.getBookId()){
                if(book.getNoOfCopies() == 0){
                    return false;
                }
            }
        }

        for(Members member : listOfMembers){
            for(Books books : member.getReserveBooks()){
                if (books.getBookId() == reservedBook.getBookId()) {
                    member.getRecievedMessages().add(message);
                    return true;
                }
            }
        }

        return true;
    }
    
    public boolean checkIfOverdueBooks(Books bookOverdue , String message) throws ParseException{
        Date currdate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy"); 
        for(Books book : listOfBooks){
            if(book.getBookId() == bookOverdue.getBookId()){
                for(Members member : listOfMembers){
                    for(int i = 0; i < member.getIssuedBooks().size(); i++){
                        if(bookOverdue.getBookId() == member.getIssuedBooks().get(i).getBookId()){
                            String publishedDate = member.getIssuedBooks_bydate().get(i);
                            int noOfDaysBorrowed = calculations.findDateDifference(publishedDate , ft.format(currdate));
                            if(noOfDaysBorrowed > 10){
                                int fineInRupees = calculations.calculateFine_Overdue(noOfDaysBorrowed);
                                notifyIfBookOverdue( member , message ,fineInRupees);
                                return true; 
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void notifyIfBookOverdue(Members memberToNotify , String message , int fineInRupees){
        memberToNotify.getRecievedMessages().add(message);
        memberToNotify.getRecievedMessages().add("Your Due fine if of Rupees " + fineInRupees);
        memberToNotify.addFine(fineInRupees);
    }
    

}
