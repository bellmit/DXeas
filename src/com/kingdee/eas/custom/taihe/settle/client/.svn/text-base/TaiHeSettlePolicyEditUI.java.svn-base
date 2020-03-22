/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.tree.DefaultKingdeeTreeNode;
import com.kingdee.bos.ctrl.swing.tree.KingdeeTreeModel;
import com.kingdee.bos.metadata.entity.DataType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.OwnPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyCollection;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.common.StockingComm;

/**
 * output class name
 */
public class TaiHeSettlePolicyEditUI extends AbstractTaiHeSettlePolicyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(TaiHeSettlePolicyEditUI.class);
    
    /**
     * output class constructor
     */
    public TaiHeSettlePolicyEditUI() throws Exception
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
        return com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo objectValue = new com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setEffectDate(new Date());
        objectValue.setUnEffectDate(new Date());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		prmtcompany.setSelector(cf7);
		this.pkeffectDate.setDatePattern("yyyy-MM-dd");
		this.pkunEffectDate.setDatePattern("yyyy-MM-dd");
		initDynamicCalculatio();
	}
    
    /**
	 * 初始化动态计算
	 */
	private void initDynamicCalculatio() {
		try {
			this.kDTable1.checkParsed();
			this.kDTable1.getStyleAttributes().setLocked(true);
			this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
			
			IRow row;
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffResult");
			row.getCell("name").setValue("公式结果");
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffIf");
			row.getCell("name").setValue("如果");
			row=kDTable1.addRow();
			row.getCell("id").setValue("ffElse");
			row.getCell("name").setValue("否则");
			
			//初始化树
			DefaultKingdeeTreeNode rootNode=new DefaultKingdeeTreeNode("单据");
			TreeModel newModel=new KingdeeTreeModel(rootNode);
			kDTree1.setModel(newModel);
			kDTree1.setShowsRootHandles(true);
			
			/*EntityObjectInfo eo = StockingComm.getEntityObject(null, "B1E872B9");
			DefaultKingdeeTreeNode lvl1Node=new DefaultKingdeeTreeNode("结算指标");
			lvl1Node.setUserObject(eo);
			rootNode.add(lvl1Node);
			insertIntoTree(eo, lvl1Node);*/
			
			EntityObjectInfo eo =StockingComm.getEntityObject(null, "FDFAF775");
			DefaultKingdeeTreeNode lvl1Node=new DefaultKingdeeTreeNode("收购结算单");
			lvl1Node.setUserObject(eo);
			rootNode.add(lvl1Node);
			insertIntoTree(eo, lvl1Node);
			
			kDTree1.expandOnLevel(2);
			
			kDTree1.addTreeSelectionListener(new TreeSelectionListener(){
				public void valueChanged(TreeSelectionEvent e) {
//					treeSelectd_changed(e);
				}});
			kDTree1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
					tree_clicked(e);
				}});
			this.kDTable1.addKDTMouseListener(new KDTMouseListener(){
				public void tableClicked(KDTMouseEvent e) {
					table_clicked(e);
				}});
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 插入单据属性节点
	 * @param eo
	 * @param rootNode
	 */
	private void insertIntoTree(EntityObjectInfo eo,DefaultKingdeeTreeNode rootNode) {
		if(eo!=null) {
			DataType dataType;
			PropertyCollection pcols = eo.getProperties();
			DefaultKingdeeTreeNode tempRoot;
			for(int index=0;index<pcols.size();index++) {
				tempRoot=new DefaultKingdeeTreeNode(pcols.get(index));
				if(!(pcols.get(index) instanceof OwnPropertyInfo)) {
					continue;
				}
				dataType=((OwnPropertyInfo)pcols.get(index)).getDataType();
				if(!dataType.equals(DataType.DECIMAL)&&!dataType.equals(DataType.FLOAT)&&!dataType.equals(DataType.DOUBLE)&&!dataType.equals(DataType.INTEGER)&&!dataType.equals(DataType.LONG)&&!dataType.equals(DataType.SHORT)) {
					continue;
				}
				tempRoot.setText(pcols.get(index).getAlias());
				System.out.println(pcols.get(index).getClass().toString());
				kDTree1.addNodeInto(tempRoot,rootNode);
			}
		}
	}
	
	private void tree_clicked(MouseEvent e) {
		if(!oprtState.equals(OprtState.ADDNEW)&&!oprtState.equals(OprtState.EDIT)) {
			return;
		}
		if(e.getClickCount()==2) {
			Object[] path = kDTree1.getSelectionPath().getPath();
			DefaultKingdeeTreeNode node=(DefaultKingdeeTreeNode)path[path.length-1];
			DefaultKingdeeTreeNode rootNode=(DefaultKingdeeTreeNode)path[1];
			if(!(node.getUserObject() instanceof PropertyInfo)) {
				return;
			}
			int beginIndex = this.txtformulaTxt.getSelectionStart();
			this.txtformulaTxt.insert(" ["+rootNode.getText()+"."+((PropertyInfo) node.getUserObject()).getAlias()+"\""+((EntityObjectInfo)rootNode.getUserObject()).getName()+"."+((PropertyInfo) node.getUserObject()).getName()+"\"]",beginIndex);
		}
	}
	private void table_clicked(KDTMouseEvent e) {
		if(!oprtState.equals(OprtState.ADDNEW)&&!oprtState.equals(OprtState.EDIT)) {
			return;
		}
		if(e.getClickCount()!=2) {
			return;
		}
		IRow row = KDTableUtil.getSelectedRow(kDTable1);
		if(row==null||row.getRowIndex()<0) {
			return;
		}
		int beginIndex = this.txtformulaTxt.getSelectionStart();
		if(row.getCell("name").getValue().toString().equals("公式结果")) {
//			this.txtformulaTxt.setText("[公式结果{result}] ="+(this.txtformulaTxt.getText()==null?"":this.txtformulaTxt.getText()));
			this.txtformulaTxt.insert("[公式结果\"result\"] = ",beginIndex);
		}
		if(row.getCell("name").getValue().toString().equals("如果")) {
			this.txtformulaTxt.insert("[如果\"if\"](1==1) {\n    \n}",beginIndex);
		}
		if(row.getCell("name").getValue().toString().equals("否则")) {
			this.txtformulaTxt.insert("\n[否则\"else\"] {\n    \n}",beginIndex);
		}
	}
}