package com.bl.base.backend.testdata;

import com.bl.base.backend.core.domain.Article;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static com.bl.base.backend.testdata.AuthorTestData.TEST_AUTHOR_1;
import static com.bl.base.backend.testdata.LoremIpsum.LOREM_IPSUM_8000;

public class ArticleTestData {
    public static final Article TEST_ARTICLE_1 = new Article(
            null,
            "Test Artikel 1",
            TEST_AUTHOR_1,
            OffsetDateTime.of(2023,4,10,12,0,0, 0, ZoneOffset.UTC),
            LOREM_IPSUM_8000
    );
}
