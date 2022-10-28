<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>Bo Y TE</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style type="text/css">
        body{
            margin-top: 20px;
        }
        .star{
            color: red;
            font-style: italic;
        }
        h4,h6 {
            text-align: center;
        }
        .red{
            color: red;
        }

    </style>
</head>

<body>
<h4>TỜ KHAI Y TẾ</h4>
<h6>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/ CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
    DỊCH BỆNH TRUYỀN NHIỄM</h6>
<h6 class="red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h6>


<form:form method="POST" action="update" modelAttribute="medical">
    <div class="container">
        <div class="form-group">
            <label >Họ tên(ghi chữ IN HOA) <span class="star">(*)</span></label>
            <form:input path="name" class="form-control" readonly="true"></form:input>

        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label >Năm sinh <span class="star">(*)</span></label>
                <form:input path="yearOfBirth" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-4">
                <label >Giới tính <span class="star">(*)</span></label>
                <form:input path="gender" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-4">
                <label >Quốc tịch <span class="star">(*)</span></label>
                <form:input path="country" class="form-control" readonly="true"></form:input>
            </div>
        </div>

        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="star">(*)</span></label>
            <form:input path="passport" class="form-control" readonly="true"></form:input>
        </div>
        <div class="form-group">
            <label>Thông tin đi lại<span class="star">(*)</span></label>
            <div class="form-check ">
                <form:input path="tranfer" class="form-control" readonly="true"></form:input>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label >Số hiệu phương tiện</label>
                <form:input path="numberTranfer" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-6">
                <label >Số ghế</label>
                <form:input path="numberChair" class="form-control" readonly="true"></form:input>
            </div>

        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Ngày khởi hành<span class="star">(*)</span></label>
                <form:input path="departureDay" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-6">
                <label >Ngày kết thúc<span class="star">(*)</span></label>
                <form:input path="endDay" class="form-control" readonly="true"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label>Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào? <span class="star">(*)</span></label>
            <form:input path="provinceVisit" class="form-control" readonly="true"></form:input>
        </div>

        <div>
            <p>Địa chỉ liên lạc</p>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label >Tỉnh / thành <span class="star">(*)</span></label>
                <form:input path="province" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-4">
                <label >Quận / huyện <span class="star">(*)</span></label>
                <form:input path="district" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-4">
                <label >Phường / xã  <span class="star">(*)</span></label>
                <form:input path="town" class="form-control" readonly="true"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label>Địa chỉ nơi ở  <span class="star">(*)</span></label>
            <form:input path="address" class="form-control" readonly="true"></form:input>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label >Điện thoại <span class="star">(*)</span></label>
                <form:input path="phoneNumber" class="form-control" readonly="true"></form:input>
            </div>
            <div class="form-group col-md-6">
                <label >Email</label>
                <form:input path="email" class="form-control" readonly="true"></form:input>
            </div>
        </div>
    </div>
    <div class="container">
        <label>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <span class="star">(*)</span></label>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th class="col-md-4">Triệu chứng</th>
                <th class="col-md-1">Có</th>
                <th class="col-md-1">Không</th>
                <th class="col-md-4">Triệu chứng</th>
                <th class="col-md-1">Có</th>
                <th class="col-md-1">Không</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Sốt<span class="star">(*)</span></td>
                <td>
                    <form:radiobutton path="fever" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="fever" value="false" disabled="true"/>
                </td>
                <td>Nôn/ buồn nôn<span class="star">(*)</span> </td>
                <td>
                    <form:radiobutton path="vomit" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="vomit" value="false" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td>Ho<span class="star">(*)</span></td>
                <td>
                    <form:radiobutton path="cough" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="cough" value="false" disabled="true"/>
                </td>
                <td>Tiêu chảy<span class="star">(*)</span> </td>
                <td>
                    <form:radiobutton path="diarrhea" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="diarrhea" value="false" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td>Khó thở<span class="star">(*)</span></td>
                <td>
                    <form:radiobutton path="shortnessOfBreath" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="shortnessOfBreath" value="false" disabled="true"/>
                </td>
                <td>Xuất huyết ngoài da<span class="star">(*)</span> </td>
                <td>
                    <form:radiobutton path="hemorrhage" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="hemorrhage" value="false" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td>Đau họng<span class="star">(*)</span></td>
                <td>
                    <form:radiobutton path="soreThroat" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="soreThroat" value="false" disabled="true"/>
                </td>
                <td>Nổi ban ngoài da<span class="star">(*)</span> </td>
                <td>
                    <form:radiobutton path="rash" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="rash" value="false" disabled="true"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="container">
        <label>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span class="star">(*)</span></label>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th class="col-md-10"></th>
                <th class="col-md-1">Có</th>
                <th class="col-md-1">Không</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="col-md-10">Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cở sở giết mổ động vật/ tiếp xúc động vật <span class="star">(*)</span></th>
                <td>
                    <form:radiobutton path="animalContact" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="animalContact" value="false" disabled="true"/>
                </td>
            </tr>
            <tr>
                <th class="col-md-10">Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV  <span class="star">(*)</span></th>
                <td>
                    <form:radiobutton path="animalPatient" value="true" disabled="true"/>
                </td>
                <td>
                    <form:radiobutton path="animalPatient" value="false" disabled="true"/>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="container">
        <div class="red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.</div>
        <div class="red">Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</div>
    </div>
    <div class="container text-center">
        <a href="/">
            <button type="button" class="btn btn-success" data-toggle="button" aria-pressed="false" autocomplete="off">
                Sửa đổi
            </button>
        </a>
    </div>
</form:form>

<footer>
    &copy; 2022 HieuCodeg
</footer>
</body>
</html>
