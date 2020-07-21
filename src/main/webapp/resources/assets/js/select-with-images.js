$(document).ready(function() {

	var sels = $(".fake-sel");

	var imgs_ = [ [
			'/resources/imagens/disicplinas/cardbrandS.jpg',
			'/resources/imagens/disicplinas/ciencia.jpg'] ];

	sels.each(function(x) {

		var $t = $(this);

		var opts_ = '', first;

		$t.find("option").each(
				function(i) {

					if (i == 0) {
						first = "<li><img th:src='@{" + imgs_[x][i] + "}'>"
								+ $(this).text() + "</li>";
					}
					opts_ += "<li" + (i == 0 ? " class='ativo'" : '')
							+ "><img th:src='@{" + imgs_[x][i] + "}'>"
							+ $(this).text() + "</li>";
				});

		$t.wrap("<div class='fake-sel-wrap'></div>").parent().css("width",
				$t.outerWidth() + 60).append("<ul>" + first + opts_ + "</ul>")
				.find("ul").on("click", function(e) {
					e.stopPropagation();
					$(".fake-sel-wrap ul").not(this).removeClass("ativo");
					$(this).toggleClass("ativo");
				}).find("li:not(:first)").on(
						"click",
						function() {
							$(this).addClass("ativo").siblings().removeClass(
									"ativo").parent().find("li:first").html(
									$(this).html());

							$t.val($(this).text());

						});
	});

	$(document).on("click", function() {
		$(".fake-sel-wrap ul").removeClass("ativo");
	});

});