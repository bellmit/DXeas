/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class StockingBreedDailyListUI extends AbstractStockingBreedDailyListUI
{
	private static final Logger logger = CoreUIObject.getLogger(StockingBreedDailyListUI.class);

	/**
	 * output class constructor
	 */
	public StockingBreedDailyListUI() throws Exception
	{
		super();
	}

	@Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{	
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
			MsgBox.showWarning("单据尚未提交，禁止再次审核！");
			SysUtil.abort();
		}
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		
		IStockingBreedDaily purorder = (IStockingBreedDaily) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				purorder.unAudit(purorder.getStockingBreedDailyInfo(pk));
				actionRefresh_actionPerformed(null);
			
		}
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}
	public String[] getSelectedListId() {
		checkSelected();
		// SelectManager 是 kdtable 中行管理类
		ArrayList blocks =tblMain.getSelectManager().getBlocks();
		ArrayList idList = new ArrayList();
		Iterator iter = blocks.iterator();
		while (iter.hasNext()) {
			KDTSelectBlock block = (KDTSelectBlock) iter.next();
			int top = block.getTop();
			int bottom = block.getBottom();
			for (int rowIndex = top; rowIndex <= bottom; rowIndex++) {
				ICell cell = tblMain.getRow(rowIndex)
						.getCell(getKeyFieldName());
				if (!idList.contains(cell.getValue())) {
					idList.add(cell.getValue());
				}
			}
		}
		String[] listId = null;
		if (idList != null && idList.size() > 0) {
			Iterator iterat = idList.iterator();
			listId = new String[idList.size()];
			int index = 0;
			while (iterat.hasNext()) {
				listId[index] = (String) iterat.next();
				index++;
			}
		}
		return listId;
	}
	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
	}
	/**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("baseStatus");
		if(list.size()>0) {
			if(list.get(0).equals("审核")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}
	}
	//设置组织隔离
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		
		FilterInfo filter = new FilterInfo();
		FilterItemInfo item = null;
		CompanyOrgUnitInfo companyFI = SysContext.getSysContext().getCurrentFIUnit();
		if(companyFI == null){
			MsgBox.showInfo("当前组织不是财务组织,无法进行相关操作!");
			SysUtil.abort();
		}

		if(!companyFI.isIsBizUnit()){
			MsgBox.showInfo("当前登录组织为虚体组织,请切换到实体组织进行相关操作");
			SysUtil.abort();
		}

		filter.getFilterItems().add(new FilterItemInfo("company.id", companyFI.getId().toString(), CompareType.EQUALS));
		
		//修改为库存组织可查看下面所有养殖场记录
		StorageOrgUnitInfo storageInfo = SysContext.getSysContext().getCurrentStorageUnit();
		Set ids=new HashSet<String>();
		ids.add("yusheID");
		if(!storageInfo.isIsCompanyOrgUnit()){
			String id=storageInfo.getId().toString();
			String sql="select distinct t1.fid from T_FM_StockingBreedDaily t1 inner join T_FM_Farm t2 on t1.CFFarmID=t2.fid where t2.FStorageOrgUnitID='"+id+"' ";
			try {
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
				while(rs.next()){
					ids.add(rs.getString("fid"));
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			filter.getFilterItems().add(new FilterItemInfo("id", ids, CompareType.INCLUDE));
			return filter;
		}
		
		return filter;
	}

	protected boolean initDefaultFilter() {
		return true;
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
	}


	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK arg0, EntityViewInfo ev) {

		SorterItemCollection sic=ev.getSorter();
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new java.util.Date();
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(nowDate)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 

		
		Date beginDate = cal.getTime();
		cal.add(Calendar.MONTH,1);//月增加1天 
		cal.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天 
		Date endDate = cal.getTime();
		StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
		System.out.println(stoInfo.getName().toString());
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
		//filter.getFilterItems().add(new FilterItemInfo("creator.number",SysContext.getSysContext().getCurrentUserInfo().getNumber(),CompareType.EQUALS));
		//20190428 macheng add 去掉养殖场过滤
		//		filter.getFilterItems().add(new FilterItemInfo("farm.name" ,"%"+stoInfo.getName().toString()+"%",CompareType.LIKE));
		//if(SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null){
			//String number = SysContext.getSysContext().getCurrentUserInfo().getPerson().getNumber();
			//filter.getFilterItems().add(new FilterItemInfo("bizPerson.number",number,CompareType.EQUALS));
			//filter.setMaskString("#0 AND #1 AND (#2 or #3) AND #4");
			filter.setMaskString("#0 AND #1");
		//}

		ev.setFilter(filter);
		ds.setDefalutEntityViewInfo(ev);
		return ds;
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory.getRemoteInstance();
	}
	/**
     * 设置默认过滤条件
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
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo();

		return objectValue;
	}

}