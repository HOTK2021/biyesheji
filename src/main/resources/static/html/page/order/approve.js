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
            elem: '#approve'
            ,height: 'auto'
            ,url: '' //数据接口
            ,page: true //开启分页
            ,toolbar:'#toolbarDemo'
            ,cols: [[ //表头
                {type:'numbers'}
                ,{type: 'checkbox'}
                ,{field: 'user_id', title: 'ID', sort: true, }
                ,{field: 'username', title: '用户名'}
                ,{field: 'ssex', title: '性别'}
                ,{field: 'dieTime', title: '死亡时间',sort: true}
            ]]
        });

    })
}
