
<%@ page language="java" contentType="text/html" import="java.util.*"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,300,400,700" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!-- Custom CSS -->
   
    <style type="text/css">
      body{
     background-image: url("images/backgroundimproper.jpg");
     
    }
     #header{
     font-size: 1.5rem;
     color:black;
    }
     #mainNav .navbar-brand{
    font-size: 1.5rem;
    color: black;
}

#mainNav .nav-link{
    color: black;
}

#mainNav .nav-link:hover{
    font-size: 1.2rem;
}
.heading{
    margin-left:120px;
    margin-bottom: 40px;
}
.reason{
    padding-right:500px;
}
     </style>

    <title>Cancellation Request</title>
  </head>
  
  <body>
         
    
    <nav id="mainNav" class="navbar navbar-dark navbar-expand-md " >
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navLinks">
             <ul class="navbar-nav">
                 <li class="navbar-item">
                    <a href="add.html" class="nav-link">ADMISSION</a>
                 </li>
                 <li class="navbar-item">
                   <a href="feePayment.html" class="nav-link">FEES</a>
                </li>
                <li class="navbar-item">
                 <a href="studentremove.jsp" class="nav-link">REMOVAL</a>
              </li>
             </ul>  
        </div>
    </nav>
      <div class="heading"><h1>Request for Admission Cancellation</h1></div>
      <div class="container">
          <form action="AddPdf" method="POST" id="usnform">
         <div class="row mb-3">
             <div class="col-12">
                 <label for="usn"><h4>Enter USN of the student :</h4></label>
                 <input type="text " class="border border-success rounded ml-3" id="usn" name="usn1">
                 <input type="submit" name="go" onclick="return validateForm(this)" class="btn btn-info">
             </div>
         </div>
         
         
        
       
        
         <div class="row">
             <div class="col-md-8">
              <table class="table table-borderless">
                      
                  <tbody>
                    <tr>  
                      <td>
                          <div class="row justify-content-between pr-5 pl-3">
                            <h4>Name :</h4>
                            <input type="text" size="35" value='<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>' class="border border-success rounded" disabled>
                          </div>
                        </td>        
                     
                    </tr>
                    <tr>
                      <td>
                          <div class="row justify-content-between pr-5 pl-3">
                            <h4>Branch :</h4>
                            <input type="text" size="35" value='<%=request.getAttribute("branch")==null?"":request.getAttribute("branch")%>' class="border border-success rounded" disabled>
                          </div>
                        </td>
                     
                    </tr>
                    <tr>
                      <td>
                          <div class="row justify-content-between pr-5 pl-3">
                            <h4>Email ID :</h4>
                            <input type="text" size="35" value='<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>' class="border border-success rounded" disabled>
                          </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row justify-content-between pr-5 pl-3">
                              <h4>Admission No. :</h4>
                              <input type="text" size="35" value='<%=request.getAttribute("admis")==null?"":request.getAttribute("admis")%>' class="border border-success rounded" disabled>
                            </div>
                          </td>
                      </tr>
                     
                  </tbody>
                </table>
             </div>
         </div>
          </form>
          <%!
             String myusn;
          %>
          <%
            myusn=request.getAttribute("seat")==null?"":request.getAttribute("seat").toString();
            %>
       
        
         
           <table class="table table-borderless">
              <form action="stored1" method="post">            
                <tbody>
                  <tr>  
                      <td>
                      <div class="row justify-content-between reason pl-3">
                          <h4>Enter the reason for removal :</h4>
                          <textarea name="reason" id="" cols="40" rows="5" class="rounded pl-0"></textarea></td></div>
                    <td> <input type="text" size="30" name="value" value="<%=myusn%>" class="border border-success rounded" hidden></td>
                  </tr>
                  <tr>
                     
                      <td><input type="submit" value="remove" class="btn btn-info "></td>
                  </tr>
                 
                </tbody>
              </form>
              </table>
            
           
      </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script type="text/javascript">
      function validateForm(button){
        var form=document.getElementById('usnform');
        var val=form.usn.value;
        const pattern=RegExp('^[1-9][a-zA-z][a-zA-z][0-9][0-9][a-zA-z][a-zA-z][0-9][0-9][0-9]$');
         if(pattern.test(val))
          {
            return true;
          }
          else{
            alert('please enter valid usn');
            return false;
          }
            
    
      }
    </script>	
  </body>
</html>