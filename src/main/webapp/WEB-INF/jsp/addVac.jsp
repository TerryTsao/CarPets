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

		<div id="login" class="box">
			<h3 class="title is-3">Add Vaccination</h3>
			<form method="post" action="addVacProcess">
			  <div class="field is-grouped">
				<div class="field">
					<label class="label">Vaccination Date</label>
					<div class="control">
						<input class="input 
						<c:if test="${dateIsEmpty != null}">
                            is-danger
                        </c:if>"
						name="vacDate" value="${vacDate}"
								placeholder="Vaccination Date" />
						<c:if test="${dateIsEmpty != null}">
                          <p class="help is-danger">Required</p>
                        </c:if>
					</div>
				</div> 

				<div class="field">
					<label class="label">Vet</label>
					<div class="control">
						<input class="input" name="vet" value="${vet}"
								placeholder="Vet" />
					</div>
				</div> 
				
				<div class="field">
					<label class="label">Weight</label>
					<div class="control">
						<input class="input" name="weight" value="${weight}"
								placeholder="Weight" /> 
					</div>
				</div> 

				<div class="field is-grouped">
                  <div class="control">
                    <input class="button is-primary" type="submit" value="Finish" />
                  </div>
                  <div class="control">
                    <a href="${root}">
                        <input class="button is-link" type="button" value="Cancel" />
                    </a>
                  </div>
                </div>
             </div>
				
			</form>
		</div>
</body>
</html>
