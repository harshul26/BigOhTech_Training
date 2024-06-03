package Day_4_LibraryManagementSystem;

import java.util.List;

public class Librarian extends Members{

    private LibraryManagement library;
    List<Books> listOfBooks;
    List<Members> listOfMembers;
    public Librarian(String name, int id, Long contact , String barcode) {
        super(name, id, contact , barcode);
        library = new LibraryManagement();
        listOfBooks = library.getListOfBooks();
        listOfMembers = library.getMembers();
    }

    public boolean addMember(Members member){
        for(Members m : library.getMembers()){
            if(m.getPersonId() == member.getPersonId()){
                return false;
            }
        }

        library.getMembers().add(member);
        return true;
    }

    public boolean removeMember(Members member){
        for(Members m : listOfMembers){
            if(m.getPersonId() == member.getPersonId()){
                listOfMembers.remove(member);
                return true;
            }
        }
        return false;
    }

    public void showMemberDetails(){
        for(Members member : library.getMembers()){
            member.showDetails();
        }
    }
    
    public void addBooks(Books newBook , int noOfCopies){
        for(Books book : listOfBooks){
            if(book.getBookId() == newBook.getBookId()){
                book.setNoOfCopies(book.getNoOfCopies() + noOfCopies);
                return;
            }
        }
        newBook.setNoOfCopies(noOfCopies);
        listOfBooks.add(newBook);
    }

    public boolean removeBook(Books oldBook){
        for(Books book : listOfBooks){
            if(book.getBookId() == oldBook.getBookId()){
                book.setNoOfCopies(book.getNoOfCopies()-1);
                return true;
            }
        }
        return false;
        
    }

    public boolean issueBook(Books bookToIssue , Members memberForBook , String date){
        if(library.isBookAvailable(bookToIssue)){
            if(removeBook(bookToIssue)){
                for(Members member : listOfMembers){
                    if(member.getPersonId() == memberForBook.getPersonId()){
                        member.checkOutBook(bookToIssue, date);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean reserveBook(Books bookToreserve , Members memberForBook){
        for(Books book : listOfBooks){
            if(book.getBookId() == bookToreserve.getBookId() && book.getNoOfCopies() == 0){
                for(Members member : listOfMembers){
                    if(member.getPersonId() == memberForBook.getPersonId()){
                        member.reserveTheBook(bookToreserve);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean returnBook(Books bookToReturn , Members memberForBook){
        for(Members member : listOfMembers){
            if(member.getPersonId() == memberForBook.getPersonId()){
                for(Books book : listOfBooks){
                    if(book.getBookId() == bookToReturn.getBookId()){
                        if(memberForBook.returnTheBook(bookToReturn)){
                            book.setNoOfCopies(book.getNoOfCopies()-1);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean reIssueBook(Books bookToReIssue , Members memberForBook , String date){
        for(Members member : listOfMembers){
            if(member.getPersonId() == memberForBook.getPersonId()){
                for(Books book : listOfBooks){
                    if(book.getBookId() == bookToReIssue.getBookId()){
                        return memberForBook.checkOutBook(bookToReIssue, date);
                    }
                }
            }
        }
        return false;
    }

    public boolean cancelReservations(Books bookToCancel , Members memberForBook){
        for(Members member : listOfMembers){
            if(member.getPersonId() == memberForBook.getPersonId()){
                for(Books book : listOfBooks){
                    if(book.getBookId() == bookToCancel.getBookId()){
                        return memberForBook.cancelTheReservation(bookToCancel);
                    }
                }
            }
        }
        return false;
    }
    
}
