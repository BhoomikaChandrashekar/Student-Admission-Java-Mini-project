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

public class Updation extends HttpServlet {
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Updation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Updation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         String action=request.getParameter("Pay");
         String usn1=request.getParameter("usn");
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         if("PAID".equalsIgnoreCase(action))
         {
            PreparedStatement ps;
             try {
                 ps = con.prepareStatement("update StudentDetails set fees=? where usn=?");
                 ps.setString(1,"Paid");
                 ps.setString(2, usn1);
                 int y=ps.executeUpdate();
                 if(y>0){
                    out.println("<html lang=\"en\">\n" +
"<head>\n" +
"  \n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"\n" +
" \n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,300,400,700\" rel=\"stylesheet\">\n" +
"\n" +
"  \n" +
"  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\n" +
"    integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n" +
"<style>\n" +".div{height:50px;}\n" +
"            #mainNav .navbar-brand{\n" +
"                font-size: 1.5rem;\n" +
"                color: white;\n" +
"            }\n" +
"\n" +
"            #mainNav .nav-link{\n" +
"                color: black;\n" +
"            }\n" +
"\n" +
"            #mainNav .nav-link:hover{\n" +
"                font-size: 1.2rem;\n" +
"            }"+
"	.button{\n" +
"		width:100px;\n" +
"	}\n" +"body{ background-image:url(\"images/backgroundimproper.jpg\");}"+".margin{margin-top:200px;}.button{width:100px;}"+
"</style>\n" +
"</head>");
                    out.println("<div class=\"div\">\n" +
"        <nav id=\"mainNav\" class=\"navbar navbar-dark navbar-expand-md fixed-top\" >\n" +
"        <div class=\"collapse navbar-collapse\" id=\"navLinks\">\n" +
"             <ul class=\"navbar-nav\">\n" +
"                 <li class=\"navbar-item\">\n" +
"                    <a href=\"student.html\" class=\"nav-link\">ADMISSION</a>\n" +
"                 </li>\n" +
"                 <li class=\"navbar-item\">\n" +
"                   <a href=\"feePayment.html\" class=\"nav-link\">FEES</a>\n" +
"                </li>\n" +
"                <li class=\"navbar-item\">\n" +
"                 <a href=\"studentremove.jsp\" class=\"nav-link\">REMOVAL</a>\n" +
"              </li>\n" +
"             </ul>  \n" +
"        </div>\n" +
"    </nav>\n" +
"        </div>");
                    out.println("<h1 align=\"center\" class=\"margin\">Updated Successfully</h1>");
                    out.println("</body></html>");
                 }
                 else{
                    out.println("<h1 align=\"center\" class=\"margin\">Error in Updation</h1>");
                    out.println("</body></html>");
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(Updation.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         else if("EXIT".equalsIgnoreCase(action))
         {
             //response.sendRedirect("StudentInformation/index");
            RequestDispatcher rd=request.getRequestDispatcher("/index.html");
            rd.include(request, response);
         }
     }
}
