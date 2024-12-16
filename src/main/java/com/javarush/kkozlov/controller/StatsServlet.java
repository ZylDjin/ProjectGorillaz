package com.javarush.kkozlov.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import util.Stats;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Stats stats = Stats.getInstance();
        req.setAttribute("stats", stats);
        req.getRequestDispatcher("/WEB-INF/views/stats.jsp").forward(req, resp);
    }
}
