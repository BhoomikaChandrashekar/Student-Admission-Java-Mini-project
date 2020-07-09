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


    
public class stored1 extends HttpServlet{
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stored1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(stored1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

         response.setContentType("text/html");
         PrintWriter out=response.getWriter(); 
         
         String value=(String)request.getParameter("value");
         String reason=(String)request.getParameter("reason");
        
         request.setAttribute("rea",reason);
          request.setAttribute("lat",value);
   
       try{
                

                 /*PreparedStatement ps2=con.prepareStatement("select * from studentdetails where usn=(?)"); 
                 ps2.setString(1,usn);
                 ResultSet rs=ps2.executeQuery();

                 while(rs.next())
                 {


                        
                 }*/

                
                 PreparedStatement ps1=con.prepareStatement("delete from studentdetails where usn=(?)"); 
                 ps1.setString(1,value);
                 int n=ps1.executeUpdate();  
                  PreparedStatement ps=con.prepareStatement("insert into reason values(?,?)"); 
                 ps.setString(1,value);
                 ps.setString(2,reason); 
                 int m=ps.executeUpdate();
                 request.setAttribute("test",m);
  
         }catch(Exception e){out.println(e);}
            
             

        request.getRequestDispatcher("studentremove.jsp").forward(request,response);

      }


}

