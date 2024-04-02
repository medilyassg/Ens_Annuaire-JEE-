<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un étudiant</title>
</head>
<body>
    <h1>Ajouter un étudiant</h1>
    <form action="students/add" method="post">
        <label for="cne">CNE:</label>
        <input type="text" id="cne" name="cne" required><br><br>

        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" required><br><br>

        <label for="filiere">Filière:</label>
        <input type="text" id="filiere" name="filiere" required><br><br>

        <label for="departement">Département:</label>
        <input type="text" id="departement" name="departement" required><br><br>

        <label for="telephone">Téléphone:</label>
        <input type="text" id="telephone" name="telephone" required><br><br>

        <input type="submit" value="Ajouter">
    </form>
</body>
</html>
