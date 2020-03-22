package com.kingdee.eas.custom.erp2tax;

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

public interface IMaterialTaxCode extends IDataBase
{
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(String oql) throws BOSException, EASBizException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection() throws BOSException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(EntityViewInfo view) throws BOSException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(String oql) throws BOSException;
}