package com.lhf.springboot.controller;

import com.lhf.springboot.service.ArticleService;
import com.lhf.springboot.service.TtlProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author kundy
 * @create 2019/2/13 9:06 PM
 */

@RestController
public class ExportController {

    @Autowired
    private TtlProductInfoService productInfoService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/exportProduct")
    public void exportProduct(HttpServletResponse response) {
        this.productInfoService.export(response, "商品信息" + new Random().nextInt(1000));
    }

    @GetMapping("/exportArticle")
    public void exportArticle(HttpServletResponse response){
        this.articleService.export(response, "图书名著" + new Random().nextInt(1000));
    }


}
