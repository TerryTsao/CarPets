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
			<h3 class="title is-3">Add a pet</h3>
			<form method="post" action="addPetProcess">
				<div class="field">
					<label class="label">Pet Name</label>
					<div class="control">
						<input class="input" name="petName" value="${petName}"
								placeholder="Pet Name" />
					</div>
				</div> 

				<div class="field">
					<label class="label">Species</label>
					<div class="control">
						<input class="input" name="species" value="${species}"
								placeholder="Species" />
					</div>
				</div> 

				<div class="field">
					<label class="label">Owner Name</label>
					<div class="control">
						<input class="input" name="ownerName" value="${ownerName}"
								placeholder="Owner Name" />
					</div>
				</div> 
											
				<div class="field">
					<label class="label">Gender</label>
					<div class="control">
						<label class="radio">
						  <input type="radio" name="gender" value="Female" />
						  Female
						</label>
						<label class="radio">
						  <input type="radio" name="gender" value="Male" />
						  Male
						</label>
						<label class="radio">
						  <input type="radio" name="gender" value="Spayed" />
						  Spayed
						</label>
						<label class="radio">
						  <input type="radio" name="gender" value="NEUTERED" />
						  Neutered
						</label>
				  </div>
				</div>
				
				<div class="field">
					<label class="label">Date of Birth</label>
					<div class="control">
						<input class="input" name="DOB" value="${DOB}"
								placeholder="DOB" />
					</div>
				</div> 

				<div class="field">
					<label class="label">Microchip ID #</label>
					<div class="control">
						<input class="input" name="microchipNO" value="${microchipNO}"
								placeholder="Microchip ID #" />
					</div>
				</div> 

				<div class="field">
					<label class="label">Breed</label>
					<div class="control">
						<input class="input" name="breed" value="${breed}"
								placeholder="Breed" />
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
				
			</form>
		</div>
</body>
</html>