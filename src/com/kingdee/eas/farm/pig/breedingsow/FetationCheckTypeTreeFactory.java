package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FetationCheckTypeTreeFactory
{
    private FetationCheckTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C8F77EFF") ,com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C8F77EFF") ,com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C8F77EFF"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C8F77EFF"));
    }
}