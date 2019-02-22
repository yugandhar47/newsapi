package com.example.news.newsPro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.news.newsPro.model.Article;
import com.example.news.newsPro.model.Source;
import com.example.news.newsPro.repo.*;
import com.example.news.newsPro.pojo.*;

@Service
public class Insert {
	
	@Autowired
	ArticleRepo ar;
	
	@Autowired
	SourceRepo sr;
	
	@Autowired
	MD5hash md5;
	
	protected boolean insertDB(NewsApiResponse newsapiresponse) {
		com.example.news.newsPro.model.Source sourceModel;
		com.example.news.newsPro.model.Article articleModel;
		boolean flag=true;
		try {
			List<com.example.news.newsPro.pojo.Article> listArticle= newsapiresponse.getArticles();
			Source s;
			Article a;
			for(com.example.news.newsPro.pojo.Article i:listArticle) {
				String sourceName = i.getSource().getName();
				if(sourceName.equals(null) || sourceName.equals("")) {
					sourceName = "Unknown";
				}
				List<Source> listSource = sr.findByName(sourceName);
				if(listSource==null || listSource.size() ==0) {
					s=new Source();
					s.setName(sourceName);
					sr.save(s);
				}
				else {
					s = listSource.get(0);
				}
				//int sourceId = s.getId();
				a = new Article();
				a.setId(md5.getMd5(i.getUrl()));
				a.setSourceid(s);
				a.setAuthor(i.getAuthor());
				a.setTitle(i.getTitle());
				a.setDescription(i.getDescription());
				a.setUrl(i.getUrl());
				a.setUrl_to_image(i.getUrlToImage());
				a.setPublished_at(i.getPublishedAt());
				a.setContent(i.getContent());
				ar.save(a);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			flag=false;
		}
		return flag;
	}

}
