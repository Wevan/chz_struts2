package Dao;

import Utils.JDBCUtil;
import bean.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChzRegistDao {
    private Connection conn = JDBCUtil.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Book> listBookInfo() {
        List<Book> list = new ArrayList();
        try {

            String sql = "SELECT * FROM books";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book books = new Book();
                books.setBookname(rs.getString("bookName"));
                books.setChzwriter(rs.getString("writer"));
                list.add(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
