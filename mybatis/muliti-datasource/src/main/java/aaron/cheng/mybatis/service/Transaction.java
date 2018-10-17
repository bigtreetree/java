package aaron.cheng.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aaron.cheng.mybatis.dao.kidostatistics.ChildrenDao;
import aaron.cheng.mybatis.entry.ChildrenEntry;

@Service
public class Transaction {

	@Autowired
	private ChildrenDao childrenDao;

	/**
	 * 
	 * 
	 */

	/*
	 * Transactional这里用的是spring自带的事务管理
	 */
	@Transactional
	public void testTransaction() {
		ChildrenEntry entry = new ChildrenEntry();
		entry.setId(99999999);
		entry.setWatchId("99999999");
		ChildrenEntry entry2 = new ChildrenEntry();
		entry2.setId(99999998);
		entry2.setWatchId("99999998");
		childrenDao.insertChildren(entry);
		if (1 / 0 == 1) {
			// 这里抛出异常，导致第一句回滚
			childrenDao.insertChildren(entry2);
		}
	}
}
