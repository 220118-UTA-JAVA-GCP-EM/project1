package com.revature.daos;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
    public boolean createRequest(Reimbursement r);
    public void viewRequest();
    public void addRequest();
    public void approveRequest();
    public void denyRequest();
    //might need this later
    //public void filterRequest();
}
