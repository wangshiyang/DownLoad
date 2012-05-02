<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.opensymphony.com/oscache" prefix="oscache" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<script type="text/javascript">
<!--
	function re1(){
	
	window.location.reload();
}
//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<meta http-equiv="refresh" content="1">
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="download.jsp">下载AVA，战地之王</a>
    <form name="login" action="login" method="post">
    	用户名:<input name="user.username" type="text"><br/>
    	密码:&nbsp&nbsp&nbsp&nbsp<input name="user.password" type="text"/>
    	<br/>
    	<input name="submit" type="submit" value="提交"/>
    	<input name="submit" type="reset" value="取消"/>
    </form>
    
    	没有缓存的日期:
            <%=new Date()%>
            <br>
    
    <oscache:cache key="huhui" scope="session" time="30" >
   		<!-- 是使用Map对象来存储缓存的，默认的key是uri路径，如：/oscache/index.jsp，也可以指定它的key --> 
  		<!-- 缓存默认存放在application范围，缓存时间默认为3600秒，即1小时 --> 
    <div><%=new Date() %></div> 
  		当前时间：<%=new Date() %>
  		<% try {%>
          ......其它内容
          <%}catch (Exception e) {%>
            	使用了缓存吗? <os:usecached />是
          <% } %>
  	</oscache:cache>
  	<br> 
  	<oscache:cache scope="session" key="testre1">
  	<div>非缓存:</div>
  	手动刷新时间为:<%=new Date() %>
  	</oscache:cache>
  	
  	

  	<button name="re1" id="re1" type="button" onclick="re1()" value="刷新"></button>
  </body>
</html>
