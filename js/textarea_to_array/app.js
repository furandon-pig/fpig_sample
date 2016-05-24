/* app.js */

APP = (function(){
  var ui_text = null;
  var ui_result = null;

  init = function() {
    ui_text = document.getElementById('ui_text');
    ui_result = document.getElementById('ui_result');
  }

  convert = function() {
    var buf = ui_text.value + "\n";
    var lines = new Array();

    line_count = 0;
    while (buf.match(/^(.*?)[\r\n]/) != null) {
      lines.push({
        lineNo: ++line_count,
        text: RegExp.$1
      });
      buf = buf.replace(/^(.*?)[\r\n]/, "");
    }

    var html = '<table border="1">';
    html += '<tr><th>行番号</th><th>テキスト</th></tr>';
    for (var i in lines) {
      html += '<tr><td>' + lines[i].lineNo + '</td><td>' + lines[i].text + '</td></tr>';
    }
    html += '</table>';

    ui_result.innerHTML = html;
  }

  return {
    "init": init,
    "convert": convert,
  };
})();

