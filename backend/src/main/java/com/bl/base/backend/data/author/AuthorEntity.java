package com.bl.base.backend.data.author;

import com.bl.base.backend.data.article.ArticleEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "author")
    private Set<ArticleEntity> articles = new HashSet<>();

    public void addArticle(ArticleEntity article){
        if(this.articles == null) {
            this.articles = new HashSet<>();
        }
        if(!this.articles.contains(article)){
            this.articles.add(article);
            article.setAuthor(this);
        }
    }
}
