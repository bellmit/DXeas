package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StrainFactory
{
    private StrainFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IStrain getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrain)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E00CBB5") ,com.kingdee.eas.farm.pig.IStrain.class);
    }
    
    public static com.kingdee.eas.farm.pig.IStrain getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrain)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E00CBB5") ,com.kingdee.eas.farm.pig.IStrain.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IStrain getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrain)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E00CBB5"));
    }
    public static com.kingdee.eas.farm.pig.IStrain getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrain)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E00CBB5"));
    }
}