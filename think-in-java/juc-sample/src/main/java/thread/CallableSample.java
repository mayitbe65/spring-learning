package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableSample implements Callable<String> {

    private final String url;
    private final String name;

    public CallableSample(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String call() {
        DownloadImg.download(url, name);
        System.out.println("下载文件: " + name);
        return name + "-OK";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableSample c1 = new CallableSample("https://avatars.githubusercontent.com/u/1134463?s=64&v=4", "1.png");
        CallableSample c2 = new CallableSample("https://avatars.githubusercontent.com/u/6304496?s=64&v=4", "2.png");
        CallableSample c3 = new CallableSample("https://avatars.githubusercontent.com/u/1059363?s=64&v=4", "3.png");

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> r1 = executorService.submit(c1);
        Future<String> r2 = executorService.submit(c2);
        Future<String> r3 = executorService.submit(c3);

        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());

        executorService.shutdown();
    }
}
