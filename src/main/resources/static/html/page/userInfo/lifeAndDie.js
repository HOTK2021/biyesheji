layui.use(['jquery','layer'],function () {
    var $=layui.$,layer=layui.layer
    $(function () {
        selectUserInfo("/selectUserInfoAll")
    })
})

var flag = true;

function selectUser() {
    flag=true;
    selectUserInfo("/selectUserInfoAll");
}
function selectUserInfoDie() {
    flag=false;
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
                {field: 'user_id', title: 'ID', sort: true}
                ,{field: 'username', title: '用户名'}
                ,{field: 'totalAge', title: '登录时间'}
                ,{field: 'create_time', title: '出生日期', sort: true}
                ,{field: 'modify_time', title: '最后登陆', sort: true}
                ,{field: 'btn',title: '操作',templet:function () {
                    return '<button type="button" class="layui-btn">编辑</button><button type="button" class="layui-btn layui-btn-danger">删除</button>'
                }}
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
                ,{field: 'description', title: '离职原因', sort: true}
                ,{field: 'btn',title: '操作',templet:function () {
                        return '<button type="button" class="layui-btn">编辑</button><button type="button" class="layui-btn layui-btn-danger">删除</button>'
                    }}
            ]]
        });

    });
}

function search() {
    layui.use(['jquery','layer'],function () {
        alert(flag);
        var $=layui.$,layer=layui.layer;
        var key = $("#searchText").val();
        if(/^[0-9]+$/.test(key)){
            alert("1")
            if(flag){
                alert("2")
                selectUserInfo("/selectUserInfoAll?user_id="+key);
            }else{
                alert("3")
                selectUserDie("/selectUserDieAll?user_id="+key);
            }
        }else{
            if(flag){
                alert("4")
                selectUserInfo("/selectUserInfoAll?username="+key);
            }else{
                alert("5")
                selectUserDie("/selectUserDieAll?username="+key);
            }
        }


    })
}




