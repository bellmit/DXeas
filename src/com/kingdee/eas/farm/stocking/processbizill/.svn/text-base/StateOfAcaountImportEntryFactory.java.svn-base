package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StateOfAcaountImportEntryFactory
{
    private StateOfAcaountImportEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F321F045") ,com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F321F045") ,com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F321F045"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImportEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F321F045"));
    }
}