<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" href="${root}/resources/css/login.css" />
</head>
<body>
	<div id="titlePanel">
		<div id="title">
			<h1 class="title is-1">Petdoc</h1>
		</div>
		<div id="icon">
			<figure class="image is-64x64">
				<img src="${root}/resources/image/paw_icon.png"
						width="64" height="64" />
			</figure> 
		</div>
	</div>

	<div class="box" id="panel">
		<div id="image">
			<img src="https://c1.staticflickr.com/8/7157/6733769739_54e6c82b2a_b.jpg" />
		</div>

		<div id="login">
			<form method="post" action="loginProcess">
				Log in<br/>

				Username <input name="userName" value="${userName}" /> <br/>
				Password <input name="password" type="password" /> <br/> <br/>

				<button class="button is-primary" type="submit">Login</button>
			</form>
		</div> 
	</div>
    
</body>
</html>
