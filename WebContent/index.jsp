<%@page import="net.CCweb.CCOntology"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList" %>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
   <style>

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 50%;
  margin-left: 25%;
}
.container1 {
    max-width: 640px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 13px;
}

ul.ks-cboxtags {
    list-style: none;
    padding: 20px;
}
ul.ks-cboxtags li{
  display: inline;
}
ul.ks-cboxtags li label{
    display: inline-block;
    background-color: rgba(255, 255, 255, .9);
    border: 2px solid rgba(139, 139, 139, .3);
    color: #adadad;
    border-radius: 25px;
    white-space: nowrap;
    margin: 3px 0px;
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    -webkit-tap-highlight-color: transparent;
    transition: all .2s;
}

ul.ks-cboxtags li label {
    padding: 8px 12px;
    cursor: pointer;
}

ul.ks-cboxtags li label::before {
    display: inline-block;
    font-style: normal;
    font-variant: normal;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    font-family: "Font Awesome 5 Free";
    font-weight: 900;
    font-size: 12px;
    padding: 2px 6px 2px 2px;
    
    transition: transform .3s ease-in-out;
}

ul.ks-cboxtags li input[type="checkbox"]:checked + label::before {
    
    transform: rotate(-360deg);
    transition: transform .3s ease-in-out;
}

ul.ks-cboxtags li input[type="checkbox"]:checked + label {
    border: 2px solid #1bdbf8;
    background-color: #12bbd4;
    color: #fff;
    transition: all .2s;
}

ul.ks-cboxtags li input[type="checkbox"] {
  display: absolute;
}
ul.ks-cboxtags li input[type="checkbox"] {
  position: absolute;
  opacity: 0;
}
ul.ks-cboxtags li input[type="checkbox"]:focus + label {
  border: 2px solid #e9a1ff;
}
/* ------------------------------------------------------------------------------------- */
.rating-system1{
  width:auto;
  display:inline-block;
  margin:20px;
  position: relative;
  
} 

.rating-system1 span{
  display:inline-block;
  width:10px;
  height:10px;
  background:red;
  position: absolute;
  left:20px;
}

.rating-system1 input{
  display:none;
}

.rating-system1 label{
  float:right;
  display:inline-block;
  width:20px;
  height:5px;
  background:#ccc;
  margin:4px;
  position: relative;
  transition:all .3s;
}
.rating-system1 label:before{
  content: '';
  position: absolute;
  width:100%;
  height:100%;
  background: inherit;
  top:0;
  left:0;
  transition:all 0.3s;
}
.rating-system1 input:checked ~ label,
.rating-system1 label:hover ~ label,
.rating-system1 label:hover{
  background:orange;
}
.rating-system1 input:checked ~ label:before{
  transform:rotate(90deg);
}  
.rating-system1 .text{
  color:#ccc;
  padding:10px 0;
  position: absolute;
  width:100%;
  top:100%;  
}
.separator{
background-color: white;
height:30px;


 }

   </style>
 



   <title>Document</title>
