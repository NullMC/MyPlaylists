package com.servlet.myplaylists;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File folder = new File(PLAYLIST_FOLDER);
        String[] playlists = folder.list((dir, name) -> name.endsWith(".txt"));

        request.setAttribute("playlists", playlists);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}