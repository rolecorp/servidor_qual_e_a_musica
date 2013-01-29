<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" type="text/css" href="css/estilo.css" media="screen" >
</head>
<body>

	<fieldset>
		<legend>Cadastro de Ranking</legend>
		<form action="servletJSON" method="get">
		
			<label>Nome</label> <input type="text" name="nome">
			<br>
			<label>Pontuacao</label> <input type="text" name="pontuacao">
			<br>
			<input type="submit" value="Cadastrar">
		</form>
	</fieldset>

</body>
</html>