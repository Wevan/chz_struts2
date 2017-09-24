package action;

import bean.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.ChzBookService;

import java.util.List;

/**
 * Created by Wean on 2017/9/11.
 */
public class ChzBookAction extends ActionSupport {
    private List books;

    public List getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }
    private Book book;
    private ChzBookService bookService=(ChzBookService)ActionContext.getContext().getSession().get("bookService");


    public ChzBookService getBookService() {
        return bookService;
    }
    public void setBookService(ChzBookService bookService) {
        this.bookService = bookService;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String execute() throws Exception {

        String chzuser = (String) ActionContext.getContext().getSession().get("chzuname");
        System.out.println("name is " + chzuser);
        if (chzuser != null) {
            ChzBookService bs = new ChzBookService();
            setBooks(bs.getBookList());
            ActionContext.getContext().getSession().put("books",bs.getBookList());
            return SUCCESS;
        } else {
            return LOGIN;
        }
    }

    public String add(){
        if(bookService==null){
            bookService=new ChzBookService();
            ActionContext.getContext().getSession().put("bookService", bookService);
        }
        bookService.addBook(book);
        System.out.println("添加书籍成功");
        return SUCCESS;

    }
    public String del(){
        return SUCCESS;

    }
    public String chg(){
        return SUCCESS;

    }
    public String find(){

        if(bookService==null){
            System.out.print("没有任何书籍的信息");
            return ERROR;
        }else{
            List<Book> bookList=bookService.getBookList();
            for(int i=0;i<bookList.size();i++){
                System.out.print(bookList.get(i).getBookname()+",");
                System.out.print(bookList.get(i).getChzwriter()+",");
            }
            return SUCCESS;
        }
    }

    public String change(){
        return SUCCESS;
    }

}
