'use strict';

angular.module('guestbookSpring')
  .controller('mainController', ['$scope', 'testMessageFactory', function($scope, testMessageFactory) {
    
    testMessageFactory.getMessage().then(function(data) { $scope.testMessage = data; });
    
  }]);
