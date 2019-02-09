package com.nts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RequestTracker
 */
@WebServlet("/welcome/")
public class RequestTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> sessionTrackerList = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestTracker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		sessionTrack(request, response, out);
		out.print("<br>welcome to NTS<br>");
		response.sendRedirect(request.getContextPath()+"/");
	}

	private void sessionTrack(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		HttpSession session = request.getSession(true);
		if (session.isNew()) {
			sessionTrackerList.add(session.getId());
		}
		out.println("session count is" + sessionTrackerList.size());
		session.setAttribute("sessionTrackerList", sessionTrackerList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
