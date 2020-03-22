package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalaryVoucherEntryAssistActItemFactory
{
    private SalaryVoucherEntryAssistActItemFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D9CBA13F") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D9CBA13F") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D9CBA13F"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherEntryAssistActItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D9CBA13F"));
    }
}