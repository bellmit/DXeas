/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.assistfunction.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class PwdVerifyUI extends AbstractPwdVerifyUI
{
    private static final Logger logger = CoreUIObject.getLogger(PwdVerifyUI.class);
    
    /**
     * output class constructor
     */
    public PwdVerifyUI() throws Exception
    {
        super();
        this.setUITitle("管理员密码");
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
		// TODO Auto-generated method stub
		super.onLoad();
		this.getUIContext().put("isCancel", true);
		this.btn0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
		this.btn9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionClicked(e);
			}})
		;
	}
    
    private void actionClicked(ActionEvent e) {
    	String pwd=this.txtPassword.getText();
    	if(pwd==null){
    		pwd="";
    	}
    	pwd+=((KDWorkButton)e.getSource()).getName().substring(3);
    	this.txtPassword.setText(pwd);
    }

	/**
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        String pwd=this.txtPassword.getText();
        if(StringUtils.isEmpty(pwd)) {
        	MsgBox.showWarning("密码不能为空！");
        	return;
        }
        if(!pwd.equals("1928374655")) {
        	MsgBox.showWarning("密码不正确！");
        	return;
        }
        this.getUIContext().put("isCancel", false);
        this.destroyWindow();
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
       this.destroyWindow();
    }

    /**
     * output btnBackSpace_actionPerformed method
     */
    protected void btnBackSpace_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	String pwd=this.txtPassword.getText();
        if(StringUtils.isNotEmpty(pwd)) {
        	this.txtPassword.setText(pwd.substring(0, pwd.length()-1));
        }
    }

    /**
     * output btnClear_actionPerformed method
     */
    protected void btnClear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	this.txtPassword.setText(null);
    }


}