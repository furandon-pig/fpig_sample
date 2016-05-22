/* app.js */

APP = (function(){
  var isDialogShow = false;
  var dialog = null;

  init = function() {
    isDialogShow = false;
    dialog = document.getElementById("dialog1");
  }

  toggleShowState = function() {
    isDialogShow = !isDialogShow;
  };  

  jsDialog = function() {
    if (isDialogShow == false) {
      dialog.style.visibility = "visible";
    } else {
      dialog.style.visibility = "hidden";
    } 
    toggleShowState();
  };  

  closeDialog = function() {
    dialog.style.visibility = "hidden";
    toggleShowState();
  };

  closeByOK = function() {
    closeDialog();
  };

  closeByCancel = function() {
    closeDialog();
  };

  return {
    "init": init,
    "jsDialog": jsDialog,
    'closeByOK'    : closeByOK,
    'closeByCancel': closeByCancel,
  };
})();

