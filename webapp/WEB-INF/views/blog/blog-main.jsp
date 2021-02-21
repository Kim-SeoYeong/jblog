<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

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
		
		<div id="content" class="clearfix">
			<div id="profilecate_area">
				<div id="profile">
					
					<c:choose>
						<c:when test="${blogVo.logoFile eq null}">
							<!-- 기본이미지 -->
							<img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
						</c:when>
						<c:otherwise>
							<!-- 사용자업로드 이미지 -->
							<img id="proImg" src="${pageContext.request.contextPath}/upload/${blogVo.logoFile}">
						</c:otherwise>
					</c:choose>
					<div id="nick">${blogVo.userName}(${blogVo.id})님</div>
				</div>
				<div id="cate">
					<div class="text-left">
						<strong>카테고리</strong>
					</div>
					<ul id="cateList" class="text-left">
						<c:forEach items="${categoryList}" var="categoryList">
							<li><a href="$}" data-cateno="${categoryList.cateNo}">${categoryList.cateName}</a></li>
						</c:forEach>
						<!-- 
						<li><a href="$}">미분류</a></li>
						-->
					</ul>
				</div>
			</div>
			<!-- profilecate_area -->
			
			<div id="post_area">
				
				<div id="postBox" class="clearfix">
					<div id="postTitle" class="text-left"><strong>등록된 글이 없습니다.</strong></div>
				<!-- 
						<div id="postTitle" class="text-left"><strong>08.페이징</strong></div>
						<div id="postDate" class="text-left"><strong>2020/07/23</strong></div>
						<div id="postNick">정우성(hijava)님</div>
				 -->
				</div>
				<!-- //postBox -->
				
				
				<!-- 로그인하면 보이게 -->
				<div id="post" >
				<!-- 포스트 글 내용 -->
				<!--
					대통령은 법률이 정하는 바에 의하여 사면·감형 또는 복권을 명할 수 있다. 
					대통령의 임기는 5년으로 하며, 중임할 수 없다. 법관은 탄핵 또는 금고 이상의 
					형의 선고에 의하지 아니하고는 파면되지 아니하며, 징계처분에 의하지 아니하고는 
					정직·감봉 기타 불리한 처분을 받지 아니한다.
					-->
				</div>
				<!-- //post -->
				
				<!-- 글이 없는 경우 -->
				<!-- 
				<div id="postBox" class="clearfix">
							<div id="postTitle" class="text-left"><strong>등록된 글이 없습니다.</strong></div>
							<div id="postDate" class="text-left"><strong></strong></div>
							<div id="postNick"></div>
				</div>
			    
				<div id="post" >
				</div>
				-->
				
				<div id="list">
					<div id="listTitle" class="text-left"><strong>카테고리의 글</strong></div>
					
					<table id="postList">
						<colgroup>
							<col style="">
							<col style="width: 20%;">
						</colgroup>
						<!-- 포스트 리스트 출력 -->
						<!-- 포스트 리스트 출력 -->
					</table>
					 -->
				</div>
				<!-- //list -->
			</div>
			<!-- //post_area -->
			
			
			
		</div>	
		<!-- //content -->
		<div class=></div>
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
//브라우저 준비가 끝났을때(DOM이 생성되면)
	$("document").ready(function(){
		console.log("ready");
		
		//리스트 출력
		cateList();
	});
	
	//포스트 데이터 + html
	function render(postVo) {
		var str = '';
		str += '<tr>';
		str += '	<td class="text-left"><a href="">' + postVo.postTitle + '</a></td>';
		str += '	<td class="text-right">' + postVo.regDate + '</td>';
		str += '</tr>';
		<!--
		var str2 = '';
		str += '<div id="postTitle" class="text-left"><strong>' + postVo.postTitle + '</strong></div>';
		str += '	<div id="postTitle" class="text-left"><strong>' + postVo.postContent + '</strong></div>';
		str += '	<div id="postDate" class="text-left"><strong>' + postVo.postContent + '</strong></div>';
		str += '<tr>';
		str += '<tr>';
		
		
		<div id="postTitle" class="text-left"><strong>등록된 글이 없습니다.</strong></div>
		<!-- 
				<div id="postTitle" class="text-left"><strong>08.페이징</strong></div>
				<div id="postDate" class="text-left"><strong>2020/07/23</strong></div>
				<div id="postNick">정우성(hijava)님</div>
		 -->
		
		$("#postList").append(str);
		$("#post").text(postVo.postContent);
	}
	
	//포스트 카테고리별 리스트 출력
	function cateList() {
		
		var id = "${authUser.id}";
		console.log(id);

		//ajax
		$.ajax({
			
			url : "${pageContext.request.contextPath}/admin/postList",		
			type : "post",
			//contentType : "application/json",
			data : {id : id},

			dataType : "json",
			success : function(postList){
				//성공시 처리해야될 코드 작성
				console.log("성공!");
				console.log(postList);
				
				for(var i = 0; i < postList.length; i++) {
					console.log(postList[i].cateNo);
					console.log(postList[i].postTitle);
					render(postList[i]);
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});	
	}
</script>
</html>