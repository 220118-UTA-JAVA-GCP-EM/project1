package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import io.javalin.http.Context;

import java.sql.Date;
import java.util.List;

public class ReimbursementController {

    ReimbursementService rs = new ReimbursementService();

    public void handleGetAllRequests(Context ctx){
        List<Reimbursement> r = rs.getAllRequests();
        ctx.json(r);
    }

    public void handleCreateRequest(Context ctx){
        Reimbursement r = ctx.bodyAsClass(Reimbursement.class);
        //String.getSubmitted();

        User u = ctx.bodyAsClass(User.class);
        boolean success = rs.createRequest(r,u);

        if (success){
            ctx.status(201);
        }else{
            ctx.status(400);
        }

    }

    public void handleDeleteRequest(Context ctx){
        String idPara = ctx.pathParam("id");
        int id = Integer.parseInt(idPara);
        boolean success = rs.deleteRequest(id);

        if (success){
            ctx.status(200);
        }else{
            ctx.status(400);
        }

    }

    public void handleGetRequestById(Context ctx){
        String idPara = ctx.pathParam("id");
        int id = Integer.parseInt(idPara);
        Reimbursement r = rs.getRequest(id);
        ctx.json(r);
    }

    public void handleUpdateRequest(Context ctx){
        Reimbursement r = ctx.bodyAsClass(Reimbursement.class);
        User u = ctx.bodyAsClass(User.class);
        boolean success = rs.updateRequest(r, u);

        if (success){
            ctx.status(200);
        }else{
            ctx.status(400);
        }

    }
}
