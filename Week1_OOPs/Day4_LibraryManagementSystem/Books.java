package Day_4_LibraryManagementSystem;

public class Books {
    private int bookId;
    private String title , author , category;
    private int noOfCopies;

    public Books(){

    }

    public int getBookId(){
        return this.bookId;
    }

    public int getNoOfCopies(){
        return this.noOfCopies;
    }

    public String getBookTitle(){
        return this.title;
    }

    public String getBookAuthor(){
        return this.author;
    }

    public String getBookCategory(){
        return this.category;
    }

    public void setNoOfCopies(int copies) {
        this.noOfCopies = copies;
    }

    public void showDetailsOfBook() {
        //display the details of the book
    }
    
}
