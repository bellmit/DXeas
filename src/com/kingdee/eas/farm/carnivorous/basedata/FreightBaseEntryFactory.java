package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreightBaseEntryFactory
{
    private FreightBaseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("03C3B1C0") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("03C3B1C0") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("03C3B1C0"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBaseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("03C3B1C0"));
    }
}