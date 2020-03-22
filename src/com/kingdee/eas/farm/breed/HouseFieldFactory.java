package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HouseFieldFactory
{
    private HouseFieldFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IHouseField getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHouseField)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64EAEE94") ,com.kingdee.eas.farm.breed.IHouseField.class);
    }
    
    public static com.kingdee.eas.farm.breed.IHouseField getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHouseField)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64EAEE94") ,com.kingdee.eas.farm.breed.IHouseField.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IHouseField getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHouseField)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64EAEE94"));
    }
    public static com.kingdee.eas.farm.breed.IHouseField getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IHouseField)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64EAEE94"));
    }
}