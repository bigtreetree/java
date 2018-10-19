package aaron.cheng.mybatis.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import aaron.cheng.mybatis.BaseTest;
import aaron.cheng.mybatis.dao.kidostatistics.ChildWifiMapper;
import aaron.cheng.mybatis.entry.ChildWifi;

public class ChildWifiMapperTest extends BaseTest {

    @Autowired
    private ChildWifiMapper childWifiMapper;

    @Test
    public void insert() {
        ChildWifi record = new ChildWifi();
        record.setChildid(99999999);
        record.setWifistate((short)1);
        record.setWifipwd("");
        record.setWifiname("");
        record.setOperationtype(1);
        record.setCreatetime(new Date());
        int res = childWifiMapper.insert(record);
        System.out.println(record.getId());
        System.out.println(res);
    }

    public void insertSelective() {
        // TODO Auto-generated method stub
    }

}
