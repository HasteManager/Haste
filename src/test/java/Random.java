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
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        String[] names = {"马清", "虞红","谈梦兰","韩建新","宗敏","王滢茜","褚孟颍","谈静静","淘逞威","陆长霖","周盼","姜萍" };
//        for (String name : names) {
//            arrayList.add(name);
//        }

        for (int i = 0; i < 1000; i++) {
            double v = Math.random() * (names.length);
            System.out.println((int) v +"："+names[(int) v]);
        }

        //arrayList.
        //System.out.println(arrayList.get((int) v));
        //return arrayList.get((int) v);
    }
}