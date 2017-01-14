document.write("<script src='resources/js/script.js'></script>");

function json_to_view(json){
	var doc = "";
	
	var id = json.id;
	var email = json.email;
	var id = json.id;
	var text = json.text;
	var add_time = json.add_time;
	var modify_time = json.modify_time;
	
	doc += '<div class="container">';
	doc += '<div id="textback">';
	doc += '<div class="row">';
	doc += '<div class="name-tag">';
	doc += '<div class="col-md-8">';
	doc += '<p id="textemail">' + email +'</p>';
	doc += '</div>';
	doc += '<div class="col-md-4">';
	doc += '<button class="btn btn-danger" style="float: right;" onclick="get_password(' + id +', 0)">삭제</button>';
	doc += '<button class="btn btn-warning" style="float: right; margin-right: 5px" onclick="get_password(' + id + ', 1)">수정</button>';
	doc += '</div>';
	doc += '</div>';
	doc += '<div style="text-align: right">';
	doc += '등록 시각 : ' + add_time + '';
	doc += '</div>';
	if(modify_time){
		doc += '<div style="text-align: right">';
		doc += '수정 시각 : ' + modify_time + '';
		doc += '</div>';
	}
	
	doc += '<div class="row">';
	doc += '<p id="textbody">' + text + '</p>';
	doc += '</div>';
	doc += '</div>';
	doc += '</div>';
		
	return doc;
}

function make_view(template, data){
	$("#" + template).append(json_to_view(data));
}

function show_list(template){
	ajax_hanlder('/nhnpre/api/article/list', 'get', function (responseData) {
		for(idx in responseData){
			make_view(template, responseData[idx]);
		}
	});
}