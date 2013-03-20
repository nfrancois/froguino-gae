package net.nfrancois.froguino.gae.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Temperature Rest Service.
 * Url : /temperature
 *
 */
public class TemperatureServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7766634356934824217L;

	protected static Double actualTemperature = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(actualTemperature != null){
			response.getWriter().write(actualTemperature.toString());
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temperature = request.getParameter("t");
		if(temperature == null){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			// TODO return 201 CREATED ?
			actualTemperature =  Double.parseDouble(request.getParameter("t"));
		}
	}

}
