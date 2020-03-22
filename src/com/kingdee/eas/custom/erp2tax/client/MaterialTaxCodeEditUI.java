/**
 * output package name
 */
package com.kingdee.eas.custom.erp2tax.client;

import java.awt.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class MaterialTaxCodeEditUI extends AbstractMaterialTaxCodeEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MaterialTaxCodeEditUI.class);
    
    /**
     * output class constructor
     */
    public MaterialTaxCodeEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.erp2tax.MaterialTaxCodeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo objectValue = new com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		super.verifyInput(e);
		String number=this.txtNumber.getText();
		if(StringUtils.isBlank(number)||number.trim().length()!=19) {
			com.kingdee.eas.util.client.MsgBox.showWarning("税收分类代码必须是19位！");
			SysUtil.abort();
		}
		
		String id=null;
		if(editData.getId()!=null) {
			id=editData.getId().toString();
		}
		String materialID;
		for(int rowIndex=0;rowIndex<kdtEntry.getRowCount();rowIndex++) {
			materialID=null;
			if(kdtEntry.getCell(rowIndex, "material")==null) {
				continue;
			}
			materialID=((IObjectValue) kdtEntry.getCell(rowIndex, "material").getValue()).getString("id");
			if(checkHasExistsMaterial(id,materialID)) {
				com.kingdee.eas.util.client.MsgBox.showWarning("第"+(rowIndex+1)+"行物料已经存在其他设置中！");
				SysUtil.abort();
			}
		}
	}
    /**
     * 检查是否存在物料
     * @param billID
     * @return
     * @throws BOSException 
     */
	private boolean checkHasExistsMaterial(String billID,String materialID) throws BOSException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select 1 ")
			.append(" from T_ERP_MaterialTaxCodeEntry tentry")
			.append(" where FMaterialID='").append(materialID).append("'");
			if(StringUtils.isNotBlank(billID)) {
				sql.append(" and tentry.fparentid!='").append(billID).append("'");
			}
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.size()>0) {
				rs.close();
				return true;
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
		return false;
	}
	
}