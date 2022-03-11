package repositories;

import models.GroceryList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryListDAOimpl implements GroceryListDAO
{

    @Override
    public List<GroceryList> getAllListGivenUserId(Integer userId) {
        List<GroceryList> lists = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new GroceryList(rs.getInt(1), rs.getString(2), rs.getInt(3 )));
            }catch()
        }
    }

    @Override
    public void createList(GroceryList groceryList) {
        try{
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "";
            PreparedStatement ps =
            ps.setString(1, groceryList.getName());


        }catch(SQLException sqle){

        }
    }

    @Override
    public void deleteList(Integer listId) {

    }
}
