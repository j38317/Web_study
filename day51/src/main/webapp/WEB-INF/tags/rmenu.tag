<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="rid" %>
<%@ attribute name="mid" %>

<c:if test="${member.mid == mid}">
	| [ <a href="deleteReply.do?rid=${rid}&a=${a}&b=${b}">삭제</a> ]
</c:if>
