package com.kingdee.eas.farm.stocking.hatch.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.cssp.ISupplier;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.ISettlementItem;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataFactory;
import com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataInfo;
import com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataPriceEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.hatch.EggPriceType;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyEntryPriceEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillCompanyInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType;
import com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;


public class StockingHatchFacadeControllerBeanCompany
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.StockingHatchFacadeControllerBean");
	private ArrayList<String> hasExeHatchBillList=new ArrayList<String>();
	private HashMap<String,ArrayList<String>> hasExeSaleEntryList=new HashMap<String,ArrayList<String>>();
	private ArrayList<String> hasExeSupplierIDAndLot=new ArrayList<String>();

	/**
	 * 获取蛋品关系
	 * @param ctx
	 * @param info
	 * @throws Exception
	 */
	private LinkedHashMap<String,SettlementItemInfo> getSettlementItem(Context ctx, String companyID) throws Exception {
		LinkedHashMap<String,SettlementItemInfo> result=new LinkedHashMap<String,SettlementItemInfo> ();
 
		ISettlementItem ies = SettlementItemFactory.getLocalInstance(ctx);

		StringBuffer sql=new StringBuffer();
		sql.append(" select tmain.fid ")
		.append(" from T_FM_SettlementItem tmain")
		.append(" inner join T_FM_SettlementIME tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.fcompanyid='").append(companyID).append("'")
		.append(" and tmain.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
		.append(" and (tmain.FSettleItemType=").append(SettleItemType.EGG_VALUE)
		.append(" or tmain.FSettleItemType=").append(SettleItemType.QCEGG_VALUE).append(")")
		.append(" order by tmain.fnumber,tmain.fcreatetime")
		;
		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("MaterialEntry.*");
		slor.add("MaterialEntry.material.*");
		while(rs.next()) {
			result.put(rs.getString("fid"), ies.getSettlementItemInfo(new ObjectUuidPK(rs.getString("fid")),slor));
		}
		return result;
	}

	/**
	 * 设置需结算的明细
	 * @param ctx
	 * @param info
	 * @throws Exception 
	 */
	private void getHatchDetail(Context ctx,EggSettleBillCompanyInfo info) throws Exception {
		//孵化场id
		String storageOrgUnitID=info.getStorageOrgUnit().getString("id");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String beginDateStr=sdf.format(info.getHatchBeginDate());
		String endDateStr=sdf.format(info.getHatchEndDate());
		String bizDateStr=sdf.format(info.getBizDate());
		String destCompanyId="";
		if(info.getDestCompany() != null){
			destCompanyId=info.getDestCompany().getId().toString();
		}
		String companyId=info.getCompany().getString("id");
		
		//获取出雏单
		StringBuffer sql=new StringBuffer();
		sql.append(" select tentry.cfsupplierID,tentry.CFSupplierLot,tentry.cfoutBatchID,tentry.CFBreedBatchID,sum(tentry.CFHatchQty) FHatchQty")
		.append(" from CT_FM_BHatchBabyBill tmain")
		.append(" inner join CT_FM_BHBBSE tentry on tentry.fparentid=tmain.fid")
		.append(" inner join CT_FM_HatchBaseData thbd on thbd.fid=tmain.CFHatchFactoryID")
		.append(" left join t_fm_stockingbatch tb on tb.fid=tentry.cfoutBatchID and tb.fcompanyID='").append(destCompanyId).append("'")
		.append(" left join CT_FM_ParentBreedBatch tpb on tpb.fid=tentry.CFBreedBatchID and tpb.FControlUnitID='").append(destCompanyId).append("'")
		.append(" where thbd.CFHatchFactoryID='").append(storageOrgUnitID).append("'")
		.append(" and tmain.fbizDate>={d '").append(beginDateStr).append("'}")
		.append(" and tmain.fbizDate<({d '").append(endDateStr).append("'}+1)")
		.append(" and tmain.CFBaseStatus=4");
		//外采
		if(info.getEggSource().equals(EggSourceType.Purchase)||info.getEggSource().equals(EggSourceType.PurchaseInstead))  {
			sql.append(" and tentry.cfsupplierID is not null")
			.append(" and exists (")
			// 种蛋结算政策，是结算价的政策
			.append(" select tentry2.fsupplierid")
			.append(" from T_FM_EggSettlePolicy tmain2")
			.append(" inner join T_FM_EggSettlePolicyRangeEntry tentry2 on tentry2.fparentid=tmain2.fid")
			.append(" where tmain2.fcompanyid='").append(companyId).append("'")
			.append(" and tmain2.fbegindate<={ d'").append(bizDateStr).append("'}")
			.append(" and tmain2.fenddate>={ d'").append(bizDateStr).append("'}")
			.append(" and tmain2.fbasestatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and tentry2.fsupplierid=tentry.cfsupplierID")
//			.append(" and tmain2.CFEggSettleType=").append(EggSettleType.SETTLEPRICE_VALUE)
			.append(" )");
			if(info.getSupplier()!=null) {
				sql.append(" and tentry.cfsupplierID='").append(info.getSupplier().getString("id")).append("'");
			}
		}
		//内采-放养
		if(info.getEggSource().equals(EggSourceType.InternalPurchase))  {
			sql.append(" and (tentry.CFOutBatchID is not null")
			.append(" or tentry.CFBreedBatchID is not null)")
			.append(" and (tb.fcompanyID='").append(destCompanyId).append("'")
			.append(" or tpb.FControlUnitID='").append(destCompanyId).append("')");
		}
		sql.append(" group by tentry.cfsupplierID,tentry.CFSupplierLot,tentry.cfoutBatchID,tentry.CFBreedBatchID");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.size()<=0) {
			return;
		}
		EggSettleBillCompanyEntryInfo entryInfo ;

//		IParentBreedBatch ipbs = ParentBreedBatchFactory.getLocalInstance(ctx);
//		ParentBreedBatchInfo pbInfo;
		IStockingBatch ibs = StockingBatchFactory.getLocalInstance(ctx);
		StockingBatchInfo bInfo;
		ISupplier iss = SupplierFactory.getLocalInstance(ctx);
		EggSettlePolicyInfo policyInfo=null;

		//结算项目map
		HashMap<String,SettlementItemInfo> settleItemMap = getSettlementItem(ctx, companyId);
		Iterator<Entry<String, SettlementItemInfo>> itr = settleItemMap.entrySet().iterator();
		SettlementItemInfo tempSettleItemInfo,settleItemInfo=null;
		while(itr.hasNext()) {
			tempSettleItemInfo=itr.next().getValue();
			if( tempSettleItemInfo.getSettleItemType().equals(SettleItemType.qcEgg)) {//getName().contains("合格蛋")
				settleItemInfo =tempSettleItemInfo;
				break;
			}
		}

		while(rs.next()) {
			//新增分录
			entryInfo = new EggSettleBillCompanyEntryInfo();

			entryInfo.setId(BOSUuid.create(entryInfo.getBOSType().toString()));
			entryInfo.setSettleItem(null);
//			if(StringUtils.isNotBlank(rs.getString("CFBreedBatchID"))) {
//				pbInfo = ipbs.getParentBreedBatchInfo(new ObjectUuidPK(rs.getString("CFBreedBatchID")));
//
//				entryInfo.setInternalBatch(pbInfo);
//				entryInfo.setInternalFarm(pbInfo.getFarm());
//				//				entryInfo.setInternalHouse(entryInfo.getHenhouse());
//			}
			if(StringUtils.isNotBlank(rs.getString("cfoutBatchID"))) {
				bInfo=ibs.getStockingBatchInfo(new ObjectUuidPK(rs.getString("cfoutBatchID")));

				entryInfo.setFarmer(bInfo.getFarmer());
				entryInfo.setFarm(bInfo.getFarm());
				//				entryInfo.setHouse(entryInfo.getStockingHouse());
				entryInfo.setStockingBatch(bInfo);
			}
			if(StringUtils.isNotBlank(rs.getString("cfsupplierID"))) {
				entryInfo.setSupplier(iss.getSupplierInfo(new ObjectUuidPK(rs.getString("cfsupplierID"))));
				entryInfo.setLot(rs.getString("CFSupplierLot"));
			}
			//			entryInfo.setSendDate(entryInfo.getSendDate());
			//			entryInfo.setWarehouse(entryInfo.getEggWarehouse());

			entryInfo.setSettleItem(settleItemInfo);
			entryInfo.setUnit(settleItemInfo!=null?settleItemInfo.getSettleUnit():null);//默认结算单位

			if((info.getEggSource().equals(EggSourceType.Purchase)||info.getEggSource().equals(EggSourceType.PurchaseInstead))&&entryInfo.getSupplier()!=null) {
				policyInfo=this.getEggSettlePolicyByID(ctx, companyId, info.getBizDate(), entryInfo.getSupplier().getString("id"));
			}
			if(info.getEggSource().equals(EggSourceType.InternalPurchase)&&StringUtils.isNotBlank(destCompanyId)) {//(entryInfo.getFarmer()!=null||entryInfo.getInternalFarm()!=null)
				policyInfo=this.getEggSettlePolicyByID(ctx, companyId, info.getBizDate(), destCompanyId);
			}
			if(policyInfo==null) {
				continue;
			}
			
			entryInfo.setPolicy(policyInfo);
			//代孵费
			entryInfo.setInsteadFee(policyInfo.getInsteadPrice());
			//上孵蛋数
			entryInfo.setHatchQty(rs.getInt("FHatchQty"));
			
//			setEggReceiveData(ctx, info, rs.getString("cfsupplierID"));
			
			info.getEntrys().add(entryInfo);
		}
	}

	/**
	 * 执行结算--孵化场
	 * @throws EASBizException 
	 */
	protected Object _exeEggSettleCompany(Context ctx, Object param) throws BOSException, EASBizException {
		EggSettleBillCompanyInfo info=(EggSettleBillCompanyInfo) param;
		hasExeHatchBillList.clear();
		hasExeSaleEntryList.clear();
		hasExeSupplierIDAndLot.clear();
		try {
			IEggSettleBillCompany ies = EggSettleBillCompanyFactory.getLocalInstance(ctx);
			if(info.getId()!=null&&ies.exists(new ObjectUuidPK(info.getId()))) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("company.*");
				slor.add("entrys.*");
				slor.add("entrys.settleItem.*");
				slor.add("entrys.farm.*");
				slor.add("entrys.PriceEntry.*");
				slor.add("entrys.PriceEntry.material.*");
				info=ies.getEggSettleBillCompanyInfo(new ObjectUuidPK(info.getId()),slor);
			}

			//总结算金额
			BigDecimal allAmount=BigDecimal.ZERO;
			BigDecimal amount=null;

			EggSettleBillCompanyEntryInfo entryInfo;

			info.getEntrys().clear();
			getHatchDetail(ctx, info);
			
			for(int index=0;index<info.getEntrys().size();index++) {
				entryInfo = info.getEntrys().get(index);
				amount=getEggPricePolicyCost(ctx, info, entryInfo);
				allAmount=allAmount.add(amount);

			}

			//设置总结算金额
			info.setAmount(allAmount);

			BigDecimal paymentAmount=info.getPaymentAmount();
			BigDecimal compensateAmount=info.getCompensateAmount();
			BigDecimal otherAmount=info.getOtherAmount();
			BigDecimal byProductAmount=info.getByProductAmount();

			if(amount==null) {
				amount=BigDecimal.ZERO;
			}
			if(paymentAmount==null) {
				paymentAmount=BigDecimal.ZERO;
			}
			if(compensateAmount==null) {
				compensateAmount=BigDecimal.ZERO;
			}
			if(otherAmount==null) {
				otherAmount=BigDecimal.ZERO;
			}
			if(byProductAmount==null) {
				byProductAmount=BigDecimal.ZERO;
			}
			info.setActualAmount(allAmount.subtract(paymentAmount).add(compensateAmount).subtract(otherAmount).subtract(byProductAmount));
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
		return info;
	}


	/**
	 * 获取 政策价格、金额
	 * @param ctx
	 * @param batchID
	 * @param farmerID
	 * @param houseID
	 * @return
	 * @throws BOSException 
	 */
	private BigDecimal getEggPricePolicyCost(Context ctx,EggSettleBillCompanyInfo info,EggSettleBillCompanyEntryInfo entryInfo) throws BOSException {
		try {
			entryInfo.setEggPriceType(EggPriceType.nonePrice);
			EggSettleBillCompanyEntryPriceEntryInfo detailInfo;
			//结算政策

			EggSettlePolicyInfo policyInfo = entryInfo.getPolicy();
			if(policyInfo==null) {
				return BigDecimal.ZERO;
			}

			BigDecimal price = BigDecimal.ZERO,amount=BigDecimal.ZERO,qty=BigDecimal.ZERO;
			//上孵数量
			qty=new BigDecimal(entryInfo.getHatchQty());
			/**
			 * *************合同价***************
			 */ 
			//上孵单日期
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String beginDateStr=sdf.format(info.getHatchBeginDate());
			String endDateStr=sdf.format(info.getHatchEndDate());
			//代孵费结算
			if(policyInfo.getEggSettleType().equals(EggSettlePolicyType.instead)) {
				amount=BigDecimal.ZERO;
				entryInfo.setEggPriceType(EggPriceType.insteadFee);
				if(policyInfo.getInsteadPrice()!=null){
					amount=policyInfo.getInsteadPrice().multiply(qty).setScale(2,BigDecimal.ROUND_HALF_UP);
				}
				entryInfo.setAmount(amount);
				entryInfo.setNum(qty.intValue());
				return amount;
			}
			//结算政策
			else if(policyInfo.getEggSettleType().equals(EggSettlePolicyType.policyPrice)) {

				//结算项目及单价-所有产品
				for(int index=0;index<policyInfo.getPolicyEntry().size();index++) {
					//结算项目和计量单位相等
					if(policyInfo.getPolicyEntry().get(index).getSettleItem().getString("id").equals(entryInfo.getSettleItem().getString("id"))
							&&policyInfo.getPolicyEntry().get(index).getUnit().getString("id").equals(entryInfo.getUnit().getString("id"))) {
						price=policyInfo.getPolicyEntry().get(index).getPrice();
						break;
					}
				}
				//设置结算金额
				if(price.signum()>0) {
					entryInfo.setEggPriceType(EggPriceType.policyPrice);
				}
				
				amount=BigDecimal.ZERO;
				if(price!=null&&entryInfo.getHatchQty()>0){
					amount=policyInfo.getInsteadPrice().max(new BigDecimal(entryInfo.getHatchQty()));
				}
				amount=price.multiply(qty).setScale(2,BigDecimal.ROUND_HALF_UP);

				entryInfo.setAmount(amount);
				entryInfo.setNum(qty.intValue());
				return amount;
				
			} 
			//合同价
			else if(policyInfo.getEggSettleType().equals(EggSettlePolicyType.contractPrice)) {
				amount=BigDecimal.ZERO;
				return amount;
			}
			//结算价结算
			else if(policyInfo.getEggSettleType().equals(EggSettlePolicyType.settlePrice)) {
				amount=BigDecimal.ZERO;
				return amount;
			}
			//苗价、代孵费
			else if(policyInfo.getEggSettleType().equals(EggSettlePolicyType.seedInsteadPrice)) {
				//副产品金额
//				BigDecimal otherProductAmount=BigDecimal.ZERO;

				//孵化场id
				String storageOrgUnitID=info.getStorageOrgUnit().getString("id");

				//销售订单获取sql --前后三天内数据
				StringBuffer saleOrderSql=new StringBuffer();
				saleOrderSql.append(" select tmain.fnumber,to_char(tmain.fbizDate,'yyyy-MM-dd') FBizDate,tentry.fid FEntryID,tentry.fseq,FMaterialID,")
				.append(" FTaxPrice,FAmount,cfhatchBillEntryIDs,cfhatchBillUsedEntryQty,cfhatchBillLossEntryQty,tentry.FQty FSaleQty ")
				.append(" from t_sd_saleorderEntry tentry ")
				.append(" inner join t_sd_saleOrder tmain on tmain.fid=tentry.fparentid")
				.append(" where tmain.FCompanyOrgUnitID='").append(info.getCompany().getString("id")).append("'")
				.append(" and tmain.fbizDate>=({d '").append(beginDateStr).append("'}-3)")
				.append(" and tmain.fbizDate<=({d '").append(endDateStr).append("'}+3)")
				.append(" and cfhatchBillEntryIDs like ?");

				String entryID;
				//获取出雏单
				StringBuffer sql=new StringBuffer();
				sql.append(" select tentry.fid fentryID")
				.append(" from CT_FM_BHatchBabyBill tmain")
				.append(" inner join CT_FM_BHBBSE tentry on tentry.fparentid=tmain.fid")
				.append(" inner join CT_FM_HatchBaseData thbd on thbd.fid=tmain.CFHatchFactoryID")
				.append(" where thbd.CFHatchFactoryID='").append(storageOrgUnitID).append("'")
				.append(" and tmain.fbizDate>={d '").append(beginDateStr).append("'}")
				.append(" and tmain.fbizDate<({d '").append(endDateStr).append("'}+1)")
				.append(" and tmain.CFBaseStatus=4");
				//外采
				if(info.getEggSource().equals(EggSourceType.Purchase)&&entryInfo.getSupplier()!=null)  {
					sql.append(" and tentry.cfsupplierID='").append(entryInfo.getSupplier().getString("id")).append("'");
					if(entryInfo.getLot()!=null) {
						sql.append(" and tentry.CFSupplierLog='").append(entryInfo.getLot()).append("'");
					}
				}
				//内采-放养
				else if((info.getEggSource().equals(EggSourceType.Purchase)||info.getEggSource().equals(EggSourceType.InternalPurchase))&&entryInfo.getStockingBatch()!=null)  {
					sql.append(" and tentry.CFOutBatchID='").append(entryInfo.getStockingBatch().getString("id")).append("'");
				}
				//内采--自养
				else if(entryInfo.getInternalBatch()!=null)  {
					sql.append(" and tentry.CFBreedBatchID='").append(entryInfo.getInternalBatch().getString("id")).append("'");
				}
				sql.append(" order by tmain.fnumber,tentry.fseq");
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				IRowSet rsSale;
				String tempEntryIDs;
				BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO,sumLossQty=BigDecimal.ZERO;
				String[] str;
				IMaterial ims = MaterialFactory.getLocalInstance(ctx);
				MaterialInfo mInfo;
				String entryIDs="";

				int sumSaleNums=0;//总枚数
				BigDecimal lossQty;
				HashMap<String,BigDecimal> tmpMaterialMap=new HashMap<String, BigDecimal>();//物料数量缓存
				while(rs.next()) {
					entryID=rs.getString("fentryID");
					if(entryIDs.length()>0) {
						entryIDs+=",";
					}
					entryIDs+="'"+entryID+"'";

					rsSale= DbUtil.executeQuery(ctx, saleOrderSql.toString(),new String[]{"%"+entryID+"%"});
					while(rsSale.next()) {
						tempEntryIDs=rsSale.getString("cfhatchBillEntryIDs");//出雏单分录ids

						if(tempEntryIDs.contains(entryID)) {
							str = tempEntryIDs.split(";");
							for(int i=0;i<str.length;i++) {
								if(str[i].equals(entryID)) {
									//金额累计
									qty=new BigDecimal(rsSale.getString("cfhatchBillUsedEntryQty").split(";")[i]);
									lossQty=BigDecimal.ZERO;
									if(StringUtils.isNotEmpty(rsSale.getString("cfhatchBillLossEntryQty"))) {
										lossQty=new BigDecimal(rsSale.getString("cfhatchBillLossEntryQty").split(";")[i]);
									}
									sumLossQty=sumLossQty.add(lossQty);

									sumQty=sumQty.add(qty);
									price=rsSale.getBigDecimal("FTaxPrice");
									
									amount=rsSale.getBigDecimal("FAmount");
//								    amount=price.multiply(qty).setScale(2, BigDecimal.ROUND_HALF_UP);金额改用实际值
									sumAmount=amount.add(sumAmount);
									
									sumSaleNums+=qty.intValue();

									detailInfo=new EggSettleBillCompanyEntryPriceEntryInfo();
									mInfo=ims.getMaterialInfo(new ObjectUuidPK(rsSale.getString("FMaterialID")));
									detailInfo.setMaterial(mInfo);
									detailInfo.setMaterialName(mInfo.getName());
									detailInfo.setModel(mInfo.getModel());
									detailInfo.setNum(qty.intValue());
									detailInfo.setQty(qty);
									detailInfo.setPrice(price);
									detailInfo.setAmount(amount);
									detailInfo.setLossQty(lossQty);
									detailInfo.setRemark("订单号:"+rsSale.getString("fnumber")+("(")+rsSale.getString("FbizDate")+"),分录:"+rsSale.getInt("fseq"));
//									entryInfo.getPriceEntry().add(detailInfo);
									BigDecimal tempSumQty=BigDecimal.ZERO;
									if(tmpMaterialMap.containsKey(mInfo.getString("id"))) {
										tempSumQty=tmpMaterialMap.get(mInfo.getString("id"));
									}
									tmpMaterialMap.put(mInfo.getString("id"),tempSumQty.add(qty));
									
//									continue;
								}
							}
						}
					}
				}
				
				
				if(StringUtils.isEmpty(entryIDs)) {
					entryIDs="'abcdqaz'";
				}

				//出雏单--上孵数量
				BigDecimal insteadQty=BigDecimal.ZERO;
				/*sql.setLength(0);
				sql.append(" select fparentid,CFOutBatchID,CFSupplierLot,isnull(sum(CFHatchQty),0) Fqty")
				.append(" from CT_FM_BHBBSE ")//出雏单
				.append(" where fid in (").append(entryIDs).append(")")
				.append(" ");
				if(entryInfo.getSupplier()!=null&&entryInfo.getLot()!=null) {
					sql.append(" and cfsupplierid='").append(entryInfo.getSupplier().getString("id")).append("'")
					.append(" and cfsupplierlog='").append(entryInfo.getLot()).append("'");
				}
				if(entryInfo.getStockingBatch()!=null) {
					sql.append(" and CFOutBatchID='").append(entryInfo.getStockingBatch().getString("id")).append("'");
				}
				if(entryInfo.getInternalBatch()!=null) {
					sql.append(" and CFBreedBatchID='").append(entryInfo.getInternalBatch().getString("id")).append("'");
				}

				sql.append(" ")
				.append(" group by fparentid,CFOutBatchID,CFSupplierLot");
				rs=DbUtil.executeQuery(ctx, sql.toString());
				String tempBatchID;
				while(rs.next()) {
					if(entryInfo.getStockingBatch()!=null) {
						tempBatchID=rs.getString("CFOutBatchID");
					}else{
						tempBatchID=rs.getString("CFOutBatchID");
					}
					insteadQty=insteadQty.add(rs.getBigDecimal("Fqty"));
					if(hasExeHatchBillList.contains(rs.getString("fparentid")+tempBatchID)) {
						continue;

					}
					hasExeHatchBillList.add(rs.getString("fparentid")+tempBatchID);
				}*/

				//代孵费
//				BigDecimal insteadAmount=BigDecimal.ZERO;
//				insteadAmount=(policyInfo.getInsteadPrice().multiply(insteadQty).multiply(new BigDecimal(-1))).setScale(2,BigDecimal.ROUND_HALF_UP);
//				detailInfo=new EggSettleBillCompanyEntryPriceEntryInfo();
//				detailInfo.setRemark("代孵费(负数扣减)");
//				detailInfo.setNum(insteadQty.intValue());
//				detailInfo.setQty(insteadQty);
//				detailInfo.setPrice(policyInfo.getInsteadPrice());
//				detailInfo.setAmount(insteadAmount);
//				entryInfo.getPriceEntry().add(detailInfo);
				//	        	}

				//销售费用
//				BigDecimal saleFeeAmount=BigDecimal.ZERO;
//				//苗差价
//				BigDecimal seedDiffAmount=BigDecimal.ZERO;
//				if(sumNums>0) {
//					BigDecimal saleFeePrice=policyInfo.getSaleFeePrice();
//					if(saleFeePrice==null) {
//						saleFeePrice=BigDecimal.ZERO;
//					}
//					saleFeeAmount=saleFeePrice.multiply(new BigDecimal(sumNums*(-1))).setScale(2,BigDecimal.ROUND_HALF_UP);
//					detailInfo=new EggSettleBillCompanyEntryPriceEntryInfo();
//					detailInfo.setRemark("销售费用(负数扣减)");
//					detailInfo.setNum(sumNums);
//					detailInfo.setQty(sumQty);
//					detailInfo.setPrice(saleFeePrice);
//					detailInfo.setAmount(saleFeeAmount);
//					entryInfo.getPriceEntry().add(detailInfo);
//
//					//苗差价
//					BigDecimal seedDiffPrice=policyInfo.getSeedDiffPrice();
//					if(seedDiffPrice==null)
//						seedDiffPrice=BigDecimal.ZERO;
//					seedDiffAmount=seedDiffPrice.multiply(new BigDecimal(sumNums*(-1))).setScale(2,BigDecimal.ROUND_HALF_UP);
//					detailInfo=new EggSettleBillCompanyEntryPriceEntryInfo();
//					detailInfo.setRemark("苗差价(负数扣减)");
//					detailInfo.setNum(sumNums);
//					detailInfo.setQty(sumQty);
//					detailInfo.setPrice(seedDiffPrice);
//					detailInfo.setAmount(seedDiffAmount);
//					entryInfo.getPriceEntry().add(detailInfo);
//				}
//
//				//路损
//				if(sumLossQty.signum()>0) {
//					detailInfo=new EggSettleBillCompanyEntryPriceEntryInfo();
//					detailInfo.setRemark("销售路损数量");
//					detailInfo.setNum(sumLossQty.intValue());
//					detailInfo.setQty(sumLossQty);
//					detailInfo.setPrice(BigDecimal.ZERO);
//					detailInfo.setAmount(BigDecimal.ZERO);
//					entryInfo.getPriceEntry().add(detailInfo);
//				}

//				entryInfo.setEggPriceType(EggPriceType.purSettlePrice);

//				sumAmount=sumAmount.add(insteadAmount).add(saleFeeAmount).add(seedDiffAmount);
				
//				insteadQty=BigDecimal.ZERO;
				
				BigDecimal seedAmount=BigDecimal.ZERO;
				String destId="";
				if(info.getEggSource().equals(EggSourceType.InternalPurchase)) {
					destId=info.getCompany().getString("id");//目标id
				}else {
					destId=info.getSupplier().getString("id");//目标id
				}
				InsteadSeedPriceDataInfo priceDataInfo = getInsteadSeedPriceDataInfo(ctx, info.getCompany().getString("id"),destId, info.getBizDate());
				if(priceDataInfo!=null) {
					Iterator<Entry<String, BigDecimal>> itr = tmpMaterialMap.entrySet().iterator();
					while(itr.hasNext()) {
						Entry<String, BigDecimal> tmp = itr.next();
						for(int index=0;index<priceDataInfo.getPriceEntry().size();index++) {
							InsteadSeedPriceDataPriceEntryInfo tmpEntryInfo = priceDataInfo.getPriceEntry().get(index);
							if(tmpEntryInfo.getMaterial().getString("id").equals(tmp.getKey())){
//								insteadQty=insteadQty.add(tmp.getValue());
								seedAmount=seedAmount.add(tmpEntryInfo.getPrice().multiply(tmp.getValue()));
								break;
							}
						}
					}
				}
				//设置为销售数量
				entryInfo.setQty(new BigDecimal(sumSaleNums));
				entryInfo.setNum(sumSaleNums);

				insteadQty=new BigDecimal(entryInfo.getHatchQty());
				//结算金额=鸭苗销售净数*苗报价-上孵蛋数*代孵费(元/枚)
				BigDecimal insteadPrice=entryInfo.getInsteadFee()!=null?entryInfo.getInsteadFee():BigDecimal.ZERO;
				sumAmount=seedAmount.subtract(insteadQty.multiply(insteadPrice));
				
				entryInfo.setAmount(sumAmount);
				
				entryInfo.setEggPriceType(EggPriceType.insteadSeedPrice);
				return sumAmount;
			}

		}catch(Exception err) {
			throw new BOSException(err);
		}
		return BigDecimal.ZERO;
	}


	/**
	 * 给分录明细设置价格
	 * @param entryInfo
	 * @param price
	 */
	private void setPriceDetailPrice(EggSettleBillCompanyEntryInfo entryInfo,BigDecimal price) {
		for(int index=0;index<entryInfo.getPriceEntry().size();index++) {
			entryInfo.getPriceEntry().get(index).setPrice(price);
			entryInfo.getPriceEntry().get(index).setAmount(entryInfo.getPriceEntry().get(index).getQty().multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}
	
	/**
	 * 获取苗报价
	 * @param ctx
	 * @param companyID
	 * @param supplier
	 * @param farmerID
	 * @return 
	 * @throws BOSException 
	 */
	private InsteadSeedPriceDataInfo getInsteadSeedPriceDataInfo(Context ctx,String companyID,String destId,Date bizDate) throws BOSException {
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
			StringBuffer sql=new StringBuffer();
			sql.append(" select tmain.fid")
			.append(" from CT_FM_InsteadSeedPriceData tmain")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tmain.FEffectDate<({ d'").append(sdf.format(bizDate)).append("'}+1)")
			.append(" and tmain.CFUnEffectDate>({ d'").append(sdf.format(bizDate)).append("'}-1)")
			.append(" and tmain.fbasestatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and exists (")
			.append(" select 1 from CT_FM_InsteadSPDR te where te.fparentid=tmain.fid and (te.CFCompanyID='").append(destId).append("' or CFSupplierID='").append(destId).append("')")
			.append(" )")
			.append(" order by CFUnEffectDate desc,FCreateTime desc");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				return InsteadSeedPriceDataFactory.getLocalInstance(ctx).getInsteadSeedPriceDataInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
		return null;
	}

	/**
	 * 通过供应商id或养殖场id获取相应的种蛋结算政策
	 * @param ctx
	 * @param companyID
	 * @param supplier
	 * @param farmerID
	 * @return 
	 */
	private EggSettlePolicyInfo getEggSettlePolicyByID(Context ctx,String companyID,Date bizDate,String destId) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			StringBuffer sql=new StringBuffer();
			sql.append(" select top 1 tmain.fid")
			.append(" from T_FM_EggSettlePolicy tmain")
			.append(" inner join T_FM_EggSettlePolicyRangeEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tmain.fbegindate<={ d'").append(sdf.format(bizDate)).append("'}")
			.append(" and tmain.fenddate>={ d'").append(sdf.format(bizDate)).append("'}")
			.append(" and tmain.fbasestatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and ( tentry.ffarmerid='").append(destId).append("'")
			.append(" or tentry.CFCompanyID='").append(destId).append("'")
			.append(" or tentry.fsupplierid='").append(destId).append("')")
			.append(" order by tmain.FCreateTime desc")
			.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("PolicyEntry.*");
				slor.add("RangeEntry.*");
				slor.add("SaleEntry.*");
				return EggSettlePolicyFactory.getLocalInstance(ctx).getEggSettlePolicyInfo(new ObjectUuidPK(rs.getString("fid")),slor);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}



}