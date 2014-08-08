$( document ).ready(function() {

	$( 'button[id^="buy_"]' ).on( "click", function() {
		var button = $(this);
		var id = button.attr("id").replace(/\D/g,'');
		$.ajax({
				type: "POST",
				url: "/sales/buy/"+id,
				data: { itemId: id}
			}).done(function( item ) {
				if(item.status !== undefined){
					alert("You don't have enough money to buy it!");
				}else{
					alert( "Item bought: " + item.id +"\n"+
							"Seller:" + item.sellerUsername);
					var budget = parseInt($("#budget").html());
					var itemPrice = parseInt(button.closest('tr').find(".item_price").html());
					button.parent().html("SOLD");
					button.remove();
					
					$("#budget").html(budget-itemPrice);
					alert(newBudget);
				}
			});
	});
});