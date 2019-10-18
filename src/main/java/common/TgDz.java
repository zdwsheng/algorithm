package common;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName TgDz
 * @Description 天干地支
 * @author: zdw
 * @date 2019/10/18 9:42
 */
public class TgDz implements Common {
    private static final Set<String> tgDz = new HashSet<>(128);
    private static final String[] tg = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "葵"};
    private static final String[] dz = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    public static void main(String[] args) throws JsonProcessingException {
        int tgIndex = 0;
        int dzIndex = 0;
        while (true) {
            tgIndex = (tgIndex == tg.length) ? 0 : tgIndex;
            dzIndex = (dzIndex == dz.length) ? 0 : dzIndex;

            String tgDzStr = tg[tgIndex] + dz[dzIndex];
            if (tgDz.contains(tgDzStr)) {
                System.out.println("重复:" + tgDzStr);
                break;
            }
            System.out.println("干支:" + tgDzStr);
            tgDz.add(tg[tgIndex] + dz[dzIndex]);

            ++tgIndex;
            ++dzIndex;
        }
        System.out.println(tgDz.size());
        System.out.println(Common.objectMapper.writeValueAsString(tgDz));
    }
}
