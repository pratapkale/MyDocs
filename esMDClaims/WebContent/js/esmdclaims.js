function go(url){
	window.location = url;
}
function doAjax(pageName, pageNo, url, divId) {
	$.ajax({
	  url: url,
	  data: ({page : pageName, pageNumber: pageNo}),
	  success: function(data) {
		  if(data.trim() == 'login'){
			  go('loginAdmin.do');   
		 } else {
			$('#'+divId).html(data);
		 }
	  }
	});
}
