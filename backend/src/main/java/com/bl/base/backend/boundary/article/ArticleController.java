package com.bl.base.backend.boundary.article;

import com.bl.base.backend.core.domain.Article;
import com.bl.base.backend.core.usecase.ArticleCRUDService;
import com.bl.base.backend.data.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleCRUDService articleCRUDService;

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable long id){
        return articleCRUDService.getArticleByID(id);
    }
    @GetMapping()
    public List<Article> getArticles(){
        return articleCRUDService.getArticles();
    }

    @PostMapping()
    public Article postArticle(@RequestBody Article article){
        return articleCRUDService.saveArticle(article);
    }

    @PutMapping
    public Article putArticle(@RequestBody Article article){
        return articleCRUDService.saveArticle(article);
    }
}
