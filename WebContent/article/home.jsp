 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" type="text/css" href="/ArticleHibernate/utlities/body.css"/>
    <link rel="stylesheet" type="text/css" href="/ArticleHibernate/utlities/article.css"/>
    <script type="text/javascript" src="/ArticleHibernate/utlities/article.js"></script>
    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
    
</head>
<body> 
      
     <jsp:include page="/includes/header.jsp"></jsp:include>
     <div class="body">
         <h2><span> ARTICLES</span></h2>
         <c:forEach var="article" items="${articles}">
             <div class="ba"> 
                <a href="<c:url value='/articleDisplay?Id=${article.aId}'/>">
                  <img  src="<c:url value='/articleImage?Id=${article.aId}'/>"/> 
                </a> 
             </div> 
             <br><br>  
             <div  class="bb">
                 <a href="<c:url value='/articleDisplay?Id=${article.aId}'/>">
                    <h3>${article.title}</h3>
                 </a>
                 <p>${article.summary}</p>
             </div>
              <br><br>  
              <hr>
         </c:forEach>
   
        <button onclick="toggle('comm')" id="commentButton">New Article</button>
        <div id="comm" class="c" >
         <form id="someform"  action="<c:url value='/articleInsert'/> " enctype="multipart/form-data">
                <input type="text" name="articleUserName"  placeholder="User Name"/><br></br>
	            <input type="text" name="title"  placeholder="Title"/><br></br>
	            <input type="text" name="summary"  placeholder="Summary"/><br></br>
	            <input type="text" name="Description"  placeholder="Description"/><br></br>
	            <input type="file" name="photo"  placeholder="Photo" size="50"/><br></br>
                <input name="submit" type="submit" value="Post your Article"/>
         </form>
        </div>
     </div>
    <jsp:include page="/includes/footer.jsp"></jsp:include>
    <script type="text/javascript">
       $(document).on("submit", "#someform", function(event) {
          var $form = $(this);

           $.post($form.attr("action"), $form.serialize(), function(response) {
        // ...
      });

      event.preventDefault(); // Important! Prevents submitting the form.
    });
    </script>
  </body>
   </html>