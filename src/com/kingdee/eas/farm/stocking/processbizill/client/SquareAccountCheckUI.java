/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.measure.quantity.Length;

import org.apache.log4j.Logger;

import com.itrus.util.DateUtils;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.PeriodCollection;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBill;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.BEggHatchBillCollection;
import com.kingdee.eas.farm.hatch.BEggHatchBillFactory;
import com.kingdee.eas.farm.hatch.BEggHatchBillInfo;
import com.kingdee.eas.farm.hatch.BEggTrayingBillInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillFactory;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.farm.hatch.IBEggCandlingBill;
import com.kingdee.eas.farm.hatch.IBEggHatchBill;
import com.kingdee.eas.farm.hatch.IBEggTrayingBill;
import com.kingdee.eas.farm.hatch.IBHatchBabyBill;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericException;

/**
 * 强英结账校验平台
 * output class name
 */
public class SquareAccountCheckUI extends AbstractSquareAccountCheckUI
{
	private static final Logger logger = CoreUIObject.getLogger(SquareAccountCheckUI.class);
	private HashMap<String,Object> checkResult=new HashMap<String, Object>();
	CompanyOrgUnitInfo companyInfo = null;
	PeriodInfo periodInfo = null;
	IRowSet rs=null;
	/**
	 * output class constructor
	 */
	public SquareAccountCheckUI() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		checkPermission();

		//默认加载当前财务组织为安徽强英鸭业
		CompanyOrgUnitCollection coll=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitCollection(" where number=21");
		if(coll.size()>0){
			prmtCompany.setValue(coll.get(0));
		}
		//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//		PeriodCollection collPeriod = PeriodFactory.getRemoteInstance().getPeriodCollection("where beginDate<=('"+sdf.format(new Date())+" 00:00:00') and endDate>=('"+sdf.format(new Date())+" 00:00:00')");

		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMM");
		PeriodCollection collPeriod = PeriodFactory.getRemoteInstance().getPeriodCollection("where number='"+sdf1.format(new Date())+"'");

