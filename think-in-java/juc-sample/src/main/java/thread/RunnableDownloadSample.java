package thread;


public class RunnableDownloadSample implements Runnable {

    private final String url;
    private final String name;

    public RunnableDownloadSample(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        DownloadImg.download(url, name);
        System.out.println("下载文件: " + name);
    }


    public static void main(String[] args) {

        RunnableDownloadSample threadDownloadSample1 = new RunnableDownloadSample("https://avatars.githubusercontent.com/u/1134463?s=64&v=4", "1.png");
        RunnableDownloadSample threadDownloadSample2 = new RunnableDownloadSample("https://avatars.githubusercontent.com/u/6304496?s=64&v=4", "2.png");
        RunnableDownloadSample threadDownloadSample3 = new RunnableDownloadSample("https://avatars.githubusercontent.com/u/1059363?s=64&v=4", "3.png");

        new Thread(threadDownloadSample1).start();
        new Thread(threadDownloadSample2).start();
        new Thread(threadDownloadSample3).start();

    }

}