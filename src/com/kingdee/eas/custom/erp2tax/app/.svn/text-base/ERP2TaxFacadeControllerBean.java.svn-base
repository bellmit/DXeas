package com.kingdee.eas.custom.erp2tax.app;

import java.io.File;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.erp2tax.BaseSettingFactory;
import com.kingdee.eas.custom.erp2tax.BaseSettingInfo;
import com.kingdee.eas.custom.erp2tax.Erp2TaxTypeEnum;
import com.kingdee.eas.custom.erp2tax.functions.ElcExportInvoiceBean;
import com.kingdee.eas.custom.erp2tax.functions.ElcExportItemBean;
import com.kingdee.eas.custom.erp2tax.functions.ElcExportMainBean;
import com.kingdee.eas.custom.erp2tax.functions.ElcExportOrderBean;
import com.kingdee.eas.custom.erp2tax.util.Erp2TaxHttpUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class ERP2TaxFacadeControllerBean extends AbstractERP2TaxFacadeControllerBean
{
    private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.erp2tax.app.ERP2TaxFacadeControllerBean");
    private BaseSettingInfo bdsInfo;//接口基础设置
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int nowNumIndex;
	private int maxRowCount=7;//发票最大行数
	private BigDecimal maxAmount;//发票最大金额
	private String keystorePath;//密匙文件路径
	private static final String export2TaxCMD="chinaeinv.api.invoice.v3.kp_async";
	private static final String exportBackCMD="chinaeinv.api.invoice.v3.ch_async";
	private static final String exportQueryCMD="chinaeinv.api.invoice.v3.cx";
    
    protected void _execute(Context ctx, String sqlStr)throws BOSException
    {
    	DbUtil.execute(ctx, sqlStr);
    }
	@Override
	protected String _exeExport2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException {
		try {
			JSONObject json=JSONObject.fromObject(jsonStr);
			String companyID=json.getString("companyID");
			setDeafultSetting(ctx, companyID);
			int opType=json.getInt("opType");
			JSONArray ja=json.getJSONArray("billIDs");
			String[] billIDs=new String[ja.size()];
			for(int i=0;i<ja.size();i++) {
				billIDs[i]=ja.getString(i);
			}
			return exeExportToTax(ctx,companyID, billIDs, opType,json);
		}catch(BOSException e) {
			throw new BOSException(e);
		}catch(SQLException e) {
			throw new BOSException(e);
		}catch(Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("",e.toString()));
		}
	}

	/**
	同步开票结果
	 */
	protected String _exeSynResult(Context ctx, String jsonStr) throws BOSException, EASBizException {
		JSONObject json=JSONObject.fromObject(jsonStr);
		String companyID=json.getString("companyID");
		setDeafultSetting(ctx, companyID);
		JSONArray ja=json.getJSONArray("billIDs");
		String[] billIDs=null;
		if(ja!=null) {
			billIDs=new String[ja.size()];
			for(int i=0;i<ja.size();i++) {
				billIDs[i]=ja.getString(i);
			}
		}
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select fid,CFSerialNo from T_IM_SaleIssueBill")
		.append(" where 1=1")
		.append(" and CFHasExport2Tax=1")
//		.append(" and CFSerialNo is not null")
		.append(" and (cftaxCode is null or cftaxCode='')")
		;
		if(json.containsKey("companyNum")) {
			sql.append(" and FStorageOrgUnitID in (")
			.append(" select ftounitid from  T_ORG_UnitRelation tor  ")//组织委托
			.append(" inner join  T_ORG_TypeRelation tot on tor.FTypeRelationID=tot.fid ")
			.append("  wheretot.FFromType=4 and tot.FToType=1")//组织委托关系类型
			.append(" )");
		}
		if(json.containsKey("billIDs")) {
			StringBuffer exportBillIDs=new StringBuffer();
			for(int i=0;i<billIDs.length;i++) {
				if(exportBillIDs.length()>0) {
					exportBillIDs.append(",");
				}
				exportBillIDs.append("'").append(billIDs[i].toString()).append("'");
			}
			sql.append(" and fid in (").append(exportBillIDs).append(")")
			.append(" ");
		}
		sql.append(" order by fnumber");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		String msg="",serialNo;
		try {
			String tempMsg;
			String[] tempArray;
			while(rs.next()) {
				serialNo= rs.getString("CFSerialNo");
				if(serialNo.contains(";")) {
					tempArray=serialNo.split(";");
				}else {
					tempArray=new String[]{serialNo};
				}
				for(int index=0;index<tempArray.length;index++) {
					serialNo=tempArray[index];
					if(StringUtils.isEmpty(serialNo)) {
						continue;
					}
					tempMsg=exeSynSingle(ctx, rs.getString("fid"),serialNo);
					json=JSONObject.fromObject(tempMsg);
					if(json.getInt("code")==0) {
//						taxCode=json.getJSONArray("invoices").getJSONObject(0).getString("code");
						msg+="同步电子发票信息成功！\n";
					}else {
						msg+=tempMsg;
					}
				}
			}
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return msg;
	}
	
	private String exeSynSingle(Context ctx,String billID,String serialNo) throws Exception {
//		if(StringUtils.isEmpty(serialNo)) {
//			return "";
//		}
		JSONObject json=new JSONObject();
		JSONObject jo;
		JSONArray ja;
		json.put("serialNo",String.valueOf(new Date().getTime()));
		json.put("postTime", sdf.format(new Date()));
		ja=new JSONArray();
		jo=new JSONObject();
		jo.put("name", "singlesSerialNo");
		jo.put("value",serialNo);
		ja.add(jo);
		json.put("criteria",ja);
		String tempMsg=Erp2TaxHttpUtil.httpsPost(keystorePath, bdsInfo.getKeystoreAbner(), bdsInfo.getPasswd(),bdsInfo.getAppCode(), bdsInfo.getInterfaceUrl(),exportQueryCMD , json.toString())+"\n";
		json=JSONObject.fromObject(tempMsg);
		String taxCode;
		if(json.getInt("code")==0) {
			taxCode=json.getJSONArray("invoices").getJSONObject(0).getString("code");
			reWriteTaxResult(ctx, billID,taxCode,json.getString("message"));
		}
		return tempMsg;
	}
	
	/**
	 * 反写开票结果
	 * @param ctx
	 * @param billID
	 * @param resultCode
	 * @param reusltMsg
	 * @throws BOSException 
	 */
	private void reWriteTaxResult(Context ctx,String billID,String taxCode,String resultMsg) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" update T_IM_SaleIssueBill set cftaxCode=isnull(cftaxCode,'')||'").append(taxCode).append("'||';'")
		.append(" where fid='").append(billID).append("'");
		DbUtil.execute(ctx, sql.toString());
	}
	
	/**
	 * 执行导入到金税接口
	 * @param billIDs
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private String exeExportToTax(Context ctx,String companyID,Object[] billIDs,int opType,JSONObject json) throws Exception {
		StringBuffer exportBillIDs=new StringBuffer();
		for(int i=0;i<billIDs.length;i++) {
			if(exportBillIDs.length()>0) {
				exportBillIDs.append(",");
			}
			exportBillIDs.append("'").append(billIDs[i].toString()).append("'");
		}
		
		try {
			if(exportBillIDs.length()>0) {
				nowNumIndex=0;
				
				//组织编码
				String companyNum=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyID)).getNumber();
				String msg=null;
				if(opType==Erp2TaxTypeEnum.SUM_VALUE) {
					msg=exeExportToTaxWithSum(ctx,companyNum,exportBillIDs.toString());
				}else if (opType==Erp2TaxTypeEnum.NORMAL_VALUE){
					msg=exeExportToTaxNoSum(ctx,companyNum,exportBillIDs.toString());
				}else if(opType==Erp2TaxTypeEnum.SPLIT_VALUE) {
					JSONArray splitParams=json.getJSONArray("splitParams");
					ArrayList<BigDecimal> amountArray=new ArrayList<BigDecimal>();
					JSONArray tempArray=splitParams.getJSONArray(2);
					for(int index=0;index<tempArray.size();index++) {
						amountArray.add(new BigDecimal(tempArray.getString(index)));
					}
					msg=exeExportWithSplit(ctx,companyNum,exportBillIDs.toString(),splitParams.getBoolean(1),new BigDecimal(splitParams.getString(0)),amountArray);
				}
				return msg;
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return null;
	}
	/**
	 * 设置默认参数
	 * @throws BOSException 
	 */
	private void setDeafultSetting(Context ctx,String companyID) throws BOSException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid,FMaxRow,FMaxAmount from ").append(" T_ERP_BaseSetting ")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" order by FCreateTime desc");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				bdsInfo=BaseSettingFactory.getLocalInstance(ctx).getBaseSettingInfo(new ObjectUuidPK(rs.getString("fid")));
				maxRowCount=rs.getInt("FMaxRow");
				maxAmount=rs.getBigDecimal("FMaxAmount");
				String splitChar=File.separator;
				keystorePath=System.getProperty("EAS_HOME")+splitChar+"server"+splitChar+"properties"+splitChar+bdsInfo.getKeystoreName();
			}else {
				throw new Exception("电子发票接口尚未进行基础设置！");
			}
			rs.close();
		}catch (Exception e) {
			throw new BOSException(e);
		}
	}
	
	/**
	 * 处理赠品
	 * @param ctx
	 * @param exportBillIDs
	 * @throws BOSException 
	 */
	private void dealGiftBills(Context ctx,String exportBillIDs) throws BOSException {
		
	}
	
	/**
	 * 执行导入非合并
	 * @throws Exception 
	 */
	private String exeExportToTaxNoSum(Context ctx,String companyNum,String exportBillIDs) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select tbill.FID,tbill.FNumber,tcus.FName_l2 FCustomerName,tcus.fnumber FCustomerNum,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tentry.FID FEntryID,tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,")
			.append(" tfcus.FPhone FTel,tbank.FBank Fbankname,tbank.FBankAccount FbankNo,tfcus.FEMail Femail,")
			.append(" nvl(tentry.FQty,0) FQty,nvl(tentry.FPrice,0) FPrice,nvl(tentry.FTaxPrice,0) FTaxPrice,nvl(tentry.FNonTaxAmount,0) FAmount,nvl(tentry.FAmount,0) FAllAmount,")
			.append(" nvl(tentry.FTaxRate,0)/100 FTaxRate,")
			.append(" nvl(tentry.FDiscountAmount,0) FDiscountAmount,tentry.FSeq,tr.fnumber cftaxCode")//折扣额、税收分类代码tmc.cftaxCode
			.append(" from T_IM_SaleIssueBill tbill")
			.append(" inner join T_IM_SaleIssueEntry tentry on tentry.fparentid=tbill.fid ")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FCustomerID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_ERP_MaterialTaxCodeEntry tre on tre.fmaterialID=tm.fid")
			.append(" left join T_ERP_MaterialTaxCode tr on tr.fid=tre.fparentid")
			.append(" left join T_ORG_UnitRelation tor on tor.ffromunitid=tbill.FStorageOrgUnitID and tor.FTypeRelationID in (")//组织委托
			.append(" select fid from  T_ORG_TypeRelation tot where tot.FFromType=4 and tot.FToType=1")//组织委托关系类型
			.append(" )")
