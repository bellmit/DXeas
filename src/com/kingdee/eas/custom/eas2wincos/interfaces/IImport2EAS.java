package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.sql.Connection;

import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IImport2EAS {
	String importBill(Context ctx,String companyID,String beginDate,String endDate) throws EASBizException;
	String importBillByBotp(Context ctx,String companyID,String beginDate,String endDate) throws EASBizException;
	String getWinCosHeadTable();
	String getWinCosEntryTable();
	String getQueryStr();
	String getSourceBillID(Connection conn,int wincosSourceBillID);
	String  getWinCosSourceTable();
	String  getEASBosType();
	String  getEASSourceBosType();
}
