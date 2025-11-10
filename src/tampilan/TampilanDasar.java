package tampilan;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Template dasar form.
 */
public class TampilanDasar extends JFrame {

    // <editor-fold defaultstate="collapsed" desc="Inisialisasi">
    public TampilanDasar(String judul) {
        super(judul);
        aturTampilan();
        buatKomponen();
        aturLayout();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Pengaturan awal frame">
    private void aturTampilan() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 720);          // standar proyek
        setLocationRelativeTo(null); // center
        setMinimumSize(new Dimension(960, 600));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Komponen UI">
    protected JPanel panelUtama;
    protected JLabel judulLabel;

    private void buatKomponen() {
        panelUtama = new JPanel();
        panelUtama.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        judulLabel = new JLabel(getTitle());
        judulLabel.setFont(judulLabel.getFont().deriveFont(Font.BOLD, 20f));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Atur layout dasar">
    private void aturLayout() {
        setLayout(new BorderLayout());
        add(panelUtama, BorderLayout.CENTER);

        // contoh header sederhana
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(16, 24, 8, 24));
        header.add(judulLabel, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);
    }
    // </editor-fold>

    // Jalankan contoh
    public static void main(String[] args) {
        FlatLightLaf.setup(); // pakai FlatLaf standar
        SwingUtilities.invokeLater(() -> new TampilanDasar("Judul Form").setVisible(true));
    }
}
