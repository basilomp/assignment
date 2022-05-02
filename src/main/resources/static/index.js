angular.module('products', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/products';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.removeFromList = function (productId) {
        $http({
            url: contextPath + '/products/remove',
            method: 'DELETE',
            params:
                {
                    productId: productId
                }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addToCart = function (productId) {
        $http({
            url: contextPath + '/products/add',
            method: 'POST',
            params: {
                productId: productId
            }
        });
    };

    // $scope.changeScore = function (clientId, delta){
    //     $http({
    //         url: contextPath + '/client/change_score',
    //         method: 'GET',
    //         params: {
    //             clientId: clientId,
    //             delta: delta
    //         }
    //     }).then(function (response){
    //         $scope.loadClients();
    //     });
    // };

    $scope.loadProducts();

});