		if(collPeriod.size()>0)
			prmtPeriod.setValue(DateUtilsComm.getUpperPeriodInfo(collPeriod.get(0)));
		//一键校验
		btnCheckAll.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				super.mouseClicked(e);
			}
		});

		//饲料领用单
		btnFeed.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkHatchBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						billNumList.add(rs.getString("fnumber"));
						errorNum++;
					}
					checkResult.put("feedCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("饲料领用单生成领料出库单校验");

					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张饲料领用单没有生成领料出库单或领料单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("饲料领用单");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("饲料领用单");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		}); 

		//药品处方单
		btnDrug.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkDrugBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("drugCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("药品处方单生成领料出库单校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张药品处方单没有生成领料出库单或领料单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("药品处方单");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("药品处方单");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});
		//种苗领用单
		btnGermchit.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkGermchitBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("germchitCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("种苗领用单生成领料出库单校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张种苗领用单没有生成领料出库单或领料单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种苗领用单");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种苗领用单");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});
		//种蛋接收单

		btnGermchitReceive.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkGermchitReceiveBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("germchitReceiveCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("种蛋接收单生成种蛋结算单校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张种蛋接收单没有生成种蛋结算单或结算单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种蛋接收单");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种蛋接收单");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});
		//种蛋接收单审核

		btnHatcheggBalance.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkHatcheggBalanceBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("hatcheggBalanceCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("种蛋接收单审核校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张种蛋接收单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种蛋接收单审核");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("种蛋接收单审核");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});

		//固定资产折旧审核
		btnAsset.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkAssetBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("assetCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("固定资产折旧审核校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张固定资产没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("固定资产折旧审核");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("固定资产折旧审核");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});
		//费用分摊单是否生成，是否审核
		btnCost.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkCostBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<Integer> billNumList=new ArrayList<Integer>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getInt("FBillStatus"));
					}
					checkResult.put("costCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("费用分摊单是否生成");
					if(errorNum<4){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+(4-errorNum)+"张费用分摊单没有生成或审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("费用分摊单");
					}else{
						int num=0;
						for(int i = 0 ; i < billNumList.size() ; i++) {
							if(billNumList.get(i)!=4){
								num=num+1;
							}
						}
						if(num==0){
							kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
							kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("费用分摊单");
						}else{
							kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+num+"张费用分摊单没有生成或审核");
							kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("费用分摊单");
						}

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});

		//辅料领用单审核
		btnAccessory.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkAccessoryBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("fnumber"));
					}
					checkResult.put("accessoryCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("辅料领用单生成领料出库单校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("共有"+errorNum+"张辅料领用单没有生成领料出库单或领料单没有审核");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("辅料领用单");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("全部合格");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("辅料领用单");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});

		//奖惩政策
		btnReward.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkRewardsBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("Fname_l2"));
					}
					checkResult.put("rewardCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("奖惩政策校验");
					if(errorNum>0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("存在奖惩政策");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("奖惩政策");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("没有奖惩政策");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("奖惩政策");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});
		//副产品价格维护
		btnByproduct.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				checkBeforeCheck();
				kdtCheckResult.removeRows();
				kdtDetails.removeRows();
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				rs=JiezhangjiaoyanComm.checkByproductBill(companyInfo,periodInfo);
				int errorNum=0;
				checkResult.clear();
				ArrayList<String> billNumList=new ArrayList<String>();
				try {
					while(rs.next()){
						errorNum++;
						billNumList.add(rs.getString("FID"));
					}
					checkResult.put("rewardCreateMaterialReq", billNumList);
					kdtCheckResult.addRow();
					kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkType").setValue("副产品价格维护");
					if(errorNum==0){
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("副产品价格未维护");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("副产品价格维护");
					}else{
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "checkResult").setValue("副产品价格已维护");
						kdtCheckResult.getCell(kdtCheckResult.getRowCount()-1, "type").setValue("副产品价格维护");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				super.mouseClicked(e);
			}
		});

		kdtCheckResult.addKDTMouseListener(new KDTMouseListener(){

			@Override
			public void tableClicked(KDTMouseEvent e) {
				kdtDetails.removeRows();
				// TODO Auto-generated method stub
				//判断fid是否为空，fid空显示未生成。审核状态不为4显示未审核。
				IRow row;
				ICell cell;
				companyInfo = (CompanyOrgUnitInfo) prmtCompany.getValue();
				periodInfo = (PeriodInfo) prmtPeriod.getValue();
				IRow selectedRow = KDTableUtil.getSelectedRow(kdtCheckResult);
				//获取行
				kdtCheckResult.getRow(0);
				//获取表头
				kdtCheckResult.getHeadRow(0);
				//获取列
				kdtCheckResult.getColumn("");
				//获取单元格
				kdtCheckResult.getRow(0).getCell("");
				//获取单元格
				String type =(String) kdtCheckResult.getCell(selectedRow.getRowIndex(), "type").getValue();
				if(type.equals("饲料领用单")){
					rs=JiezhangjiaoyanComm.checkHatchBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							if(rs.getString("fid")==null){
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("未生成领料出库单");
							}else{
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("领料出库单未审核");
							}
							//billNumList.add(rs.getString("fnumber"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(type.equals("药品处方单")){
					rs=JiezhangjiaoyanComm.checkDrugBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							if(rs.getString("fid")==null){
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("未生成领料出库单");
							}else{
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("领料出库单未审核");
							}
							//billNumList.add(rs.getString("fnumber"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(type.equals("种苗领用单")){
					rs=JiezhangjiaoyanComm.checkGermchitBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							if(rs.getString("fid")==null){
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("未生成领料出库单");
							}else{
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("领料出库单未审核");
							}
							//billNumList.add(rs.getString("fnumber"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(type.equals("种蛋接收单")){
					rs=JiezhangjiaoyanComm.checkGermchitReceiveBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							if(rs.getString("fid")==null){
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("未生成种蛋结算单");
							}else{
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("种蛋结算单未审核");
							}
							//billNumList.add(rs.getString("fnumber"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}							
				}else if(type.equals("种蛋接收单审核")){
					rs=JiezhangjiaoyanComm.checkHatcheggBalanceBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							row=kdtDetails.addRow();
							cell=row.getCell(0);
							cell.setValue("溜溜球");
							cell=row.getCell(1);
							cell.setValue(rs.getString("fnumber"));
							cell=row.getCell(2);
							cell.setValue("种蛋接收单未审核");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}							
				}else if(type.equals("固定资产折旧审核")){
					rs=JiezhangjiaoyanComm.checkAssetBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							row=kdtDetails.addRow();
							cell=row.getCell(0);
							cell.setValue("溜溜球");
							cell=row.getCell(1);
							cell.setValue(rs.getString("fnumber"));
							cell=row.getCell(2);
							cell.setValue("固定资产折旧未审核");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}else if(type.equals("辅料领用单")){
					rs=JiezhangjiaoyanComm.checkAccessoryBill(companyInfo,periodInfo);
					try {
						while(rs.next()){
							if(rs.getString("fid")==null){
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("未生成领料出库单");
							}else{
								row=kdtDetails.addRow();
								cell=row.getCell(0);
								cell.setValue(1);
								cell=row.getCell(1);
								cell.setValue(rs.getString("fnumber"));
								cell=row.getCell(2);
								cell.setValue("领料出库单未审核");
							}
							//billNumList.add(rs.getString("fnumber"));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(type.equals("费用分摊表")){
					rs=JiezhangjiaoyanComm.checkCostBill(companyInfo,periodInfo);
					if(rs.size()==4){
						for(int i = 0 ; i < rs.size(); i++) {
							try {
								if(rs.getInt("FBillStatus")!=4){
									row=kdtDetails.addRow();
									cell=row.getCell(0);
									cell.setValue(1);
									cell=row.getCell(1);
									cell.setValue(rs.getString("FNumber"));
									cell=row.getCell(2);
									cell.setValue("费用分摊单未审核");
								}else{
									row=kdtDetails.addRow();
									cell=row.getCell(0);
									cell.setValue(1);
									cell=row.getCell(1);
									cell.setValue(rs.getString("FNumber"));
									cell=row.getCell(2);
									cell.setValue("费用分摊单已审核");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}else{
						row=kdtDetails.addRow();
						row.getCell("selected").setValue(false);
						/*cell=row.getCell(0);
									cell.setValue(1);*/
						cell=row.getCell(1);
						cell.setValue("费用分摊表");
						cell=row.getCell(2);
						cell.setValue("费用分摊表未全部生成");
					}
					//billNumList.add(rs.getString("fnumber"));

				}
			}
		});

		functionInitData();
		functionAddListener();

		btnUpdateBatch.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				try {
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FA_FaCurCard  set CFSTOCKINGBATCHID=CFBREEDBATCHID where CFSTOCKINGBATCHID is null and CFBREEDBATCHID is not null");
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});


		btnUpdateFarmer.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				try {
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FA_FaCurCard t1 set t1.CFFARMERID=(select t2.FFarmerID from T_FM_StockingBatch t2 where t2.FID=t1.CFSTOCKINGBATCHID) where  t1.FFarmerID is null");
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});


		btnUpdateFarm.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent paramMouseEvent) {
				// TODO Auto-generated method stub
				super.mouseClicked(paramMouseEvent);
				try {
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FA_FaCurCard t1 set t1.CFFARMID=(select t2.FFarmID from T_FM_StockingBatch t2 where t2.FID=t1.CFSTOCKINGBATCHID) where  t1.CFFARMID is null");
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		intUI();
	}

	/**
	 * 校验权限
	 */
	private void checkPermission() {
		// TODO Auto-generated method stub
		CompanyOrgUnitInfo FIUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		String str = "select * from CT_FM_SquareChechPermission t1 inner join CT_FM_SquareCPEU t2 on t1.FID=t2.FParentID where t1.CFCompanyID='"+FIUnitInfo.getString("id")+"' and t2.CFUserID='"+userInfo.getString("id")+"'";
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rowSet.size()==0)
				commUtils.giveUserTipsAndRetire("没有权限，请联系管理员获取权限");
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void intUI() {
		// TODO Auto-generated method stub
		kdtCheckResult.getStyleAttributes().setLocked(true);
		kdtDetails.getStyleAttributes().setLocked(true);
		prmtHatchArea.setEnabledMultiSelection(true);
		pkBeginDate.setValue(DateUtilsComm.getFirstDayOfMonth(new Date()));
		kdtFunction.getStyleAttributes().setLocked(true);
		kdtFunction.getColumn("Selected").getStyleAttributes().setLocked(false);
		kdtFunction.getColumn("BillNumber").setWidth(150);


		cboxFunction.addItems(new String[]{"反审核","审核","批次校验"});
	}

	/**
	 * 功能页签初始化数据
	 */
	private void functionInitData() {
		// TODO Auto-generated method stub
		cboxItem.addItems(new String[]{"种蛋上孵单","照蛋记录单","落盘记录单","出雏单"});
		cboxSelectModel.addItems(new String[]{"","全选","全不选"});
	}

	/**
	 * 功能页签添加事件
	 */
	private void functionAddListener() {
		// TODO Auto-generated method stub
		btnSearch.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				try {
					checkBeforeFunction();
					IBEggHatchBill iEggHatchBill = null;
					iEggHatchBill = BEggHatchBillFactory.getRemoteInstance();
					IBEggCandlingBill iBEggCandlingBill = BEggCandlingBillFactory.getRemoteInstance();
					IBEggTrayingBill iBEggTrayingBill = BEggTrayingBillFactory.getRemoteInstance();
					IBHatchBabyBill iHatchBabyBill = BHatchBabyBillFactory.getRemoteInstance();

					BEggHatchBillInfo info;
					BEggCandlingBillInfo candInfo;
					BEggTrayingBillInfo trayingInfo;
					BHatchBabyBillInfo hatchBabyInfo;

					kdtFunction.removeRows();

					String str="";
					//功能：种蛋上孵单
					if(cboxItem.getSelectedItem().equals("种蛋上孵单")&&UIRuleUtil.isNull(cboxContent.getSelectedItem())){
						str=getFilterBillInformation("CT_FM_BEggHatchBill");
						rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
						while(rs.next()){
							kdtFunction.addRow();
							SelectorItemCollection slor=new SelectorItemCollection();
							slor.add("*");
							slor.add("HatchFactory.*");
							info=iEggHatchBill.getBEggHatchBillInfo(new ObjectUuidPK(rs.getString("id")),slor);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"Selected").setValue(false);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"BillNumber").setValue(info.getString("number"));
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"hatchArea").setValue(info.getHatchFactory());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"checkContent").setValue(info.getBaseStatus());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"bizDate").setValue(info.getBizDate());
						}

					}else if(cboxItem.getSelectedItem().equals("照蛋记录单")&&UIRuleUtil.isNull(cboxContent.getSelectedItem())){
						str=getFilterBillInformation("CT_FM_BEggCandlingBill");
						rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
						while(rs.next()){
							kdtFunction.addRow();
							SelectorItemCollection slor=new SelectorItemCollection();
							slor.add("*");
							slor.add("HatchFactory.*");
							candInfo=iBEggCandlingBill.getBEggCandlingBillInfo(new ObjectUuidPK(rs.getString("id")),slor);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"Selected").setValue(false);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"BillNumber").setValue(candInfo.getString("number"));
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"hatchArea").setValue(candInfo.getHatchFactory());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"checkContent").setValue(candInfo.getBaseStatus());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"bizDate").setValue(candInfo.getBizDate());
						}

					}else if (cboxItem.getSelectedItem().equals("落盘记录单")&&UIRuleUtil.isNull(cboxContent.getSelectedItem())){
						str=getFilterBillInformation("CT_FM_BEggTrayingBill");
						rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
						while(rs.next()){
							kdtFunction.addRow();
							SelectorItemCollection slor=new SelectorItemCollection();
							slor.add("*");
							slor.add("HatchFactory.*");
							trayingInfo = iBEggTrayingBill.getBEggTrayingBillInfo(new ObjectUuidPK(rs.getString("id")),slor);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"Selected").setValue(false);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"BillNumber").setValue(trayingInfo.getString("number"));
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"hatchArea").setValue(trayingInfo.getHatchFactory());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"checkContent").setValue(trayingInfo.getBaseStatus());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"bizDate").setValue(trayingInfo.getBizDate());
						}
					}
					else if (cboxItem.getSelectedItem().equals("出雏单")&&UIRuleUtil.isNull(cboxContent.getSelectedItem())){
						str=getFilterBillInformation("CT_FM_BHatchBabyBill");
						rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
						while(rs.next()){
							kdtFunction.addRow();
							SelectorItemCollection slor=new SelectorItemCollection();
							slor.add("*");
							slor.add("HatchFactory.*");
							hatchBabyInfo = iHatchBabyBill.getBHatchBabyBillInfo(new ObjectUuidPK(rs.getString("id")),slor);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"Selected").setValue(false);
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"BillNumber").setValue(hatchBabyInfo.getString("number"));
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"hatchArea").setValue(hatchBabyInfo.getHatchFactory());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"checkContent").setValue(hatchBabyInfo.getBaseStatus());
							kdtFunction.getCell(kdtFunction.getRowCount()-1,"bizDate").setValue(hatchBabyInfo.getBizDate());
						}
					}
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		btnBegin.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				try {
					//审核
					if(cboxItem.getSelectedItem().equals("种蛋上孵单")){
						if(cboxFunction.getSelectedItem().equals("审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggHatchBill set CFBaseStatus=4 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进上孵蛋列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
							//反审核
						}else if(cboxFunction.getSelectedItem().equals("反审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggHatchBill set CFBaseStatus=1 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进上孵蛋列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
						}
					}


					//照单记录单
					else if(cboxItem.getSelectedItem().equals("照蛋记录单")){
						if(cboxFunction.getSelectedItem().equals("审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggCandlingBill set CFBaseStatus=4 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进照蛋记录单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
							//反审核
						}else if(cboxFunction.getSelectedItem().equals("反审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggCandlingBill set CFBaseStatus=1 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进照蛋记录单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
						}
					}

					//落盘记录单
					else if(cboxItem.getSelectedItem().equals("落盘记录单")){
						if(cboxFunction.getSelectedItem().equals("审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggTrayingBill set CFBaseStatus=4 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进落盘记录单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
							//反审核
						}else if(cboxFunction.getSelectedItem().equals("反审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BEggTrayingBill set CFBaseStatus=1 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进落盘记录单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
						}
					}
					//出雏单
					else if(cboxItem.getSelectedItem().equals("出雏单")){
						if(cboxFunction.getSelectedItem().equals("审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BHatchBabyBill set CFBaseStatus=4 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进出雏单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
							//反审核
						}else if(cboxFunction.getSelectedItem().equals("反审核")){
							for(int i=0;i<kdtFunction.getRowCount();i++){
								if(!kdtFunction.getCell(i, "checkContent").getValue().equals("审核")&&kdtFunction.getCell(i, "Selected").getValue().equals(true))
									CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_BHatchBabyBill set CFBaseStatus=1 where FNumber='"+kdtFunction.getCell(i, "BillNumber").getValue()+"'");
							}
							MsgBox.showInfo("执行完成，请进出雏单列表界面刷新(或者在本界面点查找)以查看结果。如不生效，请联系开发人员，联系方式：shootingstarxx@126.com。请注明'强英Bug'");
						}
					}
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}});
	}

	/**
	 * 检验前检验
	 */
	private void checkBeforeCheck() {
		// TODO Auto-generated method stub
		if(prmtCompany.getValue()==null)
			commUtils.giveUserTipsAndRetire("请填写公司");
		if(prmtPeriod.getValue()==null)
			commUtils.giveUserTipsAndRetire("请填写期间");

	}
	/**
	 * 功能 查找之前的校验
	 */
	private void checkBeforeFunction() {
		// TODO Auto-generated method stub
//		if(UIRuleUtil.isNull(pkBeginDate.getValue())||UIRuleUtil.isNull(pkEndDate.getValue())){
//			MsgBox.showInfo("开始日期和结束日期不能为空");
//		}
	}

	/**
	 * 种蛋上孵蛋根据过滤条件获取数据
	 * @param tableName
	 * @return
	 */
	private String getFilterBillInformation(String tableName) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = (Date)pkBeginDate.getValue();
		Date endDate = (Date)pkEndDate.getValue();
//		endDate=DateUtilsComm.addDays(endDate,1);
		StringBuffer sb = new StringBuffer();
		sb.append(" select t1.FID id,t3.Fnumber,t1.FbizDate,t1.FNumber from ").append(tableName).append(" t1 inner join CT_FM_HatchBaseData")
		.append(" t2 on t1.CFHatchFactoryID=t2.FID inner join T_ORG_Storage t3 on t3.FID=t2.CFHatchFactoryID where 1=1");
		if(beginDate!=null)
			sb.append( "  and t1.FBizdate>={ts '").append(sdf.format(beginDate)).append(" 00:00:00'}");
		if(endDate!=null)
			sb.append(" and t1.FBizdate<{ts '").append(sdf.format(endDate)).append(" 00:00:00'}+1 ");
			//单据号过滤
			if(UIRuleUtil.isNotNull(txtBillNum.getStringValue())){
				sb.append(" and t1.FNumber like '%").append(txtBillNum.getStringValue()).append("%'");
			}

			//孵化区过滤
			if(prmtHatchArea.getValue()!=null&&((Object[])prmtHatchArea.getValue()).length>0&&UIRuleUtil.isNotNull(((Object [])prmtHatchArea.getValue())[0])){
				Object[] storageRange=(Object[]) prmtHatchArea.getValue();
				if(storageRange!=null&&storageRange.length>0){
					sb.append(" and t3.FID in (");
					for(int i=0;i<storageRange.length;i++){
						sb.append("'"+((StorageOrgUnitInfo)storageRange[i]).getString("id")).append("'");
						if(i<storageRange.length-1)
							sb.append(",");

					}
					sb.append(")");
				}
			}
			sb.append(" order by t3.FNumber,t1.FbizDate,t1.FNumber");
			return sb.toString();
	}

}