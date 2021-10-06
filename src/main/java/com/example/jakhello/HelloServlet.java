package com.example.jakhello;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
// a travez de clases que extienden de httpservlet
//tiene un ciclo de vida
// init algo parecido a un metodo constructor

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class  HelloServlet extends HttpServlet {
    //private String message;

    //metodo constructor
    public void init() {
     //   message = "Hello World!";
    }

    // puedo hacer llamados por medio de una url y un puerto  utilizando diferentes metodos que vienen con el estandar http
    // pueden ser get, put, poust, y delete estos son los principlaes
    //get: traer informacion del servidor
    // el post: cuando quiero enviar informacion pero que esa informacion es nueva
    // el put: cuando quiero actualizar una informacion existenete
    // delete: para eliminar
  /* public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // puedo responder un json, un text por ahora un html ya que quiero que el navegador imprima de una vez
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //imprimo un log con los parametros que me acaban de llegar
        System.out.println("username: "+username);
        System.out.println("password: "+password);

        if(username.equals("aperezdi")&& password.equals("1234")){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Hello " + username + "</h1>");
            out.println("</body></html>");
        } else {
            response.sendError(401);
        }
    }

    /* si despues de que finalize ese servlet quiero desatruir una variable para liberar espacion en memoria,o para guardar un log en donde
   el usuario ya abandono la pagina  */
    public void destroy() {
    }
}

