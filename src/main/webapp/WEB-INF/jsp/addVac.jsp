<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" href="${root}/resources/css/addVac.css" />
     <script>
  $( function() {
    $( "#datepicker" ).datepicker({changeMonth: true, changeYear: true});
  } );
  </script>
</head>
<body>
    <t:title root="${root}"></t:title>

		<div id="login" class="box">
			<h3 class="title is-3">Add Vaccination</h3>
			<form:form method="post" action="addVacProcess" modelAttribute="vac">
			  <div class="field is-grouped">
				<div class="field">
					<label class="label">Vaccination Date</label>
					<div class="control">
						<input id="datepicker" class="input 
						<c:if test="${dateIsEmpty != null || dateWrongFormat != null}">
                            is-danger
                        </c:if>"
						name="vacDate" value="${vacDate}"
								placeholder="mm/dd/yyyy" />
						<c:if test="${dateIsEmpty != null }">
                          <p class="help is-danger">Required</p>
                        </c:if>
                        <c:if test="${dateWrongFormat != null }">
                          <p class="help is-danger">Invalid date</p>
                        </c:if>
					</div>
				</div> 

				<div class="field">
                    <label class="label">Weight</label>
                    <div class="control">
                        <input class="input" name="weight" value="${weight}"
                                placeholder="Weight" /> 
                    </div>
                </div> 
                
				<div class="field">
					<label class="label">Vet</label>
					<div class="control">
						<input class="input" name="vet" value="${vet}"
								placeholder="Vet" />
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
             
             
             <label class="label">Vaccination</label>
			<c:if test="${vacsIsEmpty != null }">
			  <p class="help is-danger">Required</p>
			</c:if>
			 <div class="field">
			     <form:checkboxes items="${vacList}" path="vacs" delimiter="<br />" />
		     </div>
		     
		</form:form>
	</div>
</body>
</html>
