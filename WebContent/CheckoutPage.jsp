<%@page import="java.util.UUID"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>

<body>
	<form action="ExpressPaymentServlet">
		<input type="hidden" name="sellerNote" value="LongSleeveTee">
		<input type="hidden" name="amount" value="100">
		<input type="hidden" name="currencyCode" value="USD">
		
		<label id="itemname" for="tshirt">Item Name: Long Sleeve Tee</label>
		<div id="amount" value="100">Unit Price: $100</div>
		<label for="units">Units:</label> <select name="units" id="units">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select> <input type="submit" value="Add to cart and go to Pay">
	</form>

</body>
</html>
