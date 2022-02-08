package com.revature.daos;

import com.revature.models.Receipt;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.utils.ConnectionUtil;

import java.sql.*;

public class ReimbursementDaoImp implements ReimbursementDao {

    @Override
    public boolean createRequest(Reimbursement r, User u){
        String sql = "insert into project1.reimbursements (amount, submitted, description, author, statusid, typeid) values (?,?,?,?,?,?)";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setDouble(1, r.getAmount());
            ps.setDate(2, r.getSubmitted());
            ps.setString(3, r.getDescription());
            ps.setInt(4, u.getId());
            ps.setInt(5, r.getStatusId());
            ps.setInt(6, r.getTypeId());


            int rowsAffected = ps.executeUpdate();
            if(rowsAffected==1){return true;}
        }
        catch (SQLException e){
            e.printStackTrace();;
        }

        return false;
    }

    @Override
    public Reimbursement viewRequest(int id){
        String sql = "SELECT * FROM project1.reimbursements where id = ?";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Reimbursement r = new Reimbursement();


                r.setId(id);
                r.setAmount(rs.getDouble("amount"));
                r.setSubmitted(rs.getDate("submitted"));
                r.setResolved(rs.getDate("resolved"));
                r.setDescription(rs.getString("description"));
                r.setAuthor(rs.getInt("author"));
                r.setResolver(rs.getInt("resolver"));
                r.setStatusId(rs.getInt("statusid"));
                r.setTypeId(rs.getInt("typeid"));

                return r;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRequest(Reimbursement r, User u){
        String sql = "update project1.reimbursements set resolved = ? , resolver = ?, statusid = ? where id = ? ";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setDate(1, r.getResolved());
            ps.setInt(2, u.getId());
            ps.setInt(3, r.getStatusId());
            ps.setInt(4, r.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected==1){return true;}

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteRequest(int id) {
        String sql = "delete from project1.reimbursements where id = ?";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected==0){
                return false;
            }

            return true;

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
