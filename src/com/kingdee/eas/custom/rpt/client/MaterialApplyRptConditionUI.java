/**
 * output package name
 */
package com.kingdee.eas.custom.rpt.client;

import java.awt.event.*;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.sql.ParserException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.SysConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.RptConditionManager;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class MaterialApplyRptConditionUI extends AbstractMaterialApplyRptConditionUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaterialApplyRptConditionUI.class);
	protected static String stoOrgUnitName=null;
	protected static String breedBtachID=null;
	/**
	 * output class constructor
	 */
	public MaterialApplyRptConditionUI() throws Exception
	{
		super();
		innitUIParam();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams param = new RptParams();
        // 放置本界面的参数
        RptConditionManager rcm = new RptConditionManager();
        rcm.setProperty("stoOrgUnit",(StorageOrgUnitInfo)prmtstoOrg.getValue());
        rcm.setProperty("breedBatch", (BreedBatchInfo)prmtbreedBatch.getValue());
        Map map = rcm.toMap();
        param.putAll(map);
        return param;
	}

	@Override
	public void onInit(RptParams arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 校验信息
	 */
	@Override
	public boolean verify() {
		// TODO Auto-generated method stub
		if(prmtstoOrg.getValue()==null){
			MsgBox.showInfo("养殖场不能为空");
			SysUtil.abort();
		}
		if(prmtbreedBatch.getValue()==null){
			MsgBox.showInfo("批次不能为空");
			SysUtil.abort();
		}
		return super.verify();
	}

	@Override
	public void setCustomCondition(RptParams arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 初始化界面参数
	 */
	private void innitUIParam() {
		// TODO Auto-generated method stub
		
		this.prmtbreedBatch.setEditable(true);		
		this.prmtbreedBatch.setDisplayFormat("$number$");		
		this.prmtbreedBatch.setEditFormat("$number$");		
		this.prmtbreedBatch.setCommitFormat("$number$");	

		//库存组织过滤
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("longNumber","1!3%",CompareType.LIKE));//取自养殖场的库存组织
		filter.getFilterItems().add(new FilterItemInfo("isBizUnit",true,CompareType.EQUALS));//实体库存组织
		evi.setFilter(filter);
		prmtstoOrg.setEntityViewInfo(evi);

		//养殖批次过滤
		prmtstoOrg.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub]
				prmtbreedBatch.setValue(null);
				
				
				if(prmtstoOrg.getValue()!=null)
					stoOrgUnitName=((StorageOrgUnitInfo)prmtstoOrg.getValue()).getName();
				EntityViewInfo evi=new EntityViewInfo();
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("stoOrg.name",stoOrgUnitName,CompareType.EQUALS));//取自养殖场的库存组织
				evi.setFilter(filter);
				prmtbreedBatch.setEntityViewInfo(evi);
			}

		});


	}
}