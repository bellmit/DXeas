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

public interface ICKPECostbill extends ICoreBillBase
{
    public CKPECostbillCollection getCKPECostbillCollection() throws BOSException;
    public CKPECostbillCollection getCKPECostbillCollection(EntityViewInfo view) throws BOSException;
    public CKPECostbillCollection getCKPECostbillCollection(String oql) throws BOSException;
    public CKPECostbillInfo getCKPECostbillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKPECostbillInfo getCKPECostbillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKPECostbillInfo getCKPECostbillInfo(String oql) throws BOSException, EASBizException;
}