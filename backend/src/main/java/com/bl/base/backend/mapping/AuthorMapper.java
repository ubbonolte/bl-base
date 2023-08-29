package com.bl.base.backend.mapping;

import com.bl.base.backend.core.domain.Author;
import com.bl.base.backend.data.author.AuthorEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ArticleMapper.class)
public interface AuthorMapper {
    AuthorEntity toEntity(Author author);
    Author toDomain(AuthorEntity authorEntity);

}
