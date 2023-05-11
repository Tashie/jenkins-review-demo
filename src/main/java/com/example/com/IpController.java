package com.example.com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

@RestController
public class IpController {

    @GetMapping("/ip")
    public String hello() throws SocketException, UnknownHostException {
        try (final DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
            return "v1->" + datagramSocket.getLocalAddress().getHostAddress();
        }
    }
}
