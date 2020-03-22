package com.kingdee.eas.custom.stockprice.showDioMainUI;

import java.awt.Toolkit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.tools.datatask.DIETemplate;
import com.kingdee.eas.tools.datatask.client.DIETemplateListUI;
import com.kingdee.eas.tools.datatask.client.DioMainUI;


/**
 * 打开界面时自动  选择 已定义好的模板
 */
public class openDioMainUIFilter {
	//	protected PayRequestBillInfo editData;
	public Boolean  openDioMainUI(Object ui) throws EASBizException, BOSException
	{	
		DioMainUI listUI = (DioMainUI)ui;
		String bool = (String) listUI.getUIContext().get("isDioMainUIFilter");
		if(bool!=null&&bool.equals("isDioMainUIFilter")){
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("name","物料基本价格"));
			listUI.setFilterForQuery(filter);
			listUI.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		}
		return null;
	}
	/**
	 * 引出模板时   打开导入导出模板界面
	 */
	public void openDIETemplateListUI(Object ui)  throws EASBizException, BOSException{
	DIETemplateListUI listUI = (DIETemplateListUI)ui;
	String bool = (String) listUI.getUIContext().get("isDioMainUIFilter");
	if(bool!=null&&bool.equals("isDioMainUIFilter")){
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("name","物料基本价格"));
		listUI.setFilterForQuery(filter);
		listUI.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
}
}