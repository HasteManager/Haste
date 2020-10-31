import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class DownloadPicTest1 {


    /**
     * ����get����,  ����ͼƬ
     *
     * @param
     * @return
     */
    public static void httpGetImg(CloseableHttpClient client, String imgUrl, String savePath) {


        // ����get����
        HttpGet request = new HttpGet(imgUrl);
        // ��������ʹ��䳬ʱʱ��
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(50000).setConnectTimeout(50000).build();

        //��������ͷ
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1");

        request.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = client.execute(request);

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity entity = response.getEntity();

                InputStream in = entity.getContent();

                FileUtils.copyInputStreamToFile(in, new File(savePath));
                System.out.println("����ͼƬ�ɹ�:" + imgUrl);

            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            request.releaseConnection();

        }
    }


    public static void main(String[] args) {

        CloseableHttpClient client = null;

        try {
            client = HttpClients.createDefault();
            String url = "https://picsum.photos/300/150/?image=";
            for (int i = 10000; i < 15000; i++) { //����100��ͼƬ
                httpGetImg(client, "https://static.ffxiah.com/images/icon/"+i+".png" , "E:\\Img" + "/" + i + ".jpg");
                System.out.println("ok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}