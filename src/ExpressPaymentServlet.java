import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;
import org.json.simple.JSONObject;

public class ExpressPaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			SignRequest params = new SignRequest();
			
			String units = request.getParameter("units");
			String unitPrice = request.getParameter("amount");
			String totalAmount = getTotalAmounr(units, unitPrice);
			String sellerNote = request.getParameter("sellerNote");
			String currencyCode = request.getParameter("currencyCode");

			Map<String, String> requestvars = new HashMap<String, String>();
			requestvars.put("amount", totalAmount);
			requestvars.put("sellerNote", sellerNote);
			requestvars.put("currencyCode", currencyCode);

			Map<String, String> prepareParameters = params
					.prepareParameters(requestvars);
			
			request.setAttribute("expressParameters", prepareParameters);
			
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(ExpressPaymentServlet.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (IllegalStateException ex) {
			Logger.getLogger(ExpressPaymentServlet.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(ExpressPaymentServlet.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ExpressPaymentPage.jsp");
		rd.forward(request, response);  
	}

	private String getTotalAmounr(String units, String unitPrice) {
		// This is just a simple calculation.
		Double totalAmount = (double) Integer.parseInt(units) * Double.parseDouble(unitPrice);
		return totalAmount.toString();
	}

	// <editor-fold defaultstate="collapsed"
	// desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 * @throws java.io.UnsupportedEncodingException
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * 
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Express Payments Demo Servlet";
	}// </editor-fold>

}
