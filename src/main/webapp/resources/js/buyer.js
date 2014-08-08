$( document ).ready(function() {

	$( 'button[id^="buy_"]' ).on( "click", function() {
		var button = $(this);
		var id = button.attr("id").replace(/\D/g,'');
		$.ajax({
				type: "POST",
				url: "/sales/buy/"+id,
				data: { itemId: id}
			}).done(function( item ) {
				alert( "Item bought: " + item.id +"\n"+
						"Seller:" + item.sellerUsername);
				button.parent().html("SOLD");
				button.remove();
			});
	});
});