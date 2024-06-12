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

public class Lotto extends JFrame {

    private JPanel contentPane;

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
    }

} 