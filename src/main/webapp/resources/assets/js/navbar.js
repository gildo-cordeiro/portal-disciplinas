$(document).ready(function(){
	 $(".owl-carousel").owlCarousel();
 });
 $(function () {
   $('.dropdown-toggle').dropdown();
 }); 
 
$(window).scroll(function () {
	 if ($(this).scrollTop() > 50) {
	    $('.nav-header').css("transition", "all 2s")
	    $('#button-nav').css("transition", "all 2s")
	    
	    $('.nav-header').css("background-color", "rgba(0,0,0,0.5)")
	    $('#button-nav').css("border", "2px solid #ffffff")
	    $('#button-nav').css("color", "#ffffff")
	 } else {
		 $('.nav-header').css("background-color", "rgba(131,111,255,0.2)")
		 $('#button-nav').css("border", "2px solid #000000")
	     $('#button-nav').css("color", "#000000")
	 }
});