/* app.js */

APP = (function(){
  var lists = document.getElementsByName('radio_lists');

  init = function() {
    lists[0].checked = true;
    choice();
  }
  choice = function() {
    for (var i in lists) {
      if (lists[i].checked == true) {
        document.getElementById('item').innerText = lists[i].value;
        return;
      }
    }
  }
  return {
    "init": init,
    "choice": choice,
  };
})();

