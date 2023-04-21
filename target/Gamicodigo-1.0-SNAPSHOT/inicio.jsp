<%-- 
    Document   : inicio
    Created on : 20 abr 2023, 13:24:53
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("usuario")==null){
    response.sendRedirect("index.html");
    }

%>


<html>
    <head>
        <title>JSP Page</title>
        <link href="rsc/styleWelcome.css" rel="stylesheet"/>
    </head>
    <body>
        <nav class="navbar">
            <div class="navbar-container">
                <div class="perfil">AVATAR</div>
                <div class="titulo">Principios de Algoritmos</div>
                <div class="logout">
                    <form action="ControladorLogout" method="post">
                        <input type="submit"/>
                    </form>
                </div>
            </div>
        </nav>
        <main>
            <div class="temas">
                <div class="card">
                    1. Conceptos <br/> Basicos
                </div>
                <div class="card">
                    2. Historia de<br/> la algoritmia
                </div>
                <div class="card">
                    3. Algoritmos<br/> Presentes en la <br/>vida
                </div>
                <div class="card">
                    4. Seudocódigo
                </div>
                <div class="card">
                    5. Etapas en el <br/>desarrollo de un <br/>algoritmo
                </div>
                <div class="card">
                    6. Estructura<br/> Secuencial
                </div>
                <div class="card">
                    7. Estructura<br/> Condicional
                </div>
                <div class="card">
                    8. Si-entonces
                </div>
                <div class="card">
                    9. Si-Entonces - sino
                </div>
                <div class="card">
                    10. Según
                </div>
                <div class="card">
                    11. Estructura <br/>condicional anidada
                </div>
                <div class="card">
                    12. Estructuras<br/> Repetitivas
                </div>
                <div class="card">
                    13. Estructura <br/>Repetir - hasta que
                </div>
                <div class="card">
                    14. Estructura <br/>Para
                </div>
            </div>
        </main>
    </body>
</html>
