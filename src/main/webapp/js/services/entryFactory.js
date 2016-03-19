'use strict';

angular.module('guestbookSpring')
  .factory('entryFactory', ['$http', function($http) {
    
    return {
      getEntries: function() {
        
       return $http.get('/entries')
          .then(function(response) {
            return response.data;
          });
      }
    };
  }]);
