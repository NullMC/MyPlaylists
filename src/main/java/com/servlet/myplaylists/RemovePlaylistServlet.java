package com.servlet.myplaylists;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(name = "RemovePlaylistServlet", value = "/removePlaylist")
public class RemovePlaylistServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile\\";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlist");
        File playlistFile = new File(PLAYLIST_FOLDER + playlist + ".txt");

        if (playlistFile.exists()) {
            playlistFile.delete();
        }

        response.sendRedirect("home");
    }
}
