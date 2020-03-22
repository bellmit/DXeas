/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;

/**
 * output class name
 */
public class DayRateCostDetailListUI extends AbstractDayRateCostDetailListUI
{
    private static final Logger logger = CoreUIObject.getLogger(DayRateCostDetailListUI.class);
    
    /**
     * output class constructor
     */
    public DayRateCostDetailListUI() throws Exception
    {
        super();
        this.actionAudit.setVisible(false);
        this.actionUnAudit.setVisible(false);
//        this.actionAddNew.setVisible(false);
        this.actionEdit.setVisible(false);
        this.actionRemove.setVisible(false);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.DayRateCostDetailFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo();
		
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.mBtnCal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exeDayrateCal();
			}});
	}
	/**
	 * 执行成本计算
	 */
	private void exeDayrateCal() {
		try {
			UIContext uiContext = new UIContext(this);
	    	IUIWindow uiWindow = null ;
	    	// UIFactoryName.MODEL 为弹出模式
	    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.dayratecost.client.DayRateCalOPUI", uiContext, null,OprtState.VIEW);
	    	//开始展现UI
	    	uiWindow.show();
	    	actionRefresh_actionPerformed(null);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		return super.getDefaultFilterForQuery();
	}
	
	protected boolean initDefaultFilter() {
		return true;
	}

	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {
		
		SorterItemCollection sic=new SorterItemCollection();
		SorterItemInfo si =new SorterItemInfo("bizDate");
		si.setSortType(SortType.DESCEND);
		sic.add(si);
		ev.setSorter(sic);
		return super.getQueryExecutor(arg0, ev);
	}
	
	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		Date endDate = cal.getTime();
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}
}