package agan;
public class AgenPintar {
    private String lingkungan[][];
    private String kotoran[] = {"debu", "pasir", "rambut"};
    boolean bersih;
    AgenPintar(int location) {
        lingkungan = new String[location][3];
    }
    public void setKondisi(int i, String nama, String location, String barang) {
        lingkungan[i - 1][0] = nama;
        lingkungan[i - 1][1] = location;
        lingkungan[i - 1][2] = barang;
    }
    public void vacumm(int i, String name, String location, String barangs) {
        String[] barang = barangs.split(", ");
        if (!bersih) {
            for (int j = 0; j < barang.length; j++) {
                for (int k = 0; k < kotoran.length; k++) {
                    if (barang[j].equalsIgnoreCase(kotoran[k])) {
                        System.out.println("----Bersih-bersih " + kotoran[k] + "----");
                        barang[j] = null;
                        bersih = false;
                        break;
                    }
                }
            }
            System.out.println("Simpan :");
            for (int j = 0; j < barang.length; j++) {
                if (barang[j] != null) {
                    System.out.print("| "+barang[j] + " | \n");
                }
            }
            System.out.println("");
            bersih = true;
            vacumm(i, name, location, barangs);
        } else if ("kiri".equals(location.toLowerCase())) {
            if ("lokasi 1".equalsIgnoreCase(name)) {
                System.out.println("geser kanan-->");
            } else {
                System.out.println("geser atas");
            }
        } else if ("tengah".equals(location.toLowerCase())) {
            if ("lokasi 2".equalsIgnoreCase(name)) {
                System.out.println("geser kanan-->");
            } else {
                System.out.println("<--geser kiri");
            }
        } else if ("kanan".equals(location.toLowerCase())) {
            if ("lokasi 3".equalsIgnoreCase(name)) {
                System.out.println("geser bawah");
            } else {
                System.out.println("<--geser kiri");
            }
        }
    }
    public void bersihkan() {
        for (int i = 0; i < lingkungan.length; i++) {
            bersih = false;
            System.out.println("Lokasi : " + lingkungan[i][0]);
            vacumm(i, lingkungan[i][0], lingkungan[i][1], lingkungan[i][2]);
            System.out.println(); 
        }
        System.out.println("SEMUA SUDAH BERSIH");
    }
    public static void main(String[] args) {
        AgenPintar a = new AgenPintar(6);
        a.setKondisi(1, "Lokasi 1", "kiri", "mainan, debu, kertas, rambut");
        a.setKondisi(2, "Lokasi 2", "tengah", "debu, pasir, gelas");
        a.setKondisi(3, "Lokasi 3", "kanan", "smartphone, radio");
        a.setKondisi(4, "Lokasi 4", "kanan", "rambut, uang, sisir, debu");
        a.setKondisi(5, "Lokasi 5", "tengah", "debu, rambut, pasir");
        a.setKondisi(6, "Lokasi 6", "kiri", "charger, laptop, tv, pasir");
        a.bersihkan();
    }
}