import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ImdbFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ImdbFrame frame = new ImdbFrame();
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
    public ImdbFrame() {

        List<Movie> movies = ReadTest.readModel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 0;
        contentPane.add(scrollPane, gbc_scrollPane);

        table = new JTable();
        table.setModel(new MovieTableModel(movies));
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("Add movie");
        btnNewButton.addActionListener(e -> {
            AddMovieDialog dialog = new AddMovieDialog();
            dialog.setVisible(true);
            System.out.println("klikk");
            if(dialog.hasValue()){
                movies.add(dialog.getMovie());
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 1;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

}
