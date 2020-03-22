package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BorrowItemReturnEntryFactory
{
    private BorrowItemReturnEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E2318F8") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E2318F8") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E2318F8"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowItemReturnEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E2318F8"));
    }
}