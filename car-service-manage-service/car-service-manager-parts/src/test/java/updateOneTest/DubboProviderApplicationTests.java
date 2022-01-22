package updateOneTest;


import com.first.group.parts.PartsApplication;
import com.first.group.parts.dtos.OneUpdateDto;
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
public class DubboProviderApplicationTests {

  /*  @Autowired
    private UserMapper userMapper;*/

    @Autowired
    private PcPartsOneMapper oneMapper;

    @Test
    public void testFind() {

        PcPartsOne partsOne = new PcPartsOne();
        partsOne.setCoding(100001);
        partsOne.setName("x");
        partsOne.setType("y");
        partsOne.setState(0);
        partsOne.setUpdateTime(new Date()); //修改时间
        partsOne.setSort(4);

        oneMapper.update(partsOne);
    }
}
