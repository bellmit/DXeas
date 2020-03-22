package com.kingdee.eas.custom.test;

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

public interface IExcelOutput extends IDataBase
{
    public ExcelOutputInfo getExcelOutputInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ExcelOutputInfo getExcelOutputInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ExcelOutputInfo getExcelOutputInfo(String oql) throws BOSException, EASBizException;
    public ExcelOutputCollection getExcelOutputCollection() throws BOSException;
    public ExcelOutputCollection getExcelOutputCollection(EntityViewInfo view) throws BOSException;
    public ExcelOutputCollection getExcelOutputCollection(String oql) throws BOSException;
}