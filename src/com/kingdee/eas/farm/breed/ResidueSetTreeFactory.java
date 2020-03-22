package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ResidueSetTreeFactory
{
    private ResidueSetTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IResidueSetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("84CC62EF") ,com.kingdee.eas.farm.breed.IResidueSetTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.IResidueSetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("84CC62EF") ,com.kingdee.eas.farm.breed.IResidueSetTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IResidueSetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("84CC62EF"));
    }
    public static com.kingdee.eas.farm.breed.IResidueSetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("84CC62EF"));
    }
}