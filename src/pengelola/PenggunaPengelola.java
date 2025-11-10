package pengelola;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entitas.Pengguna;
import koneksi.Koneksi;

/**
 * Mengelola CRUD untuk tabel `user`.
 */
public class PenggunaPengelola {

    private final Connection cn;

    public PenggunaPengelola() {
        this.cn = Koneksi.getKoneksi();
    }

    public Pengguna cariPenggunaByUsername(String username) {
        Pengguna pr = null;

        for (Pengguna p : daftarPengguna) {   // asumsinya ini list user
            if (p.getNamaPengguna().equalsIgnoreCase(username)) {
                pr = p;
            }
        }
        return pr;
    }

    // <editor-fold defaultstate="collapsed" desc="CREATE">
    /**
     * Simpan pengguna baru (password di-MD5 di SQL).
     */
    public void simpan(Pengguna p) throws SQLException {
        String sql = "INSERT INTO user (userName, userEmail, userPassword, userFullName, userStatus) "
                + "VALUES (?, ?, MD5(?), ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getNamaPengguna());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getKataSandi());
            ps.setString(4, p.getNamaLengkap());
            ps.setInt(5, p.getStatus());
            ps.executeUpdate();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="UPDATE">
    /**
     * Ubah profil (tanpa ganti password).
     */
    public void ubah(Pengguna p) throws SQLException {
        String sql = "UPDATE user SET userEmail=?, userFullName=?, userStatus=? WHERE userName=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getEmail());
            ps.setString(2, p.getNamaLengkap());
            ps.setInt(3, p.getStatus());
            ps.setString(4, p.getNamaPengguna());
            ps.executeUpdate();
        }
    }

    /**
     * Ganti password.
     */
    public void ubahKataSandi(String namaPengguna, String kataSandiBaru) throws SQLException {
        String sql = "UPDATE user SET userPassword=MD5(?) WHERE userName=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, kataSandiBaru);
            ps.setString(2, namaPengguna);
            ps.executeUpdate();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DELETE">
    public void hapus(String namaPengguna) throws SQLException {
        String sql = "DELETE FROM user WHERE userName=?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, namaPengguna);
            ps.executeUpdate();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="READ">
    public List<Pengguna> cariSemua() throws SQLException {
        String sql = "SELECT userName, userEmail, userFullName, userStatus FROM user";
        List<Pengguna> hasil = new ArrayList<>();
        try (Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Pengguna p = new Pengguna();
                p.setNamaPengguna(rs.getString("userName"));
                p.setEmail(rs.getString("userEmail"));
                p.setNamaLengkap(rs.getString("userFullName"));
                p.setStatus(rs.getInt("userStatus"));
                hasil.add(p);
            }
        }
        return hasil;
    }

    /**
     * Validasi login aktif.
     */
    public boolean validasiLogin(String namaPengguna, String kataSandi) throws SQLException {
        String sql = "SELECT 1 FROM user WHERE userName=? AND userPassword=MD5(?) AND userStatus=1";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, namaPengguna);
            ps.setString(2, kataSandi);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    // </editor-fold>
}
