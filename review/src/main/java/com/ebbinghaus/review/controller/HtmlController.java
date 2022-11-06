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
     * 创建网页
     * */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object createMapHtml(@RequestBody CreateMap createMap ) {
        return htmlService.createMapHtml(createMap);
    }
}
