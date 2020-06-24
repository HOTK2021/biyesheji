layui.use(['jquery','layer'],function () {
    var $=layui.$,layer=layui.layer;
    $(function () {
        selectNotConfirmed()
    });


})

function selectNotConfirmed(){
    layui.use("table",function () {
        var table = layui.table;
        //监听表格复选框选择
        table.render({
            elem: '#confirmed'
            ,id: 'confirmed'
            ,height: 'auto'
            ,url: '/userdie' //数据接口
            ,page: true //开启分页
            ,toolbar:'#toolbarDemo'
            ,cols: [[ //表头
                {type: "numbers"}
                ,{type:'checkbox'}
                ,{field: 'user_id', title: 'ID', sort: true}
                ,{field: 'username', title: '用户名'}
                ,{field: 'ssex', title: '性别'}
                ,{field: 'dieTime', title: '死亡时间',sort: true}
            ]]
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var user_id=[];
                var checkStatus = table.checkStatus('confirmed')
                    ,data = checkStatus.data;
                for (var i=0;i<data.length;i++){
                    user_id[i] = JSON.stringify(data[i].user_id);
                }
                $.ajax({
                    type: 'post',
                    data:{"user_id":user_id},
                    url: '/RemoveAndAdd',
                    dataType: 'json',
                    success:function (data) {
                        if(data==1){
                            layer.alert("操作成功！")
                        }else{
                            layer.alert("操作失败！")
                        }
                    }
                })


            }
        };
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        })
    })
}
