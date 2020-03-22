package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FetationCheckTypeFactory
{
    private FetationCheckTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D6F75FC1") ,com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D6F75FC1") ,com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D6F75FC1"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IFetationCheckType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D6F75FC1"));
    }
}