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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student extends HttpServlet {
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       String usn1=request.getParameter("usn").toUpperCase();
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
                      out.println("<html><head>\n" +
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
"}\n" +"body{background-image:url(\"images/backgroundimproper.jpg\");}"+
".tag{\n" +
"	width:30%;\n" +
"	-background:red;\n" +
"	text-align:center;\n" +
"	font-size:25px;\n" +
"}\n" +".div{height:50px;}\n" +
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
".colon{\n" +
"float:right;\n" +
"}\n" +".margin{margin-top:200px;}.button{width:100px;}"+
"input{\n" +
"	font-size:20px;\n" +
"}\n" +
"</style>\n" +"<title>StudentDetails</title>"+
"</head>");
                      out.println("<body><div class=\"div\">\n" +
"        <nav id=\"mainNav\" class=\"navbar navbar-dark navbar-expand-md \" >\n" +
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
        try {
            PreparedStatement ps = con.prepareStatement("select * from studentdetails where usn=?");
            ps.setString(1, usn1);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                out.println("<div class=\"tab\">\n" +
"    <table class=\"table table-borderless col-md-6\" align=\"center\">\n" +
"        <tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Name\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("name")+"'  readonly>\n" +
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
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("usn")+"' readonly>\n" +
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
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("branch")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">DOB\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("dob")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Residential Address\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("addr")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">City\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("city")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">State\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("state")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Country\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("country")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Email-ID\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("email")+"' readonly>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr>\n" +
"        \n" +
"		\n" +
"		<tr >\n" +
"		<td>\n" +
"            <div class=\"row justify-content-right ml-5 \">\n" +
"				<div class=\"tag\">Phone No\n" +
"				<div class=\"colon\">:</div>\n" +
"				</div>\n" +
"              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString("phone")+"' readonly/>\n" +
"            </div>\n" +
"          </td>\n" +
"        </tr></table>");
             out.println("<form action=\"Exit\" method=\"POST\" align=\"center\">");
             out.println("<input type=\"submit\" value=\"EXIT\" class=\"btn btn-primary button\" name=\"Pay\">");
             out.println("</form>");
             out.println("</body></html>");
            }
            else
            {
                out.println("<h3 align=\"center\" class=\"margin\">Details Not Found</h3>");
                out.println("</body></html>");
                
            }     
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void destroy()
    {
        try { 
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}



