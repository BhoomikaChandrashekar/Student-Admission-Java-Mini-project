import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold=1024*1024*10,maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*100)
public class pdf extends HttpServlet {
    Connection con;
    PreparedStatement ps;
    private static final long serialVersionUID = 1L;
    public pdf() {
        super();
    }
    public void init() throws ServletException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action=request.getParameter("view");
        response.setContentType("text/html");
        String usn=request.getParameter("usn");
        PrintWriter out = response.getWriter();
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
"    integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"+
       "<style>.margin{margin-top:200px;}.button{width:100px;} body{\n" +
"                background-image: url(\"images/backgroundimproper.jpg\");\n" +
"            }" +
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
"            }</style>");
        out.println("</head><body><div class=\"div\">\n" +
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
           if("ACCEPT".equals(action))
           {
            ResultSet rs1=null;
            try {
                ps=con.prepareStatement("select * from studentdetails where usn=?");
                ps.setString(1,usn);
                rs1=ps.executeQuery();   
                if(rs1.next())
                {
                    out.println("<h3 align=\"center\" class=\"margin\">Student details already exists</h3>");
                    rs1=ps.executeQuery();
                }     
                else 
                {
                    int y=0;

                    ps = con.prepareStatement("select adm,usn,name,dob,branch,addr,city,state,country,email,phone from student where usn=?");
                    ps.setString(1,usn);

                    ResultSet rs=null;

                    rs = ps.executeQuery();

                    String paid="Not Paid";


                    while(rs.next())
                    {
                        ps = con.prepareStatement("insert into studentdetails values(?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1,rs.getString("adm"));
                        ps.setString(2,rs.getString("usn"));
                        ps.setString(3,rs.getString("name"));
                        ps.setString(4,rs.getString("dob"));
                        ps.setString(5,rs.getString("branch"));
                        ps.setString(6,rs.getString("addr"));
                        ps.setString(7,rs.getString("city"));
                        ps.setString(8,rs.getString("state"));
                        ps.setString(9,rs.getString("country"));
                        ps.setString(10,rs.getString("email"));
                        ps.setString(11,rs.getString("phone"));
                        ps.setString(12,paid);
                         y=ps.executeUpdate();    
                    }



                     if(y>0)
                     { 
                         out.println("<h3 align=\"center\" class=\"margin\">Student Admission Processed Successfully</h3>");
                     }
                     else
                     {
                        out.println("<h3 align=\"center\" class=\"margin\">Error in admission process...plz update again</h3>");
                     }
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if("REJECT".equals(action))
        {
            out.println("<h3 align=\"center\" class=\"margin\">Sorry!!!</h3>");
            out.println("<h3 align=\"center\">Student admission rejected</h3>");
            out.println("</body></html>");
        }   
    }
}



