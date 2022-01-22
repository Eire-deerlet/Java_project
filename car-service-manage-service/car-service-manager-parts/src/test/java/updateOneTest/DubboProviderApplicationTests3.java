package updateOneTest;


import com.first.group.dtos.ManagerCodeEnum;
import com.first.group.dtos.ResponseResult;
import com.first.group.exception.CarServiceException;
import com.first.group.parts.PartsApplication;
import com.first.group.parts.mapper.PcBrandMapper;
import com.first.group.parts.mapper.PcPartsMapper;
import com.first.group.parts.mapper.PcPartsOneMapper;
import com.first.group.parts.mapper.PcPartsTwoMapper;
import com.first.group.parts.pojos.PcBrand;
import com.first.group.parts.pojos.PcParts;
import com.first.group.parts.pojos.PcPartsOne;
import com.first.group.parts.pojos.PcPartsTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartsApplication.class)
public class DubboProviderApplicationTests3 {

  /*  @Autowired
    private UserMapper userMapper;*/

    @Autowired
    private PcPartsTwoMapper twoMapper;

    @Autowired
    private PcPartsMapper pcPartsMapper;

    @Test
    public void testFind() {
        PcPartsTwo two = new PcPartsTwo();
        two.setSort(1);
        two.setCoding(10000001);
        two.setName("AA");
        two.setImage("BB");
        two.setUpdateTime(new Date());



        twoMapper.update(two);

    }

    @Test
    public void testFind2() {
        List<PcParts> findlist = pcPartsMapper.findlist();
        for (PcParts pcParts : findlist) {
            System.out.println(pcParts);
        }


    }

    @Autowired
    private PcBrandMapper pcBrandMapper;
    @Test
    public void testFind3() {


        PcBrand pcBrand = new PcBrand();

        pcBrand.setCoding(2);
        pcBrand.setName("e");
        pcBrand.setLogo("e");
        pcBrand.setSort(1);
        pcBrand.setCreateTime(new Date());
        pcBrand.setUpdateTime(new Date());

        pcBrandMapper.add(pcBrand);

    }

    @Test
    public void testFind4() {

    Integer id=1;


        PcBrand pcBrand = new PcBrand();
        pcBrand.setId(id);


        pcBrand.setCoding(111);
        pcBrand.setName("er");
        pcBrand.setLogo("ere");
        pcBrand.setUpdateTime(new Date());
        pcBrand.setSort(4);

        pcBrandMapper.update(pcBrand);

    }

}
