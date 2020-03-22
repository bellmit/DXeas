package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarTreeFactory
{
    private BoarTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F2D483B8") ,com.kingdee.eas.farm.pig.breedingboar.IBoarTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F2D483B8") ,com.kingdee.eas.farm.pig.breedingboar.IBoarTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F2D483B8"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F2D483B8"));
    }
}