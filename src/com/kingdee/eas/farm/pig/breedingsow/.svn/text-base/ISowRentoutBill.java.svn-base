package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISowRentoutBill extends ICoreBillBase
{
    public SowRentoutBillCollection getSowRentoutBillCollection() throws BOSException;
    public SowRentoutBillCollection getSowRentoutBillCollection(EntityViewInfo view) throws BOSException;
    public SowRentoutBillCollection getSowRentoutBillCollection(String oql) throws BOSException;
    public SowRentoutBillInfo getSowRentoutBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SowRentoutBillInfo getSowRentoutBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SowRentoutBillInfo getSowRentoutBillInfo(String oql) throws BOSException, EASBizException;
}