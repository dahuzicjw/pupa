package com.github;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by Kevin on 2016/5/29.
 * @author chenjw
 */
//@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.out.println(randomMac4Qemu());
        System.out.println(randomMac4Qemu());
        System.out.println(randomMac4Qemu());
        System.out.println(randomMac4Qemu());
    }
    private static String SEPARATOR_OF_MAC = ":";

    /**
     * Generate a random MAC address for qemu/kvm
     * 52-54-00 used by qemu/kvm
     * The remaining 3 fields are random,  range from 0 to 255
     *
     * @return MAC address string
     */
    public static String randomMac4Qemu() {
        Random random = new Random();
        String[] mac = {
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff)),
                String.format("%02x", random.nextInt(0xff))
        };
        return String.join(SEPARATOR_OF_MAC, mac);
    }
}
