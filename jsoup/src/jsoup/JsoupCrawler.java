package jsoup;

import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Jsoup<p>
 * 網路爬蟲測試範例<p>
 * 利用yahoo股票為測試目標<p>
 * @author xie
 *
 */
public class JsoupCrawler {

	public static void main(String[] args)  throws Exception{
		//URL 以yahoo股票為測試
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s=2002");

		/*
		 * 向網頁伺服發出請求，並將回應分析成document。
		 * 第一個參數是：請求位置與QueryString。
		 * 第二個參數是：連線時間(毫秒)，在指定時間內若無回應則會丟出IOException
		 */       
		Document doc = Jsoup.parse(url, 3000);


		/**
		 * 取回所center下所有的table
		 */
		Elements tables = doc.select("center>table");


		System.out.println("------------------------印出 tables 所有內容--------------------------");    
		/**
		 * 為了有一致的方式來逐一取 得物件內部的資料，
		 * 您可以讓一個Iterator於物件內部進行收集，
		 * 之後傳回Iterator物件，
		 * 透過該Iterator來逐一取得物件內部資料。
		 */
		Iterator iterator;



		/**
		 * 	印出 tables 物件內容，
		 *  取到沒有為止
		 */
		for(Element table : tables)
		{
			/**
			 * 取得 html <td> 元素  內容
			 */
			iterator = table.select("td").iterator();           

			while(iterator.hasNext()){
				System.out.println("data" + ": " + iterator.next().toString());
			}
		}

		System.out.println("------------------------取標頭--------------------------");    
		Element  table;



		/**
		 * 取標頭
		 */
		table = tables.get(1).select("table").get(0);
		iterator = table.select("th").iterator();
		while(iterator.hasNext()){    
			System.out.println("取標頭" + " : " + iterator.next().toString());
		}

		System.out.println("------------------------取內容 --------------------------");    

		/**
		 * 取內容        
		 * 取索引1的table
		 */
		table = tables.get(1).select("table").get(1);

		/**
		 * 取得 html <td> 元素  內容
		 */
		iterator = table.select("td").iterator();       
		while(iterator.hasNext()){      
			System.out.println("取內容" + " : " + iterator.next().toString());
		}
	}

	/**
	 * 
	 * @param id 股市代號
	 * @param v 取得第幾個佈局
	 * @throws Exception
	 */
	public String getJsoupHTML佈局(String id,int v) throws Exception{
		//URL 以yahoo股票為測試
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s="+id);

		String[] html內容=new String[50];
		int i=0;
		/*
		 * 向網頁伺服發出請求，並將回應分析成document。
		 * 第一個參數是：請求位置與QueryString。
		 * 第二個參數是：連線時間(毫秒)，在指定時間內若無回應則會丟出IOException
		 */       
		Document doc = Jsoup.parse(url, 3000);


		/**
		 * 取回所center下所有的table
		 */
		Elements tables = doc.select("center");


		System.out.println("------------------------印出 tables 所有內容--------------------------");    
		/**
		 * 為了有一致的方式來逐一取 得物件內部的資料，
		 * 您可以讓一個Iterator於物件內部進行收集，
		 * 之後傳回Iterator物件，
		 * 透過該Iterator來逐一取得物件內部資料。
		 */
		Iterator iterator;

		/**
		 * 	印出 tables 物件內容，
		 *  取到沒有為止
		 */
		for(Element table : tables)
		{
			/**
			 * 取得 html <td> 元素  內容
			 */
			iterator = table.select("tbody").iterator();           
			while(iterator.hasNext()){
				
				html內容[i]="<html>" + iterator.next().toString() + "</html>" ;
				System.out.println(i+"\ndata" + html內容[i]);
				i++;
			}
		}

		return html內容[v];
	}




	/**
	 * 取標頭
	 * @return
	 * @throws Exception
	 */
	public String[] getJsoup標題()  throws Exception{
		String[] s=new String[13];
		int i=0;
		//URL 以yahoo股票為測試
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s=2002");

		/*
		 * 向網頁伺服發出請求，並將回應分析成document。
		 * 第一個參數是：請求位置與QueryString。
		 * 第二個參數是：連線時間(毫秒)，在指定時間內若無回應則會丟出IOException
		 */       
		Document doc = Jsoup.parse(url, 3000);

		//取回所center下所有的table
		Elements tables = doc.select("center>table");

		//取標頭
		Element table = tables.get(1).select("table").get(0);
		Iterator iterator = table.select("th").iterator();       
		while(iterator.hasNext())
		{               
			s[i]="<html>"+ iterator.next().toString()+"</html>";
			i++;
		} 
		return s;         
	}


	/**
	 *  取內容
	 * @param id 股市代號
	 * @return 內容
	 * @throws Exception
	 */
	public String[] getJsoup內容(String id)  throws Exception{
		String[] s=new String[13];
		int i=0;
		//URL 以yahoo股票為測試
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s="+id);

		/*
		 * 向網頁伺服發出請求，並將回應分析成document。
		 * 第一個參數是：請求位置與QueryString。
		 * 第二個參數是：連線時間(毫秒)，在指定時間內若無回應則會丟出IOException
		 */       
		Document doc = Jsoup.parse(url, 3000);

		//取回所center下所有的table
		Elements tables = doc.select("center>table");

		//取內容        
		//取索引1的table
		Element table = tables.get(1).select("table").get(1);

		//get td Iterator
		Iterator iterator = table.select("td").iterator(); 

		while(iterator.hasNext()){
			s[i]="<html>" + iterator.next().toString() + "</html>";
			i++;
		}
		s[0]=s[0].replace("加到投資組合", "");


		return s;         
	}

}
