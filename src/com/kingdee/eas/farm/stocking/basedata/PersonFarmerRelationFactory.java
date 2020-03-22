package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRelationFactory
{
    private PersonFarmerRelationFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("26BD9205") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("26BD9205") ,com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("26BD9205"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IPersonFarmerRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("26BD9205"));
    }
}