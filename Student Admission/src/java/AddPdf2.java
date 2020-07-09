import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class AddPdf2 extends HttpServlet{
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPdf2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(AddPdf2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
     public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

         response.setContentType("text/html");
         PrintWriter out=response.getWriter(); 
         
         String usn=request.getParameter("usn1");
        
        
   
       try{
                 
                 PreparedStatement ps=con.prepareStatement("select * from studentdetails where usn=(?)"); 
                 ps.setString(1,usn);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next()==false)
                 { 
                     request.getRequestDispatcher("notsuccess.jsp").forward(request,response);

                  }
                 else{ 
                     rs.beforeFirst();
                 while(rs.next()) 
                  {
                         request.setAttribute("name",rs.getString("name"));
                          request.setAttribute("branch",rs.getString("branch"));
                           request.setAttribute("email",rs.getString("email"));
                            request.setAttribute("admis",rs.getString("adm"));
                             request.setAttribute("seat",usn);
                  }
		}
  
         }catch(Exception e){out.println(e);}

        request.getRequestDispatcher("others.jsp").forward(request,response);

      }




}

