import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;
    private Random rand = new Random();

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // Top panel: label + scaled image
        JLabel titleLabel = new JLabel("Fortune Teller");

        ImageIcon icon = new ImageIcon("fortune.png");

        // Resize image to prevent overlaying the GUI
        Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        titleLabel.setIcon(scaledIcon);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        Font titleFont = new Font("Serif", Font.BOLD, 36);
        titleLabel.setFont(titleFont);

        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);

        // Middle panel: text area in scroll pane
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setEditable(false);
        Font fortuneFont = new Font("SansSerif", Font.PLAIN, 16);
        fortuneArea.setFont(fortuneFont);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel: buttons
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 18);
        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        // Add panels to frame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // 12 basic fortunes
        fortunes = new ArrayList<>();
        fortunes.add("Good things are coming your way.");
        fortunes.add("A new opportunity will present itself soon.");
        fortunes.add("You will find peace in a small moment today.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("Your hard work will bring rewards.");
        fortunes.add("Someone will appreciate your kindness.");
        fortunes.add("A positive change is on the horizon.");
        fortunes.add("You will make a decision that leads to success.");
        fortunes.add("Happiness will come from an unexpected place.");
        fortunes.add("You will soon gain clarity in a confusing situation.");
        fortunes.add("A calm moment will help you see things clearly.");
        fortunes.add("Your patience will bring good results.");

        // Button actions
        readButton.addActionListener(e -> showFortune());
        quitButton.addActionListener(e -> System.exit(0));

        // Toolkit: size 3/4 of screen and center
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showFortune() {
        int index;
        do {
            index = rand.nextInt(fortunes.size());
        } while (index == lastIndex);

        lastIndex = index;
        String fortune = fortunes.get(index);
        fortuneArea.append(fortune + "\n");
    }
}
