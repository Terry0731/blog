package idv.ckt.blog.bo;

import java.util.ArrayList;
import java.util.List;

import idv.ckt.blog.dto.Article;
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

	public static List<Article> getArticlesByKeyword(String keyword) {
		List<Article> articles = new ArrayList<>();

		try {
			for (int i = 0; i < 5; i++) {
				Article article = new Article();

				article.setId(i);
				article.setTitle("Story " + i);
				article.setContent("This is test article No." + i);
				article.setDate(TimeUtil.getCurrTimestamp());

				articles.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articles;
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
