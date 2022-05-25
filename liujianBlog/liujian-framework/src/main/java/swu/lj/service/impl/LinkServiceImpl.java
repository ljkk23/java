package swu.lj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import swu.lj.Constants.SystemConstants;
import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Link;
import swu.lj.domain.vo.LinkVO;
import swu.lj.mapper.LinkMapper;
import swu.lj.service.ILinkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import swu.lj.utils.BeanCopyUtils;

import java.util.List;

/**
 * <p>
 * 友链 服务实现类
 * </p>
 *
 * @author liujian
 * @since 2022-05-25
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {
    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        List<LinkVO> linkVOS = BeanCopyUtils.copyBeanList(links, LinkVO.class);
        return ResponseResult.okResult(linkVOS);


    }
}
