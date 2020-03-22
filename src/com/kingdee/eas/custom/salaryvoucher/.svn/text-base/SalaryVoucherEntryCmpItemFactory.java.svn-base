package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalaryVoucherEntryCmpItemFactory
{
    private SalaryVoucherEntryCmpItemFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("00F648DC") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("00F648DC") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("00F648DC"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryCmpItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("00F648DC"));
    }
}