/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.cm.common.filter.CompositeFilterElement;
import com.kingdee.eas.cm.common.filter.RangeFilterElement;
import com.kingdee.eas.cm.common.verify.VerifyItem;
import com.kingdee.eas.cm.common.verify.VerifyType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.signwasthetable.SignBDInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.custom.signwasthetable.billType;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.client.SCMClientUtils;

/**
 * output class name
 */
public class SignTableQueryPanel extends AbstractSignTableQueryPanel
{
	private static final Logger logger = CoreUIObject.getLogger(SignTableQueryPanel.class);

	/**
	 * output class constructor
	 */
	public SignTableQueryPanel() throws Exception
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
	// @Override
	public FilterInfo getFilterInfo() {
		// TODO Auto-generated method stub
		FilterInfo filterInfo=new FilterInfo();


		//公司
		if(prmtCompany.getValue()!=null){
			filterInfo.getFilterItems().add(new FilterItemInfo("orgSupp",((CompanyOrgUnitInfo)prmtCompany.getValue()).getName(),CompareType.EQUALS));
		}

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			if(pkBizDateFrom.getValue()!=null){
				Date beginDate = pkBizDateFrom.getSqlDate();
				String beginDateStr = sdf.format(beginDate);
				filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",sdf.parse(beginDateStr),CompareType.GREATER));
			}
			if(pkBizDateTo.getValue()!=null){
				Date beginDate = pkBizDateTo.getSqlDate();
				String endDateStr = sdf.format(beginDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(endDateStr));
				cal.add(Calendar.DATE, 1);
				
				filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS));
			}
			
	
			//呈送人
			if(prmtPresentedPerson.getValue()!=null){
				filterInfo.getFilterItems().add(new FilterItemInfo("presentedPerson.name",((PersonInfo)prmtPresentedPerson.getValue()).getName()));
			}
	
			//单据类型
			if(prmtsighTableType.getValue()!=null){
				filterInfo.getFilterItems().add(new FilterItemInfo("billType.name",((SignBDInfo)prmtsighTableType.getValue()).getName()));
			}
	
			//单据状态
			if(kDComboBox1.getSelectedItem()!=null)
				if(!kDComboBox1.getSelectedItem().equals(""))			{
					filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",((billStatus)kDComboBox1.getSelectedItem()).getValue()));
				}
			
			if(txtCodeFrom.getStringValue()!=null){
				filterInfo.getFilterItems().add(new FilterItemInfo("number",txtCodeFrom.getStringValue(),CompareType.GREATER_EQUALS));
			}
			if(txtCodeTo.getStringValue()!=null){
				filterInfo.getFilterItems().add(new FilterItemInfo("number",txtCodeTo.getStringValue(),CompareType.LESS_EQUALS));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.handUIException(e);
		}
		return filterInfo;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		if(SysContext.getSysContext().getCurrentFIUnit()!=null)
			prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		//获取当前月第一天：
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date dateFrom = c.getTime();
		pkBizDateFrom.setValue(dateFrom);

		pkBizDateTo.setValue(new Date());

		kDComboBox1.addItem("");
		kDComboBox1.setSelectedItem("");
	}


}