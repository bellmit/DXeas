package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AvgWgtSectionFactory
{
    private AvgWgtSectionFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("99C848B1") ,com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("99C848B1") ,com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("99C848B1"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSection)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("99C848B1"));
    }
}