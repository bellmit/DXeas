/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class LayEggDailyListUI extends AbstractLayEggDailyListUI
{
    private static final Logger logger = CoreUIObject.getLogger(LayEggDailyListUI.class);
    
    // ��ǰ��ֳ��
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public LayEggDailyListUI() throws Exception
    {
        super();
        this.setUITitle("��ֳ�ձ�");
    	// ��ǰ ��ֳ��
		StorageOrgUnitInfo currStoorg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoorg == null){
			MsgBox.showInfo("��ǰδ���κο����֯");
			SysUtil.abort();
		}
		try{
			currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(currStoorg.getId().toString());
		}catch(BOSException bose){
			MsgBox.showInfo(bose.getMessage());
			SysUtil.abort();
		}
		if(currStoorg == null){
			MsgBox.showInfo("��ǰδ���κ���ֳ���������л�����Ӧ��ֳ����������ز���");
			SysUtil.abort();
		}
        // Ĭ�Ϲ�������
		this.setFilterForQuery(this.getFilterInfo());
    }
    /**
     * �����ʼ�� 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ����ȫ��
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
    }

//	public RequestContext prepareActionCreateTo(IItemAction itemAction)
//			throws Exception {
//		RequestContext request = super.prepareActionCreateTo(itemAction);
//		ArrayList idList = new ArrayList();
//		getBillIdList(idList, new ArrayList());
//		request.setIdList(idList);
//		return request;
//	}

//	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
//		setCanVoucher(false);
//
//		checkSelected();
//		ArrayList idList = new ArrayList();
//		List entriesKey = new ArrayList();
//
//		getBillIdList(idList, entriesKey);
//		checkEntryNumber(entriesKey);
//		String[] idArray = new String[idList.size()];
//		idList.toArray(idArray);
//		if (this.isDAPTrans) {
//			entriesKey.clear();
//		}
//		this.billList.createTo(idArray, new String[] { getEntriesName() },
//				entriesKey, getBizType().toString(), getBOTPSelectors());
//	}

    /**
     * ����Ĭ�Ϲ�������
     */
    @Override
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
    	if(stoInfo == null){
    		SysUtil.abort();
    	}
    	
    	filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.longNumber",stoInfo.getLongNumber()+"%" ,CompareType.LIKE));
    	
    	
    	return filterInfo;
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

   
    @Override
	public void actionToStockDaily_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
    	//LayEggFacadeFactory.getRemoteInstance().toStockDaily();
		super.actionToStockDaily_actionPerformed(e);
	}
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.layegg.LayEggDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo();
		
        return objectValue;
    }

    /**
     * ���
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("������");
			
			this.refreshList();
			this.setMessageText("������");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * �����
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("��������");
			
			this.refreshList();
			this.setMessageText("��������");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
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


	/**
	 * ��ҵ�����ڽ�������
	 */
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,
			EntityViewInfo viewInfo) {
		SorterItemCollection sic = new SorterItemCollection();
		SorterItemInfo siInfo = new SorterItemInfo("bizDate");
		siInfo.setSortType(SortType.DESCEND);
		sic.add(siInfo);
		viewInfo.setSorter(sic);
		return super.getQueryExecutor(queryPK, viewInfo);
	}
	@Override
	public void actionReShareInfos_actionPerformed(ActionEvent e)
			throws Exception {
		try{
			super.actionReShareInfos_actionPerformed(e);
		}catch(BOSException fe){
			MsgBox.showError(fe.getMessage());
		}
	}
	
	
	
	
}