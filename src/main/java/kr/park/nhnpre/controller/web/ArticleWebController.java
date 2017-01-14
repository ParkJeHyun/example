package kr.park.nhnpre.controller.web;

import kr.park.nhnpre.artifacts.Article;
import kr.park.nhnpre.service.ArticleService;
import kr.park.nhnpre.util.EmailCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016-12-19.
 */
@Controller
public class ArticleWebController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleWebController.class);
    
    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String main() {
        //Main 페이지에서 Article 리스트를 불러오기 위한 Controller
		logger.info("WebController - main");
    	
        return "index";
    }
}
