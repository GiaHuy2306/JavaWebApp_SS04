<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chi tiết bàn ăn</title>
    <style>
        .card {
            border: 1px solid #ccc;
            padding: 20px;
            width: 300px;
            border-radius: 8px;
            box-shadow: 2px 2px 12px #eee;
        }
        .status-open { color: green; font-weight: bold; }
        .status-busy { color: red; font-weight: bold; }
        .back-link { display: inline-block; margin-top: 15px; text-decoration: none; color: #007bff; }
    </style>
</head>
<body>
<h2>Thông tin định danh bàn ăn</h2>

<c:choose>
    <%-- Trường hợp tìm thấy bàn --%>
    <c:when test="${not empty table}">
        <div class="card">
            <p><strong>Mã số bàn (ID):</strong> ${table.id}</p>
            <p><strong>Tên gọi:</strong> ${table.name}</p>
            <p><strong>Sức chứa:</strong> ${table.capacity} người</p>
            <p><strong>Trạng thái hiện tại:</strong>
                <span class="${table.status == 'Trống' ? 'status-open' : 'status-busy'}">
                        ${table.status}
                </span>
            </p>

            <hr>
            <form action="../update-status" method="post">
                <input type="hidden" name="id" value="${table.id}">
                <c:choose>
                    <c:when test="${table.status == 'Trống'}">
                        <input type="hidden" name="status" value="Đang dùng">
                        <button type="submit">Đổi sang: Đang dùng</button>
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="status" value="Trống">
                        <button type="submit">Đổi sang: Trống</button>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </c:when>

    <%-- Trường hợp không tìm thấy bàn hoặc ID sai --%>
    <c:otherwise>
        <div style="color: red; border: 1px solid red; padding: 10px; width: fit-content;">
                ${error != null ? error : "Dữ liệu bàn ăn không tồn tại hoặc đã bị xóa!"}
        </div>
    </c:otherwise>
</c:choose>

<a href="../list" class="back-link">← Quay lại danh sách bàn</a>

</body>
</html>