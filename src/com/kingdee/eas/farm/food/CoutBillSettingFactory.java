package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoutBillSettingFactory
{
    private CoutBillSettingFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICoutBillSetting getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSetting)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E105C954") ,com.kingdee.eas.farm.food.ICoutBillSetting.class);
    }
    
    public static com.kingdee.eas.farm.food.ICoutBillSetting getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSetting)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E105C954") ,com.kingdee.eas.farm.food.ICoutBillSetting.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICoutBillSetting getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSetting)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E105C954"));
    }
    public static com.kingdee.eas.farm.food.ICoutBillSetting getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSetting)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E105C954"));
    }
}