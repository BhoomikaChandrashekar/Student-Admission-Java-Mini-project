import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDetails extends HttpServlet {
    Connection con;
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        
        try {
            
            String adm=req.getParameter("adm");
            PreparedStatement ps;
            PrintWriter out = res.getWriter();
            String query="select * from StudentDetails where adm=?";
            ResultSet rs1=null;
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
                            "<style>\n" +
                            " body{ background-image:url(\"images/backgroundimproper.jpg\");}\n" +
                            ".tab{margin-left:100px;}\n" +
                            ".tag{width:30%;text-align:center;font-size:25px;}\n" +
                            ".colon{float:right;}\n" +
                            "input{font-size:20px;}\n" +
                            ".button{width:100px;}\n" +".margin{margin-top:200px;}.button{width:100px;}"+".div{height:50px;}\n" +
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
"                font-size: 1.2rem;"+
                            "</style>\n" +
                            "</head>\n" +
                            "\n" );
            out.println("<body><div class=\"div\">\n" +
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
            try {
                ps=con.prepareStatement(query);
                ps.setString(1,adm);
                rs1=ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(rs1.next()){
               out.println("<h3 align=\"center\" class=\"margin\">Student is already admitted into the college</h3>");
               out.println("</body></html>");
            }
            else{
                try {
                    res.setContentType("text/html");
                    
                    
                    String query1="select * from Student where adm=?";
                    
                    ps=con.prepareStatement(query1);
                    ps.setString(1,adm);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        out.println(
                                "<h4 align=\"center\"><u>Add New Student</u></h4>\n" +
                                "  <div class=\"tab\">\n" +
                                "    <table class=\"table table-borderless col-md-6\" align=\"center\">\n" +
                                "	\n" +
                                "	<tr >\n" +
                                "		<td>\n" +
                                "            <div class=\"row justify-content-right ml-5 \">\n" +
                                "				<div class=\"tag\">Admission No.\n" +
                                "				<div class=\"colon\">:</div>\n" +
                                "				</div>\n" +
                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(1)+"' name=\"adm\" readonly>\n" +
                                        "            </div>\n" +
                                        "          </td>\n" +
                                        "        </tr>\n" +
                                        "	\n" +
                                        "	<tr >\n" +
                                        "		<td>\n" +
                                        "            <div class=\"row justify-content-right ml-5 \">\n" +
                                        "				<div class=\"tag\">USN\n" +
                                        "				<div class=\"colon\">:</div>\n" +
                                        "				</div>\n" +
                                        "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(2)+"' name=\"usn\" readonly>\n" +
                                                "            </div>\n" +
                                                "          </td>\n" +
                                                "        </tr>\n" +
                                                "	\n" +
                                                "        <tr >\n" +
                                                "		<td>\n" +
                                                "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                "				<div class=\"tag\">Name\n" +
                                                "				<div class=\"colon\">:</div>\n" +
                                                "				</div>\n" +
                                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(3)+"' name=\"name\"  readonly>\n" +
                                                        "            </div>\n" +
                                                        "          </td>\n" +
                                                        "        </tr>\n" +
                                                        "		\n" +
                                                        "		<tr >\n" +
                                                        "		<td>\n" +
                                                        "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                        "				<div class=\"tag\">DOB\n" +
                                                        "				<div class=\"colon\">:</div>\n" +
                                                        "				</div>\n" +
                                                        "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(4)+"' name=\"dom\" readonly>\n" +
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
                                                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(5)+"' name=\"branch\" readonly>\n" +
                                                                        "            </div>\n" +
                                                                        "          </td>\n" +
                                                                        "        </tr>\n" +
                                                                        "		\n" +
                                                                        "		<tr >\n" +
                                                                        "		<td>\n" +
                                                                        "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                                        "				<div class=\"tag\">Residential Address\n" +
                                                                        "				<div class=\"colon\">:</div>\n" +
                                                                        "				</div>\n" +
                                                                        "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(6)+"' name=\"addr\" readonly>\n" +
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
                                                                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(7)+"' name=\"city\" readonly>\n" +
                                                                                        "            </div>\n" +
                                                                                        "          </td>\n" +
                                                                                        "        </tr>\n" +
                                                                                        "		\n" +
                                                                                        "		<tr >\n" +
                                                                                        "		<td>\n" +
                                                                                        "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                                                        "				<div class=\"tag\">State\n" +
                                                                                        "				<div class=\"colon\">:</div>\n" +
                                                                                        "				</div>\n" +
                                                                                        "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(8)+"' name=\"state\" readonly>\n" +
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
                                                                                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(9)+"' name=\"count\" readonly>\n" +
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
                                                                                                        "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(10)+"' name=\"email\" readonly>\n" +
                                                                                                                "            </div>\n" +
                                                                                                                "          </td>\n" +
                                                                                                                "        </tr>\n" +
                                                                                                                "        	\n" +
                                                                                                                "		<tr>\n" +
                                                                                                                "		<td>\n" +
                                                                                                                "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                                                                                "				<div class=\"tag\">Phone No.\n" +
                                                                                                                "				<div class=\"colon\">:</div>\n" +
                                                                                                                "				</div>\n" +
                                                                                                                "              <input type=\"text\" size=\"35\" class=\"border border-success rounded  ml-3 pl-2\" value='"+rs.getString(11)+"' name=\"phno\" readonly>\n" +
                                                                                                                        "            </div>\n" +
                                                                                                                        "          </td>\n" +
                                                                                                                        "        </tr>\n" +
                                                                                                                        "		\n" +
                                                                                                                        "		<tr>\n" +
                                                                                                                        "		<td>\n" +
                                                                                                                        "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                                                                                        "				<div class=\"tag\">PUC Marks List\n" +
                                                                                                                        "				<div class=\"colon\"> </div>\n" +
                                                                                                                        "				</div>\n" +
                                                                                                                        "				<form action=\"FileReadPdf1\" method=\"POST\">\n" +
                                                                                                                        "					<input type=\"hidden\" name=\"usn\" value='"+rs.getString(2)+"'>\n" +
                                                                                                                                "					<input type=\"submit\"  class=\"btn btn-primary button ml-3\" value=\"Doc1\" name=\"view\"/>\n" +
                                                                                                                                "				</form>\n" +
                                                                                                                                "            </div>\n" +
                                                                                                                                "          </td>\n" +
                                                                                                                                "        </tr>\n" +
                                                                                                                                "		\n" +
                                                                                                                                "		<tr>\n" +
                                                                                                                                "		<td>\n" +
                                                                                                                                "            <div class=\"row justify-content-right ml-5 \">\n" +
                                                                                                                                "				<div class=\"tag\">Aadhar\n" +
                                                                                                                                "				<div class=\"colon\"> </div>\n" +
                                                                                                                                "				</div>\n" +
                                                                                                                                "				<form action=\"FileReadPdf1\" method=\"POST\">\n" +
                                                                                                                                "					<input type=\"hidden\" name=\"usn\" value='"+rs.getString(2)+"'>\n" +
                                                                                                                                        "					<input type=\"submit\"  class=\"btn btn-primary button ml-3\" value=\"Doc2\" name=\"view\"/>\n" +
                                                                                                                                        "				</form>\n" +
                                                                                                                                        "            </div>\n" +
                                                                                                                                        "          </td>\n" +
                                                                                                                                        "        </tr>\n" +
                                                                                                                                        "	</table>\n" +
                                                                                                                                        "	<form action=\"pdf\" method=\"POST\" align=\"center\">\n" +
                                                                                                                                        "               <input type=\"hidden\" name=\"usn\" value='"+rs.getString(2)+"'>\n" +
                                                                                                                                                "		<input type=\"submit\"  class=\"btn btn-success mt-2 mb-3\" value=\"ACCEPT\" name=\"view\">\n" +
                                                                                                                                                "		<input type=\"submit\"  class=\"btn btn-danger mt-2 mb-3 ml-2\" value=\"REJECT\" name=\"view\">\n" +
                                                                                                                                                "	</form>\n" +
                                                                                                                                                "	</body></html>");
                    }
                    else
                    {
                        out.println("<h3 align=\"center\" class=\"margin\">Student With Admission Number : "+adm+"\nis not present</h3> </body></html>");
                      
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
