package java_database.view;

import java_database.model.RoomDao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class AddRoomDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;



    public AddRoomDialog(Hotel hotel) {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel lblNewLabel = new JLabel("Level");
            GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
            gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel.gridx = 0;
            gbc_lblNewLabel.gridy = 0;
            contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        }
        {
            textField = new JTextField();
            GridBagConstraints gbc_textField = new GridBagConstraints();
            gbc_textField.insets = new Insets(0, 0, 5, 0);
            gbc_textField.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField.gridx = 1;
            gbc_textField.gridy = 0;
            contentPanel.add(textField, gbc_textField);
            textField.setColumns(10);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("RoomCategoryId");
            GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
            gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_1.gridx = 0;
            gbc_lblNewLabel_1.gridy = 1;
            contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
        }
        {
            textField_1 = new JTextField();
            GridBagConstraints gbc_textField_1 = new GridBagConstraints();
            gbc_textField_1.insets = new Insets(0, 0, 5, 0);
            gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_1.gridx = 1;
            gbc_textField_1.gridy = 1;
            contentPanel.add(textField_1, gbc_textField_1);
            textField_1.setColumns(10);
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Area");
            GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
            gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_2.gridx = 0;
            gbc_lblNewLabel_2.gridy = 2;
            contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
        }
        {
            textField_2 = new JTextField();
            GridBagConstraints gbc_textField_2 = new GridBagConstraints();
            gbc_textField_2.insets = new Insets(0, 0, 5, 0);
            gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_2.gridx = 1;
            gbc_textField_2.gridy = 2;
            contentPanel.add(textField_2, gbc_textField_2);
            textField_2.setColumns(10);
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Price");
            GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
            gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_3.gridx = 0;
            gbc_lblNewLabel_3.gridy = 3;
            contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
        }
        {
            textField_3 = new JTextField();
            GridBagConstraints gbc_textField_3 = new GridBagConstraints();
            gbc_textField_3.insets = new Insets(0, 0, 5, 0);
            gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_3.gridx = 1;
            gbc_textField_3.gridy = 3;
            contentPanel.add(textField_3, gbc_textField_3);
            textField_3.setColumns(10);
        }
        {
            JLabel lblNewLabel_4 = new JLabel("Reserved");
            GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
            gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_4.gridx = 0;
            gbc_lblNewLabel_4.gridy = 4;
            contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        }
        {
            chckbxNewCheckBox = new JCheckBox("");
            GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
            gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
            gbc_chckbxNewCheckBox.gridx = 1;
            gbc_chckbxNewCheckBox.gridy = 4;
            contentPanel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
        }
        {
            JLabel lblNewLabel_5 = new JLabel("onSale");
            GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
            gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_5.gridx = 0;
            gbc_lblNewLabel_5.gridy = 5;
            contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
        }
        {
            chckbxNewCheckBox_1 = new JCheckBox("");
            GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
            gbc_chckbxNewCheckBox_1.gridx = 1;
            gbc_chckbxNewCheckBox_1.gridy = 5;
            contentPanel.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        RoomDao roomDao = new RoomDao(
                                Integer.parseInt(textField.getText()),
                                Integer.parseInt(textField_1.getText()),
                                Double.parseDouble(textField_2.getText()),
                                Integer.parseInt(textField_3.getText()),
                                chckbxNewCheckBox.isSelected(),
                                chckbxNewCheckBox_1.isSelected()
                        );

                        hotel.addRoom(roomDao);
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}

