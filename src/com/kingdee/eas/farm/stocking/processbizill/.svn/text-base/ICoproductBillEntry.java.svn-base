package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICoproductBillEntry extends ICoreBillEntryBase
{
    public CoproductBillEntryInfo getCoproductBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CoproductBillEntryInfo getCoproductBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CoproductBillEntryInfo getCoproductBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CoproductBillEntryCollection getCoproductBillEntryCollection() throws BOSException;
    public CoproductBillEntryCollection getCoproductBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CoproductBillEntryCollection getCoproductBillEntryCollection(String oql) throws BOSException;
}