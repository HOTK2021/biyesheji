var form, $,areaData;



layui.config({
    base : "../../js/"
}).extend({
    "address" : "address"
})

layui.use(['form','layer','upload','laydate',"address"],function(){
    form = layui.form;
    $ = layui.jquery;

    $(function () {
        selectUserDie()
        lifetime()
    });

    function selectUserDie() {
        $.ajax({
            type: 'get',
            url: '/selectUserDie',
            dataType: 'json',
            async:false,
            success: function (data) {
                for (var i=0;i<data.length;i++){
                    $("#plife").append("<option value='"+data[i].user_id+"'>"+data[i].username+"</option>");
                }
            }
        });
    }

    function lifetime() {
        for(var i=1;i<=130;i++){
            $("#lifetime").append("<option value='"+i+"'>"+i+"</option>")
        }
    }

    var layer = parent.layer === undefined ? layui.layer : top.layer,
        upload = layui.upload,
        laydate = layui.laydate,
        address = layui.address;

    //上传头像
    upload.render({
        elem: '.userFaceBtn',
        url: '../../json/userface.json',
        method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            $('#userFace').attr('src',res.data[num].src);
            window.sessionStorage.setItem('userFace',res.data[num].src);
        }
    });

    //添加验证规则
    form.verify({
        userBirthday : function(value){
            if(!/^(\d{4})[\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|1[0-2])([\u4e00-\u9fa5]|[-\/](\d{1}|0\d{1}|[1-2][0-9]|3[0-1]))*$/.test(value)){
                return "出生日期格式不正确！";
            }
        }
    })
    //选择出生日期
    laydate.render({
        elem: '.userBirthday',
        format: 'yyyy年MM月dd日',
        trigger: 'click',
        max : 0,
        mark : {"0-12-15":"生日"},
        done: function(value, date){
            if(date.month === 12 && date.date === 15){ //点击每年12月15日，弹出提示语
                layer.msg('今天是马哥的生日，也是layuicms2.0的发布日，快来送上祝福吧！');
            }
        }
    });

    //获取省信息
    address.provinces();

    form.on('submit(addUser)',function (data) {
        layer.closeAll();
        $.ajax({
            type:"post",
            url:"/addUser",
            dataType: "json",
            data:$("#addUser").serialize(),
            success:function (data) {
                if(data=="ok"){
                    layer.msg("添加成功！",{icon:6});
                }else{
                    layer.msg("添加失败！",{icon:5});
                }
            }
        })
        return false;
    })
    //渲染表单
    form.render("select");

})




