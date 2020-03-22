/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.client;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.FrameWorkException;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.tools.datatask.DatataskMode;
import com.kingdee.eas.tools.datatask.DatataskParameter;
import com.kingdee.eas.tools.datatask.client.DatataskCaller;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class BasePriceOfOtherCompanyListUI extends AbstractBasePriceOfOtherCompanyListUI
{
	private static final Logger logger = CoreUIObject.getLogger(BasePriceOfOtherCompanyListUI.class);

	/**
	 * output class constructor
	 */
	public BasePriceOfOtherCompanyListUI() throws Exception
	{
		super();
	}

	/**	和单据过滤的代码是一样的，只不过是  过滤的条件不一样
	*	要求：entity  里面  BaseEntry  里面的不允许删除
	*   query   里面  其它 主键定义  包含entry.id  【猜测，如果此处不包含】
	*/
	protected FilterInfo getDefaultFilterForQuery(){
		FilterInfo filter =  super.getDefaultFilterForQuery();
		FilterInfo filterNew = new FilterInfo();
		filterNew.getFilterItems().add(new FilterItemInfo("Entrys.seq",new Integer(1),CompareType.EQUALS));
		filterNew.getFilterItems().add(new FilterItemInfo("Entrys.seq",null,CompareType.EQUALS));
		filterNew.setMaskString("#0 or #1");

		try{
			if(filter != null){
				filter.mergeFilter(filterNew, "and");
			}else{
				filter = filterNew;
			}

		}catch(BOSException e){
			e.printStackTrace();
			this.handleException(e);
		}
		return filterNew;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionExportData_actionPerformed(ActionEvent e)
	throws Exception {
		String destBillEditUIClassName ="com.kingdee.eas.tools.datatask.client.DIETemplateListUI";
        Map map = new UIContext(this);
        map.put("isDioMainUIFilter","isDioMainUIFilter");
        map.put(UIContext.OWNER, this);
        IUIWindow uiWindow = null ;
        uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
        //开始展现UI
        uiWindow.show();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionImportData_actionPerformed(ActionEvent e)
	throws Exception {
		String destBillEditUIClassName ="com.kingdee.eas.tools.datatask.client.DioMainUI";
        Map map = new UIContext(this);
        map.put("isDioMainUIFilter","isDioMainUIFilter");
        map.put(UIContext.OWNER, this);
        IUIWindow uiWindow = null ;
        uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
        //开始展现UI
        uiWindow.show();
    }
	

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}


	/**
	 * output menuItemImportData_actionPerformed method
	 */
	protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemImportData_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo objectValue = new com.kingdee.eas.custom.stockprice.BasePriceOfOtherCompanyInfo();
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	/**
	 * @return 人民币info   CNY
	 */
	protected CurrencyInfo getCurrencyByRMB() throws BOSException, EASBizException, SQLException{
		String str = "select * from T_BD_Currency where fname_l2='人民币'";
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
		if(rs.next())
			return CurrencyFactory.getRemoteInstance().getCurrencyInfo(new ObjectUuidPK(rs.getString("fid")));
		return null;
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		btnImportData.setIcon(EASResource.getIcon("imgTree_import"));
		btnExportModel.setIcon(EASResource.getIcon("imgTbtn_importexcel"));
		btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		this.setUITitle("外部公司价格");
	}

	@Override
	public void onShow() throws Exception {
		super.onShow();
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
	}
	
	

}