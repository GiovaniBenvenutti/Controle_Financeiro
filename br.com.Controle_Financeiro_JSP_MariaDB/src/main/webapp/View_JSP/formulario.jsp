<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="receber.jsp" method="POST">
		<label>Nome</label>
		<input type="text" name="nome"> <br><br>
		
		<label>Nota 1</label>
		<input type="number" step="0.01" name="nota1"> <br><br>
		
		<label>Nota 2</label>
		<input type="number" step="0.01" name="nota2"> <br><br>
		
		<label>Nota 3</label>
		<input type="number" step="0.01" name="nota3"> <br><br>
		
		<input type="submit" value="Calcular média">
	</form>
	
</body>
</html>