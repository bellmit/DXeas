package com.kingdee.eas.mm.mo.app;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.custom.eas2temp.MMPlanInfo;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.util.app.DbUtil;

public class ManufactureOrderControllerBeanDep {
	/**
	 * 反写生产计划执行数量
	 * @param ctx
	 * @param info
	 */
	public void rewriteMMPlan(Context ctx,ManufactureOrderInfo info,boolean isPlus) {

		String srcbillIDString=info.getSourceBillId();
		if(StringUtils.isEmpty(srcbillIDString)) {
			return;
		}
		String bosType=BOSUuid.read(srcbillIDString).getType().toString();
		//生产计划
		if(!bosType.equals("1F3B6F9D")) {
			return;
		}
		
		BigDecimal qty=info.getQty();
		if(!isPlus) {
			qty=new BigDecimal(-1).multiply(qty);
		}
		String entryID=info.getSrcBillEntryID();
		try {
			DbUtil.execute(ctx, "update T_EAS_MMPlanEntry set FExedQty=isnull(FExedQty,0)+"+qty.toString()+" where fid='"+entryID+"'");
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}
}
