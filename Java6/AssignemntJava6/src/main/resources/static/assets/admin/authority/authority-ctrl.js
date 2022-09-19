app.controller("authority-ctrl",function($scope,$http,$location){
	
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.initialize = function(){
        // load tất cả role
        $http.get("/rest/roles").then(resp => {
            $scope.roles = resp.data;
        })

        //load staff và directors (administrators)
        $http.get("/rest/accounts?admin=true").then(resp => {
            $scope.admins = resp.data;
            //console.log(resp.data);
        })

        // load quyền của nhân viên và quản lý
        $http.get("/rest/authorities?admin=true").then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
        })
    }

    $scope.authority_of = function(acc,role){
        if($scope.authorities){
            // có trả về #null, không có trả về undefined
            //console.log($scope.authorities);
            //console.log(acc.username);
            return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id == role.id); 
        }
    }

    $scope.authority_changed = function(acc,role){
        //console.log(acc.username);
        var authority = $scope.authority_of(acc,role);
        if(authority){
            // khó vậy thầy cũng nghĩ ra được
            // đã cấp quyền => thu hồi quyền ( là xóa á)
            $scope.revoke_authority(authority);
        }else{
            // chưa được cấp quyền => cấp quyền ( ý là thêm mới hê hê)
            authority = {account: acc, role: role};
            $scope.grant_authority(authority);
        }
    }

    // thêm mới 1 authority
    $scope.grant_authority = function(authority){
        $http.post(`/rest/authorities`,authority).then(resp => {
            $scope.authorities.push(resp.data); // bổ sung vào authority đã tải để để nó check lên trên giao diện
            alert("Thành công cấp quyền sử dụng !");
        }).catch(error => {
            alert("Cấp quyền sử dụng thất bại !")
            console.log("Error: ",error);
        })
    }

    //xóa authority
    $scope.revoke_authority = function(authority){
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);// tìm trong máng
            $scope.authorities.splice(index,1);// xóa khỏi nè
            alert("Thu hồi quyền sử dụng thành công !");
        }).catch(error => {
            alert("Thu hồi quyền sử dụng thất bại !");
            console.log("Error: ",error);
        })
    }

    $scope.initialize();
});