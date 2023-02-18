import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<User> users = new ArrayList<>();
       try {
           while (true){
               System.out.println("Insert 1 to add user");
               System.out.println("Insert 2 to list user");
               System.out.println("Insert 3 to delete user");
               System.out.println("Insert 4 to exit user");
               int a = Integer.parseInt(rd.readLine());
               if(a==1){
                   System.out.println("Inser id");
                   int id = Integer.parseInt(rd.readLine());
                   System.out.println("Inser login");
                   String login = rd.readLine();
                   System.out.println("Inser password");
                   String pass = rd.readLine();
                   users.add(new User(id,login,pass));
                   saveUsers(users);
               } else if (a==2) {
                   System.out.println(getUserList());
               } else if (a==3) {
                   System.out.println("Insert index user for delete");
                   int index = Integer.parseInt(rd.readLine());
                   users.remove(index);
                   saveUsers(users);
                   System.out.println(getUserList());
               }
               else if (a==4){
                   break;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }

    }
    public static ArrayList<User> getUserList(){
        ArrayList<User> users = null;
        BufferedReader read = null;

        try {
            read = new BufferedReader(new FileReader("memory.txt"));
            String text = "";
            users = new ArrayList<>();

            while ((text = read.readLine())!=null){
                String arr [] = text.split(" ");
                users.add(new User(Integer.parseInt(arr[0]),arr[1],arr[2]));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static void saveUsers(ArrayList<User> users){
        BufferedWriter wr = null;

        try {
            wr = new BufferedWriter(new FileWriter("memory.txt"));

            for (User u:users){
                wr.write(u.toString() + "\n");
            }
            wr.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

 class User {
    private int id;
    private String login;
    private String password;

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " " + login + " " + password;
    }
}
