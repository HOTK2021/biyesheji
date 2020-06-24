var $;

layui.use(['jquery','layer','address','form','laydate'],function () {
    $=layui.$;
    var layer=layui.layer,address=layui.address,form=layui.form,laydate=layui.laydate;

    //获取省信息
    address.provinces();

    //选择散播时间
    laydate.render({
        elem: '.speedTime',
        type: 'datetime',
        format: 'yyyy-MM-dd HH:mm:ss',
        trigger: 'click',
    });

    form.on('submit(speedPlague)',function () {
        layer.closeAll();
        var area_id = $("#area").val();
        var data =  $("#speedPlague").serialize();
        $.ajax({
            type: 'post',
            url: '/subPlague?area_id='+area_id,
            dataType: 'json',
            data:data,
            success:function (data) {
                if(data==1){
                    layer.msg("散播成功！",{icon:6});
                }else{
                    layer.msg("散播失败！",{icon:5});
                }
            }
        })
        return false;
    })

    $(function () {
        faqiernyi();
        plague();
        person();
    })

    form.render('select');

})

function plague() {
    $.ajax({
        type:'get',
        dataType:'json',
        url:'/selectPlauge',
        async:false,
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $('#plague').append('<option value="'+data[i].plague_id+'">'+data[i].plague_name+'</option>')
            }
        }
    });
}


function person() {
    $.ajax({
        type:'get',
        dataType:'json',
        url:'/selectUserToPlague',
        async:false,
        success:function (data) {
            for (var i=0;i<data.length;i++){
                $('#person').append('<option value="'+data[i].user_id+'">'+data[i].username+'</option>')
            }
        }
    });
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
            ,{field: 'area_id', title: '散播地区'}
            ,{field: 'die_count', title: '死亡人数',sort: true}
            ,{field: 'happen_time', title: '散播时间',sort: true}
        ]]
    })
})


function getCode() {
    var code = $("#area").val();
    alert(code)
}



