package kadai7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDataBean {
	
	public Connection createConnection() throws
	ClassNotFoundException, SQLException {
	Connection conn = null;
	try {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (InstantiationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	conn = DriverManager.getConnection(
	"jdbc:mysql://red99.ced.cei.uec.ac.jp:3306/1910426db",
	"t1910426","usbukr");
	conn.setAutoCommit(true);
	return conn;
	}
	
public boolean AddRecord(String ID, String email,
		String password, String name, String name_kana
		, String zip, String addr1, String addr2, String addr3) {
		
		PreparedStatement prstmt = null;
		String sql ="insert into member values(?,?,?,?,?,?,?,?,?)" ;
		Connection conn = null;
		int rs = 0;
		try {
			conn = createConnection();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1,ID);
			prstmt.setString(2,email);
			prstmt.setString(3,password);
			prstmt.setString(4,name);
			prstmt.setString(5,name_kana);
			prstmt.setString(6,zip);
			prstmt.setString(7,addr1);
			prstmt.setString(8,addr2);
			prstmt.setString(9,addr3);
			rs = prstmt.executeUpdate();
		
		while (rs==1) {
			return true;	
				
		}}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
			conn.close();
			} catch (Exception ex) {
			} }

		return false;
		
		}


			
			
			public String checkPW(String ID, String password) {
				
				PreparedStatement prstmt = null;
				String sql ="select * from member where ID= ? AND password= ?";
				
						
				Connection conn = null;
				ResultSet rs = null;
				String name="";
				try {
					conn = createConnection();
					prstmt = conn.prepareStatement(sql);
					prstmt.setString(1,ID);
					prstmt.setString(2,password);
					rs = prstmt.executeQuery();
				
				while (rs.next()) {
					name = rs.getString("name");		
				}}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				finally {
					try {
					rs.close();
					conn.close();
					} catch (Exception ex) {
					} }
				
				
				return name;
				
				}

			

}
