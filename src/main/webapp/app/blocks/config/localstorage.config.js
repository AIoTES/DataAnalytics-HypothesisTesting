(function() {
    'use strict';

    angular
        .module('simlifeApp')
        .config(localStorageConfig);

    localStorageConfig.$inject = ['$localStorageProvider', '$sessionStorageProvider'];

    function localStorageConfig($localStorageProvider, $sessionStorageProvider) {
        $localStorageProvider.setKeyPrefix('sim-');
        $sessionStorageProvider.setKeyPrefix('sim-');
    }
})();
