package com.kingdee.eas.custom.dep.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.framework.DataBaseDAssignFactory;
import com.kingdee.eas.basedata.framework.DataBaseDAssignInfo;
import com.kingdee.eas.basedata.framework.DataStateEnum;
import com.kingdee.eas.basedata.hraux.FolkFactory;
import com.kingdee.eas.basedata.hraux.FolkInfo;
import com.kingdee.eas.basedata.hraux.WedInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryInfo;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillFactory;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillInfo;
import com.kingdee.eas.hr.emp.PersonContactMethodFactory;
import com.kingdee.eas.hr.emp.PersonContactMethodInfo;
import com.kingdee.eas.hr.emp.PersonLinkmanFactory;
import com.kingdee.eas.hr.emp.PersonLinkmanInfo;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.Context;

public class StaffEntryBillEditDep {
	public static void afterAuditSaveData(Context ctx,final Object param) throws EASBizException{
			EmpEnrollBizBillInfo ebInfo = null;
			try {
				ebInfo = EmpEnrollBizBillFactory.getLocalInstance(ctx).getEmpEnrollBizBillInfo(new ObjectUuidPK((BOSUuid) param));
			
			for(int i = 0;i <ebInfo.getEntrys().size();i++){
				EmpEnrollBizBillEntryInfo ebeInfo = ebInfo.getEntrys().get(i);
				WedInfo wedInfo = (WedInfo) ebeInfo.get("marriageState");
				FolkInfo folkInfo =(FolkInfo) ebeInfo.get("nation");
				//FolkInfo folkInfo = FolkFactory.getLocalInstance(ctx).getFolkInfo(new ObjectUuidPK(((FolkInfo) ebeInfo.get("nation")).getId()));
					String accountAddress = (String)ebeInfo.get("accountAddress");
					String nowAddress = (String) ebeInfo.get("nowAddress");
					String emergencyContactsName = (String)ebeInfo.get("emergencyContactsName");
					String emergencyContactsNum =(String)ebeInfo.get("emergencyContactsNum");
					String personID = ebeInfo.getPerson().getString("id");
					PersonInfo psInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personID));
					psInfo.setWed(wedInfo);
					psInfo.setFolk(folkInfo);
					PersonFactory.getLocalInstance(ctx).save(psInfo);
					//加入紧急联系人页签
					PersonLinkmanInfo plmInfo = new PersonLinkmanInfo();
					plmInfo.setName(emergencyContactsName);
					plmInfo.setPhoneNumber(emergencyContactsNum);
					plmInfo.setPerson(psInfo);
					plmInfo.setCU(psInfo.getCU());
					PersonLinkmanFactory.getLocalInstance(ctx).save(plmInfo);
					//加入联系方式页签
					PersonContactMethodInfo psmInfo = new PersonContactMethodInfo();
					psmInfo.setHjAddress(accountAddress);
					psmInfo.setHomeAddress(nowAddress);
					plmInfo.setPerson(psInfo);
					plmInfo.setCU(psInfo.getCU());
					PersonContactMethodFactory.getLocalInstance(ctx).save(psmInfo);
					
					//throw new Exception("test");
				
			}
			} catch (Exception e1) {
				throw new EASBizException(new NumericExceptionSubItem("",e1.getMessage()));
			} 
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 /*for(int i = 0;i <param.getKDTable("kdtEntrys").getColumnCount() ;i++){
		 WedInfo wedInfo = (WedInfo) param.getKDTable("kdtEntrys").getRow(i).getCell("marriageState").getValue();
		 FolkInfo folkInfo = (FolkInfo) param.getKDTable("kdtEntrys").getRow(i).getCell("nation").getValue();
		 String accountAddress = (String) param.getKDTable("kdtEntrys").getRow(i).getCell("accountAddress").getValue();
		 String nowAddress = (String) param.getKDTable("kdtEntrys").getRow(i).getCell("nowAddress").getValue();
		 String emergencyContactsName = (String) param.getKDTable("kdtEntrys").getRow(i).getCell("emergencyContactsName").getValue();
		 String emergencyContactsNum = (String) param.getKDTable("kdtEntrys").getRow(i).getCell("emergencyContactsNum").getValue();
		 String personID = (String) param.getKDTable("kdtEntrys").getRow(i).getCell("id").getValue();
		 PersonInfo psInfo = null;
		 try {
			 psInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(personID));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 PersonLinkmanInfo plmInfo = new PersonLinkmanInfo();
		 plmInfo.setPerson(psInfo);
		 plmInfo.setName(emergencyContactsName);
		 plmInfo.setPhoneNumber(emergencyContactsNum);
		 try {
			PersonLinkmanFactory.getLocalInstance(ctx).save(plmInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }*/
}
