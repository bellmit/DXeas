package com.kingdee.eas.custom.dep.client;

import java.math.BigDecimal;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.client.PurInWarehsBillEditUI;


/**
 * 采购入库单 编辑 dep
 * @author Administrator
 *
 */
public class PurInWarehsBillEditDep {
//
//	// 编辑界面
	protected PurInWarehsBillEditUI ui;
//	// 界面 对象
//	protected PurInWarehsBillInfo editData;
//	
//	/**
//	 * 界面初始化完成后 设置
//	 * @param param
//	 */
	public void afterOnLoad(final UIParam param){
		
		final KDTable table=param.getKDTable("detailTable");
		table.addKDTEditListener(new KDTEditAdapter(){
			//增加其他数量的计算
			public void editStopped(KDTEditEvent event) {
				if(table.getColumnKey(event.getColIndex()).equals("otherAmount")) {
					BigDecimal qty=UIRuleUtil.getBigDecimal(table.getCell(event.getRowIndex(),"otherQty").getValue());
					BigDecimal amount=UIRuleUtil.getBigDecimal(table.getCell(event.getRowIndex(),"otherAmount").getValue());
					if(qty==null||qty.signum()<=0) {
						table.getCell(event.getRowIndex(),"otherPrice").setValue(java.math.BigDecimal.ZERO);
					}else {
						table.getCell(event.getRowIndex(),"otherPrice").setValue(amount.divide(qty,4,java.math.BigDecimal.ROUND_HALF_UP));
					}
				}
				else if(table.getColumnKey(event.getColIndex()).equals("otherQty")||table.getColumnKey(event.getColIndex()).equals("otherPrice")) {
					BigDecimal qty=UIRuleUtil.getBigDecimal(table.getCell(event.getRowIndex(),"otherQty").getValue());
					BigDecimal price= UIRuleUtil.getBigDecimal(table.getCell(event.getRowIndex(),"otherPrice").getValue());
					if(qty==null) {
						qty=java.math.BigDecimal.ZERO;
					}
					if(price==null) {
						price=java.math.BigDecimal.ZERO;
					}
					table.getCell(event.getRowIndex(),"otherAmount").setValue(qty.multiply(price).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
				}
			}
			
		});
	}
		

//		ui = (PurInWarehsBillEditUI) param.getUI();
//		editData = (PurInWarehsBillInfo) ui.getEditData();
//		
////		param.getKDButton("workbtnBizProcess").setVisible(false);
////		param.getKDButton("workbtnBizProcess").setEnabled(false);
//
//		
////		param.getKDCheckBoxMenuItem("chkMenuItemSubmitAndAddNew").setSelected(false);
//		
////		param.getKDBizPromptBox("prmtPurContract").addDataChangeListener(new DataChangeListener(){
////			public void dataChanged(DataChangeEvent arg0) {
////				// TODO Auto-generated method stub
////				try {
////					prmtPurContract_Changed(param, arg0);
////				} catch (Exception e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			}
////			
////		});
//		FilterInfo filterInfo=new FilterInfo();
//		filterInfo.getFilterItems().add(new FilterItemInfo("company.id",ui.getCuid(),CompareType.EQUALS));
//		EntityViewInfo evi=new EntityViewInfo();
//		evi.setFilter(filterInfo);
//		param.getKDBizPromptBox("prmtInWarehs").setQueryInfo("com.kingdee.eas.custom.lhsm.app.InWarehsDetailQuery");		
//        param.getKDBizPromptBox("prmtInWarehs").setVisible(true);		
//        param.getKDBizPromptBox("prmtInWarehs").setEditable(true);		
//        param.getKDBizPromptBox("prmtInWarehs").setDisplayFormat("$number$");		
//        param.getKDBizPromptBox("prmtInWarehs").setEditFormat("$number$");		
//        param.getKDBizPromptBox("prmtInWarehs").setCommitFormat("$number$");		
//        param.getKDBizPromptBox("prmtInWarehs").setRequired(false);
//        param.getKDBizPromptBox("prmtInWarehs").setEntityViewInfo(evi);
//		
//        param.getKDBizPromptBox("prmtPurContract").setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7PurContractAQuery");
//        param.getKDBizPromptBox("prmtPurContract").setVisible(true);
//        param.getKDBizPromptBox("prmtPurContract").setEditable(true);
//        param.getKDBizPromptBox("prmtPurContract").setDisplayFormat("$number$");
//        param.getKDBizPromptBox("prmtPurContract").setEditFormat("$number$");
//        param.getKDBizPromptBox("prmtPurContract").setCommitFormat("$number$");
//		filterInfo=new FilterInfo();
//		filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",ui.getCuid(),CompareType.EQUALS));
//		evi=new EntityViewInfo();
//		evi.setFilter(filterInfo);
//		param.getKDBizPromptBox("prmtPurContract").setEntityViewInfo(evi);
//		
//		// 发货明细变化时更新  其他关联值
//		param.getKDBizPromptBox("prmtInWarehs").addDataChangeListener(new DataChangeListener(){
//			public void dataChanged(DataChangeEvent arg0) {
//			// TODO Auto-generated method stub
//			try {
//				prmtInWarehs_Changed(param, arg0);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	});
//	param.getKDBizPromptBox("prmtPurContract").addDataChangeListener(new DataChangeListener(){
//		public void dataChanged(DataChangeEvent arg0) {
//			// TODO Auto-generated method stub
//			try {
//				prmtPurContract_Changed(param, arg0);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	});
//		//KDTable增加表格编辑事件监听
//	param.getKDTable("detailTable").addKDTEditListener(new KDTEditAdapter(){
//		public void editStopped(KDTEditEvent e) {
//			try {
//				detailTable_Changed(param, e.getRowIndex(),e.getColIndex());
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}});
//	}
//	
//	/**
//	 * 采购合同变更时处理
//	 * @param param
//	 * @param e
//	 * @throws Exception
//	 */
//	public void prmtPurContract_Changed(UIParam param,DataChangeEvent e)throws Exception {
//		ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		editData = (PurInWarehsBillInfo) ui.getEditData();
//		
//		if(param.getKDBizPromptBox("prmtPurContract").getData()==null){
//			FilterInfo filterInfo=new FilterInfo();
//			filterInfo.getFilterItems().add(new FilterItemInfo("company.id",ui.getCuid(),CompareType.EQUALS));
//			EntityViewInfo evi=new EntityViewInfo();
//			evi.setFilter(filterInfo);
//			param.getKDBizPromptBox("prmtInWarehs").setQueryInfo("com.kingdee.eas.custom.lhsm.app.InWarehsDetailQuery");		
//	        param.getKDBizPromptBox("prmtInWarehs").setVisible(true);		
//	        param.getKDBizPromptBox("prmtInWarehs").setEditable(true);		
//	        param.getKDBizPromptBox("prmtInWarehs").setDisplayFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setEditFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setCommitFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setRequired(false);
//	        param.getKDBizPromptBox("prmtInWarehs").setEntityViewInfo(evi);
//		}else{
//			String contractid=((IObjectValue) param.getKDBizPromptBox("prmtPurContract").getValue()).getString("id");
//			PurContractAInfo pconinfo=PurContractAFactory.getRemoteInstance().getPurContractAInfo(new ObjectUuidPK(contractid));
////			PurContractAInfo pconinfo=(PurContractAInfo)param.getKDBizPromptBox("prmtPurContract").getValue();
//			String purcontractaid="";
//			purcontractaid=pconinfo.getContractID();
//			FilterInfo filterInfo=new FilterInfo();
//			filterInfo.getFilterItems().add(new FilterItemInfo("company.id",ui.getCuid(),CompareType.EQUALS));
//			filterInfo.getFilterItems().add(new FilterItemInfo("purContract.id",purcontractaid,CompareType.EQUALS));
//			EntityViewInfo evi=new EntityViewInfo();
//			evi.setFilter(filterInfo);
//			param.getKDBizPromptBox("prmtInWarehs").setQueryInfo("com.kingdee.eas.custom.lhsm.app.InWarehsDetailQuery");		
//	        param.getKDBizPromptBox("prmtInWarehs").setVisible(true);		
//	        param.getKDBizPromptBox("prmtInWarehs").setEditable(true);		
//	        param.getKDBizPromptBox("prmtInWarehs").setDisplayFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setEditFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setCommitFormat("$number$");		
//	        param.getKDBizPromptBox("prmtInWarehs").setRequired(false);
//	        param.getKDBizPromptBox("prmtInWarehs").setEntityViewInfo(evi);
//		}
//	}
//	/**
//	 * 发货明细 编辑时 设置 采购合同 车号 和车皮号等信息
//	 * @throws Exception
//	 */
//	public void prmtInWarehs_Changed(UIParam param,DataChangeEvent e)throws Exception {
//		
//		ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		editData = (PurInWarehsBillInfo) ui.getEditData();
//		
//		StringBuffer sql=new StringBuffer();
//		if(param.getKDBizPromptBox("prmtInWarehs").getData()!=null){
//			InWarehsDetailInfo info=(InWarehsDetailInfo)param.getKDBizPromptBox("prmtInWarehs").getData();
//			ObjectUuidPK pk = new ObjectUuidPK(info.getId().toString());
//			info=InWarehsDetailFactory.getRemoteInstance().getInWarehsDetailInfo(pk);
//			if(info.getPurContract().getId()!=null){
//				sql=new StringBuffer();
//				sql.append(" select * from t_sm_PurContract ");
//				sql.append(" where FContractID='"+info.getPurContract().getId().toString()+"' ");
//				sql.append(" and FPurOrgUnitID='"+ui.getCuid()+"' ");
//				IRowSet rs=JackFacadeFactory.getRemoteInstance().GetSqlData(sql.toString());
//				if(rs.next()){
//					pk = new ObjectUuidPK(rs.getString("fid"));
//					PurContractAInfo  infoA=PurContractAFactory.getRemoteInstance().getPurContractAInfo(pk);
//					param.getKDBizPromptBox("prmtPurContract").setValue(infoA);
//				}
//			}
//			param.getKDTextField("txtcarNumber").setText(info.getCarNumber());
//			param.getKDTextField("txtcarNumberA").setText(info.getCarNumber());
//			//this.txtqtyin.setValue(info.getQty());
//		}
//	}
//	/**
//	 * 选中供应商时  设置联系方式
//	 * @param param
//	 * @throws Exception
//	 */
//	public void updateSupplierAddBySupplier(UIParam param,DataChangeEvent e) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//		if(param.getKDBizPromptBox("bizPromptSupplier").getValue()!=null){
//			SupplierInfo info=(SupplierInfo)param.getKDBizPromptBox("bizPromptSupplier").getValue();
//			ObjectUuidPK pk = new ObjectUuidPK(info.getId());
//			info=SupplierFactory.getRemoteInstance().getSupplierInfo(pk);
//			
//			param.getKDTextField("txtsupplierAdd").setText(info.getBusiLicence());
//		}
//	}
//
//	/**
//	 * 下推生成前校验
//	 * @param e
//	 * @throws Exception
//	 */
//	public void checkBeforeCreateTo(UIParam param) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//		// TODO Auto-generated method stub
//		String cuId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
//		StringBuffer sql=new StringBuffer();
//		sql.append(" select fnumber from t_org_company ");
//		sql.append(" where fid in(");
//		sql.append(" select fparentid from t_org_company ");
//		sql.append(" where fid='"+cuId+"'");
//		sql.append(" )");
//		IRowSet rs=JackFacadeFactory.getRemoteInstance().GetSqlData(sql.toString());
//		if(rs.next()) {
//			if(rs.getString("fnumber").equals("10000")) {
//				if(editData.getObjectValue("pPerson")==null) {
//					MsgBox.showInfo( "请先进行品管审核");
//					SysUtil.abort();
//				}
//			}
//		}
//	}
//	
//	/**
//	 * 提交完成后更新
//	 * @param param
//	 * @throws BOSException 
//	 * @throws EASBizException 
//	 */
//	public void afterSubmit(UIParam param) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//		if(editData.getId()!=null){
//			
//			if(param.getKDBizPromptBox("prmtPurContract").getValue()!=null){
////				if(param.getKDTextField("txtcarNumber").getText()==null){
////					MsgBox.showError("");
////					SysUtil.abort();
////				}
//				String inWarid="";
//				String fid=editData.getId().toString();
//				if(param.getKDBizPromptBox("prmtInWarehs").getData()!=null){
//					InWarehsDetailInfo info=(InWarehsDetailInfo)param.getKDBizPromptBox("prmtInWarehs").getData();
//					inWarid=info.getId().toString();
//					StringBuffer sql=new StringBuffer();
//					sql.append(" delete CT_LHS_INWAREHSDETAILENTRY2 where CFPURINWAREHSID='"+fid+"' ");
//					JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//					
//					sql=new StringBuffer();
//					sql.append("insert into CT_LHS_INWAREHSDETAILENTRY2(FID,FParentID,CFPURINWAREHSID) ");
//					sql.append(" select dbo.newbosid('6B3D770B'),'"+inWarid+"','"+fid+"' ");//68C07155 by dai
//					JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//					
//					PurContractJFacadeFactory.getRemoteInstance().updateInWQtyA(fid, inWarid);
//					
//				}else{
//					StringBuffer sql=new StringBuffer();
//					sql.append(" delete CT_LHS_INWAREHSDETAILENTRY2 where CFPURINWAREHSID='"+fid+"' ");
//					JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				}
//				
////				PurContractAInfo pconinfo=(PurContractAInfo)param.getKDBizPromptBox("prmtPurContract").getValue();//採購合同編碼
////				String contractid=pconinfo.getId().toString();
//				String contractid=((IObjectValue) param.getKDBizPromptBox("prmtPurContract").getValue()).getString("id");
//				PurContractAInfo pconinfo=PurContractAFactory.getRemoteInstance().getPurContractAInfo(new ObjectUuidPK(contractid));
//				String contractbid=pconinfo.getContractBID();//公司合同编码？（空）
//				if(contractbid==null)contractbid="";
//				
//				String contractaid=pconinfo.getContractID();//本部合同编码
//				if(contractaid==null)contractaid="";
//				reCompute(fid,contractid,contractbid,contractaid);
//			}
//				
//			
//		}
//	}
//	
//	/**
//	 * 
//	 * @param fid
//	 * @param contractid
//	 * @param contractbid
//	 * @param contractaid
//	 * @throws EASBizException
//	 * @throws BOSException
//	 */
//	public void reCompute(String fid,String contractid,
//			String contractbid,String contractaid ) throws Exception{
//			//删除本组织和本合同数据
//			StringBuffer sql=new StringBuffer();
//			sql.append(" delete t_lhs_inventoryrpt ");
//			sql.append(" where FID='"+fid+"' ");
//			JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//			if(!contractid.equals("")){
//				
//				//插入本组织和本合同数据
//				sql=new StringBuffer();
//				sql.append(" insert into t_lhs_inventoryrpt( ");
//				sql.append(" fid,fnumber,fdate,fcontrolunitid, ");
//				sql.append(" fpurcontractid,fpurcontractbid,fpurcontractaid,");
//				sql.append(" fsupplierid,FCarNumber,fmaterialid,");
//				sql.append(" fqty,fqtya,fqtyb,fqtyin,fCarnumberA, ");
//				sql.append(" fqtyc,fprice,famount, ");
//				sql.append(" famounta,famountb ");
//				sql.append(" ) ");
//				sql.append(" select  ");
//				sql.append(" t1.fid,t1.fnumber,t1.fbizdate,t1.fcontrolunitid,");
//				sql.append(" t3.fid,t3.fcontractbid,t3.fcontractid," );
//				sql.append(" t1.fsupplierid,upper(t1.CFCarNumber),t2.fmaterialid, ");
//				sql.append(" 0,t2.fbaseqty,isnull(t1.cfqtyb,0),isnull(t1.cfqtyin,0),isnull(t1.CFCarNumberA,''), ");
//				sql.append(" 0,t2.fprice,t2.ftaxamount, ");
//				sql.append(" 0,t2.ftaxamount ");
//				sql.append(" from t_im_purinwarehsbill t1 ");
//				sql.append(" inner join t_im_purinwarehsentry t2 on t2.fparentid=t1.fid ");
//				sql.append(" inner join t_sm_purcontract t3 on t3.fid=t1.cfpurcontractid");
//				sql.append(" where t1.FID='"+fid+"' ");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				sql=new StringBuffer();
//				sql.append(" update t_lhs_inventoryrpt set fqtyin=fqtya ");
//				sql.append(" where isnull(fqtyin,0)=0");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				sql=new StringBuffer();
//				sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=0,cfqtyb=0 ");
//				sql.append(" where fparentid='"+contractid+"'");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				//更新公司合同
//				sql=new StringBuffer();
//				sql.append("update  ct_lhs_purcontractapurqty  t1 set (cfqtya,cfqtyb)=( ");
//				sql.append(" select  t2.fqtya,t2.fqtyb from (  ");
//				sql.append(" select fpurcontractid,fmaterialid ,sum(fqtya) fqtya,sum(fqtyb) fqtyb ");
//				sql.append(" from t_lhs_inventoryrpt ");
//				sql.append(" where fpurcontractid='"+contractid+"'");
//				sql.append(" group by fpurcontractid,fmaterialid ");
//				sql.append(" )as t2 where t2.fpurcontractid=t1.fparentid ");
//				sql.append(" and t2.fmaterialid=t1.cfmaterialid");
//				sql.append(" ) ");
//				sql.append(" where t1.fparentid='"+contractid+"' ");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				sql=new StringBuffer();
//				sql.append(" update  ct_lhs_purcontractapurqty  set cfqtyc=cfqty-cfqtya-cfqtyb ");
//				sql.append(" where fparentid='"+contractid+"'");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//			}
//			if(!contractaid.equals("")){
//				sql=new StringBuffer();
//				sql.append(" update  ct_lhs_purcontractapurqty  set cfqtya=0,cfqtyb=0 ");
//				sql.append(" where fparentid='"+contractaid+"'");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				//更新商贸合同
//				sql=new StringBuffer();
//				sql.append(" update  ct_lhs_purcontractapurqty  t1 set (cfqtya,cfqtyb)=( ");
//				sql.append(" select  t2.fqtya,t2.fqtyb from (  ");
//				sql.append(" select fpurcontractaid,fmaterialid ,sum(fqtya) fqtya,sum(fqtyb) fqtyb ");
//				sql.append(" from t_lhs_inventoryrpt ");
//				sql.append(" where fpurcontractaid='"+contractaid+"'");
//				sql.append(" group by fpurcontractaid,fmaterialid ");
//				sql.append(" )as t2 where t2.fpurcontractaid=t1.fparentid ");
//				sql.append(" and t2.fmaterialid=t1.cfmaterialid");
//				sql.append(" ) ");
//				sql.append(" where t1.fparentid='"+contractaid+"' ");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//				sql=new StringBuffer();
//				sql.append(" update  ct_lhs_purcontractapurqty  set cfqtyc=cfqty-(cfqtya+cfqtyb)");
//				sql.append(" where fparentid='"+contractaid+"'");
//				JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//				
//			}
//		
//	}
//	
//	/**
//	 * 打开 更新合同号 功能
//	 * @param param
//	 * @throws Exception
//	 */
//	 public void actionUpdateContractNumber(UIParam param) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//			
//		  if(editData.getId()!=null){
//			String uiname="com.kingdee.eas.custom.lhsm.client.UpdatePurInWarehsBillUI";
//			UIContext uicontext = new UIContext();
//			uicontext.put("FID", editData.getId().toString());
//			IUIWindow iuiwindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(
//					uiname, uicontext, null, OprtState.VIEW);
//			iuiwindow.show();
//		  }
//	    }
//	 
//	 
//	/**
//	 * 品管审核
//	 * @param e
//	 * @throws Exception
//	 */
//	public void actionPAudit_actionPerformed(UIParam param) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//		// TODO Auto-generated method stub
//		UserInfo user=SysContext.getSysContext().getCurrentUserInfo();
//		BillBaseStatusEnum status = this.editData.getBaseStatus();
//		if(!status.toString().equals("审核")) {
//			MsgBox.showInfo("请先审核");
//			SysUtil.abort();
//		}
//		StringBuffer sql=new StringBuffer();
//		sql.append(" /*dialect*/ update T_IM_PurInWarehsBill ");
//		sql.append(" set cfppersonid='"+user.getId().toString()+"'");
//		sql.append(" where fid='"+this.editData.getId().toString()+"'");
//		JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
//		param.getKDBizPromptBox("prmtpPerson").setValue(user);
//		ui.storeFields();
//		MsgBox.showInfo("品管审核完成");
//		
//	}
//	
//	
//	/**
//	 * 分录变化时
//	 * @param param
//	 * @param rowIndex
//	 * @param colIndex
//	 * @throws Exception
//	 */
//	public void detailTable_Changed(UIParam param,int rowIndex, int colIndex) throws Exception {
//		 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (PurInWarehsBillInfo) ui.getEditData();
//		 
//		 KDTable detailTable = param.getKDTable("detailTable");
//			// 解决wincos 托盘数量问题
//			try{
//				IRow row = detailTable.getRow(rowIndex);
//				if(!detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("baseQty")&&!detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("qty")
//						&&!detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("packQty")&&detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("unitPackQty")
//						&&detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("packCount")) {
//					return;
//				}
//
//				if(detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("baseQty")||detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("qty")) {
//					row.getCell("packQty").setValue(row.getCell("qty").getValue());
//				}
//				BigDecimal packQty=BigDecimal.ZERO;
//				BigDecimal unitPackQty=BigDecimal.ZERO;
//				BigDecimal packCount=BigDecimal.ZERO;
//					 
//				 if(detailTable.getRow(rowIndex).getCell("packQty").getValue()!=null) {
//					 packQty=new BigDecimal(detailTable.getRow(rowIndex).getCell("packQty").getValue().toString());
//				 }
//				 if(detailTable.getRow(rowIndex).getCell("unitPackQty").getValue()!=null) {
//					 unitPackQty=new BigDecimal(detailTable.getRow(rowIndex).getCell("unitPackQty").getValue().toString());
//				 }
//				 if(detailTable.getRow(rowIndex).getCell("packCount").getValue()!=null) {
//					 packCount=new BigDecimal(detailTable.getRow(rowIndex).getCell("packCount").getValue().toString());
//				 }
//				 
//				if(detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("baseQty")||detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("qty")||detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("packQty")) {
//					if(unitPackQty.compareTo(BigDecimal.ZERO)>0) {
//						 packCount=packQty.divide(unitPackQty,4,BigDecimal.ROUND_HALF_UP);
//					 }
//					row.getCell("packCount").setValue(packCount);
//				}
//				if(detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("unitPackQty")) {
//					if(unitPackQty.compareTo(BigDecimal.ZERO)>0) {
//						 packCount=packQty.divide(unitPackQty,4,BigDecimal.ROUND_HALF_UP);
//					 }else {
//						 packCount=BigDecimal.ZERO;
//					 }
//					 row.getCell("packCount").setValue(packCount);
//				}
//				if(detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("packCount")) {
//					if(packCount.compareTo(BigDecimal.ZERO)>0) {
//						unitPackQty=packQty.divide(packCount,4,BigDecimal.ROUND_HALF_UP);
//					 }else {
//						 unitPackQty=BigDecimal.ZERO;
//					 }
//					row.getCell("unitPackQty").setValue(unitPackQty);
//				}
//				
//				if(detailTable.getColumn(colIndex).getKey().equalsIgnoreCase("materialNum")) {
//					MaterialInfo currMaterial = (MaterialInfo) detailTable.getCell(rowIndex, colIndex).getValue();
//					if(currMaterial != null){
//						String alias = currMaterial.getAlias();
//						if(alias == null){
//							currMaterial = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(currMaterial.getId().toString()));
//							alias = currMaterial.getAlias();
//						}
//						row.getCell("materialalias").setValue(alias);
//					}
//					
//				}
//			}catch(Exception err) {
//				err.printStackTrace();
//			}
//		}
//
//		 /**
//		  * 解决wincos 托盘数量问题
//		  * @return
//		  * @throws Exception
//		  */
//		public void verifyPackInfos(UIParam param) throws Exception {
//			 ui = (PurInWarehsBillEditUIPIEx) param.getUI();
//			 editData = (PurInWarehsBillInfo) ui.getEditData();
//			try {
//				KDTable detailTable = param.getKDTable("detailTable");
//				
//				IRow row;
//				for(int rowIndex=0;rowIndex<detailTable.getRowCount();rowIndex++) {
//					row=detailTable.getRow(rowIndex);
//					if(row.getCell("packType").getValue()!=null&&!row.getCell("packType").getValue().equals(PackingTypeEnum.unDefine)) {
//						if(row.getCell("packQty").getValue()==null||row.getCell("unitPackQty").getValue()==null||row.getCell("packCount").getValue()==null) {
//							MsgBox.showWarning("第"+(rowIndex+1)+"行分录“包装类型”有值，“总包装数量”、“单位包装数量”或“包装件数”不能为空！");
////							return false;
//							SysUtil.abort();
//						}
//						BigDecimal packCount=new BigDecimal(row.getCell("packCount").getValue().toString());
//						BigDecimal packCountAll=packCount;
//						if(packCount.compareTo(BigDecimal.ZERO)==0||packCount.setScale(0, BigDecimal.ROUND_HALF_UP).compareTo(packCountAll)!=0) {
//							int result=MsgBox.showConfirm2("第"+(rowIndex+1)+"行分录“包装类型”有值，且“包装件数”为0或不为整数，是否继续！");
//							if(result!=MsgBox.YES) {
//								SysUtil.abort();
////								return false;
//							}
//						}
//					}
//				}
//			}catch(Exception err) {
//				err.printStackTrace();
//			}
////			return true;
//		}
}
