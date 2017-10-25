<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
  <!DOCTYPE html>
   <html>

<head>

  <link rel="stylesheet" type="text/css" href="/ArticleHibernate/utlities/footer.css"/>
</head>
<body> 
    <div class="footer">
        <div class="fa">
           <div class="faa">
                <h3>Register for an Account</h3>
                <form method="post" action="<c:url value='/Register'/> "  enctype="multipart/form-data">
                    
	                 <input type="text" name="userName"  placeholder="User Name"/><br></br>
	        
	                 
	                 <input type="text" name="password"  placeholder="Password"/><br></br>
	      
	                
	                 <input type="text" name="email"  placeholder="E-Mail"/><br></br>
	                 
	              
	                 <input type="file" name="photo"  placeholder="Photo"/><br></br>
	        
	              
	                 <input type="button" value="Join our List"/>
                 
               </form>
           </div>
            <div class="fab">
            </div>
            <div class="fac">
               <table>
                 <tr>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                    <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                 </tr>
                 <tr>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                    <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                 </tr>
                 <tr>
                 <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                    <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                 </tr>
                  <tr>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                    <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                   <td><img src="/ArticleHibernate/images/8601_cover_t.jpg"/></td>
                  </tr>
               
               </table>
            </div> 
        </div>
        <div class="fb">
               <p class="copyright" align="center">&copy; Copyright ${currentYear} 
              Sofani Mesfun &amp; Associates, Inc. All rights reserved.</p>
        </div> 
       
    
  
    </div>
</body>
</html>