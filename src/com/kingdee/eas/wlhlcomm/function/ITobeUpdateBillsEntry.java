package com.kingdee.eas.wlhlcomm.function;

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

public interface ITobeUpdateBillsEntry extends ICoreBillEntryBase
{
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(String oql) throws BOSException, EASBizException;
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection() throws BOSException;
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection(EntityViewInfo view) throws BOSException;
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection(String oql) throws BOSException;
}