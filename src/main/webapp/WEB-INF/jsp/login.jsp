<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/include.jsp" %>
    <title>Insert title here</title>
</head>
<body>
    <form method="post" action="loginProcess">
        Log in<br/>
        
        Username <input name="userName" value="${userName}" /> <br/>
        Password <input name="password" type="password" /> <br/> <br/>
        
        <input type="submit" />
    </form> 
    
</body>
</html>
