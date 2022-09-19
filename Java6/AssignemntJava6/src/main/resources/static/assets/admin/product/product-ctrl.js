app.controller("product-ctrl", function($scope,$http){
    $scope.items = [];
    $scope.categories = [];
    $scope.form = {
        image:'cloud-upload.jpg'
    };

    $scope.intialize = function(){
        // load products
       $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        }) 
        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.categories = resp.data;
        }) 
    }
    
    // khởi đầu
    $scope.intialize();

    //xóa form
    $scope.reset = function(){
        $scope.form = {
            createDate: new Date(),
            image:'cloud-upload.jpg',
            available:true
        }
    }

    //Hiển thị lên form
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
        $('.nav-tabs a:eq(0)').tab('show') // hiển thị tab đầu tiền khi ấn edit
    }

    $scope.create = function(item){
        //alert("create");
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`,item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate);
            $scope.items.push(resp.data); // thêm duwxl i
            $scope.reset();
            alert("Thêm mới sản phẩm thành công !");
        }).catch(error => {
            alert("Lỗi thêm mới sản phẩm!");
            console.log("Error: ",error);
        })
    }

    $scope.update = function(item){
		//alert("update ");
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`,item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id); // tìm vị trí đâug tiê phần tử 
            $scope.items[index] = item;
            alert("Cập nhật thành công !");
        }).catch(error => {
            alert("Lỗi cập nhật!");
            console.log("Error: ",error);
        }) 
    }

    $scope.delete = function(item){
		//alert("delete ");
        $http.delete(`/rest/products/${item.id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1); // xóa phần tywf đó 
            $scope.reset();
            alert("Đã xóa thành công!");
        }).catch(error => {
            alert("Lỗi xóa!");
            console.log("Error: ",error);
        })
    }

    // Upload hình
    $scope.imageChanged = function(files){
        //alert("file");
        var data = new FormData();
        data.append('file',files[0]); // lấy file vừa chọn được bỏ vào formData đấy
        $http.post('/rest/upload/images',data, { // post len server
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error: ",error);
        })
    }

    // page
    $scope.pager = {
        page: 0,
        size: 10,
        get items(){
            var start = (this.page * this.size);
            return $scope.items.slice(start,(start + this.size));  
            // slice() - cắt lấy các mặt hàng ...
        },
        
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },

        first(){
            this.page = 0;
            
        },

        previous(){
            this.page--;
            console.log(this.items);
            if(this.page < 0){
                this.last();
            }
        },

        next(){
            this.page++;
            console.log(this.items);
            if(this.page >= this.count){
                this.first();
            }
        },

        last(){
            this.page = this.count - 1;
        }
    }
});