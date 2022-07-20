import DAO.SaleTransDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class mainTest implements Runnable {
    private Thread t;
    private String threadName;

    mainTest(String name) {
        threadName = name;
        System.out.println("Creating thread: " + name);
    }

    public static void main(String[] args) {
        try {
            SSLCertificate();
            mainTest r1 = new mainTest("Telegram bot");
            r1.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void SSLCertificate() throws NoSuchAlgorithmException, KeyManagementException {
        /* Start of Fix */
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        /* End of the fix*/
    }

    public static void HTTPSendPhoto(String imageDirectory) throws IOException {
        String url = "https://api.telegram.org/bot'Put your token api here'/sendPhoto?";
        String charset = "UTF-8";
        String chat_id = "Put your chat id here";
        String caption = "Select data from bccs.im";
        File imageFile = new File(imageDirectory);
        String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
        String CRLF = "\r\n"; // Line separator required by multipart/form-data.

        URLConnection connection = new URL(url).openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);


        try (
                OutputStream output = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
        ) {
            // Send normal chat Id .
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"chat_id\"").append(CRLF);
            writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF);
            writer.append(CRLF).append(chat_id).append(CRLF).flush();

            // Send normal caption.
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"caption\"").append(CRLF);
            writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF);
            writer.append(CRLF).append(caption).append(CRLF).flush();

            // Send file.
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"photo\"; filename=\"" + imageFile.getName() + "\"").append(CRLF);
            writer.append("Content-Type: image/jpeg; charset=" + charset).append(CRLF); // Text file itself must be saved in this charset!
            writer.append(CRLF).flush();
            Files.copy(imageFile.toPath(), output);
            output.flush(); // Important before continuing with writer!
            writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.

            // End of multipart/form-data.
            writer.append("--" + boundary + "--").append(CRLF).flush();
        }

        // Request is lazily fired whenever you need to obtain information about response.
        int responseCode = ((HttpURLConnection) connection).getResponseCode();
        System.out.println("================= HTTP ====================");
        System.out.println("Status: " + responseCode); // Should be 200
    }
    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy - hh:mm:ss");
            while (true) {
                long start = System.nanoTime();
                System.out.println("Thread: " + threadName + " on " + sdf.format(new Date()));
                String fileName = ChartReport();
//                System.out.println(fileName);
                HTTPSendPhoto(fileName);
                long elapsedTime = System.nanoTime() - start;
                Thread.sleep(2 * 60 * 1000 - elapsedTime / 1000000); // 2 minutes
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public String ChartReport() throws IOException {
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Report Sale Chart",
                "Sale date", "Value of amount not tax",
                createDataset(), PlotOrientation.VERTICAL,
                true, true, false);


        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        String date = simpleFormatter.format(new Date());
        String fileName = "ChartReport_" + date + ".jpeg";
        File ChartReport = new File(fileName);
        ChartUtilities.saveChartAsJPEG(ChartReport, lineChart, 1080, 720);
        System.out.println("Image name: " + ChartReport.getAbsolutePath());
        return ChartReport.getAbsolutePath();

    }
    private static DefaultCategoryDataset createDataset() {
        try{

            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
            dataset = SaleTransDAO.getALlSaleTrans1(dataset);

            return dataset;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
