layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#userInfoAll'
        ,height: auto
        ,url: '/selectUserInfo' //数据接口
        ,page: true //开启分页
        ,limit: [10,20,30]
        ,cols: [[ //表头
            {field: 'user_id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'username', title: '用户名', width:80}
            ,{field: 'dept_id', title: '部门', width:80, sort: true}
            ,{field: 'email', title: '邮箱', width:80}
            ,{field: 'mobile', title: '电话', width: 177}
            ,{field: 'create_time', title: '出生日期', width: 80, sort: true}
            ,{field: 'age', title: '年龄', width: 135, sort: true}
            ,{field: 'ssex', title: '性别', width: 80}
            ,{field: 'last_login_time', title: '最后登陆', width: 80, sort: true}
            ,{field: 'description', title: '个人简介', width: 135, sort: true}
        ]]
    });

});