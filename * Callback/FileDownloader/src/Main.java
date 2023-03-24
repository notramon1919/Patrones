class FileDownloader {
    interface Callback {
        void progreso(int percentage);
    }

    public void downloadFile(String filePath, Callback callback) {
        // simular progreso de descarga
        for (int percentage = 0; percentage <= 100; percentage += 10) {
            callback.progreso(percentage);
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
       fileDownloader.downloadFile("http://.../myFile.txt", new FileDownloader.Callback() {
           @Override
           public void progreso(int percentage) {
               System.out.println("DESCARGA AL : " + percentage + "%");
           }
       });


    }
}