//			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tor.ftounitid")
			.append(" left join T_BD_CustomerCompanyInfo tfcus on tfcus.FComOrgID=tor.ftounitid and tfcus.FCustomerID=tcus.fid")//客户财务资料
			.append(" left join T_BD_CustomerCompanyBank tbank on tbank.fseq=1 and FCustomerCompanyInfoID=tfcus.fid")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FUnitID")
			.append(" where tbill.fid in (").append(exportBillIDs).append(")")
			.append(" and tentry.FIsPresent=0")//非赠品
			.append(" order by tbill.fnumber, tentry.fseq ")
			.append(" ")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			String billID,billIDKeep=null;
			HashMap<String,ElcExportMainBean> exportBeanMap=new HashMap<String,ElcExportMainBean>();
			ElcExportMainBean eb=null;
			String userName=ContextUtil.getCurrentUserInfo(ctx).getName();
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
					 
					 eb=createNewExportBean(companyNum,rs, userName);
	                 exportBeanMap.put(eb.getSerialNo(), eb);
				 }else {
					 //新单据或者最后一行
					 if(!billIDKeep.equals(billID)) {
						 
						 eb=createNewExportBean(companyNum,rs, userName);
		                 exportBeanMap.put(eb.getSerialNo(), eb);
		                 
		                 billIDKeep=billID;
		                 sumAllAmount=BigDecimal.ZERO;
		                 nowRowCount=0;
					 }
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");//返利
				 allAmount=rs.getBigDecimal("FAllAmount");//应收金额
				 
				 nowRowCount++;
				 if(allAmount.compareTo(maxAmount)>0) {
					 throw new Exception("单据"+rs.getString("fnumber")+"第"+rs.getInt("FSeq")+"行分录应收金额超出开票最大支持金额:"+maxAmount);
				 }
				 
				 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
				 if(nowRowCount>maxRowCount ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+1)>maxRowCount)) {
					 throw new Exception("单据"+rs.getString("fnumber")+"超出开票最大分录行:"+maxAmount);
				 }
				 
				 qty=rs.getBigDecimal("FQty");
				 taxPrice=rs.getBigDecimal("FTaxPrice");
				 taxRate=rs.getBigDecimal("FTaxRate");
