import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/FileReadPdf1")
public class FileReadPdf1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FileReadPdf1() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {    
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String usn = request.getParameter("usn")!=null?request.getParameter("usn"):"NA";
      String action=request.getParameter("view");
        ServletOutputStream sos;
        Connection  con=null;
        PreparedStatement pstmt=null;
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition","inline; filename="+usn+".pdf" );
        sos = response.getOutputStream();
        try {
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation","root","");
          } catch (Exception e) {
                     System.out.println(e);
                     System.exit(0); 
                          }
         ResultSet rset=null;
          if(action.equals("Doc1"))
          {
            try {
                pstmt = con.prepareStatement("Select puc from student where usn=?");
                pstmt.setString(1,usn);
                rset = pstmt.executeQuery();
                if (rset.next())
                    sos.write(rset.getBytes("puc"));
                else
                    return;
                 
            } catch (SQLException e) {
                e.printStackTrace();
            }
          }
          else if(action.equals("Doc2"))
          {
             try {
                pstmt = con.prepareStatement("Select aadhar from student where usn=?");
                pstmt.setString(1,usn);
                rset = pstmt.executeQuery();
                if (rset.next())
                    sos.write(rset.getBytes("aadhar"));
                else
                    return;
                 
            } catch (SQLException e) {
                e.printStackTrace();
            } 
          }
     
        sos.flush();
        sos.close();
         
    }
 
}