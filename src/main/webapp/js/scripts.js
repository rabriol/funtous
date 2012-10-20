$(document).ready(function(){
    //scrollDiv();
    loadMore();
});

function refreshPosts() {
	setInterval(function(){
		$("#posts").fadeOut("Slow").load("/funtous/main/home.xhtml").fadeIn("Slow");
	}, 5000);
}

function scrollDiv() {
	$('#containerrodape').scrollToFixed({
    	bottom:0
    });
}

function loadMore() {
	$(window).scroll(function(){
		if ($(window).scrollTop() == $(document).height() - $(window).height()) {
			$('div#loadmore').show();
			$.ajax({
				url: "/funtous/posts.xhtml",
				success: function(html) {
					if (html) {
						$("#posts").append(html);
						$('div#loadmore').hide();
					} else {
						$('div#loadmore').html('<center>Não existem mais posts</center>');
					}
				}
			})
		}
	});
}