<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    
    <title>WebSocket Chat Client</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="js/prototype.js"></script>

    <script type="text/javascript">
        document.observe("dom:loaded", function() {
            function log(text) {
                $("log").innerHTML =  (!Object.isUndefined(text) && text !== null ? text.escapeHTML() : "null") + $("log").innerHTML;
            }

            if (!window.WebSocket) {
                alert("启动失败，请使用原生支持WebSocket的浏览器，如：火狐浏览器");
            }

            var ws;

            $("uriForm").observe("submit", function(e) {
                e.stop();
                ws = new WebSocket("ws://192.168.1.101:8080/redwine/websocket/001");
                ws.onopen = function() {
                    log("已经连接到服务器\n");
                }
                ws.onmessage = function(e) {
                    log(e.data+"\n");
                }
                ws.onclose = function() {
                    log("断开服务器连接\n");
                    $("ws://192.168.1.101:8080/redwine/websocket/001", "connect").invoke("enable");
                    $("disconnect").disable();
                    ws = null;
                }
                $("ws://192.168.1.101:8080/redwine/websocket/001", "connect").invoke("disable");
                $("disconnect").enable();
            });

            $("sendForm").observe("submit", function(e) {
                e.stop();
                if (ws) {
                    var textField = $("textField");
                    ws.send("客服:"+textField.value);
                    textField.value = "";
                    textField.focus();
                }
            });

            $("disconnect").observe("click", function(e) {
                e.stop();
                if (ws) {
                    ws.close();
                    ws = null;
                }
            });
        });
    </script>
  </head>
  <body >
      <form id="uriForm"><input type="submit" id="connect" value="连接服务器"></form><br>
      <form id="sendForm"><input type="text" id="textField" value="" style="width:200px;"> <input type="submit" value="发送"></form><br>
      <form><textarea id="log" rows="30" cols="100" style="font-family:monospace; color:black;"></textarea></form><br>
  </body>
</html>
