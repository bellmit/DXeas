package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IComplainBill extends IWlhlBillBase
{
    public ComplainBillCollection getComplainBillCollection() throws BOSException;
    public ComplainBillCollection getComplainBillCollection(EntityViewInfo view) throws BOSException;
    public ComplainBillCollection getComplainBillCollection(String oql) throws BOSException;
    public ComplainBillInfo getComplainBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ComplainBillInfo getComplainBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ComplainBillInfo getComplainBillInfo(String oql) throws BOSException, EASBizException;
}