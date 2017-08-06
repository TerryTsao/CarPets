<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
</body>
</html>
