var vm = new Vue({
  el: '#app',
  data: {
    mymap: undefined,
    message: 'Hello Vue!',
    check1: false, 
    check2: false,
    check3: false,
    radio1: 'aaa',
    select1: 'bbb',
  },
  mounted: function() {
    this.mymap = L.map('map').setView([35.6800328,139.7692996], 13);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
      maxZoom: 18,
      attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
                   '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                   'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
      id: 'mapbox.streets'
    }).addTo(this.mymap);
  },
  methods: {
    closeDialog: function() {
      $('#modal1').modal('hide');
    }
  }
})

