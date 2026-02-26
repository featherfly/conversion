
package cn.featherfly.conversion;

import static org.testng.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.ClassType;
import cn.featherfly.common.structure.ChainSetImpl;
import cn.featherfly.conversion.convertors.ContainerType;
import cn.featherfly.conversion.string.ToStringBeanPropertyConversion;
import cn.featherfly.conversion.string.ToStringConversionPolicys;
import cn.featherfly.conversion.string.ToStringTypeConversion;
import cn.featherfly.conversion.vo.User;

/**
 * @author 钟冀
 */
public class CollectionTest {

    ToStringTypeConversion conversion = new ToStringTypeConversion();

    ToStringBeanPropertyConversion bpConversion;

    String numsStr = "1,2,3,4,5";
    String nums2Str = "5,4,3,2,1";
    String addressListStr = "address1,address-2,address_3";
    String nameSetStr = "yufei,yi,featherfly";
    String queueStr = "q1,q2,q3";

    BeanDescriptor<User> beanDescriptor = BeanDescriptor.getBeanDescriptor(User.class);

    BeanProperty<User, List<String>> addressListBeanProperty = beanDescriptor.getBeanProperty("addressList");
    BeanProperty<User, Set<String>> nameSetBeanProperty = beanDescriptor.getBeanProperty("nameSet");
    BeanProperty<User, Queue<String>> queueBeanProperty = beanDescriptor.getBeanProperty("queue");

    User user;

    @BeforeClass
    public void setUp() {
        bpConversion = new ToStringBeanPropertyConversion(ToStringConversionPolicys.FORMAT_CONVERSION_POLICY);
        user = new User();
        user.setAddressList(Lang.list("address1", "address-2", "address_3"));
        user.setNameSet(new ChainSetImpl<String>(new LinkedHashSet<>()).addChain("yufei", "yi", "featherfly"));
        Queue<String> queue = new ArrayDeque<>();
        queue.add("q1");
        queue.add("q2");
        queue.add("q3");
        user.setQueue(queue);
    }

    @Test
    public void list() {
        assertEquals(Lang.list(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, new ContainerType<>(List.class, int.class)));
        assertEquals(nums2Str, conversion.sourceToTarget(Lang.list(5, 4, 3, 2, 1), String.class));
    }

    @Test
    public void listBeanProperty() {
        assertEquals(user.getAddressList(),
            bpConversion.targetToSource(addressListStr, addressListBeanProperty));
        assertEquals(addressListStr, bpConversion.sourceToTarget(user.getAddressList(), addressListBeanProperty));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void listException1() {
        assertEquals(Lang.list(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, List.class));
        assertEquals(nums2Str, conversion.sourceToTarget(Lang.list(5, 4, 3, 2, 1), String.class));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void listException2() {
        assertEquals(Lang.list(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, new ClassType<>(List.class)));
        assertEquals(nums2Str, conversion.sourceToTarget(Lang.list(5, 4, 3, 2, 1), String.class));
    }

    @Test
    public void set() {
        assertEquals(Lang.set(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, new ContainerType<>(Set.class, int.class)));
        assertEquals(Lang.set(5, 4, 3, 2, 1),
            conversion.targetToSource(numsStr, new ContainerType<>(Set.class, int.class)));
        assertEquals(numsStr, conversion.sourceToTarget(Lang.set(5, 4, 3, 2, 1), String.class));
        assertEquals(nums2Str,
            conversion.sourceToTarget(new ChainSetImpl<>(new LinkedHashSet<>()).addChain(5, 4, 3, 2, 1), String.class));
    }

    @Test
    public void setBeanProperty() {
        assertEquals(user.getNameSet(),
            bpConversion.targetToSource(nameSetStr, nameSetBeanProperty));
        assertEquals(nameSetStr, bpConversion.sourceToTarget(user.getNameSet(), nameSetBeanProperty));
    }

    @Test
    public void queue() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertEquals(queue,
            conversion.targetToSource(numsStr, new ContainerType<>(Queue.class, int.class)));
        assertEquals(numsStr, conversion.sourceToTarget(queue, String.class));

        String className = User.class.getName();
        assertEquals(User.class, conversion.targetToSource(className, Class.class));

        assertEquals(className, conversion.sourceToTarget(User.class, String.class));
    }

    @Test
    public void queueBeanProperty() {
        assertEquals(user.getQueue(),
            bpConversion.targetToSource(queueStr, queueBeanProperty));
        assertEquals(queueStr, bpConversion.sourceToTarget(user.getQueue(), queueBeanProperty));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void setException1() {

        assertEquals(Lang.set(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, Set.class));
        assertEquals(nums2Str, conversion.sourceToTarget(Lang.set(5, 4, 3, 2, 1), String.class));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void setException2() {
        assertEquals(Lang.set(1, 2, 3, 4, 5),
            conversion.targetToSource(numsStr, new ClassType<>(Set.class)));
        assertEquals(nums2Str, conversion.sourceToTarget(Lang.set(5, 4, 3, 2, 1), String.class));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void queueException1() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertEquals(queue,
            conversion.targetToSource(numsStr, Queue.class));
        assertEquals(nums2Str, conversion.sourceToTarget(queue, String.class));
    }

    @Test(expectedExceptions = ConversionException.class)
    public void queueException2() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertEquals(queue,
            conversion.targetToSource(numsStr, new ClassType<>(Queue.class)));
        assertEquals(nums2Str, conversion.sourceToTarget(queue, String.class));
    }
}
