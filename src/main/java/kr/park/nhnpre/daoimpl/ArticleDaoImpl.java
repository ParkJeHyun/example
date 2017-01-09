package kr.park.nhnpre.daoimpl;

import kr.park.nhnpre.artifacts.Article;
import kr.park.nhnpre.dao.ArticleDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016-12-19.
 */
@Repository("ArticleDao")
public class ArticleDaoImpl implements ArticleDao {
	private static final Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Article> getAllArticle() {
		// DB에 있는 모든 Article 불러오기
		List<Article> articles = sqlSession.selectList("getArticle");

		logger.info("DaoImpl - getAll Size : " + articles.size());

		return articles;
	}

	public Article getArticleById(String id) {
		// ID에 해당하는 Article 불러오기
		Article article = sqlSession.selectOne("getArticleById", id);

		logger.info("DaoImpl - get Id : " + article.getId());

		return article;
	}

	public String getPasswordById(String id) {
		// ID에 해당하는 Article의 비밀번호 불러오기
		String password = sqlSession.selectOne("getPasswordById", id);

		logger.info("DaoImpl - getPassword Password : " + password);

		return password;
	}

	public Integer insertArticle(Article article) {
		// Article 추가
		logger.info("DaoImpl - insert ");

		return sqlSession.insert("insertArticle", article);
	}

	public Integer modifyArticle(Article article) {
		// Article 변경
		logger.info("DaoImpl - modify Id : " + article.getId());

		return sqlSession.update("modifyArticle", article);
	}

	public Integer deleteArticleById(String id) {
		// ID에 해당하는 Article 삭제
		logger.info("DaoImpl - delete Id : " + id);

		return sqlSession.delete("removeArticleById", id);
	}
}
