(function($) {
  $(".toggle-footer").click(function(){
    $("html, body").animate({ scrollTop: $(document).height() }, 1000, "swing"); 
    $(".toggle-footer").slideToggle(1000, "swing", function() {
        $(this).toggleClass('hidden');
    });
    $(".footer-pane").slideToggle(1000, "swing", function() {
        $(this).toggleClass('hidden');
    });
  });
})(jQuery);