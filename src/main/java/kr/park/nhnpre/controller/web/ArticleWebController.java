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
    public String getArticles(Model model) {
        //Main 페이지에서 Article 리스트를 불러오기 위한 Controller
		logger.info("Controller - getAll");
    	
        model.addAttribute("articles", articleService.getArticles());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Article article, HttpServletResponse response) {
		logger.info("Controller - Add");
        //Article을 추가
        try {
            response.getWriter().print(articleService.addArticle(article));
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/password/{id}", method = RequestMethod.GET)
    public void getPassword(@PathVariable String id, HttpServletResponse response) {
		logger.info("Controller - Get Id : " + id);
        //해당 id의 Article의 비밀번호 부르기
        try {
            response.getWriter().print(articleService.getPassword(id));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public void modify(@PathVariable String id, @RequestBody String text, HttpServletResponse response) {
		logger.info("Controller - Modify Id : " + id);
        //Article의 내용 변경
        try {
            response.getWriter().print(articleService.modify(id, text));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id, HttpServletResponse response) {
		logger.info("Controller - Delete Id : " + id);

        //id에 해당하는 Article삭제
        try {
            response.getWriter().print(articleService.delete(id));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
