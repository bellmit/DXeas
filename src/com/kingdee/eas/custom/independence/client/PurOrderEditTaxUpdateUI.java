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
        this.setUITitle("��Ʊ��Ϣ�޸�");
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
    	if(MsgBox.showConfirm2("���²���������ԭ�ȿ�Ʊ��Ϣ���Ƿ����ִ�У�")!=MsgBox.OK) {
    		return;
    	}
    	exeAction(true);
    }
    /**
     * 
     * @param isUpdate �Ǹ��»�������
     */
    private void exeAction(boolean isUpdate) {
    	String dateStr="",id="",number="",amount="",person="";
    	if(StringUtils.isEmpty(this.txtDate.getText())) {
//    		MsgBox.showWarning("��Ʊ���ڲ���Ϊ�գ�");
//    		SysUtil.abort();
    	}else{
	    	dateStr= this.txtDate.getText().trim();	
    	}
    	if(StringUtils.isEmpty(this.txtID.getText())) {
//    		MsgBox.showWarning("��Ʊ���벻��Ϊ�գ�");
//    		SysUtil.abort();
    	}else{
    		id=this.txtID.getText().trim();
    	}
    	if(StringUtils.isEmpty(this.txtNum.getText())) {
//    		MsgBox.showWarning("��Ʊ���벻��Ϊ�գ�");
//    		SysUtil.abort();
    	}else{
    		number= this.txtNum.getText().trim();
    	}
    	if(StringUtils.isEmpty(this.txtAmount.getText())) {
//    		MsgBox.showWarning("��Ʊ����Ϊ0��");
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
	    			MsgBox.showWarning("��Ʊ���ڸ�ʽ����ȷ����ȷ��ʽ2000-01-01,�������Էֺŷָ��");
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
				//���ּ��ֺ�
				if ((keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9)||keyChar==KeyEvent.VK_PERIOD ||keyChar==KeyEvent.VK_SEMICOLON ) {
					
				} else {
					e.consume();  
				}
			}
			
		});
		
	}
	

}