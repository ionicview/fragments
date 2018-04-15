package spider;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spider {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(Spider.class);

    private static String matchedCtx = "";

    /** 默认睡眠时间 30_000ms */
    private static final int defaultSleepMs = 30_000;

    public static void main(String[] args) {

        // check
        if (!checkArgs(args)) {
            LOGGER.warn("main args is null.");
            return;
        }

        // convert
        MainArgs mArgs = getMainArgs(args);
        LOGGER.info(mArgs.toString());

        // doSpider
        if (mArgs.isComplete()) {
            doSpider(mArgs);
        } else {
            LOGGER.error("main args is not complete");
        }

    }

    /**
     * 爬虫
     * 
     * @param mArgs
     */
    private static void doSpider(MainArgs mArgs) {

        // selects
        Elements selects = getElements(mArgs);
        // regex
        boolean anyMatch = anyMatch(mArgs.getRegex(), selects);

        if (anyMatch) {
            // send email
            EmailUtil.send(mArgs.getEmailAttr(), "spider", createMsg(mArgs));
        } else {
            // sleep
            int sleepMs = mArgs.getSleepMs() < 1000 ? defaultSleepMs : mArgs.getSleepMs();
            try {
                LOGGER.info("No find any info, after " + sleepMs / 1000 + "s try again...");
                Thread.sleep(sleepMs);
                // try again
                doSpider(mArgs);
            } catch (InterruptedException e) {
                LOGGER.error("sleep Interrupted.");
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean anyMatch(String regex, Elements selects) {

        Pattern compile = Pattern.compile(regex);

        // match
        return selects.stream().anyMatch((element) -> {

            // val
            String val = element.val();
            // text
            String text = element.text();

            Matcher matcherVal = compile.matcher(val);
            Matcher matcherText = compile.matcher(text);

            if (matcherVal.find()) {
                matchedCtx = matcherVal.group();
                return true;
            } else if (matcherText.find()) {
                matchedCtx = matcherText.group();
                return true;
            } else {
                return false;
            }

        });


    }

    private static String createMsg(MainArgs mArgs) {

        StringBuilder sb = new StringBuilder();
        sb.append("★★★★★★★★★★★★★★★").append("\nFind [" + matchedCtx + "]!\n")
                .append("☆ use paramter ☆").append("\n☆URL☆:" + mArgs.getUrl())
                .append("\n☆CSSQUERY☆:" + mArgs.getCssQuery())
                .append("\n☆REGEX☆:" + mArgs.getRegex());
        return sb.toString();
    }

    /**
     * 通过css选择器选择指定元素
     * 
     * @param mArgs
     * 
     * @return 元素
     */
    private static Elements getElements(MainArgs mArgs) {
        // document
        Document doc = null;
        try {
            doc = Jsoup.connect(mArgs.getUrl()).get();
            // System.out.println(doc.text());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements selects = doc.select(mArgs.getCssQuery());

        // no query result
        if (Objects.isNull(selects) || selects.size() == 0) {
            throw new RuntimeException(
                    "Cant find any elements by selector ：" + mArgs.getCssQuery());
        }

        return selects;
    }

    private static boolean checkArgs(String[] args) {
        return args != null;
    }

    private static MainArgs getMainArgs(String[] args) {

        int length = args.length;

        MainArgs mainArgs = new MainArgs();

        if (length > 0) {
            String url = args[0];
            mainArgs.setUrl(url);
        }
        if (length > 1) {
            String cssQuery = args[1];
            mainArgs.setCssQuery(cssQuery);
        }
        if (length > 2) {
            String regex = args[2];
            mainArgs.setRegex(regex);
        }
        if (length > 3) {
            String emailAttr = args[3];
            mainArgs.setEmailAttr(emailAttr);
        }
        if (length > 4) {
            String sleepMs = args[4];
            mainArgs.setSleepMs(Integer.parseInt(sleepMs));
        }

        return mainArgs;
    }

}
