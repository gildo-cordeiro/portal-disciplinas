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
	    $('.item').css("transition", "all 2s")
	    
	    $('.nav-header').css("background-color", "rgba(0,0,0,0.5)")	
	    $('.item').css("color", "#ffffff")  
	    $('#button-nav').css("border", "2px solid #ffffff")
	    $('#button-nav').css("color", "#ffffff")
	 } else {
		 $('.item').css("color", "#000000")  
		 $('.nav-header').css("background-color", "rgba(255,255,255,0.9)")
		 $('#button-nav').css("border", "2px solid #000000")
	     $('#button-nav').css("color", "#000000")
	 }
});