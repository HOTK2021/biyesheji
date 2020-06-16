layui.use(['jquery','layer'],function () {
    var $=layui.$,layer=layui.layer;
    $(function () {
        selectNotApprove()
    })
})

function selectNotApprove(){
    layui.use("table",function () {
        var table = layui.table;
        table.render({
            elem: '#confirmed'
            ,height: 'auto'
            ,url: '/userdie' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                ,{field: 'user_id', title: 'ID', sort: true, fixed: 'left'}
                ,{field: 'username', title: '用户名'}
                ,{field: 'ssex', title: '性别'}
                ,{field: 'dieTime', title: '死亡时间',sort: true}
                ,{field: 'btn',title: '操作',templet:function () {
                        return '<button type="button" class="layui-btn">确认</button>'
                    }}
            ]]
        });

    })
}
