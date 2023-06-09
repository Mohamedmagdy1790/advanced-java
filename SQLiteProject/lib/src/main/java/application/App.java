package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dburl="jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
      
      Connection connc= DriverManager.getConnection(dburl,"root","hello");
      System.out.println(connc);
      
      Statement stmt =connc.createStatement();
      System.out.println(stmt);
      //connc.setAutoCommit(false);
      
      var sql ="create table if not exists user (id integer primary key, name text not null)";
      stmt.execute(sql);
      
      
      
      sql ="insert into user(id, name) values (?,?)";
      
      PreparedStatement insertstmt= connc.prepareStatement(sql);
      
      int[] ids= {1,2,3};
      String[] names= {"ahmed","mohamed","body"};
      
      for(int i=0; i<names.length; i++) {
    	  
    	  insertstmt.setInt(1, ids[i]);
    	  insertstmt.setString(2, names[i]);
    	  
    	 //insertstmt.executeUpdate();
    	    
      }
      
      //connc.commit();

      
      insertstmt.close();
      
      
     sql="select * from user";
     ResultSet rs =stmt.executeQuery(sql);
      
      while(rs.next()) {
    	  
    	  int id = rs.getInt("id");
    	  String name =rs.getString("name");
    	  System.out.println(id+"   "+ name);
    	  
      }
      
      
     
      
      
      
      stmt.close();
      connc.close();
	}

}