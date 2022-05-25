<%--
  Created by IntelliJ IDEA.
  User: kj
  Date: 2022/5/11
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="tools/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="tools/jquery.min.js"></script>
    <script src="tools/bootstrap.min.js"></script>
    <style>
        .btn-suc{
            font-size: 20px;
            font-weight: 400;
            color: rgb(92,184,92)
        }
        .btn-dan{
            font-size: 20px;
            font-weight: 400;
            color: red
        }
    </style>
</head>
<body>
<div class="container">
    <table class="row table table-hover">
        <thead>
        <tr class="headTh">
            <th class="col-md-1 text-center">班级名称</th>
            <th class="col-md-1 text-center">学号</th>
            <th class="col-md-1 text-center">姓名</th>
            <th class="col-md-1 text-center">联系电话</th>
            <th class="col-md-1 text-center">请假日期</th>
            <th class="col-md-1 text-center">请假天数</th>
            <th class="col-md-1 text-center">情况说明</th>
            <th class="col-md-2 text-center">操作</th>
            <th class="col-md-1 text-center">状态</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<script>
    function Ajax() {
        xhr = new XMLHttpRequest()
        xhr.open('post', 'RequestItemsView', true)
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
    }


    var oTr
    // xhr.send()
    Ajax()
    xhr.send()
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                // console.log(xhr.responseText)
                var data =  JSON.parse(xhr.responseText)
                console.log(data);
                for (let i = 0; i < data.length; i++) {
                    oTr = document.createElement("tr")
                    var oTd = document.createElement("td")
                    var oTd1 = document.createElement("td")
                    var oTd2 = document.createElement("td")
                    var oTd3 = document.createElement("td")
                    var oTd4 = document.createElement("td")
                    var oTd5 = document.createElement("td")
                    var oTd6 = document.createElement("td")
                    var oTd7 = document.createElement("td")
                    var oTd8 = document.createElement("td")

                    oTd.innerText = data[i].classes
                    oTd1.innerText = data[i].userNum
                    oTd2.innerText = data[i].name
                    oTd3.innerText = data[i].phoneNum
                    oTd4.innerText = data[i].severalDays
                    oTd5.innerText = data[i].days
                    oTd6.innerText = data[i].cause

                    oTd7.innerHTML = "<button class='button_left btn btn-success'  style='margin-right: 15px;'>同意</button>" + "<button class='btn btn-danger'>拒绝</button>"
                    if (data[i].isconsent == false && data[i].isconsent2 == false){
                        oTd8.innerHTML = '拒绝'
                    }else if (data[i].isconsent == true && data[i].isconsent2 == true){
                        oTd8.innerHTML = '已同意'
                    }else if(data[i].isconsent == false && data[i].isconsent2 == true){
                        oTd8.innerHTML = '未操作'
                    }else if(data[i].isconsent == true && data[i].isconsent2 == false){
                        oTd8.innerHTML='已销假'
                    }

                    oTr.appendChild(oTd);
                    oTr.appendChild(oTd1);
                    oTr.appendChild(oTd2);
                    oTr.appendChild(oTd3);
                    oTr.appendChild(oTd4)
                    oTr.appendChild(oTd5)
                    oTr.appendChild(oTd6)
                    oTr.appendChild(oTd7)
                    oTr.appendChild(oTd8)




                    // 获取 tbody
                    var tbody = document.querySelector('tbody')
                    // 将创建的 tr 插入到 tbody 里面
                    tbody.appendChild(oTr)
                    // 设置 tr 的 class 值
                    oTr.className = "text-center"
                    // 设置 tr 的 id 值
                    oTr.id = "rem"
                    // 设置状态栏的 id
                    oTd8.id = "zhuangtai"
                    // 获取所有年龄
                    oTd1.id = 'oTd1s'
                }
                // 获取所有 tr
                var oTrs = document.querySelectorAll('#rem')
                console.log(oTrs);
                // 获取所有 button
                let btn = document.querySelectorAll('button')
                // 获取所有 age 节点
                var oTd1s = document.querySelectorAll('#oTd1s')
                console.log(oTd1s);


                // 获取所有状态选项
                var zhuangtai = document.querySelectorAll('#zhuangtai')
                console.log(zhuangtai);
                // console.log(zhuangtai);
                // for (let z = 0; z < zhuangtai.length; z++) {
                //     console.log(zhuangtai[z]);
                // }


                // for (let z = 0; z < zhuangtai.length; z++) {
                //     zhuangtai[z].innerText = "同意"
                //     console.log(zhuangtai[z]);
                // }


                // 获取成功按钮 和 失败按钮
                var btn_success = document.querySelectorAll('.btn-success')
                console.log(btn_success);
                var btn_danger = document.querySelectorAll('.btn-danger')
                console.log(btn_danger);


                // 点击同意按钮 同意
                var isZhuangTai
                for (let k = 0; k < btn_success.length; k++) {
                    btn_success[k].addEventListener('click',function(){
                        zhuangtai[k].className = 'btn-suc'
                        zhuangtai[k].innerText = "同意";
                        var ids=data[k].id
                        isZhuangTai = true
                        console.log(zhuangtai[k]);
                        let userNums = oTd1s[k].innerHTML
                        console.log(userNums)
                        Ajax()
                        xhr.send('isZhuangTai=' + true + '&userNum=' + userNums + '&ids=' + ids)
                        console.log('----------------')

                        })
                    }
                }

                // 点击拒绝按钮 拒绝
            for (let k = 0; k < btn_danger.length; k++) {
                btn_danger[k].addEventListener('click',function(){
                    zhuangtai[k].className = 'btn-dan'
                    zhuangtai[k].innerHTML = "拒绝"
                    isZhuangTai = false
                    var ids=data[k].id
                    console.log(zhuangtai[k]);
                    let userNums = oTd1s[k].innerHTML
                    console.log(userNums)

                    Ajax()
                    xhr.send("isZhuangTai=" + false + "&userNum=" + userNums + '&ids=' + ids);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4) {
                            if (xhr.status == 200) {
                            }
                        }
                    }
                })
            }
        }



                // // 循环 tr
                // for (let i = 0; i < oTrs.length; i++) {
                //     console.log(oTrs[i]);
                //     // 循环 tr 中的 button 按钮
                //     for (let j = 0; j < btn.length; j++) {
                //         // 点击 button 删除 tr 节点
                //         btn[i].onclick = function(){
                //             console.log(oTrs[i]);
                //             tbody.removeChild(oTrs[i])
                //         }
                //     }
                // }
    }

</script>
</body>

</html>
