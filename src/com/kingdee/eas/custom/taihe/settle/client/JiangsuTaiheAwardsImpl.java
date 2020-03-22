package com.kingdee.eas.custom.taihe.settle.client;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyFactory;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo;

/**
 * 江苏太合奖惩结算类
 * @author dai_andong
 *
 */
public class JiangsuTaiheAwardsImpl implements ISettleBillCal {
	protected SettleBillEditUI editUI;//结算单编辑界面
	private static BigDecimal stdAvtWgt=new BigDecimal(2);//标准只重
	/**
	 * 执行结算
	 */
	public void ExeCalSettleAmount(SettleBillEditUI settlebillEditUI) throws Exception {
		editUI=settlebillEditUI;
		calAwardAmt();//计算奖惩
	}
	/**
	 * 计算扣款标准
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	protected void calAwardAmt() throws BOSException, EASBizException {
		if(editUI.prmtsuccessiveContract.getValue()==null) {
			return;
		}
		
		
		ContractTypeInfo  contractTypeInfo=(ContractTypeInfo) editUI.prmtcontractType.getValue();
		if(contractTypeInfo==null) {
			return;
		}
		
		//直接取奖惩政策
		SettleAwardPolicyInfo tempInfo =(SettleAwardPolicyInfo) editUI.prmtawardsPolicy.getValue();
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("Entry.*");
		slor.add("AwardEntry.*");
		tempInfo=SettleAwardPolicyFactory.getRemoteInstance().getSettleAwardPolicyInfo(new ObjectUuidPK(tempInfo.getId()),slor);
		
		editUI.txtchargeStd.setValue(BigDecimal.ZERO);
		
		//保底合同
		if(contractTypeInfo.getString("id").equals(tempInfo.getFlooredContractType().getString("id"))) {
			BigDecimal floorPrice=UIRuleUtil.getBigDecimal(editUI.txtsafePrice.getBigDecimalValue());
			BigDecimal marketPrice=UIRuleUtil.getBigDecimal(editUI.txtmarketPrice.getBigDecimalValue());
			//保底价格大于市场价格
			if(floorPrice.compareTo(marketPrice)>0) {
				BigDecimal recyPrice=UIRuleUtil.getBigDecimal(editUI.txtpurchasePrice.getBigDecimalValue());//回收价
				BigDecimal inQty=UIRuleUtil.getBigDecimal(editUI.txtinQty.getBigDecimalValue());//合同数量
				BigDecimal qty=UIRuleUtil.getBigDecimal(editUI.txtqty.getBigDecimalValue());//实际数量
				BigDecimal avgWgt=UIRuleUtil.getBigDecimal(editUI.txtavgWgt.getBigDecimalValue());//实际平均只重
				BigDecimal addPrice=recyPrice.subtract(marketPrice);//加价=回收价-市场价

				BigDecimal amount=BigDecimal.ZERO;
				//超只扣罚金额=（回收只数-合同只数*95%）*平均只重*加价  单只重量计量单位为斤
				if(qty.compareTo(inQty)>0) {
					amount=qty.subtract(inQty).multiply(new BigDecimal(0.95)).multiply(avgWgt).multiply(addPrice);
					
					//超重  超重扣款=超出只重*（回收只数-超出只数）*加价。
					if(avgWgt.compareTo(stdAvtWgt)>0) {
						amount=amount.add(avgWgt.subtract(stdAvtWgt).multiply(qty.subtract(inQty)).multiply(addPrice)).divide(new BigDecimal(2),10,BigDecimal.ROUND_HALF_UP);
					}else {
						amount=amount.add(recyPrice.add(getChargeStd(tempInfo, avgWgt)));
					}
				}else {
					//超重扣款=超出只重*回收只数*加价 
					//超出只重=实际平均只重-标准平均只重     重量单位为斤
					//加价=回收价-市场价
					if(avgWgt.compareTo(stdAvtWgt)>0) {
						amount=amount.add(avgWgt.subtract(stdAvtWgt).multiply(qty).multiply(addPrice)).divide(new BigDecimal(2),10,BigDecimal.ROUND_HALF_UP);
					}
				}
				editUI.txtawardsAmount.setValue(amount.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
		}
		//保值合同
		else if(contractTypeInfo.getString("id").equals(tempInfo.getHedgingContractType().getString("id"))) {
			BigDecimal hedingPrice=editUI.txthedingPrice.getBigDecimalValue();
			if(hedingPrice==null) {
				hedingPrice=BigDecimal.ZERO;
			}
			BigDecimal markedPrice=editUI.txtmarketPrice.getBigDecimalValue();
			if(markedPrice==null) {
				markedPrice=BigDecimal.ZERO;
			}
			//市场价格>保值价格
			if(markedPrice.compareTo(hedingPrice)>0) {
				BigDecimal supplierProp=tempInfo.getSupplierProp();
				if(supplierProp==null) {
					supplierProp=BigDecimal.ZERO;
				}
				supplierProp=supplierProp.divide(new BigDecimal(100));
				BigDecimal price = hedingPrice.add(markedPrice.subtract(hedingPrice).multiply(supplierProp));
				editUI.txtpurchasePrice.setValue(price);
			}else {
				editUI.txtpurchasePrice.setValue(hedingPrice);
			}
		}
		
	}
	/**
	 * 获取扣款标准
	 * @return
	 */
	private BigDecimal getChargeStd(SettleAwardPolicyInfo tempInfo,BigDecimal avgWgt) {
		BigDecimal price=BigDecimal.ZERO;
		BigDecimal lowWgt,upperWgt;
		for(int index=0;index<tempInfo.getEntry().size();index++) {
			//重量范围内
			lowWgt=tempInfo.getEntry().get(index).getFloor();
			upperWgt=tempInfo.getEntry().get(index).getUp();
			
			if(lowWgt==null) {
				lowWgt=BigDecimal.ZERO;
			}
			if(upperWgt==null) {
				upperWgt=new BigDecimal(99999);
			}
			
			if(lowWgt.compareTo(avgWgt)<0&&upperWgt.compareTo(avgWgt)>=0) {
				price=tempInfo.getEntry().get(index).getAmt();
				break;
			}
		}
		if(price==null) {
			price=BigDecimal.ZERO;
		}
		//扣款标准
		return price;
	}
}
