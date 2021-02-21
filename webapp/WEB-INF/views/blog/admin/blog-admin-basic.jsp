<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>

</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
				<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
	 		      	<table id="admin-basic">
	 		      		<colgroup>
							<col style="width: 100px;">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td><label for="textTitle">블로그 제목</label></td>
			      			<td><input id="textTitle" type="text" name="blogTitle" value="${blogVo.blogTitle}"></td>
			      		</tr>
			      		<tr>
			      			<td><label>로고이미지</label></td>
			      			<c:choose>
			      				<c:when test="${blogVo.logoFile == null}">
			      					<td class="text-left"><img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>
			      				</c:when>  
			      				<c:otherwise>
			      					<td class="text-left"><img src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}"></td>
			      				</c:otherwise>
			      			</c:choose> 
			      		</tr>      		
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td><input id="textLogo" type="file" name="file"></td>      			
			      		</tr>           		
			      	</table>
			      	<input type="hidden" name="id" value="${authUser.id}">
			      	<div id="btnArea">
			      		<button class="btn_l" type="submit" >기본설정변경</button>
			      	</div>
				</form>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
/*
	$("#admin-menu").on("click", "a", function(){
		event.preventDefault();
		console.log("ul 클릭");
		//console.log($(this));
		//event.preventDefault();
	
		var str = $(this).text();
		console.log(str);
		
		if(str == '카테고리') {
			var id = "${authUser.id}";
			console.log(id);
			
			$.ajax({
				url : "${pageContext.request.contextPath}/"+id+"/admin/category",		
				type : "post",
				//contentType : "application/json",
				//data : {name : "홍길동"}

				dataType : "json",
				success : function(categoryList){
					//성공시 처리해야될 코드 작성
					console.log("과연 성공하나요!!!::::" + categoryList);
					
					//for(var i = 0; i < categoryList.length; i++) {
						//render(categoryList[i]);
					//}
					
				},
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});	
		}
		
	});
*/
</script>

</html>
