package com.servlet.myplaylists;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name ="RemoveSongServlet", value ="/removeSong")
public class RemoveSongServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile\\";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlist");
        String titolo = request.getParameter("titolo");

        File playlistFile = new File(PLAYLIST_FOLDER + playlist + ".txt");
        if (!playlistFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Playlist non trovata");
            return;
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(playlistFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(titolo + ";")) {
                    lines.add(line);
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(playlistFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }

        response.sendRedirect("viewPlaylist?playlist=" + playlist);
    }
}