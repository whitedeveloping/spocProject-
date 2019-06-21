<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post" action="${contextPath}/upload" enctype="multipart/form-data">
	    <table cellpadding="5">
	        <%--<tr>--%>
	            <%--<td>商品类目:</td>--%>
	            <%--<td>--%>
	            	<%--<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>--%>
	            	<%--<input type="hidden" name="cid" style="width: 280px;"></input>--%>
	            <%--</td>--%>
	        <%--</tr>--%>
	        <tr>
	            <td>视频标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>


	        <tr>
				<td>视频资源:</td>
				<td>
					<input type="file" class="form-control" name="file" id="file">
				</td>
			</tr>
	        <tr>
	            <td>视频描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
		<button type="submit">提交</button>
	</form>
	<%--<div style="padding:5px">--%>
	    <%--<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>--%>
	    <%--<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>--%>
	<%--</div>--%>


</div>
<script type="text/javascript">
	var itemAddEditor ;

	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = E3.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器
		E3.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//E3.changeItemParam(node, "itemAddForm");
		}});
	});
	// //提交表单
	// function submitForm(){
	// 	//有效性验证
	// 	if(!$('#itemAddForm').form('validate')){
	// 		$.messager.alert('提示','表单还未填写完成!');
	// 		return ;
	// 	}
	// 	//同步文本框中的商品描述
	// 	itemAddEditor.sync();
	//
	// 	//ajax的post方式提交表单
	// 	//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
	// 	$.post("/upload",$("#itemAddForm").serialize(), function(data){
	// 		if(data.status == 200){
	// 			$.messager.alert('提示','新增视频成功!');
	// 		}
	// 	});
	// }
	// function clearForm(){
	// 	$('#itemAddForm').form('reset');
	// 	itemAddEditor.html('');
	// }
</script>
