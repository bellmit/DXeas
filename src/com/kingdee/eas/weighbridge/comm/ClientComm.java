package com.kingdee.eas.weighbridge.comm;

import java.lang.reflect.Method;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBase;

public class ClientComm {
	
	/**
	 * BOTP生成单据
	 * 
	 * @throws BOSException
	 */
	public static BTPTransformResult createToSCMBill(CoreBillBaseInfo info, String orderBillBosType) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getRemoteInstance");
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls);

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getRemoteInstance();
			// [注释]获取BTP的本地接口
			result = btp.transform(info, orderBillBosType);
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			destBillInfo = result.getBills().getObject(0);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// 目标单据Id

			
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e1) {// botp 失败 删除单据
			throw new BOSException(e1.getMessage());
		}
		return result;
	}
}
