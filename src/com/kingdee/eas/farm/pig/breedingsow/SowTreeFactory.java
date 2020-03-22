package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowTreeFactory
{
    private SowTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("73273298") ,com.kingdee.eas.farm.pig.breedingsow.ISowTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("73273298") ,com.kingdee.eas.farm.pig.breedingsow.ISowTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("73273298"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("73273298"));
    }
}