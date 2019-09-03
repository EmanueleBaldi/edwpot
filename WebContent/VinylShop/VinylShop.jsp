<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VinylShop</title>
</head>
<body>

	<h1>Band</h1>
<form action="/edwpot/VinylShop/VinylShop" method="get">

		Elenco vinili a disposizione:
		<select name="vinyls">
			<option value="vinyl1">Vinyl1</option>
			<option value="vinyl2">Vinyl2</option>
			<option value="vinyl3">Vinyl3</option>
			<option value="vinyl4">Vinyl4</option>
			<option value="vinyl5">Vinyl5</option>
		</select> 
		<br>
		Quantità : <input type="number" min="1" max="5" id="quantityID" name="quantity" placeholder="range:1-5" style="width: 100px" required>
		<br>
		<button type="submit" id="aggiungi">Aggiungi</button>
		<br>
</form>
		<br>
<form action="/edwpot/VinylShop/VinylShop" method="get">
		<button type="submit" id="acquista">Acquista</button>
</form>	
	
</body>
</html>