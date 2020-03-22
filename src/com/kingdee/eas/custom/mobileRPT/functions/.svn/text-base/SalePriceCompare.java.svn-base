package com.kingdee.eas.custom.mobileRPT.functions;

import java.math.BigDecimal;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.mobileRPT.IDownload;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SalePriceCompare implements IDownload {

	@Override
	public JSONArray downloadData(Context ctx, JSONObject queryJSON)
			throws Exception {
		// TODO Auto-generated method stub
		String date;
		String companyID;
		if(queryJSON.containsKey("date") && StringUtils.isNotBlank(queryJSON.getString("date"))){
			date = queryJSON.getString("date");
		}else{
			throw new BOSException("查询条件：日期  不允许为空！");
		}
//		if(queryJSON.containsKey("companyID") && StringUtils.isNotBlank(queryJSON.getString("companyID"))){
//			companyID = queryJSON.getString("companyID");
//		}else{
//			throw new BOSException("查询条件：公司   不允许为空！");
//		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("").append("\n");
		sql.append("insert into T_PRICE(materialNO,materialName,model) ").append("\n");
		sql.append("SELECT ").append("\n");
		sql.append("distinct tm.fnumber,tm.fname_l2,tm.fmodel ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.FmaterialID ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' ").append("\n");
		sql.append("order by tm.fnumber").append("\n");
		DbUtil.execute(ctx, sql.toString());

		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='11') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"临沂A线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='12') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"临沂B线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='21') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"临沭A线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='22') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"临沭B线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='31') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"沂南A线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='32') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"沂南B线\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("/*dialect*/ ");
		sql.append("merge into T_PRICE ").append("\n");
		sql.append("using ").append("\n");
		sql.append("(SELECT ").append("\n");
		sql.append("  tm.fnumber,tentry.FPrice ").append("\n");
		sql.append("FROM T_STO_SalesPrice tmain ").append("\n");
		sql.append("inner join T_STO_SalesPriceEntry tentry on tentry.fparentid=tmain.fid ").append("\n");
		sql.append("inner join t_bd_material tm on tm.fid=tentry.fmaterialid ").append("\n");
		sql.append("inner join t_org_baseUnit torg on torg.fid=tentry.forgunitid ").append("\n");
		sql.append("where to_char(tmain.fbizDate,'yyyy-MM-dd')='"+date+"' and torg.fNumber='4') t ").append("\n");
		sql.append("on (T_PRICE.materialNO=t.fnumber) ").append("\n");
		sql.append("when matched then ").append("\n");
		sql.append("update set T_PRICE.\"江苏\"=t.FPrice ").append("\n");
		DbUtil.execute(ctx, sql.toString());
		
		sql.setLength(0);
		sql.append("select materialNO,materialName,model,\"临沂A线\",\"临沂B线\",\"临沭A线\",\"临沭B线\",\"沂南A线\",\"沂南B线\",\"江苏\" from T_PRICE");
		System.out.println(sql.toString());
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo = null;
		JSONArray ja = new JSONArray();
		while(rs.next()){
			jo = new JSONObject();
			jo.put("materilaNO", rs.getString("materialNO"));
			jo.put("materialName", rs.getString("materialName"));
			jo.put("model", rs.getString("model"));
			jo.put("临沂A线", StringUtils.isNotBlank(rs.getString("临沂A线"))? rs.getBigDecimal("临沂A线"):BigDecimal.ZERO);
			jo.put("临沂B线", StringUtils.isNotBlank(rs.getString("临沂B线"))? rs.getBigDecimal("临沂B线"):BigDecimal.ZERO);
			jo.put("临沭A线", StringUtils.isNotBlank(rs.getString("临沭A线"))? rs.getBigDecimal("临沭A线"):BigDecimal.ZERO);
			jo.put("临沭B线", StringUtils.isNotBlank(rs.getString("临沭B线"))? rs.getBigDecimal("临沭B线"):BigDecimal.ZERO);
			jo.put("沂南A线", StringUtils.isNotBlank(rs.getString("沂南A线"))? rs.getBigDecimal("沂南A线"):BigDecimal.ZERO);
			jo.put("沂南B线", StringUtils.isNotBlank(rs.getString("沂南B线"))? rs.getBigDecimal("沂南B线"):BigDecimal.ZERO);
			jo.put("江苏", StringUtils.isNotBlank(rs.getString("江苏"))? rs.getBigDecimal("江苏"):BigDecimal.ZERO);
			ja.add(jo);
		}
		DbUtil.execute(ctx, "truncate table T_PRICE");
		return ja;
	}

}
