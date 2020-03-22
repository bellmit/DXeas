package com.kingdee.eas.custom.taihe.weight.app;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK; //import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean; //import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.szcount.SzSemiProductEntryCollection;
import com.kingdee.eas.custom.taihe.weight.CarcassEntryCollection;
import com.kingdee.eas.custom.taihe.weight.CarcassEntryInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassEntrysSCollection;
import com.kingdee.eas.custom.taihe.weight.CarcassEntrysSInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassFactory;
import com.kingdee.eas.custom.taihe.weight.CarcassInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.custom.taihe.weight.ICarcass;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlBotpCommUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;
import java.math.BigDecimal;

public class CarcassFacadeControllerBean extends
		AbstractCarcassFacadeControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.custom.taihe.weight.app.CarcassFacadeControllerBean");

	@Override
	protected String _createBill(Context ctx, String params)
			throws BOSException {
		// TODO Auto-generated method stub
		JSONArray jsa = JSONArray.fromObject(params);
		System.out.println(jsa);
		if (jsa.size() > 0) {
			for (int i = 0; i < jsa.size(); i++) {
				try {
					JSONObject json = jsa.getJSONObject(i); // 遍历 jsonarray
					// 数组，把每一个对象转成 json 对象
					String companyNum = json.getString("companyNum");
					String companyID = getCompanyID(ctx, companyNum);
					String Bizdate = json.getString("date");
					String carOrder = json.getString("carOrder");
					String wgt = json.getString("wgt");
					String qty = json.getString("qty");
					BigDecimal wgtB = new BigDecimal(wgt);
					BigDecimal qtyB = new BigDecimal(qty);
					StringBuffer sb = new StringBuffer();
					sb.append("select * from CT_WEI_Carcass where to_char(fbizDate,'yyyy-MM-dd') = '")
					.append(Bizdate).append("' and CFTrain = '")
					.append(carOrder).append("' and FCompanyID = '").append(companyID).append("'");
					IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
					if(rs.next()){
						
					}else{
						CarcassInfo ccInfo = new CarcassInfo();
						CarcassEntryCollection ec = ccInfo.getEntrys();
						CarcassEntryInfo ccEInfo = new CarcassEntryInfo();
						CarcassEntrysSCollection ecc = ccInfo.getEntrysS();
						Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Bizdate);
						CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
						companyInfo.setId(BOSUuid.read(companyID));
						
						ccInfo.setCompany(companyInfo);
						ccInfo.setBizDate(date);
						ccInfo.setBillStatus(BillBaseStatusEnum.SUBMITED);
						ccInfo.setNumber(WlhlBotpCommUtils.getAutoCode(ctx, ccInfo, companyID));
						ccInfo.setTrain(Integer.valueOf(carOrder).intValue());
						//ccEInfo.setCarcassType(CarcassType.carcass);
						ccEInfo.setQty(qtyB);
						ccEInfo.setWgt(wgtB);
						ec.add(ccEInfo);
						JSONArray mxja = new JSONArray();
						mxja = json.getJSONArray("data");
						for (int a = 0; a < mxja.size(); a++) {
							JSONObject mxjs = mxja.getJSONObject(a);
							if(mxjs.has("mxtime")){
								CarcassEntrysSInfo info = new CarcassEntrysSInfo();
								String mxtime = mxjs.getString("mxtime");
								String mxwgt = mxjs.getString("mxwgt");
								BigDecimal bgmxwgt = new BigDecimal(mxwgt);
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date mxtimeDate=sdf.parse(mxtime);
								info.setDtime(mxtimeDate);
								info.setDweight(bgmxwgt);
								ecc.add(info);
							}
							
						}
						ICarcass ic = CarcassFactory.getLocalInstance(ctx);
						ic.save(ccInfo);
					}
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		JSONObject jsResult = new JSONObject();
		jsResult.put("message", "success");
		return jsResult.toString();
	}

	private String getCompanyID(Context ctx, String Number) {
		String sql = "select FID from T_ORG_BaseUnit where FNumber ='" + Number
				+ "' ";
		IRowSet rs;
		String companyID = null;
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
			if (rs.next()) {
				companyID = rs.getString("FID");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return companyID;

	}
}