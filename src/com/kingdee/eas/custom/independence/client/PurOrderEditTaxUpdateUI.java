/**
 * output package name
 */
package com.kingdee.eas.custom.independence.client;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class PurOrderEditTaxUpdateUI extends AbstractPurOrderEditTaxUpdateUI
{
    private static final Logger logger = CoreUIObject.getLogger(PurOrderEditTaxUpdateUI.class);
    private SimpleDateFormat sdf;
    
    /**
     * output class constructor
     */
    public PurOrderEditTaxUpdateUI() throws Exception
    {
        super();
        this.setUITitle("开票信息修改");
    }


    /**
     * output btnAdd_actionPerformed method
     */
    protected void btnAdd_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	exeAction(false);
    }

    /**
     * output btnUpdate_actionPerformed method
     */
    protected void btnUpdate_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(MsgBox.showConfirm2("更新操作将覆盖原先开票信息，是否继续执行？")!=MsgBox.OK) {
    		return;
    	}
    	exeAction(true);
    }
    /**
     * 
     * @param isUpdate 是更新还是新增
     */
    private void exeAction(boolean isUpdate) {
    	String dateStr="",id="",number="",amount="",person="";
    	if(StringUtils.isEmpty(this.txtDate.getText())) {
//    		MsgBox.showWarning("开票日期不能为空！");
//    		SysUtil.abort();
    	}else{
	    	dateStr= this.txtDate.getText().trim();	
    	}
    	if(StringUtils.isEmpty(this.txtID.getText())) {
//    		MsgBox.showWarning("发票代码不能为空！");
//    		SysUtil.abort();
    	}else{
    		id=this.txtID.getText().trim();
    	}
    	if(StringUtils.isEmpty(this.txtNum.getText())) {
//    		MsgBox.showWarning("发票号码不能为空！");
//    		SysUtil.abort();
    	}else{
    		number= this.txtNum.getText().trim();
    	}
    	if(StringUtils.isEmpty(this.txtAmount.getText())) {
//    		MsgBox.showWarning("发票金额不能为0！");
//    		SysUtil.abort();
    	}else{
    		amount=this.txtAmount.getText().trim();
    	}
    	
    	if(StringUtils.isNotEmpty(this.txtPerson.getText())) {
    		person=this.txtPerson.getText().trim();
    	}
    	
    	if(StringUtils.isNotEmpty(this.txtDate.getText())) {
	    	String[] tmp = dateStr.split(";");
	    	for(int i=0;i<tmp.length;i++) {
	    		try {
	    			sdf.parse(tmp[i]);
	    		}catch(Exception err) {
	    			MsgBox.showWarning("发票日期格式不正确（正确格式2000-01-01,多日期以分号分割）！");
	        		SysUtil.abort();
	    		}
	    	}
    	}
    	
    	this.getUIContext().put("isUpdate", isUpdate);
    	this.getUIContext().put("dateStr",dateStr);
    	this.getUIContext().put("id", id);
    	this.getUIContext().put("number",number);
    	this.getUIContext().put("amount", amount);
    	this.getUIContext().put("person", person);
    	this.destroyWindow();
    	
    }

    /**
     * output dpDate_dataChanged method
     */
    protected void dpDate_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
       this.txtDate.setText(sdf.format(this.dpDate.getTimestamp()));
    }


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		this.dpDate.setDatePattern("yyyy-MM-dd");
		this.dpDate.setSupportedEmpty(false);
		
		this.txtDate.setRequired(true);
		this.txtID.setRequired(true);
		this.txtAmount.setRequired(true);
		this.txtNum.setRequired(true);
		this.txtPerson.setRequired(true);
		
		this.txtDate.setText(sdf.format(this.dpDate.getValue()));
		this.txtPerson.setText(SysContext.getSysContext().getCurrentUserInfo().getName());
		
		txtAmount.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
				int keyChar=e.getKeyChar();
				//数字及分号
				if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9)||keyChar==KeyEvent.VK_PERIOD ||keyChar==KeyEvent.VK_SEMICOLON ) {
					
				} else {
					e.consume();  
				}
			}
			
		});
		
	}
	

}