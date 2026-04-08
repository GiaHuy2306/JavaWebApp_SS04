<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi Dữ Liệu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
        }
        .error-container {
            border: 2px solid #dc3545;
            background-color: #f8d7da;
            color: #721c24;
            padding: 30px;
            width: 50%;
            margin: 80px auto;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .error-title {
            font-size: 28px;
            font-weight: bold;
            margin-bottom: 15px;
        }
        .error-message {
            font-size: 16px;
            line-height: 1.5;
            margin-bottom: 25px;
        }
        .back-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="error-container">
    <div class="error-title">Đã xảy ra sự cố!</div>

    <div class="error-message">
        ${errorMessage != null ? errorMessage : "Hệ thống không thể xử lý yêu cầu của bạn. Vui lòng kiểm tra lại đường dẫn."}
    </div>

    <a href="${pageContext.request.contextPath}/admin/tables/list" class="back-btn">
        ← Quay lại danh sách bàn
    </a>
</div>

</body>
</html>