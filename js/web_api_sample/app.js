/* app.js */

APP = (function(){

  var httpRequest = null;

  init = function() {
    if(window.XMLHttpRequest) { // Firefox, Opera など
      httpRequest = new XMLHttpRequest();
      httpRequest.overrideMimeType('text/xml');
    } else if(window.ActiveXObject) { // IE
      try {
        httpRequest = new ActiveXObject('Msxml2.XMLHTTP');
      } catch (e) {
        httpRequest = new ActiveXObject('Microsoft.XMLHTTP');
      }
    }
  }

  WebAPI = function() {
    url = 'http://127.0.0.1:38080/json';
    console.log(url);
    httpRequest.open('GET', url, true);
    httpRequest.onreadystatechange = processResult;
    httpRequest.send(null);
  }

  processResult = function() {
    if (httpRequest.readyState == 4) {
      var status = httpRequest.status;
      if (status == 200 || status == 201) {
        $('#ui_text').val(httpRequest.responseText);
      } else {
        var errStr = httpRequest.statusText + '(' + httpRequest.status + ')';
        alert(errStr);
      }
    }
  }

  return {
    "init": init,
    "WebAPI": WebAPI,
  };
})();

