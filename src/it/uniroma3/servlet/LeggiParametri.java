package it.uniroma3.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processaDati")
public class LeggiParametri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gestione della RICHIESTA

		// leggo i parametri
	  	String nome = request.getParameter("nome").toUpperCase();
	  	String cognome = request.getParameter("cognome").toUpperCase();

		// leggo (alcune) intestazioni http della richiesta
		String address = (String)request.getRemoteAddr();
		String host = (String)request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");

		request.setAttribute("NOME", nome);
		request.setAttribute("COGNOME", cognome);
		request.setAttribute("IP", address);
		request.setAttribute("HOST", host);
		request.setAttribute("USER_AGENT", userAgent);
		
		// inoltro
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/mostraDati");
		rd.forward(request, response);
		return; 
		}
	}