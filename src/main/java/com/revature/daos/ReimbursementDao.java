package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDao {
    public boolean createRequest(Reimbursement r, User u);
    public Reimbursement viewRequest(int id);
    public boolean updateRequest(Reimbursement r, User u);
    //might need this later
    //public void filterRequest();
}
