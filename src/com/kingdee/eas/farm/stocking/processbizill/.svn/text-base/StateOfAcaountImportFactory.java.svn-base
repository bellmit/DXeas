package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StateOfAcaountImportFactory
{
    private StateOfAcaountImportFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EEDDBC2D") ,com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EEDDBC2D") ,com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EEDDBC2D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IStateOfAcaountImport)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EEDDBC2D"));
    }
}