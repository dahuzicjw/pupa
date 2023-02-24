package com.github;

import okhttp3.HttpUrl;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Test {

    // Authorization: <schema> <token>
// GET - getToken("GET", httpurl, "")
// POST - getToken("POST", httpurl, json)
    static String schema = "WECHATPAY2-SHA256-RSA2048";
    static HttpUrl httpurl = HttpUrl.parse("https://api.mch.weixin.qq.com/v3/certificates");

    public static void main(String[] args) throws Exception {
        String get = getToken("get", httpurl, "");
        System.out.println(get);
    }

    static String getToken(String method, HttpUrl url, String body) throws Exception {
        String nonceStr = "xxx";
        long timestamp = System.currentTimeMillis() / 1000;
        String message = buildMessage(method, url, timestamp, nonceStr, body);
        String signature = sign(message.getBytes("utf-8"));

        return "mchid=\"" + 1636168917 + "\","
                + "nonce_str=\"" + nonceStr + "\","
                + "timestamp=\"" + timestamp + "\","
                + "serial_no=\"" + "35F9074BBA5361D451E2E6DE1A4A23C8ADD15F22" + "\","
                + "signature=\"" + signature + "\"";
    }

    static String sign(byte[] message) throws Exception{
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDdz2Hck6CET/SP\n" +
                        "/nexroMlq1ijrkg9QQYBaHN7LNC0FjC9v9fUoB0Gj4M0iHIOoGR9Ao4Md8XrmXUQ\n" +
                        "TZBWUVoMtW093cOgSqS7Ad9sQN0Vd/vUp3zwsPnZy49HM4vUVoQpO5knhlct/q2t\n" +
                        "NDsP1yPb231SNQEXn0RiM/MrdqFbBvr7oHa01xfTaGQoCQhP5ljgeKwGkAYtVl/2\n" +
                        "6kkEbUVJ42CXmjwgT0CxZvV0KZDHaE22RCB7T/cwoavWiPoVsWnxLtE/r2N5RDkA\n" +
                        "gbfr+PZdIwdV/70IyVq2WTtBBenJafJmxlFpu0+jIJ2fDseH01uCZmNPzvqh0hx2\n" +
                        "8CpTS/9fAgMBAAECggEBAKo1wOAWPSArhv2UhV9JDoSylyOL0w2GP0iHUc7c1g7L\n" +
                        "1H1XoRUeBQgKyuFeL0BAHry7YCv7IVso+GcZTkCezt5fvsOx0LPJc925kyysHbui\n" +
                        "xhIqsLq25BQYnAtEZ/H6rhJCFMX61h2KiNYX9ZazPmYxaVrTJ9JrunstaFYbA7ko\n" +
                        "FWWLRaSfMDHT/jXnOvdjWacpkr2OdZwkaiplhPKykJ3j2JvSIgba8RCKLMwg573V\n" +
                        "4UHBXDqe4qe8HvBsdwwnv9VsNhH2EBJ1E9n1DLct0LLGev1IKHRBA8JRgJycxqZ0\n" +
                        "SO4OlYJP/SiPt5+ppU/JNnvHoZAH1Ftb6ufAjAqC8NkCgYEA8MJfNpqe1nRLKOVq\n" +
                        "LF/dwbhrOb5Rhn3NI/Cm0+paO5WN2mYLlRJElWS4GJGslrO+kVYGuIFBJDZvjxTo\n" +
                        "A0MfhlMqIkZhLWNpXdV51Z2H9EkoCoYD/W42yoMBjP3zRnog+yz9uUyh/D3LNii4\n" +
                        "e7ZpRCtRK19k8L2SXXhnfzdTBkUCgYEA69nt2+OGSBNSmUj55rDA5b0xudt3h81A\n" +
                        "6KupWtMBSpBMBeR0ZGBIK+Pe/EpwsxUqp3i8mCWoCGXMFm5srwEfVI/FJeTwMR/s\n" +
                        "Q31zFXf1/qjOiNWl8kqpU86BhiEAPrzumCf5jj0mhdAtFRUyNJ52UmyW0VQ+oD65\n" +
                        "Ur56uMlsC1MCgYEAlRKVJ9c3UGwzeYALbKxzP5az9c4M5qyQT5ebhI2QD2K7saYL\n" +
                        "t+LWynXRs4zHg4yKC61rfeSyc/ysuLhmLFbsdxyZcx2G4Da0sCAVTxo6axy9CT8P\n" +
                        "y2Tp0hyp4iX/8vx93WhvNcPobKnKYJ94E0nQBiCYIrXvZ0zKCswZsWCNLM0CgYB7\n" +
                        "EtsLrtxIykSFFs7Jch0HBcZoHT1v0Uz43XNfoNKArXHudTvDkXa36I5ZCyNqYDZE\n" +
                        "9D0+DBB2aWCpp+/xFt3Zi7iuQJySlfz9bv5aCqKExGQahZq2J/3abN2sN5ZgJsk+\n" +
                        "/0U7029BztNnuArd6H8IHgBJtfOEPZcJtbpmqT1HXwKBgG6tx4mOPLwHA5x3zxYo\n" +
                        "MgCuRdkSOvnBoqxOrFQe/a/g/nudzTAXx8wVB4HpaaB7n0KuULTv1RC36YCGWsa/\n" +
                        "gBhXS2AS1wv92ausug2loYxRWt5xjb+YKIVXA853Tkqz4UUtCymXy+QlxLkZCNZ0\n" +
                        "jce68sGmzLe7+wTSzSGB5EwH"))));
        sign.update(message);

        return Base64.getEncoder().encodeToString(sign.sign());
    }

    static String buildMessage(String method, HttpUrl url, long timestamp, String nonceStr, String body) {
        String canonicalUrl = url.encodedPath();
        if (url.encodedQuery() != null) {
            canonicalUrl += "?" + url.encodedQuery();
        }

        return method + "\n"
                + canonicalUrl + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + body + "\n";
    }

}
