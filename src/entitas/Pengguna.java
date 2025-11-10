package entitas;

/**
 * Entitas untuk menyimpan data pengguna.
 */
public class Pengguna {

    private String namaPengguna;
    private String email;
    private String kataSandi;
    private String namaLengkap;
    private int status;

    // Constructor kosong
    public Pengguna() {
    }

    // Constructor dengan parameter
    public Pengguna(String namaPengguna, String email, String kataSandi, String namaLengkap, int status) {
        this.namaPengguna = namaPengguna;
        this.email = email;
        this.kataSandi = kataSandi;
        this.namaLengkap = namaLengkap;
        this.status = status;
    }

    // Getter dan Setter
    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
