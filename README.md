# CustomButtonForExpress
Sample code for a custom button for a hosted (express) integration

# Dependencies
Three dependencies are required to execute the sample code (included in branch):

commons-codec-1.10.jar
javax.servlet-3.0.jar
json-simple-1.1.1.jar

# Configuration
The src/Express.config.properties must be updated to include the seller id, MWS Access key, MWS secret key, and lwaClientId.

# Endpoint URL
The WebContent/ExpressPaymentPage.jsp uses the following endpoint for sandbox/development:

https://payments-sandbox.amazon.com/gp/widgets/hosted


This will need to be modified to the endpoint below for production deployment:

https://payments.amazon.com/gp/widgets/hosted
