public class NguoiDung {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String canCuoc;

    public NguoiDung(String tenDangNhap, String matKhau, String vaiTro,
            String hoTen, String soDienThoai, String email, String canCuoc) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.canCuoc = canCuoc;
    }

    public NguoiDung(String tenDangNhap, String matKhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public void xemThongTinCaNhan() {
        System.out.println("=== THONG TIN CA NHAN ===");
        System.out.println("Ten dang nhap: " + tenDangNhap);
        System.out.println("Vai tro: " + vaiTro);
        System.out.println("Ho ten: " + (hoTen != null ? hoTen : "Chua cap nhat"));
        System.out.println("So dien thoai: " + (soDienThoai != null ? soDienThoai : "Chua cap nhat"));
        System.out.println("Email: " + (email != null ? email : "Chua cap nhat"));
        System.out.println("CCCD: " + (canCuoc != null ? canCuoc : "Chua cap nhat"));
    }

    public void capNhatThongTinCaNhan(String hoTen, String soDienThoai, String email, String canCuoc) {
        if(hoTen != null && !hoTen.trim().isEmpty()) {
            this.hoTen = hoTen;
        }
        if(soDienThoai != null && !soDienThoai.trim().isEmpty()) {
            this.soDienThoai = soDienThoai;
        }
        if(email != null && !email.trim().isEmpty()) {
            this.email = email;
        }
        if(canCuoc != null && !canCuoc.trim().isEmpty()) {
            this.canCuoc = canCuoc;
        }
        System.out.println("Cap nhat thong tin thanh cong!");
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
        if(this.matKhau.equals(matKhauCu)) {
            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong!");
            return true;
        } else {
            System.out.println("Mat khau cu khong dung!");
            return false;
        }
    }

    public String getTenDangNhap() {return tenDangNhap;}
    public String getMatKhau() {return matKhau;}
    public String getVaiTro() {return vaiTro;}
    public String getHoTen() {return hoTen;}
    public String getSoDienThoai() {return soDienThoai;}
    public String getEmail() {return email;}
    public String getCanCuoc() {return canCuoc;}

    @Override 
    public String toString() {
        return "NguoiDung{" + "tenDangNhap='" + tenDangNhap + '\'' + ", vaiTro='" + vaiTro + '\'' + ", hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' + ", email='" + email + '\'' + ", canCuoc='" + canCuoc + '\'' + '}';
    }
}