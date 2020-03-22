package com.kingdee.eas.farm.carnivorous.assistbiz;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICKGrowthFreightBill extends IDataBase
{
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKGrowthFreightBillInfo getCKGrowthFreightBillInfo(String oql) throws BOSException, EASBizException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection() throws BOSException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(EntityViewInfo view) throws BOSException;
    public CKGrowthFreightBillCollection getCKGrowthFreightBillCollection(String oql) throws BOSException;
    public void audit(CKGrowthFreightBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CKGrowthFreightBillInfo model) throws BOSException, EASBizException;
}