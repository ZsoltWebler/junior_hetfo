import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {

		List<Song> songs = readModel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new SongTableModel(songs));
		
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(e -> {
			System.out.println("MEGNYOMVA!");
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	private List<Song> readModel() {
		
		List<Song> songs = new ArrayList<Song>();

		try {
			Scanner scanner = new Scanner(
					new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\GUI\\src\\musor.txt"));

			while (scanner.hasNextLine()) {
				String[] values = scanner.nextLine().split(" ",4);
				
				String[] artistAndTitle = values[3].split(":");
				
				Song song = new Song(
						Integer.parseInt(values[1]),
						Integer.parseInt(values[2]),
						artistAndTitle[0],
						artistAndTitle[1]
						);
				
				songs.add(song);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return songs;

	}
}
