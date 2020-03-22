/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;


import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.KDComboBox;
import com.kingdee.bos.ctrl.swing.KDDialog;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.attachment.util.Sout;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.base.uiframe.client.UINewFrame;
import com.kingdee.eas.base.uiframe.client.UINewTab;
import com.kingdee.eas.basedata.master.batch.DlgGeneralBatch;
import com.kingdee.eas.basedata.master.batch.ExecutorParameter;
import com.kingdee.eas.basedata.master.batch.GeneralBatchLog;
import com.kingdee.eas.basedata.master.batch.IModelExecutor;
import com.kingdee.eas.basedata.master.batch.ModelExecutorFactory;
import com.kingdee.eas.basedata.master.batch.app.AbstractBatchUpdateStrategy;
import com.kingdee.eas.basedata.master.batch.client.ModelFactory;
import com.kingdee.eas.basedata.master.batch.model.EntityModelCollection;
import com.kingdee.eas.basedata.master.batch.model.EntityModelInfo;
import com.kingdee.eas.basedata.master.batch.model.PropertyModelCollection;
import com.kingdee.eas.basedata.master.batch.model.PropertyModelInfo;
import com.kingdee.eas.basedata.master.batch.viewer.AbstractPropertyViewer;
import com.kingdee.eas.basedata.master.batch.viewer.CustomerView;
import com.kingdee.eas.basedata.master.batch.viewer.F7SchemaAdapter;
import com.kingdee.eas.basedata.master.material.client.MaterialClientTools;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmModel;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.ListUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

import org.apache.commons.lang.StringUtils;

/**
 * output class name
 */
