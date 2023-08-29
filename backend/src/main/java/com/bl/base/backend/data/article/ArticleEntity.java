package com.bl.base.backend.data.article;

import com.bl.base.backend.data.author.AuthorEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "article")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorEntity author;

    @Column(name = "publication_date")
    private OffsetDateTime publicationDate;

    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    public void setAuthor(AuthorEntity author){
        this.author = author;
        author.addArticle(this);
    }
}