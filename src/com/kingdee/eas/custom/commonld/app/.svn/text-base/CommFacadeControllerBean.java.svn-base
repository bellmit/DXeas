package com.kingdee.eas.custom.commonld.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.lang.String;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;

public class CommFacadeControllerBean extends AbstractCommFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.commonld.app.CommFacadeControllerBean");
    
    /**
     * 执行一段sql
     */
    protected void _excuteUpdateSql(Context ctx, String str)throws BOSException, EASBizException
    {
    	DbUtil.execute(ctx, str);
    }
    /**
     * 返回服务器时间
     */
    protected Date _getDateFromServer(Context ctx)throws BOSException
    {
        return new Date();
    }
}