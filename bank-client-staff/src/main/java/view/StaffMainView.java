/*
 * Created by JFormDesigner on Mon Oct 15 22:02:45 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class StaffMainView extends JFrame {
    public StaffMainView() {
        initComponents();
    }

    private void btn_signoutActionPerformed(ActionEvent e) {
        this.dispose();
        new StaffLoginView().run();
    }

    private void btn_add_moreInfoActionPerformed(ActionEvent e) {
        this.dispose();
        new StaffAddAccountInfoView().run();
    }

    private void btn_remove_moreInfoActionPerformed(ActionEvent e) {
        this.dispose();
        new StaffRemoveAccountInfoView().run();
    }

    private void btn_frozen_moreInfoActionPerformed(ActionEvent e) {
        this.dispose();
        new StaffFrozenAccountInfoView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tab_staffTab = new JTabbedPane();
        requestPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table_requestTable = new JTable();
        btn_add_moreInfo = new JButton();
        removePanel = new JPanel();
        scrollPane3 = new JScrollPane();
        table_removeAccounts = new JTable();
        btn_remove_moreInfo = new JButton();
        frozenPanel = new JPanel();
        scrollPane2 = new JScrollPane();
        table_frozenAccountsTable = new JTable();
        btn_frozen_moreInfo = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Staff Main View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== tab_staffTab ========
        {
            tab_staffTab.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //======== requestPanel ========
            {
                requestPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane1 ========
                {

                    //---- table_requestTable ----
                    table_requestTable.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "First Name", "Last Name", "Account Type", "Email", "Contact Number"
                        }
                    ));
                    table_requestTable.setMinimumSize(new Dimension(500, 48));
                    table_requestTable.setPreferredSize(new Dimension(1000, 48));
                    scrollPane1.setViewportView(table_requestTable);
                }
                requestPanel.add(scrollPane1, "cell 0 0,wmin 800");

                //---- btn_add_moreInfo ----
                btn_add_moreInfo.setText("More Info");
                btn_add_moreInfo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_add_moreInfoActionPerformed(e);
                    }
                });
                requestPanel.add(btn_add_moreInfo, "cell 0 1");
            }
            tab_staffTab.addTab("Add a Customer account Requests", requestPanel);

            //======== removePanel ========
            {
                removePanel.setMinimumSize(new Dimension(800, 71));
                removePanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[300:n,fill]" +
                    "[100:n,fill]",
                    // rows
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]" +
                    "[]"));

                //======== scrollPane3 ========
                {
                    scrollPane3.setMinimumSize(new Dimension(800, 20));

                    //---- table_removeAccounts ----
                    table_removeAccounts.setMinimumSize(new Dimension(500, 32));
                    table_removeAccounts.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null},
                            {null, null},
                        },
                        new String[] {
                            "A", "B"
                        }
                    ));
                    scrollPane3.setViewportView(table_removeAccounts);
                }
                removePanel.add(scrollPane3, "cell 0 0");

                //---- btn_remove_moreInfo ----
                btn_remove_moreInfo.setText("More Info");
                btn_remove_moreInfo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_remove_moreInfoActionPerformed(e);
                    }
                });
                removePanel.add(btn_remove_moreInfo, "cell 0 5");
            }
            tab_staffTab.addTab("Remove a customer account requests", removePanel);

            //======== frozenPanel ========
            {
                frozenPanel.setMinimumSize(new Dimension(800, 48));
                frozenPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane2 ========
                {
                    scrollPane2.setMinimumSize(new Dimension(700, 20));

                    //---- table_frozenAccountsTable ----
                    table_frozenAccountsTable.setMinimumSize(new Dimension(500, 32));
                    scrollPane2.setViewportView(table_frozenAccountsTable);
                }
                frozenPanel.add(scrollPane2, "cell 0 0");

                //---- btn_frozen_moreInfo ----
                btn_frozen_moreInfo.setText("More Info");
                btn_frozen_moreInfo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                btn_frozen_moreInfo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_frozen_moreInfoActionPerformed(e);
                    }
                });
                frozenPanel.add(btn_frozen_moreInfo, "cell 0 1");
            }
            tab_staffTab.addTab("Frozen customer accounts", frozenPanel);
        }
        contentPane.add(tab_staffTab, "cell 0 0,wmin 800");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_signoutActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 0 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tab_staffTab;
    private JPanel requestPanel;
    private JScrollPane scrollPane1;
    private JTable table_requestTable;
    private JButton btn_add_moreInfo;
    private JPanel removePanel;
    private JScrollPane scrollPane3;
    private JTable table_removeAccounts;
    private JButton btn_remove_moreInfo;
    private JPanel frozenPanel;
    private JScrollPane scrollPane2;
    private JTable table_frozenAccountsTable;
    private JButton btn_frozen_moreInfo;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}