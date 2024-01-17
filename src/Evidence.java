import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Evidence extends JFrame {
    private JPanel EvidenceZaku;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtBirthDate;
    private JCheckBox cbOdsouhlasil;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JTextArea txtNakupy;
    private JButton btnReload;
    private JButton btnSave;
    private JCheckBox cbCheckBox;

    static ArrayList<Zak> seznamZaku = new ArrayList<>();
    static ButtonGroup rocnikGroup = new ButtonGroup();

    public Evidence() {
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nacistZnovu(0); //pracujeme pouze s první položkou v evidenci
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ulozit(0); //pracujeme pouze s první položkou v evidenci
            }
        });
    }

    public static void main(String[] args) {
        Evidence evidence = new Evidence();
        evidence.setDefaultCloseOperation(EXIT_ON_CLOSE);
        evidence.setTitle("Evidence žáků");
        evidence.setSize(400, 300);
        evidence.setContentPane(evidence.EvidenceZaku);
        evidence.setVisible(true);

        rocnikGroup.add(evidence.rb1);
        rocnikGroup.add(evidence.rb2);
        rocnikGroup.add(evidence.rb3);
        rocnikGroup.add(evidence.rb4);

        ArrayList<Nakup> seznamNakupu = new ArrayList<>();
        seznamNakupu.add(new Nakup(LocalDate.parse("2023-12-21"), 77.25));
        seznamNakupu.add(new Nakup(LocalDate.parse("2024-01-12"), 114.99));
        seznamZaku.add(new Zak("Pavel", "Novák", LocalDate.parse("2004-07-26"), true, 4, seznamNakupu));

    }

    public void nacistZnovu(int indexZaka) {
        Zak zak = seznamZaku.get(indexZaka);
        txtName.setText(zak.getJmeno());
        txtSurname.setText(zak.getPrijmeni());
        txtBirthDate.setText(zak.getDatumNarozeni().toString());
        cbOdsouhlasil.setSelected(zak.isOdsouhlasilGDPR());
        switch (zak.getRocnik()) {
            case 1:
                rb1.setSelected(true);
                break;
            case 2:
                rb2.setSelected(true);
                break;
            case 3:
                rb3.setSelected(true);
                break;
            case 4:
                rb4.setSelected(true);
                break;
        }
        txtNakupy.setText("");
        for (Nakup nakup : zak.getSeznamNakupu()) {
            txtNakupy.append("datum: " + nakup.getDatum().toString() + ", cena: " + nakup.getCena() + " Kč\n");
        }
    }

    public void ulozit(int indexZaka) {
        Zak zak = seznamZaku.get(indexZaka);

        zak.setJmeno(txtName.getText());
        zak.setPrijmeni(txtSurname.getText());
        zak.setDatumNarozeni(LocalDate.parse(txtBirthDate.getText()));
        zak.setOdsouhlasilGDPR(cbOdsouhlasil.isSelected());
        if (rb1.isSelected()) {
            zak.setRocnik(1);
        } else if (rb2.isSelected()) {
            zak.setRocnik(2);
        } else if (rb3.isSelected()) {
            zak.setRocnik(3);
        } else {
            zak.setRocnik(4);
        }
        String[] nakupy = txtNakupy.getText().split("Kč");
        ArrayList<Nakup> seznamNakupu = new ArrayList<>();
        for (String nakup : nakupy) {
            nakup = nakup.trim();
            if (!nakup.isEmpty()) {
                try {
                    LocalDate datum = LocalDate.parse(nakup.substring(7, nakup.indexOf(",")));
                    double cena = Double.parseDouble(nakup.substring(nakup.indexOf(",") + 8));
                    seznamNakupu.add(new Nakup(datum, cena));
                } catch (NumberFormatException e ) {
                    JOptionPane.showMessageDialog(this, "Špatný formát nákupů!");
                }
            }
        }
        zak.setSeznamNakupu(seznamNakupu);
        seznamZaku.set(indexZaka, zak);
        if (cbCheckBox.isSelected()) {
            cbCheckBox.setSelected(false);
            JOptionPane.showMessageDialog(this, "Evidence žáka uložena\nCheckbox byl odškrtnut");
        }
        else {
            cbCheckBox.setSelected(true);
            JOptionPane.showMessageDialog(this, "Evidence žáka uložena\nCheckbox byl zaškrtnut");
        }
    }
}