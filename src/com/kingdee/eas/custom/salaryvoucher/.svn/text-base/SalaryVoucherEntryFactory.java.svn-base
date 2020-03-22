package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalaryVoucherEntryFactory
{
    private SalaryVoucherEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69C849DD") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69C849DD") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69C849DD"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69C849DD"));
    }
}