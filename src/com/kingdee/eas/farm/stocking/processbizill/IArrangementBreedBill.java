package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IArrangementBreedBill extends ICoreBillBase
{
    public ArrangementBreedBillCollection getArrangementBreedBillCollection() throws BOSException;
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(EntityViewInfo view) throws BOSException;
    public ArrangementBreedBillCollection getArrangementBreedBillCollection(String oql) throws BOSException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ArrangementBreedBillInfo getArrangementBreedBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(ArrangementBreedBillInfo model) throws BOSException;
    public void unAudit(ArrangementBreedBillInfo model) throws BOSException;
}