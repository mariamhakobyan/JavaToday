/**********************************************************
 *
 * Copyright by JavaToday.com
 *
 *********************************************************/

window.addEvent('domready', function(){
	$$(".pagination li a").addEvent("click", function(e){
		e.stop();

		var contentHeight = $("content").getHeight().toInt() - 20;
		$("loader").setStyles({
			display: 'block',
			height: contentHeight
		});
		
		var link = "articles.php" + "?page=" + this.get("data-page").toInt();
		new Request({
			url: link,
			method: 'get',
			onRequest: function(){
				$("loader").set('text', 'loading...');
			},
			onSuccess: function(responseText){
				$("articles").set('html', responseText);
				$("loader").erase('style');
			},
			onFailure: function(){
				$("loader").set('text', 'Sorry, your request failed.');
			}
		}).send();
	});
});