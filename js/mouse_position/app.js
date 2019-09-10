APP=(() => {
  return {
    'init': () => {
      var p = document.getElementById('p01');
      p.style.position = 'absolute';

      document.body.addEventListener("mousemove", (e) => {
        var p = document.getElementById('p01');

        p.innerText = `x,y= ${e.pageX},${e.pageY}\n`;

        p.style.left = `${e.pageX}px`;
        p.style.top  = `${e.pageY}px`;
      });
    }
  };
})().init();

