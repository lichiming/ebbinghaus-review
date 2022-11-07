package com.ebbinghaus.review.service;

import com.ebbinghaus.review.entity.CreateMap;
import com.ebbinghaus.review.util.HtmlPublic;
import com.ebbinghaus.review.util.TimeUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service("htmlService")
public class HtmlService {

    public Object createMapHtml(CreateMap createMap) {
        List<String> mapHtmlString = new ArrayList<>();


        String deleteMark = System.currentTimeMillis()+"";

        String firstStr = "<tr><td>学习内容</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>删除</td></tr>";
        String str = "<tr>" +
                "<td>"+createMap.getContent()+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.MINUTE,20)+"'>"+ TimeUtil.getTime(Calendar.MINUTE,20)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.MINUTE,60)+"'>"+ TimeUtil.getTime(Calendar.MINUTE,60)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.MINUTE,540)+"'>"+ TimeUtil.getTime(Calendar.MINUTE,540)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.DATE,1)+"'>"+ TimeUtil.getTime(Calendar.DATE,1)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.DATE,2)+"'>"+ TimeUtil.getTime(Calendar.DATE,2)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.DATE,5)+"'>"+ TimeUtil.getTime(Calendar.DATE,5)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.DATE,8)+"'>"+ TimeUtil.getTime(Calendar.DATE,8)+"</td>" +
                "<td class = '"+TimeUtil.getDate(Calendar.DATE,14)+"'>"+ TimeUtil.getTime(Calendar.DATE,14)+"</td>" +
                "<td><input type=button value=删除 onclick=deleteCell("+deleteMark+")></td>" +
                "</tr>";
        mapHtmlString.add(HtmlPublic.getMapHtmlFirstString());


        //在这里读数据



        mapHtmlString.add(firstStr);

        mapHtmlString.addAll(HtmlPublic.readLine());
        mapHtmlString.add(str);



        mapHtmlString.add(HtmlPublic.getMapHtmlLastString());
        HtmlPublic.createHtmlFile(mapHtmlString);
        return "ok";
    }



    public Object deleteCell(CreateMap createMap) {
        List<String> mapHtmlString = new ArrayList<>();
        mapHtmlString.addAll(HtmlPublic.deleteLine(createMap.getContent()));
        HtmlPublic.createHtmlFile(mapHtmlString);
        return "ok";
    }

    public String getData() {
        return TimeUtil.getDate(Calendar.DATE,0);
    }
}
