package demo;

import java.util.Arrays;

import jsoup.JsoupCrawler;

/**
 * �ܽd��Ƨ��
 * @author xie
 *
 */
public class demo1 {

	public static void main(String[] args) throws Exception {
		JsoupCrawler jsoupCrawlerUT=new JsoupCrawler();
		
		System.out.println("------------getJsoup���D----------------");
		
		String[] jsoup1=jsoupCrawlerUT.getJsoup���D();
		
		for(String jsoup:jsoup1){
			System.out.println(jsoup);
		}
		
		System.out.println("------------getJsoup���e----------------");
		
		String[] jsoup2=jsoupCrawlerUT.getJsoup���e("2300");
		
		for(String jsoup:jsoup2){
			System.out.println(jsoup);
		}
		
	}

}
