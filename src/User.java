import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String email;
    private String password;
    private Diary diary;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    private List<User> users = new ArrayList<>();

    public void register(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setDiary(new Diary());
        users.add(user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getNumberOfUsers(){
        return users.size();
    }

    public User findUserByEmail(String email) {
        for (User user:users) {
            if (user.getEmail().equalsIgnoreCase(email))return user;
        }
       return null;
    }
    public void createDiaryContent(String title, String body, String email){
        findUserByEmail(email).getDiary().createContent(title,body);
    }
    public User login(String email, String password){
//        boolean verify = false;
//        if (findUserByEmail(email) == null)verify = false;
//        else if (!Objects.equals(findUserByEmail(email).getPassword(), password))verify = false;
//        else verify = true;
//        return verify;
        if (findUserByEmail(email) == null){
            System.out.println("No user found");
            return null;
        }
        else if (findUserByEmail(email).getPassword()!= password)return null;
        else return findUserByEmail(email);
    }
    public List<DiaryContent> findContentByDate(String date, String email){
        return findUserByEmail(email).getDiary().findByDate(date);
    }
}
