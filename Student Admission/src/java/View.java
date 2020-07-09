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

public class View extends HttpServlet {
    Connection con;
    public void init() throws ServletException
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            PreparedStatement ps = con.prepareStatement("select * from StudentDetails order by usn");
            ResultSet rs=ps.executeQuery();
            out.println("<html>\n" +
"    <head>\n" +
"        <title>Details</title>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"        \n" +
"        <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,300,400,700\" rel=\"stylesheet\">\n" +
"        \n" +
"        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\"></head><body>");
            out.println("<h1 align='center' ><u>Student Details:</u></h1>");
            out.println("<table align='center'  color='black' class=\"table table-striped\" cellspacing='0px' cellpadding='20px'><tr><th>ADMISSION NO.</th><th>USN</th><th>NAME</th><th>DOB</th><th>BRANCH</th><th>CITY</th><th>EMAIL-ID</th><th>PHONE NO.</th>");
            while(rs.next())
            {
                out.println("<tr><td>"+rs.getString(1)+"</td>");
                out.print("<td>"+rs.getString(2)+"</td>");
                out.print("<td>"+rs.getString(3)+"</td>");
                out.print("<td>"+rs.getString(4)+"</td>");
                out.print("<td>"+rs.getString(5)+"</td>");
                out.print("<td>"+rs.getString(7)+"</td>");
                out.print("<td>"+rs.getString(10)+"</td>");
                out.print("<td>"+rs.getString("phone")+"</td>");
                
            }
            out.println("</table>");
            out.println("<form action=\"Exit\" method=\"POST\" align=\"center\">");
            out.println("<input type=\"submit\" value=\"EXIT\" class=\"btn btn-primary button mt-2\" name=\"Pay\">");
            out.println("</form>");
            out.println("</body></html>");
            
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void destroy()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
