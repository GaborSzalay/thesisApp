var dynatableSearchInput = $("#dynatable-query-search-my-table");
dynatableSearchInput.addClass("form-control");

var dynatablePageDropDown = $("#dynatable-per-page-my-table");
dynatablePageDropDown.addClass("form-control");

var clickedButtons = $(".btn-default.clicked");
clickedButtons.click();

$(document).ready(function() {

	$('.simple-ajax-popup-align-top').magnificPopup({
		type: 'ajax',
		alignTop: true,
		overflowY: 'scroll' // as we know that popup content is tall we set scroll overflow by default to avoid jump
	});

});
