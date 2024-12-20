import java.util.ArrayList;

public class QuanLyXe {
    private ArrayList<Xe> danhSachXe;
    private ArrayList<LichSuGuiXe> lichSuGuiXe;
    private QuanLyThoiGianGuiXe quanLyThoiGian;
    private ArrayList<ViTriGuiXe> danhSachViTri;
    private double giaGuiXe;
    private double tongDoanhThu;

    public QuanLyXe() {
        this.danhSachXe = new ArrayList<>();
        this.lichSuGuiXe = new ArrayList<>();
        this.quanLyThoiGian = new QuanLyThoiGianGuiXe();
        this.danhSachViTri = new ArrayList<>();
        this.giaGuiXe = 5000.0;
        this.tongDoanhThu = 0.0;

        for (int i = 1; i <= 100; i++) {
            danhSachViTri.add(new ViTriGuiXe(i, "A" + (i / 10 + 1)));
        }
    }

    public boolean themXe(Xe xe) {
        for (Xe x : danhSachXe) {
            if (x.getBienSo().equals(xe.getBienSo())) {
                System.out.println("Bien so xe da ton tai!");
                return false;
            }
        }

        ViTriGuiXe viTriTrong = null;
        for (ViTriGuiXe viTri : danhSachViTri) {
            if (viTri.kiemTraTrong()) {
                viTriTrong = viTri;
                break;
            }
        }

        if (viTriTrong == null) {
            System.out.println("Bai xe da het cho trong!");
            return false;
        }

        xe.setViTriDo(viTriTrong.getMaViTri());
        viTriTrong.capNhatTrangThai(xe.getBienSo());
        danhSachXe.add(xe);

        LichSuGuiXe lichSu = new LichSuGuiXe(xe.getBienSo(), "Dang ky", xe.getViTriDo());
        lichSuGuiXe.add(lichSu);
        lichSu.ghiNhanLichSu();

        System.out.println("Them xe thanh cong!");
        return true;
    }

    public void capNhatTrangThaiXe(String bienSo, boolean trongBai, int viTriDo) {
        Xe xe = timXeTheoBienSo(bienSo);
        if (xe != null) {
            if (xe.getViTriDo() != -1) {
                for (ViTriGuiXe viTri : danhSachViTri) {
                    if (viTri.getMaViTri() == xe.getViTriDo()) {
                        viTri.capNhatTrangThai(null);
                        break;
                    }
                }
            }

            if (trongBai && viTriDo != -1) {
                for (ViTriGuiXe viTri : danhSachViTri) {
                    if (viTri.getMaViTri() == viTriDo && viTri.kiemTraTrong()) {
                        viTri.capNhatTrangThai(bienSo);
                        break;
                    }
                }
            }

            xe.capNhatTrangThai(trongBai, viTriDo);
            String trangThai = trongBai ? "Vào" : "Ra";
            LichSuGuiXe lichSu = new LichSuGuiXe(bienSo, trangThai, viTriDo);
            lichSuGuiXe.add(lichSu);
            lichSu.ghiNhanLichSu();

            if (trongBai) {
                quanLyThoiGian.batDauGuiXe(bienSo);
            } else {
                double phi = quanLyThoiGian.ketThucGuiXe(bienSo, giaGuiXe);
                tongDoanhThu += phi;
                System.out.printf("Phi gui xe: %.2f VND\n", phi);
            }
        } else {
            System.out.println("Khong tim thay xe!");
        }
    }

    public Xe timXeTheoBienSo(String bienSo) {
        for (Xe xe : danhSachXe) {
            if (xe.getBienSo().equals(bienSo)) {
                return xe;
            }
        }
        return null;
    }

    public double tinhPhiGuiXe(String bienSo) {
        return quanLyThoiGian.ketThucGuiXe(bienSo, giaGuiXe);
    }

    public void xemDanhSachXe() {
        System.out.println("\n=== DANH SACH XE ===");
        if (danhSachXe.isEmpty()) {
            System.out.println("Khong co xe nao trong danh sach.");
            return;
        }
        for (Xe xe : danhSachXe) {
            System.out.println(xe.toString());
        }
    }

    public void xemDanhSachXeCuDan(String tenCuDan) {
        System.out.println("\n=== DANH SACH XE CUA CU DAN " + tenCuDan + " ===");
        boolean coXe = false;
        for (Xe xe : danhSachXe) {
            if (xe.getChuXe().equals(tenCuDan)) {
                System.out.println(xe.toString());
                coXe = true;
            }
        }
        if (!coXe) {
            System.out.println("Cu dan chua dang ky xe nao.");
        }
    }

    public void xemLichSuGuiXe() {
        System.out.println("\n=== LICH SU GUI XE ===");
        if (lichSuGuiXe.isEmpty()) {
            System.out.println("Chua co lich su gui xe.");
            return;
        }
        for (LichSuGuiXe lichSu : lichSuGuiXe) {
            System.out.println(lichSu.toString());
        }
    }

    public void xemLichSuGuiXeCuDan(String tenCuDan) {
        System.out.println("\n=== LICH SU GUI XE CUA CU DAN " + tenCuDan + " ===");
        boolean coLichSu = false;
        for (LichSuGuiXe lichsu : lichSuGuiXe) {
            Xe xe = timXeTheoBienSo(lichsu.getBienSo());
            if (xe != null && xe.getChuXe().equals(tenCuDan)) {
                System.out.println(lichsu.toString());
                coLichSu = true;
            }
        }
        if (!coLichSu) {
            System.out.println("Chua co lich su gui xe.");
        }
    }

    public void capNhatGiaGuiXe(double giaGuiXeMoi) {
        if (giaGuiXeMoi > 0) {
            this.giaGuiXe = giaGuiXeMoi;
            System.out.printf("Da cap nhat gia gui xe: %.2f VND/gio\n", giaGuiXeMoi);
        } else {
            System.out.println("Gia gui xe khong hop le!");
        }
    }

    public void xemBaoCaoDoanhThu(String loaiBaoCao) {
        BaoCaoThongKe baoCao = new BaoCaoThongKe(
                danhSachXe.size(),
                (int) danhSachXe.stream().filter(Xe::isTrongBai).count(),
                tongDoanhThu);

        System.out.println("\n=== BAO CAO DOANH THU (" + loaiBaoCao + ") ===");
        System.out.println(baoCao.toString());
    }

    public ArrayList<Xe> getDanhSachXe() {
        return danhSachXe;
    }

    public ArrayList<LichSuGuiXe> getLichSuGuiXe() {
        return lichSuGuiXe;
    }

    public double getGiaGuiXe() {
        return giaGuiXe;
    }

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }
}
