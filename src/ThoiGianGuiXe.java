import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class ThoiGianGuiXe {
    private String bienSo;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRa;
    private double phiGuiXe;

    public ThoiGianGuiXe(String bienSo) {
        this.bienSo = bienSo;
        this.thoiGianVao = LocalDateTime.now();
        this.phiGuiXe = 0.0;
    }

    public double tinhPhiGuiXe(double giaGuiXe) {
        if(thoiGianRa == null) {
            thoiGianRa = LocalDateTime.now();
        }

        Duration thoiGianGui = Duration.between(thoiGianVao, thoiGianRa);
        long soGio = thoiGianGui.toMinutes()/60;
        if(thoiGianGui.toMinutes()%60>0) {
            soGio++;
        }

        this.phiGuiXe = soGio * giaGuiXe;
        return this.phiGuiXe;
    }

    public void ketThucGuiXe() {
        this.thoiGianRa = LocalDateTime.now();
    }

    public String getBienSo() {
        return bienSo;
    }

    public LocalDateTime getThoiGianVao() {
        return thoiGianVao;
    }

    public LocalDateTime getThoiGianRa() {
        return thoiGianRa;
    }

    public double getPhiGuiXe() {
        return phiGuiXe;
    }

    private String formatDateTime(LocalDateTime dateTime) {
        if(dateTime == null) return "Chua xac dinh";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    @Override 
    public String toString() {
        return String.format("ThoiGianGuiXe{bien so='%s', thoi gian vao='%s'," + "thoi gian ra='%s', phi gui xe=%.2f VND}",  
                            bienSo, formatDateTime(thoiGianVao), formatDateTime(thoiGianRa), phiGuiXe);
    }

    public void hienThiThongTinGui() {
        System.out.println("=== THONG TIN GUI XE ===");
        System.out.println(("Bien so: " + bienSo));
        System.out.println("Thoi gian vao: " + formatDateTime(thoiGianVao));
        System.out.println("Thoi gian ra: " + formatDateTime(thoiGianRa));
        System.out.printf("Phi gui xe: %.2f VND\n", phiGuiXe);

    }

}
