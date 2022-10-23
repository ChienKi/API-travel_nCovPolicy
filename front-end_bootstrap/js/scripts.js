// Empty JS for your own code to be here

function get_nCovInfo(){
    let str_json
    let json
    $.ajaxSettings.async = false;
    $.get("http://127.0.0.1:8082/api/get_nCovInfo",function (data,status){
        str_json = data
        json = eval("("+data+")");
        // console.log("get_nCovInfo:"+data);
    })
    // return str_json;
    return json;
}

//出行防疫政策-----------------------------------------------------------------------------------

function get_TravelPolicy(){  //这个from和to是城市下拉菜单的value
    var dCity_code = document.getElementById("TravelPolicy_出发地城市").value;  //已经选中的出发城市
    var aCity_code = document.getElementById("TravelPolicy_目的地城市").value;  //已经选中的出发城市
    // console.log(aCity_code)
    // console.log(dCity_code)
    if(dCity_code=="请选择城市" || aCity_code=="请选择城市")return;


    // $.ajaxSettings.async = false;
    // $.get("http://127.0.0.1:8082/api/TravelPolicy/getByFromTo",{
    //     from:dCity_code,
    //     to:aCity_code,
    // },function(data, status){
    //     json = eval("("+data+")");
    // })
    // let json = get_json("http://127.0.0.1:8082/api/TravelPolicy/getDefaultPolicy")
    let json = get_json("http://127.0.0.1:8082/api/TravelPolicy/getByFromTo?from="+dCity_code+"&to="+aCity_code)
    // console.log(json)
    if(json.reason!="success"){
        console.log(json.reason);
        return;
    }
    // console.log(json.result.from_info)
    // console.log(json.result.to_info)

    setPolicyTab("d", json.result.from_info)
    setPolicyTab("a", json.result.to_info)

    /*
    error_code	int	返回码
    reason	string	返回说明
    result	string	返回结果集
    from_info	object	出发地城市-出行政策信息
    to_info	object	目的地城市-出行政策信息
    province_id	stirng	省份ID
    province_name	stirng	省份名称
    city_id	stirng	城市ID
    city_name	stirng	城市名称
    health_code_desc	stirng	健康码描述
    health_code_gid	stirng	健康码使用教程链接
    health_code_name	stirng	健康码名称
    health_code_picture	stirng	健康码图片
    health_code_style	stirng	健康码类型,0:小程序 1:二维码，其他：未知
    high_in_desc	stirng	高风险地区，进入政策描述
    low_in_desc	stirng	低风险地区，进入政策描述
    out_desc	stirng	出行政策描述
    risk_level	stirng	风险等级，0:暂无 1:低风险 2:中风险 3:高风险 4:部分地区中风险 5:部分地区高风险 6:部分地区中、高风险

    city_id:"10001"
    city_name:"合肥"
    health_code_desc:"支付宝扫一扫，进入小程序"
    health_code_gid:""
    health_code_name:"安康码"
    health_code_picture:"https://cdn.juhekeji.com/spring_travel/88bdc6e35120ac7a587beaa5d4942c45.png"
    health_code_style:"1"
    high_in_desc:""
    low_in_desc:"对中高风险地区来（返）肥人员，分类实施48小时核酸查验、集中隔离、居家健康监测。"
    out_desc:"严格限制前往中、高风险地区及所在县（市、区、旗），非必要不前往中、高风险地区所在地市的其他县（市、区、旗）；高风险岗位人员应尽量避免出行，确需出行的须满足脱离工作岗位14天以上，且持48小时内核酸检测阴性证明，并向所在单位报备。"
    province_id:"1"
    province_name:"安徽"
    risk_level:"1"

    city_id: "10017"
    city_name: "北京"
    health_code_desc: "微信扫一扫，进入小程序"
    health_code_gid: ""
    health_code_name: "北京健康宝"
    health_code_picture: "https://cdn.juhekeji.com/spring_travel/e354e61774e7294ace7273850ee660a9.png"
    health_code_style: "0"
    high_in_desc: ""
    low_in_desc: "1.加强机场口岸防疫管理，严格落实入境人员和高风险岗位工作人员全流程闭环管理要求。入境人员严格执行“7天集中隔离+3天居家健康监测”措施。\n2.7天内出现本土疫情的县（市、区、旗）人员严格限制进返京，已抵京的分类落实隔离观察、健康监测、核酸检测等措施，居家期间不外出。其他人员持48小时内核酸阴性证明和“北京健康宝”绿码正常进返京，在抵京后以及出现涉疫风险、疑似症状时，都要第一时间通过电话、微信等方式主动向社区（村）、酒店或单位报告，本人及同住人员配合做好排查管理、健康监测。\n3.进返京人员抵京后居家健康监测3天，开展3天2检（抵京24小时内完成一次核酸检测，间隔24小时后、抵京72小时内完成第二次核酸检测），7天内不聚餐、不聚会、不前往人群密集场所。涉疫风险人员配合落实居家（店）健康监测等防疫措施。居家隔离、居家健康监测及其同住人员，要严格居家、不外出。\n4.严格落实快递、外卖、冷链、医疗机构等重点行业、重点场所、重点区域人群常态化核酸筛查，确保“应检尽检”。进入党政机关、企事业单位、公共场所及社区（村），乘坐公共交通工具，严格扫码、测温、查验72小时内核酸阴性证明。各小区（村）加强卡口管理，严格落实查验要求。在京单位履行防疫责任，职工假期返岗前48小时内应进行1次核酸检测，检测阴性结果未出之前或有疑似症状的暂缓返岗。\n5.压实疫情防控“四方责任”。各行业主管部门坚持“管行业必须管防疫、管业务必须管防疫”，加强日常检查指导，发现问题及时督促整改。在京单位严格落实防疫主体责任，动态完善人员台账，强化内部管理，抓实抓细各项防疫措施。各区对属地疫情防控工作负总责，统筹各方资源力量，确保各项防疫措施落实落位。个人要当好自身健康管理第一责任人，主动报告个人涉疫情况，自觉履行核酸检测、扫码查验等防疫义务。对于违反首都防疫政策，造成不良后果的，依法追究责任并通报曝光。"
    out_desc: "在京党政机关、国有企事业单位人员带头执行，除重要公务活动需要外原则上不出京，确需出京的严格审批管理。提倡市民群众减少出京活动，确需出京的，要防范旅途疫情风险，全程规范佩戴口罩，做好个人防护，不前往有疫情的县（市、区、旗）。如途中出现涉疫风险，就地配合落实防疫措施，暂缓进返京。严控本地中高风险区及其他涉疫风险人员出京。"
    province_id: "2"
    province_name: "北京"
    risk_level: "6"
     */

}

