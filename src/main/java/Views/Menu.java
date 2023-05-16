package Views;

import Model.Book;
import Model.Role;
import Model.User;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static BookView bookView = new BookView();
    static Scanner scanner = new Scanner(System.in);

    private static User user1 = null;
//    private static User1 user2 = null;
    private static boolean isFinished = false;

    public static void  boss(){

        boolean isLoggedIn = checkLogin();
        if (!isLoggedIn){
            login();
            return;
        }
        boolean isFinishep = false;
        menuBoss();
        int number = 0;
        while (!isFinishep){
            try {
                System.out.println("════ Chọn chức năng ════");
                number =Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("════ Nhập ko đúng, vui lòng nhập lại ════");
                number = 0;
                continue;
            }
            switch (number){
                case 1:
                    bookView.showBookBoss();
                    break;
                case 2:
                    bookView.addBookByBoss();
                    break;
                case 3:
                    bookView.updateBook();
                    break;
                case 4:
                    bookView.findBookByNameBoss();
                    break;
                case 5:
                    bookView.deleteById();
                    break;
                case 6:
                    chon();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("════ Vui lòng nhập từ 1 đến 7 ════");
                    chon();
                    break;

            }
        }
    }

    public static User login(){
        LoginView loginView = new LoginView();
        boolean isLoggedIn = false;
        User user = null;
        while (!isLoggedIn){
            try {
                user = loginView.Login();
                isLoggedIn = true;
                user1 = user;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("════ Lỗi, vui lòng nhập lại ════");
                return null;
            }
        }
        return user;
    }
    public static boolean checkLogin(){
        if (user1 == null){
            return false;
        } return true;
    }

    public static void guest(){
        boolean isLoggedIn = checkLogin();
        if (!checkLogin()){
            login();
        }
        int number = 0;
        boolean checkAction = false;
        do {
           menuGuest();
            try {
                number = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("════════ Nhập sai, vui lòng nhập lại ════════");
                number = 0;
                continue;
            }
            switch (number) {
                case 1:
                    bookView.showBookGuest();
                    checkAction = true;
                    break;
                case 2:
                    bookView.findBookByNameGuest();
                    checkAction = true;
                    break;
                case 3:
                    bookView.borrowBook();
                    checkAction = true;
                    break;
                case 4:
                    bookView.returnBook();
                    checkAction = true;
                    break;
                case 5:
                    bookView.showborrowBook();
                    checkAction= true;
                    break;
                case 6:
                    chon();
                    checkAction = true;
                    break;
                case 7:
                    exit();
                    checkAction =true;
                    break;

            }

        }while (!checkAction);
    }

    public static void exit(){
        System.out.println("╔═══════════════════════╗");
        System.out.println("║                       ║");
        System.out.println("║       Thank you !     ║");
        System.out.println("║      See you later !  ║");
        System.out.println("║                       ║");
        System.out.println("╚═══════════════════════╝");
        System.exit(0);
    }

    public static void chon(){
        int number = 0;
        boolean action = false;
        do {
            menuMain();
            try {
                System.out.println("═══ Chọn chức năng ═══");
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("═══ Nhập sai, vui lòng nhập lại ═══");
                number = 0;
                continue;
            }
            switch (number){
                case 1:
                    boss();
                    break;
                case 2:
                    guest();
                    action=true;
                    break;
                case 3:
                    exit();
                    action=true;
                    break;
                default:
                    System.out.println("═══ Không hợp lệ, vui lòng nhập lại ═══");
                    chon();
                    break;
            }
        }while (!action);
    }

    public static void menuMain(){
        System.out.println("╔═════════════  Menu   ══════════╗");
        System.out.println("║                                ║");
        System.out.println("║          1.    Chủ             ║");
        System.out.println("║          2.    Khách           ║");
        System.out.println("║          3.    Thoát           ║");
        System.out.println("║                                ║");
        System.out.println("╚════════════════════════════════╝");
    }

    public static void menuBoss(){
        System.out.println("╔══════════════════  Chủ  ═══════════════╗");
        System.out.println("║           1.Hiển thị danh sách         ║");
        System.out.println("║           2.Thêm sách mới              ║");
        System.out.println("║           3.Sửa thông tin sách         ║");
        System.out.println("║           4.Tìm kiếm sách theo tên     ║");
        System.out.println("║           5.Xoá sách theo ID           ║");
        System.out.println("║           6.Quay lại                   ║");
        System.out.println("║           7.Thoát                      ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    public static void menuGuest(){
        System.out.println("╔══════════════════  Khách ═══════════════╗");
        System.out.println("║           1.Hiển thị danh sách          ║");
        System.out.println("║           2.Tìm kiếm theo tên           ║");
        System.out.println("║           3.Mượn sách                   ║");
        System.out.println("║           4.Trả sách                    ║");
        System.out.println("║           5.Hiển thị sách mượn          ║");
        System.out.println("║           6.Quay lại                    ║");
        System.out.println("║           7.Thoát                       ║");
        System.out.println("╚═════════════════════════════════════════╝");
    }
}
