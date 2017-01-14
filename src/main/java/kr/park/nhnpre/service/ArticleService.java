package kr.park.nhnpre.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.park.nhnpre.artifacts.Article;
import kr.park.nhnpre.controller.web.ArticleWebController;
import kr.park.nhnpre.mapper.ArticleMapper;
import kr.park.nhnpre.util.EmailCheck;

@Service
public class ArticleService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
    ArticleMapper articleMapper;

    public List<Article> getArticles() {
		logger.info("Service - getAll");
		
        return articleMapper.getArticleList();
    }

    public int addArticle(Article article) {
		logger.info("Service - Add");
        //Article을 추가
        if(EmailCheck.checkEmail(article.getEmail())){
            //Email 형식이 제대로 됨
            return articleMapper.addArticle(article);
        }
        else {
            //Email의 형식이 잘못됨
            return 2;
        }
    }

    public String getPassword(String id) {
		logger.info("Service - Get Id : " + id);
        //해당 id의 Article의 비밀번호 부르기
        return articleMapper.getArticlePasswordById(id);
    }

    public int modify(String id, String text) {
		logger.info("Service - Modify Id : " + id);
        //Article의 내용 변경
        Article article = articleMapper.getArticleById(id);
        article.setText(text);

        return articleMapper.updateArticle(article);
    }

    public int delete(String id) {
		logger.info("Service - Delete Id : " + id);

        //id에 해당하는 Article삭제
		return articleMapper.deleteArticle(id);
    }
}
