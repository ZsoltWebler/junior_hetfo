package fuel;

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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertRecordDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField manufacturerField;
	private JTextField modelField;
	private JTextField engineSizeField;
	private JComboBox fuelTypeBox;
	private JSpinner co2EmissionSpinner;
	private FuelFrame parent;

	public InsertRecordDialog(FuelFrame frame) {
		this.parent = frame;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Manufacturer");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			manufacturerField = new JTextField();
			GridBagConstraints gbc_manufacturerField = new GridBagConstraints();
			gbc_manufacturerField.insets = new Insets(0, 0, 5, 0);
			gbc_manufacturerField.fill = GridBagConstraints.HORIZONTAL;
			gbc_manufacturerField.gridx = 1;
			gbc_manufacturerField.gridy = 0;
			contentPanel.add(manufacturerField, gbc_manufacturerField);
			manufacturerField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Model");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 1;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			modelField = new JTextField();
			GridBagConstraints gbc_modelField = new GridBagConstraints();
			gbc_modelField.insets = new Insets(0, 0, 5, 0);
			gbc_modelField.fill = GridBagConstraints.HORIZONTAL;
			gbc_modelField.gridx = 1;
			gbc_modelField.gridy = 1;
			contentPanel.add(modelField, gbc_modelField);
			modelField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Engine size");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			engineSizeField = new JTextField();
			GridBagConstraints gbc_engineSizeField = new GridBagConstraints();
			gbc_engineSizeField.insets = new Insets(0, 0, 5, 0);
			gbc_engineSizeField.fill = GridBagConstraints.HORIZONTAL;
			gbc_engineSizeField.gridx = 1;
			gbc_engineSizeField.gridy = 2;
			contentPanel.add(engineSizeField, gbc_engineSizeField);
			engineSizeField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Fuel type");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 3;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			fuelTypeBox = new JComboBox();
			fuelTypeBox.setModel(new DefaultComboBoxModel<FuelType>(FuelType.values()));
			GridBagConstraints gbc_fuelTypeBox = new GridBagConstraints();
			gbc_fuelTypeBox.insets = new Insets(0, 0, 5, 0);
			gbc_fuelTypeBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_fuelTypeBox.gridx = 1;
			gbc_fuelTypeBox.gridy = 3;
			contentPanel.add(fuelTypeBox, gbc_fuelTypeBox);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Co2 emission");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 4;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			co2EmissionSpinner = new JSpinner();
			co2EmissionSpinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			GridBagConstraints gbc_co2EmissionSpinner = new GridBagConstraints();
			gbc_co2EmissionSpinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_co2EmissionSpinner.gridx = 1;
			gbc_co2EmissionSpinner.gridy = 4;
			contentPanel.add(co2EmissionSpinner, gbc_co2EmissionSpinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						CarEmissionInfo carEmissionInfo = new CarEmissionInfo(
								manufacturerField.getText(),
								modelField.getText(),
								Double.parseDouble(engineSizeField.getText()),
								(FuelType) fuelTypeBox.getSelectedItem(),
								(int) co2EmissionSpinner.getValue());
						
						parent.insertRecord(carEmissionInfo);
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
