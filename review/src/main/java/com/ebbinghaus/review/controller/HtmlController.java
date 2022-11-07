package com.ebbinghaus.review.controller;



import com.ebbinghaus.review.entity.CreateMap;
import com.ebbinghaus.review.service.HtmlService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/html")
public class HtmlController {


    private final HtmlService htmlService;

    public HtmlController(HtmlService htmlService) {
        this.htmlService = htmlService;
    }

    /**
     * 新增一条
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody CreateMap createMap ) {
        return htmlService.createMapHtml(createMap);
    }


    /**
     * 删除一条
     * */
    @RequestMapping(value = "/deleteCell", method = RequestMethod.POST)
    public Object deleteCell(@RequestBody CreateMap createMap ) {
        return htmlService.deleteCell(createMap);
    }

    /**
     * 获取日期
     * */
    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public String getData() {
        return htmlService.getData();
    }
}
