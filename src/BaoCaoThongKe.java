import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaoCaoThongKe {
    private int tongSoXe;
    private int soXeTrongBai;
    private double tongDoanhThu;
    private LocalDateTime thoiGianBaoCao;

    public BaoCaoThongKe(int tongSoXe, int soXeTrongBai, double tongDoanhThu) {
        this.tongSoXe = tongSoXe;
        this.soXeTrongBai = soXeTrongBai;
        this.tongDoanhThu = tongDoanhThu;
        this.thoiGianBaoCao = LocalDateTime.now();
    }

    public void taoBaoCaoNgay() {
        System.out.println("\n=== BAO CAO THONG KE NGAY " + thoiGianBaoCao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ===");
        hienThiThongKe();
    }

    public void taoBaoCaoTuan() {
        System.out.println("\n=== BAO CAO THONG KE TUAN " + thoiGianBaoCao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ===");
        hienThiThongKe();
    }

    public void taoBaoCaoThang() {
        System.out.println("\n=== BÁO CÁO THỐNG KÊ THÁNG " + thoiGianBaoCao.format(DateTimeFormatter.ofPattern("MM/yyyy")) + " ===");
        hienThiThongKe();
    }

    private void hienThiThongKe() {
        System.out.println("Tong so xe dang ky: " + tongSoXe);
        System.out.println("So xe dang trong bai: " + soXeTrongBai);
        System.out.println("So xe ngoai bai: " + (tongSoXe - soXeTrongBai));
        System.out.printf("Tong doanh thu: %.2f VND \n", tongDoanhThu);
        System.out.println("Thoi gian bao cao: " + thoiGianBaoCao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    @Override
    public String toString() {
        return String.format("BaoCaoThongKe{tong so xe=%d, xe trong bai=%d, xe ngoai bai=%d, " + "doanh thu=%.2f VND, thoi gian bao cao=%s}", 
                            tongSoXe, soXeTrongBai, (tongSoXe - soXeTrongBai), tongDoanhThu, thoiGianBaoCao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public int getTongSoXe() {
        return tongSoXe;
    }

    public int getSoXeTrongBai() {
        return soXeTrongBai;
    }

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }

    public LocalDateTime getThoiGianBaoCao() {
        return thoiGianBaoCao;
    }
}
