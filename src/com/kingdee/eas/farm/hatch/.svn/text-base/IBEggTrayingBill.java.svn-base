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

public interface IBEggTrayingBill extends ICoreBillBase
{
    public BEggTrayingBillCollection getBEggTrayingBillCollection() throws BOSException;
    public BEggTrayingBillCollection getBEggTrayingBillCollection(EntityViewInfo view) throws BOSException;
    public BEggTrayingBillCollection getBEggTrayingBillCollection(String oql) throws BOSException;
    public BEggTrayingBillInfo getBEggTrayingBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BEggTrayingBillInfo getBEggTrayingBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BEggTrayingBillInfo getBEggTrayingBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BEggTrayingBillInfo model) throws BOSException, EASBizException;
    public void unAudit(BEggTrayingBillInfo model) throws BOSException, EASBizException;
    public void adjust(BEggTrayingBillInfo model) throws BOSException;
}