import model.*;

/** Main sementara untuk menguji Soal 1 dan 2. */
public class Main {

    public static void main(String[] args) {
        // Lantai & rak majalah tidak ada di soal -> asumsi.
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", 1, false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", 2, true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "C-01", 1);
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "C-02", 1);
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        System.out.println("=== SOAL 1: hierarki kelas ===");
        Koleksi[] semua = {bk1, bk2, mj1, mj2, bd1, bd2};
        for (Koleksi k : semua) {
            System.out.println(k.deskripsi());
            System.out.println("   Layak dipinjam: " + (k.layakDipinjam() ? "Ya" : "Tidak"));
        }

        System.out.println("\n=== SOAL 2: interface Terarsip ===");
        // Hanya objek yang menerapkan Terarsip yang bisa masuk ke array ini.
        // Menambahkan bd1 (BerkasDigital) di sini akan gagal dikompilasi.
        Terarsip[] diRak = {bk1, bk2, mj1, mj2};
        for (Terarsip t : diRak) {
            System.out.println(t.ringkasanArsip());
        }
    }
}
