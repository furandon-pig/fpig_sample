/* app.js */

APP = (function(){
  var APP_KEY = "fpig_localstorage_sample";
  var text = "hello,world.";

  var ui_text = null;

  init = function() {
    ui_text = document.getElementById('ui_text');
    loadData();
    ui_text.value = text;
  }

  loadData = function() {
    var json_str = localStorage.getItem(APP_KEY);
    if (json_str != null) {
      try {
        text = JSON.parse(json_str);
      } catch (e) {
        console.log('JSON parse error.');
      }
    }
  }

  saveData = function() {
    localStorage.setItem(APP_KEY, JSON.stringify(ui_text.value));
  }

  clearData = function() {
    localStorage.removeItem(APP_KEY);
  }

  return {
    "init": init,
    "saveData": saveData,
    "clearData": clearData,
  };
})();

