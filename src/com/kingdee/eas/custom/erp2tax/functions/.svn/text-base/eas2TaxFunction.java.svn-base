package com.kingdee.eas.custom.erp2tax.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.basedata.master.cssp.ICustomer;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.erp2tax.ERP2TaxFacadeFactory;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.fi.ar.BillStatusEnum;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.fi.ar.client.OtherBillEditUI;
import com.kingdee.eas.fi.ar.client.OtherBillListUI;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillEditUI;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillListUI;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * erp 系统单据生成金税软件xml文件功能类
 * @author dai_andong
 *
 */
public class eas2TaxFunction {
	private SaleIssueBillListUI listui;
	private SaleIssueBillEditUI editui;
	private String spbm="";//税收分类代码
	private String xmlPathTemp,xmlPathBackupTemp,txtPathTemp,txtPathBackupTemp;
	private String xmlPath,xmlPathBackup,txtPath,txtPathBackup;//普票
	private String xmlPathDedicated,xmlPathBackupDedicated,txtPathDedicated,txtPathBackupDedicated;//专票
	private int maxRowCount=7;//发票最大行数
	private BigDecimal maxAmount;//发票最大金额
	private static Thread thread;//后台反写进程
	private String companyID;
	private boolean isExistBaseSetting=false;
	private boolean isAuditAutoExport=false;//审核自动导入
	private ICustomer ics=null;
	public final static int Export_NoSum=1;//非合并导入
	public final static int Export_WithSum=2;//合并导入
	public final static int Export_WithSpit=3;//拆分导入
	private int nowNumIndex=0;//当前序号
//	private SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 初始化 listui
	 */
	public void initListUI(final UIParam param) {
		listui=(SaleIssueBillListUI) param.getUI();
//		param.getUIContext();
		companyID=((SysContext) param.getUIContext().get("sysContext")).getCurrentFIUnit().getString("id");
		try {
			setDeafultSetting(companyID);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		
		//导入到金税接口
		if(param.getKDMenuItem("mBtnExport2Tax")!=null) {
			param.getKDMenuItem("mBtnExport2Tax").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
//					if(!isExistBaseSetting) {
//						MsgBox.showWarning("没有进行金税导入配置！");
//						return;
//					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_NoSum,false);
				}});
		}
		//合并导入到金税
		if(param.getKDMenuItem("mBtnExport2TaxSum")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSum").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_WithSum,false);
				}});
		}
		//拆分导入到金税
		if(param.getKDMenuItem("mBtnExport2TaxSplit")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSplit").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_WithSpit,false);
				}});
		}
		
		//导入到金税接口--专票
		if(param.getKDMenuItem("mBtnExport2TaxDedicated")!=null) {
			param.getKDMenuItem("mBtnExport2TaxDedicated").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_NoSum,true);
				}});
		}
		//合并导入到金税--专票
		if(param.getKDMenuItem("mBtnExport2TaxSumDedicated")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSumDedicated").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_WithSum,true);
				}});
		}
		//拆分导入到金税--专票
		if(param.getKDMenuItem("mBtnExport2TaxSplitDedicated")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSplitDedicated").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=(Object[]) listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Export_WithSpit,true);
				}});
		}
		
		if(thread==null&&isExistBaseSetting) {
			thread=new Thread(new threadClass());
			thread.start();
		}
	}
	
	/**
	 * 初始化 listui
	 */
	public void initEditUI(final UIParam param) {
		editui=(SaleIssueBillEditUI) param.getUI();
		companyID=((SysContext) param.getUIContext().get("sysContext")).getCurrentFIUnit().getString("id");
		
		try {
			setDeafultSetting(companyID);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		//导入到金税接口
		if(param.getKDMenuItem("btnExport2Tax")!=null) {
			param.getKDWorkButton("btnExport2Tax").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Export_NoSum,false);
				}});
		}
		//拆分导入到金税
		if(param.getKDMenuItem("mBtnExport2TaxSplit")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSplit").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Export_WithSpit,false);
				}});
		}
		//导入到金税接口--专票
		if(param.getKDMenuItem("btnExport2TaxDedicated")!=null) {
			param.getKDWorkButton("btnExport2TaxDedicated").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Export_NoSum,true);
				}});
		}
		//拆分导入到金税--专票
		if(param.getKDMenuItem("mBtnExport2TaxSplitDedicated")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSplitDedicated").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(!isExistBaseSetting) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Export_WithSpit,true);
				}});
		}
		if(thread==null) {
			thread=new Thread(new threadClass());
			thread.start();
		}
	}
	
	/**
	 * 审核完成后执行自动导出
	 * @param param
	 */
	public void afterAuditExeExport(final UIParam param) {
		editui=(SaleIssueBillEditUI) param.getUI();
		companyID=((SysContext) param.getUIContext().get("sysContext")).getCurrentFIUnit().getString("id");
		
		try {
			setDeafultSetting(companyID);
		} catch (BOSException e) {
			e.printStackTrace();
		}
		//自动导出
		if(isAuditAutoExport&&((OtherBillInfo)editui.getDataObject()).getBillStatus().equals(BillStatusEnum.AUDITED)) {
			if(!isExistBaseSetting) {
				MsgBox.showWarning("没有进行金税导入配置！");
				return;
			}
			if(param.getDataObject().get("id")==null) {
				return ;
			}
			String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
			exeExportToTax(companyID,billIDs,Export_NoSum,false);
		}
	}
	
	
	public void closeThread() {
		//断掉线程
		if(thread.isAlive()) {
			thread.interrupt();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		closeThread();
	}



	/**
	 * 执行导入到金税接口
	 * @param billIDs
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void exeExportToTax(String companyID,Object[] billIDs,int opType,boolean isDedicated) {
		if(MsgBox.showConfirm2("是否导入到金税")!=MsgBox.YES) {
			return;
		}

		if(opType==Export_WithSpit&&billIDs.length>1) {
			MsgBox.showWarning("请选择一行记录操作！");
			return;
		}
		
		String hasExportBillNums="";
		ArrayList<String> hasExportBillIDs=new ArrayList<String>();
		
		String[] reusltStrs;
		String asstActIDKeep=null;//往来户id
		for(int i=0;i<billIDs.length;i++) {
			reusltStrs=checkHasTax(billIDs[i].toString());
			//需要合并
			if(opType==Export_WithSum){
				if(asstActIDKeep==null) {
					asstActIDKeep=reusltStrs[2];
				}else{
					if(!asstActIDKeep.equals(reusltStrs[2])) {
						MsgBox.showWarning("所选合并记录存在不一致的客户！");
						return;
					}
				}
			}
			//已经导入过
			if(reusltStrs!=null&&StringUtils.isNotBlank(reusltStrs[0])) {
				hasExportBillIDs.add(billIDs[i].toString());
				if(hasExportBillNums.length()>0)
					hasExportBillNums+=",";
				hasExportBillNums+=reusltStrs[1];
			}
		}
		
		boolean isRedo=false;//重复生成
		StringBuffer exportBillIDs=new StringBuffer();
		if(hasExportBillIDs.size()>0&&MsgBox.showConfirm2("单据"+hasExportBillNums+"单据已经生成金税发票,是否重新生成？")==MsgBox.YES){
			isRedo=true;
		}

		for(int i=0;i<billIDs.length;i++) {
			if(!isRedo&&hasExportBillIDs.contains(billIDs[i])) {
				continue;
			}
			if(exportBillIDs.length()>0) {
				exportBillIDs.append(",");
			}
			exportBillIDs.append("'").append(billIDs[i]).append("'");
		}
		
		try {
			if(exportBillIDs.length()>0) {
				//专票
				if(isDedicated) {
					xmlPathTemp=xmlPathDedicated;
					xmlPathBackupTemp=xmlPathBackupDedicated;
					txtPathTemp=txtPathDedicated;
					txtPathBackupTemp=txtPathBackupDedicated;
				}
				//普票
				else {
					xmlPathTemp=xmlPath;
					xmlPathBackupTemp=xmlPathBackup;
					txtPathTemp=txtPath;
					txtPathBackupTemp=txtPathBackup;
				}
				nowNumIndex=0;
				
				//组织编码
				String companyNum=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)).getNumber();
				boolean isSuccess=true;
				if(opType==Export_WithSum) {
					isSuccess=exeExportToTaxWithSum(companyNum,exportBillIDs.toString());
				}else if (opType==Export_NoSum){
					isSuccess=exeExportToTaxNoSum(companyNum,exportBillIDs.toString());
				}else if(opType==Export_WithSpit) {
					isSuccess=exeExportWithSplit(companyNum,billIDs[0].toString());
				}
				if(isSuccess) {
					MsgBox.showInfo("生成XML文件完成！");
				}
			}
		} catch (Exception e) {
			MsgBox.showError(e.getMessage());
		}
	}
	
	/**
	 * 执行拆分导入
	 * @param companyNum
	 * @param exportBillIDs
	 * @throws UIException
	 */
	private boolean exeExportWithSplit(String companyNum,String exportBillID) throws Exception {
		UIContext uiContext = new UIContext(this);
		uiContext.put("companyNum", companyNum);// id
		uiContext.put("exportBillIDs", exportBillID);// id
		OtherBillInfo info = OtherBillFactory.getRemoteInstance().getOtherBillInfo(new ObjectUuidPK(exportBillID));
		uiContext.put("allAmount",info.getAmountLocal());// id
		uiContext.put("maxAmount",maxAmount);// id
		IUIWindow uiWindow = null;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.erp2tax.client.ERP2TaxSplitUI", uiContext, null, OprtState.VIEW);
		uiWindow.show();
		//非取消
		if(!(Boolean)uiWindow.getUIObject().getUIContext().get("isCancel")) {
			ArrayList<BigDecimal> amountList=(ArrayList<BigDecimal>) uiWindow.getUIObject().getUIContext().get("amountList");
			if(amountList.size()>1) {
				exeExportToTaxSplit(companyNum, "'"+exportBillID+"'",(Boolean) uiWindow.getUIObject().getUIContext().get("isSplitInit"),info.getAmountLocal(),amountList);
			}else {
				//单条导入
				exeExportToTaxNoSum(companyNum, "'"+exportBillID+"'");
			}
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 执行导入非合并
	 * @throws Exception 
	 */
	private boolean exeExportToTaxNoSum(String companyNum,String exportBillIDs) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbill.FID,tbill.FNumber,tcus.FName_l2 FCustomerName,tcus.fnumber FCustomerNum,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tentry.FID FEntryID,tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,")
			// CFSettleQty
			.append(" isnull(tentry.FQuantity,0) FQty,isnull(tentry.FPrice,0) FPrice,isnull(tentry.CFOrderBillPrice,0) FTaxPrice,isnull(tentry.FAmount,0) FAmount,isnull(tentry.FRecievePayAmount,0) FRecievePayAmount,isnull(tentry.FTaxRate,0)/100 FTaxRate,")
			.append(" isnull(tentry.FDiscountAmount,0) FDiscountAmount,tentry.FSeq,tmc.cftaxCode cftaxCode")//折扣额、税收分类代码tmc.cftaxCode
			.append(" from t_ar_otherbill tbill")
			.append(" inner join t_ar_otherBillEntry tentry on tentry.fparentid=tbill.fid ")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FAsstActID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tbill.FCompanyID")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FMeasureUnitID")
			.append(" where tbill.fid in (").append(exportBillIDs).append(")")
			.append(" order by tbill.fnumber, tentry.fseq ")
			.append(" ")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			String billID,billIDKeep=null;
			HashMap<String,ExportBean> exportBeanMap=new HashMap<String,ExportBean>();
			ExportBean eb=null;
			String userName=SysContext.getSysContext().getCurrentUserInfo().getName();
			BigDecimal discountAmount;//折扣额，返利金额
			BigDecimal allAmount,sumAllAmount=BigDecimal.ZERO;//总价税合计
			BigDecimal qty,price,taxPrice,taxRate;
			int nowRowCount=0;//当前发票行数
			while(rs.next()) {
				if(StringUtils.isBlank(rs.getString("cftaxCode"))) {
					 throw new Exception("物料："+rs.getString("FMaterialName")+"，尚未维护税收分类代码");
				}
				 billID=rs.getString("fid");
				 if(billIDKeep==null) {
					 billIDKeep=billID;
					 
					 eb=createNewExportBean(companyNum,rs.getString("FCustomerNum"), rs.getString("FCustomerName"), rs.getString("FTxRegisterNo")
							 ,rs.getString("FAddress"),null,rs.getBigDecimal("FTaxRate").signum()>0?true:false, userName);
	                 exportBeanMap.put(eb.getTimeStr(), eb);
				 }else {
					 //新单据或者最后一行
					 if(!billIDKeep.equals(billID)) {
						 
						 eb=createNewExportBean(companyNum,rs.getString("FCustomerNum"), rs.getString("FCustomerName"),
								 rs.getString("FTxRegisterNo"),rs.getString("FAddress"),null,rs.getBigDecimal("FTaxRate").signum()>0?true:false, userName);
		                 exportBeanMap.put(eb.getTimeStr(), eb);
		                 
		                 billIDKeep=billID;
		                 sumAllAmount=BigDecimal.ZERO;
		                 nowRowCount=0;
					 }
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");//返利
				 allAmount=rs.getBigDecimal("FRecievePayAmount");//应收金额
				 
				 qty=rs.getBigDecimal("FQty");
				 taxPrice=rs.getBigDecimal("FTaxPrice");
				 taxRate=rs.getBigDecimal("FTaxRate");
//				 price=taxPrice.divide(BigDecimal.ONE.add(taxRate),10,BigDecimal.ROUND_HALF_UP);
				 if(taxRate.signum()>0) {
					 price=rs.getBigDecimal("FAmount").divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 }else {
					 price=taxPrice;
				 }
				 
				 if(allAmount.compareTo(maxAmount)>0) {
					 throw new Exception("单据"+rs.getString("fnumber")+"第"+rs.getInt("FSeq")+"行分录应收金额超出开票最大支持金额"+maxAmount);
				 }
				 
				 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
				 if(sumAllAmount.add(allAmount).compareTo(maxAmount)>0||(nowRowCount+1)>maxRowCount
						 ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+2)>maxRowCount)) {
					 
					 eb=createNewExportBean(companyNum,rs.getString("FCustomerNum"), rs.getString("FCustomerName"),
							 rs.getString("FTxRegisterNo"),rs.getString("FAddress"),null,rs.getBigDecimal("FTaxRate").signum()>0?true:false, userName);
	                 exportBeanMap.put(eb.getTimeStr(), eb);
	                 
	                 sumAllAmount=BigDecimal.ZERO;
	                 nowRowCount=0;
				 }
				 
				 sumAllAmount=sumAllAmount.add(allAmount);
				 nowRowCount++;
				 
				 //发票分录
				 ExportEntryBean eeb = new ExportEntryBean();
				 eeb.setSeq(nowRowCount);
				 eeb.setMaterialNum (rs.getString("FMaterialNum"));
                 eeb.setMaterialName(rs.getString("FMaterialName"));
                 eeb.setTaxCode(rs.getString("cftaxCode"));
                 eeb.setModel(rs.getString("FModel"));
                 eeb.setMeasureUnit(rs.getString("FUnitName"));
                 eeb.setTaxPrice(taxPrice);
                 eeb.setQty(qty);
                 eeb.setAllAmount(allAmount);
                 eeb.setAmount(rs.getBigDecimal("FAmount"));//不含税金额
                 eeb.setPrice(price);//不含税单价
                 eeb.setTaxRate(taxRate);

                 eeb.setSrcID(rs.getString("FEntryID"));
                 
                 eb.getExportEntryCols().add(eeb);
                 
                 //增加返利分录
                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
                	 //发票分录
    				 ExportEntryBean eebDis = new ExportEntryBean();
    				 eebDis.setSeq(nowRowCount);
    				 eebDis.setMaterialNum (rs.getString("FMaterialNum"));
    				 eebDis.setMaterialName(rs.getString("FMaterialName"));
    				 eebDis.setModel(rs.getString("FModel"));
    				 eebDis.setMeasureUnit("");
    				 eebDis.setTaxPrice(BigDecimal.ZERO);
    				 eebDis.setQty(BigDecimal.ZERO);
    				 eebDis.setAllAmount(new BigDecimal(-1).multiply(discountAmount));
    				 eebDis.setAmount(eebDis.getAllAmount());
    				 eebDis.setPrice(BigDecimal.ZERO);//不含税单价
    				 eebDis.setTaxRate(BigDecimal.ZERO);
    				 eebDis.setSrcID(rs.getString("FEntryID"));
    				 
                     eb.getExportEntryCols().add(eebDis);
                 }
			}
			//生成XML
			if(exportBeanMap.size()>0) {
				exeCreateXML(exportBillIDs,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return true;
	}
	/**
	 * 反写时间戳
	 * @throws BOSException 
	 */
	private void reWriteTimeNo(String timeNo,String exportBillIDs,String entryIDs,String customerNum) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" update t_ar_otherBill")
		.append(" set CFtimeNo='").append(timeNo).append("'")
		.append(" ,CFHasCreateXML=1")
		.append(" where 1=1");
		if(StringUtils.isNotEmpty(exportBillIDs)) {
			sql.append(" and fid in (").append(exportBillIDs).append(")");
		}
		if(StringUtils.isNotEmpty(entryIDs)) {
			sql.append(" and fid in (")
			.append(" select distinct Fparentid from t_ar_otherBillEntry where fid in (").append(entryIDs).append(")")
			.append(")");
		}
		if(StringUtils.isNotEmpty(customerNum)) {
			sql.append(" and FAsstActNumber ='").append(customerNum).append("'");
		}
		ERP2TaxFacadeFactory.getRemoteInstance().execute(sql.toString());
	}
	
	/**
	 * 创建新的导入bean
	 * @param customerNum
	 * @param customerName
	 * @param taxNo
	 * @param userName
	 * @return
	 */
	private ExportBean createNewExportBean(String companyNum,String customerNum,String customerName,String taxNo,
			String address,String bankNo,boolean isTaxRate,String userName) {
		 String timeStr = String.valueOf(new java.util.Date().getTime())+"-"+(nowNumIndex++);
		 String filePathAndName = xmlPathTemp + "\\"+companyNum+"@" + customerNum+ "@" + timeStr + ".xml";
         //新增表头
		 ExportBean eb = new ExportBean();
         eb.setNumber(companyNum+"@"+timeStr);
         eb.setTimeStr(timeStr);
         eb.setCompanyNum(companyNum);
         eb.setCustomerNum(customerNum);
         eb.setCustomerName(customerName);
         eb.setCustomerTaxNo(taxNo==null?"":taxNo);
         eb.setCustomerBankNo(bankNo==null?"":bankNo);
         eb.setCustomerAddTel(address==null?"":address);
         eb.setTaxRate(isTaxRate);
/*         try {
        	 if(ics==null) {
        		 ics=CustomerFactory.getRemoteInstance();
        	 }
        	 CustomerInfo cInfo = ics.getCustomerInfo("where number='"+customerNum+"'");
        	 eb.setCustomerBankNo("");
             eb.setCustomerAddTel(cInfo.getAddress()==null?"":cInfo.getAddress());
         }catch(Exception err) {
        	 err.printStackTrace();
         }*/
         
         //eb.remark = row.Cells["remark"].Value.ToString(); 
         eb.setChecker(userName);
         eb.setPayee(userName);
         eb.setFilePathAndName(filePathAndName);
         eb.setRemark("");
         return eb;
	}
	
	/**
	 * 执行导入合并
	 * @throws Exception 
	 */
	private boolean exeExportToTaxWithSum(String companyNum,String exportBillIDs) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbill.FAsstActNumber FCustomerNum,tbill.FAsstActName_l2 FCustomerName,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,cftaxCode cftaxCode,")//cftaxCode
			//CFSettleQty 
			.append(" sum(tentry.FQuantity) FQty,")//FTaxPrice avg(tentry.FPrice) FPrice,avg(tentry.CFOrderBillPrice) FTaxPrice,
			.append(" sum(tentry.FAmount) FAmount,sum(tentry.FRecievePayAmount) FRecievePayAmount,sum(tentry.FTaxAmount) FTaxAmount,")//avg(tentry.FTaxRate)/100 FTaxRate
			.append(" sum(tentry.FDiscountAmount) FDiscountAmount")//折扣额
			.append(" from t_ar_otherbill tbill")
			.append(" inner join t_ar_otherBillEntry tentry on tentry.FParentid=tbill.fid")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FAsstActID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tbill.FCompanyID")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FMeasureUnitID")
			.append(" where tbill.fid in (").append(exportBillIDs).append(")")
			//客户物料分组
