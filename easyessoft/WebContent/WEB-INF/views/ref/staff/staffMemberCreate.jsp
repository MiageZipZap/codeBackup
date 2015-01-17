<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../include/header.jsp">
	<jsp:param value="Create Staff Member" name="title" />
</jsp:include>

<div id="content">
	<div>
		<h1>Create a Staff Member</h1>
	</div>
	<form:form id="staffMemberForm" method="post"
		action="/easyessoft/ihm/ref/staff/create" commandName="staffMember"
		onsubmit="">	
	<!-- onsubmit="return false;"!-->		
		<fieldset>
			<legend>Staff Member Informations</legend>
			<p>
				<label>First Name</label> :
				<form:input path="firstName" type="text" id="firstName" />
			</p>
			<p>
				<label>Last Name</label> :
				<form:input path="lastName" type="text" id="lastname" />
			</p>
			<p>
				<label>Birth date</label> :
				<form:input path="birthDate" type="text" id="birthDate" />
			</p>
			<p>
				<label>Gender</label> :
				<form:input path="gender" type="text" id="gender" />
			</p>
			<p>
				<label>Adress : Street Number</label> :
				<form:input path="adress.streetNumber" type="text" id="addressStreetNumber" />
			</p>
			<p>
				<label>Adress : Street Type</label> :
				<form:input path="adress.streetType" type="text" id="addressStreetType" />
			</p>
			<p>
				<label>Adress : Street Name</label> :
				<form:input path="adress.streetName" type="text" id="addressStreetName" />
			</p>
			<p>
				<label>Adress : Zip Code</label> :
				<form:input path="adress.zipCode" type="text" id="addressZipCode" />
			</p>
			<p>
				<label>Adress : City</label> :
				<form:input path="adress.city" type="text" id="addressCity" />
			</p>
			<p>
				<label>Adress : Department</label> :
				<form:input path="adress.department" type="text" id="addressDepartment" />
			</p>
			<p>
				<label>Phone Number (Work)</label> :
				<form:input path="phoneNumberWork" type="text" id="phoneNumberWork" />
			</p>
			<p>
				<label>Phone Number (Mobile)</label> :
				<form:input path="phoneNumberMobile" type="text" id="phoneNumberMobile" />
			</p>
			<p>
				<label>Mail Adress</label> :
				<form:input path="mailAdress" type="text" id="mailAdress" />
			</p>
			<p>
				<label>Profession</label> :
				<form:input path="profession" type="text" id="profession" />
			</p>
		<!--  
			<input type="hidden" path="disabledFacilities" value="true" />
		-->
		</fieldset>
		
		<p>
			<input type="submit" value="create" id="createBut">
		</p>
	</form:form>
</div>
<jsp:include page="../../include/footer.jsp" />