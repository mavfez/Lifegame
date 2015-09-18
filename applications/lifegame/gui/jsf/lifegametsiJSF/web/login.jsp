<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <title>Home - Life Game by TSI Agile Group</title>
            <meta charset="utf-8">
            <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
            <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
            <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
            <link rel="stylesheet" href="css/login.css" type="text/css" media="screen">   
            <script src="js/login.js"></script>
        </head>
        <body>
            <div class="main-bg">
                <div class="bg">
                    <!--==============================header=================================-->
                    <header>
                        <div class="main">
                            <div class="wrapper">
                                <div class="fright">
                                    <div class="indent">
                                        <span class="redright">Welcome to the Life Game</span>
                                        <span class="whiteright">Let the game begin</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </header>

                    <!--==============================content================================-->
                    <section id="content">
                        <div class="main">
                            <div class="container_12">
                                <div class="container-bot">
                                    <div class="container-top">
                                        <div class="container">

                                            <form name="login" class="login">
                                                <p>
                                                    <label for="login">User:</label>
                                                    <input type="text" name="login" id="login" value="username">
                                                </p>

                                                <p>
                                                    <label for="password">Password:</label>
                                                    <input type="password" name="password" id="password" value="4815162342">
                                                </p>

                                                <p class="login-submit">
                                                    <button type="button" onclick="validate_login()" class="login-button">Login</button>
                                                </p>

                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                    <!--==============================footer=================================-->
                    <jsp:include page="WEB-INF/jspf/footer.jspf"/>
                </div>
            </div>
        </body>
    </html>
</f:view>
