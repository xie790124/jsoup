package txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class firm_id {
	/**
	 * ㏃¾⒡┳ず쩘많
	 * @return
	 */
	public ArrayList get¾켹ぱ�ゥN많(){
		ArrayList list=new ArrayList();
		ArrayList list2=new ArrayList();
		try {
			
			String path=System.getProperty("user.dir");

			FileReader fr = new FileReader(path+"/json/json.txt");

			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				list.add(br.readLine());
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		for(int i=0;i<list.size();i++){
			if((i%2)!=0){
				String[] s2=list.get(i).toString().split(",");
				for(int i2=0;i2<s2.length;i2++){
					String[] s3=s2[i2].split(" ");
					list2.add(s3[0]);
				}
			}
		}
		return list2;
	}
	
	/**
	 * ㏃¾⒡┳ず쩘많
	 * @return
	 */
	public ArrayList get¾켹れ쯮ㅖぱ�ゥN많ㅞㅍ쩻(){
		ArrayList list=new ArrayList();
		ArrayList list2=new ArrayList();
		try {
			
			String path=System.getProperty("user.dir");

			FileReader fr = new FileReader(path+"/json/json.txt");

			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				list.add(br.readLine());
			}
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		for(int i=0;i<list.size();i++){
			if((i%2)!=0){
				String[] s2=list.get(i).toString().split(",");
				for(int i2=0;i2<s2.length;i2++){
					list2.add(s2[i2]);
				}
			}
		}
		return list2;
	}
	
	
}
