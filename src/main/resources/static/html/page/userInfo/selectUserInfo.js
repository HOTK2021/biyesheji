layui.use(['jquery','layer'],function () {
    var $=layui.$,layer=layui.layer
    $(function () {
        selectUserInfo("/selectUserInfoAll")
    })
})

function selectUser() {
    selectUserInfo("/selectUserInfoAll");
}

function selectUserInfoDie() {
    selectUserDie("/selectUserDieAll");
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
                {field: 'user_id', title: 'ID', sort: true, fixed: 'left'}
                ,{field: 'username', title: '用户名'}
                ,{field: 'totalAge', title: '剩余寿命'}
                ,{field: 'create_time', title: '出生日期', sort: true}
                ,{field: 'modify_time', title: '最后登陆', sort: true,fixed: 'right'}
            ]]
        });

    });
}
function selectUserDie(url){
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#userInfoAll'
            ,height: 'auto'
            ,url: url //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'user_id', title: 'ID', sort: true, fixed: 'left'}
                ,{field: 'username', title: '用户名'}
                ,{field: 'create_time', title: '出生日期', sort: true}
                ,{field: 'description', title: '死亡原因', sort: true,fixed: 'right'}
            ]]
        });

    });
}


