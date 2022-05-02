angular.module('products', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/products/cart';

    $scope.loadCart = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.productsInCart = response.data;
            });
    };

    $scope.loadCart;

});