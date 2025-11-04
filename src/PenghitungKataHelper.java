
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PenghitungKataHelper {

    public static int hitungKata(String teks) {
        if (teks == null || teks.trim().isEmpty()) return 0;
        String[] kata = teks.trim().split("\\s+");
        return kata.length;
    }

    public static int hitungKarakter(String teks) {
        if (teks == null) return 0;
        return teks.length();
    }

    public static int hitungKalimat(String teks) {
        if (teks == null || teks.trim().isEmpty()) return 0;
        String[] kalimat = teks.trim().split("[.!?\\n]+");
        
        int count = 0;
        for (String k : kalimat) {
            if (!k.trim().isEmpty()) count++;
        }
        return count;
    }

    public static int hitungParagraf(String teks) {
        if (teks == null || teks.trim().isEmpty()) return 0;
        String[] paragraf = teks.trim().split("\\n+");
        return paragraf.length;
    }

    public static int cariKata(String teks, String kataCari) {
        if (teks == null || teks.isEmpty() || kataCari == null || kataCari.isEmpty()) {
            return 0;
        }

        String lowerText = teks.toLowerCase();
        String lowerCari = kataCari.toLowerCase();

        int count = 0, index = 0;
        while ((index = lowerText.indexOf(lowerCari, index)) != -1) {
            count++;
            index += lowerCari.length();
        }
        return count;
    }

    public static boolean simpanKeFile(String isi, File fileTujuan) {
        try {
            Files.write(Paths.get(fileTujuan.getAbsolutePath()), isi.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

