'use strict';

angular.module('guestbookSpring')
  .controller('mainController', ['$scope', 'entryFactory', function($scope, entryFactory) {
    
    $scope.refreshEntries = function() {
      entryFactory.getEntries()
      .then(function(data) {
        $scope.entries = data;
        console.log(data);
      });
    };
    
    $scope.refreshEntries();
      
    $scope.addNewEntry = function(entry) {
      var newEntry = {
        id: 0,
        message: $scope.newEntryMessage
      };
      
      entryFactory.addEntry(newEntry);
      $scope.newEntryMessage = undefined;
      
      $scope.refreshEntries();
    };
    
  }]);
