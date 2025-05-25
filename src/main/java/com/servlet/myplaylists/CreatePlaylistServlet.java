package com.servlet.myplaylists;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(name = "CreatePlaylistServlet", value = "/createPlaylist")
public class CreatePlaylistServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile\\";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlistName = request.getParameter("playlistName");

        if (playlistName == null || playlistName.trim().isEmpty()) {
            response.sendRedirect("home");
            return;
        }

        File newPlaylist = new File(PLAYLIST_FOLDER + playlistName + ".txt");
        if (!newPlaylist.exists()) {
            newPlaylist.createNewFile();
        }

        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("home");
    }
}
