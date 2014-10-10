package Action;



import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;



public class GetBook extends ActionSupport{
	
	private String author;
	private int age;
	private  String isbn;
	private String title;
	private  String authorid;
	private String publisher;
	private Date publishdate;
	private String country;
	private float price;
	
	public String getTitle() {
		return title;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Date getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getAuthorid() {
		return authorid;
	}


	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	private  Connection conn = null;
	private  Statement st = null;
	

	/**
	 * execute
	 */
	public String execute(){
		//isbn = "Hello everybody!!";
		queryAuthorid();
		queryBook();
		return "success";
	}
	
	
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Connection getConnection() {  
        Connection con = null;  //���������������ݿ��Connection����  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������  
               
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/bookdb", "root", "123456");// ������������  
              
        } catch (Exception e) {  
            System.out.println("���ݿ�����ʧ��" + e.getMessage());  
        }  
        return con; //���������������ݿ�����  
    }  
	public void queryAuthorid(){
		
		conn = getConnection();    //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try{
			String sql = "select * from author where name = '"+author+"'";   // ��ѯ���ݵ�sql���
			st = conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����
			ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
			while (rs.next()) {
				authorid = rs.getString("authorid");
				country = rs.getString("country");
				age = rs.getInt("age");
				System.out.println(authorid);
			}
			conn.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void queryBook() {
		
		conn = getConnection();    //ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try{
			String sql = "select * from book where authorid = '"+authorid+"'";    // ��ѯ���ݵ�sql���
			st = conn.createStatement();    //��������ִ�о�̬sql����Statement����st���ֲ�����
			
			ResultSet rs = st.executeQuery(sql);    //ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
			while (rs.next()) {
				isbn = rs.getString("isbn");
				title = rs.getString("title");
				publisher = rs.getString("publisher");
				publishdate = rs.getDate("publishdate");
				price = rs.getFloat("price");
				System.out.println(isbn);
				System.out.println(publisher);
				System.out.println(publishdate);
				System.out.println(title);
			}
			rs.close();
		}catch (Exception e) {
			System.out.println("failed!!!");
		}finally{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	/**
	 * 
	 * @set and get
	 */


	
	
} 
