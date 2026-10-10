import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StatistikNilai {

    //pembacaan do-while sama seperti minggu lalu
    static final int SELESAI = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //nilai disimpan di Arraylist<integer> tidak langsung dijumlahkan
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik " + SELESAI + " kalau sudah selesai.");

        int nilai;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = scanner.nextInt();

            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println(" Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        // ini mencetak pesan, bukan error
        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukkan.");
            scanner.close();
            return;
        }

        // tertinggi dan terendah dicari dengan loop sendiri (bukan Collections.max / Collections.min).
        // Keduanya dimulai dari nilai PERTAMA di daftar (daftar.get(0)), bukan dari angka
        // tetap seperti 0 atau 100. Alasannya: nilai pertama pasti anggota daftar, jadi
        // pembanding awalnya selalu sah. Kalau tertinggi dimulai dari 0 atau terendah dari
        // 100, hasilnya baru benar karena kebetulan batas nilai 0-100; dengan nilai pertama, logikanya benar untuk rentang berapa pun.
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        int total = 0;
        for (int i = 0; i < daftar.size(); i++) {
            int n = daftar.get(i);
            total += n;
            if (n > tertinggi) {
                tertinggi = n;
            }
            if (n < terendah) {
                terendah = n;
            }
        }

        // memakai double supaya pembagian tidak terpotong
        double rataRata = (double) total / daftar.size();

        int diAtasRataRata = 0;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i) > rataRata) {
                diAtasRataRata++;
            }
        }

        int[] jumlahGrade = new int [5];
        for (int i = 0; i < daftar.size(); i++) {
            int n = daftar.get(i);
            if (n >= 90) {
                jumlahGrade[0]++;
            } else if (n >= 80) {
                jumlahGrade[1]++;
            } else if (n >= 70) {
                jumlahGrade[2]++;
            }  else if (n >= 60) {
                jumlahGrade[3]++;
            }else {
                jumlahGrade[4]++;
            }
        }
        String[] namaGrade = {"A", "B", "C", "D", "E"};

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());
        System.out.println("Rata-rata       : " + String.format("%.2f", rataRata));
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        System.out.println("Di atas rata2   : " + diAtasRataRata + " orang");

        // Distribusi dicetak dengan loop, bukan lima baris println
        System.out.print("Distribusi      :");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(" " + namaGrade[i] + "=" + jumlahGrade[i]);
        }
        System.out.println();

        System.out.println("Terurut         : " + terurut);
        // Bukti daftar asli tidak ikut terurut
        System.out.println("Urutan asli     : " + daftar);

        scanner.close();

    }
}
