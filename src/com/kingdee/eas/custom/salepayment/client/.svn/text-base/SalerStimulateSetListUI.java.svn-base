/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.event.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.tree.KDTreeNode;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class SalerStimulateSetListUI extends AbstractSalerStimulateSetListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SalerStimulateSetListUI.class);
    
    /**
     * output class constructor
     */
    public SalerStimulateSetListUI() throws Exception
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


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.custom.salepayment.client.SalerStimulateSetTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "销售提成设置";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo objectValue = new com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo();
		
        return objectValue;
    }
    

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
    	// 分组校验
    	checkSelTreeNode();
    	
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * 校验选中的 分组
     */
    public void checkSelTreeNode(){
    	KDTreeNode selTreeNode = this.getSelectedTreeNode();
    	try{
	    	TreeBaseInfo treeObj = (TreeBaseInfo) selTreeNode.getUserObject();
	    	if(treeObj != null){
	    		String number = treeObj.getNumber();
	    		String name = treeObj.getName();
	    		// 编码和名称一致
	    		if(StringUtils.isNotBlank(number) && StringUtils.isNotBlank(name) && number.equals(name)){
	    			
	    				Integer year = Integer.parseInt(name);
	    				if(year < 2016 || year > 2030){
	    					MsgBox.showInfo("分类只能选编码和名称一致的 2016至2030年的有效年份，请核对");
	    					SysUtil.abort();
	    				}
	    			
	    		}else{
	    			MsgBox.showInfo("分类只能选编码和名称一致的 2016至2030年的有效年份，请核对");
	    			SysUtil.abort();
	    		}
	    	}
    	}catch(Exception e){
			MsgBox.showInfo("分类只能选编码和名称一致的 2016至2030年的有效年份，请核对");
			SysUtil.abort();
		}
    }

}