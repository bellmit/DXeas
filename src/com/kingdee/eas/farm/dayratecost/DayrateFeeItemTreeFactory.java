package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DayrateFeeItemTreeFactory
{
    private DayrateFeeItemTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CAD34D00") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree.class);
    }
    
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CAD34D00") ,com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CAD34D00"));
    }
    public static com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.dayratecost.IDayrateFeeItemTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CAD34D00"));
    }
}