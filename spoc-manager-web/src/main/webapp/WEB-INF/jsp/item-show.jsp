<%--
  Created by IntelliJ IDEA.
  User: wxc
  Date: 19-5-6
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传视频结果</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-body" align="center">
        <div class="panel-heading">
            <h1 class="sub-header h3">播放结果</h1>
        </div>

        <form method="get" action = "${contextPath}/play">
            <input name = "fileId" type = "text" >
            视频ID:
            <input value = "查询" type ="submit">
        </form>

        <div class="row-fluid">${result}</div>
        <hr>
        <div class="row-fluid">
            <div class="col-lg-12">
                <div class="table-responsive">


                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>文件名称</th>
                            <th>文件大小</th>
                            <th>文件类型</th>
                            <th>文件路径</th>
                            <th>上传时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${fileEntity.titleOrig}</td>
                            <td>${fileEntity.size}</td>
                            <td>${fileEntity.type}</td>
                            <td>${fileEntity.path}</td>
                            <td>${fileEntity.uploadTime}</td>
                            <td><button onclick="play()">播放</button></td>
                            </td>
                        </tr>


                        </tbody>
                    </table>


                </div>
            </div>
        </div>
        <div id="a1" align="center"></div>
    </div>
</div>
</body>
<script type="text/javascript" src="${contextPath}/js/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript" src="${contextPath}/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
    function play(){
        var flashvars = {
            f : '${contextPath}/${entity.path}', //项目的相对路径WebContent下
            c : 0,
            s : 0,
            p : 1
        };
        var video=['${contextPath}/${fileEntity.path}->video/fiv'];
        CKobject.embed('${contextPath}/js/ckplayer/ckplayer.swf', 'a1', 'ckplayer_a1',
            '600', '400',false, flashvars, video);

    }

</script>
</html>