//			.append(" group by tcus.fnumber,tcus.FName_l2,tcus.FTxRegisterNo,tm.fnumber,tm.FName_l2,")
//			.append(" tm.FModel,tu.FName_l2,tentry.FTaxRate")
			.append(" group by tbill.FAsstActNumber,tbill.FAsstActName_l2,tcus.FTxRegisterNo,tcus.FAddress,")
			.append(" tm.fnumber,tm.FName_l2,tm.FModel,tu.FName_l2,tmc.cftaxCode")
//			.append(" order by tcus.fnumber,tm.fnumber")
			.append(" ")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			String customerNum,customerNumKeep=null;
			HashMap<String,ExportBean> exportBeanMap=new HashMap<String,ExportBean>();
			ExportBean eb=null;
			String userName=SysContext.getSysContext().getCurrentUserInfo().getName();
			BigDecimal discountAmount;//折扣额，返利金额
			BigDecimal amount,taxAmount,allAmount,sumAllAmount=BigDecimal.ZERO;//总价税合计
			BigDecimal qty,price,taxPrice,taxRate;
			int nowRowCount=0;//当前发票行数
			while(rs.next()) {
				if(StringUtils.isBlank(rs.getString("cftaxCode"))) {
					 throw new Exception("物料："+rs.getString("FMaterialName")+"，尚未维护税收分类代码");
				}
				
				 customerNum=rs.getString("FCustomerNum");
				 if(customerNumKeep==null) {
					 customerNumKeep=customerNum;
					 eb=createNewExportBean(companyNum,customerNum, rs.getString("FCustomerName"), rs.getString("FTxRegisterNo"),
							 rs.getString("FAddress"),null,rs.getBigDecimal("FTaxAmount").signum()>0?true:false, userName);
	                 exportBeanMap.put(eb.getTimeStr(), eb);
				 }else {
					 //新单据或者最后一行
					 if(!customerNumKeep.equals(customerNum)) {
						 throw new EASBizException(new NumericExceptionSubItem("001","非同一客户不允许合并！"));
						/* 
						 String timeStr = String.valueOf(new java.util.Date().getTime());
						 eb=createNewExportBean(companyNum,timeStr,customerNum, rs.getString("FCustomerName"), rs.getString("FTxRegisterNo"), userName);
		                 exportBeanMap.put(timeStr, eb);
		                 
		                 customerNumKeep=customerNum;
		                 sumAllAmount=BigDecimal.ZERO;
		                 nowRowCount=0;*/
					 }
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");
				 allAmount=rs.getBigDecimal("FRecievePayAmount");
				 amount=rs.getBigDecimal("FAmount");//不含税金额
				 taxAmount=rs.getBigDecimal("FTaxAmount");//税额
				 
				 qty=rs.getBigDecimal("FQty");
				 
				 taxPrice=allAmount.divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 price=amount.divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 
				 taxRate=taxAmount.divide(amount,2,BigDecimal.ROUND_HALF_UP);
				 
				 if(allAmount.compareTo(maxAmount)>0) {
					 throw new Exception("客户"+rs.getString("FCustomerName")+"物料"+rs.getInt("FMaterialName")+"合计应收金额超出开票最大支持金额"+maxAmount);
				 }
				 
				 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
				 if(sumAllAmount.add(allAmount).compareTo(maxAmount)>0||(nowRowCount+1)>maxRowCount
						 ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+2)>maxRowCount)) {
					 
					 eb=createNewExportBean(companyNum,customerNum, rs.getString("FCustomerName"), rs.getString("FTxRegisterNo")
							 , rs.getString("FAddress"),null,rs.getBigDecimal("FTaxRate").signum()>0?true:false, userName);
	                 exportBeanMap.put(eb.getTimeStr(), eb);
	                 
	                 sumAllAmount=BigDecimal.ZERO;
	                 nowRowCount=0;
				 }
				 
				 sumAllAmount=sumAllAmount.add(allAmount);
				 nowRowCount++;
				 
				 //发票分录
				 ExportEntryBean eeb = new ExportEntryBean();
				 eeb.setSeq(nowRowCount);
				 eeb.setMaterialNum (rs.getString("FMaterialNum"));
                 eeb.setMaterialName(rs.getString("FMaterialName"));
                 eeb.setTaxCode(rs.getString("cftaxCode"));
                 eeb.setModel(rs.getString("FModel"));
                 eeb.setMeasureUnit(rs.getString("FUnitName"));
                 eeb.setTaxPrice(taxPrice);
                 eeb.setQty(qty);
                 eeb.setAllAmount(allAmount);
                 eeb.setAmount (amount);
                 eeb.setPrice(price);//不含税单价
                 eeb.setTaxRate(taxRate);
                 
                 eeb.setSrcID(null);
                 
                 eb.getExportEntryCols().add(eeb);
                 
                 //增加返利分录
                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
                	 //发票分录
    				 ExportEntryBean eebDis = new ExportEntryBean();
    				 eebDis.setSeq(nowRowCount);
    				 eebDis.setMaterialNum (rs.getString("FMaterialNum"));
    				 eebDis.setMaterialName(rs.getString("FMaterialName"));
    				 eebDis.setModel(rs.getString("FModel"));
    				 eebDis.setMeasureUnit("");
    				 eebDis.setTaxPrice(BigDecimal.ZERO);
    				 eebDis.setQty(BigDecimal.ZERO);
    				 eebDis.setAllAmount(new BigDecimal(-1).multiply(discountAmount));
    				 eebDis.setAmount(eebDis.getAllAmount());
    				 eebDis.setPrice(BigDecimal.ZERO);//不含税单价
    				 eebDis.setTaxRate(BigDecimal.ZERO);
    				 eebDis.setSrcID(null);
                     eb.getExportEntryCols().add(eebDis);
                 }
			}
			//生成XML
			if(exportBeanMap.size()>0) {
				exeCreateXML(exportBillIDs,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return true;
	}
	
	
	private static String[] checkHasTax(String billID) {
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance("select fnumber,FCustomerID,CFSerialNo from T_IM_SaleIssueBill where  fid='"+billID+"'").executeSQL();
			if(rs.next()) {
				String[] result=new String[3];
				result[0]=rs.getString("CFSerialNo");
				result[1]=rs.getString("fnumber");
				result[2]=rs.getString("FCustomerID");
				return result;
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 设置默认参数
	 * @throws BOSException 
	 */
	private void setDeafultSetting(String companyID) throws BOSException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select * from ").append(" T_ERP_BaseSetting ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" order by FCreateTime desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				spbm=rs.getString("FSpbm");
				xmlPath=rs.getString("FXmlPath");
				xmlPathBackup=rs.getString("FXmlBackupPath");
				txtPath=rs.getString("FTxtPath");
				txtPathBackup=rs.getString("FTxtBackupPath");
				
				xmlPathDedicated=rs.getString("FXmlPath")+"Dedicated";
				xmlPathBackupDedicated=rs.getString("FXmlBackupPath")+"Dedicated";
				txtPathDedicated=rs.getString("FTxtPath")+"Dedicated";
				txtPathBackupDedicated=rs.getString("FTxtBackupPath")+"Dedicated";
				
				maxRowCount=rs.getInt("FMaxRow");
				maxAmount=rs.getBigDecimal("FMaxAmount");
//				isAuditAutoExport=rs.getBoolean("FIsAuditAutoCreate");
				isExistBaseSetting=true;
			}else {
				isExistBaseSetting=false;
				isAuditAutoExport=false;
				return;
//				MsgBox.showWarning("没有进行金税导入配置！");
			}
			rs.close();
			
        	
        	File filePath = new File(xmlPath);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(xmlPathBackup);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(txtPath);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(txtPathBackup);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	
        	filePath = new File(xmlPathDedicated);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(xmlPathBackupDedicated);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(txtPathDedicated);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	filePath = new File(txtPathBackupDedicated);
        	if(!filePath.exists()) {
        		filePath.mkdirs();
        	}
        	
		}catch(Exception err) {
			throw new BOSException(err);
		}
		
	}
	
    /*
   * 生成xml文件
   */
    private void exeCreateXML(String exportBillIDs,HashMap<String, ExportBean> map) throws Exception
    {
        if (map != null && map.size()>0)
        {
            String filePathAndName;
            String timeStr;
            String entryIDs;
            ExportBean eb;
            Map.Entry entry;
            Iterator<Entry<String, ExportBean>> iter = map.entrySet().iterator();
            OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
            xmlFormat.setEncoding("GBK");
            while (iter.hasNext()) {
            {
            	entry=iter.next();
            	timeStr=(String) entry.getKey();
                eb=(ExportBean) entry.getValue();

                if (eb.getExportEntryCols().size() <= 0)//没有分录的话不导出
                    continue;

                filePathAndName=eb.getFilePathAndName();//文件路径
                
        		Document document = DocumentHelper.createDocument();// 建立document对象， 用来操作xml文件
        		document.addComment("金税发票导入xml");// 加入一行注释
        		Element rootElement = document.addElement("Kp");// 建立根节点
        		rootElement.addElement("Version").setText("2.0");
        		Element FpxxElement = rootElement.addElement("Fpxx");// 添加一个Fpxx节点
        		FpxxElement.addElement("Zsl").setText("1");
        		Element FpsjElement = FpxxElement.addElement("Fpsj");// 
        		Element FpElement = FpsjElement.addElement("Fp");// 
        		FpElement.addElement("Djh").setText(eb.getNumber());//单据编号
        		FpElement.addElement("Gfmc").setText(eb.getCustomerName());//购方名称
        		FpElement.addElement("Gfsh").setText( eb.getCustomerTaxNo());//购方税号
        		FpElement.addElement("Gfyhzh").setText(eb.getCustomerBankNo());//购方银行账号
        		FpElement.addElement("Gfdzdh").setText( eb.getCustomerAddTel());//购方地址电话
        		FpElement.addElement("Bz").setText( eb.getRemark());//备注
        		FpElement.addElement("Fhr").setText(eb.getChecker());//复核人
        		FpElement.addElement("Skr").setText(eb.getPayee());//收款人	
        		FpElement.addElement("Spbmbbh").setText("1.0");//商品编码表版本号 add@20160720升级增加
        		FpElement.addElement("Hsbz").setText(eb.isTaxRate()?"1":"0");//含税标识 add@20160531 升级订制 0为不含税率
        		
        		Element SpxxElement = FpElement.addElement("Spxx");
        		entryIDs="";//分录id
        		
        		for(ExportEntryBean ebb:eb.getExportEntryCols()) {
        			Element SphElement = SpxxElement.addElement("Sph");
        			SphElement.addElement("Xh").setText(String.valueOf(ebb.getSeq()));//序号
        			SphElement.addElement("Spmc").setText(ebb.getMaterialName());//商品名称
        			spbm=ebb.getTaxCode();
        			if(spbm.length()<19) {
        				int dd=19-spbm.length();
        				for(int i=0;i<dd;i++) {
        					spbm+="0";
        				}
        			}
        			SphElement.addElement("Spbm").setText(spbm);//商品编码 add@20160720升级增加
        			SphElement.addElement("Qyspbm").setText(ebb.getMaterialNum());//企业商品编码 add@20160723升级增加
        			SphElement.addElement("Syyhzcbz").setText( "0");//优惠政策标识 add@20160723升级增加 0不适用优惠政策
        			SphElement.addElement("Lslbz").setText("");//零售税标识 add@20160723升级增加
        			SphElement.addElement("Yhzcsm").setText( "");//优惠政策说明 add@20160723升级增加

        			SphElement.addElement("Ggxh").setText( ebb.getModel()==null?"":ebb.getModel());//规格型号
        			SphElement.addElement("Jldw").setText( ebb.getMeasureUnit()==null?"":ebb.getMeasureUnit());//计量单位
        			SphElement.addElement("Dj").setText( String.valueOf(ebb.getTaxPrice()));//单价 ebb.getPrice()
        			SphElement.addElement("Sl").setText( String.valueOf(ebb.getQty()));//数量
        			SphElement.addElement("Je").setText( String.valueOf(ebb.getAllAmount()));//金额 ebb.getAmount()
        			SphElement.addElement("Slv").setText( String.valueOf(ebb.getTaxRate()));//税率
        			SphElement.addElement("Kce").setText( "");//扣除额，用于差额税计算 add@20160531 升级订制
        			
        			if(StringUtils.isNotBlank(ebb.getSrcID())) {
	        			if(entryIDs.length()>0)
	        				entryIDs+=",";
	        			entryIDs+="'"+ebb.getSrcID()+"'";
        			}
                }
        		try {
        			XMLWriter writer = new XMLWriter(new FileWriter(filePathAndName),xmlFormat);
        			writer.write(document);
        			writer.close();
        		} catch (Exception e) {
        			throw new Exception(e);
        		}
        		//反写生成xml标志
        		reWriteTimeNo(eb.getNumber(),exportBillIDs, entryIDs, eb.getCustomerNum());
            }
            }
        }
    }
    
    /**
     * 后台开票结果读写类
     * @author Administrator
     *
     */
    private class threadClass implements Runnable  {
    	File filePath=new File(txtPath);
    	File[] files;
    	File filePathDedicated=new File(txtPathDedicated);
    	File[] filesDedicated;
		public void run() {
			while(true) {
				//普票
				files= filePath.listFiles();
		    	for(File file:files){
		    	    //非文件夹且txt结尾 
		    		if(!file.isDirectory()&&file.getName().endsWith(".txt")){
		    			try {
							reWriteTaxInfo(file);
						} catch (Exception e) {
							e.printStackTrace();
						} 
		    		}
		    	}
		    	//专票
		    	filesDedicated= filePathDedicated.listFiles();
		    	for(File file:filesDedicated){
		    	    //非文件夹且txt结尾 
		    		if(!file.isDirectory()&&file.getName().endsWith(".txt")){
		    			try {
							reWriteTaxInfo(file);
						} catch (Exception e) {
							e.printStackTrace();
						} 
		    		}
		    	}
//				System.out.println("后台");
		    	try {
					Thread.currentThread().sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

        /**
         * 反写导入信息
         * @throws IOException 
         * @throws NumberFormatException 
         */
        private void reWriteTaxInfo(File file) throws NumberFormatException, IOException
        {
                String fileNo = file.getName();//单据编码--文件名 
                int beginIndex = 0;

                int endIndex = fileNo.indexOf("_");//生成的xml的文件名
                if(endIndex<0) {
                	return;
                }
                fileNo = fileNo.substring(beginIndex, endIndex - beginIndex);

                String taxCode = "";//发票编码
                String taxNo = "";//发票号码

                int result = -1;//结果
                String msg = null;
                String taxDateStr;//结果反写日期
                String timerBillNo = null;
                
                BufferedReader reader = null; 
        	    String tempString = null;
        	    reader = new BufferedReader(new FileReader(file)); 
        	    while ((tempString = reader.readLine()) != null) {
                {
                    beginIndex = tempString.indexOf("[") + "[".length();
                    endIndex = tempString.indexOf("]");
                    taxDateStr = tempString.substring(beginIndex, endIndex);//文件日期名
                    taxCode=null;
                    taxNo=null;

                    if (timerBillNo == null)
                    {
                        beginIndex = tempString.indexOf("单据号:") + "单据号:".length();
                        endIndex = tempString.indexOf("开具结果:");
                        if (beginIndex > 0 && endIndex > 0)//
                        {
                            timerBillNo = tempString.substring(beginIndex, endIndex-1);
                        }
                    }
                    if (timerBillNo != null)
                    {
                        beginIndex = tempString.indexOf("开具结果:") + "开具结果:".length();
                        if (beginIndex >= 0)//
                        {
                            result = Integer.valueOf(tempString.substring(beginIndex, beginIndex+1));
                        }
                    }
                    if (result == 0)
                    {
                        beginIndex = tempString.indexOf("开具失败原因:");
                        // endIndex = line.indexOf(",");
                        if (beginIndex >= 0)// && endIndex > 0
                        {
                            msg = tempString.substring(beginIndex,tempString.length());
                            reWriteTaxMsg(fileNo, timerBillNo,taxCode,taxNo, result, taxDateStr, msg);//反写开票信息
                        }

                    }
                    else if (result == 1)
                    {
                        beginIndex = tempString.indexOf("对应发票信息:")+"对应发票信息:".length();
                        msg=tempString.substring(beginIndex, tempString.length());
                        if (beginIndex >= 0)// && endIndex > 0
                        {

                            //获取发票编码*****************
                            beginIndex = msg.indexOf(",");
                            endIndex = msg.indexOf(",",beginIndex+1);

                            //金税编码和名称
                            taxCode = msg.substring(beginIndex+1, msg.indexOf("(代码)"));
                            taxNo = msg.substring(endIndex+1, msg.indexOf("(号码)"));
                            //****************************
                            reWriteTaxMsg(fileNo, timerBillNo, taxCode, taxNo, result, taxDateStr, msg);//反写开票信息
                        }

                    }
            	}

                if (file.exists())
                {
                	reader.close();
                	//移动到新路径下
                	file.renameTo(new File(txtPathBackupTemp + "\\" + file.getName()));
                }
                break;
    	    }
        }
        /**
         * 反写开票信息
         * @param fileBillNo
         * @param timerFileNo
         * @param taxCodeString
         * @param taxNo
         * @param result
         * @param taxDateStr
         * @param msg
         */
        private void reWriteTaxMsg(String fileNo,String timerBillNo,String taxCode ,String taxNo,int result,String taxDateStr,String msg){
/*        	int index = timerBillNo.indexOf("|");
        	String companyNum=timerBillNo.substring(0,index);
        	String timerNo=timerBillNo.substring(index+1,timerBillNo.length());
*/        	StringBuffer sql=new StringBuffer();
        	sql.append(" update t_ar_Otherbill ")
        	.append(" set CFinvoiceNumber='").append(taxNo).append("'")
        	.append(" ,CFhasExport2Tax=1")
        	.append(" ,cfinvoiceInfo='").append(msg).append("'")
        	.append(" ,CFinvoiceDate={ts '").append(taxDateStr).append("'}")
        	.append(" where 1=1");
        	/*if(StringUtils.isNotBlank(companyNum)) {
        		sql.append(" and FCompanyID in (")
        		.append(" select fid from t_org_company where fid='").append(companyNum).append("'")
        		.append(" )");
        	}*/
        	sql.append(" and CFtimeNo='").append(timerBillNo).append("'")
        	.append(" ");
        	try {
				ERP2TaxFacadeFactory.getRemoteInstance().execute(sql.toString());
			} catch (BOSException e) {
				e.printStackTrace();
			}
        }
	}
    
    
    /**
	 * 执行导入到金税接口
	 * @param billIDs
     * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void exeExportToTaxSplit(String companyNum,String exportBillID,boolean isQtyInit,BigDecimal arAllAmount,ArrayList<BigDecimal> amountList) throws Exception {
		try {
//			BigDecimal disAllAmount=BigDecimal.ZERO;
//			StringBuffer sql=new StringBuffer();
//			sql.append(" select isnull(sum(FDiscountAmount),0) FDiscountAmount")
//			.append(" from t_ar_otherBillEntry where fparentid in (").append(exportBillID).append(")")
//			.append(" ");
//			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
//			if(rs.next()) {
//				disAllAmount=rs.getBigDecimal("FDiscountAmount");
//			}
			StringBuffer sql=new StringBuffer();
			sql.setLength(0);
			sql.append(" select tbill.FID,tbill.FNumber,tcus.FName_l2 FCustomerName,tcus.fnumber FCustomerNum,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tentry.FID FEntryID,tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,")
			//CFSettleQty
			.append(" tentry.FQuantity FQty,tentry.FPrice,tentry.CFOrderBillPrice FTaxPrice,tentry.FAmount,isnull(tentry.FRecievePayAmount,0) FRecievePayAmount,tentry.FTaxRate/100 FTaxRate,")
			.append(" isnull(tentry.FDiscountAmount,0) FDiscountAmount,isnull(tentry.FTaxAmount,0) FTaxAmount,tentry.FSeq,tmc.cftaxCode cftaxCode")//折扣额 tmc.cftaxCode
			.append(" from t_ar_otherbill tbill")
			.append(" inner join t_ar_otherBillEntry tentry on tentry.fparentid=tbill.fid ")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FAsstActID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tbill.FCompanyID")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FMeasureUnitID")
			.append(" where tbill.fid in (").append(exportBillID).append(")")
			.append(" order by tbill.fnumber, tentry.fseq ")
			.append(" ")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			String billID,billIDKeep=null;
			HashMap<String,ExportBean> exportBeanMap=new HashMap<String,ExportBean>();
			ExportBean eb=null;
			String userName=SysContext.getSysContext().getCurrentUserInfo().getName();
			BigDecimal discountAmount,orgDiscountAmount;//折扣额，返利金额
			BigDecimal arAmount,orgArAmount,sumAmount=BigDecimal.ZERO;//总价税合计
			BigDecimal tempAmount,tempProp,tempSumDisAmount,tempSumArAmount;
			BigDecimal qty,orgQty,tempSumQty;
			BigDecimal price,taxPrice,taxRate;
			BigDecimal amount,taxAmount,tempSumAmount,tempSumTaxAmount;	
			BigDecimal orgAmount,orgTaxAmount;
			
			int nowRowCount=0;//当前发票行数
			String timeStr,orgTimeStr="";
			while(rs.next()) {
				if(StringUtils.isBlank(rs.getString("cftaxCode"))) {
					 throw new Exception("物料"+rs.getString("FMaterialName")+"，尚未维护税收分类代码");
				}
				 billID=rs.getString("fid");
				 if(billIDKeep==null) {
					 billIDKeep=billID;
					 eb=createNewExportBean(companyNum,rs.getString("FCustomerNum"), rs.getString("FCustomerName"), rs.getString("FTxRegisterNo")
							 ,rs.getString("FAddress"),null,rs.getBigDecimal("FTaxAmount").signum()>0?true:false, userName);
	                 exportBeanMap.put(eb.getTimeStr(), eb);
					 orgTimeStr=eb.getTimeStr();
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");//返利
				 arAmount=rs.getBigDecimal("FRecievePayAmount");//应收金额
				 amount=rs.getBigDecimal("FAmount");//金额
				 taxAmount=rs.getBigDecimal("FTaxAmount");//税额
				 qty=rs.getBigDecimal("FQty");
				 
				 orgQty=qty;
				 orgDiscountAmount=discountAmount;
				 orgArAmount=arAmount;
				 orgAmount=amount;
				 orgTaxAmount=taxAmount;
				 
				 tempSumDisAmount=BigDecimal.ZERO;
				 tempSumArAmount=BigDecimal.ZERO;
				 tempSumQty=BigDecimal.ZERO;
				 tempSumAmount=BigDecimal.ZERO;
				 tempSumTaxAmount=BigDecimal.ZERO;
				 
				 //拆分
				 for(int i=0;i<amountList.size();i++) {
					 tempAmount=amountList.get(i);//拆分金额
					 
					 if(i>0) {//非第一行、原始行
						 timeStr=orgTimeStr+"."+i;
						 if(!exportBeanMap.containsKey(timeStr)) {
							 eb=createNewExportBean(companyNum,rs.getString("FCustomerNum"), rs.getString("FCustomerName"), rs.getString("FTxRegisterNo")
									 ,rs.getString("FAddress"),null,taxAmount.signum()>0?true:false, userName);
							 
							 exportBeanMap.put(timeStr, eb);
						 }else {
							 eb=exportBeanMap.get(timeStr);
						 }
					 }
					 //最后一行
					 if(i==amountList.size()-1) {
						 arAmount= orgArAmount.subtract(tempSumArAmount);
						 discountAmount=orgDiscountAmount.subtract(tempSumDisAmount);
						 taxAmount=orgTaxAmount.subtract(tempSumTaxAmount);
						 qty=orgQty.subtract(tempSumQty);
					 }else {
						 //拆分比例
						 tempProp=tempAmount.divide(arAllAmount,10,BigDecimal.ROUND_HALF_UP);
						 
						 discountAmount= orgDiscountAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 arAmount= orgArAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 taxAmount= orgTaxAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 
						 qty=qty.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 //数量取整
						 if(isQtyInit) {
							 qty=qty.setScale(0, BigDecimal.ROUND_HALF_UP);
						 }
						 
						 tempSumArAmount=tempSumArAmount.add(arAmount);
						 tempSumDisAmount=tempSumDisAmount.add(discountAmount);
						 tempSumQty=tempSumQty.add(qty);
						 tempSumTaxAmount=tempSumTaxAmount.add(taxAmount);
					 }
				 
					 amount=arAmount.subtract(taxAmount);
					 taxRate=taxAmount.divide(amount,2,BigDecimal.ROUND_HALF_UP);
					 
					 taxPrice=arAmount.divide(qty,10, BigDecimal.ROUND_HALF_UP);
					 price=amount.divide(qty,10, BigDecimal.ROUND_HALF_UP);
					 
					 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
					 if(sumAmount.add(arAmount).compareTo(maxAmount)>0||(nowRowCount+1)>maxRowCount
							 ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+2)>maxRowCount)) {
						 throw new Exception("单据"+rs.getString("fnumber")+"超出开票最大规格");
					 }
					 
					 sumAmount=sumAmount.add(arAmount);
					 nowRowCount++;
					 
					 //发票分录
					 ExportEntryBean eeb = new ExportEntryBean();
					 eeb.setSeq(nowRowCount);
					 eeb.setMaterialNum (rs.getString("FMaterialNum"));
	                 eeb.setMaterialName(rs.getString("FMaterialName"));
	                 eeb.setTaxCode(rs.getString("cftaxCode"));
	                 eeb.setModel(rs.getString("FModel"));
	                 eeb.setMeasureUnit(rs.getString("FUnitName"));
	                 eeb.setTaxPrice(taxPrice);
	                 eeb.setQty(qty);
	                 eeb.setAllAmount(arAmount);
	                 eeb.setAmount(amount);
	                 eeb.setPrice(price);//不含税单价
	                 eeb.setTaxRate(taxRate);
	
	                 eeb.setSrcID(rs.getString("FEntryID"));
	                 
	                 eb.getExportEntryCols().add(eeb);
	                 
	                 //增加返利分录
	                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
	                	 //发票分录
	    				 ExportEntryBean eebDis = new ExportEntryBean();
	    				 eebDis.setSeq(nowRowCount);
	    				 eebDis.setMaterialNum (rs.getString("FMaterialNum"));
	    				 eebDis.setMaterialName(rs.getString("FMaterialName"));
	    				 eebDis.setModel(rs.getString("FModel"));
	    				 eebDis.setMeasureUnit("");
	    				 eebDis.setTaxPrice(BigDecimal.ZERO);
	    				 eebDis.setQty(BigDecimal.ZERO);
	    				 eebDis.setAllAmount(new BigDecimal(-1).multiply(discountAmount));
	    				 eebDis.setAmount(eebDis.getAllAmount());
	    				 eebDis.setPrice(BigDecimal.ZERO);//不含税单价
	    				 eebDis.setTaxRate(BigDecimal.ZERO);
	    				 eebDis.setSrcID(rs.getString("FEntryID"));
	    				 
	                     eb.getExportEntryCols().add(eebDis);
	                 }
				 }
			}
			//生成XML
			if(exportBeanMap.size()>0) {
				exeCreateXML(exportBillID,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
	}
	
}
