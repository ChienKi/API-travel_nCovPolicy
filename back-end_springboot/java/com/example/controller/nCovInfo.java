package com.example.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class nCovInfo {
    public static String get_nCovInfo() {
        //java环境中文传值时，需特别注意字符编码问题
        String httpUrl = "http://api.tianapi.com/ncov/index";
        String httpArg = "key=767d51bc9cce27e05421a1a9cd7f4c4f";
        String jsonResult = request.request(httpUrl, httpArg);
        System.out.println(jsonResult);
        return jsonResult;
    }

    public static String getTestDefault() {
        return "{\"code\":200,\"msg\":\"success\",\"newslist\":[{\"news\":[{\"id\":212096,\"pubDate\":1665968561000,\"pubDateStr\":\"21小时前\",\"title\":\"国家卫健委|昨日新增本土182+534例\",\"summary\":\"10月16日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例245例。其中境外输入病例63例（广东18例，福建8例，上海7例，江苏7例，北京6例，四川6例，内蒙古3例，山东3例，云南3例，湖北1例，广西1例），含6例由无症状感染者转为确诊病例（四川4例，山东1例，广东1例）；本土病例182例（山西40例，广东23例，浙江20例，北京13例，内蒙古13例，新疆13例，江苏9例\",\"infoSource\":\"央视新闻app\",\"sourceUrl\":\"https:\\/\\/content-static.cctvnews.cctv.com\\/snow-book\\/index.html?item_id=18436538838733489518&toc_style_id=feeds_default\"},{\"id\":212077,\"pubDate\":1665963463000,\"pubDateStr\":\"22小时前\",\"title\":\"山西|昨日新增本土确诊病例40例\",\"summary\":\"2022年10月16日0-24时，山西省新增本土新冠肺炎确诊病例40例（大同市平城区21例、大同市云州区11例、朔州市朔城区无症状感染者转为确诊病例2例、新增确诊病例1例、朔州市怀仁市无症状感染者转为确诊病例1例、忻州市五寨县1例、忻州市偏关县1例、临汾市永和县1例、吕梁市文水县1例）。当日治愈出院7例（太原市尖草坪区1例、太原市晋源区1例、晋中市平遥县1例、晋中市祁县1例、运城市盐湖区3例）。累\",\"infoSource\":\"央视新闻app\",\"sourceUrl\":\"https:\\/\\/content-static.cctvnews.cctv.com\\/snow-book\\/index.html?item_id=3072866275901042823&toc_style_id=feeds_default\"},{\"id\":212093,\"pubDate\":1665967565000,\"pubDateStr\":\"21小时前\",\"title\":\"广东|昨日新增本土确诊病例23例\",\"summary\":\"10月16日0—24时，广东全省新增本土确诊病例23例（广州3例，深圳10例，佛山6例，惠州1例，东莞1例，中山2例）；新增本土无症状感染者38例（广州27例，深圳5例，惠州1例，东莞4例，中山1例）。全省新增境外输入确诊病例17例（广州8例，深圳7例，佛山1例，肇庆1例）；新增境外输入无症状感染者17例（广州8例，深圳2例，佛山6例，东莞1例）；另有1例境外输入无症状感染者转确诊病例（深圳1例）\",\"infoSource\":\"央视新闻app\",\"sourceUrl\":\"https:\\/\\/content-static.cctvnews.cctv.com\\/snow-book\\/index.html?item_id=7206922379184890367&toc_style_id=feeds_default\"},{\"id\":212080,\"pubDate\":1665964250000,\"pubDateStr\":\"22小时前\",\"title\":\"北京|昨日新增本土确诊病例13例\",\"summary\":\"10月16日0时至24时，北京新增13例本土确诊病例（含2例无症状感染者转确诊病例，其中9例已通报）和2例无症状感染者（均已通报），无新增疑似病例；新增6例境外输入确诊病例和14例无症状感染者，无新增疑似病例。治愈出院5例，解除医学观察的无症状感染者7例。\\n本土病例\\n确诊病例1：现住海淀区中关村南大街12号院，为社会面筛查人员，10月16日诊断为确诊病例。\\n确诊病例2：现住怀柔区茶坞火车站，为隔离\",\"infoSource\":\"央视新闻app\",\"sourceUrl\":\"https:\\/\\/content-static.cctvnews.cctv.com\\/snow-book\\/index.html?item_id=13748317123476919067&toc_style_id=feeds_default\"},{\"id\":212090,\"pubDate\":1665966614000,\"pubDateStr\":\"21小时前\",\"title\":\"新疆|昨日新增本土确诊病例13例\",\"summary\":\"新疆维吾尔自治区卫生健康委通报，10月16日0至24时，新疆维吾尔自治区新增本土确诊病例13例，其中，乌鲁木齐市天山区2例、沙依巴克区2例、高新区1例、水磨沟区3例、米东区2例，伊犁州伊宁市3例。\\n新增本土无症状感染者175例，其中，乌鲁木齐市天山区29例、沙依巴克区25例、高新区16例、水磨沟区18例、经开区9例、米东区13例，伊犁州伊宁市24例、伊宁县3例，塔城地区乌苏市8例，哈密市伊州区3例\",\"infoSource\":\"央视新闻app\",\"sourceUrl\":\"https:\\/\\/content-static.cctvnews.cctv.com\\/snow-book\\/index.html?item_id=178599323407777668&toc_style_id=feeds_default\"}],\"desc\":{\"id\":1,\"createTime\":1579537899000,\"modifyTime\":1665999118000,\"currentConfirmedCount\":7517216,\"confirmedCount\":7894097,\"suspectedCount\":25085,\"curedCount\":349415,\"deadCount\":27466,\"seriousCount\":15621,\"foreignStatistics\":{\"currentConfirmedCount\":216538505,\"confirmedCount\":618434863,\"suspectedCount\":4,\"curedCount\":395313830,\"deadCount\":6582528},\"globalStatistics\":{\"currentConfirmedCount\":224055721,\"confirmedCount\":626328960,\"curedCount\":395663245,\"deadCount\":6609994},\"highDangerCount\":2339,\"midDangerCount\":1506},\"riskarea\":\"客观原因限制，暂无法提供\"}]}";
    }
}
