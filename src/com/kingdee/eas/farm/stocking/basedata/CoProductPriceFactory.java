package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoProductPriceFactory
{
    private CoProductPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("566729B7") ,com.kingdee.eas.farm.stocking.basedata.ICoProductPrice.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("566729B7") ,com.kingdee.eas.farm.stocking.basedata.ICoProductPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("566729B7"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("566729B7"));
    }
}