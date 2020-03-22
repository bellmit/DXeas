package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayrateFeeItemFactory
{
    private DayrateFeeItemFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3D245642") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItem.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3D245642") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3D245642"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3D245642"));
    }
}