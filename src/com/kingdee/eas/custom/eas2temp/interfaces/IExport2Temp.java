package com.kingdee.eas.custom.eas2temp.interfaces;

import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IExport2Temp {
	String export2Temp(Context ctx, String companyNum,String beginDate,String endDate) throws EASBizException;
	String export2TempByID(Context ctx, String companyNum,String billID) throws EASBizException;
	String getTempHeadTable();
	String getTempEntryTable();
	String getInsertHeadSql();
	String getInsertEntrySql();
	String getBosType();
	
}
