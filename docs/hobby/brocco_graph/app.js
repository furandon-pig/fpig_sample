var vm = new Vue({
  el: '#app',
  data: {
    size_countup: true,
    raw_text: '',
    graph_text: '',
    svg_text: '',
    waiting: false,
    rendering: false
  },
  mounted: function() {
    var str = 'ブロっ子 ブロっ子 ブロッコリー♪ （ブロっ子！） ブロっ子 ブロっ子 ブロッコリー♪\n';
    str += 'ブロっ子 ブロっ子 ブロッコリー♪ （ブロっ子！） ブロっ子 ブロっ子 ブロッコリー♪\n';

    this.raw_text = str;
    setTimeout(function() {
      vm.update(true);
    }, 200);
  },
  methods: {
    update: function(force) {
      if (force !== true && (this.rendering == true || this.waiting == false)) {
        this.waiting = true;
        return;
      }
      this.rendering = true;

      var str = this.raw_text.replace(/\"/g, '&quot;');
      var w1 = str.replace(/\n/g, ' ').replace(/　/g, ' ').replace(/\s*?/g, '').split(' ').filter(c => c != '');
      var w2 = str.replace(/\n/g, ' ').replace(/　/g, ' ').replace(/\s*?/g, '').split(' ').filter(c => c != '');
      w2.push('');

      var words = [];
      for (var w in w1) {
        words.push({
          word: w2[w],
          word_next: w2[(w|0)+1]
        });
      }

      var dict = [];
      var index = 1;
      for (var w of words) {
        var d = dict.find((d) => d.word == w.word);
        if (d === undefined) {
          dict.push({
            id: `a${index++}`,
            word: w.word,
            word_next: w.word_next,
            count: 10
          });
        } else {
          if (this.size_countup == true) {
            d.count += 2;
          }
        }
      }

      var graph = 'digraph G {\n';
      for (var d of dict) {
        if (d.word === '') { continue; }
        graph += `  ${d.id} [ label="${d.word}", fontsize = ${d.count} ];\n`
      }
      graph += '\n';

      relations = [];
      for (var w of words) {
        if (w.word_next === '') { continue; }
        var d1 = dict.find((d) => d.word == w.word);
        var d2 = dict.find((d) => d.word == w.word_next);
        if (d1 !== undefined || d2 !== undefined) {
          str = `  ${d1.id} -> ${d2.id};\n`;
          if (relations.find((r) => r === str) === undefined) {
            relations.push(str);
          }
        }
      }
      for (r of relations) {
        graph += r;
      }
      graph += '}\n'

      this.graph_text = graph;
      this.render();
    },
    render: function() {
      const workerURL = 'full.render.js';
      let viz = new Viz({ workerURL });

      viz.renderSVGElement(this.graph_text)
      .then(function(element) {
        var elm = document.getElementById('graph');
        if (elm.childNodes[0] !== undefined) {
          elm.childNodes[0].remove();
        }
        elm.appendChild(element);

        var svg = '<?xml version="1.0" encoding="UTF-8" standalone="no"?>\n';
        svg += document.getElementById('graph').innerHTML;
        vm.svg_text = svg;

        vm.rendering = false;
        if (vm.waiting === true) {
          vm.waiting = false;
          vm.update();
        }
      })
      .catch(error => {
        viz = new Viz({ workerURL });
        console.error(error);
      });
    }
  }
})

