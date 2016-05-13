/* app.js */

APP = (function(){
  var ui_layer = null;
  var ui_top    = null;
  var ui_bottom = null;
  var ui_right  = null;
  var ui_left   = null;

  init = function() {
    ui_layer = document.getElementById('ui_layer');
    ui_top    = document.getElementById('ui_top');
    ui_bottom = document.getElementById('ui_bottom');
    ui_right  = document.getElementById('ui_right');
    ui_left   = document.getElementById('ui_left');

    update();
  }

  function wrapLon(val) {
    var worlds = Math.floor((val + 180) / 360);
    return val - (worlds * 360);
  }

  update = function() {
    var map = document.getElementById('map');
    if (map.childNodes.length > 0) {
      map.removeChild(map.childNodes[0]);
    }

    var mousePositionControl = new ol.control.MousePosition({
      coordinateFormat: ol.coordinate.createStringXY(4),
      projection: 'EPSG:4326',
      className: 'custom-mouse-position',
      target: document.getElementById('mouse-position'),
      undefinedHTML: '&nbsp;'
    });

    // arguments of ol.layer.Tile()
    var tileArgs = null;
    if (ui_layer.value == 'default') {
      tileArgs = {
        source: new ol.source.OSM()
      };
    } else {
      tileArgs = {
        source: new ol.source.MapQuest({
          // ui_layer.value = { osm | sat | hyb }
          layer: ui_layer.value
        })
      };
    }

    var view = new ol.View({
      center: ol.proj.fromLonLat([139.7724, 35.6193]),
      zoom: 17
    });
    var mapobj = new ol.Map({
      target: 'map',
      controls: ol.control.defaults({
        attributionOptions: ({
          collapsible: false
        })
      }).extend([mousePositionControl]),
      layers: [
        new ol.layer.Tile(tileArgs)
      ],
      view: view
    });

    mapobj.on('moveend', function(evt) {
      var extent = evt.map.getView().calculateExtent(evt.map.getSize());
      var bottomLeft = ol.proj.transform(
                        ol.extent.getBottomLeft(extent),
                        'EPSG:3857', 'EPSG:4326');
      var topRight = ol.proj.transform(
                        ol.extent.getTopRight(extent),
                        'EPSG:3857', 'EPSG:4326');
      ui_top.value    = topRight[1];
      ui_bottom.value = bottomLeft[1];
      ui_right.value  = wrapLon(topRight[0]);
      ui_left.value   = wrapLon(bottomLeft[0]);
    });
  }

  return {
    "init": init,
    "update": update,
  };
})();

