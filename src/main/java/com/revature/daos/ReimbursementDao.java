package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.User;

import java.util.List;

public interface ReimbursementDao {
    public boolean createRequest(Reimbursement r, User u);
    public Reimbursement getRequest(int id);
    public boolean updateRequest(Reimbursement r, User u);
    public boolean deleteRequest(int id);
    public List<Reimbursement> getAllRequests();
    //might need this later
    //public void filterRequest();
}
