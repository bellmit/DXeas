package com.kingdee.eas.custom.dep.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.common.app.AppCommonUtil;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportSaleOrder;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
//import com.kingdee.eas.custom.xszr.JszrFactory;
//import com.kingdee.eas.custom.xszr.JszrInfo;
import com.kingdee.eas.farm.breed.BreedStage;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 成本对象 dep后台
 * @author Administrator
 *
 */
public class CostObjectControllerBeanDep {

	
	/**
	 * 将 成本对象 反写 到对应的成本对象上 
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void updateBreedBatchCostObject(Context ctx, IObjectValue objValue) throws BOSException,
			EASBizException {
		CostObjectInfo costInfo = (CostObjectInfo) objValue;
		// 成本对象不为空，同时包含批次设置，则更新对应的 批次成本对象
		if(costInfo != null){
			// 如果成本对象没有设置批次信息，则判断 是否 之前已经与批次关联，如果有 则删除之前 批次关联关系
			// 先清理之前的 关联   再 重新 建立关联关系
			String upSql1 = "update ct_fm_parentbreedbatch set ";
			String upSql2 = "= null where ";
			String upSql3 = "=? ";
			Object[] args = {costInfo.getId().toString()};
			DbUtil.execute(ctx, upSql1 + "CFBabyCostObjectID" +upSql2 + "CFBabyCostObjectID" + upSql3,args);
			DbUtil.execute(ctx, upSql1 + "CFYoungCostObjectI" +upSql2 + "CFYoungCostObjectI" + upSql3,args);
//			DbUtil.execute(ctx, upSql1 + "CFAdultCostObjectI" +upSql2 + "CFAdultCostObjectI" + upSql3,args);
			DbUtil.execute(ctx, upSql1 + "CFEggCostObjectID" +upSql2 + "CFEggCostObjectID" + upSql3,args);
			
			ParentBreedBatchInfo parentBatchInfo = (ParentBreedBatchInfo) costInfo.getObjectValue("parentBreedBatch");
			String stageStr = costInfo.getString("breedStage");
			BreedStage stage = null;
			if(stageStr != null){
				stage = BreedStage.getEnum(stageStr);
			}
			// 校验批次和 批次阶段不能为空
			if(stage != null && !BreedStage.null_value.equals(stage)){
				if(parentBatchInfo == null){
					throw new BOSException("已选批次阶段，请填写对应养殖批次");
				}
			}else if(parentBatchInfo != null){
				throw new BOSException("已选养殖批次，请填写对应批次阶段");
			}else{
				// 如果都为空  则
			}
			// 更新 对应 批次 的成本对象
			if(parentBatchInfo != null){
				
				String costFieldStr = "";
//				if(stage.getValue() == BreedStage.BABY_VALUE){
//					costFieldStr = "CFBabyCostObjectID";
//				}else
					if(stage.getValue() == BreedStage.BROOD_VALUE){
					costFieldStr = "CFYoungCostObjectI";
//				}else if(stage.getValue() == BreedStage.LAYEGG_VALUE){
//					costFieldStr = "CFAdultCostObjectI";
				}else if(stage.getValue() == BreedStage.EGG_VALUE){
					costFieldStr = "CFEggCostObjectID";
				}
				// 执行更新
				String upSql = "update ct_fm_parentbreedbatch set " + costFieldStr + "=? where fid=?";
				Object[] args1 = {costInfo.getId().toString(),parentBatchInfo.getId().toString()};
				DbUtil.execute(ctx, upSql,args1);
			}else{
				
			}
			
			
		}
	}

	
}
