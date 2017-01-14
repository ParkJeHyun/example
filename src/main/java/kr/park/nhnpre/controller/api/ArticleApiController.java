package kr.park.nhnpre.controller.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.park.nhnpre.artifacts.Article;
import kr.park.nhnpre.controller.web.ArticleWebController;
import kr.park.nhnpre.service.ArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleApiController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleWebController.class);
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/list")
    public List<Article> getArticles() {
        //Main 페이지에서 Article 리스트를 불러오기 위한 Controller
		logger.info("Controller - getAll");
    	
        return articleService.getArticles();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(Article article) {
		logger.info("Controller - Add");
        //Article을 추가
        return articleService.addArticle(article);
    }

    @RequestMapping(value = "/password/{id}")
    public String getPassword(@PathVariable String id) {
		logger.info("Controller - Get Id : " + id);
        //해당 id의 Article의 비밀번호 부르기
        return articleService.getPassword(id);
    }

    @RequestMapping(value = "/modify/{id}")
    public Integer modify(@PathVariable String id, @RequestBody String text) {
		logger.info("Controller - Modify Id : " + id);
        //Article의 내용 변경
               
        return articleService.modify(id, text);
    }

    @RequestMapping(value = "/delete/{id}")
    public Integer delete(@PathVariable String id) {
		logger.info("Controller - Delete Id : " + id);
        //id에 해당하는 Article삭제
        
        return articleService.delete(id);
    }
}
