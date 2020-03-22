package com.kingdee.eas.farm.stocking.dep.app;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;

/**
 * 成本对象dep
 */
public class CostObjectControllerBeanDep {
	/**
	 * 更新批次的成本对象
	 * @param ctx
	 */
	public static void updateBatchCostObject(Context ctx,Object obj) {

		try {
			CostObjectInfo cInfo=null;
			if(obj instanceof IObjectPK) {
				cInfo=CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo((IObjectPK)obj);
			}
			if(obj instanceof CostObjectInfo) {
				cInfo=(CostObjectInfo) obj;
			}
			if(cInfo.getObjectValue("stockingBatch")!=null) {
				StockingBatchInfo bInfo=(StockingBatchInfo) cInfo.getObjectValue("stockingBatch");
				bInfo.setEggCostItem(cInfo);
				StockingBatchFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bInfo.getId()),bInfo);
			}
		} catch (EASBizException e) {
			e.printStackTrace();
		} catch (BOSException e) {
			e.printStackTrace();
		}
	}
}
