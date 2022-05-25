<%--
  Created by IntelliJ IDEA.
  User: kj
  Date: 2022/5/13
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<%--    <link rel="stylesheet" href="../bootstrap-5.1.3-dist/css/bootstrap.min.css">--%>
<%--    <script src="../jquery-3.6.0.min.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%--    <script src="../bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>


<%--    <link href="tools/bootstrap.min.css" rel="stylesheet" />--%>
<%--    <script type="text/javascript" src="tools/jquery.min.js"></script>--%>
<%--    <script src="tools/bootstrap.min.js"></script>--%>
</head>
<body style="height: 100vh; ">
<div class="container" style="padding-top: 150px;">
    <div class="row">
        <div class="col-md-6 offset-3 text-center" style="font-size: 30px; font-weight: 300; margin-top: 20px; margin-bottom: 20px;">
            登录
        </div>
        <div class="col-md-4 offset-4" style="margin-bottom: 40px;">
            <button id="student" class="col-md-5 btn" style="margin-right: 30px; border: solid 1px; background-color: #ccc;">学生登录</button>
            <button id="teacher" class="col-md-5 btn" style="border: solid 1px;">教师登录</button>
        </div>
        <div class="col-md-6 offset-3">
            <div class="row form-group col-md-12">
                <div class="col-md-8 offset-md-2">
                    <input autocomplete=off onkeyup="MyXueH()" id="xuehao" type="number" class="form-control" style="border-radius: 50px;" placeholder="学号：(请输入8位数字)">
                    <label id="lab2" class="form-label" style="visibility: hidden; color: red">请重新输入正确的学号</label>
                </div>
            </div>
            <div class="row form-group col-md-12" style="margin-bottom: 20px;">
                <div class="col-md-8 offset-md-2">
                    <input autocomplete=off onkeyup="MyMiM()" id="mima" type="password" onkeyup="this.value=this.value.replace(/[^\w]/g,'')" class="form-control" style="border-radius: 50px;" placeholder="密码：(请输入数字字母)">
                    <label id="lab3" class="form-label" style="visibility: hidden; color: red">请重新输入正确的密码</label>
                </div>
            </div>

        </div>
        <div class="row col-md-12 text-center">
            <button id="submit" class="btn col-md-2 offset-md-5 text-center" style="border-radius: 50px; border: solid 1px;">立即登录</button>
            <a id="as" href="register.jsp" class="col-md-3 offset-md-1" style="position: relative; bottom: -10px">立即注册 (教师注册请联系管理员)</a>
        </div>
    </div>
</div>

<script>
    var xhr
    function Ajax(){
        xhr = new XMLHttpRequest()
        xhr.open('post', 'loginServlets', true)
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    }
    Ajax()


    // 获取提交按钮
    var submit = document.querySelector('#submit')
    // 获取学号框
    var xuehao = document.querySelector('#xuehao')
    // 获取密码框
    var mima = document.querySelector('#mima')
    var as = document.querySelector('#as')

    // 判断是学生登录还是教师登录
    var name = 1

    var stuBtn = document.querySelector('#student')
    var teaBtn = document.querySelector('#teacher')

    stuBtn.addEventListener('click',function(){
        name = 1
        console.log(name);
        teaBtn.style.backgroundColor = ''
        stuBtn.style.backgroundColor = '#CCCCCC'
        console.log("学生按钮被点击");
    })
    teaBtn.addEventListener('click',function(){
        name = 2
        console.log(name);
        stuBtn.style.backgroundColor = ''
        teaBtn.style.backgroundColor = '#CCCCCC'
        console.log("教师按钮被点击");
        // //教师登录发送后台验证账号密码
        // submit.addEventListener('click',function (){
        //     Ajax()
        //     xhr.send('name' + name.toString() + '&xuehao' + xuehao.value + '&mima' + mima.value)
        //     console.log(name)
        // })
    })
    // if (name == 2){
    //
    // }


    var lab2 = document.querySelector('#lab2')
    var lab3 = document.querySelector('#lab3')


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
        let mm_judge = mima.value.length<=12 && reg2.test(mima.value)
        if (!mm_judge) {
            lab3.style.visibility = 'visible'
            lab3.innerHTML = '密码请不要超过12位'
            return false
        }else {
            lab3.innerHTML = '正确'
            if(lab3.innerHTML == "正确"){
                lab3.style.visibility = 'hidden'
            }
        }
    }


    var data
    // if (name == 1) {
        submit.addEventListener('click', function () {
            if (!xuehao.value || !mima.value) {
                alert('缺少信息,请仔细检查')
                return false
            }
            if (name == 1){
                console.log('学生登录')
                if (lab2.innerHTML == "正确" && lab3.innerHTML == "正确") {
                    lab2.innerHTML = ''
                    lab3.innerHTML = ''

                    Ajax()
                    console.log(xhr)
                    xhr.send('name=' + name.toString() + "&xuehaoValue=" + xuehao.value.toString() + "&mimaValue=" + mima.value.toString());
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4) {
                            if (xhr.status == 200) {
                                var dataText = JSON.parse(xhr.responseText)
                                var dataurl = xhr.responseURL
                                // var dataurl = xhr.responseURL
                                console.log(xhr.responseURL)
                                if (dataText.error == 1) {
                                    mima.value = ''
                                    alert("账号与密码不匹配，请重新数入")
                                } else {
                                    submit.innerHTML = '正在登录请勿重复点击'
                                    submit.disabled = true
                                    window.location.href = 'qingjia.jsp'
                                }
                            }
                        }
                    }
                } else {
                    xuehao.value = ''
                    mima.value = ''
                    alert("登录失败：请检查输入信息是否有误")
                    window.location.reload()
                }
            }if (name == 2){
                Ajax()
                xhr.send('name=' + name.toString() + "&xuehaoValue=" + xuehao.value.toString() + "&mimaValue=" + mima.value.toString());
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            var data2 = JSON.parse(xhr.responseText)
                            console.log(data2)
                            if (data2.error == 1) {
                                mima.value = ''
                                alert("账号与密码不匹配，请重新数入")
                            } else {
                                console.log(xhr.responseURL)
                                window.location.href = 'RequestItemsView.jsp'
                            }
                        }
                    }
                }
            }
        })


    // }if (name == 2){
        // submit.addEventListener('click',function (){
        //     console.log('老师登录')
            // Ajax()
            // xhr.send('name' + name.toString() + '&xuehao' + xuehao.value + '&mima' + mima.value)
            // xhr.onreadystatechange = function () {
            //     if (xhr.readyState == 4) {
            //         if (xhr.status == 200) {
            //             window.location.href = 'RequestItemsView.jsp'
            //         }
            //     }
            // }
        // })
    // }

</script>
</body>
</html>
