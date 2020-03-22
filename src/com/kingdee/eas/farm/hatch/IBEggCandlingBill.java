package com.kingdee.eas.farm.hatch;

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

public interface IBEggCandlingBill extends ICoreBillBase
{
    public BEggCandlingBillCollection getBEggCandlingBillCollection() throws BOSException;
    public BEggCandlingBillCollection getBEggCandlingBillCollection(EntityViewInfo view) throws BOSException;
    public BEggCandlingBillCollection getBEggCandlingBillCollection(String oql) throws BOSException;
    public BEggCandlingBillInfo getBEggCandlingBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BEggCandlingBillInfo getBEggCandlingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BEggCandlingBillInfo getBEggCandlingBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BEggCandlingBillInfo model) throws BOSException, EASBizException;
    public void unAudit(BEggCandlingBillInfo model) throws BOSException, EASBizException;
    public void adjust(BEggCandlingBillInfo model) throws BOSException;
}