//				 price=taxPrice.divide(BigDecimal.ONE.add(taxRate),10,BigDecimal.ROUND_HALF_UP);
				 if(taxRate.signum()>0) {
					 price=rs.getBigDecimal("FAmount").divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 }else {
					 price=taxPrice;
				 }
				 
				 sumAllAmount=sumAllAmount.add(allAmount);
				 
				 //来源单据号
				 eb.getInvoice().getSrcBillIDsList().add(rs.getString("fid"));
				 
				 //发票分录
				 ElcExportItemBean eeb = new ElcExportItemBean();
				 eeb.setAmount(allAmount);
				 eeb.setCode(rs.getString("FMaterialNum"));
				 eeb.setName(rs.getString("FMaterialName"));
				 eeb.setPrice(taxPrice);
				 eeb.setQuantity(qty);
				 eeb.setTaxRate(taxRate);
				 eeb.setUom(rs.getString("FUnitName"));
				 eeb.setType(discountAmount.signum()>0?"2":"0");//发票性质
				 eeb.setSpec(rs.getString("FModel"));
				 eeb.setCatalogCode(rs.getString("cftaxCode"));
				 eeb.setPreferentialPolicyFlg("0");
				 eeb.setAddedValueTaxFlg("0");
				 eeb.setZeroTaxRateFlg("1");
				 
//                 eeb.set
                 
                 eb.getInvoice().getItems().add(eeb);
                 
                 //增加返利分录
                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
                	 //发票分录
                	 ElcExportItemBean eebDis = new ElcExportItemBean();
                	 
                	 eeb.setAmount(discountAmount.multiply(new BigDecimal(-1)));
    				 eeb.setCode(rs.getString("FMaterialNum"));
    				 eeb.setName(rs.getString("FMaterialName"));
    				 eeb.setPrice(BigDecimal.ZERO);
    				 eeb.setQuantity(BigDecimal.ZERO);
    				 eeb.setTaxRate(taxRate);
    				 eeb.setUom("");
    				 eeb.setType("1");//发票性质
    				 eeb.setSpec(rs.getString("FModel"));
    				 eeb.setCatalogCode(rs.getString("cftaxCode"));
    				 eeb.setPreferentialPolicyFlg("0");
    				 eeb.setAddedValueTaxFlg("0");
    				 eeb.setZeroTaxRateFlg("1");
    				 