public class FarmerModifyUI extends AbstractFarmerModifyUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerModifyUI.class);
	private CtrlUnitInfo curCtrlUnitInfo = null;
	private FarmModel model=null;
	/**
	 * output class constructor
	 */
	public FarmerModifyUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		this.curCtrlUnitInfo = ((CtrlUnitInfo) getUIContext().get(
		"CurrentCtrlUnit"));
		if (this.curCtrlUnitInfo == null) {
			this.curCtrlUnitInfo = SysContext.getSysContext()
			.getCurrentCtrlUnit();
		}
		super.onLoad();
		loadFields();
	}

	public void onShow() throws Exception {
		setUITitle("批量修改界面");
		super.onShow();
		super.actionForcedLoad.setEnabled(true);
		addForcedLoadShotKey();
	}

	
	private void addForcedLoadShotKey() {
		String strKey = "control F10";
		if (strKey != null) {
			KeyStroke ks = KeyStroke.getKeyStroke(strKey);
			Object wnd = getUIWindow();
			JRootPane jp = null;
			IUIObject uio = null;
			if (wnd instanceof UINewTab) {
				UINewTab uitab = (UINewTab) wnd;
				uio = uitab.getUIObject();
			} else if (wnd instanceof UINewFrame) {
				UINewFrame uiFra = (UINewFrame) wnd;
				uio = uiFra.getUIObject();
			} else if (wnd instanceof UIModelDialog) {
				UIModelDialog uiDlg = (UIModelDialog) wnd;
				uio = uiDlg.getUIObject();
			}
			if (uio instanceof JPanel)
				jp = ((JPanel) uio).getRootPane();
			if (jp != null) {
				jp.getActionMap().put(strKey, super.actionForcedLoad);
				jp.getInputMap(2).put(ks, strKey);
			}
		}
	}

	public void loadFields() {
		super.loadFields();
		if (super.getUIContext().get("Model") == null) {
			return;
		}
		model=(FarmModel) super.getUIContext().get("Model");
		initField();	
	}


	public void storeFields() {
		super.storeFields();
	}

	protected void cmdOK_actionPerformed(ActionEvent e) throws Exception {
		super.cmdOK_actionPerformed(e);
		JComponent bakController = null;
		if (model == null)
			return;
		checkRequired(model);
		String	columnKey = (String) this.listField.getSelectedItem();
		bakController = model.getViewer(columnKey,false).getController();
		Map resultMap =_executBatchUpdate(null, model.getProperties().get(columnKey),getParams());
		if (((Boolean) resultMap.get("status")).booleanValue()) {
			GeneralBatchLog log = (GeneralBatchLog) resultMap
			.get("errorInfo");
			if (SwingUtilities.getWindowAncestor(this) instanceof KDDialog) {
				DlgGeneralBatch dlgLog = new DlgGeneralBatch(
						(KDDialog) SwingUtilities.getWindowAncestor(this),
						log);

				dlgLog.setModal(true);
				dlgLog.show();
				dlgLog.dispose();
			}
		} else {
			MsgBox
			.showInfo(
					this,
					EASResource
					.getString(
							"com.kingdee.eas.basedata.master.batch.client.BatchModifyResource",
					"editSuccess"));
		}
	}

	protected Map _executBatchUpdate(Object values, String columnKey,Map params) throws BOSException, EASBizException {
		List errors = new ArrayList();
		GeneralBatchLog log = new GeneralBatchLog();
		HashMap resultMap = new HashMap();
		if ((model != null) && (params != null)	&& (params instanceof ExecutorParameter)) {
			ExecutorParameter ep = (ExecutorParameter) params;
			Object[] idList = ep.getIdList();
			StringBuffer ids=new StringBuffer();
			StringBuffer keyValue=new StringBuffer();
			StringBuffer sql=new StringBuffer();
			keyValue.append(columnKey).append("=").append("'").append(ep.getValues().get(columnKey)).append("'");
			for(int i=0;i<idList.length;i++){
				ids.append("'").append(idList[i]).append("',");
				if(i==idList.length-1){
					ids.delete(ids.lastIndexOf(","),ids.length()); 
				}
			}
			sql.append("update ").append(model.getTable()).append(" set ").append(keyValue).append(" where fid in (").append(ids).append(")");
			System.out.println(sql.toString());	
			try{
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql.toString());
			}catch (Exception e) {
				log.addException(e.getMessage(), e);
			}	
		}		
		
		if (log.getErrorDetailCount() > 0)
			resultMap.put("status", Boolean.valueOf(true));
		else {
			resultMap.put("status", Boolean.valueOf(false));
		}
		resultMap.put("errorInfo", log);
		return resultMap;
	}

	private void checkRequired(FarmModel model) throws Exception {
		String columnKey =  (String) this.listField.getSelectedItem();
		Object vo = null;
		if ((StringUtils.isNotBlank(columnKey)) && (model.getViewer(columnKey,false)!= null)) {
			vo = model.getViewer(columnKey,false).getValue();
			if (vo == null) {
				MsgBox
				.showInfo(EASResource
						.getString(
								"com.kingdee.eas.basedata.master.batch.client.BatchModifyResource",
						"requiredNotNull"));

				SysUtil.abort();
			}

		}
	}

	private Map getParams() throws Exception {
		ExecutorParameter params = new ExecutorParameter();

		Map idList = (Map) super.getUIContext().get("idlist");
		if ((idList != null) && (idList.keySet() != null)) {
			params.setIdList(idList.keySet().toArray());
		}
		String orgId = null;
		params.put("orgvalue", orgId);
		params.setValues(getFieldValues());

		return params;
	}



	private Map getFieldValues() throws Exception {
		Map mp = new HashMap();

		String columnKey = (String) this.listField.getSelectedItem();
		if (columnKey != null) {
			if ((model != null) && (model.getViewer(columnKey,false)!= null)) {
				Object vo = model.getViewer(columnKey,false).getValue();
				Map<String, String> properties=model.getProperties();
				if (vo != null)
					if(!(model.getViewer(columnKey,false).getController() instanceof KDBizPromptBox)){
						mp.put(properties.get(columnKey),model.getViewer(columnKey,false).getObjectValue(vo));
					}else{
						mp.put(properties.get(columnKey),((IPropertyContainer)vo).getString("id"));
					}
				else {
					mp.put(columnKey, null);
				}
			}
		}
		return mp;
	}


	protected void cmdCancel_actionPerformed(ActionEvent e) throws Exception {
		super.cmdCancel_actionPerformed(e);
		getUIWindow().close();
		Object window = getUIContext().get("Owner");
		if (window instanceof ListUI)
			((ListUI) window).refreshList();
	}

	public void actionListChanged_actionPerformed(ActionEvent e)
	throws Exception {
		super.actionListChanged_actionPerformed(e);
		if (e.getSource().equals(listField)) {
			String orgId = null;
			changeField(listField.getSelectedItem(), orgId);
		}
	}


	protected void initContextOrg() {
		initUIMainOrgContext(this.curCtrlUnitInfo.getId().toString());
	}

	private void initField() {
		this.listField.removeAllItems();
		this.listField.addItems(model.toArray());

		if (this.listField.getItemCount() > 0) {
			this.listField.setSelectedIndex(0);
		}
	}

	private void changeField(Object selectedItem, String value)
	throws Exception {
		if ((selectedItem != null)
				&& (selectedItem instanceof String)) {
			String  columnKey = (String) selectedItem;

			if (StringUtils.isNotBlank(columnKey)) {
				super.getUIContext().put("orgvalue", value);
				JComponent controller = model.getViewer(columnKey,true).getController();
				clearValue(controller);
				this.dynamicFieldContainer.setBoundEditor(controller);
			}
		}
	}

	private void clearValue(JComponent controller) {
		if (controller instanceof KDBizPromptBox)
			((KDBizPromptBox) controller).setValue(null);
	}


}