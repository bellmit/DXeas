package com.kingdee.eas.farm.foodtrac.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 条码 信息 
 * 保存解析后的条码信息
 * @author USER
 *
 */
public class BarCodeInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2863304176890119292L;
//	private Context ctx;
	
	private Map<String,String> values;
	
	private String barcode;
	
	/**
	 * 构造方法
	 * @param barcode
	 * @throws BOSException 
	 */
	public BarCodeInfo(Context ctx,String barcode) throws BOSException{
//		this.ctx = ctx;
		this.barcode = barcode;
		values = new HashMap<String, String>();
		this.setBarcodeInfos(ctx,barcode);
		
		
	}
	
	
	/**
	 * 
	 * @param barcode
	 * @throws BOSException 
	 */
	private void setBarcodeInfos(Context ctx, String barcode) throws BOSException{
		try{
			if(StringUtils.isNotBlank(barcode)){
				StringBuffer sb = new StringBuffer();
				sb.append(" select tiie.cfname,te.cfvalue from CT_IND_BarcodeDossier t "); 
				sb.append(" inner join CT_IND_BarcodeDossierEntry te on t.fid = te.fparentid ");
				sb.append(" inner join CT_IND_IndBarcodeMasterEntry tiie on te.cfdisplaynameid = tiie.fid ");
				sb.append(" where t.fnumber = '");
				sb.append(StringUtils.trim(barcode));
				sb.append("'");
				IRowSet rs = null;
				if(ctx != null){
					rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, sb.toString());
					
				}else{
					rs = ToolFacadeFactory.getRemoteInstance().executeQuery(sb.toString());
				}
				
				if(rs.size() <= 0) throw new BOSException("输入条码无效");
				while(rs.next()){
					String name = rs.getString("cfname");
					String value = rs.getString("cfvalue");
					values.put(name, value);
					
				}
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
	}
	/**
	 * 原始条码信息
	 * @return
	 */
	public String getBarcode(){
		return this.barcode;
	}
	/**
	 * 获取产品编码
	 * @return
	 */
	public String getProductNumber(){
		return this.values.get("物料编码");
	}
	/**
	 * 获取产品名称
	 * @return
	 */
	public String getProductName(){
		return this.values.get("物料名称");
	}
	/**
	 * 获取生产日期字符串
	 * @return
	 */
	public String getProductDateStr(){
		return this.values.get("生产日期");
	}
	/**
	 * 获取生产日期
	 * @return
	 * @throws BOSException 
	 */
	public Date getProductDate() throws BOSException{
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.parse(getProductDateStr());
		}catch(ParseException pe){
			pe.printStackTrace();
			throw new BOSException(pe);
		}
	}
	/**
	 * 获取批次
	 * @return
	 */
	public String getBatchcode(){
		return this.values.get("批次");
	}
	/**
	 * 获得批号
	 * @return
	 */
	public String getFarmCode(){
		return this.values.get("批号");
	}
	/**
	 * 获得规格型号
	 * @return
	 */
	public String getModel(){
		return this.values.get("规格型号");
	}
	/**
	 * 获取数量
	 * @return
	 */
	public BigDecimal getQty(){
		return new BigDecimal(this.values.get("数量"));
	}
}
