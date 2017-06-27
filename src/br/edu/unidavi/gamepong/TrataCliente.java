package br.edu.unidavi.gamepong;

import java.io.InputStream;
import java.util.Scanner;


public class TrataCliente implements Runnable {
 
   private int id;
   private InputStream cliente;
   private Servidor servidor;
 
   public TrataCliente(InputStream cliente, Servidor servidor) {
     this.cliente = cliente;
     this.servidor = servidor;
   }
 
   public void run() {
     // quando chegar uma msg, distribui pra todos
     Scanner s = new Scanner(this.cliente);
     while (s.hasNextLine()) {
         String msg = s.nextLine();
         System.out.println(msg);
         servidor.distribuiMensagem(msg);
     }
     s.close();
   } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 }