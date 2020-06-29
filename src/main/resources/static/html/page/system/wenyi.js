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

    $(function () {
        faqiernyi();
        plague();
        person();
    })

    form.on('submit(speedPlague)',function () {
        layer.closeAll();
        var area_id;
        var area = $('#area').val();
        var city = $('#city').val();
        var province = $('#province').val();
        if(area!=''){
            area_id = area;
        }else if(area==''&&city!=''){
            area_id = city;
        }else{
            area_id = province;
        }
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

layui.use(['table','jquery'],function () {
    var $ = layui.$;
    var table = layui.table;
    table.render({
        elem: '#wenyitable'
        ,height: 'auto'
        ,url: '/selectPlaugeInfo' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {field: 'plague_info_id', title: 'ID', sort: true}
            ,{field: 'address', title: '散播地区',templet:function (d) {
                    var code = (d.area_id).toString();
                    var address = "";
                    $.ajax({
                        url:'../../json/address.json',
                        type:'get',
                        dataType:'json',
                        async:false,
                        success:function (data) {
                            for (var i=0;i<data.length;i++){
                                if(data[i].code==code.slice(0,2)){
                                    address+=data[i].name
                                }
                                for (var j=0;j<data[i].childs.length;j++){
                                    if(data[i].childs[j].code==code.slice(0,4)){
                                        address+=data[i].childs[j].name
                                    }
                                    for (var k=0;k<data[i].childs[j].childs.length;k++){
                                        if(data[i].childs[j].childs[k].code == code){
                                            address+=data[i].childs[j].childs[k].name
                                        }

                                    }
                                }
                            }
                        }
                    })
                    return '<span>'+address+'</span>'
                }}
            ,{field: 'die_count', title: '死亡人数',sort: true}
            ,{field: 'happen_time', title: '散播时间',sort: true}
            ,{field: 'btn',title: '操作',templet:function (d) {
                var plague_info_id = d.plague_info_id;
                return '<button class="layui-btn" onclick="showDieUser('+plague_info_id+')">死亡名单</button>'
            }}
        ]]
    })
})

function showDieUser(plague_info_id) {
    layui.use(['table','jquery'],function () {
        var $ = layui.$,
            table = layui.table,
            layer = layui.layer;
        table.render({
            elem:'#dieUserTable'
            ,height: 'auto'
            ,url: '/selectPlagueUser?plague_info_id='+plague_info_id //数据接口
            ,cols: [[
                {field: 'id',title: 'ID',sort: true,width: 200}
                ,{field: 'userid',title: '用户ID',sort: true,width: 200}
                ,{field: 'username',title: '用户名',width: 200}
            ]]
        })

        layer.open({
            type:1,
            title:'死亡名单',
            area:['600px','400px'],
            content: $("#dieUserDiv"),
            offset:'auto',
            end:function () {
                $("#divs").css("display","none");
            }
        })
    })
}


