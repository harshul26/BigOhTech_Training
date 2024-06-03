package Day_4_LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class SearchCatalogue {

    public List<Integer> searchBookByAuthor(String auther , LibraryManagement library){
        List<Integer> booksIdList = new ArrayList<>();

        for(Books book : library.getListOfBooks()){
            if(book.getBookAuthor().equals(auther)){
                booksIdList.add(book.getBookId());
            }
        }

        return booksIdList;
    }

    public List<Integer> searchBookByCategory(String category , LibraryManagement library){
        List<Integer> booksIdList = new ArrayList<>();

        for(Books book : library.getListOfBooks()){
            if(book.getBookAuthor().equals(category)){
                booksIdList.add(book.getBookId());
            }
        }

        return booksIdList;
    }

    public List<Integer> searchBookByTitle(String title , LibraryManagement library){
        List<Integer> booksIdList = new ArrayList<>();

        for(Books book : library.getListOfBooks()){
            if(book.getBookAuthor().equals(title)){
                booksIdList.add(book.getBookId());
            }
        }

        return booksIdList;
    }

    public List<Integer> searchBookByDate(String date , LibraryManagement library){
        List<Integer> booksIdList = new ArrayList<>();

        for(Books book : library.getListOfBooks()){
            if(book.getBookAuthor().equals(date)){
                booksIdList.add(book.getBookId());
            }
        }

        return booksIdList;
    }


}
