package com.github.web3;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class HelloWorldWeb3 {

    public static void main(String[] args) {
        // 连接到以太坊网络（这里使用的是Infura的测试网络）
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/your_infura_project_id"));

        try {
            // 获取当前区块链的区块数量
            EthBlockNumber blockNumber = web3.ethBlockNumber().send();
            // 打印出区块数量
            System.out.println("Hello World! 当前区块链的区块数量为：" + blockNumber.getBlockNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}