package com.kingdee.eas.custom.taihe.utils;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.basesetting.ITaiheBaseSetting;
import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingCollection;
import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingFactory;
import com.kingdee.eas.custom.taihe.basesetting.TaiheBaseSettingInfo;

/**
 * 太合工具类
 * @author dai_andong
 *
 */
public class TaiheUtils {
	/**
	 * 获取基础配置
	 * @param ctx
	 * @param companyID
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static TaiheBaseSettingInfo getBaseSetting(Context ctx,String companyID) throws BOSException, EASBizException {
		if(StringUtils.isNotEmpty(companyID)) {
			ITaiheBaseSetting is =null;
			if(ctx!=null) {
				is=TaiheBaseSettingFactory.getLocalInstance(ctx);
			}else {
				is=TaiheBaseSettingFactory.getRemoteInstance();
			}
			TaiheBaseSettingCollection cols = is.getTaiheBaseSettingCollection("where company.id='"+companyID+"'");
			if(!cols.isEmpty()) {
				return is.getTaiheBaseSettingInfo(new ObjectUuidPK(cols.get(0).getId()));
			}
		}
		return null;
	}
}
