package compress;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressTest {

    public static void main(String[] args) {
        try {
            String path = "compressFile/";
            String context = "ABCDEFGHIJKLMNOP";
            byte[] fileByte = context.getBytes();
            System.out.println("写入内容长度:" + fileByte.length);
            System.out.println("写入文件内容:" + context);
            File file1 = new File(  path + "a.bin");
            File file2 = new File(  path + "b.bin");
            System.out.println("file1内容长度:" + file1.length());

            OutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(context.getBytes(),0,context.length());

            //将字节写入文件
            OutputStream outputStream1 = new FileOutputStream(file1);
            outputStream1.write(fileByte);
            outputStream1.close();

            OutputStream outputStream2 = new FileOutputStream(file2);
            outputStream2.write(fileByte);
            outputStream2.close();

            //读取文件到字节
            InputStream inputStream = new FileInputStream(file1);
            byte[] readBytes = new byte[16];
            inputStream.read(readBytes,0,readBytes.length);
            inputStream.close();
            System.out.println("文件字节长度:"+ file1.length());
            System.out.println("读取文件内容:" + new String(readBytes));

            //压缩文件/文件夹
            dozip(path,"./compressFile.zip");

            //解压文件夹，读取各文件二进制
            unzip("./compressFile.zip");

            //将字节压缩到文件
            Map<String, byte[]> result = new HashMap<>();
            result.put("aa.bin", fileByte);
            result.put("bb.bin", fileByte);
            compress(result, "./test.zip");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //压缩文件/文件夹
    private static void dozip(String srcDir, String zipFileName) throws Exception {
        File zipFile = new File(zipFileName);
        OutputStream outputStream = new FileOutputStream(zipFile);
        Charset charset = Charset.forName("GBK");
        ZipOutputStream zos = new ZipOutputStream(outputStream,charset);
        File file = new File(srcDir);
        if(!file.isFile()){
            File[] fileList = file.listFiles();
            if(fileList != null){
                Arrays.stream(fileList).forEach(item->{
                    try {
                        byte [] itemBytes = new byte[16];
                        zos.putNextEntry(new ZipEntry(item.getName()));
                        InputStream inputStream = new FileInputStream(file.getPath()+ "/"  + item.getName());
                        inputStream.read(itemBytes,0,itemBytes.length);
                        zos.write(itemBytes);
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                zos.close();
            }
        }
    }

    //解压文件夹，读取各文件二进制
    private static void unzip(String zipFile){
        try {
            File file = new File(zipFile);
            String parentPath = file.getParent() +"/";
            InputStream inputStream = new FileInputStream(file);
            Charset charset = Charset.forName("GBK");
            ZipInputStream zis = new ZipInputStream(inputStream, charset);
            ZipEntry zipEntry = null;
            while((zipEntry = zis.getNextEntry()) != null){
                if(!zipEntry.isDirectory()){
                    OutputStream outputStream = new FileOutputStream(parentPath + zipEntry.getName());
                    byte[] bytes = new byte[16];
                    zis.read(bytes);
                    outputStream.write(bytes);
                    outputStream.close();
                    System.out.println(zipEntry.getName());
                }
            }
            zis.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //压缩
    private static void compress(Map<String, byte[]> map, String zipFileName){
        try {
            OutputStream baos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(baos);
            Set<Map.Entry<String, byte[]>> entries = map.entrySet();
            for(Map.Entry<String, byte[]> entry :entries){
                zos.putNextEntry(new ZipEntry(entry.getKey()));
                zos.write(entry.getValue());
            }
            zos.close();
            baos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
