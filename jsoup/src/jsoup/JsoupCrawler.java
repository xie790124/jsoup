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
 * �������δ��սd��<p>
 * �Q��yahoo�Ѳ������եؼ�<p>
 * @author xie
 *
 */
public class JsoupCrawler {

	public static void main(String[] args)  throws Exception{
		//URL �Hyahoo�Ѳ�������
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s=2002");

		/*
		 * �V�������A�o�X�ШD�A�ñN�^�����R��document�C
		 * �Ĥ@�ӰѼƬO�G�ШD��m�PQueryString�C
		 * �ĤG�ӰѼƬO�G�s�u�ɶ�(�@��)�A�b���w�ɶ����Y�L�^���h�|��XIOException
		 */       
		Document doc = Jsoup.parse(url, 3000);


		/**
		 * ���^��center�U�Ҧ���table
		 */
		Elements tables = doc.select("center>table");


		System.out.println("------------------------�L�X tables �Ҧ����e--------------------------");    
		/**
		 * ���F���@�P���覡�ӳv�@�� �o���󤺳�����ơA
		 * �z�i�H���@��Iterator�󪫥󤺳��i�榬���A
		 * ����Ǧ^Iterator����A
		 * �z�L��Iterator�ӳv�@���o���󤺳���ơC
		 */
		Iterator iterator;



		/**
		 * 	�L�X tables ���󤺮e�A
		 *  ����S������
		 */
		for(Element table : tables)
		{
			/**
			 * ���o html <td> ����  ���e
			 */
			iterator = table.select("td").iterator();           

			while(iterator.hasNext()){
				System.out.println("data" + ": " + iterator.next().toString());
			}
		}

		System.out.println("------------------------�����Y--------------------------");    
		Element  table;



		/**
		 * �����Y
		 */
		table = tables.get(1).select("table").get(0);
		iterator = table.select("th").iterator();
		while(iterator.hasNext()){    
			System.out.println("�����Y" + " : " + iterator.next().toString());
		}

		System.out.println("------------------------�����e --------------------------");    

		/**
		 * �����e        
		 * ������1��table
		 */
		table = tables.get(1).select("table").get(1);

		/**
		 * ���o html <td> ����  ���e
		 */
		iterator = table.select("td").iterator();       
		while(iterator.hasNext()){      
			System.out.println("�����e" + " : " + iterator.next().toString());
		}
	}

	/**
	 * 
	 * @param id �ѥ��N��
	 * @param v ���o�ĴX�ӧG��
	 * @throws Exception
	 */
	public String getJsoupHTML�G��(String id,int v) throws Exception{
		//URL �Hyahoo�Ѳ�������
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s="+id);

		String[] html���e=new String[50];
		int i=0;
		/*
		 * �V�������A�o�X�ШD�A�ñN�^�����R��document�C
		 * �Ĥ@�ӰѼƬO�G�ШD��m�PQueryString�C
		 * �ĤG�ӰѼƬO�G�s�u�ɶ�(�@��)�A�b���w�ɶ����Y�L�^���h�|��XIOException
		 */       
		Document doc = Jsoup.parse(url, 3000);


		/**
		 * ���^��center�U�Ҧ���table
		 */
		Elements tables = doc.select("center");


		System.out.println("------------------------�L�X tables �Ҧ����e--------------------------");    
		/**
		 * ���F���@�P���覡�ӳv�@�� �o���󤺳�����ơA
		 * �z�i�H���@��Iterator�󪫥󤺳��i�榬���A
		 * ����Ǧ^Iterator����A
		 * �z�L��Iterator�ӳv�@���o���󤺳���ơC
		 */
		Iterator iterator;

		/**
		 * 	�L�X tables ���󤺮e�A
		 *  ����S������
		 */
		for(Element table : tables)
		{
			/**
			 * ���o html <td> ����  ���e
			 */
			iterator = table.select("tbody").iterator();           
			while(iterator.hasNext()){
				
				html���e[i]="<html>" + iterator.next().toString() + "</html>" ;
				System.out.println(i+"\ndata" + html���e[i]);
				i++;
			}
		}

		return html���e[v];
	}




	/**
	 * �����Y
	 * @return
	 * @throws Exception
	 */
	public String[] getJsoup���D()  throws Exception{
		String[] s=new String[13];
		int i=0;
		//URL �Hyahoo�Ѳ�������
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s=2002");

		/*
		 * �V�������A�o�X�ШD�A�ñN�^�����R��document�C
		 * �Ĥ@�ӰѼƬO�G�ШD��m�PQueryString�C
		 * �ĤG�ӰѼƬO�G�s�u�ɶ�(�@��)�A�b���w�ɶ����Y�L�^���h�|��XIOException
		 */       
		Document doc = Jsoup.parse(url, 3000);

		//���^��center�U�Ҧ���table
		Elements tables = doc.select("center>table");

		//�����Y
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
	 *  �����e
	 * @param id �ѥ��N��
	 * @return ���e
	 * @throws Exception
	 */
	public String[] getJsoup���e(String id)  throws Exception{
		String[] s=new String[13];
		int i=0;
		//URL �Hyahoo�Ѳ�������
		URL url = new URL("http://tw.stock.yahoo.com/q/q?s="+id);

		/*
		 * �V�������A�o�X�ШD�A�ñN�^�����R��document�C
		 * �Ĥ@�ӰѼƬO�G�ШD��m�PQueryString�C
		 * �ĤG�ӰѼƬO�G�s�u�ɶ�(�@��)�A�b���w�ɶ����Y�L�^���h�|��XIOException
		 */       
		Document doc = Jsoup.parse(url, 3000);

		//���^��center�U�Ҧ���table
		Elements tables = doc.select("center>table");

		//�����e        
		//������1��table
		Element table = tables.get(1).select("table").get(1);

		//get td Iterator
		Iterator iterator = table.select("td").iterator(); 

		while(iterator.hasNext()){
			s[i]="<html>" + iterator.next().toString() + "</html>";
			i++;
		}
		s[0]=s[0].replace("�[����զX", "");


		return s;         
	}

}
