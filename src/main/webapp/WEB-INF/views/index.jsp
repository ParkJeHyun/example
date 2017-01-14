<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <style>
        #textemail{
            font-size: 15px;
            color : darkgray;
            line-height: 2;
            text-align: left;
        }
        #textbody{
            font-size: 20px;
            color: black;
            font-weight: bold;
            line-height: 2;
            text-align: center;
        }
        #textback{
            background: whitesmoke;
            max-width: 600px;
            left:50%;
            margin: 10px auto 10px auto;
            padding: 40px 40px 40px 40px;
        }
        #password_modal {
            display:none;
            background-color:#FFFFFF;
            position:absolute;
            max-width: 400px;
            max-height: 200px;
            margin: auto;
            padding:10px;
        }

        #modify_modal {
            display:none;
            background-color:#FFFFFF;
            position:absolute;
            max-width: 400px;
            max-height: 200px;
            margin: auto;
            padding:10px;
        }

    </style>
</head>

<body>
<div class="container">
    <form style="max-width: 600px; margin: auto; padding: 50px">
        <input type="email" id="email" class="form-control" name="email" placeholder="Email Address" required="true"><br/>
        <input type="password" id="password" class="form-control" name="password" placeholder="Password" required="true"><br/>
        <textarea id="text" name="text" rows="4" required="true" placeholder="내용" style="width:100%;"></textarea><br/>
        <input type="button" class="btn btn-primary" onclick="add_article()" value="등록" style="margin-top: 15px; width: 40%; float: right">

    </form>
</div>
<div class="container" id="list">
</div>
</body>

<div class="modal fade" id="password_modal">
    <h3>비밀번호를 입력해주세요.</h3>
    <form id="password_form">
        <input type="password" id="input_password" class="form-control" name="input_password" placeholder="Password" required="true"><br/>
        <div class="row" style="padding-right: 15px">
            <button class="btn btn-danger" data-dismiss="modal" style="float: right">취소</button>
            <input type="button" class="btn btn-primary" onclick="change_article()" value="확인" style="float: right; margin-right: 10px">
        </div>
    </form>
</div>

<div class="modal fade" id="modify_modal">
    <h3>변경할 텍스트를 입력해주세요.</h3>
    <form id="text_form">
        <input type="text" id="input_text" class="form-control" name="input_text" placeholder="내용" required="true"><br/>
        <div class="row" style="padding-right: 15px">
            <button class="btn btn-danger" data-dismiss="modal" style="float: right">취소</button>
            <input type="button" class="btn btn-primary" onclick="modify_article()" value="확인" style="float: right; margin-right: 10px">
        </div>
    </form>
</div>

<script src="resources/jquery/jquery-3.1.1.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/article.js"></script>
<script src="resources/js/script.js"></script>
<script>
	show_list("list");
    var password;
    var click_flag;//0->삭제, 1->수정
    var change_id;//변경 혹은 삭제할 Article의 ID
    
    function add_article() {
        var form = $('form').serialize();
        ajax_hanlder('/nhnpre/api/article/add','POST', form, function (responseData) {
            if(responseData == 1){
                alert("등록되었습니다.");
                window.location.href = '/nhnpre';
            }
            else if(responseData == 2){
                alert("Email 형식이 잘못 되었습니다.");
            }
        });
    }

    function get_password(id, flag) {
        //ID에 해당하는 비밀번호 불러와서 password변수에 저장
        click_flag = flag;
        change_id = id;
        ajax_hanlder('/nhnpre/api/article/password/'+id, 'get', function (responseData) {
            	password = responseData;
            	$('#password_modal').modal();
        	});
    }

    function change_article() {
        var input_password = $('#input_password').val();//document.getElementsByTagName("input_password").value;
        if(input_password == password){
            //사용자가 입력한 password가 Database에서 불러온 password와 같을 때
            if(click_flag == 0){
                //삭제
                ajax_hanlder('/nhnpre/api/article/delete/' + change_id, 'delete', function (response) {
                    if(response == 1){
                        alert("삭제가 완료 되었습니다.");
                        window.location.href = '/nhnpre';
                    }
                });
            }
            else {
                //수정
                $('#password_modal').modal('hide');
                $('#modify_modal').modal();
            }
        }
        else {
            alert("비밀번호가 틀렸습니다.");
        }
    }

    function modify_article() {
        var text = $('#input_text').val();
        ajax_hanlder('/nhnpre/api/article/modify/'+change_id, 'put', text, function (response) {
            if(response == 1){
                alert("변경이 완료 되었습니다.");
                window.location.href = '/nhnpre';
            	}
        	});
    }
</script>
</html>
