package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BorrowItemReturnFactory
{
    private BorrowItemReturnFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("723CAF9A") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("723CAF9A") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("723CAF9A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturn)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("723CAF9A"));
    }
}