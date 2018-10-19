package aaron.cheng.mybatis.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import aaron.cheng.mybatis.BaseTest;
import aaron.cheng.mybatis.dao.kidodata.ChildHomeSchoolMapper;
import aaron.cheng.mybatis.entry.ChildHomeSchool;

public class ChildHomeSchoolMapperTest extends BaseTest {

    @Autowired
    private ChildHomeSchoolMapper childHomeSchoolMapper;

    @Test
    public void testInsert() {
        ChildHomeSchool child = new ChildHomeSchool();
        child.setChildid(9999);
        // childHomeSchoolMapper.insert(child);
        ChildHomeSchool child2 = childHomeSchoolMapper.selectByPrimaryKey(9999);
        System.out.println(child2.getChildid());
    }
}
