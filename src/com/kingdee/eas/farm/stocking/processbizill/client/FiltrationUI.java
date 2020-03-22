/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.processbizill.CreateReconciliationBillFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FiltrationUI extends AbstractFiltrationUI
{
	private static final Logger logger = CoreUIObject.getLogger(FiltrationUI.class);

	/**
	 * output class constructor
	 */
	public FiltrationUI() throws Exception
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
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		if(getUIContext().get("company")==null)
			prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		else
			prmtCompany.setValue((CompanyOrgUnitInfo)getUIContext().get("company"));

		if(getUIContext().get("period")==null)
			//获取当月期间
			//DateUtilsComm.getCurrentPeriodInfo()
			//获取当月的上个期间
			prmtPeriod.setValue(DateUtilsComm.getUpperPeriodInfo(DateUtilsComm.getCurrentPeriodInfo()));

		else
			prmtPeriod.setValue((PeriodInfo)getUIContext().get("period"));

		if(getUIContext().get("farmer")!=null){
			prmtPeriod.setEnabled(false);
			prmtCompany.setEnabled(false);
			prmtFarmers.setEnabled(false);
			prmtFarmers.setValue((FarmersInfo)getUIContext().get("farmer"));
		}else{
			prmtPeriod.setEnabled(true);
			prmtCompany.setEnabled(true);
			prmtFarmers.setEnabled(true);
		}

		prmtPeriod.setCommitFormat("$number$");
		btnDetermine.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(prmtCompany.getValue()==null)
					commUtils.giveUserTipsAndRetire("请填写公司");
				if(prmtPeriod.getValue()==null)
					commUtils.giveUserTipsAndRetire("请填写期间");
				try {
					CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo)prmtCompany.getValue();
					PeriodInfo period = (PeriodInfo)prmtPeriod.getValue();
					FarmersInfo farmers = (FarmersInfo)prmtFarmers.getValue();
					HashMap<String,Object> map = new HashMap<String,Object>();
					map.put("company", companyInfo);
					map.put("period", period);
					map.put("farmers", farmers);
					HashMap resultMap = CreateReconciliationBillFacadeFactory.getRemoteInstance().CreateReconciliationBill(map);
					MsgBox.showInfo("共生成"+resultMap.get("successQty")+"张对账单\n请在对账单列表界面刷新查看");
					destroyWindow();
					//getRemoteInstance().CreateReconciliationBill(map);
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					MsgBox.showInfo(e1.getCause().getMessage());
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					MsgBox.showInfo(e1.getCause().getMessage());
				}
			}
		});

	}

}