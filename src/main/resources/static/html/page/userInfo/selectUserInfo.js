layui.use(['jquery','layer'],function () {
    var $=layui.$,layer=layui.layer
    $(function () {
        selectUserInfo("/selectUserInfoAll")
    })
})

function selectUser() {
    alert("1")
    var url="/selectUserInfoAll"
    selectUserInfo(url)
}
function selectUserDie() {
    alert("2")
    var url="/selectUserDieAll"
    selectUserInfo(url)
}

function selectUserInfo(url){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#userInfoAll'
            ,height: 'auto'
            ,url: url //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'user_id', title: 'ID', width: 200, sort: true, fixed: 'left'},
                {field: 'username',title: '姓名',width: 200, sort: true},
                {field: 'totalAge',title: '寿命',width: 200, sort: true},
                {field: 'overAge',title: '剩余寿命',width: 200, sort: true},
                {field: 'create_time', title: '出生日期', width: 200, sort: true},
                {field: 'last_login_time', title: '最后登陆', width: 200, sort: true}
                // ,{field: 'username', title: '用户名', width:auto}
                // ,{field: 'create_time', title: '出生日期', width: auto, sort: true}
                // ,{field: 'modify_time', title: '最后登陆', width: auto, sort: true}
            ]]
        });

    });
}


