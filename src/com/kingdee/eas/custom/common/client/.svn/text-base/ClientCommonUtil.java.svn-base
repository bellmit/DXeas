package com.kingdee.eas.custom.common.client;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.client.EASResource;

public class ClientCommonUtil {
	
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount得到的行可能不正确  
		int count = table.getRowCount3();  

		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  

	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}
	
	
//	/**
//	 * 打开指定单据 生成的 凭证 
//	 * @param billID
//	 * @param bostype
//	 * @throws BOSException 
//	 */
//	public void openBillVoucher(Component ownerComponent, String srcBosType, String[] srcBillIds, String destBosType, String mappintID) throws BOSException{
//		StringBuilder sb = new StringBuilder();
//		// 组织id列表
//		StringBuilder billIDRange = new StringBuilder();
//		if(srcBillIds != null && srcBillIds.length > 0){
//			for(int i = 0; i < srcBillIds.length; i++){
//				if(i == 0){
//					billIDRange.append("('");
//					billIDRange.append(srcBillIds[i]);
//					billIDRange.append("' ");
//				}else {
//					billIDRange.append(",'");
//					billIDRange.append(srcBillIds[i]);
//					billIDRange.append("' ");
//				}
//				
//			}
//			
//			billIDRange.append(")");
//		}else{
//			return ;
//		}
//		sb.append("select t.FDESTOBJECTID from t_bot_relation t where fsrcentityid='");
//		sb.append(srcBosType);
//		sb.append("' and fsrcobjectid in ");
//		sb.append(billIDRange.toString());
//		sb.append(" and fdestentityid='");
//		sb.append(destBosType);
//		sb.append("' ");
//		sb.append(" and fbotmappingID='");
//		sb.append(mappintID);
//		sb.append("' ");
//		
//		
//		try{
//			IRowSet rs = CommonFacadeFactory.getRemoteInstance().getSqlData(sb.toString());
//			IIDList idList = RealModeIDList.getEmptyIDList();
//			while(rs.next()){
//				String voucherId = rs.getString(1);
//				
//				idList.add(voucherId);
//			    
//				
//				
//			}
//			if(idList.size() > 0){
//				// 打开凭证
//				 UIContext uiContext = new UIContext(this);
//			     uiContext.put("ID", idList.getFirstID());
//			     uiContext.put("Owner", ownerComponent);
//			 
//			    
//			     
//			     uiContext.put("company", SysContext.getSysContext().getCurrentFIUnit());
//			    
//			 
//			     uiContext.put("NOTLICHA", "NOTLICHA");
//			     uiContext.put("BOTPViewStatus", Integer.valueOf(1));
//			 
//			     uiContext.put("EDITRULE", "com.kingdee.eas.fi.gl.client.DefaultVoucherEditRule");
//			 
//			     uiContext.put("IDList", idList);
//			 
//			     String uiClass = "com.kingdee.eas.fi.gl.client.VoucherEditUI";
//			     IUIWindow uiWindow = null;
//			 
//			     uiWindow = UIFactory.createUIFactory("com.kingdee.eas.base.uiframe.client.UIModelDialogFactory").create(uiClass, uiContext, null, OprtState.EDIT);
//			 
//			     uiWindow.show();
//			}else{
//				return;
//			}
//		}catch(SQLException sqle){
//			throw new BOSException(sqle);
//		}
//	}
//	
//	
//	
//	
//	/**
//	 * 获取 指定单据的botp ID列表
//	 * @param ctx
//	 * @param srcBosType
//	 * @param isEffected
//	 * @return
//	 * @throws BOSException 
//	 */
//	public List<String> getBillBotMappings_Open( String srcBosType,DefineSysEnum definesysEnum, boolean isEffected) throws BOSException{
//		ArrayList<String> result = new ArrayList<String>();
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("select t.fid from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where t.FISSHOWEDITUI=1 and t.fdefinesys=");
//		sb.append(definesysEnum.getValue());
//		sb.append(" and t.fsrcentityname='");
//		sb.append(srcBosType);
//		sb.append("' and te.fiseffected=");
//		if(isEffected){
//			sb.append("1");
//		}else{
//			sb.append("0");
//		}
//		try{
//			IRowSet rs = CommonFacadeFactory.getRemoteInstance().getSqlData(sb.toString());
//			while(rs.next()){
//				String fid = rs.getString(1);
//				result.add(fid);
//			}
//		}catch(Exception e){
//			throw new BOSException(e);
//		}
//		
//		
//		
//		return result;
//		
//	}
}
