$( document ).ready(function() {
	 $(function() {
		 $( "#datepicker" ).datepicker( {dateFormat: 'yy-mm-dd'} );
	 });
	 
	 
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
					alert( "Sale Id: " + item.id +"\n"+
							"Seller: " + item.sellerUsername);
					var budget = parseInt($("#budget").html());
					var itemPrice = parseInt(button.closest('tr').find(".item_price").html());
					button.parent().html("SOLD");
					button.remove();
					$("#add_to_cart_"+id).parent().html("SOLD");
					$("#add_to_cart_"+id).remove();
					$("#budget").html(budget-itemPrice);
				}
			});
	});
	
	$( 'button[id^="edit_"]' ).on( "click", function() {
		var button = $(this);
		var id = button.attr("id").replace(/\D/g,'');
		
		window.location.href = "/sales/edit/"+id;
	});
	
	$( 'button[id^="delete_"]' ).on( "click", function() {
		var button = $(this);
		var id = button.attr("id").replace(/\D/g,'');
		
		$.ajax({
			type: "POST",
			url: "/sales/delete/"+id,
			data: { itemId: id}
		}).done(function( item ) {
			if(item.status == "OK"){
				alert("Delete successfull");
				button.parent().parent().remove();
			}else{
				alert("Delete unsuccessfull");
			}
		});
	});
	
	   $(function() {
	        $.getJSON('/home/chart', function(json) {
	        	  $('#container').highcharts({
	        		  chart: {
	        	            plotBackgroundColor: null,
	        	            plotBorderWidth: 1,//null,
	        	            plotShadow: false
	        	        },
	        	        title: {
	        	            text: 'Sales and Items'
	        	        },
	        	        tooltip: {
	        	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        	        },
	        	        plotOptions: {
	        	            pie: {
	        	                allowPointSelect: true,
	        	                cursor: 'pointer',
	        	                dataLabels: {
	        	                    enabled: true,
	        	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	        	                    style: {
	        	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	        	                    }
	        	                }
	        	            }
	        	        },
	        	        series:[json]
	        	    });
	         }).done(function(json) {
	         })
	         .fail(function( jqxhr, textStatus, error ) {
	        	 	var err = textStatus + ", " + error;
	        	 	console.log( "Request Failed: " + err );
	         });

	     });
});