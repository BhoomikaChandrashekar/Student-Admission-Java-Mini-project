import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exit extends HttpServlet {
//    Connection con;
//    public void init() throws ServletException
//    {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
//        } catch (SQLException ex) {
//            Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
     public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         RequestDispatcher rd=request.getRequestDispatcher("/index.html");
         rd.include(request, response);
     }
}
