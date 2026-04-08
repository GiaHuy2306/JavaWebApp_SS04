<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản lý Bàn Ăn</title>
</head>
<body>
<h2>Danh sách bàn ăn</h2>

<c:if test="${not empty error}">
    <p style="color: red;"><b>${error}</b></p>
</c:if>
<c:if test="${not empty message}">
    <p style="color: blue;"><b>${message}</b></p>
</c:if>

<form action="list" method="get">
    Lọc sức chứa:
    <input name="cap" type="number" value="${currentCap}">
    <button type="submit">Tìm</button>
</form>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Tên Bàn</th>
        <th>Sức Chứa</th>
        <th>Trạng Thái</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="t" items="${tables}">
        <tr>
            <td>${t.id}</td>
            <td><a href="view/${t.id}">${t.name}</a></td> <td>${t.capacity}</td>
            <td>${t.status}</td>
            <td>
                <form action="update-status" method="post" style="display:inline">
                    <input type="hidden" name="id" value="${t.id}">
                    <c:choose>
                        <c:when test="${t.status == 'Trống'}">
                            <input type="hidden" name="status" value="Đang dùng">
                            <button type="submit">Nhận bàn</button>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="status" value="Trống">
                            <button type="submit">Dọn bàn</button>
                        </c:otherwise>
                    </c:choose>
                </form>

                <form action="delete/${t.id}" method="post" style="display:inline">
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa ${t.name}?')">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>