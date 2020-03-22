package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonFarmerRangeTreeFactory
{
    private PersonFarmerRangeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CC7059E1") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CC7059E1") ,com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CC7059E1"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IPersonFarmerRangeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CC7059E1"));
    }
}