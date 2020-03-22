/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IColumn;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.query.QuickFilteringSupportItems;

/**
 * output class name
 */
public class BasicPostListUI extends AbstractBasicPostListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BasicPostListUI.class);
    QuickFilteringSupportItems qfsi;
    /**
     * output class constructor
     */
    public BasicPostListUI() throws Exception
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
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }


    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.BasicPostInfo objectValue = new com.kingdee.eas.custom.wages.BasicPostInfo();
		
        return objectValue;
    }
    public String[] getMergeColumnKeys() {
		// TODO Auto-generated method stub
		return new String[]{"number","postname","theGroup","ProductRatio","BaseStatus","coefficient","ExtractFrom","slaughter","createTime","creator.number","creator.name","lastUpdateTime","lastUpdateUser.number","lastUpdateUser.name"};
	}
    
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setMergeColumn();
		
	}

	private void setMergeColumn()
	{
	  String[] mergeColumnKeys = getMergeColumnKeys();
	  if ((mergeColumnKeys == null) || (mergeColumnKeys.length <= 0))
	    return;
	  this.tblMain.checkParsed();
	  this.tblMain.getGroupManager().setGroup(true);
	  IColumn col = null;
	  for (int i = 0; i < mergeColumnKeys.length; ++i)
	  {
	    col = this.tblMain.getColumn(mergeColumnKeys[i]);
	    if (col != null) {
	      col.setGroup(true);
	      col.setMergeable(true);
	    } else {
	      logger.info("mergeColumn no found:" + mergeColumnKeys[i]);
	    }
	  }
	}

	
}