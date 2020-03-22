package com.kingdee.eas.custom.znck.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wsclient.Ctr_LedSoapProxy;
import com.kingdee.eas.custom.znck.MaterialLedRelFacadeFactory;
import com.kingdee.eas.util.client.MsgBox;

/**
 * 
 * ����Ͽ��Ʒ������ led�ƿ��ƽӿ�
 * @author USER
 *
 */
public class LedControlUtil {
	
	private String port;
	private String baudRate;
	private String lightIP;
	
	public LedControlUtil(){
		port = "COM2";
		baudRate = "9600";
		lightIP = "192.168.1.153";
	}
	
	/**
	 * ������¼�������϶�Ӧ�ĵ� 3����
	 * @param kdtEntry
	 */
	public void lightOnAllEntryMaterials(KDTable kdtEntry,String materialKey){
		String currIP = SysContext.getSysContext().getClientIP();
		if(lightIP.equals(currIP)){
			List<String> materialIDs = new ArrayList<String>();
			for(int i = 0; i < kdtEntry.getRowCount(); i++){
				if(kdtEntry.getCell(i, materialKey) != null){
					MaterialInfo materialInfo = (MaterialInfo) kdtEntry.getCell(i, materialKey).getValue();
					// ������ϲ�Ϊ��
					if(materialInfo != null){
						materialIDs.add(materialInfo.getId().toString());
					}
				}
			}
			// ����
			lightOnMoment(materialIDs);
		}
	}
	/**
	 * ����
	 * @param materials
	 */
	public void lightOnMoment(List<String> materials){
		 Ctr_LedSoapProxy proxy = new Ctr_LedSoapProxy();
		try{
			List<Integer> ledNumbers = MaterialLedRelFacadeFactory.getRemoteInstance().getMaterialRelLEDNumbers(materials);
			for(int i = 0; i < ledNumbers.size(); i++){
				// ����
		    	String lightResult  = proxy.lighten(port, baudRate, ledNumbers.get(i));
			}
		}catch(BOSException bose){
			MsgBox.showInfo(bose.getMessage());
		} catch (RemoteException e) {
			e.printStackTrace();
			MsgBox.showInfo("Զ�̽ӿ��쳣"+e.getMessage());
		}
	}
	
	/**
	 * ȫ���ص�
	 */
	public void lightOffAllLed(){
		try{
			String currIP = SysContext.getSysContext().getClientIP();
			if(lightIP.equals(currIP)){
				 Ctr_LedSoapProxy proxy = new Ctr_LedSoapProxy();
				 proxy.allOut(port, baudRate);
			}
			 
		}catch (RemoteException e) {
			
//			e.printStackTrace();
//			MsgBox.showInfo("Զ�̽ӿ��쳣"+e.getMessage());
		} 
	}
	
	
}
