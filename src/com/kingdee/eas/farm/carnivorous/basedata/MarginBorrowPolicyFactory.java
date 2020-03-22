package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarginBorrowPolicyFactory
{
    private MarginBorrowPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C238A177") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C238A177") ,com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C238A177"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarginBorrowPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C238A177"));
    }
}