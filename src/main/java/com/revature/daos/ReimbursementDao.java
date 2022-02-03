package com.revature.daos;

public interface ReimbursementDao {
    public boolean createRequest();
    public void viewRequest();
    public void addRequest();
    public void approveRequest();
    public void denyRequest();
    //might need this later
    //public void filterRequest();
}
