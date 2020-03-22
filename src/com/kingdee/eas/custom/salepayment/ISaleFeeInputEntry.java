package com.kingdee.eas.custom.salepayment;

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

public interface ISaleFeeInputEntry extends ICoreBillEntryBase
{
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleFeeInputEntryInfo getSaleFeeInputEntryInfo(String oql) throws BOSException, EASBizException;
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection() throws BOSException;
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection(EntityViewInfo view) throws BOSException;
    public SaleFeeInputEntryCollection getSaleFeeInputEntryCollection(String oql) throws BOSException;
}