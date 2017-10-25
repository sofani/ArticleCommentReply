<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
   <script type="text/javascript" src="/ArticleHibernate/utlities/jquery.leanModal.min.js"></script>
   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
   <link type="text/css" rel="stylesheet" href="/ArticleHibernate/utlities/style.css" />
   
   

    <!-- <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script> -->
    <link rel="stylesheet" type="text/css" href="/ArticleHibernate/utlities/headerFooter.css"/>
    <script src="/ArticleHibernate/utlities/jquery.highlightmenu.js"></script>
   <script src="/ArticleHibernate/utlities/highlight.js"></script>
 
</head>
<body>
    <div class="header">
       <div class="ha">
         <ol >
            <li><a href="index.html">PRESS</a></li>
           <li><a href="index.html">CONTACT</a></li>
          
         </ol>
       </div>
       <div class="hb">
          <a class="a" href="/ArticleHibernate/user/LogInForm.jsp">Log In</a>
       </div>
       <div class="hc">
        <nav>
            <ul>
               <li><a href="index.html">NEWS</a></li>
               <li><a href="index.html">ADULIS</a></li>
               <li><a href="faq.html">VISUALS</a></li>
               <li><a href="index.html">TEAM</a></li>
               <li><a style="width: 80px;"href="index.html">PARTNERS</a></li>
               <li><a style="width: 145px;"href="index.html">RACES & EVENTS</a></li>
              
            </ul>
           
        </nav>
        
      </div>
             
       <div class="hd">
              <!--  <span class="icon"><i class="fa fa-search"></i></span>
               <input type="search" id="search" placeholder="Search..." /> -->
       </div>
       
  </div>
  <div class="container">
	  <a id="modal_trigger" href="#modal" class="btn"><img src="/ArticleHibernate/images/log.gif"></a>
      <!--  <a id="modal_trigger" href="#modal" ><img src="/ArticleHibernate/images/log.gif"></a> -->
	<div id="modal" class="popupContainer" style="display:none;">
		<header class="popupHeader">
			<span class="header_title">Login</span>
			<span class="modal_close"><i class="fa fa-times"></i></span>
		</header>
		
		<section class="popupBody">
			<!-- Social Login -->
			<div class="social_login">
			    <div class="">
					<a href="https://www.facebook.com/" class="social_box fb">
						<span class="icon"><i class="fa fa-facebook"></i></span>
						<span class="icon_title">Connect with Facebook</span>
						
					</a>
               
					<a href="#" class="social_box google">
						<span class="icon"><i class="fa fa-google-plus"></i></span>
						<span class="icon_title">Connect with Google</span>
					</a>
				</div> 

				 <div class="centeredText">
					<span>Or use your Email address</span>
				</div> <br>

				<div class="action_btns">
					<div class="one_half"><a href="#" id="login_form" class="btn">Login</a></div>
					<div class="one_half last"><a href="#" id="register_form" class="btn">Sign up</a></div>
				</div>
			</div>
 
			<!-- Username & Password Login form -->
			<div class="user_login">
			      
					<label> User Name:</label>
					<input type="text" id="user"/>
					<br />

					<label>Password</label>
					<input type="password" id="password"/>
					<br />

					<div class="checkbox">
						<input id="remember" type="checkbox" />
						<label for="remember">Remember me on this computer</label>
					</div>

					<div class="action_btns">
						<div class="one_half"><a href="#" class="btn back_btn"><i class="fa fa-angle-double-left"></i> Back</a></div>
						<div class="one_half last"><input id="submit1"  type="submit" value="LOGIN"  class="btn btn_red"></div>
					</div>
				

				<a href="#" class="forgot_password">Forgot password?</a>
			</div>

			<!-- Register Form -->
			<div class="user_register">
				<form>
					<label>User Name</label>
					<input type="text" name="username"/>
					<br />

					<label>Email Address</label>
					<input type="email" />
					<br />

					<label>Password</label>
					<input type="password" />
					<br />

					<div class="checkbox">
						<input id="send_updates" type="checkbox" />
						<label for="send_updates">Send me occasional email updates</label>
					</div>

					<div class="action_btns">
						<div class="one_half"><a href="#" class="btn back_btn"><i class="fa fa-angle-double-left"></i> Back</a></div>
						<div class="one_half last"><a href="#" class="btn btn_red">Register</a></div>
					</div>
				</form>
			</div>
		</section>
	</div>
</div>

<script type="text/javascript">
	$("#modal_trigger").leanModal({top : 200, overlay : 0.6, closeButton: ".modal_close" });

	$(function(){
		// Calling Login Form
		$("#login_form").click(function(){
			$(".social_login").hide();
			$(".user_login").show();
			return false;
		});

		// Calling Register Form
		$("#register_form").click(function(){
			$(".social_login").hide();
			$(".user_register").show();
			$(".header_title").text('Register');
			return false;
		});

		// Going back to Social Forms
		$(".back_btn").click(function(){
			$(".user_login").hide();
			$(".user_register").hide();
			$(".social_login").show();
			$(".header_title").text('Login');
			return false;
		});

	});
	$(document).ready(function(){
        $('#submit1').click(function() {   
            var user = $('#user').val();
            var password = $('#password').val();
            $.ajax({
                type: "POST",
                url:"LogIn",   // this is my servlet
                
                data:{"user": user, "password": password},
                success: function (data) {
                	 /* if(data=='True'){
                        $(location).attr('href', '/ArticleHibernate/article/home.jsp'); 
                       alert(data);
                      } else {
                          alert('Fail....');
                      } */
 
                }
            });                                
        });
    });

</script>    
</body>
</html>