function setPolicyTab(d_a,info){
    $("#"+d_a+"HealthCode").empty().append("<p class='text-success'>" +
        "<br>"+info.health_code_name+
        "<br>"+"<img alt=\"Health Code QRcode\" src=\""+info.health_code_picture+"\" class=\"img-thumbnail\" style=\"width:60%;\"/>" +
        "<br> <span>"+info.health_code_desc+"</span> </p>");

    $("#"+d_a+"InPolicy").empty().append(
        "<p> <br>低风险地区进入政策"+
        "<br>" + info.low_in_desc + "</p>" +
        "<p class='text-danger'> <br>高风险地区进入政策" +
        "<br>" + info.high_in_desc + "</p>")

    $("#"+d_a+"OutPolicy").empty().append("<p class='text-danger'>"+ info.out_desc +"</p>")

    //risk_level 风险等级，0:暂无 1:低风险 2:中风险 3:高风险 4:部分地区中风险 5:部分地区高风险 6:部分地区中、高风险
    let risk_level=["暂无" ,"低风险" ,"中风险" ,"高风险" ,"部分地区中风险" ,"部分地区高风险" ,"部分地区中、高风险"]
    $("#"+d_a+"Risk").empty().append("<p class='text-info'>"+ risk_level[info.risk_level] +"</p>")
}

function get_ProvCity_policy(){
    return get_json("http://127.0.0.1:8082/api/TravelPolicy/getCityCodes")
}

function addProvinceOption(){
    // console.log(ProvCity_Policy)
    for(let i=0;i<ProvCity_Policy.length;i++){
        // console.log(ProvCity_Policy[i].province);
        $(".policy_province").append(
            "<option value=\""+i+"\">"+ProvCity_Policy[i].province+"</option>"
        )//value是数组的i, 用于进一步索引ProvCity_Policy[i].city
    }
}

