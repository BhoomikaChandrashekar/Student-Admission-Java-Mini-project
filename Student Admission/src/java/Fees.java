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

public class Fees extends HttpServlet {
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fees.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Fees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       String usn1=request.getParameter("usn").toUpperCase();
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
        try {
            PreparedStatement ps = con.prepareStatement("select * from Studentdetails where usn=?");
            ps.setString(1, usn1);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                out.println("<html lang=\"en\">\n" +
"\n" +
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
"\n" +
"  \n" +
"  <link rel=\"stylesheet\" href=\"i-mproper.css\">\n" +
"  \n" +
"  <style>\n" +
".tab{\n" +
"	margin-left:100px;\n" +
"}\n" +
".tag{\n" +
"	width:30%;\n" +
"	-background:red;\n" +
"	text-align:center;\n" +
"	font-size:25px;\n" +
"}\n" +"body{ background-image:url(\"images/backgroundimproper.jpg\");}"+
".colon{\n" +
"float:right;\n" +
"}\n" +
"input{\n" +
"	font-size:20px;\n" +
"}\n" +".div{height:50px;}#mainNav .navbar-brand{font-size: 1.5rem;color: white;} #mainNav .nav-link{ color: black;}#mainNav .nav-link:hover{font-size: 1.2rem;}" +
"            }"+
"</style>\n" +
"</head>\n" +
"\n" +
"<body>\n"); 
         out.println("<div class=\"div\"><nav id=\"mainNav\" class=\"navbar navbar-dark navbar-expand-md fixed\" >\n" +
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
"    </nav></div>"+
"  <div class=\"tab\">\n" +
"    <table class=\"table table-borderless col-md-6\" align=\"center\">\n" +
"        <tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Name\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"25\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(3)+"'  readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">USN\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"25\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(2)+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Branch\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"25\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(5)+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n");
                
                
                if(rs.getString(12).equalsIgnoreCase("Not Paid"))
                {
                    out.println("<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Fees\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"25\" class=\"border border-success rounded  ml-3 pl-2\" value=\"NOT PAID\" readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		</table>");
                    
                    out.println("<form action=\"Updation\" method=\"POST\" align=\"center\">");
                    out.println("<input type=\"hidden\" name=\"usn\" value='"+usn1+"'> ");
                    out.println("<input type=\"submit\" value=\"PAID\" size=\"25\" class=\"btn btn-primary button mt-2\" name=\"Pay\">");
                    out.println("<input type=\"submit\" value=\"EXIT\" size=\"25\" class=\"btn btn-primary button mt-2\" name=\"Pay\">");
                    out.println("</form>");
                    out.println("</body></html>");
                }
                else
                {
                    out.println("<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Fees\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"25\" class=\"border border-success rounded  ml-3 pl-2\" value=\"PAID\" readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		</table>");
                    out.println("</table>");
                    out.println("</body></html>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fees.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
}
