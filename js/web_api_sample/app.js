/* app.js */

APP = (function(){

  httpRequest = null;

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
    httpRequest.open('GET', 'http://localhost:38080/', true);
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

