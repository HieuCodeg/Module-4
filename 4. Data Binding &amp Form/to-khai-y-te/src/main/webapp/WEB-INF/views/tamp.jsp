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
        span{
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


<div class="container">
    <div class="form-group">
        <label >Họ tên(ghi chữ IN HOA) <span>(*)</span></label>
        <p class="form-control"></p>

    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label >Năm sinh <span>(*)</span></label>
            <input type="text" class="form-control" >
        </div>
        <div class="form-group col-md-4">
            <label >Giới tính <span>(*)</span></label>
            <select class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label >Quốc tịch <span>(*)</span></label>
            <select class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span>(*)</span></label>
        <input type="text" class="form-control">
    </div>
    <div class="form-group">
        <label>Thông tin đi lại<span>(*)</span></label>
        <div class="form-check ">
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="gridRadios" value="option1"
                       checked>
                <label class="form-check-label" >
                    Car
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="gridRadios" value="option1"
                       checked>
                <label class="form-check-label" >
                    Plane
                </label>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label >Số hiệu phương tiện</label>
            <input type="text" class="form-control" >
        </div>
        <div class="form-group col-md-6">
            <label >Số ghế</label>
            <input type="text" class="form-control" >
        </div>

    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Ngày khởi hành<span>(*)</span></label>
            <input type="date" class="form-control" >
        </div>
        <div class="form-group col-md-6">
            <label >Ngày kết thúc<span>(*)</span></label>
            <input type="date" class="form-control" >
        </div>
    </div>
    <div class="form-group">
        <label>Trong vòng 14 ngày qua, Anh/chị có đến tỉnh/thành phố nào? <span>(*)</span></label>
        <input type="text" class="form-control">
    </div>

    <div>
        <p>Địa chỉ liên lạc</p>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label >Tỉnh / thành <span>(*)</span></label>
            <select class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label >Quận / huyện <span>(*)</span></label>
            <select class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label for="inputState">Phường / xã  <span>(*)</span></label>
            <select id="inputState" class="form-control">
                <option selected>Choose...</option>
                <option>...</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label>Địa chỉ nơi ở  <span>(*)</span></label>
        <input type="text" class="form-control">
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label >Điện thoại <span>(*)</span></label>
            <input type="text" class="form-control" >
        </div>
        <div class="form-group col-md-6">
            <label >Email</label>
            <input type="text" class="form-control" >
        </div>
    </div>
</div>
<div class="container">
    <label>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <span>(*)</span></label>
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
            <td>Sốt<span>(*)</span></td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
            <td>Nôn/ buồn nôn<span>(*)</span> </td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
        </tr>
        <tr>
            <td>Ho<span>(*)</span></td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
            <td>Tiêu chảy<span>(*)</span> </td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
        </tr>
        <tr>
            <td>Khó thở<span>(*)</span></td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
            <td>Xuất huyết ngoài da<span>(*)</span> </td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
        </tr>
        <tr>
            <td>Đau họng<span>(*)</span></td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
            <td>Nổi ban ngoài da<span>(*)</span> </td>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="container">
    <label>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span>(*)</span></label>
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
            <th class="col-md-10">Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ cở sở giết mổ động vật/ tiếp xúc động vật <span>(*)</span></th>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
            </td>
        </tr>
        <tr>
            <th class="col-md-10">Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV  <span>(*)</span></th>
            <td>
                <input type="radio" name="gridRadios"  value="option1">
            </td>
            <td>
                <input type="radio" name="gridRadios" value="option1" checked>
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
        <button type="button" class="btn btn-success" data-toggle="button" aria-pressed="false" autocomplete="off">
            Sửa đổi
        </button>
    </div>

<footer>
    &copy; 2022 HieuCodeg
</footer>
</body>
</html>
