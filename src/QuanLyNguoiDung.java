import java.util.ArrayList;

public class QuanLyNguoiDung {
    private ArrayList<NguoiDung> danhSachNguoiDung;

    public QuanLyNguoiDung() {
        this.danhSachNguoiDung = new ArrayList<>();

        danhSachNguoiDung.add(new NguoiDung("baove1", "123456", "Bao ve", 
                            "Nguyen Van A", "0123456789", "baove@gmail.com", "0020203030"));
        danhSachNguoiDung.add(new NguoiDung("cudan1", "123456", "Cu dan",
                            "Tran Hoang Anh", "0987654321", "cudan1@amail.com", "001201123457"));
    }
    
    public NguoiDung dangNhap(String tenDangNhap, String matKhau) {
        for(NguoiDung nguoiDung : danhSachNguoiDung) {
            if (nguoiDung.getTenDangNhap().equals(tenDangNhap) && 
                nguoiDung.getMatKhau().equals(matKhau)) {
                return nguoiDung;
            }
        }
        return null;
    }

    public boolean kiemTraQuyen(String tenDangNhap, String vaiTro) {
        for(NguoiDung nguoiDung : danhSachNguoiDung) {
            if(nguoiDung.getTenDangNhap().equals(tenDangNhap)) {
                return nguoiDung.getVaiTro().equals(vaiTro);
            }
        }
        return false;
    }

    public boolean themNguoiDung(NguoiDung nguoiDungMoi) {
        for (NguoiDung nguoiDung : danhSachNguoiDung) {
            if(nguoiDung.getTenDangNhap().equals(nguoiDungMoi.getTenDangNhap())) {
                System.out.println("Ten dang nhap da ton tai!");
                return false;
            }
        }
        danhSachNguoiDung.add(nguoiDungMoi);
        System.out.println("Them nguoi dung thanh cong!");
        return true;
    }

    public NguoiDung timNguoiDung(String tenDangNhap) {
        for(NguoiDung nguoiDung : danhSachNguoiDung) {
            if(nguoiDung.getTenDangNhap().equals(tenDangNhap)) {
                return nguoiDung;
            }
        }
        return null;
    }

    public boolean capNhatThongTinNguoiDung(String tenDangNhap, String hoTen, String soDienThoai, String email, String canCuoc) {
        NguoiDung nguoiDung = timNguoiDung(tenDangNhap);
        if(nguoiDung != null) {
            nguoiDung.capNhatThongTinCaNhan(hoTen, soDienThoai, email, canCuoc);
            return true;
        }
        return false;
    }

    public void hienThiDanhSachNguoiDung() {
        System.out.println("\n=== DANH SACH NGUOI DUNG ===");
        for(NguoiDung nguoiDung : danhSachNguoiDung) {
            System.out.println(nguoiDung.toString());
        }
    }

    public void hienThiDanhSachTheoVaiTro(String vaiTro) {
        System.out.println("\n=== DANH SACH " + vaiTro.toUpperCase() + " ===");
        for(NguoiDung nguoiDung : danhSachNguoiDung) {
            if(nguoiDung.getVaiTro().equals(vaiTro)) {
                System.out.println(nguoiDung.toString());
            }
        }
    }

    public ArrayList<NguoiDung> getDanhSachNguoiDung() {
        return danhSachNguoiDung;
    }
}