//    				 eebDis.setSrcID(rs.getString("FEntryID"));
    				 
    				  eb.getInvoice().getItems().add(eebDis);
                 }
			}
			//导出发票
			if(exportBeanMap.size()>0) {
				return exeExoprt2Tax(ctx,exportBillIDs,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return null;
	}
	/**
	 * 反写时间戳
	 * timeNo==null 为红冲单据
	 * @throws BOSException 
	 */
	private void reWriteTimeNo(Context ctx,String timeNo,String exportBillIDs,String entryIDs,String customerID) throws BOSException {
		if(StringUtils.isNotBlank(timeNo)) {
			timeNo="'"+timeNo+"'";
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update T_IM_SaleIssueBill")
		.append(" set ");
		if(timeNo!=null) {
			sql.append(" CFSerialNo=isnull(CFSerialNo,'')||").append(timeNo==null?"''":timeNo).append("||';'");
		}else {
			sql.append(" CFSerialNo=''")
			.append(" ,cftaxcode=''");
		}
		sql.append(" ,cfhasExport2Tax=").append(timeNo==null?"0":"1")
		.append(" where 1=1");
		if(StringUtils.isNotEmpty(exportBillIDs)) {
			//红冲、包括合并红冲
			if(timeNo==null) {
				sql.append(" and CFSerialNo in (select CFSerialNo from T_IM_SaleIssueBill where fid in (").append(exportBillIDs).append(")");
			}else {
				sql.append(" and fid in (").append(exportBillIDs).append(")");
			}
		}
		if(StringUtils.isNotEmpty(entryIDs)) {
			sql.append(" and fid in (")
			.append(" select distinct Fparentid from T_IM_SaleIssueEntry where fid in (").append(entryIDs).append(")")
			.append(")");
		}
		if(StringUtils.isNotEmpty(customerID)) {
			sql.append(" and FCustomerID ='").append(customerID).append("'");
		}
		DbUtil.execute(ctx, sql.toString());
	}
	
	
	/**
	 * 创建新的导入bean
	 * @param customerNum
	 * @param customerName
	 * @param taxNo
	 * @param userName
	 * @return
	 * @throws SQLException 
	 */
	private ElcExportMainBean createNewExportBean(String companyNum,IRowSet rs,String userName) throws SQLException {
		 Date nowDate=new java.util.Date();
		 String timeStr = String.valueOf(nowDate.getTime())+"-"+(nowNumIndex++);
         //新增表头
		 ElcExportMainBean eb = new ElcExportMainBean();
		 eb.setSerialNo(timeStr);
		 eb.setPostTime(sdf.format(nowDate));
		 ElcExportInvoiceBean invoceBean=new ElcExportInvoiceBean();
		 invoceBean.setTaxpayerCode(bdsInfo.getTaxNo());
		 invoceBean.setTaxpayerAddress(bdsInfo.getAddress());
		 invoceBean.setTaxpayerTel(bdsInfo.getTel());
		 invoceBean.setTaxpayerBankName(bdsInfo.getBankName());
		 invoceBean.setTaxpayerBankAccount(bdsInfo.getBankNo());
		 invoceBean.setCustomerName(rs.getString("FCustomerName"));
		 invoceBean.setCustomerCode(rs.getString("FTxRegisterNo"));//纳税人识别号
		 invoceBean.setDrawer(userName);
//		 invoceBean.setRemark("");
		 invoceBean.setCustomerAddress(rs.getString("FAddress"));
		 invoceBean.setCustomerTel(rs.getString("FTel"));
		 invoceBean.setCustomerBankName(rs.getString("FBankName"));
		 invoceBean.setCustomerBankAccount(rs.getString("FbankNo"));
		 invoceBean.setPayee(userName);
		 invoceBean.setReviewer(userName);
		 invoceBean.setItems(new ArrayList<ElcExportItemBean>());
		 invoceBean.setSrcBillIDsList(new ArrayList<String>());
		 eb.setInvoice(invoceBean);
		 
		 ElcExportOrderBean orderInfo=new ElcExportOrderBean();
		 orderInfo.setOrderNo(rs.getString("fnumber"));
//		 orderInfo.setAccount(rs.getString("FCustomerName"));
//		 orderInfo.setAddress(rs.getString("FAddress"));
//		 orderInfo.setEmail(StringUtils.isNotEmpty(rs.getString("Femail"))?rs.getString("Femail"):"123@qq.com");//email
//		 orderInfo.setTel(rs.getString("FTel"));
		 eb.setOrder(orderInfo);
         return eb;
	}
	/**
	 * 执行导出
	 * @param exportBillIDs
	 * @param map
	 * @throws BOSException 
	 */
	private String exeExoprt2Tax(Context ctx,String exportBillIDs,HashMap<String, ElcExportMainBean> map) throws Exception {
		Iterator<Entry<String, ElcExportMainBean>> itr = map.entrySet().iterator();
		String msg="",tempMsg;
		BigDecimal totalAmount;
		JSONObject json;
		while(itr.hasNext()) {
			ElcExportMainBean obj = itr.next().getValue();
			totalAmount=BigDecimal.ZERO;
			for(ElcExportItemBean tb:obj.getInvoice().getItems()) {
				totalAmount=totalAmount.add(tb.getAmount());
			}
			obj.getInvoice().setTotalAmount(totalAmount);
			exportBillIDs="";
			for(String id:obj.getInvoice().getSrcBillIDsList()) {
				if(exportBillIDs.length()>0) {
					exportBillIDs+=",";
				}
				exportBillIDs+="'"+id+"'";
			}
			obj.getInvoice().setSrcBillIDsList(null);
			tempMsg=Erp2TaxHttpUtil.httpsPost(keystorePath, bdsInfo.getKeystoreAbner(), bdsInfo.getPasswd(),bdsInfo.getAppCode(), bdsInfo.getInterfaceUrl(),export2TaxCMD , JSONObject.fromObject(obj).toString());
			msg+=tempMsg;
			json=JSONObject.fromObject(tempMsg);
			//成功
			if(json.getInt("code")==0&&exportBillIDs.length()>0) {
				reWriteTimeNo(ctx, obj.getSerialNo(), exportBillIDs, null, null);
			}
		}
		return msg;
	}
	
	/**
	 * 执行导入合并
	 * @throws Exception 
	 */
	private String exeExportToTaxWithSum(Context ctx,String companyNum,String exportBillIDs) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select 'sumOrderNum' fnumber,tcus.fnumber FCustomerNum,tcus.fname_l2 FCustomerName,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tfcus.FPhone FTel,tbank.FBank Fbankname,tbank.FBankAccount FbankNo,")//tfcus.FEMail Femail,
			.append(" tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,tr.fnumber cftaxCode,")//cftaxCode
			.append(" sum(tentry.FQty) FQty,")
			.append(" sum(tentry.FNonTaxAmount) FAmount,sum(tentry.FAmount) FAllAmount,0 FTaxAmount,")//avg(tentry.FTaxRate)/100 FTaxRate
			.append(" sum(tentry.FDiscountAmount) FDiscountAmount")//折扣额
			.append(" from T_IM_SaleIssueBill tbill")
			.append(" inner join T_IM_SaleIssueEntry tentry on tentry.FParentid=tbill.fid")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FCustomerID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_ERP_MaterialTaxCodeEntry tre on tre.fmaterialID=tm.fid")
			.append(" left join T_ERP_MaterialTaxCode tr on tr.fid=tre.fparentid")
			.append(" left join T_ORG_UnitRelation tor on tor.ffromunitid=tbill.FStorageOrgUnitID and tor.FTypeRelationID in (")//组织委托
			.append(" select fid from  T_ORG_TypeRelation tot where tot.FFromType=4 and tot.FToType=1")//组织委托关系类型
			.append(" )")
			.append(" left join T_BD_CustomerCompanyInfo tfcus on tfcus.FComOrgID=tor.ftounitid and tfcus.FCustomerID=tcus.fid")//客户财务资料
			.append(" left join T_BD_CustomerCompanyBank tbank on tbank.fseq=1 and FCustomerCompanyInfoID=tfcus.fid")
//			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tor.ftounitid")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FUnitID")
			.append(" where tbill.fid in (").append(exportBillIDs).append(")")
			.append(" group by tcus.fnumber,tcus.fname_l2,tcus.FTxRegisterNo,tcus.FAddress,")
			.append(" tfcus.FPhone,tbank.FBank,tbank.FBankAccount,")
			.append(" tm.fnumber,tm.FName_l2,tm.FModel,tu.FName_l2,tr.fnumber")
			.append(" ")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			String customerNum,customerNumKeep=null;
			HashMap<String,ElcExportMainBean> exportBeanMap=new HashMap<String,ElcExportMainBean>();
			ElcExportMainBean eb=null;
			String userName=ContextUtil.getCurrentUserInfo(ctx).getName();
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
					 eb=createNewExportBean(companyNum,rs, userName);
					 
					 //设置来源id
					 String[] IdsArray=exportBillIDs.replaceAll("'", "").split(",");
					 eb.getInvoice().setSrcBillIDsList(Arrays.asList(IdsArray));
					 
	                 exportBeanMap.put(eb.getSerialNo(), eb);
				 }else {
					 //新单据或者最后一行
					 if(!customerNumKeep.equals(customerNum)) {
						 throw new EASBizException(new NumericExceptionSubItem("001","非同一客户不允许合并！"));
					 }
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");
				 allAmount=rs.getBigDecimal("FAllAmount");
				 nowRowCount++;
				 
				 if(allAmount.compareTo(maxAmount)>0) {
					 throw new Exception("客户"+rs.getString("FCustomerName")+"物料"+rs.getInt("FMaterialName")+"合计应收金额超出开票最大支持金额"+maxAmount);
				 }
				 
				 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
				 if(nowRowCount>maxRowCount ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+1)>maxRowCount)) {
					 throw new Exception("单据"+rs.getString("fnumber")+"超出开票最大分录行:"+maxAmount);
				 }
				 
				 amount=rs.getBigDecimal("FAmount");//不含税金额
				 taxAmount=rs.getBigDecimal("FTaxAmount");//税额
				 
				 qty=rs.getBigDecimal("FQty");
				 
				 taxPrice=allAmount.divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 price=amount.divide(qty,10,BigDecimal.ROUND_HALF_UP);
				 
				 taxRate=taxAmount.divide(amount,2,BigDecimal.ROUND_HALF_UP);

				 sumAllAmount=sumAllAmount.add(allAmount);
				 
				 //来源单据号
