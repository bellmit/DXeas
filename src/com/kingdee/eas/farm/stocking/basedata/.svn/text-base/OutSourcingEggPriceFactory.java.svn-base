package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutSourcingEggPriceFactory
{
    private OutSourcingEggPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("578FBAF9") ,com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("578FBAF9") ,com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("578FBAF9"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOutSourcingEggPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("578FBAF9"));
    }
}