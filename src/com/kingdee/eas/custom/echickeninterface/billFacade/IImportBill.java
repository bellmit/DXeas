package com.kingdee.eas.custom.echickeninterface.billFacade;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IImportBill {
	
	public abstract String importing(Context ctx,String billType,String billDataJSON,int billStatus)throws BOSException, EASBizException;
}
