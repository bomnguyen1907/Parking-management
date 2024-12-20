import java.time.LocalDate;
import java.time.LocalDateTime;

public class Xe {
    private String bienSo;
    private String loaiXe;
    private String chuXe;
    private boolean trongBai;
    private LocalDateTime thoiGianDangKi;
    private int viTriDo;

    public Xe(String bienSo, String loaiXe, String chuXe) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.chuXe = chuXe;
        this.trongBai = true;
        this.thoiGianDangKi = LocalDateTime.now();
        this.viTriDo = -1;
    }

    public void capNhatTrangThai(boolean trongBai, int viTriDo) {
        this.trongBai = trongBai;
        this.viTriDo = viTriDo;
    }

    public String getBienSo() {return bienSo;}
    public String getLoaiXe() {return loaiXe;}
    public String getChuXe() {return chuXe;}
    public boolean isTrongBai() {return trongBai;}
    public LocalDateTime getThoiGianDangKi() {return thoiGianDangKi;}
    public int getViTriDo() {return viTriDo;}
    public void setViTriDo(int viTriDo) {this.viTriDo = viTriDo;}

    @Override
    public String toString() {
        String trangThai = trongBai ? "Trong bai" : "Ngoai bai";
        String viTri = viTriDo != -1 ? String.valueOf(viTriDo) : "Chua co";

        return String.format("Xe{bien so='%s', loai xe='%s', chu xe='%s', " + "trang thai='%s', vi tri do='%s', thoi gian dang ki='%s'}",
                            bienSo, loaiXe, chuXe, trangThai, viTri, thoiGianDangKi.toString());
    }
}