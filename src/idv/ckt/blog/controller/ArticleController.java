package idv.ckt.blog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import idv.ckt.blog.bo.ArticleBO;
import idv.ckt.blog.dto.Article;
import idv.ckt.blog.params.ArticleQueryParameter;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticleController {
	@Autowired
	private ArticleBO articleBO;

	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable("id") long id) {
		Article article = articleBO.getArticle(id);
		return ResponseEntity.ok(article);
	}

	@PostMapping
	public ResponseEntity<Article> createArticle(@RequestBody Article request) {
		Article article = articleBO.createArticle(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId())
				.toUri();
		return ResponseEntity.created(location).body(article);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> replaceArticle(@PathVariable("id") long id, @RequestBody Article request) {
		Article article = articleBO.replaceArticle(id, request);
		return ResponseEntity.ok(article);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id) {
		articleBO.deleteArticle(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Article>> getArticles(@ModelAttribute ArticleQueryParameter param) {
		List<Article> articles = articleBO.getArticles(param);
		return ResponseEntity.ok(articles);
	}
}
