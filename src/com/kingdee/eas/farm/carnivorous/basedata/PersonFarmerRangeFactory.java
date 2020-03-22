package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRangeFactory
{
    private PersonFarmerRangeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B444FBA3") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B444FBA3") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B444FBA3"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRange)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B444FBA3"));
    }
}