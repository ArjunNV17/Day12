

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.cj.xdevapi.Statement;
// 1.We need to import a package
// 2 load and register the driver - com.mysql.jdbc.driver
// 3 establish the connection
// 4 create the statements
// 5 execute the query
// 6 process result
// 7 close the connection
public class JdbcDemo1 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String userName="root";
		String pwd="nam1234";
		String query="select * from sample";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,pwd);
		Statement st=con.createStatement();
//		st.executeQuery(query);
		ResultSet rs=st.executeQuery(query);
		while (rs.next()) {
//			int id=rs.getInt(1);
						


			String email=rs.getString(3);
			String name = null;
			System.out.println("Name is "+name+" email is :"+email);
		}
		st.close();
		con.close();
	}
}
