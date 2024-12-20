import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class QuanLyThoiGianGuiXe {
    private HashMap<String, ThoiGianGuiXe> danhSachGuiXe;
    private ArrayList<ThoiGianGuiXe> LichSuGuiXe;

    public QuanLyThoiGianGuiXe() {
        this.danhSachGuiXe = new HashMap<>();
        this.LichSuGuiXe = new ArrayList<>();
    }

    public void batDauGuiXe(String bienSo) {
        ThoiGianGuiXe thoiGianGuiXe = new ThoiGianGuiXe(bienSo);
        danhSachGuiXe.put(bienSo, thoiGianGuiXe);
        System.out.println("Bat dau tinh gio cho xe " + bienSo);
    }

    public double ketThucGuiXe(String bienSo, double giaGuiXe) {
        ThoiGianGuiXe thoiGianGuiXe = danhSachGuiXe.get(bienSo);
        if (thoiGianGuiXe != null) {
            thoiGianGuiXe.ketThucGuiXe();
            double phiGuiXe = thoiGianGuiXe.tinhPhiGuiXe(giaGuiXe);

            LichSuGuiXe.add(thoiGianGuiXe);
            danhSachGuiXe.remove(bienSo);

            return phiGuiXe;
        }
        return 0.0;
    }

    public void xemThoiGianGui(String bienSo) {
        ThoiGianGuiXe thoiGianGuiXe = danhSachGuiXe.get(bienSo);
        if (thoiGianGuiXe != null) {
            thoiGianGuiXe.hienThiThongTinGui();
        } else {
            System.out.println("Khong tim thay thong tin gui xe cho bien so " + bienSo);
        }
    }

    public String tinhThoiGianGui(String bienSo) {
        ThoiGianGuiXe thoiGianGuiXe = danhSachGuiXe.get(bienSo);
        if (thoiGianGuiXe != null) {
            LocalDateTime thoiGianVao = thoiGianGuiXe.getThoiGianVao();
            LocalDateTime hienTai = LocalDateTime.now();
            long soPhut = java.time.Duration.between(thoiGianVao, hienTai).toMinutes();
            long soGio = soPhut/60;
            soPhut = soPhut % 60;

            return String.format("%d gio %d phut", soGio, soPhut);
        }
        return "Khong tim thay thong tin";
    }
    
    public void hienThiDanhSachDangGui() {
        System.out.println("\n=== DANH SACH XE DANG GUI ===");
        if (danhSachGuiXe.isEmpty()) {
            System.out.println("Khong co xe nao dang gui.");
            return;
        }

        for (ThoiGianGuiXe thoiGianGuiXe : danhSachGuiXe.values()) {
            System.out.println("Thoi gian da gui: " + tinhThoiGianGui(thoiGianGuiXe.getBienSo()));  
            System.out.println("------------------------");
        }
    }

    public void hienThiLichSuGuiXe() {
        System.out.println("\n=== LICH SU GUI XE ===");
        if (LichSuGuiXe.isEmpty()) {
            System.out.println("Chua co lich su gui xe.");
            return;
        }

        for(ThoiGianGuiXe thoiGianGuiXe: LichSuGuiXe) {
            System.out.println(thoiGianGuiXe.toString());
            System.out.println("-----------------------");
        }
    }

    public HashMap<String, ThoiGianGuiXe> getDanhSachGuiXe() {
        return danhSachGuiXe;
    }

    public ArrayList<ThoiGianGuiXe> getLichSuGuiXe() {
        return LichSuGuiXe;
    }
}
