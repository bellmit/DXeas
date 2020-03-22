package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleStandardTreeFactory
{
    private SettleStandardTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEB655F7") ,com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEB655F7") ,com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEB655F7"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettleStandardTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEB655F7"));
    }
}