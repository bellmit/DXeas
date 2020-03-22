/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.query.QuickFilteringSupportItems;

/**
 * output class name
 */
public class MonthWagesListUI extends AbstractMonthWagesListUI
{
    private static final Logger logger = CoreUIObject.getLogger(MonthWagesListUI.class);
    QuickFilteringSupportItems qfsi;
    /**
     * output class constructor
     */
    public MonthWagesListUI() throws Exception
    {
        super();
        qfsi = new QuickFilteringSupportItems(true, true);
    }
    //3.重写getQuickFilteringSupport 返回QuickFilteringSupportItems
    @Override
    protected QuickFilteringSupportItems getQuickFilteringSupport()   {
    	if(isNeedQueryFilter()) {
    		qfsi.getSystemSolutionItem().setSolutionInfo(getCurrentSolutionInfo());
    		qfsi.setMustQueryAtFirst(true);//打开界面是否默认查询，基础资料可启用此选项
    		qfsi.supportExecutionWithoutFilters();
    		return qfsi;
    	}else {
    		return super.getQuickFilteringSupport();
    	}
	}

    protected boolean isNeedQueryFilter() {
    	return true;
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillListUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		refresh(getActionEvent());
		//UITools.apendFootRow(tblMain, getSumColNames());
	}

//	/* (non-Javadoc)
//	 * @see com.kingdee.eas.framework.client.CoreBillListUI#onShow()
//	 */
//	@Override
//	public void onShow() throws Exception {
//		// TODO Auto-generated method stub
//		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
//		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
//		super.onShow();
//	}

	/**
     * 设置合计行
     * @return
     */
    protected String[] getSumColNames()
    {
    	
        return new String[] { "entry.pieceMoney","entry.pieceAmount"};
    }
    
    /**
     * 设置合计行
     * @return
     */
	@Override
    public List<String> getFieldSumList()
    {
    	List<String> sumField = super.getFieldSumList();
    	if(sumField == null) sumField = new ArrayList<String>();
    	
    	sumField.add("Entry.fractionWages");
    	sumField.add("Entry.bythejobWages");
    	sumField.add("Entry.seniorityWages");
    	sumField.add("Entry.sanctionWages");
    	sumField.add("Entry.attendanceWages");
    	sumField.add("Entry.lifeWages");
    	sumField.add("Entry.postWages");
    	sumField.add("Entry.introduceWages");
    	sumField.add("Entry.adjustmentWages");
    	sumField.add("Entry.allWags");
    	sumField.add("Entry.basicWages");
    	
    
        return sumField;
    }
	
	protected void afterTableFillData(KDTDataRequestEvent e) {
		// TODO Auto-generated method stub
		super.afterTableFillData(e);
	}
	@Override
	protected void execQuery() {
		
		super.execQuery();
	}
	@Override
	protected IRow appendFootRow() {
		// TODO Auto-generated method stub
		return super.appendFootRow();
	}
	
    
	@Override
	protected boolean isFootVisible() {
		return true;
	}
	

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.MonthWagesFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.MonthWagesInfo objectValue = new com.kingdee.eas.custom.wages.MonthWagesInfo();
		
        return objectValue;
    }

}