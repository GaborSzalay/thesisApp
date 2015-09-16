$('#my-table').dynatable({
  table: {
    defaultColumnIdStyle: 'trimDash'
  }
});

$(document).ready(function() {
	$('.inline-popup').magnificPopup({
		type: 'inline',
		preloader: false,
		focus: '#name',

		// When elemened is focused, some mobile browsers in some cases zoom in
		// It looks not nice, so we disable it:
		callbacks: {
			beforeOpen: function() {
				if($(window).width() < 700) {
					this.st.focus = false;
				} else {
					this.st.focus = '#name';
				}
			}
		}
	});
});

$('#my-table').on("dynatable:afterUpdate",
  function(){
    $('.thesis-popup').magnificPopup({
        type: 'ajax',
        alignTop: true,
        overflowY: 'scroll' // as we know that popup content is tall we set scroll overflow by default to avoid jump
    });
  }
);

