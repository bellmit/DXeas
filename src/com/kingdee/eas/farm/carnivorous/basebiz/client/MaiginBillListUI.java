/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ctrl.kdf.table.IBlock;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.ListUIController;
import com.kingdee.eas.framework.client.ListUiHelper;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;

/**
 * output class name
 */
public class MaiginBillListUI extends AbstractMaiginBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaiginBillListUI.class);
	/**
	 * output class constructor
	 */
	public MaiginBillListUI() throws Exception
	{
		super();
	}
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("BillStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
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
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,getSelectedKeyValue())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
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
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	private void initControl() throws Exception{

		//生成凭证按钮可见可编辑
		btnVoucher.setVisible(true);
		btnVoucher.setEnabled(true);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

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
		ArrayList list = this.getSelectedFieldValues("billStatus");
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

	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		return super.getDefaultFilterForQuery();
	}

	protected boolean initDefaultFilter() {
		return true;
	}



	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControl();
		setUITitle("保证金收退单");		
	}


	@Override
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String[] billIdlist = getSelectListId();  
		super.actionVoucher_actionPerformed(e);
		if(billIdlist==null){
			return;
		}
		for(int j=0;j<billIdlist.length;j++){
			String id=billIdlist[j];
			if(StringUtils.isEmpty(id))
				return;
			//校验生成凭证
			ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "2652E01E");
			if(destObejctIDs.size()==1){
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_MaiginBill set CFVoucherNumID='"+destObejctIDs.get(0)+"' where fid='"+id+"'");
			}
		}
		refreshList();
	}


	public String[] getSelectListId(){
		String listId[] = null;
		ArrayList blocks = tblMain.getSelectManager().getBlocks();
		ArrayList idList = new ArrayList();
		Iterator iter = blocks.iterator();
		while(iter.hasNext()){
			KDTSelectBlock block = (KDTSelectBlock)iter.next();
			int top = block.getTop();
			int bottom = block.getBottom();
			for(int rowIndex = top;rowIndex<=bottom; rowIndex++){
				ICell cell = tblMain.getRow(rowIndex).getCell(getKeyFieldName());
				if(!idList.contains(cell.getValue())){
					idList.add(cell.getValue());
				}
			}
		}
		if(idList!=null&&idList.size()>0){
			Iterator iterat = idList.iterator();
			listId = new String[idList.size()];
			int index = 0 ;
			while(iterat.hasNext()){
				listId[index]=(String)iterat.next();
				index++;
			}
		}
		return listId;
	}

	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(nowDate)));
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
			ds.setDefalutEntityViewInfo(ev);		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ds;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MaiginBillInfo();

		return objectValue;
	}

}