import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipFiles {


    public static void main(String[] args) throws IOException {

        //String path = "C:\\Users\\Rishabh Handa\\Documents\\files\\task\\ssc upgrade\\recursive-extract\\outerzip.rar";


        String path = "C:\\Users\\Rishabh Handa\\Documents\\files\\task\\ssc upgrade\\recursive-extract\\java\\cdev~ext_lib.zip";
        extractFolder(path);
    }

    public static void extractFolder(String zipFile) throws IOException {
        int buffer = 2048;
        File file = new File(zipFile);


        try (ZipFile zip = new ZipFile(file)) {
            file.getName().length();
            String newPath = zipFile.substring(0, zipFile.length() - 4);

            boolean createdFolder = new File(newPath).mkdir();
            Enumeration<? extends ZipEntry> zipFileEntries = zip.entries();

            // Process each entry
            while (zipFileEntries.hasMoreElements()) {
                // grab a zip file entry
                ZipEntry entry = zipFileEntries.nextElement();
                String currentEntry = entry.getName();
                File destFile = new File(newPath, currentEntry);
                File destinationParent = destFile.getParentFile();

                // create the parent directory structure if needed
                createdFolder = destinationParent.mkdirs();

                if (!entry.isDirectory()) {
                    BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
                    int currentByte;
                    // establish buffer for writing file
                    byte[] data = new byte[buffer];

                    // write the current file to disk
                    FileOutputStream fos = new FileOutputStream(destFile);
                    try (BufferedOutputStream dest = new BufferedOutputStream(fos, buffer)) {

                        // read and write until last byte is encountered
                        while ((currentByte = is.read(data, 0, buffer)) != -1) {
                            dest.write(data, 0, currentByte);
                        }
                        dest.flush();
                        is.close();
                    }
                }

                if (currentEntry.endsWith(".zip") ||
                        currentEntry.endsWith(".rar") ||
                        currentEntry.endsWith(".jar") ||
                        currentEntry.endsWith(".ppa")) {
                    // found a zip file, try to open
                    extractFolder(destFile.getAbsolutePath());
                }
            }
        } catch (Exception ex) {
            System.out.println("Got an error - " + ex.getMessage());
            ex.printStackTrace();
        }
    }


}
