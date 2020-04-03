$(document).ready(function() {
    $("input").blur(function(){
     if($(this).val() == "")
         {
             $(this).css({"border" : "1px solid #F00", "padding": "2px"});
         }
    });
    $("#formCadastro").submit(function() {
    	$("#formCadastro input").each(function(){
    		if($(this).val() == "") {
                 $(this).css({"border" : "1px solid #F00", "padding": "2px"});
                 return false;
             }
        });
    	if($("#senha").val() == "" || $("#confirmSenha").val() == ""){
    		alert("O(s) campo(s) da(s) senha(s) não pode(m) estar vazio(s)");
    		return false;
    	}else if($("#senha").val() !== $("#confirmSenha").val()){
    		alert( $("#senha").val(), $("confirmSenha").val);
    		return false;
    	}

    	return true;
    	
    	
    });
})
	
