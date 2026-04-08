# [cite_start]BÁO CÁO KẾT QUẢ THỰC HÀNH - SESSION 04 [cite: 1]

## [cite_start]## Bài 2: Xử lý bẫy dữ liệu với @RequestParam [cite: 1]

Mục tiêu của bài này là xử lý bẫy dữ liệu để hệ thống không bị lỗi khi khách hàng quên truyền tham số.

**Trước khi dùng `required = false: 
    * Khi truy cập thẳng vào `/bai2/menu` mà không có tham số `?category=...`, hệ thống lập tức báo lỗi **HTTP 400 – Requête invalide**[cite: 2].
    * Thông báo lỗi: "Required parameter 'category' is not present"[cite: 2].

* [cite_start]**Sau khi dùng `required = false` và `defaultValue = “chay”`**: [cite: 3]
    * [cite_start]Đường dẫn luôn hoạt động ổn định và trả về loại "chay" nếu khách quên nhập[cite: 3].
    * [cite_start]Kết quả hiển thị trên trình duyệt: "Menu cho loai: chay"[cite: 3].

---

## [cite_start]## Bài 3: Phân tích URI Path và Query String [cite: 4]

Dựa trên yêu cầu lấy thông tin chi tiết của một đơn hàng cụ thể (ID số 5), chúng ta có hai cách thiết kế URL:

* **Phân tích vị trí số 5**:
    * [cite_start]**Cách A (`/bai3/orders/5`)**: Số 5 nằm trực tiếp trên **URI Path** (định danh tài nguyên)[cite: 5].
    * [cite_start]**Cách B (`/bai3/orders?id=5`)**: Số 5 nằm ở **Query String** (thường dùng để lọc hoặc tìm kiếm)[cite: 6].
* [cite_start]**Lựa chọn**: Theo tiêu chuẩn thiết kế bài học, để lấy ID của một đối tượng cụ thể thì **Cách A (@PathVariable)** là chuẩn RESTful và phù hợp hơn[cite: 7].

---

## [cite_start]## Bài 4: Hiển thị dữ liệu ra giao diện JSP [cite: 8]

Mục tiêu là truyền dữ liệu từ Controller ra View bằng `ModelMap` và xử lý lỗi ép kiểu dữ liệu.

* [cite_start]**Bẫy dữ liệu ép kiểu**: [cite: 9]
    * [cite_start]Khi khách hàng cố tình nhập sai định dạng (ví dụ: `limit=abc` thay vì số), hệ thống ném ra lỗi **HTTP 400 – Requête invalide** do sai lệch kiểu dữ liệu (Type Mismatch)[cite: 9].
* [cite_start]**Kết quả khi nhập đúng URL**: [cite: 10]
    * [cite_start]Dữ liệu `category`, `limit` và `message` ("Tìm kiếm thành công") được hiển thị chính xác trên trang `productList.jsp`[cite: 10].

---

## [cite_start]## Bài 5: Xây dựng luồng Quản lý đơn hàng toàn diện [cite: 11]

### [cite_start]### 1. Sơ đồ luồng (Data Flow) [cite: 12]
[cite_start]Quy trình xử lý dữ liệu tuân theo kiến trúc 3 tầng chuẩn Spring: [cite: 13]
[cite_start]`Client (Browser/Postman) -> Controller (Check bẫy dữ liệu) -> Service (Logic) -> Repository (Data) -> Trả về String` [cite: 13]

### [cite_start]### 2. Giải thích tính Idempotent [cite: 14]
Tính Idempotent là khả năng một thao tác có thể thực hiện nhiều lần mà không làm thay đổi kết quả sau lần thực hiện đầu tiên:

* [cite_start]**POST (Tạo đơn)**: **Không có tính Idempotent**[cite: 15]. [cite_start]Nếu nhân viên bấm "Lưu" 3 lần do lag mạng, Server sẽ tạo ra 3 đơn hàng khác nhau trong Database, gây dư thừa dữ liệu rác[cite: 16, 17].
* [cite_start]**DELETE (Hủy đơn)**: **Có tính Idempotent**[cite: 18]. [cite_start]Dù nhân viên bấm "Hủy" đơn hàng số 5 tới 10 lần, kết quả cuối cùng vẫn là đơn hàng số 5 biến mất và không làm thay đổi thêm trạng thái hệ thống sau lần xóa đầu tiên[cite: 18, 19].