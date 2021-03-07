package idv.ckt.blog.bo;

import java.util.ArrayList;
import java.util.List;

import idv.ckt.blog.dto.Article;
import idv.ckt.blog.params.ArticleQueryParameter;
import idv.ckt.blog.utils.TimeUtil;

public class ArticleBO {
	public static Article getArticleById(long id) {
		try {
			Article article = new Article();

			article.setId(id);
			article.setTitle("Story");
			article.setContent("This is a test article.");
			article.setDate(TimeUtil.getCurrTimestamp());

			return article;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Article> getArticlesByParam(ArticleQueryParameter param) {
		try {
			List<Article> articles = new ArrayList<>();

			String keyword = param.getKeyword();
			String orderBy = param.getOrderBy();
			String sortRule = param.getSortRule();

			for (int i = 0; i < 5; i++) {
				Article article = new Article();

				article.setId(i);
				article.setTitle(keyword);
				article.setContent(orderBy + "-" + sortRule);
				article.setDate(TimeUtil.getCurrTimestamp());

				articles.add(article);
			}

			return articles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void createArticle(Article article) {
		try {
			article.setId(123);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void replaceArticleById(long id, Article article) {
		try {
			article.setTitle("Story");
			article.setContent("This is a test article.");
			article.setDate(TimeUtil.getCurrTimestamp());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteArticleById(long id) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
