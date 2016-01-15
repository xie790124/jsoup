package screen;


import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import jsoup.JsoupCrawler;

public class JLabel_test extends JFrame {
	public JLabel_test() {
		setTitle("JLabel with HTML");
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel label = null;
		try {
			label = new JLabel(new JsoupCrawler().getJsoupHTML§G§½("2300", 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		container.add(label);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JLabel_test().setVisible(true);
			}
		});
	}
}