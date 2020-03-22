package com.kingdee.eas.custom.taihe.workshopmanager.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBill;
import com.kingdee.eas.custom.taihe.workshopmanager.ILoadingBillEntry;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryFactory;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryInfo;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillFactory;
import com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillInfo;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlBotpCommUtils;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.ISaleIssueBill;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class LoadingBillFacadeControllerBean extends AbstractLoadingBillFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.workshopmanager.app.LoadingBillFacadeControllerBean");
    
    /**
     * 下载单据
     */
    protected String _downloadData(Context ctx, String jsonStr)throws BOSException
    {
    	
    	JSONObject json=JSONObject.fromObject(jsonStr);
    	String number=json.getString("billNumber");
    	json.clear();
    	JSONObject result=new JSONObject();
    	result.put("result", "0");
    	result.put("message", "success");
    	
    	try {
			if(!PermissionFactory.getLocalInstance(ctx).hasFunctionPermission(new ObjectUuidPK(ContextUtil.getCurrentUserInfo(ctx).getId()),new ObjectUuidPK(ContextUtil.getCurrentCtrlUnit(ctx).getId()), "THLoadingBillMobileQuery")) {
				result.put("result", "1");
				result.put("message", "您没有该业务功能权限！");
				return result.toString();
			}
		} catch (Exception e1) {
			result.put("result", "1");
			result.put("message",e1.getMessage());
			return result.toString();
		}
    	
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select tbill.fid,tbill.fnumber,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,")
    	.append(" tcus.fnumber FCustomerNum,tcus.Fname_l2 FCustomerName,")
    	.append(" tentry.fid FEntryID,tentry.FSeq,tm.fid FMaterialID,tm.fnumber FMaterialNum,")
    	.append(" tm.fname_l2 FMaterialName,tm.fmodel,tu.fid FUnitID,tu.fname_l2 FUnitName,tentry.fqty,")
    	.append(" tua.fid FAssistUnitID,tua.fname_l2 FAsstUnitName,isnull(tentry.FAssistQty,0) FAssistQty,tbill.CFIsUpWeight,")
    	.append(" tbill.fbaseStatus")
    	.append(" from t_sd_saleOrder tbill")
    	.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FOrderCustomerID")
    	.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tbill.fid")
    	.append(" inner join t_bd_material tm  on tm.fid=tentry.fmaterialid")
    	.append(" inner join t_bd_measureunit tu on tu.fid=tentry.FUnitID");
    	if(number.contains("-")){
    		 sql.append(" left join t_bd_measureunit tua on tua.fid=tentry.FAssistUnitID")
    	    	.append(" where tbill.fnumber like '%").append(number).append("%'")
//    	    	.append(" and tbill.FBaseStatus=4")//是否需要审核才可以扫码
    	    	.append(" order by tbill.fid,tentry.fseq");
    	}else{
    		 sql.append(" left join t_bd_measureunit tua on tua.fid=tentry.FAssistUnitID")
    	    	.append(" where tbill.CFlicensePlateNum like '%").append(number).append("%'")
    	    	//.append(" and tbill.FBaseStatus=4")//是否需要审核才可以扫码
    	    	.append(" and to_char(tbill.FbizDate,'yyyy-MM-dd') = to_char(sysdate,'yyyy-MM-dd') ")//是否需要审核才可以扫码
    	    	.append(" order by tbill.fid,tentry.fseq");
    	}
    	
    	 
    	 
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	JSONArray ja=new JSONArray();
    	BigDecimal qty=BigDecimal.ZERO;
    	JSONObject jo,tempJO;
    	JSONArray tempJA;
    	try {
			while(rs.next()) {
				if(rs.getInt("fbaseStatus")<BillBaseStatusEnum.AUDITED_VALUE) {
					throw new Exception("该订单尚未审核!");
				}
				if(rs.getInt("fbaseStatus")>BillBaseStatusEnum.AUDITED_VALUE) {
					throw new Exception("该订单已经关闭!");
				}
//				qty=rs.getBigDecimal("FAssistQty").subtract(getHasLoadingQty(ctx, rs.getString("FEntryID"), "FAssitQty"));
				if(qty.signum()<=0){
//					continue;
				}
				
				if(rs.getRow()==1) {
					json=new JSONObject();
					json.put("billID", rs.getString("fid"));
					json.put("billNumber", rs.getString("fnumber"));
					json.put("bizDate", rs.getString("FbizDate"));
					json.put("customerNum", rs.getString("FCustomerNum"));
					json.put("customerName", rs.getString("FCustomerName"));
					json.put("IsUpWeight", rs.getString("CFIsUpWeight"));
				}
					
				jo=new JSONObject();
				jo.put("entryID", rs.getString("FEntryID"));
				jo.put("entrySeq", rs.getString("FSeq"));
				jo.put("materialID", rs.getString("FMaterialID"));
				jo.put("materialNum", rs.getString("FMaterialNum"));
				jo.put("materialName", rs.getString("FMaterialName"));
				jo.put("model", rs.getString("fmodel"));
//				tempJO.put("unitName", rs.getString("FUnitName"));
//				tempJO.put("qty", rs.getString("fqty"));
				//返回辅助数量
				jo.put("unitName", rs.getString("FAsstUnitName"));
				jo.put("qty",qty);
				
				//加入多单位选择
				tempJA=new JSONArray();
				tempJO=new JSONObject();
				tempJO.put("unitID", rs.getString("FAssistUnitID"));
				tempJO.put("unitName", rs.getString("FAsstUnitName"));
				tempJO.put("qty", BigDecimal.ZERO);
				tempJO.put("existQty", getHasLoadingQty(ctx, rs.getString("FEntryID"), "FAssitQty"));
				tempJA.add(tempJO);
				tempJO=new JSONObject();
				tempJO.put("unitID", rs.getString("FUnitID"));
				tempJO.put("unitName", rs.getString("FUnitName"));
				tempJO.put("qty", BigDecimal.ZERO);
				tempJO.put("existQty", getHasLoadingQty(ctx, rs.getString("FEntryID"), "FQty"));
				tempJA.add(tempJO);
				
				jo.put("detail", tempJA);
				
				ja.add(jo);
			}
			json.put("entrys", ja);
		} catch (Exception e) {
			result.put("result", "1");
			result.put("message", e.getMessage());
		}
		result.put("data", json);
		System.out.println(result.toString());
		return result.toString();
    }
    
    /**
     * 上传单据
     */
    protected String _uploadData(Context ctx, String jsonStr)throws BOSException
    {
    	SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println("装货单上传开始:"+dd.format(new Date()));
    	JSONObject result=new JSONObject();
    	result.put("result", "0");
    	result.put("message", "success");
    	
    	try {
			if(!PermissionFactory.getLocalInstance(ctx).hasFunctionPermission(new ObjectUuidPK(ContextUtil.getCurrentUserInfo(ctx).getId()),new ObjectUuidPK(ContextUtil.getCurrentCtrlUnit(ctx).getId()), "THLoadingBillMobileAddNew")) {
				result.put("result", "1");
				result.put("message", "您没有该业务功能权限！");
				return result.toString();
			}
		} catch (Exception e1) {
			result.put("result", "1");
			result.put("message",e1.getMessage());
			return result.toString();
		}
    	
    	JSONObject json=JSONObject.fromObject(jsonStr);
    	String billID=json.getString("billID");
    	
    	SaleOrderInfo saleInfo;
		try {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("entries.*");
			slor.add("entries.material.*");
			slor.add("entries.unit.*");
			slor.add("entries.assistUnit.*");
			saleInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(billID),slor);
			String companyID="";
			if(saleInfo.getCompanyOrgUnit()!=null) {
				companyID=saleInfo.getCompanyOrgUnit().getString("id");
			}
			//校验数量是否超出
			
			JSONArray ja=json.getJSONArray("entrys");
			String entryID,unitName;
			BigDecimal hasLoadingQty,tempQty;
			StringBuffer msg=new StringBuffer();
			BigDecimal qty,orderQty;
			BigDecimal coeff;
			IMeasureUnit ius = MeasureUnitFactory.getLocalInstance(ctx);
			for(int j=0;j<ja.size();j++) {
				json=ja.getJSONObject(j);
				entryID=json.getString("entryID");
				for(int k=0;k<saleInfo.getEntries().size();k++) {
					if(saleInfo.getEntries().get(k).getString("id").equals(entryID)) {
						//原始数量（辅助数量）
						if(json.containsKey("realQty")) {
							qty=new BigDecimal(json.getString("realQty"));
						}else {
							qty=BigDecimal.ZERO;
						}
						if(qty.signum()<=0) {
							continue;
						}
						orderQty=BigDecimal.ZERO;
						//新功能，包含计量单位
						if(json.containsKey("unitID")&&json.getString("unitID").equals(saleInfo.getEntries().get(k).getUnit().getString("id"))) {
							orderQty=saleInfo.getEntries().get(k).getQty();
							hasLoadingQty=getHasLoadingQty(ctx, entryID,"FQty");
							unitName=saleInfo.getEntries().get(k).getUnit().getName();
						}else{ 
							if(saleInfo.getEntries().get(k).getAssistUnit()!=null&&saleInfo.getEntries().get(k).getAssistQty()!=null) {
								orderQty=saleInfo.getEntries().get(k).getAssistQty();
								hasLoadingQty=getHasLoadingQty(ctx,entryID, "FAssitQty");
								unitName=saleInfo.getEntries().get(k).getAssistUnit().getName();
							}else {
								orderQty=saleInfo.getEntries().get(k).getQty();
								hasLoadingQty=getHasLoadingQty(ctx, entryID,"FQty");
								unitName=saleInfo.getEntries().get(k).getUnit().getName();
							}
						}
						
						if(orderQty==null) {
							orderQty=BigDecimal.ZERO;
						}
						
						tempQty=qty.add(hasLoadingQty).subtract(orderQty.multiply(getBeyongRate(ctx,companyID)));
						if(tempQty.signum()>0) {
							msg.append("物料"+saleInfo.getEntries().get(k).getMaterial().getName()
									+"数量超出订单"+tempQty+"("+unitName+")！\n");
							break;
						}
					}
				}
			}

			
			if(msg.length()>0) {
				result.put("result", "1");
		    	result.put("message",msg.toString());
		    	return result.toString();
			}
			
			//德翔需求修改 单个订单多次提交 在一个装货单中累加数据
			//生成装货单并反写数量
			String fid = getHasLoading(ctx,saleInfo.getId().toString());
			if(fid!=null){
				LoadingBillInfo info;
				BigDecimal assitQty;
				ILoadingBill ils = LoadingBillFactory.getLocalInstance(ctx);
				info = ils.getLoadingBillInfo(new ObjectUuidPK(fid));
				for(int i=0;i<info.getEntry().size();i++){
					LoadingBillEntryInfo infoentry = info.getEntry().get(i);
					for(int j=0;j<ja.size();j++) {
						json=ja.getJSONObject(j);
						if(json.getString("entryID").equals(infoentry.getSrcEntryID())
					      &&json.getString("materialID").equals(infoentry.getMaterial().getString("id"))
							){
							
							if(json.containsKey("realQty")) {
								qty=new BigDecimal(json.getString("realQty"));
							}else {
								qty=BigDecimal.ZERO;
							}
							//新功能，包含计量单位
							if(json.containsKey("unitID")&&json.getString("unitID").equals(infoentry.getSrcEntryID())) {
								infoentry.setQty(qty);
								infoentry.setBaseQty(qty);
								qty=qty.add(getHasLoadingQty(ctx,json.getString("entryID"),"FQty"));
								if(infoentry.getAssitUnit()!=null) {
									coeff=ius.getMeasureUnitInfo(new ObjectUuidPK(infoentry.getAssitUnit().getId())).getCoefficient();
									assitQty=null;
									if(coeff!=null&&coeff.signum()>0) {
										assitQty=qty.divide(coeff,4, BigDecimal.ROUND_HALF_UP);
									}
									infoentry.setAssitQty(assitQty);
								}
								//*********************
							}else {
								//*****************得到的数量是辅助数量
								qty=qty.add(getHasLoadingQty(ctx,json.getString("entryID"),"FAssitQty"));
								assitQty=qty;
								infoentry.setAssitQty(assitQty);
								if(infoentry.getAssitUnit()!=null) {
									coeff=ius.getMeasureUnitInfo(new ObjectUuidPK(infoentry.getAssitUnit().getId())).getCoefficient();
									if(coeff!=null&&coeff.signum()>0) {
										qty=assitQty.multiply(coeff).setScale(4, BigDecimal.ROUND_HALF_UP);
									}
									infoentry.setQty(qty);
									infoentry.setBaseQty(qty);
								}
								//*********************
							}
							
							
							
							
						}else{
							
							
						}
						
					}
					
					
				}
				ils.submit(info);
				updateSale(ctx,info);
				
			}else{
			CoreBillBaseCollection destCols=createToLoadingBill(ctx, saleInfo);
			LoadingBillInfo info;
			BigDecimal taxPrice,price,allAmount,amount,assitQty;
			ILoadingBill ils = LoadingBillFactory.getLocalInstance(ctx);
			IMaterialInventory imis = MaterialInventoryFactory.getLocalInstance(ctx);
			String orgID="";
			MaterialInventoryInfo mInvInfo;
			for(int index=0;index<destCols.size();index++) {
				info=(LoadingBillInfo) destCols.get(index);
				if(info.getStorageOrgUnit()!=null) {
					if(info instanceof IObjectValue) {
						orgID=info.getStorageOrgUnit().getString("id");
					}else {
						orgID=info.toString();
					}
				}else if(info.getCompany()!=null) {
					orgID=info.getCompany().getString("id");
				}
				for(int j=0;j<ja.size();j++) {
					json=ja.getJSONObject(j);
					for(int k=0;k<info.getEntry().size();) {
						//分录相等
						if(json.getString("entryID").equals(info.getEntry().get(k).getSrcEntryID())
						&&	json.getString("materialID").equals(info.getEntry().get(k).getMaterial().getString("id"))
						) {
							if(json.containsKey("realQty")) {
								qty=new BigDecimal(json.getString("realQty"));
							}else {
								qty=BigDecimal.ZERO;
							}
							
//							//删除为0的行
//							if(qty.signum()<=0) {
//								info.getEntry().removeObject(k);
//								continue;
//							}

							//新功能，包含计量单位
							if(json.containsKey("unitID")&&json.getString("unitID").equals(saleInfo.getEntries().get(k).getUnit().getString("id"))) {
								info.getEntry().get(k).setQty(qty);
								info.getEntry().get(k).setBaseQty(qty);
								
								if(info.getEntry().get(k).getAssitUnit()!=null) {
									coeff=ius.getMeasureUnitInfo(new ObjectUuidPK(info.getEntry().get(k).getAssitUnit().getId())).getCoefficient();
									assitQty=null;
									if(coeff!=null&&coeff.signum()>0) {
										assitQty=qty.divide(coeff,4, BigDecimal.ROUND_HALF_UP);
									}
									info.getEntry().get(k).setAssitQty(assitQty);
								}
								//*********************
							}else {
								//*****************得到的数量是辅助数量
								assitQty=qty;
								info.getEntry().get(k).setAssitQty(assitQty);
								if(info.getEntry().get(k).getAssitUnit()!=null) {
									coeff=ius.getMeasureUnitInfo(new ObjectUuidPK(info.getEntry().get(k).getAssitUnit().getId())).getCoefficient();
									if(coeff!=null&&coeff.signum()>0) {
										qty=assitQty.multiply(coeff).setScale(4, BigDecimal.ROUND_HALF_UP);
									}
									info.getEntry().get(k).setQty(qty);
									info.getEntry().get(k).setBaseQty(qty);
								}
								//*********************
							}
							
							taxPrice=info.getEntry().get(k).getTaxPrice();
							if(taxPrice==null) {
								taxPrice=BigDecimal.ZERO;
							}
							price=info.getEntry().get(k).getPrice();
							if(price==null) {
								price=BigDecimal.ZERO;
							}
							allAmount=taxPrice.multiply(qty).setScale(2,BigDecimal.ROUND_HALF_UP);
							amount=price.multiply(qty).setScale(2,BigDecimal.ROUND_HALF_UP);
							info.getEntry().get(k).setAllAmount(allAmount);
							info.getEntry().get(k).setAmount(amount);
							info.getEntry().get(k).setTaxAmount(allAmount.subtract(amount));
							try {
								mInvInfo = imis.getMaterialInventoryInfo("where orgUnit.id='"+orgID+"' and material.id='"+info.getEntry().get(k).getMaterial().getString("id")+"'");
								if(mInvInfo!=null) {
									info.getEntry().get(k).setWarehouse(mInvInfo.getDefaultWarehouse());
								}
							}catch(Exception err) {
								err.printStackTrace();
							}
						}
						//手工行+1
						k++;
					}
				}
				info.setBillStatus(BillBaseStatusEnum.AUDITED);
				//设置编码
				if(StringUtils.isBlank(info.getNumber())) {
					try {
						info.setNumber(WlhlBotpCommUtils.getAutoCode(ctx, info, orgID));
					}catch(Exception err) {
						err.printStackTrace();
					}
				}
				ils.submit(info);
				updateSale(ctx,info);
//				//生成销售出库单
				//createToSaleIssueBill(ctx, info);
			}
			
			}
			
		} catch (Exception e) {
			result.put("result", "1");
	    	result.put("message",e.getMessage());
		}
		System.out.println("装货单上传结束:"+dd.format(new Date()));
        return result.toString();
    }
    
    private void updateSale(Context ctx, LoadingBillInfo info) {
		// TODO Auto-generated method stub
    	for(int i=0;i<info.getEntry().size();i++){
    		String srcEntryId,TatleAsQty,TatleBaQty;
    		srcEntryId = info.getEntry().get(i).getSrcEntryID();
    		TatleAsQty = info.getEntry().get(i).getAssitQty().toString();
    		TatleBaQty = info.getEntry().get(i).getBaseQty().toString();
    		if(srcEntryId!=null&&TatleAsQty!=null&&TatleBaQty!=null){
        		String sql = "update T_SD_SaleOrderEntry set CFTotalShipmentAsQty = '"+TatleAsQty+"',CFTotalShipmentQty= '"+TatleBaQty+"' where fid = '"+srcEntryId+"'";
        		try {
					DbUtil.execute(ctx,sql);
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    		}
    	}
	}

	private String getHasLoading(Context ctx, String string) {
		// TODO Auto-generated method stub
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select FID  from T_WOR_LoadingBill")
    	.append(" where FSrcBillID=?")
    	.append(" ");
    	IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{string});
			if(rs.next()) {
				return rs.getString("FID");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}

	/**
     * 获取允许超出系数
     * @param ctx
     * @param obj
     * @return
     */
    private BigDecimal getBeyongRate(Context ctx,String companyID) {
    	try {
	    	StringBuffer sql=new StringBuffer();
	    	sql.append(" select 1+(isnull(FBeyondRate,0)/100) FBeyondRate from T_WOR_WorkshopDeafultSetting")
	    	.append(" where FCompanyID='").append(companyID).append("'")
	    	.append(" and FBaseStatus=").append(UsedStatusEnum.APPROVED_VALUE)
	    	;
	    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
	    	if(rs.next()) {
	    		return rs.getBigDecimal("FBeyondRate");
	    	}
    	}catch(Exception err) {
    		err.printStackTrace();
    	}
    	return BigDecimal.ONE;
    }
    
    /**
     * 获取已经装货的数量
     * @param ctx
     * @param entryID
     * @return
     * @throws BOSException 
     */
    private BigDecimal getHasLoadingQty(Context ctx,String entryID,String colName) throws BOSException {
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select isnull(sum(").append(colName).append("),0) FQty from T_WOR_LoadingBillEntry")
    	.append(" where FSrcEntryID=?")
    	.append(" ");
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{entryID });
    	try {
			if(rs.next()) {
				return rs.getBigDecimal("FQty");
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
    	return BigDecimal.ZERO;
    }
    
    /**
     * 生成装货单
     * @param ctx
     * @param info
     */
    private CoreBillBaseCollection createToLoadingBill(Context ctx,CoreBillBaseInfo info) throws BOSException {
    	try {
    		//装货单
    		String destBillType="BEDBE401";
    		WlhlBotpCommUtils btpIS = WlhlBotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCU();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			CoreBillBaseCollection destCols=new CoreBillBaseCollection();
			for(int index=0;index<btpCols.size();index++) {
				destCols.add( btpIS.createToBill(ctx, info,destBillType, btpCols.get(index)));
			}
			return destCols;
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
    
    /**
     * 生成销售出库单
     * @param ctx
     * @param info
     */
    private CoreBillBaseCollection createToSaleIssueBill(Context ctx,CoreBillBaseInfo info) throws BOSException {
    	try {
    		//装货单
    		String destBillType="CC3E933B";
    		WlhlBotpCommUtils btpIS = WlhlBotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCU();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			CoreBillBaseCollection destCols=new CoreBillBaseCollection();
			for(int index=0;index<btpCols.size();index++) {
				destCols.add( btpIS.createToBill(ctx, info,destBillType, btpCols.get(index)));
			}
			return destCols;
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }

	@Override
	protected String _queryData(Context ctx, String jsonStr) throws BOSException {
		JSONObject result=new JSONObject();
    	result.put("result", "0");
    	result.put("message", "success");
    	
    	try {
			if(!PermissionFactory.getLocalInstance(ctx).hasFunctionPermission(new ObjectUuidPK(ContextUtil.getCurrentUserInfo(ctx).getId()),new ObjectUuidPK(ContextUtil.getCurrentCtrlUnit(ctx).getId()), "THLoadingBillMobileQuery")) {
				result.put("result", "1");
				result.put("message", "您没有该业务功能权限！");
				return result.toString();
			}
		} catch (Exception e1) {
			result.put("result", "1");
			result.put("message",e1.getMessage());
			return result.toString();
		}
    	
    	JSONObject json=JSONObject.fromObject(jsonStr);
    	//查询类型
    	String queryType=json.containsKey("queryType")?json.getString("queryType"):null;
    	String billNum=json.containsKey("billNum")?json.getString("billNum"):null;
    	String billID=json.containsKey("billID")?json.getString("billID"):null;
    	String beginDate=json.containsKey("beginDate")?json.getString("beginDate"):null;
    	String endDate=json.containsKey("endDate")?json.getString("endDate"):null;
    	String userNum=json.containsKey("userNum")?json.getString("userNum"):null;
    	if(StringUtils.isEmpty(userNum)) {
    		result.put("result", "1");
        	result.put("message", "用户不能为空！");
        	return result.toString();
    	}
    	Boolean isNeedSum=json.containsKey("isNeedSum")?json.getBoolean("isNeedSum"):false;
    	try {
	    	JSONArray ja=new JSONArray();
	    	//查询明细
	    	if(StringUtils.isEmpty(queryType)) {
	    		ja=queryDataData(ctx, billID,billNum, userNum, beginDate, endDate, isNeedSum);
	    	}
	    	//查询列表
	    	else {
	    		if(queryType.equalsIgnoreCase("list")) {
	    			ja=queryListData(ctx, billNum, userNum, beginDate, endDate, isNeedSum);
	    		}else {
	
	    			ja=queryDataData(ctx, billID,billNum, userNum, beginDate, endDate, isNeedSum);
	    		}
	    	}
			result.put("data", ja);
    	}catch(Exception err){
    		result.put("result", "1");
        	result.put("message",err.getMessage());
    	}
		return result.toString();
	}
	
	private JSONArray queryListData(Context ctx,String billNum,String userNum,String beginDate,String endDate,boolean isNeedSum) throws BOSException {
    	if(StringUtils.isEmpty(endDate)||StringUtils.isEmpty(beginDate)) {
    		throw new BOSException( "开始和结束日期不能为空！");
    	}
		
		JSONArray ja=new JSONArray();
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct tsale.fid,tsale.fnumber,to_char(tsale.FbizDate,'yyyy-MM-dd') FBizDate,")
		.append(" tcus.fnumber FCustomerNum,tcus.fname_l2 FCustomerName,tsale.CFLICENSEPLATENUM FCarNum,")
		.append(" tsale.CFFinishLoading")
    	.append(" from T_WOR_LoadingBill tbill ")
    	.append(" inner join t_pm_user tuser on tuser.fid=tbill.fcreatorID")
    	.append(" inner join t_sd_saleOrder tsale on tsale.fid=tbill.FSrcBillID")
    	.append(" left join t_bd_customer tcus on tcus.fid=tbill.fcustomerid")
    	.append(" where 1=1")
    	.append(" and tuser.fnumber='").append(userNum).append("'")
    	.append(" and tbill.fbizDate>={ ts '").append(beginDate).append(" 00:00:00'}")
    	.append(" and tbill.fbizDate<({ ts '").append(endDate).append(" 00:00:00'}+1)");
    	if(StringUtils.isNotBlank(billNum)) {
    		sql.append(" and tsale.fnumber like'%").append(billNum).append("%'");
    	}
    	sql.append(" order by tsale.fnumber");
		;
    	try {
    		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    		JSONObject tempJO=new JSONObject();
			while(rs.next()) {
				tempJO.put("billID", rs.getString("fid"));
				tempJO.put("billNum", rs.getString("fnumber"));
				tempJO.put("bizDate", rs.getString("FBizDate"));
				tempJO.put("customerNum", rs.getString("FCustomerNum"));
				tempJO.put("customerName", rs.getString("fcustomerName"));
				tempJO.put("carNum", rs.getString("FCarNum"));
				tempJO.put("isFinishLoading", rs.getBoolean("CFFinishLoading")?"1":"0");
				ja.add(tempJO);
			}
    	}catch(Exception err) {
    		throw new BOSException(err);	
		}
		return ja;
	}
	
	private JSONArray queryDataData(Context ctx,String billID,String billNum,String userNum,String beginDate,String endDate,boolean isNeedSum) throws BOSException {
		StringBuffer sql=new StringBuffer();
    	if(!isNeedSum) {
	    	sql.append(" select tsale.fnumber,tcus.fname_l2 fcustomerName,tm.fnumber FMaterialNum,tm.fname_l2 FMaterialName,tm.fmodel,")
	    	.append(" tunit.fname_l2 funitName,tentry.fqty,tua.fname_l2 FAssitUnitName,isnull(tentry.FAssitQty,0) FAssistQty,")
	    	.append(" tentry.fid FEntryID")
	    	.append(" from T_WOR_LoadingBill tbill ")
	    	.append(" inner join t_sd_saleOrder tsale on tsale.fid=tbill.FSrcBillID")
	    	.append(" inner join t_pm_user tuser on tuser.fid=tbill.fcreatorID")
	    	.append(" left join t_bd_customer tcus on tcus.fid=tbill.fcustomerid")
	    	.append(" inner join T_WOR_LoadingBillEntry tentry on tentry.fparentid=tbill.fid")
	    	.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
	    	.append(" inner join t_bd_measureUnit tunit on tunit.fid=tentry.funitid")
	    	.append(" left join t_bd_measureunit tua on tua.fid=tentry.FAssitUnitID")
	    	.append(" where 1=1")
	    	.append(" and tentry.FQty>0")
	    	.append(" and tuser.fnumber='").append(userNum).append("'");
	    	if(StringUtils.isNotBlank(billID)) {
	    		sql.append(" and tsale.fid='").append(billID).append("'");
	    	}
	    	if(StringUtils.isNotBlank(beginDate)) {
		    	sql.append(" and tbill.fbizDate>={ ts '").append(beginDate).append(" 00:00:00'}");
	    	}	
	    	if(StringUtils.isNotBlank(endDate)) {
		    	sql.append(" and tbill.fbizDate<({ ts '").append(endDate).append(" 00:00:00'}+1)");
	    	}
	    	if(StringUtils.isNotBlank(billNum)) {
	    		sql.append(" and tsale.fnumber like'%").append(billNum).append("%'");
	    	}
	    	sql.append(" order by tsale.fnumber,tbill.fcreatetime desc,tbill.fnumber,tentry.fseq");
    	}else{
    		sql.append(" select tsale.fnumber,tcus.fname_l2 fcustomerName,tm.fnumber FMaterialNum,tm.fname_l2 FMaterialName,tm.fmodel,")
	    	.append(" tunit.fname_l2 funitName,sum(tentry.fqty) FQty,tua.fname_l2 FAssitUnitName,sum(tentry.FAssitQty) FAssistQty,")
	    	.append(" '' FEntryID")
	    	.append(" from T_WOR_LoadingBill tbill ")
    		.append(" inner join t_sd_saleOrder tsale on tsale.fid=tbill.FSrcBillID")
	    	.append(" inner join t_pm_user tuser on tuser.fid=tbill.fcreatorID")
	    	.append(" left join t_bd_customer tcus on tcus.fid=tbill.fcustomerid")
	    	.append(" inner join T_WOR_LoadingBillEntry tentry on tentry.fparentid=tbill.fid")
	    	.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
	    	.append(" inner join t_bd_measureUnit tunit on tunit.fid=tentry.funitid")
	    	.append(" left join t_bd_measureunit tua on tua.fid=tentry.FAssitUnitID")
	    	.append(" where 1=1")
	    	.append(" and tentry.FQty>0")
	    	.append(" and tuser.fnumber='").append(userNum).append("'");
    		if(StringUtils.isNotBlank(billID)) {
	    		sql.append(" and tsale.fid='").append(billID).append("'");
	    	}
	    	if(StringUtils.isNotBlank(beginDate)) {
		    	sql.append(" and tbill.fbizDate>={ ts '").append(beginDate).append(" 00:00:00'}");
	    	}	
	    	if(StringUtils.isNotBlank(endDate)) {
		    	sql.append(" and tbill.fbizDate<({ ts '").append(endDate).append(" 00:00:00'}+1)");
	    	}
	    	if(StringUtils.isNotBlank(billNum)) {
	    		sql.append(" and tsale.fnumber like '%").append(billNum).append("%'");
	    	}
	    	sql.append(" group by tsale.fnumber,tbill.fnumber,tcus.fname_l2,tm.fnumber,tm.fname_l2,tm.fmodel,")
	    	.append(" tunit.fname_l2,tua.fname_l2")
	    	.append(" order by tcus.fname_l2,tm.fnumber");
    	}
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	JSONArray ja=new JSONArray();
    	try {
    		JSONObject tempJO=new JSONObject();
			while(rs.next()) {
				tempJO.put("loadingEntryID", rs.getString("FEntryID"));
//				tempJO.put("customerName", rs.getString("fcustomerName"));
				tempJO.put("materialNum", rs.getString("FMaterialNum"));
				tempJO.put("materialName", rs.getString("FMaterialName"));
				tempJO.put("model", rs.getString("fmodel"));
				tempJO.put("unitName", rs.getString("funitName"));
				tempJO.put("qty", rs.getString("fqty"));
				tempJO.put("assitUnitName", rs.getString("FAssitUnitName"));
				tempJO.put("assitQty", rs.getString("FAssistQty"));
				ja.add(tempJO);
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return ja;
	}

	/**
	 * 生成销售出库单--装货完成
	 */
	protected String _create2SaleIssure(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=JSONObject.fromObject(jsonStr);
		/*String companyID=json.getString("companyID");
		String beginDate=json.getString("beginDate");
		String endDate=json.getString("endDate");*/
		String saleOrderID="";
		if(json.containsKey("saleOrderID")) {
			saleOrderID="'"+json.getString("saleOrderID")+"'";
		}
		
		if(json.containsKey("saleOrderIDs")) {
			for(int index=0;index<json.getJSONArray("saleOrderIDs").size();index++) {
				if(saleOrderID.length()>0) {
					saleOrderID+=",";
				}
				saleOrderID+="'"+json.getJSONArray("saleOrderIDs").getString(index)+"'";
			}
		}
		
		if(saleOrderID.length()<=0) {
			return null;
		}
		
		ArrayList<String> entryKeys=new ArrayList<String>();
		StringBuffer sql=new StringBuffer();
		sql.append(" select t1.fid,t2.fid FEntryID from T_WOR_LoadingBill t1 ")
		.append(" inner join T_WOR_LoadingBillEntry t2 on t2.fparentid=t1.fid ")
//		.append(" where FSrcBillID=? ")
		.append(" where FSrcBillID in (").append(saleOrderID).append(")")
		.append(" and not exists (")
		.append(" select 1 from t_bot_relation t3 where t3.FSrcObjectID=t1.fid and t3.FDestEntityID='CC3E933B'")
		.append(" )")
		.append(" order by t1.fid,t2.fseq");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			String[] srcBillIDs=new String[rs.size()];
			int i=0;
			while(rs.next()) {
				srcBillIDs[i++]=rs.getString("fid");
				entryKeys.add(rs.getString("FEntryID"));
			}
			if(srcBillIDs.length>0) {
				createToSaleIssueBillMuti(ctx, srcBillIDs,entryKeys);
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return "success";
	}
	
	 /**
     * 生成销售出库单
     * @param ctx
     * @param info
     */
    private CoreBillBaseCollection createToSaleIssueBillMuti(Context ctx,String[] srcBillIDs,ArrayList<String> entryKeys) throws BOSException {
    	try {
    		//装货单
    		String srcBillType="BEDBE401";
    		//销售出库单
    		String destBillType="CC3E933B";
    		WlhlBotpCommUtils btpIS = WlhlBotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=ContextUtil.getCurrentCtrlUnit(ctx);
			String[] entryNames=new String[]{"Entry"};
			BOTMappingCollection btpCols = new BOTMappingCollection();//btpIS.getAllCanUsedBotps(ctx, orgInfo, srcBillType,destBillType,srcBillIDs,entryNames, entryKeys, null);
			BOTMappingInfo btpInfo=BOTMappingFactory.getLocalInstance(ctx).getBOTMappingInfo("where name='ZH001'");
			btpCols.add(btpInfo);
			
			CoreBillBaseCollection destCols=new CoreBillBaseCollection();
			ISaleIssueBill is = SaleIssueBillFactory.getLocalInstance(ctx);
			SaleIssueBillInfo info;
			for(int index=0;index<btpCols.size();index++) {
				info = (SaleIssueBillInfo) btpIS.createToBillWithMutilyBill(ctx, srcBillType, srcBillIDs, entryNames,entryKeys,destBillType, btpCols.get(index));
				destCols.add(info);
				if(info.getStorageOrgUnit()==null) {
//					StorageOrgUnitInfo stoInfo = new StorageOrgUnitInfo();
//					stoInfo.setId(BOSUuid.read(info.getCompany));
//					info.setStorageOrgUnit(stoInfo);
				}
				is.save(info);
			}
			return destCols;
    	}catch(Exception err) {
    		throw new BOSException(err);
    	}
    }
	/**
	 * 删除装货单--按分录删除
	 */
	protected String _deleteData(Context ctx, String jsonStr) throws BOSException {
		JSONObject result=new JSONObject();
    	result.put("result", "0");
    	result.put("message", "success");
    	JSONObject json=JSONObject.fromObject(jsonStr);
    	if(!json.containsKey("loadingEntryID")) {
    		result.put("result", "1");
	    	result.put("message","id不能为空！");
	    	return result.toString();
    	}
    	String entryID=json.getString("loadingEntryID");
    	IRowSet rs=DbUtil.executeQuery(ctx, "select CFFinishLoading from T_WOR_LoadingBill tbill inner join T_WOR_LoadingBillEntry tentry on tentry.fparentid=tbill.fid inner join t_sd_saleOrder torder on torder.fid=tbill.FSrcBillID where tentry.fid=? ",new Object[]{entryID});
    	try {
	    	if(rs.next()) {
	    		if(rs.getBoolean("CFFinishLoading")) {
	    			throw new Exception("该单据已经装货完成，禁止删除！");
	    		}
	    	}
	    	DbUtil.execute(ctx, "delete from T_WOR_LoadingBillEntry where fid=? ",new Object[]{entryID});
    	}catch(Exception err) {
    		result.put("result", "1");
	    	result.put("message",err.getMessage());
    	}
    	return result.toString();
	}

	/**
	 * 装货完成
	 */
	protected String _finishLoading(Context ctx, String jsonStr) throws BOSException {
		JSONObject result=new JSONObject();
    	result.put("result", "0");
    	result.put("message", "success");
    	try {
			JSONObject json=JSONObject.fromObject(jsonStr);
	    	String billID=json.getString("billID");
	    	DbUtil.execute(ctx,"update t_sd_saleOrder set CFFinishLoading=1 where fid=? and (CFFinishLoading=0 or CFFinishLoading is null)",new Object[]{billID});
    	}catch(Exception err) {
    		result.put("result", "1");
	    	result.put("message",err.getMessage());
    	}
    	return result.toString();
    	//createToSaleIssueBill(ctx, info);
	}
    
}