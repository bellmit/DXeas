package com.kingdee.eas.custom.eas2wincos.interfaces;

import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IExport2WinCos {
	String export2WinCos(Context ctx, String companyNum,String beginDate,String endDate) throws EASBizException;
	String export2WinCosByID(Context ctx, String companyNum,String billID) throws EASBizException;
	String getWinCosHeadTable();
	String getWinCosEntryTable();
	String getInsertHeadSql();
	String getInsertEntrySql();
	String getBosType();
}
