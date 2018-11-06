/*
 * Created by JFormDesigner on Mon Oct 15 21:59:49 BST 2018
 */

package view;

import model.StaffLoginModel;
import net.miginfocom.swing.MigLayout;
import service.impl.StaffLoginService;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author xiangkai22
 */
public class StaffLoginView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel lbl_staffId;
    private JTextField tf_staffId;
    private JLabel lbl_pwd;
    private JPasswordField pf_pwd;
    private JButton btn_login;
    public StaffLoginView() {
        initComponents();
    }

    private void btn_loginActionPerformed(ActionEvent e) {
        try {
            long staffId = Long.parseLong(tf_staffId.getText().trim());
            String password = String.valueOf(pf_pwd.getPassword());
            StaffLoginModel staffLoginModel = new StaffLoginModel(staffId, password);
            boolean isValidStaff = StaffLoginService.getInstance().staffLogin(staffLoginModel);
            if (isValidStaff) {
                new StaffMainView(staffId).run();
                this.dispose();
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,
                    "Please input a valid combination of Staff ID and password.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        lbl_staffId = new JLabel();
        tf_staffId = new JTextField();
        tf_staffId.setDocument(new JTextFieldLimit(10));
        lbl_pwd = new JLabel();
        pf_pwd = new JPasswordField();
        btn_login = new JButton();

        //======== this ========
        setTitle("Staff Login View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[100:n,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[100:n,fill]",
                // rows
                "[50:n]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[100:n]"));

        //---- label1 ----
        label1.setText("Welcome Staff Login Portal");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, "cell 1 0 2 1");

        //---- lbl_staffId ----
        lbl_staffId.setText("Staff ID");
        lbl_staffId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_staffId, "cell 1 1");

        //---- tf_staffId ----
        tf_staffId.setMinimumSize(new Dimension(110, 30));
        contentPane.add(tf_staffId, "cell 2 1");

        //---- lbl_pwd ----
        lbl_pwd.setText("Password");
        lbl_pwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_pwd, "cell 1 2");
        contentPane.add(pf_pwd, "cell 2 2");

        //---- btn_login ----
        btn_login.setText("Login");
        btn_login.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_login.addActionListener(e -> btn_loginActionPerformed(e));
        contentPane.add(btn_login, "cell 2 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
