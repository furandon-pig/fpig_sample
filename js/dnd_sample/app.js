/* app.js */

APP = (function(){
  init = function() {
  }

  start = function() {
    var transObj = {};
    var ui_item = document.getElementById('ui_item');

    // dnd対象のIDとdnd後にdnd元の要素を削除するため、
    // dnd元をsrc_idとして持ち回す。
    transObj.id = ui_item.id;
    transObj.src_id = ui_item.parentElement.id;

    event.dataTransfer.setData("text", JSON.stringify(transObj));
  }

  dragover = function(event) {
    event.preventDefault();
  }

  drop = function(event) {
    var transObj = JSON.parse(event.dataTransfer.getData("text"));
    var elm = document.getElementById(transObj.id);

    // dnd元の要素を削除する
    var src_node = document.getElementById(transObj.src_id);
    var src_node_child = document.getElementById(transObj.id);
    src_node.removeChild(src_node_child);

    // 新しい要素を追加する
    var drag_elm = elm.cloneNode(true);
    drag_elm.setAttribute('class', 'ui_handle');
    event.currentTarget.appendChild(drag_elm);

    event.preventDefault();
  }

  btn_click = function() {
    alert('hello,world.');
  }

  return {
    "init": init,
    "start": start,
    "dragover": dragover,
    "drop": drop,
    "btn_click": btn_click,
  };
})();

