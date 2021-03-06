(function() {
    'use strict';

    angular
        .module('simlifeApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('sim-metrics', {
            parent: 'admin',
            url: '/metrics',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Application Metrics'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/metrics/metrics.html',
                    controller: 'SimMetricsMonitoringController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
