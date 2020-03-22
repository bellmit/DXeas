package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoutBillSettingMaterialEntryFactory
{
    private CoutBillSettingMaterialEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D8DF0297") ,com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D8DF0297") ,com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D8DF0297"));
    }
    public static com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.ICoutBillSettingMaterialEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D8DF0297"));
    }
}