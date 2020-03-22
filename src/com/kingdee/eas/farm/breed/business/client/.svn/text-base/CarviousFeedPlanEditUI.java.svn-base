/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

//import cn.topca.util.calendar.BaseCalendar.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.business.FeedWithHisNumberCollection;
import com.kingdee.eas.farm.breed.business.FeedWithHisNumberFactory;
import com.kingdee.eas.farm.breed.business.FeedWithHisNumberInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;

/**
 * output class name
 */
public class CarviousFeedPlanEditUI extends AbstractCarviousFeedPlanEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CarviousFeedPlanEditUI.class);
	private FeedWithHisNumberInfo feedWithHisNumberInfo = null;//饲料编号
	/**
	 * output class constructor
	 */
	public CarviousFeedPlanEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output MenuItemPCVoucher_actionPerformed method
	 */
	protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.MenuItemPCVoucher_actionPerformed(e);
	}

	/**
	 * output menuItemDelPCVoucher_actionPerformed method
	 */
	protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemDelPCVoucher_actionPerformed(e);
	}


	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
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
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
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




	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.breed.business.CarviousFeedPlanFactory.getRemoteInstance();
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
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.breed.business.CarviousFeedPlanInfo objectValue = new com.kingdee.eas.farm.breed.business.CarviousFeedPlanInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());


		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql = "where isCancelCancel=1 and beginDate<=('" + sdf.format(new Date()) + "') and endDate>=('" + sdf.format(new Date()) + "')";
		FeedWithHisNumberCollection coll = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberCollection(sql);
		if(coll.size()>0)
			feedWithHisNumberInfo=coll.get(0);
		//设置物料编号
		if(coll.size()>0){
			feedWithHisNumberInfo=coll.get(0);
			SelectorItemCollection slor = new SelectorItemCollection();
			slor.add("*");
			slor.add("num1.*");
			slor.add("num2.*");
			slor.add("num3.*");
			slor.add("num4.*");
			slor.add("num5.*");
			feedWithHisNumberInfo = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberInfo(new ObjectUuidPK(feedWithHisNumberInfo.getId()),slor );
			if(feedWithHisNumberInfo.getNum1() != null){
				kdtEntrys.getHeadRow(0).getCell("num1Feed").setValue(feedWithHisNumberInfo.getNum1().getName());
			}
			if(feedWithHisNumberInfo.getNum2() != null){
				kdtEntrys.getHeadRow(0).getCell("num2Feed").setValue(feedWithHisNumberInfo.getNum2().getName());
			}
			if(feedWithHisNumberInfo.getNum3() != null){
				kdtEntrys.getHeadRow(0).getCell("num3Feed").setValue(feedWithHisNumberInfo.getNum3().getName());
			}
			if(feedWithHisNumberInfo.getNum4() != null){
				kdtEntrys.getHeadRow(0).getCell("num4Feed").setValue(feedWithHisNumberInfo.getNum4().getName());
			}
			if(feedWithHisNumberInfo.getNum5() != null){
				kdtEntrys.getHeadRow(0).getCell("num5Feed").setValue(feedWithHisNumberInfo.getNum5().getName());
			}
		}



		kdtEntrys_detailPanel.getAddNewLineButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				//设置物料
				MaterialInfo matInfo = null;
				try {
					if(feedWithHisNumberInfo.getNum1() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(feedWithHisNumberInfo.getNum1().getId()));
						kdtEntrys.getHeadRow(0).getCell("num1Feed").setValue(matInfo.getName());					
					}
					if(feedWithHisNumberInfo.getNum2() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(feedWithHisNumberInfo.getNum2().getId()));
						kdtEntrys.getHeadRow(0).getCell("num2Feed").setValue(matInfo.getName());
					}
					if(feedWithHisNumberInfo.getNum3() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(feedWithHisNumberInfo.getNum3().getId()));
						kdtEntrys.getHeadRow(0).getCell("num3Feed").setValue(matInfo.getName());
					}
					if(feedWithHisNumberInfo.getNum4() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(feedWithHisNumberInfo.getNum4().getId()));
						kdtEntrys.getHeadRow(0).getCell("num4Feed").setValue(matInfo.getName());
					}
					if(feedWithHisNumberInfo.getNum5() != null){
						matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(feedWithHisNumberInfo.getNum5().getId()));
						kdtEntrys.getHeadRow(0).getCell("num5Feed").setValue(matInfo.getName());
					}

				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});




		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				batchChange(e);
			}

			//批次改变添加监听事件
			private void batchChange(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if("batch".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					if(e.getValue()!=null){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						BatchInfo batchInfo = (BatchInfo) e.getValue();
						try {
							batchInfo = BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchInfo.getId()));

							//根据批次信息判自动带出养殖场，再判断是否带出养殖户
							FarmInfo farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(batchInfo.getFarm().getId()));
							//自动带出养殖场
							kdtEntrys.getCell(e.getRowIndex(), "farm").setValue(farmInfo);
							//养殖场类型--如果是公司自养需要自动带出养殖户
							FarmerInfo farmerInfo = null;
							BigDecimal inQty = BigDecimal.ZERO;
							if(farmInfo.getFarmType().equals(StockingFarmTypeEnum .company)){
								String farmerid = null;
								String s1 = "/*dialect*/ select t1.fid farmerid from CT_FM_Farmer t1 inner join CT_FM_FarmerFarmEntry t2 on t2.fparentid = t1.fid" +
								" inner join CT_FM_Farm t3 on t3.fid = t2.FFarmID where t3.fid = '"+farmInfo.getId()+"'";
								IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
								if(r1.next()){
									farmerid = r1.getString("farmerid");
								}
								farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerid));
								kdtEntrys.getCell(e.getRowIndex(), "farmer").setValue(farmerInfo);

								BatchHouseEntryCollection batchHouseEntryColl = batchInfo.getHouseEntry();
								BatchHouseEntryInfo houseInfo = null;
								for(int i = 0,size = batchHouseEntryColl.size();i<size;i++){
									houseInfo = batchHouseEntryColl.get(i);
									inQty = inQty.add(houseInfo.getMaleQty());
								}
							}else{//公司放养
								//设置批次合同
								BatchContractBillInfo batchContInfo = batchInfo.getBatchContract();
								batchContInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContInfo.getId()));
								kdtEntrys.getCell(e.getRowIndex(), "batchContract").setValue(batchContInfo);
								//批次信息的入雏数量(棚舍信息的公禽数量)
								inQty = batchInfo.getFemaleQty();
							}
							Date inDate = (Date) pkbeginDate.getValue();
							//----------计算存栏信息
							//计算业务日期之前的累计死亡淘汰
							BigDecimal passQty = calcStockQty(inDate,batchInfo);

							kdtEntrys.getCell(e.getRowIndex(), "currentQty").setValue(inQty.subtract(passQty));

						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}



					}
				}
			}

			/**
			 * 计算该批次累计死亡淘汰
			 * @param object
			 * @param batchInfo
			 * @return
			 */
			private BigDecimal calcStockQty(Date inDate, BatchInfo batchInfo) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				StringBuffer s1 = new StringBuffer();
				s1.append("/*dialect*/ select sum(t2.CFCullAndDeath) cullAndDeath, sum(t2.CFMarketQty)    markQty");
				s1.append(" from CT_FM_CommecialChilkenDaily  t1 inner join CT_FM_CommecialCDAE t2 on t2.fparentid = t1.fid");
				s1.append(" where t1.CFBreedBatchID = '");
				s1.append(batchInfo.getId());
				s1.append("'");
				s1.append(" and t1.FBizDate <= { d '");
				s1.append(sdf.format(inDate));
				s1.append("'}");
				BigDecimal allPass = BigDecimal.ZERO;
				BigDecimal cullAndDeath = BigDecimal.ZERO;
				BigDecimal markQty = BigDecimal.ZERO;
				IRowSet r1;
				try {
					r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1.toString());
					if(r1.next()){
						cullAndDeath = UIRuleUtil.getBigDecimal(r1.getBigDecimal("cullAndDeath"));
						markQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("markQty"));
						allPass = cullAndDeath.add(markQty);
					}
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return allPass;





			}

		});
	}

}