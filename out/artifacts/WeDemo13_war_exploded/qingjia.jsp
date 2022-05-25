<%--
  Created by IntelliJ IDEA.
  User: kj
  Date: 2022/5/15
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.Student" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <%--    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.min.css">--%>
    <%--    <script src="../jquery-3.6.0.min.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <%--    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body >
<%
    Object objstu=session.getAttribute("loginedStudent");
    Student stu=null;
    if (objstu!=null){
        stu= (Student) objstu;
    }
%>

<div class="container">
    <div class="col-md-2" style="position: absolute; font-size: 18px; font-weight: 300; text-align: right; padding: 20px 0;">
        <button id="btn1" type="button" class="btn btn-default" style="margin-bottom: 20px; border: solid 1px #66CCFF;">请假首页</button><br>
        <button id="btn2" type="button" class="btn btn-default" style="border: solid 1px #66CCFF;">请假详情</button>
        <!-- <button style="margin-bottom: 20px;">请假详情</button> -->
    </div>
    <form onsubmit="return false" class="row col-md-8 offset-md-2" style="position: absolute; top: 20px;">
        <div class="qingjia">
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">院校</label>
                <input class="col-md-8" type="text"value="" required  placeholder="请输入院系">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">专业</label>
                <input class="col-md-8" type="text" required  placeholder="请输入专业名称">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">班级</label>
                <input class="col-md-8" type="text" required  placeholder="请输入班级">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">姓名</label>
                <input class="col-md-8" type="text"value="<%=stu.getStu_name() %>" required  readonly placeholder="请输入姓名">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">学号</label>
                <input class="col-md-8" type="text"  value="<%=stu.getStu_userNum()%>" required  readonly placeholder="请输入学号">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">假因</label>
                <input class="col-md-8" type="text" required   placeholder="请输入假因">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">辅导员</label>
                <input class="col-md-8" type="text" required  placeholder="请输入辅导员">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">请假天数</label>
                <input class="col-md-8" type="text" required  readonly placeholder="请假天数 (此值无需手动输入)">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">请假时间</label>
                <input class="col-md-8" type="date" value=""  required  placeholder="请输入时间">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">返校时间</label>
                <input class="col-md-8" type="date"onchange="Time()" value="" required placeholder="请输入返校">
            </div>
            <div style="margin-bottom: 30px;">
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">联系电话</label>
                <input class="col-md-8" type="number" required placeholder="请输入联系电话">
            </div>
            <div>
                <label style="width: 120px; text-align: right; font-size: 18px; letter-spacing: 10px;">家长电话</label>
                <input class="col-md-8" type="number"  required  placeholder="请输入家长电话">
            </div>
            <button class="btn btn-success offset-md-11" id="submit" style="width: 150px; position: relative; top: -38px;">提交</button>
        </div>
        <div class="xiaojia" style="display: none;">
            <table class="table table-hover" style="text-align: center;">
                <thead>
                <tr>
                    <th>班级名称</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>联系电话</th>
                    <th>请假日期</th>
                    <th>请假天数</th>
                    <th>假因</th>
                    <th>我已到校</th>
                    <th>状态</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>

    </form>
</div>

