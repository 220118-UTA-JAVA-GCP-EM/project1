package com.revature.daos;

import com.revature.models.LoggingSingleton;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao{

    LoggingSingleton logger = LoggingSingleton.getLogger();

    @Override
    public boolean createUser(User u) {
        String sql = "insert into project1.user (username,password,fname,lname,email) values (?,?,?,?,?)";



        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFname());
            ps.setString(4, u.getLname());
            ps.setString(5, u.getEmail());
            //ps.setInt(6, u.getRoleId().ordinal());


        }
        catch (SQLException e){
            e.printStackTrace();;
        }

        String sql2 = "insert into project1.user_roles (id, user_role) values (?,?)";
        try (Connection con2 = ConnectionUtil.getConnection();
        PreparedStatement ps2 = con2.prepareStatement(sql2);){


            ps2.setInt(1, u.getId());
            ps2.setInt(2, u.getRoleId().ordinal());

            int rowsAffected = ps2.executeUpdate();
            if(rowsAffected==1){return true;}

            }


        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(User u){
        String sql = "update project1.user set username = ? , password = ? , fname = ? , lname = ?, email = ?   where id = ? ";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getFname());
            ps.setString(4, u.getLname());
            ps.setString(5, u.getEmail());
            ps.setInt(6, u.getRoleId().ordinal());
            ps.setInt(7, u.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected==1){return true;}

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM project1.user ";

        try(Connection con = ConnectionUtil.getConnection();
        Statement s = con.createStatement();){

            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                User u = new User();


                int id = rs.getInt("id");
                u.setId(id);
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setFname(rs.getString("fname"));
                u.setLname(rs.getString("lname"));
                u.setEmail(rs.getString("email"));


                //gives the ENUMS a  numeric value
                UserRole[] roles = UserRole.values();

                int roleOrdinal = rs.getInt(("roleid"));
                u.setRoleId(roles[roleOrdinal]);

                users.add(u);
            }
        }
        catch (SQLException e) {
            logger.info("Caught SQL exception");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById() {
        return null;
    }

    @Override
    public User getUserByUsernameAndPassword() {
        return null;
    }
}
