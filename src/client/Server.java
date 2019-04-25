package client;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

/**
 * The interface responsible for communicating client requests to the remote
 * database server
 */
class Server {

    static List<String> data = new ArrayList<>();
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static long timer = 0;

    public static List<String> getQuotes() {
        if (System.currentTimeMillis() - timer < 2000)
            return data;
        request(new String[] { "get" });
        return data;
    }

    public static Boolean addQuote(String quote) {
        return request(new String[] {"add", quote});
    }

    public static Boolean editQuote(String targetQuote, String newQuote) {
        return request(new String[] { "edit", targetQuote, newQuote });
    }

    public static Boolean deleteQuote(String quote) {
        return request(new String[] { "delete", quote });
    }

    private static Boolean request(String...parameters) {
        
        if (!connect()) return false; // error
        
        // send request
        for (String p : parameters) 
            out.println(p);
        try {
            socket.shutdownOutput();
            timer = System.currentTimeMillis();
            return saveResponse();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static Boolean saveResponse() {

        ArrayList<String> response = new ArrayList<>();
        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null)
                response.add(inputLine);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        data = response.subList(response.indexOf("data") + 1, response.size());
        return response.get(1).equals("1") ? true : false;

    }

    private static boolean connect() {

        try {
            socket = new Socket("130.225.247.85", 65432);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}