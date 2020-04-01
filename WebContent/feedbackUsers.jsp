<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"
   import="java.util.List"
   import="org.bson.Document"
 %><html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
   @import url(https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Oxygen);

/* Page layout */

body {
    background-color: #fff;
    margin: 0;
    padding: 0;
    font-family: 'Oxygen', sans-serif;
    color: #444;
    font-size: 15px;
    line-height: 18px;
    font-weight: 300;
}

header {
    margin: 0;
    background: #000;
    height: 65px;
    padding: 1px;
    
}

article {
    margin: 40px 30px;
}

h1 {
    font-family: 'Open Sans Condensed', sans-serif;
    letter-spacing: 1px;
    font-size: 2.3em;
    line-height: 44px;
    text-transform: uppercase;
    color: #fff;
    font-weight: 900;
    margin: 0;
    padding: 10px 0 0 30px;
    letter-spacing: 2px;
}

h2 { margin: 20px 0 10px 0;
    font-weight: 900;
}

p {
    margin: 20px 0 5px 0;
}


/* Table Layout */

table.vitamins {
    margin: 20px 0 0 0;
    border-collapse: collapse;
    border-spacing: 0;
    background: #212121;
    color: #fff;
}

table.vitamins th, table.vitamins td {
    text-align: center;
}

table.vitamins thead {
    line-height: 12px;
    background: #2e63e7;
    text-transform: uppercase;
}

table.vitamins thead th {
    color: #fff;
    padding: 10px;
    letter-spacing: 1px;
    vertical-align: bottom;
}

table.vitamins thead th:nth-child(1) {
    width: 20%;
    text-align: left;
    padding-left: 20px;
}

table.vitamins thead th:nth-child(2) {
    width: 30%;
}

table.vitamins thead th:nth-child(3) {
    width: 35%;
}

table.vitamins thead th:nth-child(4) {
    width: 15%;
}

table.vitamins tbody {
    font-size: 1em;
    line-height: 15px;
}

table.vitamins tbody tr {
    border-top: 2px solid rgba(109, 176, 231, 0.8);
    transition: background 0.6s, color 0.6s;
}

table.vitamins tbody tr:nth-child(even) {
    background: rgba(255, 255, 255, 0.2);
}

table.vitamins tbody tr:hover {
    color: #000;
    background: rgba(255, 255, 255, 0.7);
    font-weight: 900;
}

table.vitamins tbody td {
    padding: 12px;
}

table.vitamins tbody tr:hover td:first-child {
    background: rgba(0,0,0,0);
}

table.vitamins tbody td:first-child {
    text-align: left;
    padding-left: 20px;
    font-weight: 700;
    background: rgba(109, 176, 231, 0.35);
    transition: backgrounf 0.6s;
}

table.vitamins tfoot {
    font-size: 0.8em;
}

table.vitamins tfoot tr {
    border-top: 2px solid #2e63e7;
}

table.vitamins tfoot td {
    color: rgba(255,255,215,0.6);
    text-align: left;
    line-height: 15px;
    padding: 15px 20px;
}


/* Mobile Layout */

@media screen and (max-width: 400px) {
    h1 {
        font-size: 34px;
        line-height: 36px;
        padding-left: 15px;
    }

    article {
        margin: 10px 15px;
    }

    table.vitamins {
        font-size: 0.8em;
    }
}
</style>
<title>Database Users</title>
</head>
<body>
  <header>
    <h1>Sleep Habits Feedback Users</h1>
</header>
<article>
<!--      <h2>nada</h2>
   -->
  
    
    <table class="vitamins">
        <thead>
            <tr>
            <%
            ArrayList<String> list=(ArrayList<String>)request.getAttribute("keys");
            for(int i=0;list.size()>i;i++)
            {
            %>
            
                <th><%=list.get(i) %></th>
                <%} %>
            </tr>
            
        </thead>
        
        <tfoot>
            <tr>
                <td colspan="4">
                    <p><strong>CC</strong> stands for character computing. </p>
               
                </td>
            </tr>
        </tfoot>
        <tbody>
        <% 
        List<Document> docList=(List<Document>)request.getAttribute("documents");
           for(int i=0;docList.size()>i;i++){
        	   ArrayList<String> keylist=(ArrayList<String>)request.getAttribute("keys");
        	   
        %>
            <tr>
                <td><%=docList.get(i).get(keylist.get(0)) %></td>
                <td><%=docList.get(i).get(keylist.get(1)) %></td>
                <td><%=docList.get(i).get(keylist.get(2)) %></td>
                <td><%=docList.get(i).get(keylist.get(3)) %></td>
                <td><%=docList.get(i).get(keylist.get(4)) %></td>
                <td><%=docList.get(i).get(keylist.get(5)) %></td>
                <td><%=docList.get(i).get(keylist.get(6)) %></td>
                <td><%=docList.get(i).get(keylist.get(7)) %></td>
                <td><%=docList.get(i).get(keylist.get(8)) %></td>
                <td><%=docList.get(i).get(keylist.get(9)) %></td>
                <td><%=docList.get(i).get(keylist.get(10)) %></td>
                
            </tr>
           
            
            
            
            
            <%
        	   
           }
            %>
        </tbody>
    </table>
</article>
  
</body>
</html>