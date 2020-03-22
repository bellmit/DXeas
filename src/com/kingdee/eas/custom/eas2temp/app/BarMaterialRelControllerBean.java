package com.kingdee.eas.custom.eas2temp.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2temp.BarMaterialRelInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BarMaterialRelControllerBean extends AbstractBarMaterialRelControllerBean
{
   
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.eas2temp.app.BarMaterialRelControllerBean");



	 @Override
	 protected IObjectPK _save(Context ctx, IObjectValue model)
	   throws BOSException, EASBizException {
	     if(this.checkExist(ctx, model)){
	   throw new EASBizException(new NumericExceptionSubItem("003","�Ѿ�������ͬ���ݣ������ظ�"));
	  }
	  return super._save(ctx, model);
	 }
	 @Override
	 protected IObjectPK _submit(Context ctx, IObjectValue model)
	   throws BOSException, EASBizException {
	  if(this.checkExist(ctx, model)){
	   throw new EASBizException(new NumericExceptionSubItem("003","�Ѿ�������ͬ���ݣ������ظ�"));
	  }
	  return super._submit(ctx, model);
	 }
	 

	 /**
	  * ��֤�Ƿ������ͬ����
	  * @param ctx
	  * @param model
	  * @return
	  * @throws BOSException
	  */
	 private boolean checkExist(Context ctx, IObjectValue model) throws BOSException,EASBizException{
	  if(model != null ){
	   BarMaterialRelInfo refInfo = (BarMaterialRelInfo)model;
	   if(refInfo.getBarMaterialNum() == null){
	    throw new EASBizException(new NumericExceptionSubItem("001","������벻��Ϊ��"));
	   }
	   if(refInfo.getEasMaterial()==null)
	   {
	    throw new EASBizException(new NumericExceptionSubItem("001","���ϲ���Ϊ��"));
	   }
	   
	   StringBuffer sql = new StringBuffer();
	   sql.append(" select 1 from CT_EAS_BarMaterialRel where CFBarMaterialNum = '");
	   sql.append(refInfo.getBarMaterialNum()).append("'");
	   sql.append(" or CFEasMaterialID='").append(refInfo.getEasMaterial().getId()).append("'");

	   try{
	   IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
	   if(rs.next()){
	    return true;
	   }
	   }catch(SQLException sqle){
	    throw new EASBizException( new NumericExceptionSubItem("002","��֤�Ƿ�����ظ�����ʱ����sql�쳣��" + sqle.getMessage()));
	   }
	  }
	  return false;
	 }
	}


