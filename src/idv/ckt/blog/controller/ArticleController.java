package idv.ckt.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import idv.ckt.blog.bo.ArticleBO;
import idv.ckt.blog.dto.Article;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticleController {
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable("id") long id) {
		Article article = ArticleBO.getArticleById(id);

		if (article == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(article);
	}

	@PostMapping("/articles")
	public ResponseEntity<Article> createArticle(@RequestBody Article request) {
		ArticleBO.createArticle(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId())
				.toUri();

		return ResponseEntity.created(location).body(request);
	}

	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> replaceArticle(@PathVariable("id") long id, @RequestBody Article request) {
		Article article = ArticleBO.getArticleById(id);

		if (article == null) {
			return ResponseEntity.notFound().build();
		}

		ArticleBO.replaceArticleById(id, request);
		return ResponseEntity.ok().body(article);
	}
}