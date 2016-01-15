package screen;


import java.awt.*;
import java.awt.event.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.table.*;

import txt.firm_id;
import jsoup.*;

public class JTable_test {
	JFrame f;
	JTable jt;
	java.util.Timer timer = new java.util.Timer();
	static MyTableModel mtm = null;
	static Object[][] data=new Object[1][13];
	ArrayList list;

	
	public JTable_test() throws Exception {
		//Setup JFrame
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		f=new JFrame("JTable Test");
		f.setSize(800,600); 
		f.setLocationRelativeTo(null); 
		Container cp=f.getContentPane();
		//cp.setLayout(null);

		list=new firm_id().get取得股市代號();
		data=new Object[list.size()][13];
		
		ArrayList list2=new firm_id().get取得初始化股市代號及公司();
		for(int i=0;i<list.size();i++){
			data[i]=new Object[]{list2.get(i),"--","--","--","--","--","--","--","--","--","--","--","--"};
		}
		
		//Build Elements
		mtm = new MyTableModel();
		jt=new JTable(mtm);
		jt.setPreferredScrollableViewportSize(new Dimension(600,600));
		cp.add(new JScrollPane(jt),BorderLayout.CENTER);
		f.setVisible(true); 

		//Close JFrame        
		f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
		f.addWindowListener(new WindowHandler(f,timer));

		timer.scheduleAtFixedRate(new SysTimeRefresher(jt,list), 5000, 60000);
	}
}

class SysTimeRefresher extends TimerTask {
	JTable jt;
	ArrayList list;

	public SysTimeRefresher(JTable jt,ArrayList list) {
		this.jt=jt;
		this.list=list;
	}
	
	
	@Override
	synchronized public void run() {

		for(int i=0;i<list.size();i++){
			final int i2=i;
			new Thread(new Runnable() {
				public void run() {
					try {
						JTable_test.data[i2]=new JsoupCrawler().getJsoup內容(list.get(i2)+"");
						JTable_test.mtm.fireTableDataChanged();
					} catch (SocketTimeoutException e) {
						System.out.println("連線超過 3 秒");
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("等候1秒");
					}
				}}).start();

		}
	}}


class WindowHandler extends WindowAdapter {
	JFrame f;
	java.util.Timer timer;
	public WindowHandler(JFrame f,java.util.Timer timer) {
		this.f=f;
		this.timer=timer;
	}
	public void windowClosing(WindowEvent e) {
		int result=JOptionPane.showConfirmDialog(f,
				"確定要結束程式嗎?",
				"確認訊息",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (result==JOptionPane.YES_OPTION) {
			timer.cancel();
			System.exit(0);
		}
	}
}


class MyTableModel extends AbstractTableModel {
	String[] columns;
	MyTableModel() throws Exception {
		columns=new JsoupCrawler().getJsoup標題();
	}

	public int getColumnCount() {return columns.length;}
	public int getRowCount() {return JTable_test.data.length;}
	public Object getValueAt(int row, int col) {return JTable_test.data[row][col];}
	public String getColumnName(int col) {return columns[col];} 
	public Class getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	public boolean isCellEditable(int row,int col) {return true;}
	public void setValueAt(Object value,int row,int col) {
		fireTableCellUpdated(row,col);
	}
} 