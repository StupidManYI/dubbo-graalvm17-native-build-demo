package com.ingsha.nativeDemo.dubboServiceImpl;

import com.ingsha.nativeDemo.dubboService.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author Martin Yi
 * @Date 2024/3/2 20:44
 * @Version 1.0
 */
@DubboService(version = "1.0.0", group = "dubbo", timeout = 5000)
public class DemoServiceImpl implements DemoService {


    @Override
    public String getUserById(Long id) {
        return new String("你好" + id);
    }

}
