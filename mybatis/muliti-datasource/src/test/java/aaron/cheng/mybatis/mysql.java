package aaron.cheng.mybatis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import aaron.cheng.mybatis.dao.kidodata.ChildSettingDao;
import aaron.cheng.mybatis.dao.kidostatistics.ChildrenDao;
import aaron.cheng.mybatis.entry.ChildSettingEntry;
import aaron.cheng.mybatis.entry.ChildrenEntry;
import aaron.cheng.mybatis.service.Transaction;

public class mysql extends BaseTest {
	@Autowired
	private ChildSettingDao settingDaoMapper;

	@Autowired
	private ChildrenDao childrenDao;

	@Autowired
	private Transaction transaction;

	@Override
	@Test
	public void test() {
		System.out.println("begin");
		transaction.testTransaction();
		ChildSettingEntry entry = settingDaoMapper.getSetting(1);
		System.out.println(entry.getApproveFriendFlag());
		System.out.println(entry.getEyeshieldStartTime());
		ChildSettingEntry entry2 = settingDaoMapper.addSetting(2036);
		System.out.println(entry2.getEyeshieldStartTime());
		ChildrenEntry childrenEntry = childrenDao.getChildren(20);
		System.out.println(childrenEntry.getWatchId());
		System.out.println("over");
	}
}
