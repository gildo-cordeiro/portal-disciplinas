$(document).ready(function() {
	$(".change-on-click").click(function() {
		var $elemento=$("div>li");
		
		$elemento.removeClass("bg-danger text-light");
		//$elemento=$pai.find();
		$(this).addClass("bg-danger text-light");
	});
});