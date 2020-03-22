package com.kingdee.eas.farm.food.rpt.client;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.report.util.KDTableInsertHandler;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.scm.im.rpt.client.IntenventoryAgeUI;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * 库存账龄分析表 拓展，添加列
 * @author lenovo
 *
 */
public class IntenventoryAgeUIEx extends IntenventoryAgeUI {
	public IntenventoryAgeUIEx() throws Exception {
		super();
	}

	@Override
	public void getData(KDTDataRequestEvent e) {
		// TODO Auto-generated method stub
		super.getData(e);
		
	}
	
	@Override
	protected void query() {
		// TODO Auto-generated method stub
		super.query();
	}

	@Override
	public void insertRows(RptRowSet rs, int start, KDTable table,boolean refreshUI, KDTableInsertHandler handler, int j) {
		// TODO Auto-generated method stub
		super.insertRows(rs, start, table, refreshUI, handler, j);
		addCustomCols(start);
	}

	/**
	 * 添加用户自定义列
	 */
	private void addCustomCols(int startRow) {
		try {
			/*Object[] storageOrgInfos=(Object[]) this.params.getObject("storageOrgInfo");
			if(storageOrgInfos==null||storageOrgInfos.length<=0||storageOrgInfos[0]==null){
				return;
			}
			
			String storageOrgIDs="";
			for(int index=0;index<storageOrgInfos.length;index++) {
				if(StringUtils.isNotBlank(storageOrgIDs)) {
					storageOrgIDs+=",";
				}
				storageOrgIDs=storageOrgIDs+"'"+((IObjectValue)storageOrgInfos[index]).getString("id")+"'";
			}*/
			if(tblMain.getColumn("periodBegin")==null){
			
				IColumn col = this.tblMain.addColumn();
				col.setKey("periodBegin");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("期初");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("期初");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.0000");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
				
				col = this.tblMain.addColumn();
				col.setKey("periodIn");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("收入");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("收入");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.0000");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
				
				col = this.tblMain.addColumn();
				col.setKey("periodIssue");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("发出");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("发出");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.0000");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
				
				col = this.tblMain.addColumn();
				col.setKey("periodEnd");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("期末");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("期末");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.0000");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
				
				col = this.tblMain.addColumn();
				col.setKey("zzRate");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("周转率");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("周转率");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.0000");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
				
				col = this.tblMain.addColumn();
				col.setKey("zzDay");
				tblMain.getHeadRow(0).getCell(col.getColumnIndex()).setValue("周转天数");
				tblMain.getHeadRow(1).getCell(col.getColumnIndex()).setValue("周转天数");
				tblMain.getHeadMergeManager().mergeBlock(0, col.getColumnIndex(), 1, col.getColumnIndex());
				col.getStyleAttributes().setNumberFormat("#.00");
				col.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
			}
			
			int year=params.getInt("spYear");
			int period=params.getInt("spPeriod");
			
			IRow row;
			String storageOrgName,materialNum,warehouseID,locationName,lot;//物料，仓库，库位，批次 FWarehouseID\FLocation\FLot
			for(int rowIndex=startRow;rowIndex<tblMain.getRowCount();rowIndex++) {
				row=tblMain.getRow(rowIndex);
				if(row==null)
					continue;
				if(row.getCell("FStorageOrgName")==null||row.getCell("FStorageOrgName").getValue()==null||row.getCell("FmaterialNumber")==null||row.getCell("FmaterialNumber").getValue()==null)
						continue;
				storageOrgName=row.getCell("FStorageOrgName").getValue().toString().trim();
				if(storageOrgName.equals("合计")) {
					continue;
				}
				materialNum=row.getCell("FmaterialNumber").getValue().toString().trim();
				warehouseID=null;
				locationName=null;
				lot=null;
				if(tblMain.getColumn("FWarehouseID")!=null&&row.getCell("FWarehouseID").getValue()!=null) {
					warehouseID=row.getCell("FWarehouseID").getValue().toString().trim();
				}
				if(tblMain.getColumn("FLocation")!=null&&row.getCell("FLocation").getValue()!=null) {
					locationName=row.getCell("FLocation").getValue().toString().trim();
				}
				if(tblMain.getColumn("FLot")!=null&&row.getCell("FLot").getValue()!=null) {
					lot=row.getCell("FLot").getValue().toString().trim();
				}
				setCustomColValueNew(row, storageOrgName,year,period, materialNum, warehouseID, locationName, lot);
			}
			
		/*	for(int j=0;j<15;j++) {
				System.out.println(tblMain.getColumn(j).getKey());
			}*/
			
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * 设置值
	 */
	private static void setCustomColValue(IRow row,String storageOrgName,int year,int period,String materialNum,String warehouseID,String locationName,String lot) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(FPeriodBeginQty),0) FPeriodBeginQty,isnull(sum(FPeriodIssueQty),0) FPeriodIssueQty,isnull(sum(FPeriodEndQty),0) FPeriodEndQty");//期初数量、发出数量、期末结存
			sql.append(" from T_IM_InventoryBalance tb");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tb.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tb.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tb.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and tb.Fyear=").append(year).append(" and FPeriod=").append(period);
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tb.flot='").append(lot).append("'");
			}
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			BigDecimal periodBegin,periodIssue,periodEnd,zzRate,zzDay;
			BigDecimal two=new BigDecimal(2);
			if(rs.next()) {
				periodBegin=rs.getBigDecimal("FPeriodBeginQty");
				periodIssue=rs.getBigDecimal("FPeriodIssueQty");
				periodEnd=rs.getBigDecimal("FPeriodEndQty");
				
				zzRate=BigDecimal.ZERO;
				if(periodIssue.compareTo(BigDecimal.ZERO)>0) {
					zzRate=periodIssue.divide((periodBegin.add(periodEnd)),6,BigDecimal.ROUND_HALF_UP).multiply(two);//周转率
				}
				zzDay=BigDecimal.ZERO;
				if(zzRate.compareTo(BigDecimal.ZERO)>0) {
					zzDay=new BigDecimal(30).divide(zzRate,2,BigDecimal.ROUND_HALF_UP);
				}
					
				row.getCell("periodBegin").setValue(periodBegin);
				row.getCell("periodIssue").setValue(periodIssue);
				row.getCell("periodEnd").setValue(periodEnd);
				row.getCell("zzRate").setValue(zzRate);
				row.getCell("zzDay").setValue(zzDay);
				
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 设置值
	 */
	private static void setCustomColValueNew(IRow row,String storageOrgName,int year,int period,String materialNum,String warehouseID,String locationName,String lot) {
		try {
			String yearAndMonth=String.valueOf(period);
			if(yearAndMonth.length()<2) {
				yearAndMonth="0"+yearAndMonth;
			}
			yearAndMonth=String.valueOf(year)+yearAndMonth;//yyyyMM
			
			StringBuffer sql=new StringBuffer();
			
			sql.append(" /*dialect*/select nvl(sum(FPeriodBeginQty),0) FPeriodBeginQty,nvl(sum(FInQty),0) FPeriodInQty,nvl(sum(FOutQty),0) FPeriodIssueQty,nvl(sum(FPeriodEndQty),0) FPeriodEndQty");//期初数量、发出数量、期末结存
			sql.append(" from (");
			//库存余额表
			sql.append(" select tb.FPeriodBeginQty,0 FInQty,0 FOutQty,FPeriodEndQty");
			sql.append(" from T_IM_InventoryBalance tb");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tb.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tb.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tb.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and tb.Fyear=").append(year).append(" and FPeriod=").append(period);
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tb.flot='").append(lot).append("'");
			}
			//采购入库单
			sql.append(" union all");
			sql.append(" select 0,tentry.FBaseQty,0,0");
			sql.append(" from T_IM_PurInWarehsBill tb");
			sql.append(" inner join T_IM_PurInWarehsEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			//生产入库单
			sql.append(" union all");
			sql.append(" select 0,tentry.FBaseQty,0,0");
			sql.append(" from T_IM_ManufactureRecBill tb");
			sql.append(" inner join T_IM_ManufactureRecBillEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			//其他入库单
			sql.append(" union all");
			sql.append(" select 0,tentry.FBaseQty,0,0");
			sql.append(" from T_IM_OtherInWarehsBill tb");
			sql.append(" inner join T_IM_OtherInWarehsBillEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			//销售出库单
			sql.append(" union all");
			sql.append(" select 0,0,tentry.FBaseQty,0");
			sql.append(" from T_IM_SaleIssueBill tb");
			sql.append(" inner join T_IM_SaleIssueEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			//其他出库单
			sql.append(" union all");
			sql.append(" select 0,0,tentry.FBaseQty,0");
			sql.append(" from T_IM_OtherIssueBill tb");
			sql.append(" inner join T_IM_OtherIssueBillEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			//领料出库单--包装物
			sql.append(" union all");
			sql.append(" select 0,0,tentry.FBaseQty,0");
			sql.append(" from T_IM_MaterialReqBill tb");
			sql.append(" inner join T_IM_MaterialReqBillEntry tentry on tentry.FParentID=tb.fid");
			sql.append(" inner join t_org_baseunit torg on torg.fid=tb.FStorageOrgUnitID");
			sql.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID");
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" inner join T_DB_WAREHOUSE tw on tw.fid=tentry.FWarehouseID");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" inner join T_DB_LOCATION tlocation on tlocation.fid=tentry.FLocationID");
			}
			sql.append(" where torg.fname_l2 ='").append(storageOrgName).append("'");
			sql.append(" and (tb.FBaseStatus=4 or tb.FBaseStatus=7 or tb.FBaseStatus=8 or tb.FBaseStatus=9)");
			sql.append(" and subStr(to_char(tb.FbizDate,'yyyyMMdd'),0,6)='").append(yearAndMonth).append("'");
			sql.append(" and tm.FNumber='").append(materialNum).append("'");
			sql.append(" and tm.FNumber like '04%'");//包装物
			if(StringUtils.isNotEmpty(warehouseID)) {
				sql.append(" and tw.fid='").append(warehouseID).append("'");
			}
			if(StringUtils.isNotEmpty(locationName)) {
				sql.append(" and tlocation.FName_l2='") .append(locationName).append("'");
			}
			if(StringUtils.isNotEmpty(lot)) {
				sql.append(" and tentry.flot='").append(lot).append("'");
			}
			sql.append(") temp");
			
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			BigDecimal periodBegin,periodIn,periodIssue,periodEnd,zzRate,zzDay;
			BigDecimal two=new BigDecimal(2);
			if(rs.next()) {
				periodBegin=rs.getBigDecimal("FPeriodBeginQty");
				periodIn=rs.getBigDecimal("FPeriodInQty");
				periodIssue=rs.getBigDecimal("FPeriodIssueQty");
				periodEnd=rs.getBigDecimal("FPeriodEndQty");
				
				zzRate=BigDecimal.ZERO;
				if((periodBegin.add(periodEnd)).compareTo(BigDecimal.ZERO)>0) {
					zzRate=periodIssue.divide((periodBegin.add(periodEnd)),6,BigDecimal.ROUND_HALF_UP).multiply(two);//周转率
				}
				zzDay=BigDecimal.ZERO;
				if(zzRate.compareTo(BigDecimal.ZERO)>0) {
					zzDay=new BigDecimal(30).divide(zzRate,2,BigDecimal.ROUND_HALF_UP);
				}
					
				row.getCell("periodBegin").setValue(periodBegin);
				row.getCell("periodIn").setValue(periodIn);
				row.getCell("periodIssue").setValue(periodIssue);
				row.getCell("periodEnd").setValue(periodEnd);
				row.getCell("zzRate").setValue(zzRate);
				row.getCell("zzDay").setValue(zzDay);
				
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
}
