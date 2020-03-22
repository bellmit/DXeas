package com.kingdee.eas.custom.commld.Component;

import com.kingdee.bos.ctrl.swing.KDDialog;
import com.kingdee.bos.ctrl.swing.KDProgressBar;
import com.kingdee.bos.ctrl.swing.KDSeparator;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.SwingWorker;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.ExceptionHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Window;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LongTimeDialog extends KDDialog{

	private static final String RESOURCE = "com.kingdee.eas.base.permission.PermissionResource";
	private ILongTimeTask longTimeTask = null;

	private static final Color bottomBgColor = new Color(230, 230, 230);

	private Object result = null;

	private Window parent = null;

	public LongTimeDialog(Frame frame)
	{
		super(frame, EASResource.getString("com.kingdee.eas.base.permission.PermissionResource", "functionInvoking"), true);
		this.parent = frame;
	}

	public LongTimeDialog(Dialog dialog)
	{
		super(dialog, EASResource.getString("com.kingdee.eas.base.permission.PermissionResource", "functionInvoking"), true);
		this.parent = dialog;
	}

	public void setLongTimeTask(ILongTimeTask longTimeTask)
	{
		this.longTimeTask = longTimeTask;
	}

	protected void dialogInit()
	{
		super.dialogInit();
		setResizable(false);

		setDefaultCloseOperation(0);
		setLocationRelativeTo(null);

		JPanel contentPane = (JPanel)getContentPane();
		contentPane.setLayout(null);
		Dimension bgPanelDimension = new Dimension(363, 96);
		int normalBottomHeight = 42;
		int advanceBottomHeight = 202;
		contentPane.setPreferredSize(new Dimension(bgPanelDimension.width, bgPanelDimension.height + 42));

		contentPane.setBackground(new Color(16777215));

		JPanel pnlBottom = new JPanel();
		pnlBottom.setLayout(null);
		pnlBottom.setBounds(0, bgPanelDimension.height, bgPanelDimension.width, 202);

		contentPane.add(pnlBottom);
		pnlBottom.setBackground(bottomBgColor);
		Graphics2D g2d = (Graphics2D)pnlBottom.getGraphics();
		if (g2d != null)
		{
			GradientPaint gradient = new GradientPaint(0.0F, 0.0F, new Color(16777215), 363.0F, 96.0F, new Color(11842740));
			g2d.setPaint(gradient);
		}

		KDSeparator sp = new KDSeparator();
		sp.setBounds(0, 0, bgPanelDimension.width, 2);
		pnlBottom.add(sp);

		JLabel text = new JLabel(EASResource.getString("com.kingdee.eas.base.permission.PermissionResource", "waitPlease"));
		text.setBounds(44, 29, 279, 20);

		KDProgressBar progressBar = new KDProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(true);
		getContentPane().add(text, null);
		getContentPane().add(progressBar, null);
		progressBar.setBounds(new Rectangle(42, 50, 279, 12));
		pack();
		setLocationRelativeTo(null);
	}

	public void show()
	{
		SwingWorker longTimeTaskWorker = new SwingWorker()
		{
			public Object construct()
			{
				try
				{
					//	           LongTimeDialog.access$002(LongTimeDialog.this, LongTimeDialog.this.longTimeTask.exec());
					LongTimeDialog.this.setVisible(false);
					LongTimeDialog.this.dispose();
					return LongTimeDialog.this.result;
				}
				catch (Exception e)
				{
					LongTimeDialog.this.setVisible(false);
					LongTimeDialog.this.dispose();
					ExceptionHandler.handle(LongTimeDialog.this.parent, e); }
				return null;

			}

			public void finished()
			{
				if (LongTimeDialog.this.result == null)
					return;
				try
				{
					Thread.sleep(500L);
					LongTimeDialog.this.longTimeTask.afterExec(LongTimeDialog.this.result);
					LongTimeDialog.this.setVisible(false);
					LongTimeDialog.this.dispose();

				}
				catch (Exception e)
				{
					ExceptionHandler.handle(LongTimeDialog.this.parent, e);


				}
			}
		};
		longTimeTaskWorker.start();

		setCursor(this, Cursor.getPredefinedCursor(3));
		super.show();
		setCursor(this, Cursor.getPredefinedCursor(0));
	}

	private void setCursor(Component cp, Cursor cursor)
	{
		cp.setCursor(cursor);
		if (!(cp instanceof Container))
			return;
		Container cc = (Container)cp;

		int i = 0; for (int n = cc.getComponentCount(); i < n; ++i)
		{
			Component curComponent = cc.getComponent(i);
			setCursor(curComponent, cursor);
		}
	}

}
