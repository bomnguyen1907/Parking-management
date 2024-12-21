import java.util.Scanner;

public class HeThongQuanLyBaiXe {
    private static QuanLyNguoiDung quanLyNguoiDung;
    private static QuanLyXe quanLyXe;
    private static Scanner scanner;

    public static void main(String[] args) {
        quanLyNguoiDung = new QuanLyNguoiDung();
        quanLyXe = new QuanLyXe();
        scanner = new Scanner(System.in);

        System.out.println("==== HE THONG QUAN LY BAI XE ====");
        boolean tiepTuc = true;

        while (tiepTuc) {
            hienThiMenuChinh();
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch(luaChon) {
                case 1:
                    dangNhap();
                    break;
                case 2: 
                    System.out.println("Cam on ban da su dung he thong!");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        scanner.close();
    }

    private static void hienThiMenuChinh() {
        System.out.println("\n----- MENU CHINH -----");
        System.out.println("1. Dang nhap");
        System.out.println("2. Thoat");
        System.out.println("Nhap lua chon cua ban: ");
    }

    private static void dangNhap() {
        System.out.print("Ten dang nhap: ");
        String tenDangNhap = scanner.nextLine();
        System.out.print("Mat khau: ");
        String matKhau = scanner.nextLine();

        NguoiDung nguoiDung = quanLyNguoiDung.dangNhap(tenDangNhap, matKhau);
        if(nguoiDung != null) {
            System.out.println("Dang nhap thanh cong! Xin chao " + nguoiDung.getHoTen());
            if(nguoiDung.getVaiTro().equals("Bao ve")) {
                menuBaoVe(nguoiDung);
            } else {
                menuCuDan(nguoiDung);
            }
        } else {
            System.out.println("Dang nhap that bai! Vui long kiem tra thong tin.");
        }
    }

    private static void menuBaoVe(NguoiDung baoVe) {
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n----- MENU BAO VE -----");
            System.out.println("1. Kiem tra xe ra/vao");
            System.out.println("2. Tinh phi gui xe");
            System.out.println("3. Xem danh sach xe");
            System.out.println("4. Cap nhat gia gui xe");
            System.out.println("5. Xem lich su ra/vao");
            System.out.println("6. Xem bao cao thong ke");
            System.out.println("7. Dang xuat");
            System.out.println("Nhap lua chon cua ban: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    kiemTraXeRaVao();
                    break;
                case 2:
                    tinhPhiGuiXe();
                    break;
                case 3:
                    quanLyXe.xemDanhSachXe();
                case 4:
                    capNhatGiaGuiXe();
                    break;
                case 5:
                    quanLyXe.xemLichSuGuiXe();
                    break;
                case 6:
                    xemBaoCaoThongKe();
                    break;
                case 7:
                    tiepTuc = false;
                    System.out.println("Da dang xuat.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void menuCuDan(NguoiDung cuDan) {
        boolean tiepTuc = true;
        while (tiepTuc) {
            System.out.println("\n----- MENU CU DAN -----");
            System.out.println("1. Dang ky xe");
            System.out.println("2. Xem danh sach xe cua ban");
            System.out.println("3. Xem lich su gui xe");
            System.out.println("4. Cap nhat thong tin ca nhan");
            System.out.println("5. Dang xuat");
            System.out.println("Nhap lua chon cua ban: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    dangKyXe(cuDan.getTenDangNhap());
                    break;
                case 2:
                    quanLyXe.xemDanhSachXeCuDan(cuDan.getTenDangNhap());
                    break;
                case 3:
                    quanLyXe.xemLichSuGuiXeCuDan(cuDan.getTenDangNhap());
                    break;
                case 4:
                    capNhatThongTinCaNhan(cuDan);
                    break;
                case 5:
                    tiepTuc = false;
                    System.out.println("Da dang xuat.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void kiemTraXeRaVao() {
        System.out.print("Nhap bien so xe: ");
        String bienSo = scanner.nextLine();
        System.out.print("Xe vao hay ra? (vao/ra): ");
        String trangThai = scanner.nextLine().toLowerCase();

        if (trangThai.equals("vao")) {
            System.out.print("Nhap vi tri do: ");
            int viTriDo = scanner.nextInt();
            quanLyXe.capNhatTrangThaiXe(bienSo, true, viTriDo);
        } else if (trangThai.equals("ra")) {
            quanLyXe.capNhatTrangThaiXe(bienSo, false, -1);
        } else {
            System.out.println("Trang thai khong hop le!");
        }
    }

    private static void tinhPhiGuiXe() {
        System.out.print("Nhap bien so xe: ");
        String bienSo = scanner.nextLine();
        double phi = quanLyXe.tinhPhiGuiXe(bienSo);
        System.out.printf("Phi gui xe: %.2f VND\n", phi);
    }

    private static void capNhatGiaGuiXe() {
        System.out.print("Nhap gia gui xe moi (VND/gio): ");
        double giaGuiXeMoi = scanner.nextDouble();
        quanLyXe.capNhatGiaGuiXe(giaGuiXeMoi);
    }

    private static void xemBaoCaoThongKe() {
        System.out.println("\n----- BAO CAO THONG KE -----");
        System.out.println("1. Bao cao ngay");
        System.out.println("2. Bao cao tuan");
        System.out.println("3. Bao cao thang");
        System.out.println("Chon loai bao cao: ");

        int luaChon = scanner.nextInt();
        String loaiBaoCao;
        switch (luaChon) {
            case 1:
                loaiBaoCao = "Ngay";
                break;
            case 2:
                loaiBaoCao = "Tuan";
                break;
            case 3:
                loaiBaoCao = "Thang";
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }
        quanLyXe.xemBaoCaoDoanhThu(loaiBaoCao);
    }

    private static void dangKyXe(String chuXe) {
        System.out.print("Nhap bien so xe: ");
        String bienSo = scanner.nextLine();
        System.out.print("Nhap loai xe (O to/Xe may): ");
        String loaiXe = scanner.nextLine();

        Xe xeMoi = new Xe(bienSo, loaiXe, chuXe);
        quanLyXe.themXe(xeMoi);
    }

    private static void capNhatThongTinCaNhan(NguoiDung nguoiDung) {
        System.out.println("\n----- CAP NHAT THONG TIN CA NHAN -----");
        System.out.print("Ho ten moi: ");
        String hoTen = scanner.nextLine();
        System.out.print("So dien thoai moi: ");
        String soDienThoai = scanner.nextLine();
        System.out.print("Email moi: ");
        String email = scanner.nextLine();
        System.out.print("CCCD moi: ");
        String canCuoc = scanner.nextLine();

        quanLyNguoiDung.capNhatThongTinNguoiDung(hoTen, hoTen, soDienThoai, email, canCuoc);
    }
}
