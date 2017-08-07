<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" href="${root}/resources/css/login.css" />
</head>
<body>
    <t:title root="${root}"></t:title>

	<div class="box" id="panel">
		<div id="image">
			<img src="https://c1.staticflickr.com/8/7157/6733769739_54e6c82b2a_b.jpg" />
		</div>

		<div id="login" class="box">
			<h3 class="title is-3">Log in</h3>
			<form method="post" action="loginProcess">
				<div class="field">
					<label class="label">Username</label>
					<div class="control has-icons_left">
						<input class="input
						
						  <c:if test="${userNameIsEmpty != null || 
						     userNameNotExist != null}">
						    is-danger
						  </c:if>
						
						" name="userName" value="${userName}"
								placeholder="Username" />
						<c:if test="${userNameIsEmpty != null}">
						  <p class="help is-danger">Required</p>
						</c:if>
						<c:if test="${userNameNotExist != null}">
                          <p class="help is-danger">Username does not exist</p>
                        </c:if>
					</div>
				</div> 

				<div class="field">
					<label class="label">Password</label>
					<div class="control has-icons_left">
						 <input class="input
						 
						   <c:if test="${passwordIsEmpty != null || 
                             wrongPassword != null}">
                            is-danger
                           </c:if>
						 
						 " name="password" 
						        type="password" placeholder="Password" />
						  
						<c:if test="${passwordIsEmpty != null}">
                          <p class="help is-danger">Required</p>
                        </c:if>
                        <c:if test="${wrongPassword != null}">
                          <p class="help is-danger">Password is incorrect</p>
                        </c:if>
					</div>
				</div>
				
				<div class="field" id="buttonDiv">
				    <div class="control">
						<input class="button is-primary" type="submit"
						      value="Login" />
				    </div>
				    <div class="control" id="signUp">
				        Not a member yet? &nbsp; <a href="signup"> Sign up</a>  now!
				    </div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
