/*
 * GradeManageInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.rongjun.zheng.view;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.rongjun.zheng.dao.GradeDao;
import com.rongjun.zheng.dao.SchoolClassDao;
import com.rongjun.zheng.model.Grade;
import com.rongjun.zheng.util.DbUtil;
import com.rongjun.zheng.util.StringUtil;

/**
 *
 * @author  __USER__
 */
public class GradeManageInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	GradeDao gradeDao = new GradeDao();
	SchoolClassDao schoolClassDao=new SchoolClassDao();

	/** Creates new form GradeManageInterFrm */
	public GradeManageInterFrm() {
		this.setLocation(400, 200);
		initComponents();
		this.fillTable(new Grade());
		this.jcb_gradeInit();
	}

	private void fillTable(Grade grade) {
		Connection con = null;
		DefaultTableModel defaultTableModel = (DefaultTableModel) this.gradeTable
				.getModel();
		defaultTableModel.setRowCount(0);
		try {
			con = dbUtil.getCon();
			ResultSet rs = gradeDao.gradeList(con, grade);
			while (rs.next()) {
				String[] newrow = { rs.getInt(1) + "", rs.getString(2),
						rs.getString(3) };
				defaultTableModel.addRow(newrow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void jcb_gradeInit(){
		this.jcb_grade.removeAllItems();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = gradeDao.gradeList(con, new Grade());
			while (rs.next()) {
				this.jcb_grade.addItem(rs.getString(2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

jScrollPane1 = new javax.swing.JScrollPane();
gradeTable = new javax.swing.JTable();
jLabel1 = new javax.swing.JLabel();
jb_gradeSearch = new javax.swing.JButton();
jLabel2 = new javax.swing.JLabel();
idTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
gradeTxt = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
jScrollPane2 = new javax.swing.JScrollPane();
gradeRemarkTxt = new javax.swing.JTextArea();
jb_grademodify = new javax.swing.JButton();
jb_gradedelete = new javax.swing.JButton();
jcb_grade = new javax.swing.JComboBox();
jb_showall = new javax.swing.JButton();

setClosable(true);
setIconifiable(true);
setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");

gradeTable.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"�꼶���", "�꼶", "��ע"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
gradeTable.addMouseListener(new java.awt.event.MouseAdapter() {
public void mousePressed(java.awt.event.MouseEvent evt) {
gradeTableMousePressed(evt);
}
});
jScrollPane1.setViewportView(gradeTable);

jLabel1.setText("\u5e74\u7ea7");

jb_gradeSearch.setText("\u67e5\u8be2");
jb_gradeSearch.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_gradeSearchActionPerformed(evt);
}
});

jLabel2.setText("\u7f16\u53f7");

idTxt.setEditable(false);

jLabel3.setText("\u5e74\u7ea7");

jLabel4.setText("\u5907\u6ce8");

gradeRemarkTxt.setColumns(20);
gradeRemarkTxt.setRows(5);
jScrollPane2.setViewportView(gradeRemarkTxt);

jb_grademodify.setText("\u4fee\u6539");
jb_grademodify.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_grademodifyActionPerformed(evt);
}
});

jb_gradedelete.setText("\u5220\u9664");
jb_gradedelete.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_gradedeleteActionPerformed(evt);
}
});



jb_showall.setText("\u5168\u90e8\u663e\u793a");
jb_showall.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_showallActionPerformed(evt);
}
});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addGroup(layout.createSequentialGroup()
.addGap(111, 111, 111)
.addComponent(jLabel1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jcb_grade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(34, 34, 34)
.addComponent(jb_gradeSearch)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jb_showall))
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
.addGap(49, 49, 49)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jLabel3)
.addComponent(jLabel2))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addComponent(gradeTxt)
.addComponent(idTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jb_grademodify)))
.addGap(18, 18, 18)
.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jb_gradedelete)
.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addGroup(layout.createSequentialGroup()
.addGap(58, 58, 58)
.addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)))
.addContainerGap(175, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(23, 23, 23)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(jb_gradeSearch)
.addComponent(jcb_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jb_showall))
.addGap(18, 18, 18)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel2)
.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel4))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3)
.addComponent(gradeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jb_grademodify)
.addComponent(jb_gradedelete))
.addGap(20, 20, 20))
);

pack();
}// </editor-fold>

	//GEN-END:initComponents
	private void jb_showallActionPerformed(java.awt.event.ActionEvent evt) {
		this.fillTable(new Grade());
	}

	private void jb_gradeSearchActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String gradeName = (String) this.jcb_grade.getSelectedItem();
		Grade grade = new Grade();
		grade.setGradeName(gradeName);
		this.fillTable(grade);

	}

	private void jb_grademodifyActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String id = this.idTxt.getText();
		String gradeName = this.gradeTxt.getText();
		String gradeRemark = this.gradeRemarkTxt.getText();
		if(StringUtil.isEmpty(gradeName)){
			JOptionPane.showMessageDialog(null,"��ѡ��һ����¼");
			return;
		}
		Grade grade = new Grade(gradeName, gradeRemark);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int num = gradeDao.gradeModify(con, grade, id);
			if (num == 1) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.fillTable(new Grade());
				this.jcb_gradeInit();
			} else if (num == 2) {
				JOptionPane.showMessageDialog(null, "��¼��û�иı�");
			} else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
		}

	}

	private void jb_gradedeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		// TODO add your handling code here:
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "�Ƿ�������¼��");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				boolean flag=schoolClassDao.getclassByGradeID(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "������»��а༶");
					return;
				}
				int deleteNum = gradeDao.gradeDelete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.fillTable(new Grade());
					this.jcb_gradeInit();
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			} finally {
				try {
					dbUtil.close(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	private void gradeTableMousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.gradeTable.getSelectedRow();
		this.idTxt.setText((String) this.gradeTable.getValueAt(row, 0));
		this.gradeTxt.setText((String) this.gradeTable.getValueAt(row, 1));
		this.gradeRemarkTxt
				.setText((String) this.gradeTable.getValueAt(row, 2));
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea gradeRemarkTxt;
	private javax.swing.JTable gradeTable;
	private javax.swing.JTextField gradeTxt;
	private javax.swing.JTextField idTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_gradeSearch;
	private javax.swing.JButton jb_gradedelete;
	private javax.swing.JButton jb_grademodify;
	private javax.swing.JButton jb_showall;
	private javax.swing.JComboBox jcb_grade;
	// End of variables declaration//GEN-END:variables

}