angular.module('guestbookSpring')
  .directive('entry', function () {
    return {
      templateUrl: 'js/directives/entry.html',
      restrict: 'E'
    };
  });
