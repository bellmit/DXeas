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
 * �ɱ����� dep��̨
 * @author Administrator
 *
 */
public class CostObjectControllerBeanDep {

	
	/**
	 * �� �ɱ����� ��д ����Ӧ�ĳɱ������� 
	 * @param ctx
	 * @param pk
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void updateBreedBatchCostObject(Context ctx, IObjectValue objValue) throws BOSException,
			EASBizException {
		CostObjectInfo costInfo = (CostObjectInfo) objValue;
		// �ɱ�����Ϊ�գ�ͬʱ�����������ã�����¶�Ӧ�� ���γɱ�����
		if(costInfo != null){
			// ����ɱ�����û������������Ϣ�����ж� �Ƿ� ֮ǰ�Ѿ������ι���������� ��ɾ��֮ǰ ���ι�����ϵ
			// ������֮ǰ�� ����   �� ���� ����������ϵ
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
			// У�����κ� ���ν׶β���Ϊ��
			if(stage != null && !BreedStage.null_value.equals(stage)){
				if(parentBatchInfo == null){
					throw new BOSException("��ѡ���ν׶Σ�����д��Ӧ��ֳ����");
				}
			}else if(parentBatchInfo != null){
				throw new BOSException("��ѡ��ֳ���Σ�����д��Ӧ���ν׶�");
			}else{
				// �����Ϊ��  ��
			}
			// ���� ��Ӧ ���� �ĳɱ�����
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
				// ִ�и���
				String upSql = "update ct_fm_parentbreedbatch set " + costFieldStr + "=? where fid=?";
				Object[] args1 = {costInfo.getId().toString(),parentBatchInfo.getId().toString()};
				DbUtil.execute(ctx, upSql,args1);
			}else{
				
			}
			
			
		}
	}

	
}
