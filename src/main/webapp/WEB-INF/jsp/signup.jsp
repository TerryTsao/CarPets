<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/include.jsp" %>
    <title>Insert title here</title>
</head>
<body>
    <form method="post" action="signupProcess">
		Sign up <br/>
		
		Username <input name="userName" value="${userName}"/> <br/>
		Password <input name="password" type="password" /> <br/> <br/>
		Reenter Password <input name="password1" type="password" /> <br/> <br/>
		
		<input type="submit" />
	</form> 
	
	<button class="button is-primary is-large">Test</button>
</body>
</html>
