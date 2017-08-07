<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" href="${root}/resources/css/login.css" />
</head>
<body>
	<div>
		<img id="title" src="${root}/resources/image/title.png" />
	</div>

	<div class="box" id="panel">
		<div id="image">
			<img src="https://c1.staticflickr.com/8/7157/6733769739_54e6c82b2a_b.jpg" />
		</div>

		<div id="login" class="box">
			<h3 class="title">Log in</h3> <br/>
			<form method="post" action="loginProcess">
				<div class="field">
					<label class="label">Username</label>
					<div class="control">
						<input class="input" name="userName" value="${userName}"
								placeholder="Username" />
					</div>
				</div> 

				<div class="field">
					<label class="label">Password</label>
					<div class="control">
						 <input class="input" name="password" 
						        type="password" placeholder="Password" />
					</div>
				</div>

				<div class="field" id="buttonDiv">
				    <div class="control">
						<button class="button is-primary" type="submit">Login</button>
				    </div>
				</div>
			</form>
		</div>
	</div>
    
</body>
</html>
