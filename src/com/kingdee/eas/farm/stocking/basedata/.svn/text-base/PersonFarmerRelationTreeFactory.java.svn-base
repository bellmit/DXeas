package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRelationTreeFactory
{
    private PersonFarmerRelationTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8A12EF43") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8A12EF43") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8A12EF43"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelationTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8A12EF43"));
    }
}