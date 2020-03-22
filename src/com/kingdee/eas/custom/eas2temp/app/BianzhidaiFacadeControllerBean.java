package com.kingdee.eas.custom.eas2temp.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;

public class BianzhidaiFacadeControllerBean extends AbstractBianzhidaiFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.eas2temp.app.BianzhidaiFacadeControllerBean");

	@Override
	public RptParams query(Context ctx, RptParams params) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		String cuID = params.getString("cuID");
		String cuNumber = params.getString("cuNumber");
		String dateFrom = params.getString("dateFrom");
		String dateTo = params.getString("dateTo");
		
		StringBuffer sql = new StringBuffer();

		sql.append(" /*dialect*/ ");
		sql.append(" select m.fnumber 物料编码,decode(m.fname_l2,null,'小计',m.fname_l2) 物料名称,mu.fname_l2 计量单位,m.fmodel 规格型号, mfo.fnumber,co.fname_l2 成本对象,sum(ms.fqty) 标准领用量");
		sql.append(" from T_MM_ManufactureOrder  mfo");
		sql.append(" inner join T_MM_MFTOrderStock ms on ms.fparentid=mfo.fid");
		sql.append(" inner join T_BD_CostObject co on co.fid=mfo.FCostObjectID");
		sql.append(" inner join T_BD_Material m on ms.fmaterialid=m.fid");
		sql.append(" inner join T_BD_MeasureUnit mu on mu.fid=m.fbaseunit");
		sql.append(" where mfo.fstorageorgunitid='").append(cuID).append("'");
		sql.append(" and mfo.faudittime>={ts'").append(dateFrom).append(" 00:00:00'}");
		sql.append(" and mfo.faudittime<={ts'").append(dateTo).append(" 23:59:59'}");
		sql.append(" and m.fmaterialgroupid='AUg7fjEiT8eVnLM9X3kGTcefwEI='");
		sql.append(" group by  rollup(m.fnumber,(m.fname_l2,mu.fname_l2,m.fmodel,mfo.fnumber,ms.fqty,co.fname_l2))");
	
		RptRowSet rs = this.executeQuery(sql.toString(),null, ctx);
		RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
		return pp;
	}

}