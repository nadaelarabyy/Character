package net.CCweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		CCOntology ontology=new CCOntology();
		try {
			ArrayList<String> behaviorList=ontology.getBehbaviors();
			ArrayList<String> personalityList=ontology.getPersonality();
			ArrayList<String> emotionList=ontology.getEmotions();
			ArrayList<String> sleepIssueList=ontology.getSleepIssues();
			request.setAttribute("behavior", behaviorList);
			request.setAttribute("personality", personalityList);
			request.setAttribute("emotion", emotionList);
			request.setAttribute("sleepIssue", sleepIssueList);
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

			

			
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
