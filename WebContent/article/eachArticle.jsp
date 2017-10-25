<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="/ArticleHibernate/utlities/article.css"/>
  <script type="text/javascript" src="/ArticleHibernate/utlities/article.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  
</head>
<body>
  <jsp:include page="/includes/header.jsp"></jsp:include>
  <div class="eachArticle">
       <div class="article">
          <h1>${article.title}</h1><br>
          <img width="600px" height="500px" src="<c:url value='/articleImage?Id=${article.aId}'/>"/>
          <br><h4>${article.summary}</h4>
          <p>${article.description}</p>
      
       </div>
       <p><strong>Comments</strong></p>
    
       <c:if test="${!empty article.comments}">
           <c:forEach var="comment" items="${article.comments}"><br>
                <div style="padding-left: 10px;">
                    <div class="comment">
                      <div class="commentImage">
                         <c:if test="${!empty comment.userName}">
                           <img width="50px" height="50px" src="<c:url value='/displayImageUser?UserName=${comment.userName}'/>"/> 
                         </c:if> 
                      </div>
                      <div class="commentUserName">
                         <h3>${comment.userName}</h3>
                      </div>
                      <div class="commentDescription">
                         <p>${comment.comment}</p>
                      </div>
                     </div>
                </div>
        
                <c:if test="${!empty comment.replies}">
                     <c:forEach var="reply" items="${comment.replies}"><br> 
                          <div style="padding-left: 30px;"> 
                              <div class="reply">
                                 <div class="replyImage">
                                    <c:if test="${!empty reply.userName}">
                                     <img width="40px" height="40px" src="<c:url value='/displayImageUser?UserName=${reply.userName}'/>"/>
                                   </c:if> 
                                 </div>
                                 <div class="replyUserName">
                                   <h3>${reply.userName}</h3>
                                 </div>
                                 <div class="replyDescription">
                                    <p>${reply.reply}</p>
                                    
                                 </div>
                                
                              </div>
                          </div>
                     </c:forEach> 
                </c:if>
                <div class="replyButton">  
                    <button onclick="toggle(${comment.cId})" >New Reply</button>
                 </div>
               <div id="${comment.cId}" class="r"> 
                  <form method="post" action="<c:url value='/replyInsert'/>">
                     <table>
                       <tr>
                       <!--  <td>Comment Id:</td> -->
                        <td><input type="hidden" name="cid" value="${comment.cId}"></td>
                       </tr>
                       <tr>
                         <td>Reply:</td>
                         <td><input type="text" name="reply"></td>
                       </tr>
                    
                       <tr>
                          <td><input type="submit" value="RepSave"></td>
                       </tr>
                     </table>
                  </form>
              </div>
           </c:forEach>
        </c:if>
        <br>
        <button onclick="toggle('comm')" id="commentButton">New Comment</button>
        <div id="comm" class="c" >
              
                <form method="post" action="<c:url value='/commentInsert'/>">
                   <table>
                     <tr>
                       <!--  <td>Article Id:</td> -->
                             <td><input name="id" type="hidden"  value="${article.aId}"></td>
                     </tr>
       
                     <tr>
                       <td>Comment:</td>
                       <td><input name="comment" type="text"></td>
                     </tr>
      
                     <tr>
                       <td><input id="submit1" type="submit" value="Save"></td>
                     </tr>
                   </table>
                </form>
        </div>
  </div>
  <jsp:include page="/includes/footer.jsp"></jsp:include>
 
</body>
</html>
