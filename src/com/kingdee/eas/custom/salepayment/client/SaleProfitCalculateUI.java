/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.cp.eip.mc.web.service.MessageWebService.Msg;
import com.kingdee.eas.custom.salepayment.CompanyTargetInfo;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateFacadeFactory;
import com.kingdee.eas.custom.salepayment.bean.SaleProfitResultInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SaleProfitCalculateUI extends AbstractSaleProfitCalculateUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleProfitCalculateUI.class);
    
    private CompanyOrgUnitInfo currentCompany;
    /**
     * output class constructor
     */
    public SaleProfitCalculateUI() throws Exception
    {
    	
        super();
        
        currentCompany = SysContext.getSysContext().getCurrentFIUnit();
        if(currentCompany == null){
        	MsgBox.showInfo("请在需要计算损益的财务组织中进行损益计算");
        	SysUtil.abort();
        }
        // 设置公司
        setCompany(currentCompany);
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnExecute_actionPerformed method
     */
    protected void btnExecute_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) this.prmtCompany.getValue();
    	CompanyTargetInfo selTarget = (CompanyTargetInfo) this.prmtCompanyTarget.getValue();
    	
    	// 公司和目标都不为空才能执行
    	if(companyInfo != null && selTarget != null){
    		if(MsgBox.showConfirm2("确认按选中的指标进行损益计算？") == MsgBox.OK){
    			SaleProfitResultInfo  resultInfo = (SaleProfitResultInfo) SaleProfitCalculateFacadeFactory.getRemoteInstance().calculateCompanyTarget(companyInfo.getId().toString(), selTarget.getId().toString());
    			MsgBox.showInfo("计算完成");
    			SysUtil.abort();
    		}
    	}else{
    		MsgBox.showInfo("请选择公司和要执行的公司指标");
    		SysUtil.abort();
    	}
//        this.pbProgress.
    }

    /**
     * 初始化
     */
	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// 公司过滤条件 
		this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtCompany.setVisible(true);		
        this.prmtCompany.setEditable(true);		
        this.prmtCompany.setDisplayFormat("$name$");		
        this.prmtCompany.setEditFormat("$number$");		
        this.prmtCompany.setCommitFormat("$number$");		
        this.prmtCompany.setRequired(true);		
        this.prmtCompany.setEnabled(false);
    	// 公司目标 F7设置
        this.prmtCompanyTarget.setQueryInfo("com.kingdee.eas.custom.salepayment.app.CompanyTargetQuery");		
        this.prmtCompanyTarget.setVisible(true);		
        this.prmtCompanyTarget.setEditable(true);		
        this.prmtCompanyTarget.setDisplayFormat("$number$");		
        this.prmtCompanyTarget.setEditFormat("$number$");		
        this.prmtCompanyTarget.setCommitFormat("$number$");		
        this.prmtCompanyTarget.setRequired(false);	
        		prmtCompanyTarget.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI prmtCompanyTarget_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCompanyTarget_F7ListUI == null) {
					try {
						prmtCompanyTarget_F7ListUI = new com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCompanyTarget_F7ListUI));
					prmtCompanyTarget_F7ListUI.setF7Use(true,ctx);
					prmtCompanyTarget.setSelector(prmtCompanyTarget_F7ListUI);
				}
			}
		});
	}
    /**
     * 设置公司 以及 公司指标的过滤条件
     * @param companyOrg
     */
    private void setCompany(CompanyOrgUnitInfo companyOrg){
    	this.prmtCompany.setValue(companyOrg);
    
        
        // 设置过滤条件		
		EntityViewInfo view = new EntityViewInfo();
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.getFilterItems().add(new FilterItemInfo("company.id",companyOrg.getId().toString(),CompareType.EQUALS));
        SorterItemInfo sortItem = new SorterItemInfo("year");
		sortItem.setSortType(SortType.DESCEND);
		view.getSorter().add(sortItem);
		view.setFilter(filterInfo);
		
		this.prmtCompanyTarget.setEntityViewInfo(view);
        
    }

}