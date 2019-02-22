package com.example.news.newsPro.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.news.newsPro.model.Article;

@Repository
public interface ArticleRepo extends CrudRepository<Article, String>{

}
