/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class BreedModelListUI extends AbstractBreedModelListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedModelListUI.class);
    
    /**
     * output class constructor
     */
    public BreedModelListUI() throws Exception
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
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.BreedModelFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.BreedModelTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.breed.client.BreedModelTreeEditUI.class.getName();
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
        return "饲喂规范";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedModelInfo objectValue = new com.kingdee.eas.farm.breed.BreedModelInfo();
		
        return objectValue;
    }

    /**
     * 不进行组织隔离
     */
	@Override
	protected boolean isIgnoreCUFilter() {
		
		return true;
	}

	@Override
	protected boolean initDefaultFilter() {
		return super.initDefaultFilter();
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filter =  super.getDefaultFilterForQuery();
		FilterInfo filterNew = new FilterInfo();
		filterNew.getFilterItems().add(new FilterItemInfo("entrys.seq",new Integer(1),CompareType.EQUALS));
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

	
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
	}

	/**
	 * 解决 叙事簿多行问题
	 */
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK, EntityViewInfo viewInfo) {
		queryPK =  new MetaDataPK("com.kingdee.eas.farm.breed.app", "BreedModelF7Query");
		return super.getQueryExecutor(queryPK, viewInfo);
	}
	
	
	
}