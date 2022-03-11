package repositories;

import models.GroceryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryItemDAOImpl implements GroceryItemDAO{
    @Override
    public List<GroceryItem> getAllItemsGivenListId(Integer listId) {
        List<GroceryItem> items = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, listId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                items.add(new GroceryItem(
                        rs.getInt(1),
                        rs.getSting(2),
                        rs.getInt(3),
                        rs.getBoolean(4));
            }


        }catch (SQLException sqle){

        }
        return null;
    }

    @Override
    public void markItemInCart(Integer itemId) {
        try{
            Connection conn = DriverManager,getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt()
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void createItemForList(GroceryItem item) {

    }

    @Override
    public void deleteItemFromList(Integer itemId) {

    }
}
