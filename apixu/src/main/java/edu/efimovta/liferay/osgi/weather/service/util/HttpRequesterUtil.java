package edu.efimovta.liferay.osgi.weather.service.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Contains only 1 method, that request answer from url, read answer, and return answer by String
 *
 * @author Efimov Timur
 * @version 1.0.1
 */
public class HttpRequesterUtil {

    /**
     * Return answer from url
     *
     * @param url source url
     * @return answer from url
     * @throws IOException              if any problem wile reading answer
     * @throws BadResponseCodeException if non 200 status code returned
     */
    public static String request(String url) throws IOException, BadResponseCodeException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        int status = response.getStatusLine().getStatusCode();

        if (status != 200) {
            throw new BadResponseCodeException(response.getStatusLine() + " status was returned");
        }

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
