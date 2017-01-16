package kr.park.nhnpre.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

import kr.park.nhnpre.artifacts.Article;

@Component
public interface ArticleMapper {
	@SelectProvider(type=Provider.class, method="getArticleList")
	List<Article> getArticleList();
	
	@SelectProvider(type=Provider.class, method="getArticleById")
	Article getArticleById(String id);
	
	@SelectProvider(type=Provider.class, method="getArticlePasswordById")
	String getArticlePasswordById(String id);
	
	@InsertProvider(type=Provider.class, method="addArticle")
	int addArticle(Article article);

	@UpdateProvider(type=Provider.class, method="updateArticle")
	int updateArticle(Article article);
	
	@DeleteProvider(type=Provider.class, method="deleteArticle")
	int deleteArticle(String id);

	//
	public static class Provider {
		public static String getArticleList() {
			BEGIN();
			SELECT("*");
			FROM("`article`");
			ORDER_BY("add_time DESC");
			
			return SQL();
		}
		
		public static String getArticleById(String id) {
			BEGIN();
			SELECT("*");
			FROM("`article`");
			WHERE("id = #{id}");
			
			return SQL();
		}
		
		public static String getArticlePasswordById(String id) {
			BEGIN();
			SELECT("password");
			FROM("`article`");
			WHERE("id = #{id}");
			
			return SQL();
		}
		
		public static String addArticle(Article article){
			BEGIN();
			INSERT_INTO("`article`");
			VALUES("email", "#{email}");
			VALUES("password", "#{password}");
			VALUES("text", "#{text}");
			VALUES("add_time", "now()");
			
			return SQL();
		}
		
		public static String updateArticle(Article article) {
			BEGIN();
			UPDATE("`article`");
			SET("text = #{text}");
			SET("modify_time = now()");
			WHERE("id = #{id}");
			
			return SQL();
		}
		
		public static String deleteArticle(String id){
			BEGIN();
			DELETE_FROM("`article`");
			WHERE("id = #{id}");
			
			return SQL();
		};
		
	}
}
