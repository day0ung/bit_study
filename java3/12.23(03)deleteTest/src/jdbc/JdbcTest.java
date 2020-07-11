package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
   public JdbcTest() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         System.out.println("Driver Loading Success!");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   public Connection getConnection() {
      
      Connection conn = null;
      
      try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.22:1521:xe", "hr", "hr");
      
      System.out.println("DB Connection Success!");
      
   } catch (SQLException e) {
      e.printStackTrace();
   }
      
     return conn;
      
   }
   
   public int Delete(String id) {
      
      String sql = " DELETE FROM USERDTO "
            + " WHERE ID = '" + id + "'";
      
      Connection conn = getConnection();
      Statement stmt = null;
      
      int count = 0;
      
      System.out.println("sql : " + sql);
      
      try {
      stmt = conn.createStatement();
      
      count = stmt.executeUpdate(sql); // 실제 DB에 영향을 주는 곳은 여기
      
   } catch (SQLException e) {
      
      e.printStackTrace();
   } finally {
      
      try {
         if(stmt != null) {
            stmt.close();
         }
         if(conn != null) {
            conn.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   return count;
   }
   
}