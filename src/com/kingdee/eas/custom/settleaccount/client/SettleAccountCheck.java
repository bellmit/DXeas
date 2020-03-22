/**
 * output package name
 */
package com.kingdee.eas.custom.settleaccount.client;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.TransportF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.settleaccount.settleAccountFacadeFactory;
import com.kingdee.eas.custom.settleaccount.util.CheckResultInfo;
import com.kingdee.eas.custom.settleaccount.util.ProblemDetailInfo;
import com.kingdee.eas.fm.mobile.app.fundreverse.model.CompanyNumberComparator;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SettleAccountCheck extends AbstractSettleAccountCheck
{
    private static final Logger logger = CoreUIObject.getLogger(SettleAccountCheck.class);
    
    /**
     * output class constructor
     */
    public SettleAccountCheck() throws Exception
    {
        super();
        initControl();
    }
    /**
     *初始化控件
     */
	private void initControl() {
		//公司f7
		// 公司过滤条件 树形结构，过滤财务组织
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(false);
		this.prmtCompany.setSelector(cf7);
        this.prmtCompany.setRequired(true);		
		
		//设置会计期间
		this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
		this.prmtPeriod.setVisible(true);		
		this.prmtPeriod.setEditable(true);		
		this.prmtPeriod.setDisplayFormat("$number$");	//$periodNumber$	
		this.prmtPeriod.setEditFormat("$number$");		
		this.prmtPeriod.setCommitFormat("$number$");		
		this.prmtPeriod.setRequired(true);
		
		//设置表格列宽
		kDTable2.checkParsed();
		kDTable2.getColumn(0).setWidth(230);
		kDTable2.getColumn(1).setWidth(60);
		kDTable2.setEditable(false);
		//获取当前公司和期间
		CompanyOrgUnitInfo currentFIUnit = SysContext.getSysContext().getCurrentFIUnit();
		this.prmtCompany.setValue(currentFIUnit);
		try {
			PeriodInfo currentPeriod = SystemStatusCtrolUtils.getCurrentPeriod(null, SystemEnum.GENERALLEDGER, currentFIUnit);
			this.prmtPeriod.setValue(currentPeriod);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    
    
    

    //左边项目表格点击事件
	@Override
	protected void kDTable2_tableClicked(KDTMouseEvent e) throws Exception {
		String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
		CheckResultInfo resultInfo = new CheckResultInfo();
		// 表格双击事件
		if(e.getClickCount()==2){
			
			String type=(String) kDTable2.getValueAt(e.getRowIndex(), 0);
			String[] typeArray=type.split("校验");
			type=typeArray[0];
			System.out.println(type);
			if("付款单生成凭证".equals(type)){
				resultInfo = settleAccountFacadeFactory.getRemoteInstance().paymentBillCheck(companyID, periodID);
			}else if("收款单生成凭证".equals(type)){
				resultInfo = settleAccountFacadeFactory.getRemoteInstance().receivingBillCheck(companyID, periodID);
			}else if("采购入库单生成凭证".equals(type)){
				resultInfo = settleAccountFacadeFactory.getRemoteInstance().purInWarehsBillCheck(companyID, periodID);
			}else if("固定资产生成凭证".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().faCurCardCheck(companyID, periodID);
			}else if("低值易耗品生成凭证".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().LCMCurCardCheck(companyID, periodID);
			}else if("采购入库单实际成本为0".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueACost0Check(companyID, periodID);
			}else if("销售订单未关闭状态".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleOrderNotCloseCheck(companyID, periodID);
			}else if("销售出库单未生成应收单".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleIssueBillNoOtherBillCheck(companyID, periodID);
			}else if("领料出库中成本中心和返工".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().materialReqCCReWorkCheck(companyID, periodID);
			}else if("领料出库单据非审核状态".equals(type)){
				settleAccountFacadeFactory.getRemoteInstance().materialReqNotAuditCheck(companyID, periodID);
			}else if("其他出库单成本中心".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueCCenterNot1Check(companyID, periodID);
			}else if("其他出库单实际成本为0".equals(type)){
				resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueACost0Check(companyID, periodID);
			}else{
				
			}
			IRow row;
			ICell cell;
			List<ProblemDetailInfo> problemDetailList = resultInfo.getReturnsObjs();
			//----校验问题表格开始----
			kDTable1.removeRows();
			for(int i=0;i<problemDetailList.size();i++){
				ProblemDetailInfo problemdetailinfo = problemDetailList.get(i);
				row=kDTable1.addRow();
				cell=row.getCell(0);
				cell.setValue(problemdetailinfo.getBillType());
				cell=row.getCell(1);
				cell.setValue(problemdetailinfo.getBillNumber());
				cell=row.getCell(2);
				cell.setValue(problemdetailinfo.getBillProblem());
			}
			//----校验问题表格结束----		
		}
	}
	/**
     * 一键校验
     */
	@Override
	protected void btnCheckAll_actionPerformed(ActionEvent e) throws Exception {
		//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
		//----通用校验开始----
		List<CheckResultInfo> resultInfoList=new ArrayList<CheckResultInfo>();
		CheckResultInfo resultInfo=new CheckResultInfo();
		//后台付款单生成凭证校验
    	resultInfo = settleAccountFacadeFactory.getRemoteInstance().paymentBillCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//后台收款单生成凭证校验
    	resultInfo = settleAccountFacadeFactory.getRemoteInstance().receivingBillCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//采购入库单生成凭证校验
    	resultInfo = settleAccountFacadeFactory.getRemoteInstance().purInWarehsBillCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//固定资产生成凭证校验
    	resultInfo=settleAccountFacadeFactory.getRemoteInstance().faCurCardCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//低值易耗品生成凭证校验
    	resultInfo=settleAccountFacadeFactory.getRemoteInstance().LCMCurCardCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//采购入库实际成本为0校验
    	resultInfo=settleAccountFacadeFactory.getRemoteInstance().purInWarehsACost0Check(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//后台销售订单未关闭状态校验
    	resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleOrderNotCloseCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	//后台销售出库单未生成应收单校验
    	resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleIssueBillNoOtherBillCheck(companyID, periodID);
    	resultInfoList.add(resultInfo);
    	
    	//----通用校验结束----
    	String companyNumber=((CoreBaseInfo) this.prmtCompany.getValue()).getString("number");
    	if(companyNumber.equals("3")){
    		//----养殖公司校验开始----
    		 
        	//----养殖公司校验结束----
    	}else if(companyNumber.equals("4")){
    		//----食品公司校验开始----
    		//后台食品公司：领料出库中成本中心和返工校验
        	resultInfo=settleAccountFacadeFactory.getRemoteInstance().materialReqCCReWorkCheck(companyID, periodID);
        	resultInfoList.add(resultInfo);
        	//后台食品公司：领料出库单据非审核状态校验
        	resultInfo=settleAccountFacadeFactory.getRemoteInstance().materialReqNotAuditCheck(companyID, periodID);
        	resultInfoList.add(resultInfo);
        	//后台食品公司：其他出库单成本中心校验
        	resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueCCenterNot1Check(companyID, periodID);
        	resultInfoList.add(resultInfo);
        	//后台食品公司： 其他出库单实际成本为0校验
        	resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueACost0Check(companyID, periodID);
        	resultInfoList.add(resultInfo);
        	//----食品公司校验结束----
    	}
    	
    	//结果展示到表格中
    	kDTable1.removeRows();
    	kDTable2.removeRows();
    	for(int i=0;i<resultInfoList.size();i++){
    		CheckResultInfo checkResultInfo=resultInfoList.get(i);
    		List<ProblemDetailInfo> problemDetailList = checkResultInfo.getReturnsObjs();
        	IRow row;
        	ICell cell;
        	//----校验项目表格开始----
        	row=kDTable2.addRow();//添加一行
        	cell=row.getCell(0);
        	cell.setValue(checkResultInfo.getCheckItem());//检验项目
        	cell=row.getCell(1);
        	String checkResult=checkResultInfo.getCheckResult();
        	cell.setValue(checkResult);//检验结果
        	if("未通过".equals(checkResult)){
        		cell.getStyleAttributes().setBackground(Color.RED);
        	}else{
        		cell.getStyleAttributes().setBackground(Color.GREEN);
        	}
        	//----校验项目表格结束----    	
    		//----校验问题表格开始----
    		for(int j=0;j<problemDetailList.size();j++){
    			ProblemDetailInfo problemdetailinfo = problemDetailList.get(j);
    			row=kDTable1.addRow();
    			cell=row.getCell(0);
    			cell.setValue(problemdetailinfo.getBillType());
    			cell=row.getCell(1);
    			cell.setValue(problemdetailinfo.getBillNumber());
    			cell=row.getCell(2);
    			cell.setValue(problemdetailinfo.getBillProblem());
    		}
    		//----校验问题表格结束----
    	}
		//----通用校验结束----
	}
	
	
	
	
	
	/**
     *食品公司： 其他出库单实际成本为0校验
     */
	@Override
	protected void btnOtherIssueACost0_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台食品公司： 其他出库单实际成本为0校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueACost0Check(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
     * 食品公司：其他出库单成本中心校验
     */
	@Override
	protected void btnOtherIssueCCenterNot1_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台食品公司：其他出库单成本中心校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().otherIssueCCenterNot1Check(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	
	/**
     * 食品公司：领料出库单据非审核状态校验
     */
	@Override
	protected void btnMaterialReqNotAudit_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台食品公司：领料出库单据非审核状态校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().materialReqNotAuditCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	
	/**
	 * 食品公司：领料出库中成本中心和返工校验
	 */
	@Override
	protected void btnMaterialReqCCReWork_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台食品公司：领料出库中成本中心和返工校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().materialReqCCReWorkCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
	 * 销售出库单未生成应收单校验
	 */
	@Override
	protected void btnSaleIssueBillNoOtherBill_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台销售出库单未生成应收单校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleIssueBillNoOtherBillCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
	 * 销售订单未关闭状态校验
	 */
	@Override
	protected void btnSaleOrderNotClose_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台销售订单未关闭状态校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().saleOrderNotCloseCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
	 * 采购入库实际成本为0校验
	 */
	@Override
	protected void btnPurInWarehsACost0_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台采购入库实际成本为0校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().purInWarehsACost0Check(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
	 * 低值易耗品生成凭证校验
	 */
	@Override
	protected void btnLCMCurCardNoVoucher_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台低值易耗品生成凭证校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().LCMCurCardCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
	 * 固定资产生成凭证校验
	 */
    @Override
	protected void btnFaCurCardNoVoucher_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
    	//后台固定资产生成凭证校验
    	CheckResultInfo resultInfo=settleAccountFacadeFactory.getRemoteInstance().faCurCardCheck(companyID, periodID);
    	//校验结果设置到表格
    	setSingleResultTable(resultInfo);
	}
	/**
     * 采购入库未生成凭证校验
     */
    @Override
	protected void btnPurInWarehsNoVoucher_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----

		//后台付款单生成凭证校验
    	CheckResultInfo resultInfo = settleAccountFacadeFactory.getRemoteInstance().purInWarehsBillCheck(companyID, periodID);
    	List<ProblemDetailInfo> problemDetailList = resultInfo.getReturnsObjs();
    	
    	//结果展示到表格中
    	IRow row;
    	ICell cell;
    	//----校验项目表格开始----
    	kDTable2.removeRows();//清空所有表体行
    	row=kDTable2.addRow();//添加一行
    	cell=row.getCell(0);
    	cell.setValue(resultInfo.getCheckItem());//检验项目
    	cell=row.getCell(1);
    	String checkResult=resultInfo.getCheckResult();
    	cell.setValue(checkResult);//检验结果
    	if("未通过".equals(checkResult)){
    		cell.getStyleAttributes().setBackground(Color.RED);
    	}else{
    		cell.getStyleAttributes().setBackground(Color.GREEN);
    	}
    	//----校验项目表格结束----    	
		//----校验问题表格开始----
		kDTable1.removeRows();
		for(int i=0;i<problemDetailList.size();i++){
			ProblemDetailInfo problemdetailinfo = problemDetailList.get(i);
			row=kDTable1.addRow();
			cell=row.getCell(0);
			cell.setValue(problemdetailinfo.getBillType());
			cell=row.getCell(1);
			cell.setValue(problemdetailinfo.getBillNumber());
			cell=row.getCell(2);
			cell.setValue(problemdetailinfo.getBillProblem());
		}
		//----校验问题表格结束----		
		
		
	}
	/**
     * 付款单生成凭证校验
     */
    @Override
	protected void btnPaymentNoVoucher_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----

		//后台付款单生成凭证校验
    	CheckResultInfo resultInfo = settleAccountFacadeFactory.getRemoteInstance().paymentBillCheck(companyID, periodID);
    	List<ProblemDetailInfo> problemDetailList = resultInfo.getReturnsObjs();
    	
    	//结果展示到表格中
    	IRow row;
    	ICell cell;
    	//----校验项目表格开始----
    	kDTable2.removeRows();//清空所有表体行
    	row=kDTable2.addRow();//添加一行
    	cell=row.getCell(0);
    	cell.setValue(resultInfo.getCheckItem());//检验项目
    	cell=row.getCell(1);
    	String checkResult=resultInfo.getCheckResult();
    	cell.setValue(checkResult);//检验结果
    	if("未通过".equals(checkResult)){
    		cell.getStyleAttributes().setBackground(Color.RED);
    	}else{
    		cell.getStyleAttributes().setBackground(Color.GREEN);
    	}
    	//----校验项目表格结束----    	
		//----校验问题表格开始----
		kDTable1.removeRows();
		for(int i=0;i<problemDetailList.size();i++){
			ProblemDetailInfo problemdetailinfo = problemDetailList.get(i);
			row=kDTable1.addRow();
			cell=row.getCell(0);
			cell.setValue(problemdetailinfo.getBillType());
			cell=row.getCell(1);
			cell.setValue(problemdetailinfo.getBillNumber());
			cell=row.getCell(2);
			cell.setValue(problemdetailinfo.getBillProblem());
		}
		//----校验问题表格结束----		
		
		
	}
	/**
     * 收款单生成凭证校验
     */
    @Override
	protected void btnReceivNoVoucher_actionPerformed(ActionEvent e)
			throws Exception {
    	//----获取界面参数开始----
    	String companyID=null,periodID=null;
		if(this.prmtCompany.getValue()!=null) {
			companyID=((CoreBaseInfo) this.prmtCompany.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("组织不能为空！ ");
			SysUtil.abort();
		}
		if(this.prmtPeriod.getValue()!=null) {
			periodID=((CoreBaseInfo) this.prmtPeriod.getValue()).getId().toString();
		}else {
			MsgBox.showWarning("期间不能为空！ ");
			SysUtil.abort();
		}
    	//----获取界面参数结束----
		
		//后台收款单生成凭证校验
    	CheckResultInfo resultInfo = settleAccountFacadeFactory.getRemoteInstance().receivingBillCheck(companyID, periodID);
    	List<ProblemDetailInfo> problemDetailList = resultInfo.getReturnsObjs();
    	
    	//结果展示到表格中
    	IRow row;
    	ICell cell;
    	//----校验项目表格开始----
    	kDTable2.removeRows();//清空所有表体行
    	row=kDTable2.addRow();//添加一行
    	cell=row.getCell(0);
    	cell.setValue(resultInfo.getCheckItem());//检验项目
    	cell=row.getCell(1);
    	String checkResult=resultInfo.getCheckResult();
    	cell.setValue(checkResult);//检验结果
    	if("未通过".equals(checkResult)){
    		cell.getStyleAttributes().setBackground(Color.RED);
    	}else{
    		cell.getStyleAttributes().setBackground(Color.GREEN);
    	}
    	//----校验项目表格结束----    	
		//----校验问题表格开始----
		kDTable1.removeRows();
		for(int i=0;i<problemDetailList.size();i++){
			ProblemDetailInfo problemdetailinfo = problemDetailList.get(i);
			row=kDTable1.addRow();
			cell=row.getCell(0);
			cell.setValue(problemdetailinfo.getBillType());
			cell=row.getCell(1);
			cell.setValue(problemdetailinfo.getBillNumber());
			cell=row.getCell(2);
			cell.setValue(problemdetailinfo.getBillProblem());
		}
		//----校验问题表格结束----		
	}
    
    /**
     * 将单项校验结果展示到表格中
     * @param resultInfo
     */
    public void setSingleResultTable(CheckResultInfo resultInfo){
    	List<ProblemDetailInfo> problemDetailList = resultInfo.getReturnsObjs();
    	//结果展示到表格中
    	IRow row;
    	ICell cell;
    	//----校验项目表格开始----
    	kDTable2.removeRows();//清空所有表体行
    	row=kDTable2.addRow();//添加一行
    	cell=row.getCell(0);
    	cell.setValue(resultInfo.getCheckItem());//检验项目
    	cell=row.getCell(1);
    	String checkResult=resultInfo.getCheckResult();
    	cell.setValue(checkResult);//检验结果
    	if("未通过".equals(checkResult)){
    		cell.getStyleAttributes().setBackground(Color.RED);
    	}else{
    		cell.getStyleAttributes().setBackground(Color.GREEN);
    	}
    	//----校验项目表格结束----    	
		//----校验问题表格开始----
		kDTable1.removeRows();
		for(int i=0;i<problemDetailList.size();i++){
			ProblemDetailInfo problemdetailinfo = problemDetailList.get(i);
			row=kDTable1.addRow();
			cell=row.getCell(0);
			cell.setValue(problemdetailinfo.getBillType());
			cell=row.getCell(1);
			cell.setValue(problemdetailinfo.getBillNumber());
			cell=row.getCell(2);
			cell.setValue(problemdetailinfo.getBillProblem());
		}
		//----校验问题表格结束----		
    }
  
	/**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

}