<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link href="tools/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="tools/jquery.min.js"></script>
</head>
<body>
<div class="container" style="margin: 20px auto";>
    <form action="RequestHoliday" method="post">
        <div class="row" style="margin: 10px 0;">
            <div class="form-group col-md-2">
                <select class="form-control" name="xy">
                    <option disabled selected>学院</option>
                    <option >数据信息学院</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <select class="form-control" name="zy">
                    <option disabled selected>专业</option>
                    <option>软件技术</option>
                    <option>大数据</option>
                    <option>计算机科学技术</option>
                    <option>计算机应用</option>
                    <option>移动应用开发</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <select class="form-control" name="bj">
                    <option disabled selected>班级</option>
                    <option>一班</option>
                    <option>二班</option>
                    <option>三班</option>
                    <option>四班</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <select class="form-control" name="fdy">
                    <option disabled selected>辅导员</option>
                    <option>李祯兆</option>
                    <option>2</option>
                    <option>3</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <select class="form-control" name="jy">
                    <option disabled selected>假因</option>
                    <option>事假</option>
                    <option>病假</option>
                    <option>其它(备注)</option>
                </select>
            </div>

            <div class="form-group col-md-2">
                <select class="form-control" name="ts">
                    <option disabled selected>请假天数</option>
                    <option>1天</option>
                    <option>2天</option>
                    <option>3天</option>
                    <option>4天</option>
                    <option>5天</option>
                    <option>6天</option>
                    <option>7天</option>
                </select>
            </div>

        </div>
        <div class="row">
            <div class="form-group">
                    <textarea class="form-control" rows="5" style="font-size: 18px;" name="bz">
                    </textarea>
            </div>
        </div>

        <!-- 请假时间 -->
        <div class="row" style="margin-top: 20px; margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px;margin: 5px 0 5px -18px;" >请假时间: </div>
            <input type="date" class="col-md-2" style="margin: 5px 0 0 -80px;" name="qj" id="qj">
        </div>

        <!-- 返校时间 -->
        <div class="row" style=" margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px; margin: 5px 0 5px -18px;">返校时间: </div>
            <input type="date" class="col-md-2" style="margin: 5px 0 0 -80px;" name="fx" id="fx">
        </div>

        <!-- 联系电话 -->
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px; margin: 5px 0 5px -18px;">联系电话: </div>
            <div class="col-md-3">
                <input class="form-control" style="margin-left: -105px; border: none; border-bottom: solid 1px; border-radius: 0; box-shadow: none;" type="text" class="form-control" name="lx">
            </div>
        </div>

        <!-- 家长电话 -->
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px; margin: 5px 0 5px -18px;">家长电话: </div>
            <div class="col-md-3">
                <input class="form-control" style="margin-left: -105px; border: none; border-bottom: solid 1px; border-radius: 0; box-shadow: none;" type="text" class="form-control" name="jz">
            </div>
        </div>

        <!-- 姓名 -->
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px; margin: 5px 0 5px -18px;">姓名: </div>
            <div class="col-md-3">
                <input class="form-control" style="margin-left: -105px; border: none; border-bottom: solid 1px; border-radius: 0; box-shadow: none;" type="text" class="form-control" name="xm">
            </div>
        </div>

        <!-- 学号 -->
        <div class="row" style="margin-bottom: 20px;">
            <div class="col-md-2" style="font-size: 18px; margin: 5px 0 5px -18px;">学号: </div>
            <div class="col-md-3">
                <input class="form-control" style="margin-left: -105px; border: none; border-bottom: solid 1px; border-radius: 0; box-shadow: none;" type="text" class="form-control" name="xh">
            </div>
        </div>

        <!-- 提交按钮 -->
        <div class="row">
            <div class="col-md-2 col-sm-offset-10">
                <button style="margin: 0 20px;" type="submit" class="btn btn-success" id="btn">提交</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>