<%@page import="es.ufc.qualeamusica.dao.RankingGeralDAO"%>
<%@page import="es.ufc.qualeamusica.model.RankingGeral"%>
<%@page import="java.util.List"%>
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
		<legend>Lista de Feriados</legend>
		<table border="2" align="center">
			<tr>
				<th>Nome</th>
				<th>Pontuação</th>
			</tr>
			<%
			RankingGeralDAO rGDao = new RankingGeralDAO();
				List<RankingGeral> listaFeriados =  rGDao.listarTodos();
				for (int i = 0; i < listaFeriados.size(); i++) {
					RankingGeral ranking = listaFeriados.get(i);
			%>
			<tr>
				<td><%=ranking.getNomeUsuario()%></td>
				<td><%=ranking.getPontuacao()%></td>

				<td><a href="servletJSON?acao=remover&idFeriado=<%=i%>">Excluir</a></td>

			</tr>
			<%
				}
			%>
		</table>

		<a href="index.jsp">Voltar para a tela inicial</a>
	</fieldset>

</body>
</html>