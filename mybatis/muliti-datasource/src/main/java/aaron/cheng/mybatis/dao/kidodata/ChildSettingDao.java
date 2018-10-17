package aaron.cheng.mybatis.dao.kidodata;

import org.apache.ibatis.annotations.Mapper;

import aaron.cheng.mybatis.entry.ChildSettingEntry;

@Mapper
public interface ChildSettingDao {
    ChildSettingEntry getSetting(int childid);

    ChildSettingEntry addSetting(int childid);
}
