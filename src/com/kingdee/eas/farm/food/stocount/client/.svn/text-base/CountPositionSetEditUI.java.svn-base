/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.food.stocount.CountPositionSetFactory;
import com.kingdee.eas.farm.food.stocount.CountPositionSetInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class CountPositionSetEditUI extends AbstractCountPositionSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CountPositionSetEditUI.class);
    
    /**
     * output class constructor
     */
    public CountPositionSetEditUI() throws Exception
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
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		
		//物料监听带出计量单位
		this.kdtMaterialEntry.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent arg0) {
			}
			public void editStarted(KDTEditEvent arg0) {
			}
			public void editStarting(KDTEditEvent arg0) {
			}
			public void editStopped(KDTEditEvent e) {
				try {
					getBaseUnit(e.getRowIndex(),e.getColIndex());
				} catch (EASBizException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			public void editStopping(KDTEditEvent arg0) {
			}
			public void editValueChanged(KDTEditEvent arg0) {
			}});
	}
  
    
    
    //计量单位带出
    private void getBaseUnit(int rowIndex,int colIndex) throws EASBizException, BOSException{
    	String unitId="";
    	MeasureUnitInfo mInfo=null;
    	String materialid="";
    	if(kdtMaterialEntry.getRow(rowIndex).getCell("material").getValue() !=null){
    		MaterialInfo info=(MaterialInfo)(kdtMaterialEntry.getRow(rowIndex).getCell("material").getValue());
    		materialid=info.getId().toString();
    		if(info.getBaseUnit() != null){
    			unitId=info.getBaseUnit().getId().toString();
    			mInfo=MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(unitId));
    		}
    		kdtMaterialEntry.getRow(rowIndex).getCell("baseUnit").setValue(mInfo);
    	}
    	
    	
    	//如果已经维护库存计量单位带出
		String storId=SysContext.getSysContext().getCurrentStorageUnit().getId().toString();
	    		EntityViewInfo ev=new EntityViewInfo();
	    		FilterInfo filterInfo=new FilterInfo();
	    		filterInfo.getFilterItems().add(new FilterItemInfo("orgunit.id",storId,CompareType.EQUALS));
	    		filterInfo.getFilterItems().add(new FilterItemInfo("material.id",materialid,CompareType.EQUALS));
	    		ev.setFilter(filterInfo);
	    		MaterialInventoryCollection collection=MaterialInventoryFactory.getRemoteInstance().getMaterialInventoryCollection(ev);
	    		if(collection.size()>0){
	    			MaterialInventoryInfo info=collection.get(0);
	    			if(info.getUnit()!= null){
	    				kdtMaterialEntry.getRow(rowIndex).getCell("inventoryUnit").setValue(MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(info.getUnit().getId().toString())));
	    			}
	    		}
    }
    
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.food.stocount.CountPositionSetTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.stocount.CountPositionSetInfo objectValue = new com.kingdee.eas.farm.food.stocount.CountPositionSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}