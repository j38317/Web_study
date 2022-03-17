<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
<c:when test="${member!=null}">
	<li>
	<form action="logout.do?a=${a}&b=${b}" method="post">
	<a href="main.do?a=${member.mid}">${member.mname}님</a>, 환영합니다! :D
	<input type="submit" value="로그아웃">
	</form>
	</li>
</c:when>
<c:otherwise>
	<li><a href="signup.jsp">회원가입</a></li><!-- javascript:newMember() -->
	<li>
	<form action="login.do?a=${a}&b=${b}" method="post">
	아이디: <input type="text" name="mid" required> 비밀번호: <input type="password" name="mpw" required>
	<input type="submit" value="로그인">
	</form>
	</li>
</c:otherwise>
</c:choose>