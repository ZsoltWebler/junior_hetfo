
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.lang.Integer.parseInt;

public class AddMovieDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    private boolean hasValue = false;

    public AddMovieDialog() {
        setBounds(100, 100, 450, 300);
        setModalityType(ModalityType.APPLICATION_MODAL);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        {
            JLabel lblNewLabel = new JLabel("rank");
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
            JLabel lblNewLabel_1 = new JLabel("releaseYear");
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
            JLabel lblNewLabel_2 = new JLabel("duration");
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
            JLabel lblNewLabel_3 = new JLabel("ageLimit");
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
            JLabel lblNewLabel_4 = new JLabel("imdbRating");
            GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
            gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_4.gridx = 0;
            gbc_lblNewLabel_4.gridy = 4;
            contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
        }
        {
            textField_4 = new JTextField();
            GridBagConstraints gbc_textField_4 = new GridBagConstraints();
            gbc_textField_4.insets = new Insets(0, 0, 5, 0);
            gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_4.gridx = 1;
            gbc_textField_4.gridy = 4;
            contentPanel.add(textField_4, gbc_textField_4);
            textField_4.setColumns(10);
        }
        {
            JLabel lblNewLabel_5 = new JLabel("metaScore");
            GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
            gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_5.gridx = 0;
            gbc_lblNewLabel_5.gridy = 5;
            contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
        }
        {
            textField_5 = new JTextField();
            GridBagConstraints gbc_textField_5 = new GridBagConstraints();
            gbc_textField_5.insets = new Insets(0, 0, 5, 0);
            gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_5.gridx = 1;
            gbc_textField_5.gridy = 5;
            contentPanel.add(textField_5, gbc_textField_5);
            textField_5.setColumns(10);
        }
        {
            JLabel lblNewLabel_6 = new JLabel("description");
            GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
            gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
            gbc_lblNewLabel_6.gridx = 0;
            gbc_lblNewLabel_6.gridy = 6;
            contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
        }
        {
            textField_6 = new JTextField();
            GridBagConstraints gbc_textField_6 = new GridBagConstraints();
            gbc_textField_6.insets = new Insets(0, 0, 5, 0);
            gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_6.gridx = 1;
            gbc_textField_6.gridy = 6;
            contentPanel.add(textField_6, gbc_textField_6);
            textField_6.setColumns(10);
        }
        {
            JLabel lblNewLabel_7 = new JLabel("name");
            GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
            gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
            gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
            gbc_lblNewLabel_7.gridx = 0;
            gbc_lblNewLabel_7.gridy = 7;
            contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
        }
        {
            textField_7 = new JTextField();
            GridBagConstraints gbc_textField_7 = new GridBagConstraints();
            gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
            gbc_textField_7.gridx = 1;
            gbc_textField_7.gridy = 7;
            contentPanel.add(textField_7, gbc_textField_7);
            textField_7.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                okButton.addActionListener(e -> {
                    this.hasValue = true;
                    this.dispose();
                });
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(e -> this.dispose());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public boolean hasValue() {
        return hasValue;
    }

    public Movie getMovie() {
        return hasValue ? new Movie(
                parseInt(textField.getText()),
                parseInt(textField_1.getText()),
                textField_2.getText(),
                textField_3.getText(),
                Double.parseDouble(textField_4.getText()),
                !textField_5.getText().isBlank() ? Integer.parseInt(textField_5.getText()) : 0,
                textField_6.getText(),
                textField_7.getText()) : null;
    }

}

