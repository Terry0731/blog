package idv.ckt.blog.bo;

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
}