//				 eb.getInvoice().getSrcBillIDsList().add(rs.getString("fid"));
				 
               //发票分录
            	 ElcExportItemBean eeb = new ElcExportItemBean();
            	 eeb.setAmount(allAmount);
            	 eeb.setCode(rs.getString("FMaterialNum"));
            	 eeb.setName(rs.getString("FMaterialName"));
            	 eeb.setPrice(taxPrice);
            	 eeb.setQuantity(qty);
            	 eeb.setTaxRate(taxRate);
            	 eeb.setUom(rs.getString("FUnitName"));
            	 eeb.setType(discountAmount.signum()>0?"2":"0");//发票性质
            	 eeb.setSpec(rs.getString("FModel"));
            	 eeb.setCatalogCode(rs.getString("cftaxCode"));
            	 eeb.setPreferentialPolicyFlg("0");
            	 eeb.setAddedValueTaxFlg("0");
            	 eeb.setZeroTaxRateFlg("1");
//            	 eeb.setSrcID(rs.getString("FEntryID"));
            	 eb.getInvoice().getItems().add(eeb);
                 
                 //增加返利分录
                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
                	//发票分录
            		 ElcExportItemBean eebDis = new ElcExportItemBean();
            		 eeb.setAmount(discountAmount.multiply(new BigDecimal(-1)));
            		 eeb.setCode(rs.getString("FMaterialNum"));
            		 eeb.setName(rs.getString("FMaterialName"));
            		 eeb.setPrice(BigDecimal.ZERO);
            		 eeb.setQuantity(BigDecimal.ZERO);
            		 eeb.setTaxRate(taxRate);
            		 eeb.setUom("");
            		 eeb.setType("1");//发票性质
            		 eeb.setSpec(rs.getString("FModel"));
            		 eeb.setCatalogCode(rs.getString("cftaxCode"));
            		 eeb.setPreferentialPolicyFlg("0");
            		 eeb.setAddedValueTaxFlg("0");
            		 eeb.setZeroTaxRateFlg("1");
