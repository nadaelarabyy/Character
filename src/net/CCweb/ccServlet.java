package net.CCweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;



/**
 * Servlet implementation class ccServlet
 */
@WebServlet("/sleep")
public class ccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		pw.write("My First Dynamic Web Project");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username=request.getParameter("firstname");
		String[] personality=request.getParameterValues("personality");
		String wakeup=request.getParameter("wakeupTime");
		String bedtime=request.getParameter("bedtime");
	    int sleepDuration=Integer.parseInt(request.getParameter("sleepDuration"));
	    String[] emotions=request.getParameterValues("emotion");
	    String[] behavior=request.getParameterValues("behavior");
	    String[] sleepIssue=request.getParameterValues("sleepIssue");
	    int rate=Integer.parseInt(request.getParameter("rate"));
	    String suggestion=request.getParameter("suggestion");
	    boolean submitButtonPressed = request.getParameter("submit") != null;
	    if(submitButtonPressed) {
	    	System.out.println("username: "+username);
	    	System.out.println("personality: "+Arrays.toString(personality));
	    	System.out.println("wakeup: "+wakeup);
	    	System.out.println("bedtime: "+bedtime);
	    	System.out.println("sleep duration: "+sleepDuration);
	    	System.out.println("emotions: "+Arrays.toString(emotions));
	    	System.out.println("behaviors: "+Arrays.toString(behavior));
	    	System.out.println("sleepIssues: "+Arrays.toString(sleepIssue));
	    	System.out.println("rating: "+rate);
	    	System.out.println("suggestions: "+suggestion);
	    	
	    }
	    else 
	    {
	    	System.out.println("none baby");
	    	
	    }
		

		
	}
	
	

}
