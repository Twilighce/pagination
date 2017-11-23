<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息展示页面</title>
<style type="text/css">
	.pagingbar {
		text-align: center;	
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<!-- 数据列表 -->
	<table align="center" border="1">
		<thead>
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>出版社</th>
				<th>类型</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty requestScope.page}">
					<c:forEach items="${requestScope.page.list}" var="book">
						<tr>
							<td>${book.id}</td>
							<td>${book.name}</td>
							<td>${book.author}</td>
							<td>${book.price}</td>
							<td>${book.publisher}</td>
							<td>${book.type}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="9">
							<font color="red">当前没有数据</font>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	<!-- 分页条 -->
	<div class="pagingbar">
		<c:if test="${not empty requestScope.page}">
			<c:if test="${requestScope.page.currentPage > 1}">
				<a href="${pageContext.request.contextPath}/bookservlet?method=getPageData&currentPage=1">首页</a>
			</c:if>
			<c:if test="${requestScope.page.currentPage > 1}">
				<a href="${pageContext.request.contextPath}/bookservlet?method=getPageData&currentPage=${requestScope.page.currentPage - 1}">上一页</a>
			</c:if>
			<c:forEach begin="${requestScope.page.begin}" end="${requestScope.page.end}" step="1" var="pageNum">
				<a href="${pageContext.request.contextPath}/bookservlet?method=getPageData&currentPage=${pageNum}"
				   ${pageNum == requestScope.page.currentPage ? "style='font-size:20px;color:red;'" : "style='color:blue;'"}
				>
					${pageNum}
				</a>
			</c:forEach>
			<c:if test="${requestScope.page.currentPage < requestScope.page.pageCount}">
				<a href="${pageContext.request.contextPath}/bookservlet?method=getPageData&currentPage=${requestScope.page.currentPage + 1}">下一页</a>
			</c:if>
			<c:if test="${requestScope.page.currentPage < requestScope.page.pageCount}">
				<a href="${pageContext.request.contextPath}/bookservlet?method=getPageData&currentPage=${requestScope.page.pageCount}">尾页</a>
			</c:if>
		</c:if>
		<form action="${pageContext.request.contextPath}/bookservlet?method=getPageData" method="post" style="display: inline;">
			<input type="text" name="currentPage" style="width: 20px"/>
			<input type="submit" value="Go">
		</form>
		当前 ${requestScope.page.currentPage}页
		共    ${requestScope.page.pageCount}页
		共    ${requestScope.page.recordCount}条记录
	</div>
</body>
</html>