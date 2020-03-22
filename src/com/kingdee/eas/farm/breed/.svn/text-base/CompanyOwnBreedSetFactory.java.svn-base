package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyOwnBreedSetFactory
{
    private CompanyOwnBreedSetFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.ICompanyOwnBreedSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICompanyOwnBreedSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FFA6F611") ,com.kingdee.eas.farm.breed.ICompanyOwnBreedSet.class);
    }
    
    public static com.kingdee.eas.farm.breed.ICompanyOwnBreedSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICompanyOwnBreedSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FFA6F611") ,com.kingdee.eas.farm.breed.ICompanyOwnBreedSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.ICompanyOwnBreedSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICompanyOwnBreedSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FFA6F611"));
    }
    public static com.kingdee.eas.farm.breed.ICompanyOwnBreedSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.ICompanyOwnBreedSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FFA6F611"));
    }
}