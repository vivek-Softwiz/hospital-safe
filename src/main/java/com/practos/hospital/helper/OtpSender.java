package com.practos.hospital.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.SplittableRandom;

public class OtpSender {
//    public static String generateOtp(int otpLength) {
//        SplittableRandom random = new SplittableRandom();
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < otpLength; i++) {
//            sb.append(random.nextInt(0, 9));
//        }
//        return sb.toString();
//    }

    public static void sendOtp(String phone) {

        System.out.println(phone);


        String apiKeys = "+ZjRiNzIyYmZiOTllMDRjOWY4NjFhOTM1OGQzMDAxOWQ=";
        try {

            String apiKey = "apikey=" + apiKeys;
            String message = "&message=" + "Your otp is"+" "+"hi";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "91"+phone;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

System.out.println(stringBuffer);
        } catch (Exception e) {
            System.out.println("Error SMS "+e);

        }
    }
}
