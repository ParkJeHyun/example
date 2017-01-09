package kr.park.nhnpre.dao;

import kr.park.nhnpre.artifacts.Article;

import java.util.List;

/**
 * Created by Administrator on 2016-12-19.
 */
public interface ArticleDao {
    List<Article> getAllArticle();

    Article getArticleById(String id);

    String getPasswordById(String id);

    Integer insertArticle(Article article);

    Integer modifyArticle(Article article);

    Integer deleteArticleById(String id);
}
