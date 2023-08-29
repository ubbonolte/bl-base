package com.bl.base.backend.mapping;

import com.bl.base.backend.core.domain.Article;
import com.bl.base.backend.core.domain.Author;
import com.bl.base.backend.data.article.ArticleEntity;
import com.bl.base.backend.data.author.AuthorEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    Article toDomain(ArticleEntity articleEntity);
    List<Article> toDomain(List<ArticleEntity> articleEntities);

    ArticleEntity toEntity(Article article);
    List<ArticleEntity> toEntity(List<Article> articles);

    @Mapping(target="articles", ignore = true)
    AuthorEntity toEntity(Author author);
    @Mapping(target="articles", ignore = true)
    Author toDomain(AuthorEntity authorEntity);



}
