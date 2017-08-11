<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map<String, String> expressParameters = (Map<String, String>) request.getAttribute("expressParameters");
	%>

	<form id="form"
		action="https://payments-sandbox.amazon.com/gp/widgets/hosted"
		method="POST">
		<input type="hidden" name="interfaceType" value="JavaScript" /> 
		<input type="hidden" name="action" value="hostedInit" /> 
		<input
			type="hidden" name="experienceType" value="ExpressPayment" />
		<input
			type="hidden" name="shippingAddressRequired"
			value="${ expressParameters['shippingAddressRequired']}" /> 		
		<input
			type="hidden" name="paymentAction"
			value="${ expressParameters['paymentAction']}" /> 

		<input
			type="hidden" name="sellerId"
			value="${ expressParameters['sellerId']}" /> 
		<input
			type="hidden" name="cartOwnerId"
			value="${ expressParameters['sellerId']}" /> 
		<input
			type="hidden" name="accessKey"
			value="${ expressParameters['accessKey']}" /> 
		<input
			type="hidden" name="lwaClientId"
			value="${ expressParameters['lwaClientId']}" /> 
		<input
			type="hidden" name="sellerOrderId"
			value="${ expressParameters['sellerOrderId']}" /> 
		<input
			type="hidden" name="amount"
			value="${ expressParameters['amount']}" /> 
		<input
			type="hidden" name="currencyCode"
			value="${ expressParameters['currencyCode']}" /> 
		<input
			type="hidden" name="returnURL"
			value="${ expressParameters['returnURL']}" /> 
		<input
			type="hidden" name="sellerNote"
			value="${ expressParameters['sellerNote']}" /> 
		<input
			type="hidden" name="signature"
			value="${ expressParameters['signature']}" />
		<img src="https://images-na.ssl-images-amazon.com/images/G/01/Iris3_US/en_US/inca/images/btnPaywAMZN-gld-Desktop-1x.png" 
			onclick="submitForm()">
	</form>
	
	<script type="text/javascript">
		function submitForm() {
			document.getElementById("form").submit();
		}
	</script>
</body>
</html>