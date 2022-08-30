package swu.lj.service;

import swu.lj.domain.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import swu.lj.domain.vo.PageVo;

import java.util.List;

/**
 * <p>
 * 标签 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-08-26
 */
public interface ITagService extends IService<Tag> {
    PageVo getPageTag(Integer pageNum, Integer pageSize, String name, String remark);
}
