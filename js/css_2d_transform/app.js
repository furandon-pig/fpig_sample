/* app.js */

APP = (function(){
  var ui_range;
  var ui_angle;
  var rotate_sample;

  init = function() {
    ui_range = document.getElementById('ui_range');
    ui_angle = document.getElementById('ui_angle');
    rotate_sample = document.getElementById('rotate_sample');
    update_angle(0);
  }

  update = function() {
    ui_angle.innerText = ui_range.value;
    update_angle(ui_range.value);
  }

  update_angle = function(angle) {
    rotate_sample.style.transform = 'rotate(' + angle + 'deg)';
  }

  return {
    "init": init,
    "update": update,
  };
})();

