<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>La Mia Playlist</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<h1 class="mb-4">Le tue Playlist</h1>

<form action="createPlaylist" method="post" class="d-flex mb-4">
    <input type="text" name="playlistName" class="form-control me-2" placeholder="Nome playlist" required>
    <button type="submit" class="btn btn-primary">Crea Playlist</button>
</form>

<ul class="list-group">
    <%
        String[] playlists = (String[]) request.getAttribute("playlists");
        if (playlists != null) {
            for (String pl : playlists) {
                String name = pl.replace(".txt", "");
    %>
    <li class="list-group-item d-flex justify-content-between align-items-center">
        <a href="viewPlaylist?playlist=<%=name%>"><%= name %></a>
        <form action="removePlaylist" method="post" style="display:inline;">
            <input type="hidden" name="playlist" value="<%=name%>">
            <button type="submit" class="btn btn-danger btn-sm">Elimina</button>
        </form>
    </li>
    <%
            }
        }
    %>
</ul>
</body>
</html>
