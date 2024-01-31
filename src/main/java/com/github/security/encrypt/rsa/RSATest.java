package com.github.security.encrypt.rsa;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

public class RSATest {

    static String modulus = 
            "167274344729242848994658275254152530801810511550982495637422963229401901344598380315243700133015597293532270772549498807396658579139674459337151556018153870903383077060590227102982058065256525525438602590125616219603068865226415601801536367775792565087044000301008922744456933681749860186582665144295496454323";
    static String public_exponent = "65537";
    static String private_exponent = "132278868271934020354870680277121459043511780698555301873828257203213191618248556665972198957743966695677303890293274412807104803736710080254012489772141556257943888590697328708420883100660825084330839212720200324850420330253569834530319989894254725058720175997841596498189994914455223476551555235792986336977";
    
    public static void main(String[] args) throws Exception {
        
//        encryptAndDecrypt();
        String encrypt = encrypt("test");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);
    }
    
    public static String encrypt(String data) throws Exception {
        RSAPublicKey publicKey = RSAUtils.getPublicKey(modulus, public_exponent);
        return RSAUtils.encryptByPublicKey(data, publicKey);
    }
    
    public static String decrypt(String data) throws Exception {
        RSAPrivateKey privateKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        return RSAUtils.decryptByPrivateKey(data, privateKey);
    }
    
    
    public static void encryptAndDecrypt() throws Exception {
        HashMap<String, Object> map = RSAUtils.getKeys();
        // 生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        // 模
        String modulus = publicKey.getModulus().toString();
        // 公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        // 私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        // 明文
        String ming = "123456789";
        // 使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        // 加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println(mi);
        // 解密后的明文
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println(ming);
    }
    
}
