<%@ include file="/WEB-INF/jsp/includeTaglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/includeCSS.jsp" %>
    <title>Insert title here</title>
</head>
<body>
    <t:title root="${root}"></t:title>

    <div class="tile is-ancestor">
        <c:forEach items="${myPets}" var="pet">
            <a href="${root}/user/${pet.pid}/addVac">
				<div class="tile is-4 is-parent">
					<div class="tile is-child notification is-danger">
						<p class="title">${pet.petName}</p>
					</div>
				</div>
			</a>
        </c:forEach>
        
            <div class="tile is-4 is-parent">
                <div class="tile is-child notification is-success">
                    <p class="title"><a href="${root}/user/addPet">Add a pet</a></p>
                </div>
            </div>
    </div>
</body>
</html>