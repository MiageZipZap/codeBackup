<%@ page contentType="text/html;charset=ISO-8859-15" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- script type="text/javascript" src="/easyessoft/js/person.js"></script -->
<form:form id="form_person" method="post"
	action="/easyessoft/ihm/ref/person/personMember" commandName="person">

	<fieldset>

		<legend>Choisissez le type d'individus à créer</legend>
		<div class="form-group">
			<p>
				<label>Type de personne</label>
				<form:select id="listPersonType" class="form-control"
					path="personType">
					<form:options items="${listPersonType}"></form:options>
				</form:select>
			</p>

		</div>
	</fieldset>
	<input class="btn btn-primary btn-lg" type="submit" value="create"
		id="createPersonButton" />
</form:form>