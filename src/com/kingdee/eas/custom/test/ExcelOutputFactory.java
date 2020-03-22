package com.kingdee.eas.custom.test;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ExcelOutputFactory
{
    private ExcelOutputFactory()
    {
    }
    public static com.kingdee.eas.custom.test.IExcelOutput getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelOutput)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7DF2FCC7") ,com.kingdee.eas.custom.test.IExcelOutput.class);
    }
    
    public static com.kingdee.eas.custom.test.IExcelOutput getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelOutput)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7DF2FCC7") ,com.kingdee.eas.custom.test.IExcelOutput.class, objectCtx);
    }
    public static com.kingdee.eas.custom.test.IExcelOutput getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelOutput)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7DF2FCC7"));
    }
    public static com.kingdee.eas.custom.test.IExcelOutput getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.test.IExcelOutput)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7DF2FCC7"));
    }
}