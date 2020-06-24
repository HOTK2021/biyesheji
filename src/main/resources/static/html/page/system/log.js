var $;

layui.use(['layer','jquery'],function () {
    $=layui.$,layer=layui.layer;
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
        ,url: '' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {type:'numbers'}
            ,{type: 'checkbox'}
            ,{field: 'plague_info_id', title: 'ID', sort: true}
            ,{field: 'plague_id', title: '瘟疫'}
            ,{field: 'area', title: '散播地区'}
            ,{field: 'dieCount', title: '死亡人数',sort: true}
            ,{field: 'happen_time', title: '散播时间',sort: true}
        ]]
    })
    table.render({
        elem: '#loginTable'
        ,height: 'auto'
        ,url: '' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {type:'numbers'}
            ,{type: 'checkbox'}
            ,{field: 'plague_info_id', title: 'ID', sort: true}
            ,{field: 'plague_id', title: '瘟疫'}
            ,{field: 'area', title: '散播地区'}
            ,{field: 'dieCount', title: '死亡人数',sort: true}
            ,{field: 'happen_time', title: '散播时间',sort: true}
        ]]
    })
})