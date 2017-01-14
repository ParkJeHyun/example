function ajax_hanlder(url, type, data, success) {
	if($.isFunction(data)){
		success = data;
		data = null;
	}
	$.ajax({
		url: url,
		type: type,
		dataType: 'json',
		data: data,
		success: function (responseData) {
			if ($.isFunction(success)){
				success(responseData);
			}
			else {
				window.location.href = success;
			}
		},
		error: function (request, status, error) {
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
	});
}