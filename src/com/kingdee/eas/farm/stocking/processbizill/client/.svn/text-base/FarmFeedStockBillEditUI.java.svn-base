/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.BillStateEnum;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.EntryBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FarmFeedStockBillEditUI extends AbstractFarmFeedStockBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmFeedStockBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;//f7控件
	private boolean isLoadField=false;
	private OrgUnitInfo orgInfo = null;//库存组织

	/**
	 * output class constructor
	 */
	public FarmFeedStockBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

	}
	@Override
	//加载控件到当前页面
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		this.contbaseStatus.setEnabled(false);
		initControl();
		super.onLoad();
	}
	//onload（）方法中的内容
	private void initControl() {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		//设置时间格式
		this.pkBizDate.setDatePattern("yyyy-MM-dd");
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		//重新解析表格
		kdtEntrys.checkParsed();
		

		((KDBizPromptBox)kdtEntrys.getColumn("material").getEditor().getComponent()).setDisplayFormat("$name$");

		//设置期初数量的显示格式
		this.kdtEntrys.getColumn("initialDate").getStyleAttributes().setNumberFormat("#.00");
		//设置对公司的过滤
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}
		});

		this.kdtEntrys.addKDTEditListener(new KDTEditListener(){
			//			@Override
			public void editStarting(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
			}

			//@Override
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getColIndex() == kdtEntrys.getColumnIndex("stockingBatch")){
				stockingBatch_Changed(arg0);
				}
				material_Changed(arg0);
				if(arg0.getColIndex() == kdtEntrys.getColumnIndex("initialDate")){
					initialDate_Changed(arg0);
					}
				}

			//			@Override
			public void editStopping(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			//			@Override
			public void editValueChanged(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			//			@Override
			public void editCanceled(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}

			//			@Override
			public void editStarted(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

			}});
		
		
	}
	protected void initialDate_Changed(KDTEditEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getValue()!= null ){
			kdtEntrys.getCell(arg0.getRowIndex(),"initialDate").setValue(arg0.getValue());
		}
	}
	protected void material_Changed(KDTEditEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getColIndex() == kdtEntrys.getColumnIndex("material")){
			if(arg0.getValue()!=null) {
				MaterialInfo mInfo;
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("baseUnit.*"));
				for(int i =0;i<kdtEntrys.getColumnCount();i++) {
					try {
						mInfo =  MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(((AbstractCoreBaseInfo)kdtEntrys.getCell(arg0.getRowIndex(),"material").getValue()).getId()),slor);
						kdtEntrys.getCell(arg0.getRowIndex(),"material").setValue(mInfo);
						kdtEntrys.getCell(arg0.getRowIndex(),"materialName").setValue(mInfo.getName());
						kdtEntrys.getCell(arg0.getRowIndex(),"model").setValue(mInfo.getModel());
						kdtEntrys.getCell(arg0.getRowIndex(),"basicunit").setValue(mInfo.getBaseUnit());
//						kdtEntrys.getCell(arg0.getRowIndex(),"unit").setValue(mInfo.getSeqUnit());
						

					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

	}
	protected void stockingBatch_Changed(KDTEditEvent arg0) {
		// TODO Auto-generated method stub

		if(isLoadField) {
			return;
		}
		isLoadField=true;
		if(kdtEntrys.getCell(arg0.getRowIndex(),"stockingBatch").getValue()!=null) {

			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("farmer.*");
			slor.add("farm.*");
			StockingBatchInfo batchInfo;
			try {
				batchInfo = StockingBatchFactory.getRemoteInstance().getStockingBatchInfo(new ObjectUuidPK(((AbstractCoreBaseInfo)kdtEntrys.getCell(arg0.getRowIndex(),"stockingBatch").getValue()).getId()),slor);
				isLoadField=true;
				kdtEntrys.getCell(arg0.getRowIndex(), "stockingBatch").setValue(batchInfo);
				kdtEntrys.getCell(arg0.getRowIndex(),"farmer").setValue(batchInfo.getFarmer());
				kdtEntrys.getCell(arg0.getRowIndex(),"farm").setValue(batchInfo.getFarm());

			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		isLoadField=false;
	}
	/*
	 * 设置过滤
	 */
	protected void setFilter() {
		// TODO Auto-generated method stub
		//公司过滤，公司等于当前公司
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		//批次过滤
		Object obj = kdtEntrys.getColumn("stockingBatch").getEditor().getComponent(); 
		if(obj instanceof KDBizPromptBox){ 
			KDBizPromptBox prmtF7 = (KDBizPromptBox )obj;
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		//获得当前财务组织
		String orgUnitId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		//按照当前组织过滤
		filter.getFilterItems().add(new FilterItemInfo("stockingBatch",orgUnitId,CompareType.LIKE));
		evi.setFilter(filter );
		prmtF7.setEntityViewInfo(evi); 

		}
	}

	/**
	 * output loadFields method
	 */
	//将数据对象加载到当前控件
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;
		//如果此单据的状态是审核，则该单据不能在审核，但是可以反审核
		if(this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
			//如果单据的状态是提交，则该单据只能进行反审核，不能进行审核
		}else if (this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
			//如果单据的状态是反审核状态，则该单据即可以审核，又可以反审核
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
		
		if(oprtState.equals("ADDNEW")){
			kdtEntrys.addRow();
		}
	}

	/**
	 * output storeFields method
	 */
	//同步当前控件中值到数据对象
	public void storeFields()
	{
		super.storeFields();
	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	/**
	 * output createNewData method
	 */
	//创建新的数据对象，并设置初始值
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
		//---已实现该方法，可直接调用  old
		//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//		Date bizDate;
		//		try {
		//			bizDate = sdf.parse(sdf.format(new Date()));
		//			Calendar cal=Calendar.getInstance();
		//			cal.setTime(bizDate);
		//			cal.add(Calendar.DAY_OF_MONTH, -1);
		//			objectValue.setBizDate(cal.getTime());
		//		} catch (ParseException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		// new
		objectValue.setBizDate(DateUtilsComm.addDays(new Date(), -1));


		return objectValue;
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(EntryBaseStatusEnum.AUDITED)){
			MsgBox.showConfirm2("单据已经审核禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}
	//删除
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(EntryBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	

	//审核按钮或者功能
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus().equals(EntryBaseStatusEnum.AUDITED)){
			MsgBox.showConfirm2("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(this.editData.getBaseStatus().equals(EntryBaseStatusEnum.TEMPORARILYSAVED)){
			MsgBox.showConfirm2("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}

		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	//反审核按钮或者功能
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		
		if(!this.editData.getBaseStatus().equals(EntryBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

}