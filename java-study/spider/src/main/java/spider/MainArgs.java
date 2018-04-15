package spider;

import java.util.Objects;
import lombok.Data;

/**
 * 网络爬虫主函数的参数
 * 
 * @author Jose
 *
 */

@Data
public class MainArgs {
    /** URL */
    private String url;
    /** 选择器 */
    private String cssQuery;
    /** 比较字符串正则 */
    private String regex;
    /** 电子邮件地址 */
    private String emailAttr;
    /** 程序睡眠 毫秒 */
    private int sleepMs;

    /**
     * 参数完整性check
     * 
     * @return isOk
     */
    public boolean isComplete() {

        return Objects.nonNull(url) && Objects.nonNull(cssQuery) && Objects.nonNull(regex);

    }

}
