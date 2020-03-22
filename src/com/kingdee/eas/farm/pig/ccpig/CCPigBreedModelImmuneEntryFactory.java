package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBreedModelImmuneEntryFactory
{
    private CCPigBreedModelImmuneEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7879BC8C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7879BC8C") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7879BC8C"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelImmuneEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7879BC8C"));
    }
}