package com.revature.daos;

import com.revature.models.Receipt;
import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementDaoImp implements ReimbursementDao {

    @Override
    public boolean createRequest(Reimbursement r){
        String sql = "insert into project1.reimbursements (amount, submitted, resolved, description) values (?,?,?,?)";

        try(Connection con = ConnectionUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){

            ps.setDouble(1, r.getAmount());
            ps.setDate(2, r.getSubmitted());
            ps.setDate(3, r.getResolved());
            ps.setString(4, r.getDescription());
            //ps.setObject(5, r.getReceipt());
            //ps.setInt(6, r.getAuthor());
            //ps.setInt(7, r.getResolver());
            //ps.setInt(8, r.getStatusId());
            //ps.setInt(9, r.getTypeId());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected==1){return true;}
        }
        catch (SQLException e){
            e.printStackTrace();;
        }

        return false;
    }

    @Override
    public void viewRequest(){

    }

    @Override
    public void addRequest(){

    }

    @Override
    public void approveRequest(){

    }

    @Override
    public void denyRequest(){

    }
}
