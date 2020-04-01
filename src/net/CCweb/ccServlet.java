package net.CCweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.diagnostics.logging.Logger;
import com.mysql.cj.Session;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;



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
//		PrintWriter pw=response.getWriter();
//		pw.write("My First Dynamic Web Project");
//		request.getRequestDispatcher("note.jsp").forward(request, response);
	    request.getRequestDispatcher("index.jsp").forward(request, response);

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
	    	MongoClient mongoClient = MongoClients.create(
			        "mongodb+srv://nada:luck1997@cluster0-wcdyb.mongodb.net/sleepFeedback?retryWrites=true&w=majority"
			);
	MongoDatabase database = mongoClient.getDatabase("sleepFeedback");


	MongoCollection<Document> collection=database.getCollection("CC_onto");


	Document person = new Document();
	person.put("username", username);
	person.put("wakeupTime", wakeup);
	person.put("bedtime", bedtime);
	person.put("sleepDuration", sleepDuration);
	person.put("trait", Arrays.asList(personality));
	person.put("emotion", Arrays.asList(emotions));
	person.put("behavior", Arrays.asList(behavior));
	person.put("sleepIssue", Arrays.asList(sleepIssue));
	person.put("rate", rate);
	person.put("suggestion", suggestion);
	collection.insertOne(person);
//	request.setAttribute("username", username);
	HttpSession session = request.getSession();
	session.setAttribute("username", username);
//    request.getRequestDispatcher("/successFeedback").forward(request, response);
    
	response.sendRedirect(request.getContextPath() + "/successFeedback");
	    }
	    else 
	    {
	    	System.out.println("none baby");
	    	
	    }





//mongoClient.close();



		

		
	}
	
	

}
