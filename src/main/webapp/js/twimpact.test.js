(function($) {
  var API_URL = document.location.protocol + "//" + document.location.host + document.location.pathname.replace("/test", "") + "1";

  var app = $.sammy('#application', function() {
    var TRACKID = null;

    this.get("#!/stream/:id", function(context) {
      if (this.params.id != TRACKID) {
        $.twire.unsubscribe();
      }

      TRACKID = this.params.id;

      $.twire.subscribe(API_URL + "/trend/" + TRACKID, null, [], function(event) {
        if(event.twmsg != "status") {
          $("#stream").append("<li>" + event.text + "</li>");
        }
      });
    });
  });

  $(function() {
    app.run("#!/stream/test");
  });
})(jQuery);