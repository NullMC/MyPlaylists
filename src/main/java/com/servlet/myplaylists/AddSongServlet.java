package com.servlet.myplaylists;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "AddSongServlet", value = "/addSong")
public class AddSongServlet extends HttpServlet {
    private static final String PLAYLIST_FOLDER = "C:\\Users\\Francesco\\OneDrive\\Desktop\\Scuola\\tempFile";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playlist = request.getParameter("playlist");
        String titolo = request.getParameter("titolo");
        String artista = request.getParameter("artista");
        String genere = request.getParameter("genere");

        File playlistFile = new File(PLAYLIST_FOLDER + playlist + ".txt");
        if (!playlistFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Playlist non trovata");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(playlistFile, true))) {
            writer.write(titolo + ";" + artista + ";" + genere);
            writer.newLine();
        }

        response.sendRedirect("viewPlaylist?playlist=" + playlist);
    }
}
