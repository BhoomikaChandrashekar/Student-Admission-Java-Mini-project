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
   
    

    <title>Admission Section</title>
    <style type="text/css">
     
body{
    padding: 70px;
    background:url(images/backgroundimproper.jpg) ;
}
#mainNav{
    
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
#buttoncol{
    background:  #ff6600;
    color: white;
}
#buttoncol:hover{
    background: #cc5200;
    
}

#back{
    background: #ffb380;
}

#back1{
    background: #85e085;
}


#back2{
    background: #bf8040;
}

#back3{
    background: #16130f5e;
}

#back4{
    background: #f76060;
}

#buttoncol1{
    /*background:   #85e085;*/
    background:black;
    color: white;
}
#buttoncol1:hover{
    background:  #3c443e;
}

#buttoncol2{
    background: #bf8040;
    color: white;
    
}
#buttoncol2:hover{
    background: #4d3319;
    
}
#buttoncol3{
    background: #b4aca3;
    color: white;
}
#buttoncol3:hover{
    background: #000000;
    
}

#buttoncol4{
    background:  #ffff66;
    color: white;
}
#buttoncol4:hover{
    background: #b3b300;
    
}
.container{
    width:700px;
    /*height:350px;*/
} 
.btn{
    margin-left:120px;
}
    </style>
  </head>
  
  <body>
     
    <nav id="mainNav" class="navbar navbar-dark navbar-expand-md fixed-top" >
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
                 <a href="#" class="nav-link">REMOVAL</a>
              </li>
             </ul>  
        </div>
    </nav>

    
    
    
        <section id="back1" class="container">
           <div class="row align-items-center" >
               <!--<div class="col-lg-6 pl-0">-->
                   <div class="card size" style="width: 20rem;">
                       <img class="card-img-top" src="images/adcancel.jpeg" alt="Card image cap">
                       <div class="card-body">
                         <h5 class="card-title">Admission Cancellation Request</h5>
                         <!--<p class="card-text">Canceling the Admission based on the request of the student</p>-->
                         
                       </div>
                     </div>                
               <!--</div>--> 
               <div class="col-sm-6">
                   <h3>Admission Cancellation Request</h3>
                   <p class="lead" align="justify">If the student has voluntarily submitted a form for Cancellation of His/Her Admission in the college, then click on the "remove" button</p>  
                   <a href="cancellation.jsp" class="btn " id="buttoncol1">Remove</a>
               </div>  
           </div>              
        </section>
   
    
    <section id="back2" class="container  mt-4">
       <div class="row align-items-center ">
<!--           <div class="col-lg-6 pl-0">-->
               <div class="card" style="width: 20rem;">
                   <img class="card-img-top" src="images/unpaidfee.jpeg" alt="Card image cap">
                   <div class="card-body">
                     <h5 class="card-title">Unpaid Fees</h5>
                     <!--<p class="card-text">In case of unpaid fees for the present semester of the ongoing acdemic year press below</p>-->
                     
                   </div>
                 </div>                
<!--           </div>  -->
           <div class="col-lg-6">
               <h1>Unpaid Fees</h1>
               <p class="lead">If the academic fees has not been paid by the student then in order to remove or generate a list of those student please click below</p>    
               <a href="fees.jsp" class="btn " id="buttoncol1">Remove</a>
           </div>  
       </div>              
    </section>




    <section id="back4" class="container  mt-4">
       <div class="row align-items-center ">
           <div class="col-lg-6 pl-0">
               <div class="card" style="width: 20rem;">
                   <img class="card-img-top" src="images/fight.png" alt="Card image cap">
                   <div class="card-body">
                     <h5 class="card-title">Others</h5>
                     <!--<p class="card-text">In case of misbehaviour, fights, breaking the rules of college to remove the student from the database click below </p>-->
                     
                   </div>
                 </div>                
           </div>  
           <div class="col-lg-6">
               <h1>Others</h1>   
               <p class="lead">In case of misbehaviour by the student where a request for removal of student has been given,then press "remove" button</p>   
               <a href="others.jsp" class="btn " id="buttoncol1">Remove</a>
           </div>  
       </div>              
    </section>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
  </body>
</html>