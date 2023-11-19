package mnegm.view;

import javax.swing.*;


/**
 * Das Frame-Klasse des Worttrainers.
 * @author Maged Negm
 * @version 2023-11-15
 */
public class WortFrame extends JFrame {
    public WortFrame(JPanel WortLayout) {
        this.setTitle("Worttrainer_mnegm3CHIT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(WortLayout);
        this.setVisible(true);
        this.setResizable(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
