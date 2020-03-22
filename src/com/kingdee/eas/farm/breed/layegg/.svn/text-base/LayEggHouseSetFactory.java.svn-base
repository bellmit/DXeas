package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LayEggHouseSetFactory
{
    private LayEggHouseSetFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D7AFD1D0") ,com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet.class);
    }
    
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D7AFD1D0") ,com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D7AFD1D0"));
    }
    public static com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.layegg.ILayEggHouseSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D7AFD1D0"));
    }
}