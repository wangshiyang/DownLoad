<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.net.URLEncoder"/>
<jsp:directive.page import="java.io.File"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="java.io.FileInputStream"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
     <base href="<%=basePath%>">
    
     <title>My JSP 'download1Action.jsp' starting page</title>
    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->

   </head>
  
   <body>
     <%
      int i = 0;
      byte[] b = new byte[1024];
      OutputStream out1 = null;
      FileInputStream fis = null;
      response.setContentType("application/x-download");
      String url = "H:/download/WP.mp4";
      String fileName = "WP.mp4";
      fileName = URLEncoder.encode(fileName, "UTF-8");
      response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
      //RequestDispatcher rd = application.getRequestDispatcher(url);
      //rd.forward(request, response);
      //response.flushBuffer();
      File file = new File(url);
      try{
       fis = new FileInputStream(file);
       out1 = response.getOutputStream();
       while((i = fis.read(b)) > 0){
        out1.write(b, 0, i);
       }
      }catch(Exception e){
       e.printStackTrace();
      } finally {
       try{
        fis.close();
        out1.flush();
        out1.close();
       }catch(Exception e){}
      }
     %>
   </body>
</html>

