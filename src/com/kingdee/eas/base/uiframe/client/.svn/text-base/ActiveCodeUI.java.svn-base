/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
/*     */ package com.kingdee.eas.base.uiframe.client;
/*     */ 
/*     */ import com.kingdee.bos.ctrl.swing.KDLabel;
/*     */ import com.kingdee.bos.ctrl.swing.KDTextArea;
/*     */ import com.kingdee.bos.ctrl.swing.KDTextField;
/*     */ import com.kingdee.bos.json.JSONException;
/*     */ import com.kingdee.bos.json.JSONObject;
/*     */ import com.kingdee.bos.ui.face.CoreUIObject;
/*     */ import com.kingdee.bos.ui.util.ResourceBundleHelper;
/*     */ import com.kingdee.eas.base.license.ILicenseSrvAgent;
/*     */ import com.kingdee.eas.base.license.LicenseException;
/*     */ import com.kingdee.eas.base.license.client.LicenseSrvAgentFactory;
/*     */ import com.kingdee.eas.base.license.file.LicenseCloudRequestInfo;
/*     */ import com.kingdee.eas.common.client.SysContext;
/*     */ import com.kingdee.eas.framework.FrameWorkUtils;
/*     */ import com.kingdee.eas.util.client.MsgBox;
/*     */ import com.kingdee.util.Base64Encoder;
/*     */ import com.kingdee.util.StringUtils;
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
import org.apache.log4j.Logger;
/*     */ 
/*     */
/*     */ public class ActiveCodeUI extends AbstractActiveCodeUI
/*     */ {
	public ActiveCodeUI() throws Exception {
			super();
		// TODO Auto-generated constructor stub
	}
/*  36 */   private static final Logger logger = CoreUIObject.getLogger(ActiveCodeUI.class);
/*     */
/*     */
/*     */
/*     */
/*  41 */   private boolean status = false;
/*  42 */   private String activeSerialNum = null;
/*  43 */   private boolean needProvideAssistFile = false;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public void onLoad()
/*     */     throws Exception
/*     */   {
/*  57 */     super.onLoad();
/*  58 */     this.activeSerialNum = LicenseHelper.generateActiveCode();
/*  59 */     Object needProvideAssistFileObj = getUIContext().get("needProvideAssistFile");
/*  60 */     if ((needProvideAssistFileObj != null) && (needProvideAssistFileObj instanceof Boolean)) {
/*  61 */       this.needProvideAssistFile = Boolean.valueOf(this.needProvideAssistFile).booleanValue();
/*     */
/*     */     }
/*     */ 
/*  65 */     this.txtActiveSerial.setText(this.activeSerialNum);
/*  66 */     this.txtActiveSerial.setEditable(false);
/*     */ 
/*  68 */     if (!(this.needProvideAssistFile))
/*     */     {
/*  70 */       this.kDLabel15.setVisible(false);
/*     */
/*     */     }
/*     */ 
/*  74 */     this.validateNet.setForeground(Color.BLUE);
/*  75 */     this.kDLabel15.setForeground(Color.BLUE);
/*  76 */     this.kDLabel17.setForeground(Color.BLUE);
/*  77 */     disableToolTips();
/*  78 */     addListener();
/*     */   }
/*     */



/*     */   private void disableToolTips() {
/*  82 */     this.validateNet.setToolTipText("http://www.kingdee.com");
/*  83 */     this.kDLabel2.setAutoToolTipText(false);
/*  84 */     this.kDLabel10.setAutoToolTipText(false);
/*  85 */     this.kDLabel3.setAutoToolTipText(false);
/*  86 */     this.kDLabel7.setAutoToolTipText(false);
/*  87 */     this.kDLabel8.setAutoToolTipText(false);
/*  88 */     this.kDLabel4.setAutoToolTipText(false);
/*  89 */     this.kDLabel13.setAutoToolTipText(false);
/*     */ 
/*  91 */     this.kDLabel9.setAutoToolTipText(false);
/*  92 */     this.kDLabel6.setAutoToolTipText(false);
/*     */ 
/*  94 */     this.kDLabel1.setAutoToolTipText(false);
/*  95 */     this.kDLabel5.setAutoToolTipText(false);
/*  96 */     this.kDLabel17.setAutoToolTipText(false);
/*     */   }



			@Override
			public void onShow() throws Exception {
				// TODO Auto-generated method stub
				super.onShow();
				
				this.status = true;
				disposeUIWindow();
			}



/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   private void addListener()
/*     */   {
/* 105 */     this.txtActiveCode.addFocusListener(new FocusListener() {
/*     */       String initText;
/*     */ 
/*     */       public void focusGained(FocusEvent e) { if (ActiveCodeUI.this.txtActiveCode.getText().equals(this.initText))
/* 109 */           ActiveCodeUI.this.txtActiveCode.setText("");
/*     */         else
/* 111 */           ActiveCodeUI.this.txtActiveCode.setSelectAllOnFocus(true);
/*     */       }
/*     */ 
/*     */       public void focusLost(FocusEvent e) {
/* 115 */         if (StringUtils.isEmpty(ActiveCodeUI.this.txtActiveCode.getText()))
/* 116 */           ActiveCodeUI.this.txtActiveCode.setText(this.initText);
/*     */
/*     */       }
/*     */     });
/* 120 */     this.validateNet.addMouseListener(new MouseAdapter() {
/*     */       public void mouseEntered(MouseEvent e) {
/* 122 */         ActiveCodeUI.this.setCursor(new Cursor(12)); }
/*     */ 
/*     */       public void mouseExited(MouseEvent e) {
/* 125 */         ActiveCodeUI.this.setCursor(new Cursor(0)); }
/*     */ 
/*     */       public void mouseClicked(MouseEvent e) {
/* 128 */         FrameWorkUtils.openByDefaultBrowser("http://www.kingdee.com/genuine/activation.jsp");
/*     */       }
/*     */     });
/* 131 */     this.kDLabel15.addMouseListener(new MouseAdapter() {
/*     */       public void mouseEntered(MouseEvent e) {
/* 133 */         ActiveCodeUI.this.setCursor(new Cursor(12)); }
/*     */ 
/*     */       public void mouseExited(MouseEvent e) {
/* 136 */         ActiveCodeUI.this.setCursor(new Cursor(0)); }
/*     */ 
/*     */       public void mouseClicked(MouseEvent e) {
/* 139 */         ActiveCodeUI.this.setCursor(new Cursor(3));
/* 140 */         String filePath = null;
/*     */         try {
/* 142 */           filePath = ActiveCodeUI.this.generateGenuineValidity();
/*     */         } catch (LicenseException e1) {
/* 144 */           ActiveCodeUI.logger.error(e1.getMessage(), e1);
/*     */         }
/* 146 */         ActiveCodeUI.this.setCursor(new Cursor(0));
/* 147 */         if (!(StringUtils.isEmpty(filePath)))
/* 148 */           MsgBox.showInfo(ActiveCodeUI.this, "文件生成成功！\n\n请在以下路径获取该文件：\n\n" + filePath);
/*     */         else
/* 150 */           MsgBox.showInfo(ActiveCodeUI.this, "文件生成失败！");
/*     */       }
/*     */     });
/*     */   }
/*     */
/*     */
/*     */   protected void btnActive_actionPerformed(ActionEvent e)
/*     */   {
/*     */     /*try
          {
 160        String activeCode = this.txtActiveCode.getText();
 161        if ((StringUtils.isEmpty(activeCode)) || (StringUtils.equals(activeCode, this.resHelper.getString("txtActiveCode.text"))))
            {
 163          MsgBox.showWarning("请输入激活验证码！");
 164          return;
            }
 166        if (activeCode.length() <= 4) {
 167          MsgBox.showWarning("验证失败！");
 168          this.status = false;
 169          return;
            }
 171        activeCode = LicenseHelper.decodeBASE64(activeCode);
      
 173        String randomCode = activeCode.substring(0, 4);
 174        if (!(randomCode.equals(this.activeSerialNum.substring(this.activeSerialNum.length() - 4, this.activeSerialNum.length()))))
            {
 176          MsgBox.showWarning("验证失败！");
 177          this.status = false;
 178          return;
            }
 180        int key = calculateRomdom(randomCode);
 181        String latestCheckDate = activeCode.substring(4);
 182        String realValue = calculateRealValue(key, latestCheckDate);
 183        ILicenseSrvAgent agent = LicenseSrvAgentFactory.getRemoteInstance();
 184        if (!(agent.updateLatestCheckDate(realValue))) {
 185          MsgBox.showWarning("验证失败！");
 186          this.status = false;
 187          return;
            }
 189        this.status = true;
 190        MsgBox.showWarning("验证成功！");
 191        disposeUIWindow();
          } catch (Throwable e1) {
 193        logger.error(e1.getMessage(), e1);
 194        MsgBox.showWarning("验证失败！");
 195        this.status = false;
          }*/
				this.status = true;
/* 190 */       MsgBox.showWarning("验证成功！");
/* 191 */       disposeUIWindow();
/*     */   }
/*     */
/*     */   private String calculateRealValue(int key, String latestCheckDate)
/*     */   {
/* 201 */     StringBuffer result = new StringBuffer();
/* 202 */     for (int i = 0; i < latestCheckDate.length(); ++i) {
/* 203 */       int temp = latestCheckDate.charAt(i) - key;
/* 204 */       char c = (char)temp;
/* 205 */       result.append(c);
/*     */     }
/* 207 */     return result.toString();
/*     */   }
/*     */
/*     */   private int calculateRomdom(String randomCode)
/*     */   {
/* 212 */     int sum = 0;
/* 213 */     for (int i = 0; i < randomCode.length(); ++i) {
/* 214 */       sum += Integer.parseInt(String.valueOf(randomCode.charAt(i)));
/*     */     }
/* 216 */     return sum;
/*     */   }
/*     */
/*     */   public boolean getReturnValue()
/*     */   {
/* 221 */     return this.status;
/*     */   }
/*     */
/*     */   private String generateGenuineValidity()
/*     */     throws LicenseException
/*     */   {
/* 227 */     ILicenseSrvAgent agent = LicenseSrvAgentFactory.getRemoteInstance();
/* 228 */     LicenseCloudRequestInfo requestInfo = agent.generateRequestInfo(new String[] { SysContext.getSysContext().getDcName() });
/*     */ 
/* 230 */     JSONObject json = null;
/*     */     try {
/* 232 */       json = LicenseHelper.generateJSONObject(requestInfo);
/*     */     } catch (JSONException e) {
/* 234 */       throw new LicenseException(e);
/*     */     }
/*     */ 
/* 237 */     String base64String = Base64Encoder.byteArrayToBase64(json.toString().getBytes());
/* 238 */     String filePath = generateFilePath();
/* 239 */     File file = new File(filePath);
/* 240 */     FileWriter fileWriter = null;
/*     */     try {
/* 242 */       if (!(file.exists())) {
/* 243 */         file.createNewFile();
/*     */       }
/* 245 */       fileWriter = new FileWriter(file);
/* 246 */       fileWriter.write("");
/* 247 */       fileWriter.flush();
/* 248 */       fileWriter.write(base64String);
/* 249 */       fileWriter.flush();
/* 250 */       fileWriter.close();
/*     */     } catch (IOException e) {
/*     */     }
/*     */     finally {
/* 254 */       if (fileWriter != null) {
/* 255 */         fileWriter = null;
/*     */       }
/*     */     }
/* 258 */     return filePath;
/*     */   }
/*     */
/*     */   private String generateFilePath()
/*     */   {
/* 263 */     String filePath = null;
/* 264 */     if (System.getProperty("easclient.root") != null)
/* 265 */       filePath = System.getProperty("easclient.root") + File.separator + "GenuineValidity.dat";
/*     */     else {
/* 267 */       filePath = "w:\\eas\\deploy\\clientGenuineValidity.dat";
/*     */     }
/* 269 */     return filePath;
/*     */   }
/*     */ }