</head>
<body>     
       <div class="container">
        <h1 style="margin-left: 35%;
        text-transform: capitalize;font-family: sans-serif;color: grey;">sleep habits</h1>

        <form action="${pageContext.request.contextPath}/sleep" method="post">
          <label for="fname">UserName</label>
          <input type="text" id="fname" name="firstname" placeholder="Your name.." >
          <label for="personality" style="text-transform: capitalize;">i can describe myself as: </label>
          <div class="container1">
            <ul class="ks-cboxtags" >
            
            <%
            CCOntology o=new CCOntology();
            ArrayList<String> b=o.getPersonality();
            ArrayList<String> labelNames=new ArrayList();
            for(int i=0;b.size()>i;i++){
            	labelNames.add("personality"+i);
            }
            for(int i=0;b.size()>i;i++){
            	
            	%>
   
            	<li><input type="checkbox" name="personality" id="<%=b.get(i) %>" value=<%=b.get(i).replace(" ", "_") %>><label for="<%=b.get(i) %>"><% out.print(b.get(i)); %></label></li>
            	
            	<% 
            }
            %>   
            </ul>
          
          </div>
      

          <label for="wakeupTime" style="text-transform: capitalize;">my usual wakeup time</label>
          <input type="time" id="appt" name="wakeupTime" min="00:00" max="24:00" required>
          <p style="color:#32CD32;size:0.5px">it has to be in formate HH:MM</p>          
       
          <label for="bedTime" style="text-transform: capitalize;">my usual bedtime time</label>
          <input type="time" id="appt" name="bedtime" min="00:00" max="24:00" required>
          <p style="color:#32CD32;size:0.5px">it has to be in formate HH:MM</p>  
          
          <label for="sleepDuration">Sleep Duration: </label>
          <input type="number" id="tentacles" name="sleepDuration" min="1" max="100">
          <p style="color:#32CD32;size:0.5px">it has to be in an integer</p>  
          
          
          <label for="emotion" style="text-transform: capitalize;">i feel this emotion before going to bed :  </label>
          <div class="container1">
            <ul class="ks-cboxtags">
            
            
            
            <%
            
            ArrayList<String> b2=o.getEmotions();
            
            for(int i=0;b2.size()>i;i++){
            	
            	%>
            	<li><input type="checkbox" name="emotion"  id="<%=b2.get(i) %>" value=<%=b2.get(i).replace(" ", "_") %>><label for="<%=b2.get(i) %>"><% out.print(b2.get(i)); %></label></li>
            	<% 
            }
            %>
             
            </ul>
          
          </div>
          <label for="behavior" style="text-transform: capitalize;">i conduct this behavior while in bed or directly before going to bed :  </label>

          <div class="container1">
            <ul class="ks-cboxtags">
            <%
            
            ArrayList<String> b3=o.getBehbaviors();
            
            for(int i=0;b3.size()>i;i++){
            	
            	%>
            	<li><input type="checkbox" name="behavior" id="<%=b3.get(i)%>" value=<%=b3.get(i).replace(" ", "_") %>><label for="<%=b3.get(i)%>"><% out.print(b3.get(i)); %></label></li>
            	<% 
            }
            %>
           
            </ul>
          
          </div>
          <label for="sleepIssue" style="text-transform: capitalize;">i suffer from this issue :  </label>
          <div class="container1">
            <ul class="ks-cboxtags">
            <%
            
            ArrayList<String> b4=o.getSleepIssues();
            
            for(int i=0;b4.size()>i;i++){
            	
            	%>
            	<li><input type="checkbox" name="sleepIssue" id="<%=b4.get(i) %>" value=<%=b4.get(i).replace(" ", "_") %>><label for="<%=b4.get(i) %>"><% out.print(b4.get(i)); %></label></li>
            	<% 
            }
            %>
            
            </ul>
          
          </div>
          <div class="separator"></div>
          <h1 style="margin-left: 35%;
        text-transform: capitalize;font-family: sans-serif;color: grey;">feedback</h1>
         <label for="rate1" style="text-transform: capitalize;">how well does this represent your daily habits ?  </label>
         <br><br>
         
         <div class="rating-system1">
          <input type="radio" name='rate' value="5" id="star5" />
          <label for="star5"></label>
        
          <input type="radio" name='rate' value="4" id="star4" />
          <label for="star4"></label>
        
          <input type="radio" name='rate' value="3" id="star3" />
          <label for="star3"></label>
         
          <input type="radio" name='rate' value="2" id="star2" />
          <label for="star2"></label>
        
          <input type="radio" name='rate' value="1" id="star1" />
          <label for="star1"></label>
        
          <div class="text"></div>
        </div>
      <br><br>
          <label for="comment">Suggestions: </label>
  
      <textarea id="subject" name="suggestion" placeholder="Write something.." style="height:200px; width: 100%;
      padding: 12px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-top: 6px;
      margin-bottom: 16px;
      resize: vertical;"></textarea>  
       <input type="submit" name="submit" value="Submit" style="width: 25%;margin-left: 53%;">
          
        </form>
      </div>
      

   
</body>
</html>