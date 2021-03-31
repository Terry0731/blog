package idv.ckt.blog.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import idv.ckt.blog.dto.Article;
import idv.ckt.blog.params.ArticleQueryParameter;

@Repository
public class ArticleDAO {
	public Article insert(Article article) {
		return article;
	}
	
	public Article replace(long id, Article article) {
		return article;
	}
	
	public void delete(long id) {
		
	}
	
	public Optional<Article> find(long id) {
		return null;
	}
	
	public List<Article> find(ArticleQueryParameter param) {
		return null;
	}
}
