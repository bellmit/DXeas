package com.kingdee.eas.custom.eas2wincos.interfaces;

import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public class ExportSupplier  implements IExport2WinCos {

	@Override
	public String export2WinCos(Context ctx, String companyNum, String beginDate, String endDate)
			throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBosType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInsertEntrySql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInsertHeadSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String export2WinCosByID(Context ctx, String companyNum, String billID) throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
}
