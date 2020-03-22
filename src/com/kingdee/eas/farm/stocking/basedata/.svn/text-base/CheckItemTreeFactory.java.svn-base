package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckItemTreeFactory
{
    private CheckItemTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItemTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItemTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B3012C8") ,com.kingdee.eas.farm.stocking.basedata.ICheckItemTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItemTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItemTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B3012C8") ,com.kingdee.eas.farm.stocking.basedata.ICheckItemTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItemTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItemTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B3012C8"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItemTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItemTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B3012C8"));
    }
}