package com.kingdee.eas.custom.erp2tax.functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.swing.KDMenu;
import com.kingdee.bos.ctrl.swing.KDMenuItem;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.erp2tax.BaseSettingFactory;
import com.kingdee.eas.custom.erp2tax.BaseSettingInfo;
import com.kingdee.eas.custom.erp2tax.ERP2TaxFacadeFactory;
import com.kingdee.eas.custom.erp2tax.Erp2TaxTypeEnum;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillEditUI;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillListUI;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * erp 系统单据生成金税软件xml文件功能类
 * @author dai_andong
 *
 */
public class SaleIssureEditUIDepErp2Tax {
	private SaleIssueBillListUI listui;
	private SaleIssueBillEditUI editui;
	private String companyID;
	private BaseSettingInfo bdsInfo=null;//接口基础设置
	
	/**
	 * 初始化 listui
	 */
	public void initListUI(final UIParam param) {
		listui=(SaleIssueBillListUI) param.getUI();
		companyID=((SysContext) param.getUIContext().get("sysContext")).getCurrentFIUnit().getString("id");
		try {
			checkDeafultSetting(companyID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		KDMenu elecMenu=new KDMenu("电子发票接口");
		param.getKDMenu("menuBiz").add(elecMenu);
		
		KDMenuItem mBtnExport2Tax=new KDMenuItem("导出到电子发票");
		elecMenu.add(mBtnExport2Tax);
		//导入到金税接口
		mBtnExport2Tax.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(bdsInfo==null) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					exeExportToTax(companyID,billIDs,Erp2TaxTypeEnum.NORMAL_VALUE,false);
				}});
		
