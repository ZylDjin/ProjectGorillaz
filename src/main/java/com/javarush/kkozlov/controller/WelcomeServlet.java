package com.javarush.kkozlov.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;


public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
    }

}
