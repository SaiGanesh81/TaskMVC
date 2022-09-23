package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.DAOEmployee;


@WebServlet("/logout")
public class logout extends HttpServlet {

		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter p=resp.getWriter();
		resp.setContentType("text/html");
		HttpSession hs=req.getSession();
		String user=(String) hs.getAttribute("user");
		LocalDateTime l= LocalDateTime.now();
		RequestDispatcher rd= req.getRequestDispatcher("logout.jsp");
		rd.include(req, resp);
		DAOEmployee ed=new DAOEmployee();
		ed.updateEmpOut(user);
		String d=ed.getI(user);
		p.print(d);
		ed.updatel(d);
	}

}