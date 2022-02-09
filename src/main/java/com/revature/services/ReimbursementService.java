package com.revature.services;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImp;
import com.revature.models.Reimbursement;
import com.revature.models.User;

import java.util.List;

public class ReimbursementService {
    ReimbursementDao rd = new ReimbursementDaoImp();

    public boolean createRequest(Reimbursement r, User u){
        return rd.createRequest(r,u);
    }
    public Reimbursement getRequest(int id){
        return rd.getRequest(id);
    }
    public boolean updateRequest(Reimbursement r, User u){
        return rd.updateRequest(r,u);
    }
    public boolean deleteRequest(int id){
        return rd.deleteRequest(id);
    }
    public List<Reimbursement> getAllRequests(){
        return rd.getAllRequests();
    }
}
