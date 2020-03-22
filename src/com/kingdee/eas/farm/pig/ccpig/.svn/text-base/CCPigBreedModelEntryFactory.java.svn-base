package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBreedModelEntryFactory
{
    private CCPigBreedModelEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("38FC290F") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("38FC290F") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("38FC290F"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("38FC290F"));
    }
}