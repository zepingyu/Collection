package Serializable;

import java.util.Base64;

/**
 * created by Shang Wu 08/22/2019
 */

public class CompressedSdkMessage {
    private String comeFrom;    //数据来自android还是ios
    private byte[] body;
    private String appName;
    private int length;

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getAppName(){return appName;}

    public void setAppName(String appName){ this.appName = appName;}

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return comeFrom.length() + body.length + appName.length() + 12;
    }

}

