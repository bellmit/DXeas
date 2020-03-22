package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBreedModelTreeFactory
{
    private CCPigBreedModelTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D384B61") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D384B61") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D384B61"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBreedModelTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D384B61"));
    }
}