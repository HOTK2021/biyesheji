var $;

layui.use(['jquery','layer','address'],function () {
    $=layui.$;
    var layer=layui.layer,address=layui.address;

    //获取省信息
    address.provinces();

    $(function () {
        person();
    })

})


function person() {
    $.ajax({
        type:'get',
        dataType:'json',
        url:'/selectUserToPlague',
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $('#person').append('<option value="'+data[i].user_id+'">'+data[i].username+'</option>')
            }
        }
    })
}

function faqiernyi() {
    $("#faqiwenyi").css('display','')
    $("#wenyijilu").css('display','none')
}
function wenyijilu() {
    $("#faqiwenyi").css('display','none')
    $("#wenyijilu").css('display','')
}

layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem: '#wenyitable'
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



