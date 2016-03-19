'use strict';

angular.module('guestbookSpring')
  .controller('mainController', ['$scope', 'testMessageFactory', 'entryFactory', function($scope, testMessageFactory, entryFactory) {
    
    testMessageFactory.getMessage().then(function(data) { $scope.testMessage = data; });
    
    entryFactory.getEntries()
      .then(function(data) {
        $scope.entries = data;
        console.log(data);
      });
    
  }]);
