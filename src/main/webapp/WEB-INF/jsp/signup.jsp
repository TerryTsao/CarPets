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
                    <div class="control has-icons-left">
                        <input class="input
                        
                          <c:if test="${userNameIsEmpty != null || 
                             userNameIsDup != null}">
                            is-danger
                          </c:if>
                        
                        " name="userName" value="${userName}"
                                placeholder="Username" />
                        <c:if test="${userNameIsEmpty != null}">
                          <p class="help is-danger">Required</p>
                        </c:if>
                        <c:if test="${userNameIsDup != null}">
                          <p class="help is-danger">Username already exists</p>
                        </c:if>
                        <span class="icon is-small is-left">
							  <i class="fa fa-user"></i>
						</span>
                    </div>
                </div> 

                <div class="field">
                    <label class="label">Password</label>
                    <div class="control has-icons-left">
                         <input class="input
                         
                          <c:if test="${passwordIsEmpty != null || 
                             passwordNotMatch != null || shortPassword}">
                            is-danger
                          </c:if>
                         " name="password" 
                                type="password" placeholder="Password" />
                         <c:if test="${passwordIsEmpty != null}">
                          <p class="help is-danger">Required</p>
                        </c:if>
                        <c:if test="${passwordNotMatch != null}">
                          <p class="help is-danger">Passwords do not match</p>
                        </c:if> 
                        <c:if test="${shortPassword != null}">
                          <p class="help is-danger">Password should be at least 6 characters</p>
                        </c:if>

                        <span class="icon is-small is-left">
							  <i class="fa fa-lock"></i>
						</span>
                    </div>
                </div>
                
                <div class="field">
                    <label class="label">Reenter Password</label>
                    <div class="control has-icons-left">
                         <input class="input
                         <c:if test="${password1IsEmpty != null }">
                            is-danger
                          </c:if>
                         " name="password1" 
                                type="password" placeholder="Reenter Password" />
                         <c:if test="${password1IsEmpty != null}">
                          <p class="help is-danger">Required</p>
                        </c:if>
                        <span class="icon is-small is-left">
							  <i class="fa fa-lock"></i>
						</span>
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
