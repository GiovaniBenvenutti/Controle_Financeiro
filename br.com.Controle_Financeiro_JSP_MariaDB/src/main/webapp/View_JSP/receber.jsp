<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		//Obtendo o nome
		String nome = request.getParameter("nome");
	
		//Obtendo as notas e calculando a média
		double nota1 = Double.parseDouble(request.getParameter("nota1"));
		double nota2 = Double.parseDouble(request.getParameter("nota2"));
		double nota3 = Double.parseDouble(request.getParameter("nota3"));
		double media = (nota1 + nota2 + nota3) / 3;
		
		String situacao;
		if (media >= 7.0) {
			situacao = "<h1><font color=\"green\">Aprovado(a)</font></h1>";
		} else if (media >= 5.0) {
			situacao = "<h1><font color=\"gray\">Em exame</font></h1>";
		} else {
			situacao = "<h1><font color=\"red\">Reprovado(a)</font></h1>";
		}
		
		//Exibindo os dados
		out.print("<h1>Nome: " + nome + "</h1>");
		out.print("<h2>Média: " + String.format("%.2f", media) + "</h2>");
		out.print("<hr>");
		out.print(situacao);
		
	%>

</body>
</html>