/* app.js */

APP = (function(){
  var timeout_id = null;
  var msg = " The quick brown fox jumps over the lazy dog.";
  var msg_len = msg.length;
  var idx = 0;

  var ui_check1  = null;
  var ui_select1 = null;
  var ui_label1  = null;

  init = function() {
    ui_check1  = document.getElementById('ui_check1');
    ui_select1 = document.getElementById('ui_select1');
    ui_label1  = document.getElementById('ui_label1');

    ui_check1.checked = true;

    console.log('Enable setTimeout: ' + ui_check1.checked);
    console.log('Interval: ' + ui_select1.value);

    set_timer_event();
  }

  set_timer_event = function() {
    timeout_id = window.setTimeout(
      function() {
        if (ui_check1.checked == false) {
          set_timer_event();
          return;
        }

        idx = idx % msg_len + 1;

        var front = msg.substr(idx, msg_len - idx);
        var rear  = msg.substr(0, idx);

        ui_label1.innerText = front + rear;

        set_timer_event();
      },
      ui_select1.value
    );
  }

  return {
    "init": init,
    "set_timer_event": set_timer_event,
  };
})();

