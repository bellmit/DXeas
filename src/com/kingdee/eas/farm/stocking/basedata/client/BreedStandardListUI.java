/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.wlhllicensemanager.DynamicFacadeFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class BreedStandardListUI extends AbstractBreedStandardListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedStandardListUI.class);
    
    /**
     * output class constructor
     */
    public BreedStandardListUI() throws Exception
    {
        super();
//       String dd="";
//       dd=DynamicFacadeFactory.getRemoteInstance().downloadBillList("{\"bosType\":\"00751DDD\",\"queryStr\":\"id is not null and farmer.id='75QAAAAd1sQYMRT/' \"} ");
//        String dd=DynamicFacadeFactory.getRemoteInstance().getDataByID("{\"id\":\"75QAAADD5fkoWadW\"}");
//        String dd=DynamicFacadeFactory.getRemoteInstance().uploadDataByBosType("2859A756","{\"isMature\":\"false\",\"nowBreedStage\":\"3\",\"weekDay\":\"1\",\"entrys\":[{\"materialName\":\"544H\",\"unit\":{\"id\":\"gw5fUwEOEADgAAsRwKgSOFuCXFc=\"},\"unitQty\":\"40\",\"materialModel\":\"40kg\",\"dailyQtyAll\":\"5200\",\"seq\":\"1\",\"material\":{\"id\":\"75QAAAAAJP9ECefw\"},\"bagQty\":\"130\"}],\"Envi\":[],\"farm\":{\"id\":\"h+C8x7XKQm+3xEnHLLaAk614wwc=\"},\"farmer\":{\"id\":\"75QAAAAuhpsYMRT/\"},\"SendEggEntry\":[],\"stockingBatch\":{\"id\":\"Xvf2zXlDQQmeorc6axU62wB1Hd0=\"},\"hasEffected\":\"false\",\"AssEntrys\":[{\"femaleMarketed\":\"0\",\"cullQty\":\"0\",\"isMarketed\":\"false\",\"adjustFemaleQty\":\"0\",\"adjustQty\":\"0\",\"femaleBreedkingStock\":\"20222\",\"seq\":\"1\",\"femaleDeathQty\":\"1\",\"markedQty\":\"0\",\"deathQty\":\"0\",\"weekDays\":\"1\",\"week\":\"39\",\"breekingStock\":\"3410\"}],\"TransEntry\":[],\"number\":\"test2018022222222\",\"isInit\":\"false\",\"company\":{\"id\":\"75QAAAAAAPTM567U\"},\"ImmuneEntrys\":[],\"Fivouchered\":\"false\",\"bizDate\":\"2018-02-22 01:00:21\",\"isBreed\":\"false\",\"EggEntry\":[{\"materialName\":\"父母代合格蛋\",\"unit\":{\"id\":\"75QAAAAABRRbglxX\"},\"allQty\":\"18638\",\"seq\":\"1\",\"material\":{\"id\":\"75QAAAAN0dNECefw\"}}],\"week\":\"39\"}");
//        System.out.println("132");
//        DynamicFacadeFactory.getRemoteInstance().downloadBillList(" {\"bosType\":\"4409E7F0\",\"queryStr\":\"qy_fodder\",\"batchID\":\"75QAAAAX3ggAdR3d\"}");
//          FarmerDataExpFacadeFactory.getRemoteInstance().expFarmerDataToTxt(null);
//       System.out.println(dd);
    }


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedStandardTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.BreedStandardTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "养殖规范";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo();
		
        return objectValue;
    }
    @Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isIgnoreTreeCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
		
	}


	@Override
	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
		if(baseStatus.equals("启用")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("核准")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else{
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
			}
	}


	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
		  return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
		  prepareCancel(null).callHandler();
		}
		cancelCancel();
		actionRefresh_actionPerformed(e);
	}
}