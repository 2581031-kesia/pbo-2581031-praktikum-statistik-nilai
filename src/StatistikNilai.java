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

        }}
}