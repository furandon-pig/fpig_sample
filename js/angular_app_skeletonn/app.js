/* app.js */

var app = angular.module('App', []);

app.controller('AppController', ['$scope',
      function($scope) {
        var idx = 1;

        // initialize
        $scope.init = function() {
          $scope.uiText = "Hello,World.";

          $scope.items = [
            { id: idx++, name: "apple"  },
            { id: idx++, name: "grape"  },
            { id: idx++, name: "orange" },
          ];
        }

        $scope.addItem = function() {
          $scope.items.push({ id: idx, name: "item(" + idx + ")" });
          idx++;
        }

        $scope.delItem = function(item) {
          for (var i in $scope.items) {
            if ($scope.items[i].id == item.id) {
              $scope.items.splice(i, 1);
              break;
            }
          }
        }

        $scope.openDialog = function() {
          $scope.uiDlgText = $scope.uiText;
        }

        $scope.closeDialog = function() {
          $scope.uiText = $scope.uiDlgText;
          $('#modal1').modal('hide');
        }

        $scope.init();
      }
]);

