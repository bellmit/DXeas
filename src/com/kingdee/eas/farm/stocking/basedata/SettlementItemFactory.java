package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementItemFactory
{
    private SettlementItemFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BC1156D") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItem.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BC1156D") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BC1156D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BC1156D"));
    }
}