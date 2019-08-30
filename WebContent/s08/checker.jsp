<!-- jsp è un documento contenente una pagina html e scriptlet(=pezzo del documento contenente codice java), in questo tipo di file
la servlet viene impostata automaticamente da tomcat per cui non sarà necessaria la creazione del file java ma sarà sufficiente 
inserire la parte di "finale" della servlet nella scriptlet
-->



<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
    <h1>Hello!</h1>
    <p>
        The user name
        <%
            @SuppressWarnings("unchecked")
            Set<Character> set = (Set<Character>) request.getAttribute("set"); //faccio un cast perchè il treeSet viene letto come un oggetto e voglio che sia un Set<Character>
            if (set == null || set.isEmpty()) {
                out.print("is empty");
            } else {
                out.print("contains these letters:");

                Iterator<Character> it = set.iterator();
                while (it.hasNext()) {
                    out.print(" " + it.next());
                }
            }
        %>
    </p>
</body>
</html>