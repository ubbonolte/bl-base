package com.bl.base.backend.boundary.article;

import com.bl.base.backend.core.domain.Article;
import com.bl.base.backend.data.article.ArticleEntity;
import com.bl.base.backend.data.article.ArticleRepository;
import com.bl.base.backend.data.author.AuthorRepository;
import com.bl.base.backend.mapping.AuthorMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static com.bl.base.backend.testdata.ArticleTestData.TEST_ARTICLE_1;
import static com.bl.base.backend.testdata.AuthorTestData.TEST_AUTHOR_1;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class ArticleCRUDIT {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public static void setUp(@Autowired AuthorRepository authorRepository, @Autowired AuthorMapper authorMapper){
        authorRepository.save(authorMapper.toEntity(TEST_AUTHOR_1));
    }

    @AfterAll
    public static void cleanUp(@Autowired AuthorRepository authorRepository, @Autowired AuthorMapper authorMapper, @Autowired ArticleRepository articleRepository){
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(1L);
        articleRepository.delete(articleEntity);
        authorRepository.delete(authorMapper.toEntity(TEST_AUTHOR_1));
    }

    @Test
    public void test_01_shouldReturnEmptyList(){
        Article[] articles = when().get("http://localhost:"+port+"/api/articles").as(Article[].class);
        assertThat(articles).isEmpty();
    }

    @Test
    public void test_02_shouldReturn404(){
        when().get("http://localhost:"+port+"/api/articles/1").then().statusCode(404);
    }

    @Test
    public void test_03_shouldReturnEntityWithIDAnd200(){
        Article article = given()
                .body(TEST_ARTICLE_1)
                .contentType("application/json")
                .when()
                .post("http://localhost:"+port+"/api/articles").then().statusCode(200).extract().as(Article.class);
        assertThat(article.getId()).isEqualTo(1L);
        article.setId(null);
        assertThat(article).isEqualTo(TEST_ARTICLE_1);
    }

    @Test
    public void test_04_shouldReturn200AndArticle(){
        Article article = when().get("http://localhost:"+port+"/api/articles/1").then().statusCode(200).extract().as(Article.class);
        assertThat(article.getId()).isEqualTo(1L);
        article.setId(null);
        assertThat(article).isEqualTo(TEST_ARTICLE_1);
    }


}
