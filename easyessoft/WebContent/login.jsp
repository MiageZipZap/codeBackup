<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EasyEs Soft</title>
</head>
<body>
	<div id="nom-application" class="">
		<h1>EasyEs Soft. Ltd</h1>
		<span class="version">Version : 1.0</span>
	</div>


	<form id="f" class="login-form"
		action="j_spring_security_check" method="post">
		<div id="identifiant">
			<p class="formulaire">
				<label for="j_username" class="libelle-moyen">Identifiant :</label>
				<input type="text" size="15" name="j_username"
					value="" />
			</p>
		</div>
		<div id="mot-de-passe">
			<p>
				<label for="j_password">Mot de passe :</label> <input
					type="password" size="15" name="j_password" />
			</p>
		</div>
		<div id="connexion">
			<button type="submit" class="bouton" name="" value="">
				<span class="btn-action-secondaire-xl"><span><span>Connexion</span></span></span>
			</button>
		</div>
	</form>
</body>
</html>