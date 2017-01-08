/* app.js */

var app = angular.module('App', []);

app.controller('AppController', ['$scope', '$http',
  function($scope, $http) {

    g_is_edit_item = false; // ToDoアイテムの新規作成・編集状態
    g_id = -1;              // ToDoアイテムのIDを持ち回す変数

    // 初期化処理
    $scope.init = function() {
      $scope.items = [];

      // WebAPI経由でサーバ(のDB)にあるToDo一覧を取得する
      $http({
        method: 'GET',
        url:    'http://localhost:4567/todo'
      }).success(function(data, status, headers, config) {
        for (var i in data) {
          $scope.items.push({
            id:    data[i].id,
            // DB(SQLite3)のBooleanは't','f'で表現されているので、
            // データ取得時にtrue,falseに置き換える。
            done:  (data[i].done == 't') ? true : false,
            title: data[i].title,
            note:  data[i].note
          });
        }
      }).error(function(data, status, headers, config) {
        console.log('error. status = ' + status);
      });
    }

    // ToDoアイテムの編集・新規作成
    $scope.addItem = function() {
      // 編集・新規作成かでWebAPIのエンドポイントを切り替える
      if (g_is_edit_item == true) {
        url = 'http://localhost:4567/todo/edit/' + g_id;
      } else {
        url = 'http://localhost:4567/todo/new';
      }

      $http({
        method: 'POST',
        url:    url,
        data: {
          title: $scope.uiDlgToDoTitle,
          note:  $scope.uiDlgToDoNote
        }
      }).success(function(data, status, headers, config) {
        if (g_is_edit_item == true) {
          for (var i in $scope.items) {
            if ($scope.items[i].id == g_id) {
              $scope.items[i].title = $scope.uiDlgToDoTitle;
              $scope.items[i].note  = $scope.uiDlgToDoNote;
              break;
            }
          }
        } else {
          $scope.items.push({
            id:    data.id,
            done:  false,
            title: $scope.uiDlgToDoTitle,
            note:  $scope.uiDlgToDoNote
          });
        }
      }).error(function(data, status, headers, config) {
        console.log('error. status = ' + status);
      });
    }

    // ToDoアイテムの削除
    $scope.delItem = function(item) {
      $http({
        method: 'GET',
        url:    'http://localhost:4567/todo/delete/' + item.id
      }).success(function(data, status, headers, config) {
        for (var i in $scope.items) {
          if ($scope.items[i].id == item.id) {
            $scope.items.splice(i, 1);
            break;
          }
        }
      }).error(function(data, status, headers, config) {
        console.log('error. status = ' + status);
      });
    }

    // Bootstrapモーダルダイアログの表示
    $scope.openDialog = function(item) {
      console.log(item)
      if (item != null) {
        g_is_edit_item = true;
        g_id = item.id;
        $scope.uiDlgToDoTitle = item.title;
        $scope.uiDlgToDoNote  = item.note;
      } else {
        g_is_edit_item = false;
        $scope.uiDlgToDoTitle = '';
        $scope.uiDlgToDoNote  = '';
      }
    }

    // モーダルダイアログを閉じる
    $scope.closeDialog = function() {
      $scope.addItem();
      $('#modal1').modal('hide');
    }

    // ToDoアイテムのチェックを切り替える
    $scope.toggleToDo = function(item) {
      if (item.done == true) {
        item.done = false;
      } else {
        item.done = true;
      }
      $http({
        method: 'POST',
        url:    'http://localhost:4567/todo/toggle/' + item.id,
        data: {
          id:   item.id,
          done: item.done
        }
      }).success(function(data, status, headers, config) {
        console.log(item.id);
      }).error(function(data, status, headers, config) {
        console.log('error. status = ' + status);
      });
    }

    // ToDoが完了状態なら、CSSの取り消し線スタイルを有効にする
    $scope.getDecoration = function(item) {
      if (item.done == true) {
        return "text-decoration: line-through;";
      } else {
        return "";
      }
    }

    $scope.init();
  }

]);

