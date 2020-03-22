/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTCell;
import com.kingdee.bos.ctrl.kdf.table.KDTHead;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.style.ShareStyleAttributes;
import com.kingdee.bos.ctrl.kdf.util.style.Style;
import com.kingdee.bos.ctrl.kdf.util.style.Styles;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.salediscount.rpt.SaleQtyCompareRptFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;

/**
 * output class name
 */
public class SaleQtyCompareRptUI extends AbstractSaleQtyCompareRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleQtyCompareRptUI.class);

	private String CURR = "_CURR";
	private String LAST = "_LAST";
	private String CHANGE = "_CHANGE";
	
	private Style headerStype = null;
	private ShareStyleAttributes headerssa = null;
    /**
     * output class constructor
     */
    public SaleQtyCompareRptUI() throws Exception
    {
        super();
        this.kDTable1.getStyleAttributes().setLocked(true);
        this.kDTable1.checkParsed();  
        
        headerStype = kDTable1.getHead().getRow(1).getCell(1).getStyle();
        headerssa =  kDTable1.getHead().getRow(1).getCell(1).getSSA();
     // 
//		KDTHead head = this.kDTable1.getHead();

           
// 		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
// 		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
// 		enableExportExcel(this.kDTable1);
 		
 		this.setUITitle("实时销量");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }


	@Override
	protected RptParams getParamsForInit() {
		// TODO Auto-generated method stub
		return params;
	}

	@Override
	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		// TODO Auto-generated method stub
		return new SaleQtyCompareRptFilterUI();
	}

	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		// TODO Auto-generated method stub
		return SaleQtyCompareRptFacadeFactory.getRemoteInstance();
	}

	@Override
	protected KDTable getTableForPrintSetting() {
		// TODO Auto-generated method stub
		return this.kDTable1;
	}

	@Override
	protected void query() {
		this.kDTable1.removeRows();
		this.kDTable1.removeColumns();
		// 添加固定 列
		addFocusHeaderRows();
		// 设置公司和 期间
		this.prmtCompany.setValue(params.getObject("company"));
//		this.prmtPeriod.setValue(params.getObject("period"));
		String beginDateStr = params.getString("beginDateStr");
		String endDateStr = params.getString("endDateStr");
		String lastBeginDateStr = params.getString("lastBeginDateStr");
		String lastEndDateStr = params.getString("lastEndDateStr");
		
		this.tfCurrTimeRange.setText(beginDateStr+" 到  "+endDateStr);
		this.tfLastTimeRange.setText(lastBeginDateStr+" 到  "+lastEndDateStr);
		try {
			
			//临时表/表头
			
			RptParams param=getRemoteInstance().createTempTable(params);
			this.setTempTable(param.getString("tempTable"));
		
			//查询并填充数据
			params.setString("tempTable",this.getTempTable());
			RptParams rpt=getRemoteInstance().query(params);
			RptRowSet rs=(RptRowSet)rpt.getObject("rs");
			// 展现结果
			expends(rs);
			
			// 汇总结果
			setSum();
			
//			enableExportExcel(this.kDTable1);
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}


	/**
	 * 设置 合计 值 
	 */
	private void setSum() {
		int rowCount = this.kDTable1.getRowCount();
		int columnCount = this.kDTable1.getColumnCount();
		if(rowCount > 0){
			// 逐行计算累计
			for(int i = 0; i < rowCount; i++){
				BigDecimal allLast = new BigDecimal("0");
				BigDecimal allCurr = new BigDecimal("0");
				
				for(int j = 0; j< columnCount;j++){
					BigDecimal currValue =  new BigDecimal("0");
					BigDecimal lastValue =  new BigDecimal("0");
					
					IColumn currColumn = this.kDTable1.getColumn(j);
					String columnName = currColumn.getKey();
					// 当月累计到当月
					if(columnName != null && columnName.endsWith(CURR)){
						currValue = (BigDecimal) this.kDTable1.getCell(i, j).getValue();
						if(currValue == null){
							currValue = new BigDecimal("0");
							this.kDTable1.getCell(i, j).setValue(currValue);
						}
						allCurr = allCurr.add(currValue);
						
					}
					// 如果是 上个月 则累计到上个月中
					if(columnName != null && columnName.endsWith(LAST)){
						lastValue = (BigDecimal) this.kDTable1.getCell(i, j).getValue();
						if(lastValue == null){
							lastValue = new BigDecimal("0");
							this.kDTable1.getCell(i, j).setValue(lastValue);
						}
						allLast = allLast.add(lastValue);
						
					}
					
					// 如果是 差额 则 计算 差额 然后 根据正负设置显示值
					if(columnName != null && columnName.endsWith(CHANGE)){
						String groupNumber = columnName.substring(0, columnName.indexOf(CHANGE));
						BigDecimal currBigValue = (BigDecimal) this.kDTable1.getCell(i, groupNumber+CURR).getValue();
						if(currBigValue== null) {
							currBigValue = new BigDecimal("");
						}
						BigDecimal lastBigValue = (BigDecimal) this.kDTable1.getCell(i, groupNumber+LAST).getValue();
						if(lastBigValue== null) {
							lastBigValue = new BigDecimal("");
						}

						BigDecimal currChangeValue = currBigValue.subtract(lastBigValue);
						
						this.kDTable1.getCell(i, j).setValue(currChangeValue);
						
					}
					
				}
				
				// 所有列 循环完了后设置  物料总计
				BigDecimal materialChange = allCurr.subtract(allLast);
				
				this.kDTable1.getCell(i, "currMonthAll").setValue(allCurr);
				this.kDTable1.getCell(i, "lastMonthAll").setValue(allLast);
				this.kDTable1.getCell(i, "changeAll").setValue(materialChange);
				
				
				
			}
		}
		
	}

	/**
	 * 添加固定列
	 */
	private void addFocusHeaderRows() {
		IColumn midColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(midColumn,"materialID");
		midColumn.getStyleAttributes().setHided(true);
		midColumn.getStyleAttributes().setNumberFormat(null);
		
		IColumn mNumberColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(mNumberColumn,"materialNumber");
		mNumberColumn.setWidth(150);
		mNumberColumn.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.LEFT);
		mNumberColumn.getStyleAttributes().setNumberFormat(null);
		
		IColumn mNameColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(mNameColumn,"materialName");
		mNameColumn.setWidth(250);
		mNameColumn.getStyleAttributes().setHorizontalAlign(Styles.HorizontalAlignment.LEFT);
		mNameColumn.getStyleAttributes().setNumberFormat(null);
		
		IColumn lastAllQtyColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(lastAllQtyColumn,"lastMonthAll");
		IColumn currAllQtyColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(currAllQtyColumn,"currMonthAll");
		IColumn changeQtyColumn = this.kDTable1.addColumn();
		setColumnDefaultStype(changeQtyColumn,"changeAll");
		
		IRow headerRow1 = kDTable1.addHeadRow();
		headerRow1.getCell(0).setValue("产品ID");
		headerRow1.getCell(0).getStyleAttributes().setBold(true);
		IRow headerRow2 = kDTable1.addHeadRow();
		IRow headerRow3 = kDTable1.addHeadRow();
		
		
		KDTHead head = this.kDTable1.getHead();
//		// 第一列
//		KDTCell newCell11 = new KDTCell();
//		setHeaderCellDefaultStyle(newCell11, "产品ID");
//		head.getRow(0).setCell(0, newCell11);
		
		// 第二列
		KDTCell newCell21 = new KDTCell();
		setHeaderCellDefaultStyle(newCell21, "产品编码");
		head.getRow(0).setCell(1, newCell21);
		// 第三列
		KDTCell newCell31 = new KDTCell();
		setHeaderCellDefaultStyle(newCell31, "产品名称");
		head.getRow(0).setCell(2, newCell31);
		
		// 第四列第一行
		KDTCell newCell41 = new KDTCell();
		setHeaderCellDefaultStyle(newCell41, "销量合计");
		head.getRow(0).setCell(3, newCell41);
		// 第四列第三行
		KDTCell newCell43 = new KDTCell();
		setHeaderCellDefaultStyle(newCell43, "上期销量");
		head.getRow(2).setCell(3, newCell43);
		
		
		// 第五列第三行
		KDTCell newCell53 = new KDTCell();
		setHeaderCellDefaultStyle(newCell53, "本期销量");
		head.getRow(2).setCell(4, newCell53);
		
		// 第六列第三行
		KDTCell newCell63 = new KDTCell();
		setHeaderCellDefaultStyle(newCell63, "较上月同期(±)");
		head.getRow(2).setCell(5, newCell63);
		
		
		
		// 合并
		List mergedRegionList = new ArrayList();
		mergedRegionList.add(new int[] {0, 0, 0, 2 });
		mergedRegionList.add(new int[] {1, 0, 1, 2 });
		mergedRegionList.add(new int[] {2, 0, 2, 2 });
		mergedRegionList.add(new int[] {3, 0, 5, 1 });
		KDTableUtil.mergeTableCell(mergedRegionList, true, kDTable1);
	}

	/**
	 * 设置 表头cell 默认格式
	 */
	private void setHeaderCellDefaultStyle(KDTCell headerCell,String cellKey){
		headerCell.setValue(cellKey);
		
		headerCell.setStyle(headerStype);
		headerCell.setSSA(headerssa);
		
		
		
	}
	/**
	 * 设置
	 * @param midColumn
	 */
	private void setColumnDefaultStype(IColumn midColumn,String columnKey){
		// 设置列 空样式
		midColumn.getStyleAttributes().setHorizontalAlign( Styles.HorizontalAlignment.RIGHT);
		midColumn.getStyleAttributes().setHided(false);
		midColumn.getStyleAttributes().setNumberFormat("#,###.00");
		midColumn.setWidth(100);
		midColumn.setKey(columnKey);
		
	}


	/**
	 * 显示出 查询结果 
	 * @param rs
	 */
	private void expends(RptRowSet rs){
		// 物料缓存
		String materialID = "";
		
		// 销售组缓存 
		Set<String> saleGroupIDs = new HashSet<String>();
		Map<String,String> groupNumber = new HashMap<String,String>();
		// 当前编辑行
		IRow tableRow = null;
		while(rs.next()){
			String currMaterialID = rs.getString("materialID");
			// 获取销售组
			String saleGroupID = rs.getString("saleGroupID");
			String saleGroupNumber = rs.getString("saleGroupNumber");
			String saleGroupName = rs.getString("saleGroupName");
			// 如果销售组 还没有添加到 列中，那么添加到table中
			if(!saleGroupIDs.contains(saleGroupID)){
				saleGroupIDs.add(saleGroupID);
				addNewGroup(saleGroupNumber,saleGroupName);
				groupNumber.put(saleGroupID, saleGroupNumber);
				
			}
			// 如果是最新的物料的话则 首先添加表头 
			if(!materialID.equals(currMaterialID)){
				materialID = currMaterialID;
				tableRow = this.kDTable1.addRow();
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				tableRow.getCell("materialID").setValue(currMaterialID);
				tableRow.getCell("materialNumber").setValue(materialNumber);
				tableRow.getCell("materialName").setValue(materialName);
			}
			
			// 销量信息
			BigDecimal currMonthSaleQty = rs.getBigDecimal("currMonthSaleQty");
			BigDecimal lastMonthSaleQty = rs.getBigDecimal("lastMonthSaleQty");
			
			tableRow.getCell(saleGroupNumber+CURR).setValue(currMonthSaleQty);
			tableRow.getCell(saleGroupNumber+LAST).setValue(lastMonthSaleQty);
		}
		
		
	}
	
	/**
	 * 还没有添加到table中的 先添加到table中，
	 * @param groupNumber
	 * @param groupName
	 */
	private void addNewGroup(String groupNumber,String groupName){
		
		
		IColumn lastColumn = this.kDTable1.addColumn();
		IColumn currColumn = this.kDTable1.addColumn();
		IColumn chargeColumn = this.kDTable1.addColumn();
		
		// 设置默认格式
		setColumnDefaultStype(lastColumn,groupNumber+LAST);
		setColumnDefaultStype(currColumn,groupNumber+CURR);
		setColumnDefaultStype(chargeColumn,groupNumber+CHANGE);
		
		int columnCount = this.kDTable1.getColumnCount();
//		kDTable1.addHeadRow()
		// 
		KDTHead head = this.kDTable1.getHead();
		// 合并行
		List mergedRegionList = new ArrayList();
		KDTCell newCell11 = new KDTCell();
		setHeaderCellDefaultStyle(newCell11,"销售组");
		
		head.getRow(0).setCell(columnCount-3, newCell11);
		mergedRegionList.add(new int[] { columnCount-3, 0, columnCount-1, 0 });
		
		KDTCell newCell21 = new KDTCell();
		setHeaderCellDefaultStyle(newCell21,groupName);
		
		head.getRow(1).setCell(columnCount-3, newCell21);
		mergedRegionList.add(new int[] { columnCount-3, 1, columnCount-1, 1 });
		
		KDTCell newCell31 = new KDTCell();
		setHeaderCellDefaultStyle(newCell31,"上期销量");
		
		head.getRow(2).setCell(columnCount-3, newCell31);
		
		KDTCell newCell32 = new KDTCell();
		setHeaderCellDefaultStyle(newCell32,"本期销量");
		
		head.getRow(2).setCell(columnCount-2, newCell32);
		
		KDTCell newCell33 = new KDTCell();
		setHeaderCellDefaultStyle(newCell33,"较上月同期(±)");
		
		head.getRow(2).setCell(columnCount-1, newCell33);
		// 合并行
		KDTableUtil.mergeTableCell(mergedRegionList, true, kDTable1);
		this.kDTable1.checkParsed();

		
		Set<Map> mergeBlocks = this.kDTable1.getHeadMergeManager().getMergeBlockSet();
		
	}

}