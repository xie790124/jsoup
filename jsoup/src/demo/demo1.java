package demo;

import java.util.Arrays;

import jsoup.JsoupCrawler;

/**
 * 示範資料抓取
 * @author xie
 *
 */
public class demo1 {

	public static void main(String[] args) throws Exception {
		JsoupCrawler jsoupCrawlerUT=new JsoupCrawler();
		
		System.out.println("------------getJsoup標題----------------");
		
		String[] jsoup1=jsoupCrawlerUT.getJsoup標題();
		
		for(String jsoup:jsoup1){
			System.out.println(jsoup);
		}
		
		System.out.println("------------getJsoup內容----------------");
		
		String[] jsoup2=jsoupCrawlerUT.getJsoup內容("2300");
		
		for(String jsoup:jsoup2){
			System.out.println(jsoup);
		}
		
	}

}
