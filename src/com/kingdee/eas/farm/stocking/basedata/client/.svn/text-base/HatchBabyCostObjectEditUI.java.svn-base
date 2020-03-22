/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class HatchBabyCostObjectEditUI extends AbstractHatchBabyCostObjectEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HatchBabyCostObjectEditUI.class);
    
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntry.addKDTPropertyChangeListener(new KDTPropertyChangeListener(){

			public void propertyChange(KDTPropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
				for(int i=0;i<kdtEntry.getRowCount();i++)
					kdtEntry.getCell(i, "farmerTree").setValue(prmtfarmersTree.getValue());
			}});
	}
	/**
     * output class constructor
     */
    public HatchBabyCostObjectEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	DataChangeListener[] farmersTreeListner = prmtfarmersTree.getListeners(DataChangeListener.class);
    	for(int i=0;i<farmersTreeListner.length;i++)
    		prmtfarmersTree.removeDataChangeListener(farmersTreeListner[i]);
    	
    	
        super.loadFields();
        
        
        this.prmtfarmersTree.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7FarmerGroupQuery");		
        this.prmtfarmersTree.setVisible(true);		
        this.prmtfarmersTree.setEditable(true);		
        this.prmtfarmersTree.setDisplayFormat("$name$");		
        this.prmtfarmersTree.setEditFormat("$number$");		
        this.prmtfarmersTree.setCommitFormat("$number$");		
        this.prmtfarmersTree.setRequired(false);
        kDLabelContainer3.setVisible(false);
        kDLabelContainer4.setVisible(false);
        kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
        kdtEntry.getColumn("farmerTree").getStyleAttributes().setLocked(true);
        
        
        
        prmtfarmersTree.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				kdtEntry.removeRows();
			}});
        kdtEntry_detailPanel.getAddNewLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(prmtfarmersTree.getValue()==null)
					commUtils.giveUserTipsAndRetire("请先填写表头片区");
			}
        });
        
        
        kdtEntry_detailPanel.getInsertLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(prmtfarmersTree.getValue()==null)
					commUtils.giveUserTipsAndRetire("请先填写表头片区");
				super.mouseClicked(e);
			}
        });
        
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.HatchBabyCostObjectInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}