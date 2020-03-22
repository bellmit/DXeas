/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFacade;
import com.kingdee.eas.farm.stocking.basedata.StockingFacadeFactory;
import com.kingdee.eas.farm.stocking.basedata.app.CreateCostObjectUIHandler;
import com.kingdee.eas.farm.stocking.basedata.app.StockingBatchControllerBean;
import com.kingdee.eas.farm.stocking.basedata.app.StockingFacadeControllerBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CreateCostObjectUI extends AbstractCreateCostObjectUI {
	private static final Logger logger = CoreUIObject.getLogger(CreateCostObjectUI.class);

	/**
	 * output class constructor
	 */
	public CreateCostObjectUI() throws Exception {
		super();
		this.setUITitle("创建批次成本对象");
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		
		//设置F7控件
		PromptCostOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");
		PromptCostOrg.setVisible(true);
		PromptCostOrg.setEditable(true);
		PromptCostOrg.setDisplayFormat("$name$");
		PromptCostOrg.setEditFormat("$name$");
		PromptCostOrg.setCommitFormat("$name$");
		
		CompanyF7 cf7=new CompanyF7();
		PromptCostOrg.setSelector(cf7);
		PromptCostOrg.setRequired(true);
		this.PromptCostOrg.setValue(SysContext.getSysContext().getCurrentFIUnit());

	}

	/**
	 * output kDButton1_actionPerformed method
	 */
	protected void kDButton1_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		super.kDButton1_actionPerformed(e);

//		StockingFacade stockFacade=new StockingFacade();
//		StockingFacadeControllerBean stockFacade=new StockingFacadeControllerBean();
		
		String companyID = null;
		if (PromptCostOrg.getValue() != null) {
			companyID = ((IPropertyContainer) PromptCostOrg.getValue()).getString("id");
			System.out.print("CompanyID"+companyID);
//			stockFacade.CreateCostObject(companyID);
			
			
			StockingFacadeFactory.getRemoteInstance().CreateCostObject(companyID);
			MsgBox.showInfo("成本对象生成完成！");
		}else{
			MsgBox.showWarning("ererer");
		}
		
		
//		exeQueryAndCreateCostObject();

	}

	private void exeQueryAndCreateCostObject() {

		String companyID = null;
		if (PromptCostOrg.getValue() != null) {
			companyID = ((IPropertyContainer) PromptCostOrg.getValue()).getString("id");
		}
		StringBuffer sql = new StringBuffer();
		sql.append("select FID,FCostItemID,FEggCostItemID from T_FM_StockingBath ");

		if (StringUtils.isNotEmpty(companyID)) {
			sql.append(" where FCompanyID='").append(companyID).append("'");
		}

		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			System.out.print("rs是："+rs);
			try {
				if (rs != null) {
					while (rs.next()) {

						if (rs.getString("FCostItemID") == null || rs.getString("FEggCostItemID") == null) {
							
						}
						if(rs.getString("FCostItemID") == null){
							
							//创建育成成本对象
							StockingBatchControllerBean sbControllerBean=new StockingBatchControllerBean();
							StockingBatchInfo model= (StockingBatchInfo) StockingBatchFactory.getRemoteInstance();
							 
//							sbControllerBean.audit(ctx, model);
						}
						if(rs.getString("FEggCostItemID")==null){
							//创建种蛋成本对象
							
							
						}

					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}