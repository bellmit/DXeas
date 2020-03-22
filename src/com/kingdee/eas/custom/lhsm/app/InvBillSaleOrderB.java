package com.kingdee.eas.custom.lhsm.app;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.ibm.db2.jcc.t4.ob;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.ConvertModeEnum;
import com.kingdee.eas.basedata.assistant.CostItemInfo;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeFactory;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.assistant.SettlementTypeFactory;
import com.kingdee.eas.basedata.assistant.SettlementTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoInfo;
import com.kingdee.eas.basedata.master.cssp.ICustomerSaleInfo;
import com.kingdee.eas.basedata.master.material.IMaterialCost;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialCostFactory;
import com.kingdee.eas.basedata.master.material.MaterialCostInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesCollection;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BillTypeFactory;
import com.kingdee.eas.basedata.scm.common.BillTypeInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeFactory;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysConstant;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.EntryBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.eas.scm.sd.sale.ISaleOrder;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.jdbc.rowset.IRowSet;
//预报单生成销售订单
public class InvBillSaleOrderB{
	public BigDecimal totalTaxamount=BigDecimal.ZERO;
	public BigDecimal totalTax=BigDecimal.ZERO;
	public BigDecimal totalAmount=BigDecimal.ZERO;
	protected String[] saleOrderA(Context ctx,String id,String cuid,String customerid)
	throws Exception {
		String msg[] = new String[2];
		StringBuffer sql=new StringBuffer();
		String linkman="";
		String linkmantel="";
		String address="";
		String remark="";
		String companyID = "";
		String description  = "";
		try {
			//切换组织
			IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);  
			orgSwitch.orgSwitch(cuid);

			totalTaxamount=BigDecimal.ZERO;
			totalTax=BigDecimal.ZERO;
			totalAmount=BigDecimal.ZERO;

			sql=new StringBuffer();
			sql.append("Select ");
			sql.append(" isnull(t1.CFLINKMAN,'') FLINKMAN,isnull(t1.CFLINKMANTEL,'') FLINKMANTEL,isnull(t3.FRemarks,'') FRemarks,");
			sql.append(" isnull(t1.CFSENDADDRESS,'') FSENDADDRESS,isnull(t1.fdescription,'') fdescription,isnull(t2.CFREMARK,'') FREMARK,");
			sql.append(" isnull(t1.cfsalepersonid,'') fsalepersonid,isnull(t1.cfsalegroupid,'') fsalegroupid, ");
			sql.append(" t3.fcustomerid,t3.fmaterialid,t3.funitid, isnull(t2.FwareHouseID,'') FwareHouseID,t1.FSaleCustomerID FSaleCustomerID,t2.CFCompanyID,");
			sql.append(" t3.fqty,t3.fprice,t3.famount,t2.FPremium premium,t2.FSrcPrice FSrcPrice,t2.FInternalCost,t1.FDepartmentID,t2.CFPrice,t2.FPremiumAmount ");
			sql.append(" from  ct_lhs_saleforecast t1 ");
			sql.append(" inner join ct_lhs_saleforecastentry t2 on t2.fparentid=t1.fid ");
			sql.append(" inner join ct_lhs_saleforecastentry2 t3 on t3.fentryid=t2.fid ");
			sql.append(" where t3.fcompanyid='"+cuid+"' ");
			sql.append(" and t3.fcustomerid='"+customerid+"' ");
			sql.append(" and isnull(t3.fstatus,0)=0 ");
			sql.append(" and t1.fid='"+id+"' ");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rs != null && rs.size() > 0){
				SaleOrderInfo info = new SaleOrderInfo();
				String saleGroupid="";
				String personid="";

				String salecustomerID = null;
				while(rs.next()){
					remark=rs.getString("FRemarks");
					linkman=rs.getString("FLINKMAN");
					linkmantel=rs.getString("FLINKMANTEL");
					address=rs.getString("FSENDADDRESS");
					saleGroupid=rs.getString("fsalegroupid");
					personid=rs.getString("fsalepersonid");
					salecustomerID =rs.getString("FSaleCustomerID");
					companyID = rs.getString("CFCompanyID");
					description = rs.getString("fdescription");

					info.put("linkCell",linkmantel);
					info.put("linkMans",linkman);
					info.put("address",address);
					info.setDescription(description);
					info.setBoolean("IsInTax", true);

					SaleOrderEntryInfo entryinfo = new SaleOrderEntryInfo();
					entryinfo.setSendAddress(address);
					entryinfo.setRemark(remark);
					entryinfo.put("destCompany",rs.getString("CFCompanyID"));
					entryinfo.put("forecastPrice",rs.getBigDecimal("CFPrice"));
					entryinfo.put("deliveryCustomer",salecustomerID);
					entryinfo.put("paymentCustomer",salecustomerID);
					entryinfo.put("receiveCustomer",salecustomerID);
					entryinfo.put("srcBillPremium",rs.getString("FPremiumAmount"));

					buildBillEntryA(ctx,entryinfo,rs,cuid,salecustomerID);
					info.getEntries().add(entryinfo);
					info.setSendAddress(address);
					if(StringUtils.isNotEmpty(rs.getString("FDepartmentID"))){
						info.put("adminOrgUnit",rs.getString("FDepartmentID"));
					}
				}
				if(info.getEntries().size()>0){
					buildBillHead(ctx, info,cuid,customerid,saleGroupid,personid);
					info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
					//					info.setDescription(remark);
					//					info.setConnectionPerson(linkman);
					info.setDescription(description);
					info.put("description",description);
					info.put("ConnectPerson", linkman);
					info.put("Person", linkman);
					//					info.setAdress(address);
					info.put("adress", address);
					//					info.setPhone(linkmantel);
					info.put("Phone", linkmantel);
					info.put("isFromInvBill", Boolean.TRUE);
					info.setVersion(0);
					info.setOldStatus(BillBaseStatusEnum.ADD);
					info.setTotalAmount(totalAmount);
					info.setLocalTotalAmount(totalAmount);
					info.setTotalTax(totalTax);
					info.setTotalTaxAmount(totalTaxamount);
					info.setLinkMan(linkman);
					//info.setDescription(item)
					String fNumber = "";
					if (this.isCodeRuleEnable(ctx, info,cuid) == true) {
						fNumber = this.getAutoCode(ctx, info,cuid);
					}
					Date date = new Date(System.currentTimeMillis());
					if (!fNumber.equals("")) {
					} else {

						fNumber = String.valueOf(date.getYear() + 1900)
						+ String.valueOf(date.getMonth() + 1)
						+ String.valueOf(date.getDate());
						fNumber = fNumber + String.valueOf(date.getHours())
						+ String.valueOf(date.getSeconds()) + "004";
					}
					info.setNumber(getuniqnumber(ctx,info,cuid,fNumber));
					info.put("saleCustomer",salecustomerID);
					info.setSyncOldValue(false);
					ISaleOrder ifac = SaleOrderFactory.getLocalInstance(ctx);
					IObjectPK pk = ifac.submit(info);
					if(info.getId()!=null){
						sql=new StringBuffer();
						sql.append(" update ct_lhs_saleforecastentry2 set fstatus=1,fsaleorderid='"+info.getId().toString()+"' ");
						sql.append(" where fcompanyid='"+cuid+"' ");
						sql.append(" and fcustomerid='"+customerid+"' ");
						sql.append(" and isnull(fstatus,0)=0 ");
						sql.append(" and FParentid='"+id+"' ");
						com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
						for(int i=0;i<info.getEntries().size();i++){
							SaleOrderEntryInfo entryinfo=(SaleOrderEntryInfo)info.getEntries().get(i);
							MaterialInfo materialinfo=(MaterialInfo)entryinfo.getMaterial();
							if(materialinfo!=null){
								ForecastOrderFacadeFactory.getLocalInstance(ctx).companyInv("'"+cuid+"'", "'"+materialinfo.getId().toString()+"'");
							}
						}
					}
					//					info = ifac.getSaleOrderInfo(pk);
					//					ifac.submit(info);
					//					info = ifac.getSaleOrderInfo(pk);
					//					ifac.audit(pk);
				}
			}
			msg[0] = "0";
			msg[1] = "成功";
		} catch (BOSException e) {
			msg[0] = "1";
			msg[1] = e.getMessage();
			throw new BOSException("生成销售订单错误：",e);
		}
		return msg;
	}
	public String getuniqnumber(Context ctx,IObjectValue objValue,String companyId, String number) throws BOSException{
		String sql = " select fid from t_sd_saleorder where fnumber='"+number+"' ";
		String newnumber = number;
		try {
			IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql);
			if(rs.next()){
				newnumber = getAutoCode(ctx,objValue,companyId);
				return getuniqnumber(ctx,objValue,companyId,newnumber);
			}
		} catch (EASBizException e) {
			throw new BOSException("错误：",e);
		} catch (BOSException e) {
			throw new BOSException("错误：",e);
		} catch (SQLException e) {
			throw new BOSException("错误：",e);
		}
		return newnumber;
	}

	private void buildBillHead(Context ctx,SaleOrderInfo info,String cuid,String customerid,String saleGroupid,String personid) throws BOSException,
	EASBizException {

		java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

		ObjectUuidPK pk = new ObjectUuidPK(cuid);// 需要修改
		CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);// 需要修改
		if (cuInfo == null) {
			throw new ImportException(ImportException.CUEXCEPTION);
		}
		// objectbase
		String fUserid = ((UserInfo) ctx.get("UserInfo")).getId().toString();
		pk = new ObjectUuidPK(fUserid);
		UserInfo creatorInfo = UserFactory.getLocalInstance(ctx).getUserInfo(pk);
		info.setCreator(creatorInfo);
		info.setCreateTime(timeStamp);
		// info.setLastUpdateUser(new UserInfo());
		// info.setLastUpdateTime(new Timestamp(0));
		pk = new ObjectUuidPK(cuid);// 需要修改
		CtrlUnitInfo cuInfoa = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);
		info.setCU(cuInfoa);


		info.setBizDate(new Date());//new Date()
		// info.setHandler(new UserInfo());
		info.setDescription("");
		// info.setHasEffected(true);//是否曾经开始
		// info.setAuditor(new UserInfo());
		info.setSourceBillId("");
		// info.setSourceFunction("");

		// scmbillbase
		// info.setAuditTime(new Timestamp(0));
		info.setBaseStatus(BillBaseStatusEnum.SUBMITED);

		BizTypeInfo bizTypeInfo=new BizTypeInfo();
		bizTypeInfo.setId(BOSUuid.read("d8e80652-010e-1000-e000-04c5c0a812202407435C"));//业务类别--普通销售
		info.setBizType(bizTypeInfo);// 业务类型 生产领料
		// com.kingdee.eas.cp.ap.BillTypeInfo
		// billTypeinfo=BillTypeFactory.getLocalInstance(ctx).
		// getBillTypeInfo("50957179-0105-1000-e000-0163c0a812fd463ED552");
		//info.setSourceBillType();
		Date date = new Date(System.currentTimeMillis());

		BillTypeInfo billTypeInfo=new BillTypeInfo();
		billTypeInfo.setId(BOSUuid.read("510b6503-0105-1000-e000-0113c0a812fd463ED552"));//单据类别--销售订单
		info.setBillType(billTypeInfo);
		info.setYear(date.getYear() + 1900);
		info.setPeriod(date.getMonth() + 1);//
		// info.setModifier(new UserInfo());
		// info.setModificationTime(new Timestamp(0));

		// invbillbase
		pk = new ObjectUuidPK(cuid);// 需要修改
		StorageOrgUnitInfo storageorgunitinfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(pk);
		info.setStorageOrgUnit(storageorgunitinfo);// 库存组织 需要修改

		//		pk = new ObjectUuidPK(cuid);// 需要修改"l+TIDkATRCGkbOFQSh0WbMznrtQ="
		//		AdminOrgUnitInfo adminOrgUnitInfo = AdminOrgUnitFactory.getLocalInstance(ctx).getAdminOrgUnitInfo(pk);
		//		info.setAdminOrgUnit(adminOrgUnitInfo);// 部门 需要修改

		// info.setStocker(new PersonInfo());
		// info.setVoucher(new VoucherInfo());//
		// info.setTotalQty(new BigDecimal(0));//
		// info.setTotalAmount(new BigDecimal(0));//
		// info.setFiVouchered(true);//
		// info.setTotalStandardCost(new BigDecimal(0));//
		// info.setTotalActualCost(new BigDecimal(0));//
		//info.setIsReversed(true);
		//info.setIsInitBill(true);

		// SaleOrder
		info.setIsInnerSale(false);// 内部销售

		//info.setCustomerOrderNumber(sBillInfo.getCustomerOrderNumber());// 客户订单号

		pk = new ObjectUuidPK(customerid);// 需要修改
		CustomerInfo customerinfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(pk);
		info.setOrderCustomer(customerinfo);// 订货客户
		// 同销售公司销售订单订货客户
		//info.setDirectSupplier(sBillInfo.getDirectSupplier());// 直运供应商
		//info.setPurchaseOrgUnit(sBillInfo.getPurchaseOrgUnit());// 采购组织

		DeliveryTypeInfo dtinfo=new DeliveryTypeInfo();
		dtinfo.setId(BOSUuid.read("521733ca-0105-1000-e000-00e2c0a8123362E9EE3F"));
		info.setDeliveryType(dtinfo);
		//info.setTransLeadTime(0);// 运输提前期

		CurrencyInfo currencyInfo=new CurrencyInfo();
		currencyInfo.setId(BOSUuid.read("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
		info.setCurrency(currencyInfo);// 币别

		info.setExchangeRate(new BigDecimal("1"));// 汇率

		com.kingdee.eas.basedata.assistant.PaymentTypeInfo ptinfo=new PaymentTypeInfo();
		ptinfo.setId(BOSUuid.read("cd54aa9f-03a4-459c-9c5a-5489dce5f0676BCA0AB5"));
		info.setPaymentType(ptinfo);// 付款方式

		//info.setCashDiscount();// 现金折扣

		SettlementTypeInfo settlementTypeInfo=new SettlementTypeInfo();
		settlementTypeInfo.setId(BOSUuid.read("e09a62cd-00fd-1000-e000-0b32c0a8100dE96B2B8E"));
		info.setSettlementType(settlementTypeInfo);// 结算方式
		//info.setPrepayment();// 预收金额
		//info.setPrepaymentRate();

		pk = new ObjectUuidPK(cuid);// 需要修改 
		SaleOrgUnitInfo saleOrgUnitInfo=SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(pk);
		info.setSaleOrgUnit(saleOrgUnitInfo);// 销售组织

		if(!saleGroupid.equals("")){
			pk = new ObjectUuidPK(saleGroupid);// 需要修改 
			SaleGroupInfo groupinfo=SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(pk);
			info.setSaleGroup(groupinfo);// 销售组
		}
		if(!personid.equals("")){
			//pk = new ObjectUuidPK(personid);// 需要修改 
			PersonInfo personInfo=new PersonInfo();
			personInfo.setId(BOSUuid.read(personid));
			//PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);
			info.setSalePerson(personInfo);// 销售员
		}

		//info.setAdminOrgUnit();// 部门
		//info.setTotalAmount();// 金额
		//info.setTotalTax();// 税额
		//info.setTotalTaxAmount();// 价税合计
		//info.setPreReceived();// 已收应收款
		//info.setUnPrereceivedAmount();// 未预收款金额
		//info.setSendAddress();// 送货地址
		info.setIsSysBill(false);// 是否系统单据
		info.setConvertMode(com.kingdee.eas.basedata.assistant.ConvertModeEnum.DIRECTEXCHANGERATE);// 折算方式
		//info.setLocalTotalAmount();// 金额本位币合计
		//info.setLocalTotalTaxAmount();// 价税合计本位币

		pk = new ObjectUuidPK(cuid);// 需要修改
		CompanyOrgUnitInfo companyOrgUnitInfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);
		info.setCompanyOrgUnit(companyOrgUnitInfo);// 财务组织

		//info.setIsInTax();// 是否含税
		//info.setCustomerPhone();// 联系电话
		//info.setLinkMan();// 联系人
		//info.setAlterPerson();// 变更人
		//info.setOldID();// 原ID
		//info.setOldStatus();// 旧的状态值
		//info.setVersion();
		//info.setAlterDate();// 变更时间
		info.setIsCentralBalance(false);// 集中结算

		pk = new ObjectUuidPK(cuid);// 需要修改
		StorageOrgUnitInfo storageOrgUnitInfo=StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(pk);
		info.setStorageOrgUnit(storageOrgUnitInfo);// 库存组织

		info.setIsReverse(false);
		//info.setBeenPaidPrepayment();// 已收预收款金额
		//info.setReceiveCondition();// 收款条件

		//info.setTypeJ(sBillInfo.getTypeJ());
	}
	private void buildBillEntryA(Context ctx, SaleOrderEntryInfo info,IRowSet rs,String cuid, String salecustomerID) throws Exception {
		java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		ObjectUuidPK pk = new ObjectUuidPK(cuid);// 需要修改
		CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);
		if (cuInfo == null) {
			throw new ImportException(ImportException.CUEXCEPTION);
		}

		// corebillentrybase
		info.setSeq(0);

		//scmbillentrybase
		pk = new ObjectUuidPK(rs.getString("fmaterialid"));// 需要修改
		MaterialInfo materialInfo= MaterialFactory.getLocalInstance(ctx).getMaterialInfo(pk);
		info.setMaterial(materialInfo);

		//		info.setMaterialA(materialInfo);
		info.put("MaterialA", materialInfo);
		info.setAssistProperty(null);//辅助属性



		info.setSourceBillId("");
		info.setSourceBillNumber("");
		info.setSourceBillEntryId("");

		//info.setAssCoefficient(new BigDecimal(""));
		info.setBaseStatus(EntryBaseStatusEnum.ADD);
		info.setAssociateQty(rs.getBigDecimal("fqty"));
		//info.setSourceBillType(new BillTypeInfo());

		pk = new ObjectUuidPK(materialInfo.getBaseUnit().getId());// 需要修改
		MeasureUnitInfo baseunitinfo=MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);
		info.setBaseUnit(baseunitinfo);

		//info.setAssistUnit(baseunitinfo);
		//info.setRemark("");
		//info.setReasonCode(new ReasonCodeInfo());
		MeasureUnitInfo unitinfo=null;
		BigDecimal coefficient=BigDecimal.ZERO;
		BigDecimal taxRate=BigDecimal.ZERO; 
		BigDecimal taxRateA=BigDecimal.ZERO;
		FilterInfo filterinfo = new FilterInfo();
		filterinfo.getFilterItems().add(new FilterItemInfo("CU.id", cuid));
		filterinfo.getFilterItems().add(new FilterItemInfo("material.id", materialInfo.getId()));
		filterinfo.setMaskString("#0 and #1");
		EntityViewInfo evi = new EntityViewInfo();
		evi.setFilter(filterinfo);
		MaterialSalesCollection mInvc = MaterialSalesFactory.getLocalInstance(ctx).getMaterialSalesCollection(evi);
		if (mInvc.size() > 0) {
			MaterialSalesInfo materialInvInfo = (MaterialSalesInfo) mInvc.get(0);

			pk = new ObjectUuidPK(materialInvInfo.getUnit().getId());// 需要修改
			unitinfo=MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);

			if(unitinfo==null){
				unitinfo=baseunitinfo;
			}
			info.setUnit(unitinfo);
			coefficient=unitinfo.getCoefficient();

			taxRate=materialInvInfo.getTaxRate();
			if(taxRate == null){
				taxRate = BigDecimal.ZERO;
			}
		}else{
			taxRate = BigDecimal.ZERO;
		}
		if(coefficient==null)coefficient=new BigDecimal("1");
		if(coefficient.compareTo(new BigDecimal("0"))==0)coefficient=new BigDecimal("1");

		info.setTaxRate(taxRate);
		taxRate=taxRate.divide(new BigDecimal("100"));
		taxRateA=taxRate.add(new BigDecimal("1"));

		BigDecimal basePrice=rs.getBigDecimal("fprice");

		BigDecimal taxprice=basePrice.multiply(coefficient);
		taxprice.setScale(6,4);

		BigDecimal taxamount=rs.getBigDecimal("famount");

		BigDecimal amount=taxamount.divide(taxRateA,2,4);
		amount=amount.setScale(2,4);

		BigDecimal tax=taxamount.subtract(amount);
		tax=tax.setScale(2,4);
		//saleOrderEntry


		BigDecimal price=taxprice.divide(taxRateA,6,4);
		price=price.setScale(6, 4);

		BigDecimal baseqty=rs.getBigDecimal("fqty");

		BigDecimal qty=baseqty.divide(coefficient,4,4);
		info.setTotalUnIssueQty(qty);
		info.setTotalunProductQty(qty);
		info.setTotalBaseunProductQty(qty);
		info.setTotalUnShipBaseQty(baseqty);
		//info.setIsPresent(true);
		info.setBaseQty(baseqty);
		info.setTotalUnIssueBaseQty(baseqty);
		info.setTotalUnReturnBaseQty(baseqty);
		info.setVersion(0);
		info.setOldStatus(EntryBaseStatusEnum.ADD);
		info.setPromotionSourceGroup(0);
		info.setIsMrpCal(false);
		info.setSourceBillEntrySeq(0);

		info.setAssistUnit(materialInfo.getAssistUnit());
		if(materialInfo.getAssistUnit()!=null){
			String assUnitID = materialInfo.getAssistUnit().getId().toString();
			MeasureUnitInfo measureUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(assUnitID));
			info.setAssistQty(UIRuleUtil.getBigDecimal(baseqty).divide(UIRuleUtil.getBigDecimal(measureUnitInfo.getCoefficient()),6,BigDecimal.ROUND_HALF_UP));
		}

		info.setQty(qty);
		//		info.put("DsBasePrice",basePrice);


		//		info.setAssignQty(baseqty);
		info.put("AssignQty", baseqty);
		//		info.setAssignPrice(basePrice);
		info.put("AssignPrice", basePrice);
		//		info.setAssignAmount(taxamount);
		info.put("AssignAmount", taxamount);
		//		info.setBasePrice(basePrice);
		info.put("basePrice", basePrice);
		info.put("DsBasePrice", UIRuleUtil.getBigDecimal(rs.getBigDecimal("FSrcPrice")));
		info.put("internalCost",UIRuleUtil.getBigDecimal(rs.getBigDecimal("FInternalCost")));
		info.setPrice(price);
		info.put("premium",UIRuleUtil.getBigDecimal(taxprice).subtract(UIRuleUtil.getBigDecimal(info.get("DsBasePrice"))).subtract(UIRuleUtil.getBigDecimal(info.get("internalCost"))));
		info.put("premiumAmount",UIRuleUtil.getBigDecimal(info.get("premium")).multiply(UIRuleUtil.getBigDecimal(qty)));
		info.setTaxPrice(taxprice);
		if(StringUtils.isNotEmpty(rs.getString("FwareHouseID")))
			info.setWarehouse(WarehouseFactory.getLocalInstance(ctx).getWarehouseInfo(new ObjectUuidPK(rs.getString("FwareHouseID"))));
		//		info.setCheapRate(null);
		//		info.setDiscountCondition(DiscountConditionEnum.AMOUNT);
		//		info.setDiscountType(DiscountModeEnum.PERCENT);
		//		info.setDiscount(null);
		//		info.setDiscountAmount(null);
		totalTaxamount=totalTaxamount.add(taxamount);
		totalTax=totalTax.add(tax);
		totalAmount=totalAmount.add(amount);

		info.setAmount(amount);

		info.setLocalAmount(amount);
		info.setActualPrice(price);
		info.setActualTaxPrice(taxprice);
		info.setTaxPrice(taxprice);
		info.setTax(tax);
		info.setTaxAmount(taxamount);
		info.setSendDate(new Date());
		info.setDeliveryDate(timeStamp);

		pk = new ObjectUuidPK(cuid);// 需要修改
		StorageOrgUnitInfo storageorgunitinfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(pk);
		info.setStorageOrgUnit(storageorgunitinfo);// 库存组织

		pk = new ObjectUuidPK(cuid);// 需要修改
		CompanyOrgUnitInfo companyorgunitinfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);
		info.setCompanyOrgUnit(companyorgunitinfo);


		//		WarehouseInfo warehouserInfo=getMaterialInventory(ctx,companyorgunitinfo,materialInfo);;
		//		info.setWarehouse(warehouserInfo);

		//info.setSendOverRate(null);

		//		info.setSendOwingRate(null);
		//		info.setSendAdvanceDay(null);
		//		info.setSendDeferralDay(null);
		//		info.setTotalIssueQty(null);
		//		info.setTotalReturnedQty(null);
		//		info.setTotalInvoicedQty(null);
		//		info.setTotalShippingQty(null);
		//		info.setTotalReceivedAmount(null);
		//		info.setParent(null);
		//		info.setTotalIssueBaseQty(null);

		//		info.setTotalReBaseQty(null);
		//		info.setTotalShipBaseQty(null);
		//		info.setTotalUnReturnBaseQty(null);
		//		info.setTotalUnIssueBaseQty(null);
		//		info.setTotalUnShipBaseQty(null);
		//		info.setTotalUnIssueQty(null);
		//		info.setIsLocked(true);
		//		info.setLockQty(null);
		//		info.setLockBaseQty(null);
		//		info.setLockAssistQty(null);
		//		info.setLocalTax(null);
		//		info.setLocalTaxAmount(null);
		//		info.setIsBySaleOrder(true);
		//		info.setOrderedQty(null);
		//		info.setUnOrderedQty(null);
		//		info.setPrepaymentRate(null);
		//		info.setPrepayment(null);
		//		info.setPreReceived(null);
		//		info.setUnPrereceivedAmount(null);
		//		info.setQuantityUnCtrl(true);
		//		info.setTimeUnCtrl(true);

		pk = new ObjectUuidPK(rs.getString("fcustomerid"));// 需要修改
		CustomerInfo customerinfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(pk);
		if(StringUtils.isNotBlank(salecustomerID)){
			info.setDeliveryCustomer(customerinfo);
			info.setPaymentCustomer(customerinfo);
			info.setReceiveCustomer(customerinfo);
		}
		info.setRemark(rs.getString("FRemark"));
	}

	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		// String companyId = OrgInnerUtils.getCurCompany();
		// ICodingRuleManager codeRuleMgr = null;
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
		.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		// String companyId = OrgInnerUtils.getCurCompany();
		// ICodingRuleManager codeRuleMgr = null;
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);  
		orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
		.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			codeRuleMgr.getNumber(objValue, companyId);
			return codeRuleMgr.readNumber(objValue, companyId);
			//return codeRuleMgr.getNumber(objValue, companyId);
		} else {
			codeRuleMgr.getNumber(objValue, companyId);
			return codeRuleMgr.readNumber(objValue, companyId);
		}
	}

	public CostItemInfo getDefaultCostItem(Context ctx,
			CompanyOrgUnitInfo aCompanyOrgUnitInfo, MaterialInfo materialInfo)
	throws Exception {
		CostItemInfo costItemInfo = null;
		if (aCompanyOrgUnitInfo != null && materialInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemMaterialInfo = new FilterItemInfo("material", materialInfo.getId().toString(),CompareType.EQUALS);
			FilterItemInfo filterItemOrgInfo = new FilterItemInfo("orgUnit",aCompanyOrgUnitInfo.getId().toString(), CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemMaterialInfo);
			filterInfo.getFilterItems().add(filterItemOrgInfo);
			filterInfo.setMaskString("#0 and #1");
			viewInfo.setFilter(filterInfo);
			IMaterialCost iMaterialCost = MaterialCostFactory
			.getLocalInstance(ctx);
			CoreBaseCollection materialCostCollection = iMaterialCost
			.getCollection(viewInfo);
			if (materialCostCollection != null
					&& materialCostCollection.size() > 0)
				return ((MaterialCostInfo) materialCostCollection.get(0))
				.getDefaultCostItem();
			else
				return costItemInfo;
		} else {
			return costItemInfo;
		}
	}
	public WarehouseInfo getMaterialInventory(Context ctx,
			CompanyOrgUnitInfo aCompanyOrgUnitInfo, MaterialInfo materialInfo)
	throws Exception {
		WarehouseInfo warehouserInfo = null;
		if (aCompanyOrgUnitInfo != null && materialInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemMaterialInfo = new FilterItemInfo("material", materialInfo.getId().toString(),CompareType.EQUALS);
			FilterItemInfo filterItemOrgInfo = new FilterItemInfo("CU",aCompanyOrgUnitInfo.getId().toString(), CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemMaterialInfo);
			filterInfo.getFilterItems().add(filterItemOrgInfo);
			filterInfo.setMaskString("#0 and #1");
			viewInfo.setFilter(filterInfo);
			IMaterialInventory iMaterialInventory = MaterialInventoryFactory.getLocalInstance(ctx);
			MaterialInventoryCollection materialCostCollection = iMaterialInventory.getMaterialInventoryCollection(viewInfo);
			if (materialCostCollection != null&& materialCostCollection.size() > 0){
				return materialCostCollection.get(0).getDefaultWarehouse();
			}else{
				return warehouserInfo;
			}	
		} else {
			return warehouserInfo;
		}
	}
	public CustomerSaleInfoInfo getCustomer(Context ctx,
			CompanyOrgUnitInfo aCompanyOrgUnitInfo, CustomerInfo customerInfo)
	throws Exception {
		CustomerSaleInfoInfo customerSaleInfo = null;
		if (aCompanyOrgUnitInfo != null && customerInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemMaterialInfo = new FilterItemInfo("customer", customerInfo.getId().toString(),CompareType.EQUALS);
			FilterItemInfo filterItemOrgInfo = new FilterItemInfo("CU",aCompanyOrgUnitInfo.getId().toString(), CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemMaterialInfo);
			filterInfo.getFilterItems().add(filterItemOrgInfo);
			filterInfo.setMaskString("#0 and #1");
			viewInfo.setFilter(filterInfo);
			ICustomerSaleInfo iCustomerSale = CustomerSaleInfoFactory.getLocalInstance(ctx);
			CustomerSaleInfoCollection CustomerCollection = iCustomerSale.getCustomerSaleInfoCollection(viewInfo);
			if (CustomerCollection != null&& CustomerCollection.size() > 0){
				return (CustomerSaleInfoInfo)CustomerCollection.get(0);
			}else{
				return customerSaleInfo;
			}	
		} else {
			return customerSaleInfo;
		}
	}
}

