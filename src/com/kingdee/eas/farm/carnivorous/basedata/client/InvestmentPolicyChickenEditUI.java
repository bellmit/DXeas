/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class InvestmentPolicyChickenEditUI extends AbstractInvestmentPolicyChickenEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(InvestmentPolicyChickenEditUI.class);
    
    /**
     * output class constructor
     */
    public InvestmentPolicyChickenEditUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setBeginDate(new Date());
	
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);

		this.pkbeginDate.setVisible(false);
		this.pkendDate.setVisible(false);
		this.prmtauditor.setVisible(false);
		this.pkauditTime.setVisible(false);

		this.btnCancel.setVisible(true);
		this.btnCancelCancel.setVisible(true);

		this.btnCancel.setEnabled(true);
		this.btnCancelCancel.setEnabled(true);

		//		kdtEntry.checkParsed();
		//		final KDBizPromptBox kdtEntry_materialNuo_PromptBox = new KDBizPromptBox();
		//		kdtEntry_materialNuo_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		//		kdtEntry_materialNuo_PromptBox.setVisible(true);
		//		kdtEntry_materialNuo_PromptBox.setEditable(true);
		//		kdtEntry_materialNuo_PromptBox.setDisplayFormat("$number$");
		//		kdtEntry_materialNuo_PromptBox.setEditFormat("$number$");
		//		kdtEntry_materialNuo_PromptBox.setCommitFormat("$number$");
		//		kdtEntry_materialNuo_PromptBox.setEnabledMultiSelection(true);
		//		KDTDefaultCellEditor kdtEntry_materialNuo_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialNuo_PromptBox);
		//		kdtEntry.getColumn("materialNuo").setEditor(kdtEntry_materialNuo_CellEditor);








		//物料添加监听事件
		this.kdtEntry.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);

				if(kdtEntry.getCell(e.getRowIndex(),"materialNuo").getValue() != null
						&& "materialNuo".equalsIgnoreCase(kdtEntry.getColumn(e.getColIndex()).getKey())){

					MaterialInfo materialInfo = null;
					try {
						materialInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(((MaterialInfo)kdtEntry.getCell(e.getRowIndex(),"materialNuo").getValue()).getId()));
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					kdtEntry.getCell(e.getRowIndex(),"materialName").setValue(materialInfo.getName());

					//根据物料找到物料的分组，根据物料分组设置 投入政策的结算项目
					SettlementItemInfo settlementItemInfo = getSettlementItem(materialInfo.getId().toString());
					kdtEntry.getCell(e.getRowIndex(),"settleItem").setValue(settlementItemInfo);
				}
			}
			/**
			 * 根据物料找到物料的分组，根据物料分组设置 投入政策的结算项目
			 * @param string
			 * @return
			 */
			public SettlementItemInfo getSettlementItem(String matid) {
				// TODO Auto-generated method stub

				List matGroupList = new ArrayList();
				String name2 = null;
				String name3 = null;
				String name4 = null;
				String name5 = null;
				String name6 = null;

				SettlementItemInfo settlementItemInfo = null;


				String sql = "/*dialect*/ select t2.fid name2,t3.fid name3" +
				" from T_BD_Material  t1 inner join T_BD_MaterialGroup t2 on t2.fid=t1.FMaterialGroupID" +
				" left join T_BD_MaterialGroup t3 on t3.fid=t2.FParentID" +
				" where t1.fid = '"+matid+"'";

				ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
				try {
					IRowSet rs = executor.executeSQL();
					if(rs.next()){
						name2 = rs.getString("name2");//物料的上一级分组
						name3 = rs.getString("name3");//物料的上两级分组
						matGroupList.add(name2);
						if(name3 != null){
							String sql1 = "/*dialect*/ select t3.fid name3, t4.fid name4 from T_BD_Material  t1" +
							" inner join T_BD_MaterialGroup t2 on t2.fid=t1.FMaterialGroupID" +
							" left join T_BD_MaterialGroup t3 on t3.fid=t2.FParentID" +
							" left join T_BD_MaterialGroup t4 on t4.fid=t3.FParentID where t1.fid = '"+matid+"'";
							ISQLExecutor executor1 = SQLExecutorFactory.getRemoteInstance(sql1);
							IRowSet rs1 = executor1.executeSQL();
							if(rs1.next()){
								name4 = rs1.getString("name4");//物料的上三级分录
								matGroupList.add(name3);
								if(name4 != null){
									String sql2 = "/*dialect*/ select t4.fname_l2 name4,t5.fid name5 from T_BD_Material  t1" +
									" inner join T_BD_MaterialGroup t2 on t2.fid=t1.FMaterialGroupID" +
									" left join T_BD_MaterialGroup t3 on t3.fid=t2.FParentID" +
									" left join T_BD_MaterialGroup t4 on t4.fid=t3.FParentID" +
									" left join T_BD_MaterialGroup t5 on t5.fid=t4.FParentID" +
									" where t1.fid = '"+matid+"'";
									ISQLExecutor executor2 = SQLExecutorFactory.getRemoteInstance(sql2);
									IRowSet rs2 = executor2.executeSQL();
									if(rs2.next()){
										name5 = rs2.getString("name5");//物料的上四级分组
										matGroupList.add(name4);
										if(name5 != null){

											String sql3 = "/*dialect*/select t5.fname_l2 name5, t6.fid name6 from T_BD_Material  t1 inner join T_BD_MaterialGroup t2 on t2.fid=t1.FMaterialGroupID " +
											" left join T_BD_MaterialGroup t3 on t3.fid=t2.FParentID left join T_BD_MaterialGroup t4 on t4.fid=t3.FParentID" +
											" left join T_BD_MaterialGroup t5 on t5.fid=t4.FParentID left join T_BD_MaterialGroup t6 on t6.fid=t5.FParentID" +
											" where t1.fid = '"+matid+"'";
											ISQLExecutor executor3 = SQLExecutorFactory.getRemoteInstance(sql3);
											IRowSet rs3 = executor3.executeSQL();
											if(rs3.next()){
												name6 = rs3.getString("name6");
												if(name6 != null){
													matGroupList.add(name5);
													matGroupList.add(name6);
												}else{
													matGroupList.add(name5);
												}
											}
										}

									}
								}

							}
						}


						//获取所有的结算项目，fid和物料分组字段
						String sq = "/*dialect*/ select t1.fid billid, t1.CFMaterialGroupID  matGroupid from T_FM_SettlementItem t1";
						ISQLExecutor ex = SQLExecutorFactory.getRemoteInstance(sq);
						IRowSet rss = ex.executeSQL();
						String billid = null;
						String matGroupid = null;
						while(rss.next()){
							billid = rss.getString("billid");
							matGroupid = rss.getString("matGroupid");
							//如果该物料所有的分组列表里面，包含该结算项目的物料分组，就直接取该结算项目的fid，并返回
							if(matGroupList.contains(matGroupid)){
								settlementItemInfo = SettlementItemFactory.getRemoteInstance().getSettlementItemInfo(new ObjectUuidPK(billid));					
								break;
							}
						}
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return settlementItemInfo;
			}

		});


	}


	@Override
	protected void setFieldsNull(AbstractObjectValue arg0) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		arg0.put("billStatus",BillBaseStatusEnum.ADD);
		InvestmentPolicyChickenInfo newInfo = (InvestmentPolicyChickenInfo) arg0;
		InvestmentPolicyChickenEntryCollection entryColl = newInfo.getEntry();
		Calendar c = null;
		Calendar c1 = null;
		for(int i = 0; i < entryColl.size(); i++){
			InvestmentPolicyChickenEntryInfo entryInfo = entryColl.get(i);
			//获取原来的结束日期
			Date endDateOld = entryInfo.getEndDate();
			//设置现在的开始日期 = 原来的结束日期+1天
			c = Calendar.getInstance();
			c.setTime(endDateOld);
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date beginDateNew = c.getTime();
			//设置开始日期
			entryInfo.setBeginDate(beginDateNew);
			
			//设置现在的结束日期 = 原来的结束日期+1年
			c1 = Calendar.getInstance();
			c1.setTime(endDateOld);
			c1.add(Calendar.YEAR, 1);
			Date endDateNew = c1.getTime();
			//设置结束日期
			entryInfo.setEndDate(endDateNew);
		}



	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		//		setUIStatus();
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.cancel)) {
			MsgBox.showWarning("单据已经审核或禁用，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

}