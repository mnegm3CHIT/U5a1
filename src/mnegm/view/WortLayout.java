package mnegm.view;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

/**
 * Das Layout-Klasse des Worttrainers.
 * @author Maged Negm
 * @version 2023-11-15
 */
public class WortLayout extends JPanel {
    private JTextField eingabe, wort, url;
    private JButton reset, add, save, load;
    private JLabel rl,al, rz, az, pic, wl, ul;
    private final JLabel TITEL = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");

    public WortLayout(WortController wc) {
        this.setLayout(new BorderLayout(5, 5));

        //top
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 2));

        TITEL.setOpaque(true);
        TITEL.setHorizontalAlignment(SwingConstants.LEFT);

        eingabe = new JTextField();
        eingabe.setActionCommand("input");
        eingabe.setFont(new Font(eingabe.getFont().getName(), eingabe.getFont().BOLD, 10));
        eingabe.addActionListener(wc);

        top.add(TITEL);
        top.add(eingabe);
        this.add(top, BorderLayout.PAGE_START);


        //center
        this.add(pic, BorderLayout.CENTER);


        //bottom
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1,2,2));

        JPanel z12 = new JPanel();
        z12.setLayout(new GridLayout(2,4,2,2));

        rl = new JLabel("Richtige Wörter:");
        rl.setOpaque(true);

        al = new JLabel("Anzahl Wörter:");
        al.setOpaque(true);

        rz = new JLabel("0");
        rz.setOpaque(true);
        rz.setHorizontalAlignment(SwingConstants.CENTER);

        az = new JLabel("0");
        az.setOpaque(true);
        az.setHorizontalAlignment(SwingConstants.CENTER);

        reset = new JButton("Zurücksetzen");
        reset.setActionCommand("reset");
        reset.addActionListener(wc);
        reset.setEnabled(false);

        reset = new JButton("Wort hinzufügen");
        reset.setActionCommand("add");
        reset.addActionListener(wc);

        save = new JButton("Speichern");
        save.setActionCommand("save");
        save.addActionListener(wc);
        save.setEnabled(false);

        save = new JButton("Laden");
        save.setActionCommand("load");
        save.addActionListener(wc);

        z12.add(rl);
        z12.add(rz);
        z12.add(reset);
        z12.add(save);
        z12.add(al);
        z12.add(az);
        z12.add(add);
        z12.add(load);

        JPanel z24 = new JPanel();
        z24.setLayout(new GridLayout(2,2,2,2));

        wl = new JLabel("Neues Wort");
        wl.setOpaque(true);

        ul = new JLabel("Neue URL");
        ul.setOpaque(true);

        wort = new JTextField();
        wort.setActionCommand("wort");
        wort.addActionListener(wc);

        url = new JTextField();
        url.setActionCommand("url");
        url.addActionListener(wc);

        z24.add(wl);
        z24.add(ul);
        z24.add(wort);
        z24.add(url);

        bottom.add(z12);
        bottom.add(z24);
    }

    public void setEB(boolean tf) {
        eingabe.setBackground(tf == true ? Color.GREEN : Color.RED);
    }

    public String getEingabe() {
        return eingabe.getText();
    }

    public String getWort() {
        return wort.getText();
    }

    public String getUrl() {
        return url.getText();
    }

    public void setPic(String picUrl) throws MalformedURLException {
            ImageIcon icon = new ImageIcon(new URL(picUrl));
            Image image = icon.getImage();
            image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            pic.setIcon(new ImageIcon(image));
    }

    public void setW(int rw, int aw, boolean tf) {
        this.setEB(tf);
        eingabe.setText("");
        rz.setText(""+rw);
        az.setText(""+aw);
        repaint();
    }

    public void load(int rw, int aw) {
        setW(rw,aw,true);
        eingabe.setBackground(Color.GRAY);
    }

    public void reset() {
        eingabe.setBackground(Color.GRAY);
        eingabe.setText("");
        rz.setText("0");
        az.setText("0");
        repaint();
    }

    /**
     * Diese Methode setzt den Reset-Button auf verfügbar oder nicht verfügbar.
     *
     * @param x true, um den Button verfügbar zu machen, false, um ihn nicht verfügbar zu machen.
     */
    public void setReset(boolean x) {
        reset.setEnabled(x);
    }
}
