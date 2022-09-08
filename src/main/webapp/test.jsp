<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.nari.resource.util.remote.*" %>

<%

    InputStream is = new FileInputStream("C:/work/workspace/jvm-learn/target/classes/com/stephen/jvm/learn/chapter02classloader/HelloLoader.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();

    out.println("<textarea style='width:1000;heigth=800'>");
    out.println(JavaClassExecuter.execute(b));
    out.println("</textarea>");

%>