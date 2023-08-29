package com.bl.base.backend.core.domain;

import com.bl.base.backend.data.article.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private transient Set<Article> articles;

    public void addArticle(Article article){
        if(this.articles == null) {
            this.articles = new HashSet<>();
        }
        this.articles.add(article);
        article.setAuthor(this);
    }
}
