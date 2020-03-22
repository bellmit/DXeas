/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class WeighLogListUI extends AbstractWeighLogListUI
{
    private static final Logger logger = CoreUIObject.getLogger(WeighLogListUI.class);
    
    /**
     * output class constructor
     */
    public WeighLogListUI() throws Exception
    {
        super();
    }


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.WeighLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.WeighLogInfo objectValue = new com.kingdee.eas.weighbridge.WeighLogInfo();
		
        return objectValue;
    }


	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			
			if (this.toolBar.getComponent(i).getName() != null && this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnRefresh")) {
				
				continue;
			}
			if (this.toolBar.getComponent(i).getName() != null && this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnQuery")) {
				
				continue;
			}
			this.toolBar.getComponent(i).setVisible(false);
		}
		
		this.actionEdit.setVisible(false);
		this.actionRemove.setVisible(false);
	}
	@Override
	protected boolean initDefaultFilter() {
		return true;
	}
	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfDetail = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String dateStartStr = sdf.format(nowDate);
		try {
			Date dateEnd = sdfDetail.parse(dateStartStr+" 23:59:59");
		
		
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("createTime",sdf.parse(dateStartStr),CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("createTime",dateEnd,CompareType.LESS_EQUALS));
			ev.setFilter(filter);
			ds.setDefalutEntityViewInfo(ev);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
}