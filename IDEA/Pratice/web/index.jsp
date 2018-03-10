<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>

  </head>
  <body>
  <hr>
  <%--jQuery的ready事件--%>
  <script>
      $(document).ready(function(){
       /*在jQuery构造函数里面传入字符串类型的标签名,
       根据签名选中body元素，在元素的内容区追加文字*/
       $('body').append('Hello,jQuery World!');
      });
  </script>
  <hr>
  <script type="text/javascript" src="./WEB-INF/js/bootstrap.min.js"></script>
  </body>
</html>