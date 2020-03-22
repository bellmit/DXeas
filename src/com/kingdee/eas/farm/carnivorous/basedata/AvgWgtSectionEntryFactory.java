package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AvgWgtSectionEntryFactory
{
    private AvgWgtSectionEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("522E9641") ,com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("522E9641") ,com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("522E9641"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IAvgWgtSectionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("522E9641"));
    }
}