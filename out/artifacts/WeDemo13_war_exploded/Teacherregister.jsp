<%--
  Created by IntelliJ IDEA.
  User: kj
  Date: 2022/5/12
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.*" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <%--    <mvc:resourcess mapping="/tools/jquery-3.6.0.min.js" location="/tools/"></mvc:resourcess>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <%--    <script type="text/javascript" src="https://cdn.bootcdn.net/ajax/libs/axios/0.27.2/axios.min.js"></script>--%>
    <%--    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>--%>

    <%--    <link href="tools/bootstrap.min.css" rel="stylesheet" />--%>
    <%--    <script type="text/javascript" src="tools/jquery-3.6.0.min.js"></script>--%>
    <%--    <script src="tools/bootstrap.min.js"></script>--%>
    <%--    <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.27.2/axios.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>--%>
</head>
<title>Title</title>
<body style="height: 100vh; ">
<div class="container" style="padding-top: 150px;">
    <div class="row">
        <div class="col-md-6 offset-3 text-center" style="font-size: 30px; font-weight: 300; margin-top: 20px; margin-bottom: 20px;">
            教师注册
        </div>
        <div class="col-md-6 offset-3">
            <div class="row form-group col-md-12">
                <div class="col-md-8 offset-md-2">
                    <input autocomplete=off onkeyup="MyXingM()" id="xingming" type="text" class="form-control" style="border-radius: 50px"; placeholder="姓名：(请输入2-5位汉字)">
                    <label id="lab1" class="form-label" style="visibility: hidden; color: red">请重新输入正确的姓名</label>
                    <!-- <label id="lab1" class="form-label" style="display: none;color: red">请重新输入正确的姓名</label> -->
                </div>
            </div>
            <div class="row form-group col-md-12">
                <div class="col-md-8 offset-md-2">
                    <input autocomplete=off onkeyup="MyXueH()" id="xuehao" type="number" class="form-control" style="border-radius: 50px;" placeholder="学号：(请输入8位数字)">
                    <label id="lab2" class="form-label" style="visibility: hidden; color: red">请重新输入正确的学号</label>
                    <!-- <label id="lab2" class="form-label" style="display: none;color: red">请重新输入正确的学号</label> -->
                </div>
            </div>
            <div class="row form-group col-md-12" style="margin-bottom: 20px;">
                <div class="col-md-8 offset-md-2">
                    <input autocomplete=off onkeyup="MyMiM()" id="mima" type="password" onkeyup="this.value=this.value.replace(/[^\w]/g,'')" class="form-control" style="border-radius: 50px;" placeholder="密码：(请输入数字字母)">
                    <!-- <label id="lab3" class="form-label" style="display: none;color: red">请重新输入正确的密码</label> -->
                    <label id="lab3" class="form-label" style="visibility: hidden; color: red">请重新输入正确的密码</label>
                </div>
            </div>
            <!-- <label class="col-sm-2 col-md-8 offset-md-2" style="border:solid 1px; color: red; font-size: 13px; display: block;">账号或密码错误！请重新登录</label> -->

            <!-- <div class="row"> -->

            <!-- </div> -->
        </div>
        <div class="row col-md-12 text-center">
            <button id="submit" class="btn col-md-2 offset-md-5 text-center" style="border-radius: 50px; border: solid 1px;">立即注册</button>
            <a href="login.jsp" class="col-md-2 offset-md-1" style="position: relative; bottom: -10px">已注册，立即登录</a>
        </div>
    </div>
</div>

<script>
    // 获取提交按钮
    var submit = document.querySelector('#submit')
    // 获取学号框
    var xuehao = document.querySelector('#xuehao')
    // 获取姓名框
    var xingming = document.querySelector('#xingming')
    // 获取密码框
    var mima = document.querySelector('#mima')

    var lab1 = document.querySelector('#lab1')
    var lab2 = document.querySelector('#lab2')
    var lab3 = document.querySelector('#lab3')

    function MyXingM(){
        // 对姓名的格式进行判断
        let reg = /^[\u4E00-\u9FA5]+$/
        let xm_judge = xingming.value.length>=2 && reg.test(xingming.value)
        if(xm_judge == false){
            // if(!xm_judge) alert("请输入中文姓名")
            lab1.style.visibility = 'visible'
            lab1.innerHTML = '请输入最小两位中文'
            return false
        }else {
            lab1.innerHTML = '正确'
            if(lab1.innerHTML == "正确"){
                lab1.style.visibility = 'hidden'
            }
        }
    }

    function MyXueH(){
        let xh_judge = xuehao.value.length===8 && Number.isFinite(Number(xuehao.value))
        if (!xh_judge) {
            lab2.style.visibility = 'visible'
            lab2.style.color = 'rgb(190 131 46 / 58%)'
            lab2.innerHTML = '请输入最大8位数的学号'
            return false
        }else{
            lab2.innerHTML = '正确'
            if(lab2.innerHTML == "正确"){
                lab2.style.visibility = 'hidden'
            }
        }
    }
    function MyMiM(){
        // 对密码格式进行判断
        let reg2 = /^[0-9a-zA-Z_]+$/
        let mm_judge = mima.value.length>=6 && mima.value.length<=12 && reg2.test(mima.value)
        if (!mm_judge) {
            lab3.style.visibility = 'visible'
            lab3.style.color = 'rgb(190 131 46 / 58%)'
            lab3.innerHTML = '请输入6-12位数字字母'
            return false
        }else {
            lab3.innerHTML = '正确'
            if(lab3.innerHTML == "正确"){
                lab3.style.visibility = 'hidden'
            }
        }
    }


    var xhr
    var data
    submit.addEventListener('click',function() {
        if(!xingming.value||!xuehao.value||!mima.value){
            alert('缺少信息,请仔细检查')
            return false
        }
        if (lab1.innerHTML == "正确" && lab2.innerHTML == "正确" && lab3.innerHTML == "正确"){

            lab1.innerHTML = ''
            lab2.innerHTML = ''
            lab3.innerHTML = ''

            xhr = new XMLHttpRequest()
            console.log(xingming.value, xuehao.value, mima.value)
            xhr.open('post', 'TeacherRegisterser ', true)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            console.log(xhr)
            xhr.send("xingmingValue=" + xingming.value + "&xuehaoValue=" + xuehao.value + "&mimaValue=" + mima.value);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        data = JSON.parse(xhr.responseText);
                        submit.disabled = true
                        alert("注册成功即将跳转至登录界面")
                        window.location.href = '登录.html'
                    }
                }
            }
        }else {
            xingming.value = ''
            xuehao.value = ''
            mima.value = ''
            alert("登录失败：请检查输入信息是否有误")
            window.location.reload()
        }
    })


</script>
</body>
</html>
