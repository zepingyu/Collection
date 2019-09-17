package Serializable;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        CompressedSdkMessage compressedSdkMessage = new CompressedSdkMessage();
        compressedSdkMessage.setAppName("yzp11111111");
        compressedSdkMessage.setBody("yzpyzbdsfdgsgf".getBytes());
        compressedSdkMessage.setComeFrom("ele2222222");
        System.out.println(compressedSdkMessage.getAppName().length() + " " + compressedSdkMessage.getComeFrom().length() + " " +  compressedSdkMessage.getBody().length);

        int length = compressedSdkMessage.getLength();
        System.out.println(length);
        ByteBuffer byteBuffer = ByteBuffer.allocate(length);
        byteBuffer.putInt(compressedSdkMessage.getAppName().length());
        byteBuffer.putInt(compressedSdkMessage.getComeFrom().length());
        byteBuffer.putInt(compressedSdkMessage.getBody().length);
        byteBuffer.put(compressedSdkMessage.getAppName().getBytes());
        byteBuffer.put(compressedSdkMessage.getComeFrom().getBytes());
        byteBuffer.put(compressedSdkMessage.getBody());

        ByteBuffer bufferResult = ByteBuffer.wrap(byteBuffer.array());
        Integer appNameLength = bufferResult.getInt();
        Integer comeFromLength = bufferResult.getInt();
        Integer bodyLength = bufferResult.getInt();

        byte[] appName = new byte[appNameLength];
        bufferResult.get(appName, 0, appNameLength);
        byte[] comeFrom = new byte[comeFromLength];
        bufferResult.get(comeFrom, 0, comeFromLength);
        byte[] body = new byte[bodyLength];
        bufferResult.get(body, 0, bodyLength);

        System.out.println(appNameLength + " " + comeFromLength + " " + bodyLength + " " + new String(appName) + " " + new String(comeFrom) + " " + new String(body));
    }
}
