package tampilan;

import pengelola.PenggunaPengelola;

public class TestKoneksi {
        public static void main(String[] args) throws Exception {
        PenggunaPengelola pg = new PenggunaPengelola();
        System.out.println("Login admin: " + pg.validasiLogin("admin","admin123")); // harus true
    }
}
