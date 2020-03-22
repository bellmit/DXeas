package com.kingdee.eas.scm.sd.sale.client;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.batchaction.BatchActionEnum;
import com.kingdee.eas.framework.batchaction.BatchSelectionEntries;
import com.kingdee.eas.framework.client.CoreBillListUI;
import com.kingdee.eas.scm.common.botputils.client.SCMBTPBillListImpl;
import com.kingdee.eas.scm.sd.sale.ISaleOrder;
import com.kingdee.eas.scm.sd.sale.SaleOrderCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleOrderListUIPIEx extends SaleOrderListUI{

	public SaleOrderListUIPIEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	/*      */   public List getDestBosTypeForBotp(CoreBillBaseCollection srcBillInfos, List destBosTypeList)
	/*      */   {
		/* 2190 */     if ((srcBillInfos != null) && (srcBillInfos.size() > 0))
		/*      */     {
			/* 2192 */       String purOrderType = new PurOrderInfo().getBOSType().toString();
			/* 2193 */       boolean isNeedDelPurOrderRule = false;
			/*      */       try
			/*      */       {
				/* 2196 */         ISaleOrder isaleOrder = SaleOrderFactory.getRemoteInstance();
				/*      */ 
				/* 2198 */         SelectorItemCollection sic = new SelectorItemCollection();
				/* 2199 */         sic.add(new SelectorItemInfo("id"));
				/* 2200 */         sic.add(new SelectorItemInfo("purchaseOrgUnit.id"));
				/*      */ 
				/* 2202 */         int i = 0; for (int n = srcBillInfos.size(); i < n; ++i) {
					/* 2203 */           SaleOrderInfo saleorder = isaleOrder.getSaleOrderInfo(new ObjectUuidPK(((SaleOrderInfo)srcBillInfos.get(i)).getId()), sic);
					/* 2204 */           if (saleorder.getPurchaseOrgUnit() == null) {
						/* 2205 */             isNeedDelPurOrderRule = true;
						/* 2206 */             break;
					/*      */           }
				/*      */         }
			/*      */       } catch (BOSException e) {
				/* 2210 */         handleException(e);
				//		/* 2211 */         super.logger.error(e);
			/*      */       } catch (EASBizException e) {
				/* 2213 */         handleException(e);
				//		/* 2214 */         logger.error(e);
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
			/*      */       }
			/*      */ 
		/*      */     }
		/*      */ 
		/* 2225 */     for (int i = destBosTypeList.size() - 1; i >= 0; --i) {
			/* 2226 */       String bosType = (String)destBosTypeList.get(i);
			/*      */ 
			/* 2228 */       if ("8B07BBDB".equals(bosType)) {
				//		/* 2229 */         destBosTypeList.remove(i);
			/*      */       }
		/*      */     }
		/*      */ 
		/* 2233 */     return destBosTypeList;
	/*      */   }


	/*      */   protected void resetBTPBillListImpl()
	/*      */     throws Exception
	/*      */   {
		/*  992 */     //SCMBTPBillListImpl billList = new SCMBTPBillListImpl(this, getMainOrgInfo());
//		/*  993 */     billList.init();
//		/*  994 */     Field field = CoreBillListUI.class.getDeclaredField("billList");
//		/*  995 */     field.setAccessible(true);
//		/*  996 */     field.set(this, billList);
	/*      */   }

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}

	private Boolean checckIsHasSameCar(String carNum,SaleOrderInfo info) {
		// TODO Auto-generated method stub
		Boolean isHasSameCar=false;
		String billID="X_X";
		if(info.getId()!=null){
			billID=info.getId().toString();
		}
		try {
			SaleOrgUnitInfo company=info.getSaleOrgUnit();
			String companyID=company.getId().toString();
			CompanyOrgUnitInfo  companyInfo=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyID));
			char firstNum=companyInfo.getNumber().charAt(0);
			Date bizdate=info.getBizDate();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			StringBuffer stf=new StringBuffer();
			stf.append("/*dialect*/select *  from T_SD_SaleOrder t1")
			.append(" inner join T_ORG_Sale t2 on t2.fid=t1.FSaleOrgUnitID")
			.append(" where t1.FBizDate>=to_date('").append(sdf.format(bizdate)).append("','yyyy-mm-dd')-2")
			.append(" and t1.FBizDate<=to_date('").append(sdf.format(bizdate)).append("','yyyy-mm-dd')+2")
			.append(" and t1.CFLicensePlateNum ='").append(carNum).append("'")
			.append(" and t2.fnumber like'").append(firstNum+"%").append("'")
			.append(" and t1.fid<>'").append(billID).append("'");
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(stf.toString()).executeSQL();
			if(rs.next()){
				isHasSameCar=true;
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
		return isHasSameCar;
	}

	@Override
	public boolean beforeAction(BatchActionEnum bizAction,
			BatchSelectionEntries selectionEntries, ActionEvent event) {
		// TODO Auto-generated method stub
		try {
			if (BatchActionEnum.SUBMIT.equals(bizAction)) {
				ISaleOrder iSaleOrder = SaleOrderFactory.getRemoteInstance();
				Map selectedIDNumberMap = getSelectedIdNumber();
				Object[] ids = selectedIDNumberMap.keySet().toArray();
				ObjectUuidPK[] pks = new ObjectUuidPK[ids.length];
				int i = 0;
				for (int length = ids.length; i < length; ++i) {
					pks[i] = new ObjectUuidPK(ids[i].toString());
				}
				if (pks.length > 0) {
					StringBuffer saleIDs = new StringBuffer();
					saleIDs.append("where id in (");
					int j = 0;
					for (int length = pks.length; j < length; ++j) {
						if (j > 0) {
							saleIDs.append(",");
						}
						saleIDs.append("'").append(pks[j]).append("'");
					}
					saleIDs.append(")");
					SaleOrderCollection saleOrderCollection;

					saleOrderCollection = iSaleOrder
					.getSaleOrderCollection(saleIDs.toString());

					if (saleOrderCollection != null) {
						if(saleOrderCollection.size()==1){
							SaleOrderInfo info= saleOrderCollection.get(0);
							if(info.get("licensePlateNum")!=null&&info.getBizDate()!=null&&info.getSaleOrgUnit()!=null){
								String carNum=(String) info.get("licensePlateNum");	
								Boolean isHasSameCar=checckIsHasSameCar(carNum,info);
								if(isHasSameCar){
									if(MsgBox.showConfirm2("当前订单车辆在本公司两天内拉过货，请注意是否继续。")!=MsgBox.YES){
										return false;
									}else{			
										return super.beforeAction(bizAction, selectionEntries, event);}
								}	
							} 
						}else{
							int k = 0;
							for (int size = saleOrderCollection.size(); k < size; ++k) {
								SaleOrderInfo info = saleOrderCollection.get(k);
								if(info.get("licensePlateNum")!=null&&info.getBizDate()!=null&&info.getSaleOrgUnit()!=null){
									String carNum=(String) info.get("licensePlateNum");	
									Boolean isHasSameCar=checckIsHasSameCar(carNum,info);
									if(isHasSameCar){
										if(MsgBox.showConfirm2("所选的订单中存在同一车辆在同一公司两天内拉过货的情况，请注意是否继续。")!=MsgBox.YES){
											return false;
										}else{			
											return super.beforeAction(bizAction, selectionEntries, event);
										}
									}	
								} 
							}
						}					

					}
				}
			} }catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return super.beforeAction(bizAction, selectionEntries, event);
	}
}
