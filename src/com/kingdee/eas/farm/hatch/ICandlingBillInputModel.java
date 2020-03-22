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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICandlingBillInputModel extends IDataBase
{
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CandlingBillInputModelInfo getCandlingBillInputModelInfo(String oql) throws BOSException, EASBizException;
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection() throws BOSException;
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection(EntityViewInfo view) throws BOSException;
    public CandlingBillInputModelCollection getCandlingBillInputModelCollection(String oql) throws BOSException;
}