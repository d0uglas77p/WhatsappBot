package whatsappbot.zapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ZapiService {

    @Value("${zapi.token}")
    private String token;

    @Value("${zapi.instanceId}")
    private String instanceId;

    private final String endpoint = "";

    public void enviarMensagem(String numero, String mensagem) {
        try {
            String apiUrl = String.format(endpoint, instanceId, token);

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Client-Token", token);

            String json = String.format("{\"phone\": \"%s\", \"message\": \"%s\"}", numero, mensagem);

            System.out.println("Enviando para URL: " + apiUrl);
            System.out.println("Com JSON: " + json);
            System.out.println("Usando Token: " + token);

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    responseCode >= 200 && responseCode < 300
                            ? conn.getInputStream()
                            : conn.getErrorStream(), "utf-8"));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            System.out.println("Resposta da Z-API (HTTP " + responseCode + "): " + response);

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}