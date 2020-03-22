/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.framework.ITreeBase;

/**
 * output class name
 */
public class CCPigBreedModelListUI extends AbstractCCPigBreedModelListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCPigBreedModelListUI.class);
    
    /**
     * output class constructor
     */
    public CCPigBreedModelListUI() throws Exception
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
        return com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.pig.ccpig.client.CCPigBreedModelTreeEditUI.class.getName();
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
        return "商品猪养殖规范";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo();
		
        return objectValue;
    }


    @Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filter =  super.getDefaultFilterForQuery();
		FilterInfo filterNew = new FilterInfo();
		filterNew.getFilterItems().add(new FilterItemInfo("entrys.seq",new Integer(1),CompareType.EQUALS));
		filterNew.getFilterItems().add(new FilterItemInfo("entrys.seq",null,CompareType.EQUALS));
		filterNew.setMaskString("#0 OR #1");
		
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
		return filter;
	}
    
    
}