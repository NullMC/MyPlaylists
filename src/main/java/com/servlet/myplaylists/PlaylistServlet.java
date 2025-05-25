package com.servlet.myplaylists;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "PlaylistServlet", value = "/viewPlaylist")
public class PlaylistServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile\\";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlist");
        File playlistFile = new File(PLAYLIST_FOLDER + playlist + ".txt");

        List<String[]> songs = new ArrayList<>();

        if (playlistFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(playlistFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 3) {
                        songs.add(parts);
                    }
                }
            }
        }

        request.setAttribute("songs", songs);
        request.setAttribute("playlist", playlist);
        request.getRequestDispatcher("viewPlaylist.jsp").forward(request, response);
    }
}
