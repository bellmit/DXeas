package com.kingdee.eas.bdm.bdapply.util;

import java.sql.SQLException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.PayConditionFactory;
import com.kingdee.eas.basedata.framework.DataBaseDAssignFactory;
import com.kingdee.eas.basedata.framework.DataBaseDAssignInfo;
import com.kingdee.eas.basedata.framework.DataStateEnum;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyBankInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerDeliveryAddressInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerLinkManInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSalerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierCompanyBankInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierCompanyInfoFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierCompanyInfoInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierPurchaseInfoFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierPurchaseInfoInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.fm.be.BEBankFactory;
import com.kingdee.eas.fm.be.BEBankInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 基础资料统一处理接口
 * @author Administrator
 *
 */
public class BaseDataHandleUtil {

	/***
	 * 插入引用关系
	 * @param ctx
	 * @param info
	 */
	public static void insertQuote(Context ctx,CoreBaseInfo destInfo,String cuID) {
		try {
			/*StringBuffer sql=new StringBuffer();
			sql.append(" insert into ");
			sql.append(" T_BD_DataBaseDAssign (");
			sql.append(" fid,FDataBaseDID,FAssignCUID,FBOSObjectType,FStatus");
			sql.append(" )values(");
			sql.append(" ");
			sql.append(" )");
			DbUtil.execute(ctx, sql.toString());*/
			DataBaseDAssignInfo dInfo=new DataBaseDAssignInfo();
			dInfo.setAssignCU(CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK(cuID)));
			dInfo.setDataBaseDID(destInfo.getId());
			dInfo.setBosObjectType(destInfo.getBOSType().toString());
			dInfo.setStatus(DataStateEnum.ENABLE);
			DataBaseDAssignFactory.getLocalInstance(ctx).save(dInfo);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 生成 申请单对应财务组织的  财务资料
	 * @param ctx
	 * @param cirinfo
	 * @param cinfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void addCustomerCompanyInfo(Context ctx,CustomerInfoReqInfo cReqInfo,CustomerInfo cInfo) throws EASBizException, BOSException{
		if(cReqInfo != null && cReqInfo.getCompany() != null && cInfo != null && cInfo.getId() != null){
			CustomerCompanyInfoInfo cusCompanyInfo = new CustomerCompanyInfoInfo();
			cusCompanyInfo.setCustomer(cInfo);
			cusCompanyInfo.setCU(cReqInfo.getCU());
			cusCompanyInfo.setCompanyOrgUnit(cReqInfo.getCompany());
			//			cusCompanyInfo.setAdminOrgUnit(cReqInfo)
			cusCompanyInfo.setOperationer(cReqInfo.getSalePerson());
			cusCompanyInfo.setPaymentType(cReqInfo.getPayType());

			IRowSet rs = DbUtil.executeQuery(ctx,"select FID from T_BD_PayCondition where FCreateOrgID='"+cReqInfo.getCompany().getString("id")+"' and FDeletedStatus=1");
			try {
				if(rs.next()){
					cusCompanyInfo.setPayCondition(PayConditionFactory.getLocalInstance(ctx).getPayConditionInfo(new ObjectUuidPK(rs.getString("fid"))));
				}else
					cusCompanyInfo.setPayCondition(cReqInfo.getPayCondition());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cusCompanyInfo.setSettlementCurrency(cReqInfo.getSettlementCurrency());

			//			// 开户行
			//			CustomerCompanyBankInfo bankInfo = new CustomerCompanyBankInfo();
			//			bankInfo.setBank(cReqInfo.getBank());
			//			bankInfo.setBankAccount(cReqInfo.getBankAccount());
			//			bankInfo.setAccountName(cReqInfo.getBank());
			//			bankInfo.setBankAddress(cReqInfo.getBankAddress());
			//			bankInfo.setCurrency(cReqInfo.getAccountCurrency());
			//			bankInfo.setOpenArea(cReqInfo.getAccountArea());
			//			bankInfo.setb
			//			cusCompanyInfo.getCustomerBank().add(bankInfo);

			CustomerCompanyInfoFactory.getLocalInstance(ctx).addnew(cusCompanyInfo);
		}

	}

	/**
	 * 生成 申请单对应财务组织的  销售资料
	 * @param ctx
	 * @param cirinfo
	 * @param cinfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void addCustomerSaleInfo(Context ctx,CustomerInfoReqInfo cReqInfo,CustomerInfo cInfo) throws EASBizException, BOSException{
		if(cReqInfo != null && cReqInfo.getCompany() != null && cInfo != null && cInfo.getId() != null){
			CustomerSaleInfoInfo cusSaleInfo = new CustomerSaleInfoInfo();
			cusSaleInfo.setCustomer(cInfo);
			cusSaleInfo.setSettlementOrgUnit(cInfo);
			cusSaleInfo.setBillingOrgUnit(cInfo);
			cusSaleInfo.setDeliverOrgUnit(cInfo);
			cusSaleInfo.setCU(cReqInfo.getCU());
			cusSaleInfo.setSaleOrgUnit(cReqInfo.getSaleOrgUnit());

			// 联系人
			CustomerLinkManInfo linkManInfo = new CustomerLinkManInfo();
			linkManInfo.setCustomerSale(cusSaleInfo);
			linkManInfo.setContactPerson(cReqInfo.getContractPerson());
			linkManInfo.setContactPersonPost(cReqInfo.getContractPersonPost());
			linkManInfo.setPhone(cReqInfo.getPhone());
			linkManInfo.setMobile(cReqInfo.getMobile());
			linkManInfo.setEmail(cReqInfo.getEmail());
			linkManInfo.setAddress(cReqInfo.getLinkManAddress());
			cusSaleInfo.getCustomerLinkMan().add(linkManInfo);

			// 销售员
			CustomerSalerInfo salerInfo = new CustomerSalerInfo();
			//			bankInfo.setCustomerCompanyInfo(item)
			salerInfo.setPerson(cReqInfo.getSalePerson());

			salerInfo.setCustomerSale(cusSaleInfo);

			SaleGroupInfo saleGroup = cReqInfo.getSaleGroup();
			if(saleGroup != null){
				salerInfo.put("saleGroup", saleGroup);
				if(cReqInfo.getSaleGroup().getNumber() == null){
					saleGroup = SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(new ObjectUuidPK(cReqInfo.getSaleGroup().getId()));
				}

				salerInfo.put("saleGroupNum", saleGroup.getNumber());
				salerInfo.put("saleGroupName", saleGroup.getName());

			}
			cusSaleInfo.getCustomerSaler().add(salerInfo);
			//			// 收货地址
			//			CustomerDeliveryAddressInfo divAddressInfo = new CustomerDeliveryAddressInfo();
			//			divAddressInfo.setAddress(cReqInfo.getLinkManAddress());
			//			divAddressInfo.setCustomerSaleInfo(cusSaleInfo);
			//			cusSaleInfo.getDeliveryAddresses().add(divAddressInfo);

			CustomerSaleInfoFactory.getLocalInstance(ctx).addnew(cusSaleInfo);
		}

	}



	/**
	 * 生成 供应商 申请单对应财务组织的  财务资料
	 * @param ctx
	 * @param cirinfo
	 * @param cinfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void addSupplierCompanyInfo(Context ctx,SupplierReqInfo cReqInfo,SupplierInfo cInfo) throws EASBizException, BOSException{
		if(cReqInfo != null && cReqInfo.getCompany() != null && cInfo != null && cInfo.getId() != null){
			SupplierCompanyInfoInfo supplierCompanyInfo = new SupplierCompanyInfoInfo();
			supplierCompanyInfo.setSupplier(cInfo);
			supplierCompanyInfo.setCU(cReqInfo.getCU());
			supplierCompanyInfo.setCompanyOrgUnit(cReqInfo.getCompany());
			//			cusCompanyInfo.setAdminOrgUnit(cReqInfo)

			try {
				//默认RMB
				supplierCompanyInfo.setSettlementCurrency(CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC")));
			}catch(Exception err) {
				err.printStackTrace();
			}

			// 开户行
			SupplierCompanyBankInfo bankInfo = new SupplierCompanyBankInfo();
			bankInfo.setBank(cReqInfo.getBank());
			if(cReqInfo.getBEBank()!=null){
				BEBankInfo beBankInfo = BEBankFactory.getLocalInstance(ctx).getBEBankInfo(new ObjectUuidPK(cReqInfo.getBEBank().getString("id")));
				bankInfo.setBank(beBankInfo.getString("name"));
				bankInfo.setBankAddress(beBankInfo.getAdress());
			}
			bankInfo.setBankAccount(cReqInfo.getAccountNum());
			bankInfo.setSupplierCompanyInfo(supplierCompanyInfo);

			supplierCompanyInfo.getSupplierBank().add(bankInfo);

			SupplierCompanyInfoFactory.getLocalInstance(ctx).save(supplierCompanyInfo);
		}

	}

	/**
	 * 生成 供应商 申请单对应财务组织的  销售资料
	 * @param ctx
	 * @param cirinfo
	 * @param cinfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static void addSupplierSaleInfo(Context ctx,SupplierReqInfo cReqInfo,SupplierInfo cInfo) throws EASBizException, BOSException{
		if(cReqInfo != null && cReqInfo.getCompany() != null && cInfo != null && cInfo.getId() != null){
			SupplierPurchaseInfoInfo supplierPurInfo = new SupplierPurchaseInfoInfo();
			supplierPurInfo.setSupplier(cInfo);
			supplierPurInfo.setBillingOrgUnit(cInfo);
			supplierPurInfo.setDeliverOrgUnit(cInfo);
			supplierPurInfo.setCU(cReqInfo.getCU());
			supplierPurInfo.setPurchaseOrgUnit(cReqInfo.getPurInOrgUnit());

			supplierPurInfo.setAvailable(true);


			SupplierPurchaseInfoFactory.getLocalInstance(ctx).addnew(supplierPurInfo);
		}

	}

}
