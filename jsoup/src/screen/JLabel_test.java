package screen;


import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import jsoup.JsoupCrawler;

public class JLabel_test extends JFrame {
	public JLabel_test() throws Exception {
		setTitle("JLabel Test");
		initComponents();
		setVisible(true);
	}

	private void initComponents() throws Exception {
		
		String[] s=new String[2];
		
		s[0]=new JsoupCrawler().getJsoupHTML§G§½("2330", 1);
		s[1]=new JsoupCrawler().getJsoupHTML§G§½("2002", 1);
		
		JLabel[] label = new JLabel[s.length];
		for(int i=0;i<s.length;i++){
			label[i]=new JLabel(s[i]);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.FlowLayout());
		
		for(int i=0;i<label.length;i++){
			getContentPane().add(label[i]);
		}
		
		setSize(800, 500);
		
	}

}