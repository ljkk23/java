package swu.lj.service;

import swu.lj.domain.ResponseResult;
import swu.lj.domain.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 * @author liujian
 * @since 2022-05-25
 */
public interface ILinkService extends IService<Link> {

    ResponseResult getAllLink();
}
