<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Home - Life Game by TSI Agile Group</title>
            <link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
            <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
            <link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">   
        </head>
        <body>
            <form>
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

                                                poner aquí el contenido

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
            </form>
        </body>
    </html>
</f:view>
