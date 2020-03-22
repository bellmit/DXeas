package com.kingdee.eas.custom.eas2temp.interfaces;

import java.sql.Connection;

import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IImport2EAS {
	

	String importBillByBotp(Context ctx, String companyID, String beginDate,
			String endDate, String string) throws EASBizException;

	String getTempHeadTable();

	String getTempEntryTable();

	String getQueryStr();

	String getSourceBillID(Context ctx, String orgUnitID,String TempSourceBillNum);

	String getTempSourceTable();

	String getEASBosType();

	String getEASSourceBosType();
}
