package com.bl.base.backend.core.usecase;

import com.bl.base.backend.core.domain.Article;
import com.bl.base.backend.mapping.ArticleMapper;
import com.bl.base.backend.data.article.ArticleEntity;
import com.bl.base.backend.data.article.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCRUDService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    public ArticleMapper articleMapper;
    public Article getArticleByID(Long id){
        ArticleEntity articleEntity = articleRepository.findById(id).orElseGet(()-> null);
        if(articleEntity == null){
            throw new EntityNotFoundException("No entity with Id %d found.".formatted(id));
        }
        return articleMapper.toDomain(articleEntity);
    }

    public List<Article> getArticles(){
        List<ArticleEntity> articleEntities = Streamable.of(articleRepository.findAll()).toList();
        return articleMapper.toDomain(articleEntities);
    }

    public Article saveArticle(Article article){
        ArticleEntity articleEntity = articleRepository.save(articleMapper.toEntity(article));
        return articleMapper.toDomain(articleEntity);
    }
}
