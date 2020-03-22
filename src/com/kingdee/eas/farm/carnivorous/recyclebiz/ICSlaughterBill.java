package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface ICSlaughterBill extends ICoreBillBase
{
    public CSlaughterBillCollection getCSlaughterBillCollection() throws BOSException;
    public CSlaughterBillCollection getCSlaughterBillCollection(EntityViewInfo view) throws BOSException;
    public CSlaughterBillCollection getCSlaughterBillCollection(String oql) throws BOSException;
    public CSlaughterBillInfo getCSlaughterBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CSlaughterBillInfo getCSlaughterBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CSlaughterBillInfo getCSlaughterBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CSlaughterBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CSlaughterBillInfo model) throws BOSException, EASBizException;
}