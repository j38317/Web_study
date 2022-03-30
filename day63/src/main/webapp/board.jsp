<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>상세 페이지</h1>

	<form action="updateBoard.do" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="글 변경"></td>
			</tr>
		</table>
	</form>

	<a href="deleteBoard.do">글 삭제</a>
	<a href="main.do">메인페이지</a>

</body>
</html>