package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.eas.util.client.KDTableUtil;

/**
 * 自定义多行,table
 * @author dai_andong
 *
 */
public class ICTable {
	private KDTable table;
	//单列合并
	private String[] singleMerageCols;
	//新增或插入分录的默认值
	private LinkedList<HashMap<String,Object>> rowCountAndDefalutValue;
	
	public static final String rowBackgroupColor="_rowBackgroup_Color";
	public static final String setRowLocked="_setRow_Locked";
	
	/**
	 * 增加分录行 并设置默认值
	 * @param bottom 
	 */
	public void addRow( ) {
		exeAddRow(table.getRowCount());
	}
	
	private void exeAddRow(int rowIndex) {
		if(rowCountAndDefalutValue==null) {
			return;
		}
		IRow row;
		Set<String> dd;
		int tempIndex;
		for(int i=0;i<rowCountAndDefalutValue.size();i++) {
			row=table.addRow(rowIndex+i);
			row.getCell("isExistDownBill").setValue(false);
			if(rowIndex<0) {
				rowIndex=row.getRowIndex();
			}
			tempIndex=0;
			for(HashMap<String, Object> map:rowCountAndDefalutValue) {
				if((tempIndex++)!=i) {
					continue;
				}
				dd = map.keySet();
				for(String key:dd) {
					if(table.getColumn(key)!=null) {
						row.getCell(key).setValue(map.get(key));
					}
					//背景色
					if(key.equalsIgnoreCase(rowBackgroupColor)) {
						for(int col=table.getColumnIndex("statisticsType");col<=table.getColumnIndex("diffQty");col++){
							row.getCell(col).getStyleAttributes().setBackground((Color) map.get(key));
						}
//						row.getStyleAttributes().setBackground((Color) map.get(key));
					}else if(key.equalsIgnoreCase(setRowLocked)) {//锁定行
						row.getStyleAttributes().setLocked((Boolean) map.get(key));
					}
				}
			}
		}
		if(rowIndex>=0) {
			setMergeSigle(rowIndex);
		}
	}
	/**
	 * 删除行
	 */
	public void removeRow() {
		int rowIndex = KDTableUtil.getSelectedRow(table);
		if(rowIndex<=0) {
			return;
		}
		rowIndex=rowIndex<0?0:rowIndex;
		//当前行数除以最大行数的余数
		int jek = rowIndex/rowCountAndDefalutValue.size()*3;
		for(int i=0;i<rowCountAndDefalutValue.size();i++) {
			try {
				table.removeRow(jek);
			}catch(Exception err){}
		}
	}
	
	/**
	 * 设置相同列值
	 * @param colName
	 * @param value
	 */
	public void setOtherCellSameVaule(int srcRowIndex,String colName,Object value) {
		for(int index=1;index<rowCountAndDefalutValue.size();index++) {
			table.getCell(srcRowIndex+index, colName).setValue(value);
		}
	}
	
	/**
	 * 设置相同列值
	 * @param colName
	 * @param value
	 */
	public void setCellSameVaule(int srcRowIndex,String colName,Object value) {
		for(int index=0;index<rowCountAndDefalutValue.size();index++) {
			table.getCell(srcRowIndex+index, colName).setValue(value);
		}
	}
	
	/**
	 * 插入分录行
	 */
	public void insertRow() {
		int rowIndex = KDTableUtil.getSelectedRow(table);
		rowIndex=rowIndex<0?0:rowIndex;
		//当前行数除以最大行数的余数
		int jek = rowIndex/rowCountAndDefalutValue.size()*3;
		exeAddRow(jek);
	}
	
	public void setMergeSigle(int rowIndex){
		String [] singleMerageCols2=new String[singleMerageCols.length+2];
		for(int i=0;i<singleMerageCols.length;i++)
			singleMerageCols2[i]=singleMerageCols[i];
		singleMerageCols2[singleMerageCols.length]="genderType";
		singleMerageCols2[singleMerageCols.length+1]="isExistDownBill";
		for(int i=0;i<singleMerageCols2.length;i++) {
			table.getMergeManager().mergeBlock(rowIndex, table.getColumnIndex(singleMerageCols2[i]), rowIndex+rowCountAndDefalutValue.size()-1, table.getColumnIndex(singleMerageCols2[i]));
		}
	}

	public KDTable getTable() {
		return table;
	}

	public void setTable(KDTable table) {
		this.table = table;
	}

	public String[] getSingleMerageCols() {
		return singleMerageCols;
	}

	public void setSingleMerageCols(String[] singleMerageCols) {
		this.singleMerageCols = singleMerageCols;
	}

	public LinkedList<HashMap<String, Object>> getRowCountAndDefalutValue() {
		return rowCountAndDefalutValue;
	}

	public void setRowCountAndDefalutValue(
			LinkedList<HashMap<String, Object>> rowCountAndDefalutValue) {
		this.rowCountAndDefalutValue = rowCountAndDefalutValue;
	}
	
}
