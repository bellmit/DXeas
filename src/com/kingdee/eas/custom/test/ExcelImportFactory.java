package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExcelImportFactory
{
    private ExcelImportFactory()
    {
    }
    public static com.kingdee.eas.custom.test.IExcelImport getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelImport)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7343576B") ,com.kingdee.eas.custom.test.IExcelImport.class);
    }
    
    public static com.kingdee.eas.custom.test.IExcelImport getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelImport)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7343576B") ,com.kingdee.eas.custom.test.IExcelImport.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.IExcelImport getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelImport)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7343576B"));
    }
    public static com.kingdee.eas.custom.test.IExcelImport getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelImport)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7343576B"));
    }
}