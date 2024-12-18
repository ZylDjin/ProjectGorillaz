package com.javarush.kkozlov.controller;


import com.javarush.kkozlov.util.Stats;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Stats stats = Stats.getInstance();
        req.setAttribute("stats", stats);
        req.getRequestDispatcher("/WEB-INF/views/stats.jsp").forward(req, resp);
    }
}
