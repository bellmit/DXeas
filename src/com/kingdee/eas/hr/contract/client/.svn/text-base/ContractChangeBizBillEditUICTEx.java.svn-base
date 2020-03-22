package com.kingdee.eas.hr.contract.client;

import java.util.Calendar;
import java.util.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.eas.common.EASBizException;



public class ContractChangeBizBillEditUICTEx extends ContractChangeBizBillEditUI{
	Date bb;
	public ContractChangeBizBillEditUICTEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntrys.addKDTEditListener(new KDTEditListener(){

			@Override
			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				//dateChange();
			}

			@Override
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				try {
					dateChange();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}
			
		});
	}
	private void dateChange() throws BOSException, EASBizException{
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getRow(i).getCell("bizDate").getValue()!=null){
				Date aa = (Date) kdtEntrys.getRow(i).getCell("bizDate").getValue();
				Calendar rightNow = Calendar.getInstance();
		        rightNow.setTime(aa);
		        rightNow.add(Calendar.YEAR,3);//日期加3年
		        bb=rightNow.getTime();
				System.out.print(bb);
				
				kdtEntrys.getRow(i).getCell("signDate").setValue(aa);
				kdtEntrys.getRow(i).getCell("endDate").setValue(bb);
			}
			else{
				kdtEntrys.getRow(i).getCell("signDate").setValue(null);
				kdtEntrys.getRow(i).getCell("endDate").setValue(null);
			}
		}
	}
	
	
}