		KDMenuItem mBtnExport2TaxSum=new KDMenuItem("合并导出到电子发票");
		elecMenu.add(mBtnExport2TaxSum);
		//合并导入到金税
		mBtnExport2TaxSum.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(bdsInfo==null) {
					MsgBox.showWarning("没有进行金税导入配置！");
					return;
				}
				listui.checkSelected();
				Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
				if(billIDs.length<2) {
					MsgBox.showWarning("请选择多条发票操作！");
					return;
				}
				exeExportToTax(companyID,billIDs,Erp2TaxTypeEnum.SUM_VALUE,false);
			}});
		
		KDMenuItem mBtnExport2TaxSplit=new KDMenuItem("拆分导出到电子发票");
		elecMenu.add(mBtnExport2TaxSplit);
		//拆分导入到金税
		mBtnExport2TaxSplit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(bdsInfo==null) {
					MsgBox.showWarning("没有进行金税导入配置！");
					return;
				}
				listui.checkSelected();
				Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
				if(billIDs.length>1) {
					MsgBox.showWarning("请选择一行记录操作！");
					return;
				}
				exeExportToTax(companyID,billIDs,Erp2TaxTypeEnum.SPLIT_VALUE,false);
			}});
		
		KDMenuItem mBtnSynTax=new KDMenuItem("同步电子发票信息");
		elecMenu.add(mBtnSynTax);
		//同步发票信息 mBtnSynTax
		mBtnSynTax.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(bdsInfo==null) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					JSONObject jo=new JSONObject();
					jo.put("companyID", companyID);
					jo.put("billIDs", billIDs);
					try {
						String msg=ERP2TaxFacadeFactory.getRemoteInstance().exeSynResult(jo.toString());
						MsgBox.showInfo("查询完成！\n"+msg);
					} catch (Exception e1) {
						MsgBox.showWarning(e1.toString());
					} 
				}});
		
		KDMenuItem mBtnExprot2TaxBack=new KDMenuItem("红冲电子发票");
		elecMenu.add(mBtnExprot2TaxBack);
		//红冲发票信息 mBtnSynTax
		mBtnExprot2TaxBack.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(bdsInfo==null) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					listui.checkSelected();
					Object[] billIDs=listui.getSelectedFieldValues("id").toArray();
					JSONObject jo=new JSONObject();
					jo.put("companyID", companyID);
					jo.put("billIDs", billIDs);
					try {
						String msg=ERP2TaxFacadeFactory.getRemoteInstance().ExportWriteBack2Tax(jo.toString());
						MsgBox.showInfo("红冲完成！\n"+msg);
					} catch (Exception e1) {
						MsgBox.showWarning(e1.toString());
					} 
				}});
	}
	
	/**
	 * 设置默认参数
	 * @throws BOSException 
	 */
	private void checkDeafultSetting(String companyID) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from ").append(" T_ERP_BaseSetting ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" order by FCreateTime desc");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				bdsInfo=BaseSettingFactory.getRemoteInstance().getBaseSettingInfo("where id='"+rs.getString("fid")+"'");
			}
			rs.close();
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * 初始化 editui
	 */
	public void initEditUI(final UIParam param) {
		editui=(SaleIssueBillEditUI) param.getUI();
		companyID=((SysContext) param.getUIContext().get("sysContext")).getCurrentFIUnit().getString("id");
		
		try {
			checkDeafultSetting(companyID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//导入到金税接口
		if(param.getKDMenuItem("btnExport2Tax")!=null) {
			param.getKDWorkButton("btnExport2Tax").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(bdsInfo==null) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Erp2TaxTypeEnum.NORMAL_VALUE,false);
				}});
		}
		//拆分导入到金税
		if(param.getKDMenuItem("mBtnExport2TaxSplit")!=null) {
			param.getKDMenuItem("mBtnExport2TaxSplit").addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(bdsInfo==null) {
						MsgBox.showWarning("没有进行金税导入配置！");
						return;
					}
					if(param.getDataObject().get("id")==null) {
						MsgBox.showWarning("请先保存单据！");
						return ;
					}
					String[] billIDs=new String[]{(String) param.getDataObject().get("id")};
					exeExportToTax(companyID,billIDs,Erp2TaxTypeEnum.SPLIT_VALUE,false);
				}});
		}
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
		
		String hasExportBillNums="";
		ArrayList<String> hasExportBillIDs=new ArrayList<String>();
		
		String[] reusltStrs;
		for(int i=0;i<billIDs.length;i++) {
			reusltStrs=checkHasTax(billIDs[i].toString());
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
		if(hasExportBillIDs.size()>0){
			MsgBox.showInfo("单据"+hasExportBillNums+"单据已经导入电子发票,不会重新导入！");
			isRedo=false;
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
				//组织编码
				String msg="success";
				JSONObject jo=new JSONObject();
				jo.put("companyID", companyID);
				jo.put("opType", opType);
				jo.put("billIDs", billIDs);
				//拆分
				if(opType==Erp2TaxTypeEnum.SPLIT_VALUE) {
					Object[] splitParams = exeExportWithSplit(companyID, billIDs[0].toString());
					if(splitParams==null||splitParams[2]==null) {
						return;
					}
					jo.put("splitParams", splitParams);
				}
				msg=ERP2TaxFacadeFactory.getRemoteInstance().exeExport2Tax(jo.toString());
				MsgBox.showInfo("导出金税接口完成\n"+msg);
			}
		} catch (Exception e) {
			MsgBox.showError(e.getMessage());
		}
	}
	/**
	 * 是否已经导出金税
	 * @param billID
	 * @return
	 */
	private static String[] checkHasTax(String billID) {
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance("select fnumber,FcustomerID,CFSerialNo CFSerialNo from T_IM_SaleIssueBill where  fid='"+billID+"'").executeSQL();
			if(rs.next()) {
				String[] result=new String[3];
				result[0]=rs.getString("CFSerialNo");
				result[1]=rs.getString("fnumber");
				result[2]=rs.getString("FcustomerID");
				return result;
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 执行拆分导入
	 * @param companyNum
	 * @param exportBillIDs
	 * @throws UIException
	 */
	private Object[] exeExportWithSplit(String companyID,String exportBillID) throws Exception {
		UIContext uiContext = new UIContext(this);
		uiContext.put("companyID", companyID);// 
		uiContext.put("bizType", "elec");// 
		uiContext.put("exportBillIDs", exportBillID);// 
		SaleIssueBillInfo info =SaleIssueBillFactory.getRemoteInstance().getSaleIssueBillInfo(new ObjectUuidPK(exportBillID));
		uiContext.put("allAmount",info.getTotalAmount());// 
		uiContext.put("maxAmount",bdsInfo.getMaxAmount());// 
		IUIWindow uiWindow = null;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.erp2tax.client.ERP2TaxSplitUI", uiContext, null, OprtState.VIEW);
		uiWindow.show();
		//非取消
		if(!(Boolean)uiWindow.getUIObject().getUIContext().get("isCancel")) {
			Object[] splitParams=new Object[3];
			splitParams[2]=(ArrayList<BigDecimal>) uiWindow.getUIObject().getUIContext().get("amountList");
			splitParams[1]=(Boolean) uiWindow.getUIObject().getUIContext().get("isSplitInit");
			splitParams[0]=info.getTotalAmount();
			return splitParams;
		}
		return null;
	}
}
