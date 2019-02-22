package com.example.news.newsPro.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.news.newsPro.pojo.*;
import com.example.news.newsPro.repo.ArticleRepo;
import com.example.news.newsPro.repo.SourceRepo;
import com.example.news.newsPro.model.*;
import com.example.news.newsPro.model.Article;
@Controller
@RequestMapping(path = "/news")
public class ShowNewsController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Insert insert;
	
	@Autowired
	ArticleRepo articleRepo;
	
	@Autowired
	SourceRepo sourceRepo;
	
	Map <String, NewsApiResponse> hm = new HashMap<String, NewsApiResponse>();

	@RequestMapping(path = "/show", method = RequestMethod.GET)
	@ResponseBody
	public NewsApiResponse showNews() {
		String uri = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		NewsApiResponse newsapi = restTemplate.getForObject(uri, NewsApiResponse.class);
		
		return newsapi;
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	@ResponseBody
	public NewsApiResponse searchNews(@RequestParam String term) {
		/*String uri = "https://newsapi.org/v2/everything?q="+term+"&sortBy=popularity&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		NewsApiResponse string = restTemplate.getForObject(uri, NewsApiResponse.class);*/
		
		String uri = "https://newsapi.org/v2/everything?q="+term+"&sortBy=popularity&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		NewsApiResponse string;
		if(hm.containsKey(uri)) {
			string = hm.get(uri);
			System.out.println("contains"+term);
		}
		else {
			string = restTemplate.getForObject(uri, NewsApiResponse.class);
			hm.put(uri,string);
		}
		
		return string;
	}
	
	@RequestMapping(path = "/advsearch", method = RequestMethod.GET)
	@ResponseBody
	public NewsApiResponse advsearchNews(@RequestParam String type, @RequestParam String term) {
		//country=us
		//category=business
		//sortBy=publishedAt, sortBy=popularity
		//sources=techcrunch
		//domains=wsj.com
		
		String uri = "https://newsapi.org/v2/everything?"+type+"="+term+"&sortBy=date&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		NewsApiResponse string = restTemplate.getForObject(uri, NewsApiResponse.class);
		
		
		return string;
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.GET)
	@ResponseBody
	public boolean saveDBNews() {
		String uri = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		NewsApiResponse string = restTemplate.getForObject(uri, NewsApiResponse.class);
		boolean status = insert.insertDB(string);
		return status;
	}
	
	@RequestMapping(path = "/showDB")
	@ResponseBody
	public List<Article> showNewsfromDB() {
		//StringBuffer retBuf = new StringBuffer();
		List<Article> userArticle = (List<Article>) articleRepo.findAll();
		
		//String uri = "https://newsapi.org/v2/top-headlines?country=us&apiKey=7268c92df6294578bd4daf9c30c32fcb";
		//NewsApiResponse newsapi = restTemplate.getForObject(uri, NewsApiResponse.class);
		System.out.println(userArticle);
		return userArticle;
	}
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

}
