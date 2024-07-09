package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserProviderDTO;
import service.serviceImp.ServiceProvidersImp;

import java.io.IOException;

@WebServlet("/providers")
public class UserProviderServ extends HttpServlet {
    public ServiceProvidersImp servProvider  =  new ServiceProvidersImp();
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("providers_res", servProvider.getAllUserProviders());
        System.out.println(servProvider.getAllUserProviders());
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserProviderDTO user = new UserProviderDTO();
        user.setName(req.getParameter("name"));
        user.setRut(req.getParameter("rut"));
        user.setAddress(req.getParameter("address"));
        user.setMail(req.getParameter("mail"));
        user.setPhoneNumber(req.getParameter("phoneNumber"));
        user.setContact(req.getParameter("contact"));
        user.setContactNumber(req.getParameter("contacNumber"));
        Boolean resp = servProvider.insertUserProvider(user);

        if(!resp){
            req.setAttribute("respNewUser","El Usuario no se pudo crear");
        }

        req.setAttribute("providers_res", servProvider.getAllUserProviders());
        req.getRequestDispatcher("index.jsp").forward(req,res);
    }
}
