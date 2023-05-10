package Views;

import Model.Role;
import Model.User;
import Utils.CSVUtils;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class LoginView {
    public User Login(){
    Scanner scanner = new Scanner(System.in);
        System.out.println("*** Vui lòng đăng nhập để sử dụng ***");
        System.out.println("Tên đăng nhập");
        String username = scanner.nextLine();
        System.out.println("Mật khẩu");
        String password = scanner.nextLine();
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
            throw new IllegalArgumentException("*** Tên đăng nhập hoặc mật khẩu sai ***");
        }catch (IllegalArgumentException e){
            throw e;
        } catch (Exception e){
            throw new RuntimeException("Sai đường dẫn đến file CSV");
        }
    }
}
