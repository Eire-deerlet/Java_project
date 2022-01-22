package updateOneTest;


import com.first.group.parts.PartsApplication;
import com.first.group.parts.mapper.PcPartsOneMapper;
import com.first.group.parts.pojos.PcPartsOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartsApplication.class)
public class DubboProviderApplicationTests2 {

  /*  @Autowired
    private UserMapper userMapper;*/

    @Autowired
    private PcPartsOneMapper oneMapper;

    @Test
    public void testFind() {
        Integer coding =100005;
        String name ="you";
        PcPartsOne pcPartsOne = oneMapper.search(name, coding);
        System.out.println(pcPartsOne);

    }
}
