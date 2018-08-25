
import com.eshop.MailService;
import com.eshop.MyShopService;
import com.eshop.UserService;
import com.eshop.model.BusketItem;
import com.eshop.model.EMailMessage;
import com.eshop.model.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Samsung
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        MyShopService mshs = new MyShopService();
        mshs.getProductCategories();
        User user = new User("testuser");
        UserService us = new UserService();
        user = us.getUserInformation("testuser");
        System.out.println("parol " + user.getPassword());

        //        ArrayList<Integer> al = new ArrayList<>();
//        al.add(1);
//        UserService us = new UserService();
//        
//        us.addUser("Petya", "Batkovich", "vse horoho");
//        ArrayList<BusketItem> al2 = new ArrayList<BusketItem>();
//        al2 = (ArrayList<BusketItem>) mshs.getBusket(1);
//        for (int i = 0; i < al2.size(); i++) {
//            BusketItem bi2 = al2.get(i);
//            int kol = bi2.getNumber();
//            int prodId = bi2.getProductId();
//            int userId = bi2.getUserId();
//            System.out.println("kolichestvo tovara= " +kol+ " id producta= "+prodId+" id polzovatelya "+userId);
       try {
            byte[] photo = Files.readAllBytes(Paths.get("C:\\Users\\Samsung\\Desktop\\MyShop\\l4602.jpg"));
            mshs.createPhoto(photo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
     byte[] photo=   mshs.getPhoto(1);
     String s= photo.toString();
        System.out.println("s="+s);
        EMailMessage mail = new EMailMessage("rodion.vlasov@mail.ru", "xxx", "Vy uspeshno zaregistrirovany, proidite po ssylke", "rodion.vlasov@mail.ru", "temaPisma");
        try {
            MailService.sendMail(mail);
            System.out.println("Pismo otpravleno");
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
