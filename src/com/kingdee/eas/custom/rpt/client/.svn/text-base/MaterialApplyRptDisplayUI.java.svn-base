/**
 * output package name
 */
package com.kingdee.eas.custom.rpt.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.rpt.MaterialApplyFacadeFactory;
import com.kingdee.eas.custom.rpt.app.MaterialApplyFacadeControllerBean;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.bireport.bimanager.util.StringUtils;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class MaterialApplyRptDisplayUI extends AbstractMaterialApplyRptDisplayUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaterialApplyRptDisplayUI.class);

	/**
	 * output class constructor
	 */
	public MaterialApplyRptDisplayUI() throws Exception
	{
		super();
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

	/**
	 * 弹出过滤框
	 */
	@Override
	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		// TODO Auto-generated method stub
		return new MaterialApplyRptConditionUI();
	}

	/**
	 * Facade实现类
	 */
	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		// TODO Auto-generated method stub
		return MaterialApplyFacadeFactory.getRemoteInstance();
	}

	/**
	 * 返回界面的表格
	 */
	@Override
	protected KDTable getTableForPrintSetting() {
		// TODO Auto-generated method stub
		return this.tblMain;
	}

	@Override
	protected void query() {
		// TODO Auto-generated method stub
		tblMain.removeRows();
		label.setText(((StorageOrgUnitInfo)params.getObject("stoOrgUnit")).getName().toString()+"第"+((BreedBatchInfo)params.getObject("breedBatch")).getNumber()+"批鸡用药情况分析");
		try {
			RptParams rps = getRemoteInstance().query(params);

			IRowSet rs=(IRowSet) rps.getObject("data");
			if(rs.size()==0){
				MsgBox.showInfo("当前批次没有使用任何药品");
				SysUtil.abort();
			}

			tblMain.removeHeadRows();
			tblMain.removeRows();
			tblMain.removeColumns();

			//单据头
			RptTableHeader header = createHeader(rps.getInt("minDays"),rps.getInt("maxDays"));
			KDTableUtil.setHeader(header, this.tblMain);

			if(tblMain.getColumnCount()<12)
				tblMain.setAutoResize(true);
			insertRows(rs);


		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 插入数据行
	 * @param rs
	 */
	private void insertRows(IRowSet rs) {
		// TODO Auto-generated method stub
		ArrayList<String> henHouseName=new ArrayList<String>();

		try {
			while(rs.next()){
				if(henHouseName.contains(rs.getString("henHouseName"))){

				}else{
					henHouseName.add(rs.getString("henHouseName"));
					tblMain.addRow();
					tblMain.getRow(tblMain.getRowCount()-1).setHeight(30);
					tblMain.getCell(tblMain.getRowCount()-1, 0).setValue(rs.getString("henHouseName"));
				}
				for(int i=1;i<tblMain.getColumnCount();i++){
					if(rs.getInt("startDate")<=Integer.parseInt(tblMain.getColumn(i).getKey())&&rs.getInt("endDate")>=Integer.parseInt(tblMain.getColumn(i).getKey())){
						if(tblMain.getCell(tblMain.getRowCount()-1, i).getValue()==null||StringUtils.isEmpty((String) tblMain.getCell(tblMain.getRowCount()-1, i).getValue()))
							tblMain.getCell(tblMain.getRowCount()-1, i).setValue(rs.getString("materialName"));
						else
							tblMain.getCell(tblMain.getRowCount()-1, i).setValue(tblMain.getCell(tblMain.getRowCount()-1, i).getValue()+","+rs.getString("materialName"));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private RptTableHeader createHeader(int minDays, int maxDays) {
		// TODO Auto-generated method stub
		RptTableHeader header = new RptTableHeader();
		StringBuffer headerLabel=new StringBuffer();
		headerLabel.append("鸡舍");
		RptTableColumn col=new RptTableColumn("henHouse");
		header.addColumn(col);

		for(int i=minDays;i<=maxDays;i++){
			headerLabel.append(",").append(String.valueOf(i)).append("日龄");
			col=new RptTableColumn(String.valueOf(i));
			col.setWidth(150);
			header.addColumn(col);
		}
		header.setLabels(new Object[][] { headerLabel.toString().split(",") });
		return header;
	}





}