<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Playlist</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

<h1>Playlist: <%= request.getAttribute("playlist") %></h1>

<table class="table table-striped mt-4">
    <thead>
    <tr>
        <th>Titolo</th>
        <th>Artista</th>
        <th>Genere</th>
        <th>Azioni</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<String[]> songs = (List<String[]>) request.getAttribute("songs");
        String playlist = (String) request.getAttribute("playlist");
        if (songs != null) {
            for (String[] song : songs) {
    %>
    <tr>
        <td><%= song[0] %></td>
        <td><%= song[1] %></td>
        <td><%= song[2] %></td>
        <td>
            <form action="removeSong" method="post" style="display:inline;">
                <input type="hidden" name="playlist" value="<%= playlist %>">
                <input type="hidden" name="titolo" value="<%= song[0] %>">
                <button type="submit" class="btn btn-danger btn-sm">Elimina</button>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<hr>

<h2>Aggiungi Nuova Canzone</h2>
<form action="addSong" method="post" class="mt-3">
    <input type="hidden" name="playlist" value="<%= playlist %>">
    <div class="mb-3">
        <input type="text" name="titolo" class="form-control" placeholder="Titolo" required>
    </div>
    <div class="mb-3">
        <input type="text" name="artista" class="form-control" placeholder="Artista" required>
    </div>
    <div class="mb-3">
        <input type="text" name="genere" class="form-control" placeholder="Genere" required>
    </div>
    <button type="submit" class="btn btn-success">Aggiungi Brano</button>
</form>

</body>
</html>
