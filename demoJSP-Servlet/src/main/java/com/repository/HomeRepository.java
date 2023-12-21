package com.repository;

import com.entity.Cart;
import com.entity.CartItems;
import com.entity.Order;
import com.entity.OrderLine;
import com.entity.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeRepository {

    public List<OrderLine> getOrderList() {
        List<OrderLine> orderLines = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT * FROM orderline";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                OrderLine orderLine = new OrderLine();
                orderLine.setProduct_id(resultSet.getInt("product_id"));
                orderLine.setQuantity(resultSet.getInt("quantity"));
                orderLine.setOrder_id(resultSet.getInt("order_id"));
                orderLine.setTopping_ids(resultSet.getInt("topping_ids"));
                orderLines.add(orderLine);
            }

        } catch (Exception e) {
            System.out.println("bug");
        }
        return orderLines;
    }

    public OrderLine addToCart(Integer cart_id, String product_id, String quantity,
                               String size_id, String topping_ids) {
        OrderLine orderLine = new OrderLine();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "insert into cartline(cart_id,product_id, quantity,size_id,topping_ids)" +
                    " VALUES (?, ?, ?, ?, ?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, cart_id);
            stmt.setString(2, product_id);
            stmt.setString(3, quantity);
            stmt.setString(4, size_id);
            stmt.setString(5, topping_ids);
            stmt.executeUpdate();


        } catch (Exception e) {
            System.out.println("bug");
        }
        return orderLine;
    }

    public Integer selectCartId(Integer user_id) {
        Cart cart = new Cart();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "select cart.id from cart join user on cart.user_id = user.id where user.id = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, String.valueOf(user_id));
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                cart.setId(resultSet.getInt("id"));
            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return cart.getId();
    }

    public void addUserIdToCart(Integer user_id) {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "insert into cart (user_id) values (?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, user_id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
    }

    public Order addTotalPriceToCart(String totalPriceIntoCart, String user_id) {
        Order order = new Order();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "INSERT INTO orders (totalprice,user_id) values (?,?)";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, totalPriceIntoCart);
            stmt.setString(2, user_id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
        return order;
    }

    public List<Products> getProductList() {
        List<Products> products = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT * FROM products";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Products product = new Products();
                product.setID(resultSet.getInt("ID"));
                product.setName(resultSet.getString("NAME"));
                product.setPrice(resultSet.getInt("PRICE"));
                product.setImage(resultSet.getString("IMAGE"));
                products.add(product);
            }

        } catch (Exception e) {
            System.out.println("bug");
        }
        return products;
    }

    public void deleteCartlineList() throws SQLException {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "DELETE  FROM cartline;";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
    }

    public void addToOrderline() {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "INSERT INTO orderline (product_id, size_id, quantity, order_id, topping_ids)\n" +
                    "SELECT product_id, size_id, quantity, cart_id, topping_ids\n" +
                    "FROM cartline;";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
    }

    public List<CartItems> getCartLineList() {
        List<CartItems> cartItems = new ArrayList<>();
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "SELECT p.image, p.id as product_id, t.NAME as topping_name, u.username, ol.cart_id, \n" +
                    "\t\tp.NAME as product_name, s.name as size_name, ol.QUANTITY,\n" +
                    "\t\tp.PRICE, (ol.QUANTITY * p.PRICE) AS SUBTOTAL \n" +
                    "FROM cart o \n" +
                    "\tjoin cartline ol on o.ID = ol.cart_id \n" +
                    "\tJOIN products p on p.ID = ol.PRODUCT_ID \n" +
                    "    JOIN size s on s.ID = ol.size_id \n" +
                    "    JOIN user u on u.ID = o.user_id \n" +
                    "\tjoin topping t on t.topping_ids = ol.topping_ids;";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CartItems cartItem = new CartItems();
                cartItem.setProductName(resultSet.getString("product_name"));
                cartItem.setSize_name(resultSet.getString("size_name"));
                cartItem.setQuantity(resultSet.getInt("ol.QUANTITY"));
                cartItem.setPrice(resultSet.getInt("p.PRICE"));
                cartItem.setSubToTal(resultSet.getInt("SUBTOTAL"));
                cartItem.setCart_id(resultSet.getInt("Cart_id"));
                cartItem.setProduct_id(resultSet.getString("product_id"));
                cartItem.setTopping(resultSet.getString("topping_name"));
                cartItem.setImage(resultSet.getString("image"));
                cartItems.add(cartItem);

            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return cartItems;
    }

    public void updateQuantity(String product_id, String quantity) {
        try (Connection conn = ConnectionConfig.getConnection()) {
            PreparedStatement stmt;
            String query = "UPDATE cartline SET quantity = ? WHERE product_id = ?";
            assert conn != null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1, quantity);
            stmt.setString(2, product_id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("bug");
        }
    }
}
