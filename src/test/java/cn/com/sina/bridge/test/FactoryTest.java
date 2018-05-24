package cn.com.sina.bridge.test;

import cn.com.sina.bridge.AlanServiceAddress;
import cn.com.sina.bridge.AlanServiceAddressSelector;
import org.junit.Test;

import java.util.List;

/**
 * Created by wanghongfei on 06/04/2017.
 */
public class FactoryTest {
    @Test
    public void testSelect() {
        for (int ix = 0 ; ix < 2; ++ix) {
            selectServer();
            System.out.println("第" + (ix + 1) + "次");
        }
    }

    private void selectServer() {
        List<AlanServiceAddress> list = AlanServiceAddressSelector.selectAvailableServers("myclient");
        System.out.println(list);

        AlanServiceAddress addr = AlanServiceAddressSelector.selectOne("myclient");
        System.out.println(addr);

    }
}
