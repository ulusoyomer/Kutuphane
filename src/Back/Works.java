
package Back;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Works {
    private final String db_host = "localhost";
    private final String db_port = "3306";
    private final String db_name = "library";
    private final String db_userName = "root";
    private final String db_userPass = "";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;

    public Works() {
        String url = "jdbc:mysql://"+db_host+":"+db_port+"/"+db_name+"?useUnicode=true&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Paket Bulunamadı");
        }
        try {
            connection = DriverManager.getConnection(url,db_userName,db_userPass);
            System.out.println("Connection is ok");
        } catch (SQLException ex) {
            System.out.println("Url veya kullanıcı adı, şifrede hata var");
        }
    }
    
    public boolean login (String username, String pass){
        String query = "Select * from admins WHERE  name = ? AND password = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Login query hatası");
            return false;
        }
        
    }
    
    public ArrayList<MembersInfo> getMemebers(){
       ArrayList<MembersInfo> membersInfos = new ArrayList<MembersInfo>();
        try {
            statement = connection.createStatement();
            String query = "Select * FROM members";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                name= name.toLowerCase();
                String surname = rs.getString("surname");
                surname = surname.toLowerCase();
                Date regDate = rs.getDate("regdate");
                long tcno = rs.getLong("Tcno");
                String tel = rs.getString("tel");
                membersInfos.add(new MembersInfo(id, name, surname, tcno, tel ,regDate));
            }
            return membersInfos;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<BooksInfo> getBooks(){
        ArrayList<BooksInfo> booksInfos = new ArrayList<BooksInfo>();
        try {
            statement = connection.createStatement();
            String query = "Select books.id,books.name,books.writer,books.year,books.publisher,books.page,books.type FROM books LEFT JOIN transactions on books.id = transactions.bookid WHERE transactions.bookid IS NULL";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                name = name.toLowerCase();
                String writer = rs.getString("writer");
                writer = writer.toLowerCase();
                Date year = rs.getDate("year");
                String publisher = rs.getString("publisher");
                publisher = publisher.toLowerCase();
                int page = rs.getInt("page");
                String type = rs.getString("type");
                type = type.toLowerCase();
                booksInfos.add(new BooksInfo(id, name, writer, publisher, page, type, year));
            }
            return booksInfos;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
       
    } 
    public ArrayList<TranInfo> getTranInfos(){
        ArrayList<TranInfo> tranInfos = new ArrayList<TranInfo>();
        try {
            statement = connection.createStatement();
            String query = "Select transactions.id AS 'traid',transactions.memid,transactions.bookid,members.name as 'memName',members.surname,books.name as 'bookName',transactions.gudate,transactions.gbdate from transactions,members,books WHERE transactions.memid=members.id AND transactions.bookid=books.id";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("traid");
                int memid = rs.getInt("memid");
                int bookid = rs.getInt("bookid");
                String members_Firstname = rs.getString("memName");
                String memner_lastname = rs.getString("surname");
                String name = members_Firstname+" "+memner_lastname;
                name = name.toLowerCase();
                String book = rs.getString("bookName");
                book = book.toLowerCase();
                Date gudate = rs.getDate("gudate");
                Date gbdate = rs.getDate("gbdate");
                tranInfos.add(new TranInfo(id, memid, bookid, gudate, gbdate, name, book));
            }
            return tranInfos;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean addBook(String name,String writer,Date date,String publisher,String type,int page){
        try {
            String query = "INSERT INTO books (name,writer,year,publisher,page,type) values (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, writer);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, publisher);
            preparedStatement.setInt(5, page);
            preparedStatement.setString(6, type);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean addMember(String name , String username , long tcno,String tel){
        try {
            String query = "Select * from members where Tcno = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, tcno);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next() == true){
                return false;
            }
        } catch (SQLException e) {
        }
        try {
            String query = "Insert Into members (name,surname,Tcno,tel) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setLong(3, tcno);
            preparedStatement.setString(4, tel);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean updateMember(String name, String surname,long tc, String tel,int id){
        try {
            String query = "Update members set name = ? , surname = ? , Tcno = ? , tel = ? where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setLong(3, tc);
            preparedStatement.setString(4, tel);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean updateBooks(int book_id,String name,String writer, Date date, String publisher,int page,String type){
        String query = "Update books set name = ?,writer = ?,year = ?,publisher = ?,page = ?,type = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, writer);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, publisher);
            preparedStatement.setInt(5, page);
            preparedStatement.setString(6, type);
            preparedStatement.setInt(7, book_id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean addTran(int memid,int bookid,Date gbdate){
        String query = "Insert Into transactions (memid,bookid,gbdate) values (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, memid);
            preparedStatement.setInt(2, bookid);
            preparedStatement.setDate(3, gbdate);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean deleteTran(int tranid){
        String query = "Delete from transactions where id = ? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tranid);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean deleteMem(int id){
        String query = "Delete from members where id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean deleteBook(int id){
        String query = "Delete from books where id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Works.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
