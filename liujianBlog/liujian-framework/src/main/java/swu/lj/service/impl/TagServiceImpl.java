package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.StringUtils;
import swu.lj.domain.entity.Tag;
import swu.lj.domain.vo.PageVo;
import swu.lj.mapper.TagMapper;
import swu.lj.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;

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

    @Override
    public PageVo getPageTag(Integer pageNum, Integer pageSize, String name, String remark) {
        LambdaQueryWrapper<Tag> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtils.hasText(name),Tag::getName,name);
        lambdaQueryWrapper.eq(StringUtils.hasText(remark),Tag::getRemark,remark);
        Page<Tag> tagPage = getBaseMapper().selectPage(new Page<>(pageNum,pageSize), lambdaQueryWrapper);
        PageVo pageVo= new PageVo(tagPage.getRecords(), tagPage.getTotal());
        return pageVo;
    }

}
