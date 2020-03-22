package com.kingdee.eas.wlhlcomm.function.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FieldDataType;
import com.kingdee.eas.wlhlcomm.FieldType;
import com.kingdee.eas.wlhlcomm.function.TobeUpdateBillsEntryInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class BillUpdateFacadeControllerBean extends AbstractBillUpdateFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.wlhlcomm.function.app.BillUpdateFacadeControllerBean");

    /**
     * 获得用户可编辑单据list
     */
	@Override
	protected List _getUserCanEditBills(Context ctx, String userID)
			throws BOSException {
		String sql = "select fid from CT_WLH_TobeUpdateBills t inner join CT_WLH_TobeUBPE te on t.fid = te.fparentid where te.CFUserID =? ";
		Object[] args = {userID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		List<String> ids = new ArrayList<String>();
		try{
			while(rs.next()){
				String fid = rs.getString("fid");
				ids.add(fid);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询用户有权限编辑的单据时出错"+sqle.getMessage());
		}

		return ids;
	}

	/**
	 * 获取指定单据  可编辑的 字段信息     MAP
	 */
	@Override
	protected Map _getBillEidtFields(Context ctx, String editBillID)
			throws BOSException {
		// 可编辑的分录明细
		Map<String,TobeUpdateBillsEntryInfo> editEntrys = new HashMap<String , TobeUpdateBillsEntryInfo>();
		String sql = "select fid,fparentid,CFFieldType,CFFieldName,CFFieldTable,CFFieldColumn,CFFieldDataType,CFEnumClass,CFF7Query from CT_WLH_TobeUpdateBillsEntry where fparentid=?";
		Object[] args = {editBillID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		try{
			while(rs.next()){
				String fid = rs.getString("fid");
				String fparentid = rs.getString("fparentid");
				String CFFieldType = rs.getString("CFFieldType");
				String CFFieldName = rs.getString("CFFieldName");
				String CFFieldTable = rs.getString("CFFieldTable");
				String CFFieldColumn = rs.getString("CFFieldColumn");
				String CFFieldDataType = rs.getString("CFFieldDataType");
				String CFEnumClass = rs.getString("CFEnumClass");
				String CFF7Query = rs.getString("CFF7Query");
				
				TobeUpdateBillsEntryInfo fieldEntryInfo = new TobeUpdateBillsEntryInfo();
				fieldEntryInfo.setId(BOSUuid.read(fid));
				fieldEntryInfo.setFieldType(FieldType.getEnum(CFFieldType));
				fieldEntryInfo.setFieldName(CFFieldName);
				fieldEntryInfo.setFieldTable(CFFieldTable);
				fieldEntryInfo.setFieldColumn(CFFieldColumn);
				fieldEntryInfo.setFieldDataType(FieldDataType.getEnum(CFFieldDataType));
				fieldEntryInfo.setEnumClass(CFEnumClass);
				fieldEntryInfo.setF7Query(CFF7Query);
				
				// 列名作为key
				editEntrys.put(CFFieldName, fieldEntryInfo);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询单据可编辑明细列出错，"+sqle.getMessage());
		}
		return editEntrys;
	}
    
    
    
}