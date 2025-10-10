package aplikasiperhitunganhari;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HariHelper {
    
    // Formatter untuk tanggal dalam Bahasa Indonesia (Variasi 1)
    private final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("id", "ID"));

    /**
     * Menghitung Jumlah Hari dalam Bulan tertentu pada Tahun tertentu.
     * Secara otomatis menangani tahun kabisat (Leap Year).
     * @param tahun Tahun (misalnya 2025)
     * @param bulanIndex Nomor Bulan (1 = Januari, 12 = Desember)
     * @return Jumlah hari (int)
     */
    public int hitungJumlahHari(int tahun, int bulanIndex) {
        // LocalDate.lengthOfMonth() secara otomatis menangani Tahun Kabisat
        LocalDate date = LocalDate.of(tahun, bulanIndex, 1);
        return date.lengthOfMonth(); 
    }
    
    /**
     * Mendapatkan tanggal dan hari pertama dalam bulan tersebut (Variasi 1).
     * @param tahun Tahun
     * @param bulanIndex Nomor Bulan
     * @return String format "Hari, Tgl Bulan Tahun"
     */
    public String getHariPertama(int tahun, int bulanIndex) {
        LocalDate date = LocalDate.of(tahun, bulanIndex, 1);
        return date.format(formatter);
    }
    
    /**
     * Mendapatkan tanggal dan hari terakhir dalam bulan tersebut (Variasi 1).
     * @param tahun Tahun
     * @param bulanIndex Nomor Bulan
     * @return String format "Hari, Tgl Bulan Tahun"
     */
    public String getHariTerakhir(int tahun, int bulanIndex) {
        int jumlahHari = hitungJumlahHari(tahun, bulanIndex);
        LocalDate date = LocalDate.of(tahun, bulanIndex, jumlahHari);
        return date.format(formatter);
    }
    
    /**
     * Menghitung Selisih Hari antara Dua Tanggal (Variasi 2).
     * @param tanggalA Tanggal pertama
     * @param tanggalB Tanggal kedua
     * @return Jumlah selisih hari (long)
     */
    public long hitungSelisihHari(LocalDate tanggalA, LocalDate tanggalB) {
        // Menggunakan ChronoUnit.DAYS.between() yang mengembalikan nilai long
        return ChronoUnit.DAYS.between(tanggalA, tanggalB); 
    }
}