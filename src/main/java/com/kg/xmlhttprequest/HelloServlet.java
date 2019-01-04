package com.kg.xmlhttprequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * HelloServlet
 */
@WebServlet("/json")
public class HelloServlet extends HttpServlet {

    // ArrayList<Object> list;
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = "SELECT * from books";
        try {
            System.out.println("json called");
            ArrayList<Object> list = MysqlConnect.getDbCon().resultSetToArrayList(query);
            System.out.println(list);
            String employeeJsonString = this.gson.toJson(list);

            System.out.println("list" + employeeJsonString);
            req.setAttribute("list1", employeeJsonString);
            // RequestDispatcher view=req.getRequestDispatcher("index.html");
            // view.forward(req,resp);
            PrintWriter out = resp.getWriter();
            out.print("hello" + employeeJsonString);

            // JSONArray lst = MysqlConnect.getDbCon().query(query);
            // req.setAttribute("list1", list);
            // RequestDispatcher view = req.getRequestDispatcher("list.jsp");
            // view.forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}