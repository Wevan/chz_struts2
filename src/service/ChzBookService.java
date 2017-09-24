package service;

import Dao.ChzRegistDao;
import bean.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wean on 2017/9/11.
 */
public class ChzBookService {
//    List books=new ArrayList();
//
//
//    public List getAllBooks(){
//
//        return new ChzRegistDao().listBookInfo();
//    }

    private List<Book> bookList=new ArrayList<Book>();


    public List<Book> getBookList() {
        return bookList;
    }


    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public String addBook(Book book){
        bookList.add(book);
        return "success";
    }

}
