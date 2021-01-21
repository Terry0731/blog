package idv.ckt.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idv.ckt.blog.bo.ArticleBO;
import idv.ckt.blog.dto.Article;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable("id") long id) {
		Article article = ArticleBO.getArticleById(id);
		
		if (article == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(article);
	}
}
