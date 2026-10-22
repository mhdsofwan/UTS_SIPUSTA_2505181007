import layanan.*;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;

public class Main {

    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();
        
        katalog.tambah(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", 1, false));
        katalog.tambah(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", 2, true));
        katalog.tambah(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", true, "C-01", 1));
        katalog.tambah(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", false, "C-02", 1));
        katalog.tambah(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambah(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        katalog.cetakStatus();
        
        System.out.println("\n=== LAYAK PINJAM ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.getDaftar().forEach(k ->
                System.out.println((k.layakDipinjam() ? "[Layak]  " : "[Tidak]  ") + k.getJudul()));

        System.out.println("\n=== JUDUL SAJA ===");
        katalog.urut((a, b) -> a.getJudul().compareToIgnoreCase(b.getJudul()));
        katalog.getDaftar().forEach(k -> System.out.println(k.getJudul()));

    }
}
