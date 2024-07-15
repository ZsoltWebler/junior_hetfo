package lotto;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class Lotto extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto frame = new Lotto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private List<LottoInformation> readModel() {
		List<LottoInformation> informations = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(
					new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\GUI\\src\\lotto\\otos.csv"));

			scanner.nextLine();

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String[] values = line.split(";");

				long maxWin = Long.MIN_VALUE;

				for (int i = 4; i <= 10; i += 2) {
					long winning = Long.parseLong(values[i].replace("Ft", "").replace(" ", ""));
					if (winning > maxWin) {
						maxWin = winning;
					}
				}

				LottoInformation lottoInformation = new LottoInformation(Integer.parseInt(values[0]),
						Integer.parseInt(values[1]), maxWin,
						Set.of(Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]),
								Integer.parseInt(values[14]), Integer.parseInt(values[15])));

				informations.add(lottoInformation);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return informations;
	}

	/**
	 * Create the frame.
	 */
	public Lotto() {

		List<LottoInformation> informations = readModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
	}

}
