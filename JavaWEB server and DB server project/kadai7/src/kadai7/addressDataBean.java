package kadai7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addressDataBean {
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
	"jdbc:mysql://red99.ced.cei.uec.ac.jp:3306/J2AB",
	"t1910426","usbukr");
	conn.setAutoCommit(true);
	return conn;
	}
public String[] GetAddress(String zip) {
		
		PreparedStatement prstmt = null;
		String sql ="select * from ZIP where zip= ?";
		Connection conn = null;
		ResultSet rs = null;
		String[] addr = new String[3];
		try {
			conn = createConnection();
			prstmt = conn.prepareStatement(sql);
			prstmt.setString(1,zip);
			rs = prstmt.executeQuery();
		
		while (rs.next()) {
			addr[0] = rs.getString("addr1");
			addr[1] = rs.getString("addr2");
			addr[2] = rs.getString("addr3");	
				
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

		return addr;
		
		}
	
}
