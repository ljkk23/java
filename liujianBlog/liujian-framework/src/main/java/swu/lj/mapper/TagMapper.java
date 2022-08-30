package swu.lj.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import swu.lj.domain.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 标签 Mapper 接口
 * </p>
 *
 * @author liujian
 * @since 2022-08-26
 */
@Component
public interface TagMapper extends BaseMapper<Tag> {

}
