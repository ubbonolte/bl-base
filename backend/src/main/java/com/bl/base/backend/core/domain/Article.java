package com.bl.base.backend.core.domain;

import com.bl.base.backend.data.author.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private Author author;
    private OffsetDateTime publicationDate;
    private String content;

    public void setAuthor(Author author){
        this.author = author;
        author.addArticle(this);
    }
}
