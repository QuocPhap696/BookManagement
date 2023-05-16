package Views;

import Model.Role;
import Model.User;
import Utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class LoginUser {
    public User Login(){
        Scanner scanner = new Scanner(System.in);
        boolean checkNumber= false;
        System.out.println("════════ Vui lòng đăng nhập để sử dụng ════════");
        nochange();
        System.out.println("════════    Tên đăng nhập    ════════");
        String username = scanner.nextLine();
        System.out.println("════════   Mật khẩu   ════════");
        String password = scanner.nextLine();
        if (username.equals("0")) {
            checkNumber = true;
            Menu menu = new Menu();
            menu.chon();
        }
        Role role = confirm(username,password);
        return new User(username,password,role);
    }

    private Role confirm(String username, String password){
        try {
            List<String> lines = CSVUtils.read("data/user.csv");
            for (String line : lines) {
                String[] fields = line.split(",");
                if (fields.length == 3 && fields[0].equals(username)&& fields[1].equals(password)){
                    return Role.fromValue(fields[2]);
                }
            }
            throw new IllegalArgumentException("════════ Tên đăng nhập hoặc mật khẩu sai ════════");
        }catch (IllegalArgumentException e){
            throw e;
        } catch (Exception e){
            throw new RuntimeException("════════ Sai đường dẫn đến file CSV ════════");
        }
    }
    public void nochange(){
        System.out.print("Nhấn 0 để quay trở lại");
    }
}
