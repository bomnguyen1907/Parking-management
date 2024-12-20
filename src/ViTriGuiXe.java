public class ViTriGuiXe {
    private int maViTri;
    private String khuVuc;
    private boolean daTrong;
    private String bienSoXe;

    public ViTriGuiXe(int maViTri, String khuVuc) {
        this.maViTri = maViTri;
        this.khuVuc = khuVuc;
        this.daTrong = true;
        this.bienSoXe = null;
    }

    public void capNhatTrangThai(String bienSoXe) {
        if(this.daTrong && bienSoXe != null) {
            this.daTrong = false;
            this.bienSoXe = bienSoXe;
            System.out.println("Xe " + bienSoXe + " da duoc do vao vi tri " + maViTri + " khu vuc " + khuVuc);
        } else if(this.daTrong && bienSoXe == null) {
            String bienSoCu = this.bienSoXe;
            this.daTrong = true;
            this.bienSoXe = null;
            System.out.println("Xe " + bienSoCu + " da roi khoi vi tri " + maViTri + " khu vuc " + khuVuc);
        }
    }

    public boolean kiemTraTrong() {
        return this.daTrong;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public boolean isDaTrong() {
        return daTrong;
    }

    @Override
    public String toString() {
        return String.format("Vi tri %d - Khu vuc %s - %s", maViTri, khuVuc, (daTrong ? "Con trong" : "Da co xe " + bienSoXe));
    }

    public void hienThiThongTinGui() {
        System.out.println("=== THONG TIN VI TRI DO XE ===");
        System.out.println("Ma vi tri: " + maViTri);
        System.out.println("Khu vuc: " + khuVuc);
        System.out.println("Trang thai: " + (daTrong ? "Con trong" : "Da co xe"));
        if(!daTrong) {
            System.out.println("Bien so xe dang do: " + bienSoXe);
        }
    }
}
