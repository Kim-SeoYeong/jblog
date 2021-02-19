<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="">기본설정</a></li>
				<li class="tabbtn selected"><a href="">카테고리</a></li>
				<li class="tabbtn"><a href="">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
 						<c:forEach items="${cateList}" var="categoryList">
			      			<tr>
								<td>${categoryList.cateNo}</td>
								<td>${categoryList.cateName}</td>
								<td>0</td>
								<td>${categoryList.description}</td>
							    <td class='text-center'>
							    	<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">
							    </td>
							 </tr>
						 </c:forEach> 
						<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
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
	//브라우저 준비가 끝났을때
	/*
	$("document").ready(function(){
		console.log("ready");

	});
	*/
	
	//카테고리 추가 버튼 클릭
	
	
	/*
	//카테고리 데이터 + html
	function render(categoryVo, updown) {
		var str = '';
		str += '<tr>';
		str += '	<td>' + categoryVo.cateNo + '</td>';
		str += '	<td>' + categoryVo.cateName + '</td>';
		str += '	<td> 0 </td>';
		str += '	<td>' + categoryVo.description + '</td>';
		str += '	<td class="text-center">';
		str += '		<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
		str += '	</td>';
		str += '</tr>';
		
		if(updown == "down") {
			$("#cateList").append(str);
		} else if(updown == "up") {
			$("#cateList").prepend(str);
		} else {
			console.log("테이블 순서 미지정");
		}
	}
	*/
	/*
	//카테고리 전체 리스트 출력
	function cateList() {
		
		var id = "${authUser.id}";
		console.log(id);
		
		//ajax
		$.ajax({
			
			url : "${pageContext.request.contextPath}/"+id+"/admin/category",		
			type : "post",
			//contentType : "application/json",
			//data : {name : "홍길동"}

			dataType : "json",
			success : function(categoryList){
				//성공시 처리해야될 코드 작성
				console.log(categoryList);
				
				for(var i = 0; i < categoryList.length; i++) {
					render(categoryList[i], "down");
				}
				
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});	
	}
	*/
</script>


</html>