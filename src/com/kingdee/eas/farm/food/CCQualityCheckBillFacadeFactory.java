package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCQualityCheckBillFacadeFactory
{
    private CCQualityCheckBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICCQualityCheckBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCQualityCheckBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("871FF6B4") ,com.kingdee.eas.farm.food.ICCQualityCheckBillFacade.class);
    }
    
    public static com.kingdee.eas.farm.food.ICCQualityCheckBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCQualityCheckBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("871FF6B4") ,com.kingdee.eas.farm.food.ICCQualityCheckBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICCQualityCheckBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCQualityCheckBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("871FF6B4"));
    }
    public static com.kingdee.eas.farm.food.ICCQualityCheckBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICCQualityCheckBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("871FF6B4"));
    }
}