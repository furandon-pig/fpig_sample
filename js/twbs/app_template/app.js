/* app.js */

APP = (function(){

  init = function() {
    $('#ui_text').val('hello,world.');
    $(function() {
      $('#modal1').on('show.bs.modal', function(event) {
        $('#ui_dlg1_text').val($('#ui_text').val());
      });
    });
  }

  close_dialog = function() {
    $('#ui_text').val($('#ui_dlg1_text').val());
    $('#modal1').modal('hide');
  }

  return {
    "init": init,
    "close_dialog": close_dialog,
  };
})();

