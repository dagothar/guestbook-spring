'use strict';

angular.module('guestbookSpring')
  .factory('testMessageFactory', ['$http', function($http) {
    
    return {
      getMessage: function() {
        
       return $http.get('/test', {
          transformResponse: function(data) { return data; }
        })
          .then(function(response) {
            return response.data;
          });
      }
    };
  }]);
