package swu.lj.service.impl;

import swu.lj.domain.entity.Tag;
import swu.lj.mapper.TagMapper;
import swu.lj.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-08-26
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
