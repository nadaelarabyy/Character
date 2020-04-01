package net.CCweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class viewDatabase
 */
@WebServlet("/viewDatabase")
public class viewDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		MongoClient mongoClient = MongoClients.create(
		        "mongodb+srv://nada:luck1997@cluster0-wcdyb.mongodb.net/sleepFeedback?retryWrites=true&w=majority"
		);
       MongoDatabase database = mongoClient.getDatabase("sleepFeedback");


      MongoCollection<Document> collection=database.getCollection("CC_onto");
      if(collection.count()>0) {
      Set<String> keys=collection.find().iterator().next().keySet();
      ArrayList<String> keysArr=convertSetToList(keys);
      
            
      request.setAttribute("keys", keysArr);
      List<Document> docs = (List<Document>) collection.find().into(
				new ArrayList<Document>());
        request.setAttribute("documents", docs);
      }
      else {
    	  Set<String> keys=new HashSet<String>();
          ArrayList<String> keysArr=new ArrayList<String>();       
          request.setAttribute("keys", keysArr);
          List<Document> docs = (List<Document>) collection.find().into(
    				new ArrayList<Document>());
            request.setAttribute("documents", docs);
    	  
      }

	    request.getRequestDispatcher("feedbackUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

	}
	public static <T> ArrayList<T> convertSetToList(Set<T> set) 
    { 
        // create an empty list 
        ArrayList<T> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (T t : set) 
            list.add(t); 
  
        // return the list 
        return list; 
    } 

}
