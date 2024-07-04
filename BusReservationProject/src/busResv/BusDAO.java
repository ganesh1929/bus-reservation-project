package busResv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
	public void displayBusInfo() throws SQLException{
		String quary ="Select * from bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(quary);
		
		while(rs.next()) {
			System.out.println("Bus No: " + rs.getInt(1));
			if(rs.getInt(2)==0) {
				System.out.println("Ac: no");
				
			}
			else {
				System.out.println("Ac: yes ");
				System.out.println("Capacity: "+ rs.getInt(3));
			}
			System.out.println("------------------------------------------------------------");
		}
		
		
	}
	public int getCapacity(int id) throws SQLException{
		
		String quary =" select capacity from bus where id= " +id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(quary);
		rs.next();
		return rs.getInt(1);
	}

}
