package edu.eci.arep.app;

import static spark.Spark.*;

public class Collatz {
    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("/", (req,res) -> {
            res.redirect("index.html");
            return null;
        });
        get("/collatzsequence", (req, res) -> {
            int numero = Integer.parseInt(req.queryParams("value"));
            return obtenerSecuencia(numero);
        });
    }

  private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5000;
  }

  private static String obtenerSecuencia(int n){
    if(n % 2 == 0){
        return n + " -> " + obtenerSecuencia(n/2);
    }else{
        if(n == 1){
            return "1";
        }else{
            return n + " -> " + obtenerSecuencia(3*n + 1);
        }
    }
  }
  
}
