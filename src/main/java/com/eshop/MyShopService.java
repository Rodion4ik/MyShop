package com.eshop;

import com.eshop.model.Busket;
import com.eshop.model.BusketItem;
import com.eshop.model.Product;
import com.eshop.model.ProductCategory;
import com.eshop.model.User;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyShopService {

    public ProductCategory getCategoryWithProducts(int id) throws SQLException {

        Connection c = getConnection();
        ProductCategory result = null;
        String s = "SELECT category_name FROM myshop.product_category WHERE id=?";
        PreparedStatement p = c.prepareStatement(s);

        p.setInt(1, id);
        try {
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                result = new ProductCategory(id, rs.getString("category_name"), getProducts(id));
            }
        } finally {
            p.close();
            c.close();
        }
        return result;
    }

    //razobratsya i dodelat tablicy s tovarami i v ney ssylky na tovar
    public List<ProductCategory> getProductCategories() throws SQLException {
        List<ProductCategory> list = new ArrayList<>();
        Connection c = getConnection();
        String s = "SELECT id,category_name FROM myshop.product_category order by category_name";
        System.out.println("c=" + c);
        PreparedStatement p = c.prepareStatement(s);
        try {
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                list.add(new ProductCategory(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            p.close();
            c.close();
        }
        return list;

    }

    public List<Product> getProducts(int par) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection c = getConnection();
        String s = "SELECT id,product_name,cost,vendor_id,description"
                + " FROM myshop.product WHERE category_id=? order by product_name";

        System.out.println("c=" + c);
        PreparedStatement p = c.prepareStatement(s);
        p.setInt(1, par);
        try {
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("product_name"),
                        rs.getDouble("cost"), rs.getInt("vendor_id"), rs.getString("description"), par));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            p.close();
            c.close();
        }
        return list;

    }

    public Product getProduct(int id) throws SQLException {
        Product prod = null;
        Connection c = getConnection();
        String s = "SELECT product_name,cost,vendor_id,description"
                + " FROM myshop.product WHERE id=?";

        System.out.println("c=" + c);
        PreparedStatement p = c.prepareStatement(s);
        p.setInt(1, id);
        try {
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                prod = new Product(id, rs.getString("product_name"), rs.getDouble("cost"),
                        rs.getInt("vendor_id"), rs.getString("description"), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            p.close();
            c.close();
        }
        if(prod!=null){
            prod.setPhotosIds(getPhotosIdByProductId(id));
        }
        return prod;

    }

    public void addToBusket(int productId, int userId, int quantity) throws SQLException {
        String s = "INSERT into myshop.basket  (user_id,product_id,quantity)  VALUES (?,?,?)";
        Connection c = getConnection();
        PreparedStatement p = c.prepareStatement(s);
        p.setInt(1, userId);
        p.setInt(2, productId);
        p.setInt(3, quantity);
        try {
            p.executeUpdate();

        } catch (Exception ex) {
        } finally {

            p.close();
            c.close();
        }
    }
 public void addToBusketNoName(int productId, String sessionId, int quantity) throws SQLException {
        String s = "INSERT into myshop.basket  (session_id,product_id,quantity)  VALUES (?,?,?)";
        Connection c = getConnection();
        PreparedStatement p = c.prepareStatement(s);
        p.setString(1, sessionId);
        p.setInt(2, productId);
        p.setInt(3, quantity);
        try {
            p.executeUpdate();

        } catch (Exception ex) {
        } finally {

            p.close();
            c.close();
        }
    }
    
    public Busket getBusket(int userId) throws SQLException {
        //  User user = new User(userId,null,null);
        List<BusketItem> bi = new ArrayList();
        Busket busket = new Busket(bi, new User(userId));
        String s = "select b.id,product_id,quantity,user_id, product_name,cost \n"
                + "from \n"
                + "myshop.basket b,\n"
                + "myshop.product p \n"
                + "where user_id=? and p.id = b.product_id ";

        System.out.println("getBusket.q=" + s);
        //join  zapros  v obe tabalicy
        Connection c = getConnection();
        PreparedStatement p = c.prepareStatement(s);
        p.setInt(1, userId);

        try {
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                bi.add(new BusketItem(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("cost")), rs.getInt("quantity"), rs.getInt("id")));
                //bi.add(new BusketItem(rs.getInt("product_id"), rs.getInt("quantity"), userId));
            }

        } catch (Exception ex) {
        } finally {
            p.close();
            c.close();
        }
        return busket;
    }

    public void deleteOrder(int user_id) throws SQLException {
        Connection c = getConnection();
        String s = "delete from myshop.basket where user_id=?";
        PreparedStatement p = c.prepareStatement(s);
        try {
            p.setInt(1, user_id);
            p.executeUpdate();
        } catch (Exception ex) {
        } finally {
            p.close();
            c.close();
        }
    }

    public void deleteOrderItem(int id) throws SQLException {
        Connection c = getConnection();
        String s = "delete from myshop.basket where id=?";
        PreparedStatement p = c.prepareStatement(s);
        try {
            p.setInt(1, id);
            p.executeUpdate();
        } catch (Exception ex) {
        } finally {
            p.close();
            c.close();
        }

    }

    public void createPhoto(byte[] photo) throws SQLException {
        Connection c = getConnection();
        String s = "insert into myshop.photo (photo) values (?)";
        PreparedStatement p = c.prepareStatement(s);

        try {
            p.setBinaryStream(1, new ByteArrayInputStream(photo));
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getPhotosIdByProductId(int id) throws SQLException {
        Connection c = getConnection();
        String s = "SELECT  photo_id FROM myshop.product_photo WHERE product_id=?";
        PreparedStatement p = c.prepareStatement(s);
        p.setInt(1, id);
        ArrayList<Integer> idPhotos = new ArrayList<>();
        try {
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                idPhotos.add(rs.getInt("photo_id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return idPhotos;
    }

    public byte[] getPhoto(int id) throws SQLException {
        Connection c = getConnection();
        String s = "select photo from myshop.photo  where id=? ";
        PreparedStatement p = c.prepareStatement(s);
        byte[] photo = null;
        p.setInt(1, id);
        try {

            ResultSet rs = p.executeQuery();
            // p.setBinaryStream(1, new ByteArrayInputStream(id));
            if (rs.next()) {
                photo = rs.getBytes("photo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photo;
    }

    //public List<>;
    //dalee - metod0 - vyborki iz bazy productov zadannoi ID categorii
    Connection getConnection() throws SQLException {
        String string = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
        Connection conn = DriverManager.getConnection(string);
        return conn;
    }
}