<script type="text/javascript">
<%--    当页面加载时候向后台发送请求返回该同学之前的请假记录放入详情页面  --%>
    var xhr
    function Ajax() {
        xhr = new XMLHttpRequest()
        xhr.open('post', 'RequestHolidayServlets', true)
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    }
        Ajax()
            xhr.send()
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        console.log(xhr)
                        var data2 =  JSON.parse(xhr.response);
                        console.log(data2);
                        for (let i = 0; i < data2.length; i++) {
                            var oTr = document.createElement("tr")
                            oTr.id = 'oTrs'
                            let oTd = document.createElement('td')
                            let oTd1 = document.createElement("td")
                            let oTd2 = document.createElement("td")
                            let oTd3 = document.createElement("td")
                            let oTd4 = document.createElement("td")
                            let oTd5 = document.createElement("td")
                            let oTd6 = document.createElement("td")
                            let oTd7 = document.createElement("td")
                            let oTd8 = document.createElement("td")
                            let oTd9 = document.createElement("td")

                            //给 td 节点赋值
                            oTd.innerText = data2[i].classes
                            oTd1.innerText = data2[i].userNum
                            oTd2.innerText = data2[i].name
                            oTd3.innerText = data2[i].phoneNum
                            oTd4.innerText = data2[i].severalDays + '-' + data2[i].backDays
                            oTd5.innerText = data2[i].days
                            oTd6.innerText = data2[i].cause
                            if (data2[i].isconsent == true && data2[i].isconsent2 == true){
                                oTd7.innerHTML = `<button id="btn4" class="btn btn-success">销假</button>`
                                oTd8.innerHTML = '同意'
                            }else if(data2[i].isconsent == false && data2[i].isconsent2 == false){
                                oTd7.innerHTML = `<button id="btn4" class="btn btn-success" style="display: none">销假</button>`
                                oTd8.innerHTML = '拒绝'
                            }else if(data2[i].isconsent == false && data2[i].isconsent2 == true){
                                oTd7.innerHTML = `<button id="btn4" class="btn btn-success" style="display: none">销假</button>`
                                oTd8.innerHTML = '老师尚未操作'
                            }else if(data2[i].isconsent == true && data2[i].isconsent2 == false){
                                oTd7.innerHTML = ''
                                oTd8.innerHTML = '已销假'
                            }
                            oTd9.innerHTML = data2[i].id
                            oTd9.style.display = 'none'
                            oTd9.id = 'oTd9'

                            //将 td 插入到 tr 中
                            oTr.appendChild(oTd);
                            oTr.appendChild(oTd1);
                            oTr.appendChild(oTd2);
                            oTr.appendChild(oTd3);
                            oTr.appendChild(oTd4)
                            oTr.appendChild(oTd5)
                            oTr.appendChild(oTd6)
                            oTr.appendChild(oTd7)
                            oTr.appendChild(oTd8)
                            oTr.appendChild(oTd9)

                            var tbody = document.querySelector('tbody')
                            // 将创建的 tr 插入到 tbody 里面
                            tbody.appendChild(oTr)
                        }



                        var btn4 = document.querySelectorAll('#btn4')
                        var oTrs = document.querySelectorAll('#oTrs')
                        var td9s = document.querySelectorAll('#oTd9')
                        for (let k = 0; k < btn4.length; k ++){
                            btn4[k].addEventListener('click',function (){
                                var isSchool = prompt("输入“确认”销假")
                                if(isSchool == '确认'){
                                    btn4[k].disabled = true
                                    btn4[k].innerHTML = '已销假'
                                    Ajax()
                                    xhr.send('ids=' + td9s[k].innerHTML + '&isSchool=' + true)
                                    alert("销假成功")
                                }else {
                                    alert('取消销假')
                                }
                            })
                        }
                    }
                }
            }


    var qingjia = document.querySelector('.qingjia')
    var xiaojia = document.querySelector('.xiaojia')
    var btn1 = document.querySelector('#btn1')
    var btn2 = document.querySelector('#btn2')
    var input = document.querySelectorAll('input')
console.log(input)
    var submit = document.querySelector('#submit')
    var td = document.querySelectorAll('td')
    // var btn3 = document.querySelectorAll('#btn3')
    // console.log(btn3)

    btn1.addEventListener('click',function(){
        xiaojia.style.display = 'none'
        qingjia.style.display = 'block'
    })

    btn2.addEventListener('click',function(){
        qingjia.style.display = 'none'
        xiaojia.style.display = 'block'
    })


    function Time(){
        console.log(2345)
        if (input[8].value != '' && input[9].value != '') {
            var a=new Date(input[8].value);
            var b=new Date(input[9].value);
            var c=(b-a)/1000/60/60/24;
            console.log(c);
            input[7].value = c + '天'
        }else{
            input[9].value = ''
            alert("请先选择请假时间")
        }
    }


    var data
    submit.addEventListener('click',function(){
        if (input[9].value != ''){
            if (input[10].value.length != 11 && input[11].value.length != 11){
                alert('请输入11位手机号码');
            }else {
                alert('提交成功')
                window.location.reload()
            }
        }
        Ajax()
        xhr.send('value0=' + input[0].value + '&value1=' + input[1].value + '&value2=' + input[2].value  + '&value3=' + input[3].value + '&value4=' + input[4].value + '&value5=' + input[5].value + '&value6=' + input[6].value + '&value7=' + input[7].value + '&value8=' + input[8].value + '&value9=' + input[9].value + '&value10=' + input[10].value + '&value11=' + input[11].value);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    console.log(xhr)
                    data = JSON.parse(xhr.responseText)
                    console.log(data)
                    td[0].innerHTML = data[0].classes
                    td[1].innerHTML = data[0].userNum
                    td[2].innerHTML = data[0].name
                    td[3].innerHTML = data[0].phoneNum
                    td[4].innerText = data[0].severalDays + '-' + data2[i].backDays
                    td[5].innerHTML = data[0].days
                    td[6].innerHTML = data[0].cause
                    // td[7].innerHTML = btn3.style.display = 'block'
                    console.log(data.isconsent,data.isconsent2)
                    if (data.isconsent == false && data.isconsent2 == true){
                        td[8].innerHTML = '老师尚未操作'
                    }else if(data.isconsent == true && data.isconsent2 == true){
                        td[8].innerHTML = '同意'
                    }else if(data.isconsent == false && data.isconsent2 == false){
                        td[8].innerHTML = '拒绝'
                    }
                }
            }
        }

    })
</script>

</body>
</html>
