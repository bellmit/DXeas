package com.kingdee.eas.custom.commld;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.eas.ep.client.editor.kdtable.KDTTableView;

public class RobotUtils {

	// shift+ ����
	public static void keyPressWithShift(Robot r, int key) {
		//		����Ч�Ľ����ʽ
		//		Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false);

		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyRelease(KeyEvent.VK_SHIFT);
		//		�ӳ�1s
		//		r.delay(1000);
	}

	// ctrl+ ����
	public static void keyPressWithCtrl(Robot r, int key) {
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	// alt+ ����
	public static void keyPressWithAlt(Robot r, int key) {
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyRelease(KeyEvent.VK_ALT);
	}
	//ctrl+alt ����
	public static void keyPressWithCtrlAlt(Robot r,int key){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_CONTROL);
	}

	//shift+alt ����
	public static void keyPressWithShiftAlt(Robot r,int key){
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SHIFT);
	}

	//ctrl+shift ����
	public static void keyPressWithCtrlShift(Robot r,int key){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(key);
		r.keyRelease(key);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_CONTROL);
	}

	//��ӡ���ַ���
	public static void keyPressString(Robot r, String str){
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//��ȡ���а�
		Transferable tText = new StringSelection(str);
		clip.setContents(tText, null); //���ü��а�����
		keyPressWithCtrl(r, KeyEvent.VK_V);//ճ��
	}
	//���� ����
	public static void keyPress(Robot r,int key){
		r.keyPress(key);
		r.keyRelease(key);
	}

	/**
	 * ��ť���enter�¼������������
	 * @param confirm
	 */
	public static void kdButtonAddEnterEvent(final KDButton confirm){
		confirm.addKeyListener(new KeyAdapter(){//����enter�¼�  ȷ��
			public void keyPressed(KeyEvent e){
				if(e.getKeyText(e.getKeyCode()).compareToIgnoreCase("Enter")==0){
					confirm.doClick();
				}
			}
		});
	}


	/**
	 * ��¼ģ������
	 * @param table
	 * @param oldValue
	 * @param newValue
	 * @param e
	 */
	public static void kdtTableInput(KDTable table,Object oldValue,Object newValue,KDTEditEvent e){
		KDTEditEvent kdte = new KDTEditEvent(table, oldValue,newValue , e.getRowIndex(), table.getColumnIndex("qty"), false, 1);  
		Object[] listeners = table.getListenerList().getListenerList();  
		for (int i = listeners.length - 2; i >= 0; i -= 2) {  
			if (listeners[i] == KDTEditListener.class) {  
				((KDTEditListener) listeners[(i + 1)]).editStopped(kdte);  
			}  
		}  
	}


	/**
	 * ��ȡ��������1
	 */
	public static void getKeyBoardInputContent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������������");
		String name = scanner.nextLine();
		System.out.println("������������䣺");
		int age = scanner.nextInt();
		System.out.println("��������Ĺ��ʣ�");
		float salary = scanner.nextFloat();
		System.out.println("�����Ϣ���£�");
		System.out.println("������"+name+"\n"+"���䣺"+age+"\n"+"���ʣ�"+salary);
		scanner.close();
	}

	/**
	 * ��ȡ��������2
	 * @throws IOException
	 */
	public static void getKeyBoardInputContent1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("Enter your value:");
		str = br.readLine();
		System.out.println("your value is :"+str);
	}
}
