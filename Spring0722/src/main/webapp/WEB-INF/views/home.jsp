<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>박건강바보</title>
	<style type="text/css">
		a{
			text-decoration: none;
		}
		a:visited{
			color:balck;
		}
	
	</style>
</head>
<body>

<h1>
	아저씨 바보 
</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
		</tr>
		<c:forEach items="${boardList }" var="board">
			<tr>
				<th>${board.BOARDNUM }</th>
				<th>${board.BOARDTITLE }</th>
				<th>${board.MEMBERID }</th>
			</tr>
		</c:forEach>
	
	</table>
<%-- 	${navi }<br> --%>
	<!-- 이전 그룹 이동 기능 -->
   <c:if test="${navi.currentGroup > 0 }">
      <a href="/?currentPage=1">
         &lt;&lt;
      </a>&nbsp;
      <a href="/?currentPage=${navi.startPageGroup - 1 }"> 
         &lt; <!-- lt:less than -->
      </a>   
   </c:if>   
   
   <!-- 현재 그룹 내 모든 페이지 표시 -->
   
   <!-- 현재 페이지는 빨간색으로 표시 -->
   <c:forEach begin="${navi.startPageGroup }" end="${navi.endPageGroup }" var="page">
      <c:if test="${page == navi.currentPage }">
         &nbsp;<a href="/?currentPage=${page }" style="font-weight: bold;color: red;">
            ${page }
         </a>&nbsp;
      </c:if>      
   <!-- 현재 페이지 말고 다른 페이지는 파란색으로 표시 -->
      <c:if test="${page != navi.currentPage }">
         &nbsp;<a href="/?currentPage=${page }" style="color: blue;">
            ${page }
         </a>&nbsp;
      </c:if>      
   </c:forEach>
   
   <!-- 다음 그룹 이동 기능 -->
   <c:if test="${navi.totalPageCount != navi.endPageGroup}">
      <a href="/?currentPage=${navi.endPageGroup + 1 }"> 
         &gt; <!-- gt:greater than -->
      </a>&nbsp;   
      <a href="/?currentPage=${navi.totalPageCount }">
         &gt;&gt;
      </a>
   </c:if>   
</body>
</html>
