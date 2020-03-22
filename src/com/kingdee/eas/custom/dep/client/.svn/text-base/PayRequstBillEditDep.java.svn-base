package com.kingdee.eas.custom.dep.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.ep.client.UIParam;

public class PayRequstBillEditDep {

	public void payRequstBillEditUiAfterOnLoad(final UIParam param){
		param.getKDTable("kdtEntrys").addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
					if(param.getKDTable("kdtEntrys").getColumnKey(e.getColIndex()).equals("asstActNumber")){
						try {
						if(param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "asstActNumber").getValue()!=null)
							param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "accountActualName").setValue((UIRuleUtil.getProperty((IObjectValue)param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "asstActNumber").getValue(), "name")));
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
	}

}
