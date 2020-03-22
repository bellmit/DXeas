package com.kingdee.eas.custom.znck.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.util.ArrayList;
import java.util.List;

public class MaterialLedRelFacadeControllerBean extends AbstractMaterialLedRelFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.znck.app.MaterialLedRelFacadeControllerBean");

	@Override
	protected List _getMaterialRelLEDNumbers(Context ctx, List materials)
			throws BOSException {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> ledNumbers = new ArrayList<Integer>();
		StringBuilder idsb = new StringBuilder("(");
		for(int i = 0; i < materials.size(); i++){
			idsb.append("'").append(materials.get(i)).append("',");
		}
		
		if(idsb.length() > 5){
			idsb = idsb.replace(idsb.length()-1, idsb.length(), "");
			
			idsb.append(")");
			sb.append("select distinct t.cflednumber from CT_FM_MaterialLedRel t inner join CT_FM_MaterialLedRelEntry te on t.fid = te.fparentid where te.cfmaterialid in ");
			sb.append(idsb.toString());
			
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			try{
				while(rs.next()){
					int ledNumber = rs.getInt("cflednumber");
					ledNumbers.add(ledNumber);
				}
			}catch(SQLException sqle){
				throw new BOSException(sqle);
			}
			
		}
		return ledNumbers;
	}
    
    
    
}