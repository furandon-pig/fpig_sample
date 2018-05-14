var vm = new Vue({
  el: '#app',
  data: {
    parkings: [],
    url: 'http://valapis.jp/v1/bicycle_parkings.json'
  },
  methods: {
    load_data: function() {
      axios.get(this.url)
      .then(result => this.parkings = result.data.result_set.data_set.bicycle_parkings)
      .catch(error => {
          console.log('fail');
      })
    }
  }
})
