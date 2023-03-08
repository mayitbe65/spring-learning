package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class ThreadDownloadSample extends Thread {

    private final String url;
    private final String name;

    public ThreadDownloadSample(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        DownloadImg.download(url, name);
        System.out.println("下载文件: " + name);
    }


    public static void main(String[] args) {

        ThreadDownloadSample threadDownloadSample1 = new ThreadDownloadSample("https://avatars.githubusercontent.com/u/1134463?s=64&v=4", "1.png");
        ThreadDownloadSample threadDownloadSample2 = new ThreadDownloadSample("https://avatars.githubusercontent.com/u/6304496?s=64&v=4", "2.png");
        ThreadDownloadSample threadDownloadSample3 = new ThreadDownloadSample("https://avatars.githubusercontent.com/u/1059363?s=64&v=4", "3.png");

        threadDownloadSample1.start();
        threadDownloadSample2.start();
        threadDownloadSample3.start();

    }
}


class DownloadImg {

    public static void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
