$(document).ready(function(){
	 $(".owl-carousel").owlCarousel();
	 
	//identificar o click 
	 $('.navbar a[href^="#"]').on('click', function(e){
	     //Evita a função padrao da ancora interna
	     e.preventDefault();
	     //pegar o item que o usuario clicou (attr -> pega o atributo)
	     var id = $(this).attr('href'),
	     // pega a distancia entre o elemento e o topo (targetOffset). offset(função do JQuery) -> retorna o top e o left do elemento
	     targetOffset = $(id).offset().top;
	     
	     //pega o tamnho do menu (innerHeight() -> é uma função do JQuery)
	     menuHight  = $('.navbar').innerHeight();

	     // animação (animate -> funçao do JQuery)
	     $('html, body').animate({
	         //anima o scroll do top e dimninui do tamanho do menu
	         scrollTop: targetOffset - menuHight

	         //500 é o tempo de transiçção em milisegundos
	     }, 500);
	 });
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