APP = (function(){
  var xhr = new XMLHttpRequest();

  preview = function() {
    var md = encodeURIComponent(document.getElementById('md').value);
    var url = 'http://localhost:4567/preview';

    xhr.open("POST", url, true);
    xhr.onload = function (e) {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          json = JSON.parse(xhr.responseText);
          document.getElementById('preview_html').innerHTML = decodeURIComponent(json.res);
        } else {
          console.error(xhr.statusText);
        }
      }
    }

    xhr.onerror = function (e) {
      console.error(xhr.statusText);
    };

    xhr.send(md);
  }

  return {
    "preview": preview,
  }
})();
