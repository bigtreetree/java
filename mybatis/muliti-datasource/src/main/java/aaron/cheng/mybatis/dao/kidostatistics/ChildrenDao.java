package aaron.cheng.mybatis.dao.kidostatistics;

import org.apache.ibatis.annotations.Mapper;

import aaron.cheng.mybatis.entry.ChildrenEntry;

@Mapper
public interface ChildrenDao {
	ChildrenEntry getChildren(int id);

	void insertChildren(ChildrenEntry childrenEntry);
}
