var $;

layui.use(['layer','jquery'],function () {
    $=layui.$;
    var layer=layui.layer;

    $(function () {
        caozuoLog();
    })

});

function caozuoLog() {
    $("#caozuoLog").css('display','');
    $("#loginLog").css('display','none');
}

function loginLog() {
    $("#caozuoLog").css('display','none');
    $("#loginLog").css('display','');
}

layui.use('table',function () {
    var table=layui.table;
    table.render({
        elem: '#caozuoTable'
        ,height: 'auto'
        ,url: '/selectJobLog' //数据接口
        ,loading: true
        ,page: true //开启分页
        ,cols: [[
            {field: 'log_id', title: 'ID', sort: true}
            ,{field: 'job_id', title: '操作ID'}
            ,{field: 'bean_name', title: 'BEAN'}
            ,{field: 'method_name', title: '方法名称'}
            ,{field: 'params', title: '参数'}
            ,{field: 'status', title: '状态'}
            ,{field: 'error', title: '异常'}
            ,{field: 'time', title: '耗时（毫秒）',sort: true}
            ,{field: 'create_time', title: '创建时间',sort: true}
        ]]
    })
    table.render({
        elem: '#loginTable'
        ,height: 'auto'
        ,url: '/selectLoginLog' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {type:'numbers'}
            ,{field: 'username', title: 'ID', sort: true}
            ,{field: 'login_time', title: '登陆时间',sort: true}
            ,{field: 'location', title: '登陆地区'}
            ,{field: 'ip', title: 'IP地址'}
        ]]
    })
})