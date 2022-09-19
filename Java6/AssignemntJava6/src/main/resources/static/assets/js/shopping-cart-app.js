const app = angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl",function($scope,$http){
	$scope.cart = {
		items: [],
		add(id){
			var item = this.items.find(item => item.id == id);
			if(item){
				item.qty++;
				this.saveToLocalStorage();
			}else{
				$http.get(`/rest/products/${id}`).then(resp => {
					this.items.push(resp.data);
					this.saveToLocalStorage();
				})
			}
		},
		saveToLocalStorage(){
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart",json);
		},
		// lưu giỏ hàng vào local storage
		remove(id){
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index ,1);
			this.saveToLocalStorage();
		},
		clear(){
			this.items = []
			this.saveToLocalStorage();
		},
		amt_of(item){},
        //Tính tổng số lượng các mặt hàng trong giỏ
        get count(){
            // duyệt qua các mặt hàng, lấy qty và tính total
            return this.items
                .map(item => item.qty)
                .reduce((total,qty) => total+= qty,0);
        },
        //Tổng thành tiên các mặt hàng trong giỏ
        get amount(){
            return this.items  
                .map(item => item.qty * item.price)
                .reduce((total,qty) => total+= qty,0);
        },
		// tong thành tiền các mặt hàng trong giỏ
		loadFormLocalStorage(){
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json):[];
		}
		// đọc giỏ hangg từ storege
}
		$scope.cart.loadFormLocalStorage();
		$scope.order = {
        createDate: new Date(),
        address:"",
        account:{username:$("#username").text()},
        get orderDetails(){ // thuộc tính chỉ đọc 'get'
            return $scope.cart.items.map(item => {
                return {
                    product:{id:item.id},
                    price: item.price,
                    quantity: item.qty
                }
            });
        },
        purchase(){
            var order = angular.copy(this); // tạo đối tượng mów
            // Thực hiện đặt hàng ở đây
            $http.post("/rest/orders",order).then(resp => { // tiến hành đặt hàng
                alert("Đặt hàng thành công !");
                $scope.cart.clear(); // xóa giỏ hàng 
                location.href = "/order/detail/" + resp.data.id; // chuyển sang trang chi tiết đơn hàng với hàng vừa đặt
            }).catch(error => {
                alert("Đặt hàng lỗi !");
                console.log(error);
            })
        }
			}
})