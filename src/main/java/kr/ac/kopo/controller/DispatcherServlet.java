package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HandlerMapping mappings;

	@Override
	public void init(ServletConfig config) throws ServletException {

		String propLoc = config.getInitParameter("propLoc");
		mappings = new HandlerMapping(propLoc);

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());

		Controller ctrl = mappings.getController(uri);
		String callPage = ctrl.handleRequest(request, response);

		if (callPage.startsWith("redirect:")) {
			response.sendRedirect(callPage.substring("redirect:".length()));
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
		}
	}

}