function addCityOption(select1_id,select2_id){
    // console.log(select1_id + "  " + select2_id)
    var select2 = document.getElementById(select2_id);
    var selected1_val = document.getElementById(select1_id).value;  //已经选中的省份
    //console.log("............"+selected1_val);

    select2.length = 0; //每次都先清空一下市级菜单
    if(selected1_val != '请选择省份'){
        var cities = ProvCity_Policy[selected1_val].citys
        for(let i=0;i<cities.length;i++){
            //console.log(cities[i].city);
            //console.log(cities[i].city_id);
            $("#"+select2_id).append(
                "<option value=\""+cities[i].city_id+"\">"+cities[i].city+"</option>"
            )//value是数组的i
        }
    }else{
        select2.length = 0;
        select2.add(new Option("请选择城市", "请选择城市"), null);
    }
}

//高德天气------------------------------------------------------------------------------------

function get_cities(){
    get_json("http://127.0.0.1:8082/db/get_gaodeCities")
}

function get_cityCode(){
    let city_name= document.getElementById("cityForWeather").value;
    // console.log("get_cityCode:"+city_name)
    let city_json
    $.ajaxSettings.async = false;
    $.get("http://127.0.0.1:8082/db/get_gaodeCityCode?city_name="+city_name,function (data,status){
        city_json = data
        console.log(city_json)
    })
    return city_json.city_code;
}

function get_Weather(){
    $("#weather-table").show()
    $("#visitList").show()
    get_Visit()
    // console.log("get_Weather")
    let city_code = get_cityCode()
    let weather = get_json("http://127.0.0.1:8082/api/getWeather?city_code="+city_code)
    // console.log(weather)
    let weather_detail = weather.lives[0]
    console.log(weather.lives[0].weather)
    $("#td_weather").empty().append(weather_detail.weather)
    $("#temperature").empty().append(weather_detail.temperature)
    $("#winddirection").empty().append(weather_detail.winddirection)
    $("#windpower").empty().append(weather_detail.windpower)
    $("#humidity").empty().append(weather_detail.humidity)
    $("#reporttime").empty().append(weather_detail.reporttime)
    $("#td_province").empty().append(weather_detail.province)
    $("#td_city").empty().append(weather_detail.city)
        // "province" :"四川",
        // "city" :"市中区",
        // "adcode" :"511102",
        // "weather" :"晴",
        // "temperature" :"24",
        // "winddirection" :"北",
        // "windpower" :"≤3",
        // "humidity" :"49",
        // "reporttime" :"2022-10-20 14:02:20"
}

//Photo-------------------------------------------------------------------------------
function get_Photo(){
    let photo = get_json("http://localhost:8082/api/get_Photo");
    // console.log(photo)
    return photo.data
}

//Visit------------------------------------------------------------------------------
function get_Visit(){
    let city_name= document.getElementById("cityForWeather").value;
    let visitList;
    $.ajaxSettings.async = false;
    $.get("https://api.tianapi.com/scenic/index?key=767d51bc9cce27e05421a1a9cd7f4c4f&word="+city_name+"&num=10",function (data,status){
        console.log(data)
        visitList = data.newslist;
    })
    for (let i = 0; i < visitList.length; i++) {
        $(".visitCardList").append("<div class=\"card\">\n" +
            "<div class=\"card-body \">\n" +
            "<h5 class=\"card-title text-success\">"+ visitList[i].name +"</h5>\n" +
            "<p class=\"card-text text-info\"  style=\"background: #f7ecb5\">"+ visitList[i].content +"</p>\n" +
            "</div>\n" +
            "</div>")
    }
    //name content
}

//map-----------------------------------------------------------
// function map(){
//     let json
//     $.ajaxSettings.async = false;
//     $.ajaxSettings.withCredentials = true
//     $.get("https://interface.sina.cn/news/wap/fymap2020_data.d.json",function (data,status){
//         console.log(data)
//         json = data.newslist;
//     })
//     // return str_json;
//     console.log(map_json)
//     return json;
// }


function get_json(url){
    let str_json
    $.ajaxSettings.async = false;
    $.get(url,function (data,status){
        str_json = data
        // console.log(str_json)
        json = eval("("+data+")");
    })
    // return str_json;
    return json;
}