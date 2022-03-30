<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메인 페이지</h1>

	<a href="logout.do">LOGOUT</a>

	<form action="search.do" method="post">
		<table border="1">
			<tr>
				<td><select name="searchCondition">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
				</select> <input type="text" name="searchKeyword"> <input
					type="submit" value="검색"></td>
			</tr>
		</table>
	</form>

	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글 작성자</th>
		</tr>

	</table>

	<a href="insertBoard.jsp">글 등록</a>

</body>
</html>