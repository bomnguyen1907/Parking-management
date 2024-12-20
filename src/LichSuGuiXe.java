import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LichSuGuiXe {
    private String bienSo;
    private String trangThai;
    private LocalDateTime thoiGian;
    private int viTriDo;

    public LichSuGuiXe(String bienSo, String trangThai, int viTriDo) {
        this.bienSo = bienSo;
        this.trangThai = trangThai;
        this.thoiGian = LocalDateTime.now();
        this.viTriDo = viTriDo;
    }

    public void ghiNhanLichSu() {
        System.out.println("Da ghi nhan: Xe " + bienSo + " " + trangThai.toLowerCase() +
                            " bai tai vi tri " + viTriDo + " - Thoi gian: " + getThoiGianFormatted());          
    }

    public String getBienSo() {return bienSo;}
    public String getTrangThai() {return trangThai;}
    public LocalDateTime getThoiGian() {return thoiGian;}
    public int getViTriDo() {return viTriDo;}
    
    public String getThoiGianFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return thoiGian.format(formatter);
    }

    @Override
    public String toString() {
        return String.format("LichSuGuiXe{bien so='%s', trang thai='%s', " + "thoi gian='%s', vi tri do=%d}", bienSo, trangThai, getThoiGianFormatted(), viTriDo);
    }
}