//                	 eebDis.setSrcID(rs.getString("FEntryID"));
            		 eb.getInvoice().getItems().add(eebDis);
                 }
			}
			//导出发票
			if(exportBeanMap.size()>0) {
				return exeExoprt2Tax(ctx,exportBillIDs,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return null;
	}
	
	 /**
	 * 执行导入到金税接口
	 * @param billIDs
     * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private String exeExportWithSplit(Context ctx,String companyNum,String exportBillID,
			boolean isQtyInit,BigDecimal billAllAmount,ArrayList<BigDecimal> amountList) throws Exception {
		try {
			StringBuffer sql=new StringBuffer();
			sql.setLength(0);
			sql.append(" /*dialect*/select tbill.FID,tbill.FNumber,tcus.FName_l2 FCustomerName,tcus.fnumber FCustomerNum,tcus.FTxRegisterNo,")
			.append(" tcus.FAddress,")
			.append(" tfcus.FPhone FTel,tbank.FBank Fbankname,tbank.FBankAccount FbankNo,tfcus.FEMail Femail,")
			.append(" tentry.FID FEntryID,tm.fnumber FMaterialNum,tm.FName_l2 FMaterialName,tm.FModel,tu.FName_l2 FUnitName,")
			.append(" tentry.FQty FQty,tentry.FPrice,tentry.FTaxPrice FTaxPrice,tentry.FAmount,nvl(tentry.FAmount,0) FAllAmount,tentry.FTaxRate/100 FTaxRate,")
			.append(" nvl(tentry.FDiscountAmount,0) FDiscountAmount,0 FTaxAmount,tentry.FSeq,tr.fnumber cftaxCode")//折扣额 tmc.cftaxCode
			.append(" from T_IM_SaleIssueBill tbill")
			.append(" inner join T_IM_SaleIssueEntry tentry on tentry.fparentid=tbill.fid ")
			.append(" inner join t_bd_customer tcus on tcus.FID=tbill.FCustomerID")
			.append(" inner join t_bd_material tm on tm.FID=tentry.FMaterialID")
			.append(" left join T_ERP_MaterialTaxCodeEntry tre on tre.fmaterialID=tm.fid")
			.append(" left join T_ERP_MaterialTaxCode tr on tr.fid=tre.fparentid")
			.append(" left join T_ORG_UnitRelation tor on tor.ffromunitid=tbill.FStorageOrgUnitID and tor.FTypeRelationID in (")//组织委托
			.append(" select fid from  T_ORG_TypeRelation tot where tot.FFromType=4 and tot.FToType=1")//组织委托关系类型
			.append(" )")
			.append(" left join T_BD_CustomerCompanyInfo tfcus on tfcus.FComOrgID=tor.ftounitid and tfcus.FCustomerID=tcus.fid")//客户财务资料
			.append(" left join T_BD_CustomerCompanyBank tbank on tbank.fseq=1 and FCustomerCompanyInfoID=tfcus.fid")
//			.append(" left join T_BD_MaterialCompanyInfo tmc on tmc.FMaterialID=tm.fid and tmc.FCompanyID=tor.ftounitid")
			.append(" inner join t_bd_measureUnit tu on tu.fid=tentry.FUnitID")
			.append(" where tbill.fid in (").append(exportBillID).append(")")
			.append(" order by tbill.fnumber, tentry.fseq ")
			.append(" ")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			String billID,billIDKeep=null;
			HashMap<String,ElcExportMainBean> exportBeanMap=new HashMap<String,ElcExportMainBean>();
			ElcExportMainBean eb=null;
			String userName=ContextUtil.getCurrentUserInfo(ctx).getName();
			BigDecimal discountAmount,orgDiscountAmount;//折扣额，返利金额
			BigDecimal allAmount,orgAllAmount,sumAmount=BigDecimal.ZERO;//总价税合计
			BigDecimal tempAmount,tempProp,tempSumDisAmount,tempSumAllAmount;
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
					 eb=createNewExportBean(companyNum,rs, userName);
					 
					 //设置来源id
					 String[] IdsArray=exportBillID.replaceAll("'", "").split(",");
					 eb.getInvoice().setSrcBillIDsList(Arrays.asList(IdsArray));
					 
					 exportBeanMap.put(eb.getSerialNo(), eb);
					 orgTimeStr=eb.getSerialNo();
				 }
				 
				 discountAmount=rs.getBigDecimal("FDiscountAmount");//返利
				 allAmount=rs.getBigDecimal("FAllAmount");//应收金额
				 
				 nowRowCount++;
				 /*if(allAmount.compareTo(maxAmount)>0) {
					 throw new Exception("单据"+rs.getString("fnumber")+"第"+rs.getInt("FSeq")+"行分录应收金额超出开票最大支持金额:"+maxAmount);
				 }*/
				 //超出最大金额、下笔行数超出最大行数、存在返利下行数超出最大行数（+2行）
				 if(nowRowCount>maxRowCount ||(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0&&(nowRowCount+1)>maxRowCount)) {
					 throw new Exception("单据"+rs.getString("fnumber")+"超出开票最大分录行:"+maxAmount);
				 }
				 
				 amount=rs.getBigDecimal("FAmount");//金额
				 taxAmount=rs.getBigDecimal("FTaxAmount");//税额
				 qty=rs.getBigDecimal("FQty");
				 
				 orgQty=qty;
				 orgDiscountAmount=discountAmount;
				 orgAllAmount=allAmount;
				 orgAmount=amount;
				 orgTaxAmount=taxAmount;
				 
				 tempSumDisAmount=BigDecimal.ZERO;
				 tempSumAllAmount=BigDecimal.ZERO;
				 tempSumQty=BigDecimal.ZERO;
				 tempSumAmount=BigDecimal.ZERO;
				 tempSumTaxAmount=BigDecimal.ZERO;
				 
				 //拆分
				 for(int i=0;i<amountList.size();i++) {
					 tempAmount=amountList.get(i);//拆分金额
					 
					 if(i>0) {//非第一行、原始行
						 timeStr=orgTimeStr+"."+i;
						 if(!exportBeanMap.containsKey(timeStr)) {
							 eb=createNewExportBean(companyNum,rs, userName);
							 eb.getInvoice().getSrcBillIDsList().add(exportBillID.replaceAll("'", ""));
							 exportBeanMap.put(eb.getSerialNo(), eb);
						 }else {
							 eb=exportBeanMap.get(timeStr);
						 }
					 }
					 //最后一行
					 if(i==amountList.size()-1) {
						 allAmount= orgAllAmount.subtract(tempSumAllAmount);
						 discountAmount=orgDiscountAmount.subtract(tempSumDisAmount);
						 taxAmount=orgTaxAmount.subtract(tempSumTaxAmount);
						 qty=orgQty.subtract(tempSumQty);
					 }else {
						 //拆分比例
						 tempProp=tempAmount.divide(billAllAmount,10,BigDecimal.ROUND_HALF_UP);
						 
						 discountAmount= orgDiscountAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 allAmount= orgAllAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 taxAmount= orgTaxAmount.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 
						 qty=qty.multiply(tempProp).setScale(2, BigDecimal.ROUND_HALF_UP);
						 //数量取整
						 if(isQtyInit) {
							 qty=qty.setScale(0, BigDecimal.ROUND_HALF_UP);
						 }
						 
						 tempSumAllAmount=tempSumAllAmount.add(allAmount);
						 tempSumDisAmount=tempSumDisAmount.add(discountAmount);
						 tempSumQty=tempSumQty.add(qty);
						 tempSumTaxAmount=tempSumTaxAmount.add(taxAmount);
					 }
				 
					 amount=allAmount.subtract(taxAmount);
					 taxRate=taxAmount.divide(amount,2,BigDecimal.ROUND_HALF_UP);
					 
					 taxPrice=allAmount.divide(qty,10, BigDecimal.ROUND_HALF_UP);
					 price=amount.divide(qty,10, BigDecimal.ROUND_HALF_UP);

					 sumAmount=sumAmount.add(allAmount);
					 
					 //发票分录
					 ElcExportItemBean eeb = new ElcExportItemBean();
					 eeb.setAmount(allAmount);
					 eeb.setCode(rs.getString("FMaterialNum"));
					 eeb.setName(rs.getString("FMaterialName"));
					 eeb.setPrice(taxPrice);
					 eeb.setQuantity(qty);
					 eeb.setTaxRate(taxRate);
					 eeb.setUom(rs.getString("FUnitName"));
					 eeb.setType(discountAmount.signum()>0?"2":"0");//发票性质
					 eeb.setSpec(rs.getString("FModel"));
					 eeb.setCatalogCode(rs.getString("cftaxCode"));
					 eeb.setPreferentialPolicyFlg("0");
					 eeb.setAddedValueTaxFlg("0");
					 eeb.setZeroTaxRateFlg("1");
					 
					 eb.getInvoice().getItems().add(eeb);
	                 
	                 //增加返利分录
	                 if(discountAmount!=null&&discountAmount.compareTo(BigDecimal.ZERO)>0) {
	                	//发票分录
	            		 ElcExportItemBean eebDis = new ElcExportItemBean();
	            		 
	            		 eeb.setAmount(discountAmount.multiply(new BigDecimal(-1)));
	            		 eeb.setCode(rs.getString("FMaterialNum"));
	            		 eeb.setName(rs.getString("FMaterialName"));
	            		 eeb.setPrice(BigDecimal.ZERO);
	            		 eeb.setQuantity(BigDecimal.ZERO);
	            		 eeb.setTaxRate(BigDecimal.ZERO);
	            		 eeb.setUom("");
	            		 eeb.setType("1");//发票性质
	            		 eeb.setSpec(rs.getString("FModel"));
	            		 eeb.setCatalogCode(rs.getString("cftaxCode"));
	            		 eeb.setPreferentialPolicyFlg("0");
	            		 eeb.setAddedValueTaxFlg("0");
	            		 eeb.setZeroTaxRateFlg("1");
	            		 eb.getInvoice().getItems().add(eebDis);
	                 }
				 }
			}
			//导出发票
			if(exportBeanMap.size()>0) {
				return exeExoprt2Tax(ctx,exportBillID,exportBeanMap);
			}
		}catch(Exception err) {
			throw new Exception(err);
		}
		return null;
	}
	
	/**
	 * 红冲
	 */
	@Override
	protected String _ExportWriteBack2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(jsonStr);
		String companyID=json.getString("companyID");
		setDeafultSetting(ctx, companyID);
		String result=null;
		if(json.getString("opType").equals("own")) {
			JSONArray ja=json.getJSONArray("billIDs");
			String[] billIDs=new String[ja.size()];
			for(int i=0;i<ja.size();i++) {
				result=billIDs[i]=ja.getString(i);
			}
			ExportWriteBack2Tax(ctx,companyID,billIDs, json);
		}else if(json.getString("opType").equals("other")) {
			exeOtherWriteBack2Tax(ctx, companyID,json.getJSONArray("data"));
		}
		return result;
	}
	
	/**
	 * 其他单据冲回--部分冲回
	 * @param ctx
	 * @param companyID
	 * @param json
	 * @throws BOSException 
	 */
	private void exeOtherWriteBack2Tax(Context ctx,String companyID,JSONArray dataJa) throws BOSException{
		JSONObject jo,joBean;
		JSONArray jaBean;
		String entryID,taxCode;
		IRowSet rs;
		HashMap<String,JSONArray> tempMap=new HashMap<String, JSONArray>();
//		HashMap<String,ArrayList<>> tempMap=new HashMap<String, JSONArray>();
		try {
			for(int index=0;index<dataJa.size();index++) {
				jo=dataJa.getJSONObject(index);
				entryID=jo.getString("entryID");
				taxCode=jo.getString("taxCode");
				
				if(tempMap.containsKey(taxCode)) {
					jaBean=tempMap.get(taxCode);
				}else {
					jaBean=new JSONArray();
					tempMap.put(taxCode, jaBean);
				}
				
				rs=getEntryDetail(ctx, entryID);
				
				joBean=new JSONObject();
				jo.put("type", "0");
				jo.put("code", rs.getString("FMaterialNum"));
				jo.put("name", rs.getString("materialName"));
				jo.put("uom", rs.getString("Fmodel"));
				jo.put("price", "");//单价和数量要么都为空要么都不为空
				jo.put("quantity", "");//单价和数量要么都为空要么都不为空
				jo.put("uom", rs.getString("FUnitName"));
				jo.put("taxRate", rs.getDouble("FTaxRate"));
				jo.put("amount", jo.getString("offAmt"));
				jo.put("catalogCode", rs.getString("taxCode"));
				jo.put("perferentialPolicyFlgad", "0");
				jo.put("addedValueTaxFlg", "0");
				jo.put("zeroTaxRateFlg", "1");
				jaBean.add(joBean);
			}
			
			Iterator<Entry<String, JSONArray>> itr = tempMap.entrySet().iterator();
			String nowDateStr=sdf.format(new Date());
			String msg="",tempMsg;
			Entry<String, JSONArray> entry ;
			int index=0;
			while(itr.hasNext()) {
				entry = itr.next();
				joBean=new JSONObject();
				joBean.put("serialNo",String.valueOf(new Date().getTime())+"-"+(++index)) ;
				joBean.put("postTime",nowDateStr);
				joBean.put("originalCode",entry.getKey());//发票号
				joBean.put("reason", "业务冲红");
				joBean.put("items", entry.getValue());
				tempMsg=Erp2TaxHttpUtil.httpsPost(keystorePath, bdsInfo.getKeystoreAbner(), bdsInfo.getPasswd(),bdsInfo.getAppCode(), bdsInfo.getInterfaceUrl(), exportBackCMD, joBean.toString());
				msg+=tempMsg;
				joBean=JSONObject.fromObject(tempMsg);
				if(joBean.getInt("code")==0) {
//					reWriteTimeNo(ctx, null,"'"+ rs.getString("fid")+"'", null, null);
					//反写红冲信息
					reWriteOffResultByTaxCode(ctx, entry.getKey(), dataJa);
				}
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}
	
	/**
	 * 反写红冲结果
	 * @throws BOSException 
	 */
	private void reWriteOffResultByTaxCode(Context ctx,String taxCode,JSONArray ja) throws BOSException {
		JSONObject jo;
		StringBuffer sql=new StringBuffer();;
		
		for(int index=0;index<ja.size();index++) {
			jo=ja.getJSONObject(index);
			if(!jo.getString("taxCode").equals(taxCode)) {
				continue;
			}
			//更新冲回数量
			sql.append(" update  T_IM_SaleIssueEntry set CFHasOffAmt=isnull(CFHasOffAmt,0)+").append(jo.getString("offAmt"))
			.append(" ,cfhasoffQty=isnull(cfhasoffqty,0)+").append(jo.getString("offQty"))
			.append(" where FID='").append(jo.getString("entryID")).append("'")
			.append(" ;");
			DbUtil.execute(ctx, sql.toString());
			//如果全部冲完，则将单据置为原始状态
			sql.append(" /*dialect*/update T_IM_SaleIssueBill t1 set t1.cfhasExport2Tax=0,t1.cfserialNo=null,t1.cftaxcode=null ")
			.append(" where fid in (")
			.append(" select fparentid from T_IM_SaleIssueEntry ")
			.append(" where FID='").append(jo.getString("entryID")).append("'")
			.append(" )")
			.append(" and not exists(")
			.append(" select 1 from T_IM_SaleIssueEntry t2 where t2.fparentid=t1.fid")
			.append(" and FAmount!=CFHasOffAmt")
			.append(" )");
			DbUtil.execute(ctx, sql.toString());
			//如果分录已经冲完，则将数量置为0
			sql.append(" /*dialect*/ update  T_IM_SaleIssueEntry t2 set CFHasOffAmt=0,cfhasOffQty=0")
			.append(" where FID='").append(jo.getString("entryID")).append("'")
			.append(" and exists(")
			.append(" and select 1 from T_IM_SaleIssueBill t1 where t1.fid=t2.fparentid")
			.append(" and t1.cfhasExport2Tax=0 and t1.cfserialNo=null and cftaxcode=null")
			.append(" )")
			.append(" ;");
			DbUtil.execute(ctx, sql.toString());
			
		}
		if(sql.length()>0) {
			DbUtil.execute(ctx, sql.toString());
		}
	}
	
	/**
	 * 获取分录明细
	 * @param ctx
	 * @param entryID
	 * @return
	 * @throws BOSException 
	 */
	private IRowSet getEntryDetail(Context ctx,String entryID) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select tentry.fid FEntryID,tm.fnumber FMaterialNum,tm.fname_l2 FMaterialName,tm.FModel,tu.fname_l2 FUnitName,")
		.append(" tentry.ftaxRate,tentry.FQty,tentry.FTaxPrice,tentry.FAmount,tbill.CFTaxCode,tr.cftaxCode")
		.append(" from T_IM_SaleIssueBill tbill")
		.append(" inner join t_bd_customer tcus on tcus.fid=tbill.FCustomerID")
		.append(" inner join T_IM_SaleIssueEntry tentry on tentry.Fparentid=tbill.fid")
		.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialid")
		.append(" left join T_ERP_MaterialTaxCodeEntry tre on tre.fmaterialID=tm.fid")
		.append(" left join T_ERP_MaterialTaxCode tr on tr.fid=tre.fparentid")
		.append(" inner join t_bd_measureunit tu on tu.fid=tentry.FUnitID")
		.append(" where tentry.fid=?");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		return rs;
	}
	
	/**
	 * 红冲发票--全部冲回
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private String ExportWriteBack2Tax(Context ctx,String companyID,Object[] billIDs,JSONObject json) throws BOSException {
		StringBuffer exportBillIDs=new StringBuffer();
		for(int i=0;i<billIDs.length;i++) {
			if(exportBillIDs.length()>0) {
				exportBillIDs.append(",");
			}
			exportBillIDs.append("'").append(billIDs[i].toString()).append("'");
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select fid,isnull(cfserialNo,'') cfserialNo,isnull(cftaxCode,'') cftaxCode from T_IM_SaleIssueBill ")
		.append(" where fid in (").append(exportBillIDs).append(")")
//		.append(" and cfserialNo is not null")
		.append(" and cfhasExport2Tax=1")//已经导出的金税
		.append(" order by fnumber")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		String nowDateStr=sdf.format(new Date());
		String  msg="",tempMsg,taxCode,serialNo;
		ArrayList<String> hasWriteBackTaxCodeList=new ArrayList<String>();
		try {
			String[] tempArraySerialNo,tempArrayTaxCode;//拆分的话一个发票会会有多个数据
			while(rs.next()) {
				serialNo=rs.getString("cfserialNo");
				taxCode=rs.getString("cftaxCode");
				if(serialNo.contains(";")) {
					tempArraySerialNo=serialNo.split(";");
				}else {
					tempArraySerialNo=new String[]{serialNo};
				}
				if(StringUtils.isNotBlank(taxCode)) {
					if(serialNo.contains(";")) {
						tempArrayTaxCode=taxCode.split(";");
					}else {
						tempArrayTaxCode=new String[]{taxCode};
					}
				}else {
					tempArrayTaxCode=new String[tempArraySerialNo.length];
					for(int index=0;index<tempArrayTaxCode.length;index++) {
						tempArrayTaxCode[index]="";
					}
				}
				//遍历每一条记录
				for(int index=0;index<tempArraySerialNo.length;index++) {
					serialNo=tempArraySerialNo[index];
					taxCode=tempArrayTaxCode[index];
					if(StringUtils.isEmpty(serialNo)) {
						continue;
					}
					
					//尚未同步开票信息
					if(StringUtils.isEmpty(taxCode)) {
						tempMsg=exeSynSingle(ctx, rs.getString("fid"), serialNo);
						json=JSONObject.fromObject(tempMsg);
						if(json.getInt("code")==0) {
							taxCode=json.getJSONArray("invoices").getJSONObject(0).getString("code");
						}else {
							msg+="单据没有电子发票信息！";
						}
					}else {
						taxCode=tempArrayTaxCode[index];
					}
					
					if(!hasWriteBackTaxCodeList.contains(taxCode)){
						hasWriteBackTaxCodeList.add(taxCode);
						json=new JSONObject();
						json.put("serialNo",String.valueOf(new Date().getTime())+"-"+rs.getRow()) ;
						json.put("postTime",nowDateStr);
						json.put("originalCode",taxCode);//发票号
						json.put("reason", "业务作废");
						tempMsg=Erp2TaxHttpUtil.httpsPost(keystorePath, bdsInfo.getKeystoreAbner(), bdsInfo.getPasswd(),bdsInfo.getAppCode(), bdsInfo.getInterfaceUrl(), exportBackCMD, json.toString());
						msg+=tempMsg;
						json=JSONObject.fromObject(tempMsg);
						if(json.getInt("code")==0) {
							hasWriteBackTaxCodeList.add(taxCode);
							reWriteOffBack(ctx, "'"+ rs.getString("fid")+"'", null);
						}
					}else {
						reWriteOffBack(ctx, "'"+ rs.getString("fid")+"'", null);
					}
				}
			}
		}catch(Exception err){
			throw new BOSException(err);
		}
		return msg;
	}
	
	/**
	 * 反写完全 为红冲单据
	 * @throws BOSException 
	 */
	private void reWriteOffBack(Context ctx,String exportBillIDs,String entryIDs) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql.append(" update T_IM_SaleIssueBill")
		.append(" set CFSerialNo=''")
		.append(" ,cftaxcode=''")
		.append(" ,cfhasExport2Tax=0")
		.append(" where 1=1");
		if(StringUtils.isNotEmpty(exportBillIDs)) {
			sql.append(" and CFSerialNo in (select CFSerialNo from T_IM_SaleIssueBill where fid in (").append(exportBillIDs).append(")");
		}
		if(StringUtils.isNotEmpty(entryIDs)) {
			sql.append(" and fid in (")
			.append(" select distinct Fparentid from T_IM_SaleIssueEntry where fid in (").append(entryIDs).append(")")
			.append(")");
		}
		sql.append(" ;");
		//反写分录
		sql.append(" update T_IM_SaleIssueEntry set CFHasOffAmt=0,CFHasOffQty=0")
		.append(" where 1=1");
		if(StringUtils.isNotEmpty(exportBillIDs)) {
			sql.append(" and fparentid in (")
			.append(" select fid from T_IM_SaleIssueBill where CFSerialNo in (")
			.append(" select CFSerialNo from T_IM_SaleIssueBill where fid in (").append(exportBillIDs).append(")")
			.append(" )")
			.append(" )");
		}
		if(StringUtils.isNotEmpty(entryIDs))  {
			sql.append(" and fid in (").append(entryIDs).append("");
		}
			
		sql.append(" ")
		;
		DbUtil.execute(ctx, sql.toString());
	}
}