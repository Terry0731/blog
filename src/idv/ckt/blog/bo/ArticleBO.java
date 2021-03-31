package idv.ckt.blog.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.ckt.blog.dao.ArticleDAO;
import idv.ckt.blog.dto.Article;
import idv.ckt.blog.exception.ConflictException;
import idv.ckt.blog.exception.NotFoundException;
import idv.ckt.blog.params.ArticleQueryParameter;

@Service
public class ArticleBO {
	@Autowired
	private ArticleDAO articleDAO;

	public Article createArticle(Article article) {
		boolean isIdDuplicated = articleDAO.find(article.getId()).isPresent();

		if (isIdDuplicated) {
			throw new ConflictException("The id of article is duplicated.");
		}

		return articleDAO.insert(article);
	}

	public Article getArticle(long id) {
		return articleDAO.find(id).orElseThrow(() -> new NotFoundException("Can't find article."));
	}

	public Article replaceArticle(long id, Article newArticle) {
		Article oldArticle = getArticle(id);
		return articleDAO.replace(oldArticle.getId(), newArticle);
	}

	public void deleteArticle(long id) {
		Article article = getArticle(id);
		articleDAO.delete(article.getId());
	}

	public List<Article> getArticles(ArticleQueryParameter param) {
		return articleDAO.find(param);
	}
}
