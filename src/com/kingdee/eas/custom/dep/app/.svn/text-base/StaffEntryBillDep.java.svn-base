package com.kingdee.eas.custom.dep.app;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.hraux.FolkInfo;
import com.kingdee.eas.basedata.hraux.WedInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillEntryInfo;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillFactory;
import com.kingdee.eas.hr.affair.EmpEnrollBizBillInfo;
import com.kingdee.eas.hr.emp.PersonContactMethodFactory;
import com.kingdee.eas.hr.emp.PersonContactMethodInfo;
import com.kingdee.eas.hr.emp.PersonLinkmanFactory;
import com.kingdee.eas.hr.emp.PersonLinkmanInfo;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class StaffEntryBillDep {
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
				String phoneNumber = (String) ebeInfo.get("PhoneNumber");
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
				//查询联系方式页签，并插入值
				String sql = "select FID from T_HR_PersonContactMethod where fpersonid = '"+psInfo.getId()+"'";
				IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
				String psmID = null;
				while(rs.next()){
					psmID = rs.getString("FID");
				}
				PersonContactMethodInfo psmInfo = PersonContactMethodFactory.getLocalInstance(ctx).getPersonContactMethodInfo(new ObjectUuidPK(psmID));
				psmInfo.setHjAddress(accountAddress);
				psmInfo.setHomeAddress(nowAddress);
				psmInfo.setMobile(phoneNumber);
				plmInfo.setPerson(psInfo);
				plmInfo.setCU(psInfo.getCU());
				PersonContactMethodFactory.getLocalInstance(ctx).save(psmInfo);
				//throw new Exception("test");
			
		}
		} catch (Exception e1) {
			throw new EASBizException(new NumericExceptionSubItem("",e1.getMessage()));
		} 
		
		
		
}
}
