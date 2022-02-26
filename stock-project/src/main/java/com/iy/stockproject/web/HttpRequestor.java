package com.iy.stockproject.web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpRequestor {
    public static boolean http_code_is_valid(int code) {
        return (code < 400);
    }

    public String get_query_param_string(String tickerSymbol) {
        final String charset = "UTF-8";
        String query = "";
        try {
            query = String.format("?symbols=%s", URLEncoder.encode(tickerSymbol + ",ETH-USD", charset));
        }
        catch (UnsupportedEncodingException exception) {
            System.err.println(exception.getMessage());
        }
        return query;
    }

    public String do_request(String tickerSymbol) {
        try {
            URL url = new URL("https://stock-data-yahoo-finance-alternative.p.rapidapi.com/v6/finance/quote" +
                    get_query_param_string(tickerSymbol));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-rapidapi-host", "stock-data-yahoo-finance-alternative.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", "");
            connection.connect();

            if (http_code_is_valid(connection.getResponseCode())) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder bldr = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    bldr.append(line);
                }
                return bldr.toString();
            }
        }
        catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return "NO RESPONSE!";
    }
}