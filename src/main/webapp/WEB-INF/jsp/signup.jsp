<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" href="${root}/resources/css/signup.css" />
</head>
<body>
    <t:title root="${root}"></t:title>

    <div class="box" id="panel">
        <div id="image">
            <img src="https://c1.staticflickr.com/8/7157/6733769739_54e6c82b2a_b.jpg" />
        </div>

        <div id="login" class="box">
            <h3 class="title is-3">Sign up</h3>
            <form method="post" action="signupProcess">
                <div class="field">
                    <label class="label">Username</label>
                    <div class="control has-icons_left">
                        <input class="input" name="userName" value="${userName}"
                                placeholder="Username" />
                    </div>
                </div> 

                <div class="field">
                    <label class="label">Password</label>
                    <div class="control has-icons_left">
                         <input class="input" name="password" 
                                type="password" placeholder="Password" />
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Reenter Password</label>
                    <div class="control has-icons_left">
                         <input class="input" name="password1" 
                                type="password" placeholder="Reenter Password" />
                    </div>
                </div>

				<div class="field is-grouped">
				  <div class="control">
					<input class="button is-primary" type="submit" value="Sign up" />
				  </div>
				  <div class="control">
				    <a href="${root}">
				        <input class="button is-link" type="button" value="Cancel" />
				    </a>
				  </div>
				</div>

            </form>
        </div>
    </div>
</body>
</html>
