package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IERP2TaxFacade extends IBizCtrl
{
    public void execute(String sqlStr) throws BOSException;
    public String exeExport2Tax(String jsonStr) throws BOSException, EASBizException;
    public String exeSynResult(String jsonStr) throws BOSException, EASBizException;
    public String ExportWriteBack2Tax(String jsonStr) throws BOSException, EASBizException;
}