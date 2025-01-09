package app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("Creando socket servidor");
                ServerSocket serverSocket = new ServerSocket();

                System.out.println("Realizando el bind");
                InetSocketAddress addr = new InetSocketAddress(6666);
                serverSocket.bind(addr);

                System.out.println("Aceptando conexiones");
                Socket newSocket = serverSocket.accept();
                System.out.println("Conexion recibida");

                InputStream is = newSocket.getInputStream();
                OutputStream os = newSocket.getOutputStream();
                byte[] mensaje = new byte[25];
                is.read(mensaje);
                System.out.println("Mensaje recibido: " + new String(mensaje));
                //Enviar mensaje al cliente
                os.write("Mensaje recibido".getBytes());
                System.out.println("Mensaje enviado");
                System.out.println("Cerrando el socket servidor");
                serverSocket.close();
                newSocket.close();
                System.out.println("Terminado");

            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }

    }
}
