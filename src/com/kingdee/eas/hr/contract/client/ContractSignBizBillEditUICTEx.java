package com.kingdee.eas.hr.contract.client;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.event.AncestorListener;

import com.kingdee.bos.BOSException;

import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.hr.base.EmployeePropertFactory;
import com.kingdee.eas.hr.base.EmployeePropertInfo;
import com.kingdee.eas.hr.base.client.EmployeePropertListUI;
import com.kingdee.eas.hr.emp.ContractLimitTypeEnum;
import com.kingdee.eas.hr.emp.ContractTempletFactory;
import com.kingdee.eas.hr.emp.ContractTempletInfo;
import com.kingdee.eas.hr.emp.ContractTypeFactory;
import com.kingdee.eas.hr.emp.ContractTypeInfo;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;

public class ContractSignBizBillEditUICTEx extends ContractSignBizBillEditUI{
	
	public ContractSignBizBillEditUICTEx() throws Exception {
		super();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		prmtToUnit.setValue(SysContext.getSysContext().getCurrentOrgUnit());
		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		IPerson ip = PersonFactory.getRemoteInstance();
		PersonInfo personInfo = ip.getPersonInfo(new ObjectUuidPK(userInfo.getPerson().getId().toString()));
		prmtDelegatePerson.setValue(personInfo);
		/*kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){

			@Override
			public void afterEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				dateChange();
			}

			@Override
			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
		});*/
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
	
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getRow(i).getCell(10).getValue()!=null){
				EmployeePropertInfo ctinfo=(EmployeePropertInfo) kdtEntrys.getRow(i).getCell(10).getValue();
				PersonInfo pinfo = (PersonInfo) kdtEntrys.getRow(i).getCell("person").getValue();
				String sql = "update t_bd_person set cfworknatureid = '"+ctinfo.getId().toString()+"' where fid = '"+pinfo.getId()+"'";
				//IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
				CommSqlFacadeFactory.getRemoteInstance().execute(sql.toString());
			}	
		}
		super.actionSubmit_actionPerformed(e);
	}

	private void dateChange() throws BOSException, EASBizException{
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			ContractLimitTypeEnum contractLimitType= (ContractLimitTypeEnum) kdtEntrys.getRow(i).getCell("contractLimitType").getValue();
			if(ContractLimitTypeEnum.FIXED_LIMIT==contractLimitType){
				if(kdtEntrys.getRow(i).getCell("bizDate").getValue()!=null&&kdtEntrys.getRow(i).getCell("contractLimit").getValue()!=null){
					Date aa = (Date) kdtEntrys.getRow(i).getCell("bizDate").getValue();
					String  contractLimit = kdtEntrys.getRow(i).getCell("contractLimit").getValue().toString();
					if(contractLimit.indexOf(".")>=0){
						contractLimit =contractLimit.substring(0, contractLimit.indexOf("."));
					}
					
					int bbb  = Integer.parseInt(contractLimit);
					Calendar rightNow = Calendar.getInstance();
			        rightNow.setTime(aa);
			        rightNow.add(Calendar.YEAR,bbb);//加上合同期限年份
			        Date endDate=rightNow.getTime();
					System.out.print(endDate);
					
					kdtEntrys.getRow(i).getCell("signDate").setValue(aa);
					kdtEntrys.getRow(i).getCell("endDate").setValue(endDate);
				}
				else{
					
					kdtEntrys.getRow(i).getCell("signDate").setValue(null);
					kdtEntrys.getRow(i).getCell("endDate").setValue(null);
				}
			}
		}
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getRow(i).getCell("contractType").getValue()==null){
				ObjectStringPK pk = new ObjectStringPK("E3sAAAAA//wFKYwe");
				ContractTypeInfo ctinfo=ContractTypeFactory.getRemoteInstance().getContractTypeInfo(pk);
				kdtEntrys.getRow(i).getCell("contractType").setValue(ctinfo);
			}
			if(kdtEntrys.getRow(i).getCell("contractType").getValue()!=null){
				ContractTypeInfo ctinfo=(ContractTypeInfo) kdtEntrys.getRow(i).getCell("contractType").getValue();
				//ctinfo.getUuid("worknature");
				EmployeePropertInfo info = EmployeePropertFactory.getRemoteInstance().getEmployeePropertInfo(new ObjectStringPK(((EmployeePropertInfo) ctinfo.get("worknature")).getId().toString()));
				kdtEntrys.getRow(i).getCell("ygxz").setValue(info);
			}
		}
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getRow(i).getCell("contractTemplet").getValue()==null){
				ObjectStringPK pk = new ObjectStringPK("E3sAAAABAASbpAZj");
				ContractTempletInfo ctpinfo = ContractTempletFactory.getRemoteInstance().getContractTempletInfo(pk);
				//kdtEntrys.getRow(i).getCell("contractTemplet").setValue(ctpinfo);
			}
		}
	}
}
