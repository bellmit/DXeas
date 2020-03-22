package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IStatementsPolicyTree extends ITreeBase
{
    public StatementsPolicyTreeInfo getStatementsPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StatementsPolicyTreeInfo getStatementsPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StatementsPolicyTreeInfo getStatementsPolicyTreeInfo(String oql) throws BOSException, EASBizException;
    public StatementsPolicyTreeCollection getStatementsPolicyTreeCollection() throws BOSException;
    public StatementsPolicyTreeCollection getStatementsPolicyTreeCollection(EntityViewInfo view) throws BOSException;
    public StatementsPolicyTreeCollection getStatementsPolicyTreeCollection(String oql) throws BOSException;
}