import java.util.*;

class CanBo {
    protected String hoten;
    protected int namsinh;
    protected String gioitinh;
    protected String diachi;

    public CanBo(String hoten, int namsinh, String gioitinh, String diachi) {// khoi tao
        this.hoten = hoten;
        this.namsinh = namsinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void hienThiThongTin() {
        System.out.println("Ho ten: " + hoten);
        System.out.println("Nam sinh: " + namsinh);
        System.out.println("Gioi tinh: " + gioitinh);
        System.out.println("Dia chi: " + diachi);
    }
}

class CongNhan extends CanBo {
    private int capbac;

    public CongNhan(String hoten, int namsinh, String gioitinh, String diachi, int capbac) {
        super(hoten, namsinh, gioitinh, diachi);
        this.capbac = capbac;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Cap bac: " + capbac);
    }
}

class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu(String hoten, int namsinh, String gioitinh, String diachi, String nganhDaoTao) {
        super(hoten, namsinh, gioitinh, diachi);
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Nganh dao tao: " + nganhDaoTao);
    }
}

class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String hoten, int namsinh, String gioitinh, String diachi, String congViec) {
        super(hoten, namsinh, gioitinh, diachi);
        this.congViec = congViec;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Cong viec: " + congViec);
    }
}

class QLCB {
    private List<CanBo> ds = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void themCanBo() {
        System.out.println("Chon loai can bo (1: Cong nhan, 2: Ky su, 3: Nhan vien): ");
        int loai = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap ho ten: ");
        String hoten = sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        int namsinh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        String gioitinh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String diachi = sc.nextLine();

        if (loai == 1) {
            System.out.print("Nhap cap bac: ");
            int capbac = sc.nextInt();
            ds.add(new CongNhan(hoten, namsinh, gioitinh, diachi, capbac));
        } else if (loai == 2) {
            System.out.print("Nhap nganh dao tao: ");
            String nganhDaoTao = sc.nextLine();
            ds.add(new KySu(hoten, namsinh, gioitinh, diachi, nganhDaoTao));
        } else if (loai == 3) {
            System.out.print("Nhap cong viec: ");
            String congViec = sc.nextLine();
            ds.add(new NhanVien(hoten, namsinh, gioitinh, diachi, congViec));
        } else {
            System.out.println("Lua chon khong hop le!");
        }
    }

    public void timKiemTheoTen() {
        System.out.print("Nhap ten ban muon tim kiem: ");
        String ten = sc.nextLine();
        boolean timThay = false;

        for (CanBo cb : ds) {
            if (cb.getHoten().equalsIgnoreCase(ten)) {
                cb.hienThiThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay!");
        }
    }

    public void hienThiDanhSach() {
        for (CanBo cb : ds) {
            cb.hienThiThongTin();
            System.out.println("------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        QLCB qlcb = new QLCB();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nQuan ly can bo");
            System.out.println("1. Them can bo");
            System.out.println("2. Tim kiem theo ho ten");
            System.out.println("3. Hien thi danh sach can bo");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");
            int chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    qlcb.themCanBo();
                    break;
                case 2:
                    qlcb.timKiemTheoTen();
                    break;
                case 3:
                    qlcb.hienThiDanhSach();
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
